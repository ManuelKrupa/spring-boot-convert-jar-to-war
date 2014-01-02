package demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.domain.Role;
import demo.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepo;
	
	/**
	 * Save role in database
	 * @param pRole Role : the new role
	 */
	public void addRole(Role pRole) {
		roleRepo.save(pRole);
	}
}
