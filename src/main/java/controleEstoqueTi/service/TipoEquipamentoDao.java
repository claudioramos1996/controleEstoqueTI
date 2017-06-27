package controleEstoqueTi.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import controleEstoqueTi.model.TipoEquipamento;
@RequestScoped
public class TipoEquipamentoDao {

	@Inject
	private EntityManager em;

	public boolean incluirTipoEquip(String nomeTipo) {

		em.getTransaction().begin();

		TipoEquipamento tipoE = new TipoEquipamento();

		tipoE.setNome(nomeTipo);

		em.persist(tipoE);

		em.getTransaction().commit();

		return true;
	}

	public List<TipoEquipamento> listaTipoEquipamento() {
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

	public boolean deletarTipoEquipamento(int id) {
		TipoEquipamento tp = em.getReference(TipoEquipamento.class, id);

		em.getTransaction().begin();

		em.remove(tp);

		em.getTransaction().commit();

		return true;
	}

	public TipoEquipamento buscarTipoEquipamento(String nome) {

		String jpql = "select tpEquip from TipoEquipamento tpEquip where tpEquip.nome = :nome";

		Query query = em.createQuery(jpql, TipoEquipamento.class);

		query.setParameter("nome", nome);

		try {
			return (TipoEquipamento) query.getSingleResult();
		} catch (NoResultException noResult) {
			return null;
		}
	}
}
