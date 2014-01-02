package demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.domain.User;
import demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	/**
	 * Count the number of users
	 * @return long
	 */
	public long countUsers() {
		return userRepo.count();
	}
	
	/**
	 * Return all users
	 * @return List<User>
	 */
	public List<User> findAllUsers() {
		return userRepo.findAll();
	}
	
	/**
	 * Return the user which ID is requested
	 * @param pId Long :
	 * 		the user ID
	 * @return User : the user requested
	 */
	public User findUser(final Long pId) {
		return userRepo.findOne(pId);
	}
	
	/**
	 * Save the user in parameter into database.
	 * @param vUser User : the user to save
	 */
	public void saveUser(final User vUser) {
		userRepo.save(vUser);
	}
	
	/**
	 * Return all users with same login/password.
	 * @return List<User> : the users
	 */
	public List<User> findAllUsersWithSamePassword() {
		return userRepo.findAllQuery(userRepo.findComplexRequest());
	}
}
