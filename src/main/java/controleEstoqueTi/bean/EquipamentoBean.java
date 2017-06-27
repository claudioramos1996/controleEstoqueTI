package controleEstoqueTi.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import controleEstoqueTi.model.Equipamento;
import controleEstoqueTi.service.EquipamentoDao;
import controleEstoqueTi.service.TipoEquipamentoDao;
import controleEstoqueTi.viewHelper.EquipamentoView;

@Named
@ViewScoped
public class EquipamentoBean implements Serializable {
	
	@Inject
	private EquipamentoDao  equipDao;
	
	@Inject
	private TipoEquipamentoDao tpEquipDao;

	private EquipamentoView view;

	private static final long serialVersionUID = -7739938370124365211L;

	@PostConstruct
	public void init() {

		view = new EquipamentoView();
	
		carregarDados();

		view.init();
	}

	/*
	 * CARREGAMENTO DOS DADOS
	 */
	private void carregarDados() {

		carregarTabela();
		carregarTiposEquipamento();

	}

	private void carregarTiposEquipamento() {

		getView().setListaTipoEquip(this.tpEquipDao.listaTipoEquipamento());
	}

	private void carregarTabela() {
		getView().setListaEquip(this.equipDao.getEquipamentoAll());
		
	}
	
	/*
	 * OPERAÇÕES BASICAS
	 */
	public void cadastrarEquipamento() {

		if(!isValidoEquip(getView().getEquipNew()))
			return; 
		
		this.equipDao.setEquipamento(getView().getEquipNew());

		carregarTabela();

		fecharAlterarIncluir();

	}

	public void alterarEquipamento() {
		
		if(!isValidoEquip(getView().getEquipNew()))
			return;
		
		this.equipDao.alterarEquipamento(getView().getSelecEquip());

		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alterado com Sucesso", null);

		FacesContext.getCurrentInstance().addMessage(null, msg);

		this.carregarTabela();

		getView().setMostrarAlterar(false);

	}

	public void excluir() {

		this.equipDao.excluirEquipamento(getView().getSelecEquip().getId());

		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletado com Sucesso", null);

		FacesContext.getCurrentInstance().addMessage(null, msg);

		this.carregarTabela();

		getView().setHabilitarDeleteAlterar(false);
		
		this.fecharAlterarIncluir();

	}

	/*
	 * OPERAÇÃO DE FILTRO
	 */
	
	public List<Equipamento> retornaFiltro(Object value, Object filter){
		
		String texto = value.toString();
		
		return null;
		
	}
	
	public boolean isValidoEquip(Equipamento equip) {
		FacesMessage msg = null;

		if (equip.getNome().trim().isEmpty())
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "É necessário digitar o nome", null);

		else if (equip.getTipoEquipamento() == null)
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "É necessário selecionar o tipo de Equipamento", null);

		else if (equip.getValor() == null)
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "É necessário informar o valor", null);

		if (msg != null) {
			
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return false;
			
		}else{
			
			return true;
		}

	}

	public void onRowSelect() {

		fecharAlterarIncluir();

		getView().setHabilitarDeleteAlterar(true);

	}

	public void abrirCadastrar() {
		getView().setHabilitarDeleteAlterar(false);
		fecharAlterarIncluir();
		getView().setEquipNew(new Equipamento());
		getView().setMostrarCadastro(true);

	}

	public void abrirAlterar() {

		fecharAlterarIncluir();

		getView().setEquipNew(getView().getSelecEquip());
		
		getView().setMostrarAlterar(true);

	}

	public void fecharAlterarIncluir() {

		getView().setMostrarAlterar(false);
		getView().setMostrarCadastro(false);
	}

	/*
	 * Getters e Setters
	 */
	
	public EquipamentoView getView() {
		return view;
	}

	public void setView(EquipamentoView view) {
		this.view = view;
	}

}
