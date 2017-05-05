package controleEstoqueTi.service;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import controleEstoqueTi.exceptions.NaoEncontrado;
import controleEstoqueTi.model.Equipamento;
import controleEstoqueTi.model.TipoEquipamento;

public class EquipamentoDaoTest {

	private int idTeste;

	private EquipamentoDao dao = new EquipamentoDao();
	
	//@Test
	public void getEquipamento(){
		
		String nomeEquip = "Teste de Busca de Nome";
		Equipamento equipTestes = new Equipamento();
		
		equipTestes.setNome(nomeEquip);
		
		
		dao.setEquipamento(equipTestes);
		
		Equipamento equipRetorno = null;
		
		try {
			
			equipRetorno = dao.getEquipamento("Teste");
			
			Assert.assertNotNull(dao.getEquipamento("Teste"));
			
		} catch (NaoEncontrado e) {
			e.printStackTrace();
		}
		
		dao.excluirEquipamento(equipRetorno.getId());
		
	}
	
	@Test
	public void testGetEquipamentoAll() {
		
		Assert.assertNotNull(dao.getEquipamentoAll());

	}

	@Test
	public void testSetEquipamento() {

		
		TipoEquipamentoDao daoTipo = new TipoEquipamentoDao();

		TipoEquipamento tpEquip = daoTipo.buscarTipoEquipamento(1);

		Equipamento equip = new Equipamento();

		equip.setNome("Teste ");
		equip.setValor(new BigDecimal("2.2"));
		equip.setTipoEquipamento(tpEquip);

		dao.setEquipamento(equip);
	}

	@Test
	public void testGetEquipamentoID() {

		Assert.assertNotNull(dao.getEquipamentoID(consultarUltimoAdd()));

	}

	@Test
	public void testAlterarEquipamento() {

		Equipamento equip = dao.getEquipamentoID(consultarUltimoAdd());

		equip.setNome("Teste de Alteracao");

		dao.alterarEquipamento(equip);

	}

	@Test
	public void testExcluirEquipamento() {

		dao.excluirEquipamento(consultarUltimoAdd());
	}

	private int consultarUltimoAdd(){
		
		if(this.idTeste != 0)
			return this.idTeste;
		
		List<Equipamento>  lista =  dao.getEquipamentoAll();
		
		int id = lista.get(lista.size()-1).getId();
		this.idTeste = id;
		
		return id;
	}
}
