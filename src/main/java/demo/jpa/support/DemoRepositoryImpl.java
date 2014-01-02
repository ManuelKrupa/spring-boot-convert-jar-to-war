package demo.jpa.support;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class DemoRepositoryImpl<T, ID extends Serializable>
	extends SimpleJpaRepository<T, ID> implements DemoRepository<T, ID> {

	private EntityManager entityManager;
	private Class<T> domainClass;
	
	public DemoRepositoryImpl(Class<T> pDomainClass, EntityManager pEm) {
		super(pDomainClass, pEm);
		entityManager = pEm;
		domainClass = pDomainClass;
	}

	@Override
	public List<T> findAllQuery(String pQuery) {
		final TypedQuery<T> vQuery = entityManager.createQuery(pQuery, domainClass);
		return vQuery.getResultList();
	}

	@Override
	public T findOneQuery(String pQuery) {
		final TypedQuery<T> vQuery = entityManager.createQuery(pQuery, domainClass);
		return vQuery.getSingleResult();
	}
}
