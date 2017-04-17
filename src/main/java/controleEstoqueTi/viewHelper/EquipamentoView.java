package controleEstoqueTi.viewHelper;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import controleEstoqueTi.model.Equipamento;
import controleEstoqueTi.model.TipoEquipamento;

public class EquipamentoView {

	private List<Equipamento> listaEquip;

	private Equipamento selecEquip;

	private boolean HabilitarDeleteAlterar;

	private boolean mostrarCadastro;

	private boolean mostrarAlterar;

	private Equipamento equipNew = new Equipamento();

	private List<SelectItem> tipoEquipItens = new ArrayList<SelectItem>();

	private List<TipoEquipamento> listaTipoEquip;

	public void init() {

		for (TipoEquipamento equip : listaTipoEquip) {

			tipoEquipItens.add(new SelectItem(equip, equip.getNome()));

		}
		
		
	}

	/*
	 * Getters e Setters
	 */
	public List<SelectItem> getTipoEquipItens() {
		return tipoEquipItens;
	}

	public void setTipoEquipItens(List<SelectItem> tipoEquipItens) {
		this.tipoEquipItens = tipoEquipItens;
	}

	public List<Equipamento> getListaEquip() {
		return listaEquip;
	}

	public void setListaEquip(List<Equipamento> listaEquip) {
		this.listaEquip = listaEquip;
	}

	public Equipamento getSelecEquip() {
		return selecEquip;
	}

	public void setSelecEquip(Equipamento selecEquip) {
		this.selecEquip = selecEquip;
	}

	public boolean isMostrarCadastro() {
		return mostrarCadastro;
	}

	public void setMostrarCadastro(boolean mostrarCadastro) {
		this.mostrarCadastro = mostrarCadastro;
	}

	public Equipamento getEquipNew() {
		return equipNew;
	}

	public List<TipoEquipamento> getListaTipoEquip() {
		return listaTipoEquip;
	}

	public void setListaTipoEquip(List<TipoEquipamento> listaTipoEquip) {
		this.listaTipoEquip = listaTipoEquip;
	}

	public void setEquipNew(Equipamento equipNew) {
		this.equipNew = equipNew;
	}

	public boolean isMostrarAlterar() {
		return mostrarAlterar;
	}

	public void setMostrarAlterar(boolean mostrarAlterar) {
		this.mostrarAlterar = mostrarAlterar;
	}

	public boolean isHabilitarDeleteAlterar() {
		return HabilitarDeleteAlterar;
	}

	public void setHabilitarDeleteAlterar(boolean habilitarDeleteAlterar) {
		HabilitarDeleteAlterar = habilitarDeleteAlterar;
	}

	
}
