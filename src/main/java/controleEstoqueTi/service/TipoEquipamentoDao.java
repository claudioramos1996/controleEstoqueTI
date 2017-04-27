package controleEstoqueTi.service;

import java.util.List;

import javax.persistence.EntityManager;

import controleEstoqueTi.model.TipoEquipamento;
import controleEstoqueTi.util.JpaUtil;

public class TipoEquipamentoDao {

	private static EntityManager em = JpaUtil.getEntityManager();

	public TipoEquipamentoDao(){
		if(!em.isOpen())
			em.getTransaction().begin();
	}
	
	public boolean incluirTipoEquip(String nomeTipo) {

		em.getTransaction().begin();
		TipoEquipamento tipoE = new TipoEquipamento();

		tipoE.setNome(nomeTipo);

		em.persist(tipoE);

		em.getTransaction().commit();
		// em.close();

		return true;
	}

	public List<TipoEquipamento> listaTipoEquipamento() {
		if(!em.isOpen())
			em.getTransaction().begin();
		
		em.clear();
		return em.createQuery("select a from TipoEquipamento a", TipoEquipamento.class).getResultList();
	}

	public boolean alterarTipoEquipamento(TipoEquipamento tipoEquip) {

		em.getTransaction().begin();

		TipoEquipamento tpAlterar = em.getReference(TipoEquipamento.class, tipoEquip.getId());
		
		tpAlterar.setNome(tipoEquip.getNome());
		
		em.merge(tpAlterar);

		em.getTransaction().commit();

		return true;
	}

	public TipoEquipamento buscarTipoEquipamento(int id) {
		return em.find(TipoEquipamento.class, id);
	}

	public boolean deletarTipoEquipamento(int id)  {
		TipoEquipamento tp = em.getReference(TipoEquipamento.class, id);
		
		
		
		if(!em.getTransaction().isActive())
			em.getTransaction().begin();
		
		em.remove(tp);
		
		em.getTransaction().commit();
		
		return true;
	}
 
}
