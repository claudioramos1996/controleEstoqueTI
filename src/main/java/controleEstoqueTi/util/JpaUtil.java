package controleEstoqueTi.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class JpaUtil {

	private static EntityManager entityManager;
	
	@Deprecated
	public static EntityManager getEntityManager() {
		
		if(entityManager == null){
		
			EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("controleEstoqueTi");
			entityManager = entityFactory.createEntityManager();
			
		}
		return entityManager;
	}

}
