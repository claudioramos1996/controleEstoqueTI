package controleEstoqueTi.service;


import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class ProdutorEntityManager {
	
	private EntityManagerFactory entityFactory;
	private EntityManager entityManager;
	
	@Produces
	public EntityManager criaEntityManager(){
	
		if(entityManager != null)
			return entityManager;
		
		entityFactory = Persistence.createEntityManagerFactory("controleEstoqueTi");
		
		entityManager = entityFactory.createEntityManager();
		
		return entityManager;
		
	}
}
