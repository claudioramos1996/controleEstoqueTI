package controleEstoqueTi.service;

import java.util.List;

import javax.persistence.EntityManager;

import controleEstoqueTi.model.Equipamento;
import controleEstoqueTi.util.JpaUtil;

public class EquipamentoDao {
	
	private EntityManager em = JpaUtil.getEntityManager();

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
