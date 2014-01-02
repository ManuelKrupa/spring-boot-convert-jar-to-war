package demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.domain.Role;
import demo.domain.User;
import demo.service.RoleService;
import demo.service.UserService;

@RestController
public class HelloController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	/**
	 * Return hello world when requesting server root
	 * @return String
	 */
	@RequestMapping("/")
	public String root() {
		return "hello world";
	}
	
	/**
	 * Return the number of users when requesting /number
	 * @return String
	 */
	@RequestMapping("/number")
	public String number() {
		long nb = userService.countUsers();
		
		final StringBuffer vSb = new StringBuffer("Number of users : ");
		vSb.append(nb);
		
		return  vSb.toString();
	}
	
	/**
	 * Return the list of users when requesting /greeting
	 * @return String
	 */
	@RequestMapping("/greeting")
	public String greeting() {
		final List<User> vUsers = userService.findAllUsers();
		
		final StringBuffer vSb = new StringBuffer("List of users : <br/>");
		
		for (User vUser : vUsers) {
			vSb.append(vUser.getLastName()).append(" ").append(vUser.getFirstName()).append("<br/>");
		}
		
		return  vSb.toString();
	}
	
	
	/**
	 * Return the rights access of users when requesting /access_rights
	 * @return String
	 */
	@RequestMapping("/access_rights")
	public String accessRights() {
		final List<User> vUsers = userService.findAllUsers();
		
		return  describeUsers(vUsers);
	}
	
	/**
	 * Method that return a string to describe all users.
	 * @param pUsers List<User> : the users to describe
	 * @return String : the resulting description
	 */
	private String describeUsers(final List<User> pUsers) {
		final StringBuffer vSb = new StringBuffer("List of users : <br/>");
		
		for (User vUser : pUsers) {
			vSb.append(vUser.getLastName()).append(" ").append(vUser.getFirstName()).append(" -> ");
			for (Role vRole : vUser.getRoles()) {
				vSb.append(vRole.getLabel()).append(" ");
			}
			vSb.append("<br/>");
		}
		
		return vSb.toString();
	}
	
	/**
	 * Add a new role and add it to the admin user (super user)
	 * @return String : the result
	 */
	@RequestMapping("/add_role")
	public String addRole() {
		String vRetour = "KO";
		
		final Role vRole = new Role();
		vRole.setLabel("TEST");
		
		roleService.addRole(vRole);
		
		// for each new role, we add it to the admin user
		final User vAdmin = userService.findUser(2L);
		final List<Role> vRoles = vAdmin.getRoles();
		vRoles.add(vRole);
		vAdmin.setRoles(vRoles);
		
		userService.saveUser(vAdmin);
				
		vRetour = "OK";
		
		return vRetour;
	}
	
	/**
	 * Add a new role and add it to the admin user (super user)
	 * but failed
	 * 
	 * @return String : the result
	 */
	@RequestMapping("/add_role_exception")
	@Transactional(rollbackFor = Exception.class)
	public String addRoleException() throws Exception {

		String vRetour = "KO";

		final Role vRole = new Role();
		vRole.setLabel("TEST");

		roleService.addRole(vRole);

		// for each new role, we add it to the admin user
		final User vAdmin = userService.findUser(2L);
		final List<Role> vRoles = vAdmin.getRoles();
		vRoles.add(vRole);
		vAdmin.setRoles(vRoles);

		userService.saveUser(vAdmin);

		vRetour = "OK";

		if (1 == 1) {
			throw new Exception("Test rollback");
		}

		return vRetour;
	}
	
	/**
	 * Return all users who have same login/password when requested /same_password
	 * @return String
	 */
	@RequestMapping("/same_password")
	public String complexQuery() {
		final List<User> vUsers = userService.findAllUsersWithSamePassword();
				return  describeUsers(vUsers);
	}
}
