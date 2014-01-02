package demo.jpa.support;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DemoRepository<T, ID extends Serializable>
	extends JpaRepository<T, ID> {
	
	List<T> findAllQuery(String pQuery);
	
	T findOneQuery(String pQuery);
}
