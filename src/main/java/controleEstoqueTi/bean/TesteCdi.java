package controleEstoqueTi.bean;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import controleEstoqueTi.service.TipoEquipamentoDao;

@Named(value="editor")
public class TesteCdi implements Serializable{

	@Inject
	public TipoEquipamentoDao tipoEquipamento;
	
	private String value = "This editor is provided by PrimeFaces";

	public String getValue() {
		System.out.println(tipoEquipamento.listaTipoEquipamento().get(0).getNome());
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
