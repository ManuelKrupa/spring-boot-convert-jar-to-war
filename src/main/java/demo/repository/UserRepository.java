package demo.repository;

import demo.domain.User;
import demo.jpa.support.DemoRepository;

public interface UserRepository extends DemoRepository<User, Long>, UserRepositoryCustom {
	
}
