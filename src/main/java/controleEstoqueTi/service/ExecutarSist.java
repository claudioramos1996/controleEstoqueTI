package controleEstoqueTi.service;

import java.math.BigDecimal;
import java.util.List;

import controleEstoqueTi.model.Equipamento;
import controleEstoqueTi.model.TipoEquipamento;

public class ExecutarSist {

	public static void main(String[] args) {
				
//		Weld weld = new Weld();
//		WeldContainer container = weld.initialize();
//		EquipamentoDao dao = container.instance().select(EquipamentoDao.class).get();
//		//testeInclusao();
//		
//		weld.shutdown();

	}

	public static void testeInclusao() {

		EquipamentoDao daoEquip = new EquipamentoDao();
		TipoEquipamentoDao daoTipo = new TipoEquipamentoDao();

		TipoEquipamento tpEquip = daoTipo.buscarTipoEquipamento(20);

		Equipamento equip = new Equipamento();

		equip.setNome("Teste");
		equip.setValor(new BigDecimal("2.2"));
		equip.setTipoEquipamento(tpEquip);

		daoEquip.setEquipamento(equip);
	}

	public static void testeConsulta() {

		EquipamentoDao daoEquip = new EquipamentoDao();

		Equipamento equip = daoEquip.getEquipamentoID(1);

		System.out.println(equip.getNome());

	}

	public static void testeListar() {

		EquipamentoDao daoEquip = new EquipamentoDao();

		List<Equipamento> lista = daoEquip.getEquipamentoAll();

		System.out.println(lista.size());
	}

	public static void alterar() {

		EquipamentoDao daoEquip = new EquipamentoDao();

		Equipamento equip = daoEquip.getEquipamentoID(1);

		equip.setNome("Teste de Alteracao");

		daoEquip.alterarEquipamento(equip);

	}

	public static void excluir() {

		EquipamentoDao daoEquip = new EquipamentoDao();

		daoEquip.excluirEquipamento(34);
	}
}
