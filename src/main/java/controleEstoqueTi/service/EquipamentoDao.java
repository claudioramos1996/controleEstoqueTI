package controleEstoqueTi.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import controleEstoqueTi.model.Equipamento;

public class EquipamentoDao {
	
	private EntityManagerFactory factManager = Persistence.createEntityManagerFactory("controleEstoqueTi");
	private EntityManager em = factManager.createEntityManager();

	
	
	public EquipamentoDao(){
		
		if(!em.isOpen())
			em.getTransaction().begin();
	}

	public List<Equipamento> getEquipamentoAll(){
		
		return em.createQuery("select a from Equipamento a",Equipamento.class).getResultList();
	}
	
	public Equipamento getEquipamentoID(int id){
		
		return em.find(Equipamento.class, id);
	}
	
	public void setEquipamento(Equipamento equip){
		
		em.getTransaction().begin();
		em.persist(equip);
		em.getTransaction().commit();
	}
	
	public void alterarEquipamento(Equipamento equip){
		
		Equipamento equipOriginal = em.getReference(Equipamento.class, equip.getId());
		
		equipOriginal.setNome(equip.getNome());
		equipOriginal.setTipoEquipamento(equip.getTipoEquipamento());
		equipOriginal.setValor(equip.getValor());
		
		em.getTransaction().begin();
		em.merge(equipOriginal);
		em.getTransaction().commit();
		
	}
	
	public void excluirEquipamento(int id){
		
		Equipamento equip = em.getReference(Equipamento.class, id);
		
		em.getTransaction().begin();
		em.remove(equip);
		em.getTransaction().commit();
		
	}


	
	
}
