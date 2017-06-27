package controleEstoqueTi.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import controleEstoqueTi.exceptions.NaoEncontrado;
import controleEstoqueTi.model.Equipamento;
@RequestScoped
public class EquipamentoDao {

	@Inject
	private EntityManager em;

	public EquipamentoDao() {
		
	}

	public List<Equipamento> getEquipamentoAll() {
		return em.createQuery("select a from Equipamento a", Equipamento.class).getResultList();
	}

	public Equipamento getEquipamento(String equipNome) throws NaoEncontrado {

		String jpql = "select equip from Equipamento equip where equip.nome like :nomeEquip";

		Query query = em.createQuery(jpql, Equipamento.class);

		query.setParameter("nomeEquip", equipNome);

		query.getResultList();

		return (Equipamento) query.getSingleResult();
	}

	public Equipamento getEquipamentoID(int id) {
		return em.find(Equipamento.class, id);
	}

	public void setEquipamento(Equipamento equip) {

		em.getTransaction().begin();
		em.persist(equip);
		em.getTransaction().commit();
	}

	public void alterarEquipamento(Equipamento equip) {

		Equipamento equipOriginal = em.getReference(Equipamento.class, equip.getId());

		equipOriginal.setNome(equip.getNome());
		equipOriginal.setTipoEquipamento(equip.getTipoEquipamento());
		equipOriginal.setValor(equip.getValor());

		em.getTransaction().begin();
		em.merge(equipOriginal);
		em.getTransaction().commit();

	}

	public void excluirEquipamento(int id) {

		Equipamento equip = em.getReference(Equipamento.class, id);

		em.getTransaction().begin();

		equip.setTipoEquipamento(null);
		
		em.remove(equip);

		em.getTransaction().commit();

	}

}
