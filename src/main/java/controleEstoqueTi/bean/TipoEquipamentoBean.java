package controleEstoqueTi.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.SelectEvent;

import controleEstoqueTi.model.TipoEquipamento;
import controleEstoqueTi.service.TipoEquipamentoDao;

@ManagedBean
@ViewScoped
public class TipoEquipamentoBean implements Serializable {

	private TipoEquipamentoDao dao = new TipoEquipamentoDao();

	private TipoEquipamento selecionado;

	private List<TipoEquipamento> listaCadastrados;

	private boolean botaoDeleteAlterar;

	private boolean mostrarAlterar;

	private boolean mostrarCadastro;

	private String nomeNovo = "";

	private static final long serialVersionUID = -2194595766119410436L;

	@PostConstruct
	public void init() {
		carregarTabela();
	}

	private void carregarTabela() {
		setListaCadastrados(dao.listaTipoEquipamento());
	}

	public void cadastrarTipoEquipamento(ActionEvent actionEvent) {

		if (nomeNovo.isEmpty()) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "É necessário digitar o nome", null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return;
		}

		dao.incluirTipoEquip(nomeNovo);

		mostrarCadastro = false;

		carregarTabela();

		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastrado com Sucesso!", null);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void excluir() {

		if (dao.deletarTipoEquipamento(selecionado.getId())) {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Removido com sucesso", null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			botaoDeleteAlterar = false;

			carregarTabela();

		} else {

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro na exclusão", null);
			FacesContext.getCurrentInstance().addMessage(null, msg);

		}

	}

	public void alterarTipoEquipamento(){
		
		TipoEquipamento tpEquip = new TipoEquipamento();
		
		tpEquip.setId(selecionado.getId());
		tpEquip.setNome(nomeNovo);
		
		dao.alterarTipoEquipamento(tpEquip);
		
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alterado com Sucesso!", null);
		
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
		mostrarAlterar = false;
		
		carregarTabela();
		
	}
	public void abrirCadastrar() {

		nomeNovo = "";
		
		mostrarAlterar = false;
		mostrarCadastro = true;

	}

	public void abrirAlterar(){
		
		nomeNovo = selecionado.getNome();
		
		mostrarCadastro = false;
		mostrarAlterar = true;
	}
	
	public void fecharCadastroAlterar(){
		
		mostrarAlterar = false;
		mostrarCadastro = false;
		
	}
	public void onRowSelect(SelectEvent event) {
		fecharCadastroAlterar();
		botaoDeleteAlterar = true;
	}

	public String getNomeNovo() {
		return nomeNovo;
	}

	public void setNomeNovo(String nomeNovo) {
		this.nomeNovo = nomeNovo;
	}

	public TipoEquipamentoDao getService() {
		return dao;
	}

	public void setService(TipoEquipamentoDao service) {
		this.dao = service;
	}

	public List<TipoEquipamento> getListaCadastrados() {
		return listaCadastrados;
	}

	public void setListaCadastrados(List<TipoEquipamento> listaCadastrados) {
		this.listaCadastrados = listaCadastrados;
	}

	public TipoEquipamento getSelecionado() {
		return selecionado;
	}

	public void setSelecionado(TipoEquipamento selecionado) {
		this.selecionado = selecionado;
	}

	public boolean isMostrarCadastro() {
		return mostrarCadastro;
	}

	public void setMostrarCadastro(boolean mostrarCadastro) {
		this.mostrarCadastro = mostrarCadastro;
	}

	public boolean isBotaoDeleteAlterar() {
		return botaoDeleteAlterar;
	}

	public void setBotaoDeleteAlterar(boolean botaoDeleteAlterar) {
		this.botaoDeleteAlterar = botaoDeleteAlterar;
	}

	public boolean isMostrarAlterar() {
		return mostrarAlterar;
	}

	public void setMostrarAlterar(boolean mostrarAlterar) {
		this.mostrarAlterar = mostrarAlterar;
	}

}
