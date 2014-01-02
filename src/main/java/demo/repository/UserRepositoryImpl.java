package demo.repository;

public class UserRepositoryImpl
	implements UserRepositoryCustom {

	@Override
	public String findComplexRequest() {
		return "select u from demo.domain.User u where u.login = u.password";
	}
}
