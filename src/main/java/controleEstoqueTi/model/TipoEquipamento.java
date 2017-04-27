package controleEstoqueTi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TipoEquipamento {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String nome;

	@OneToMany(mappedBy="tipoEquipamento",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<Equipamento> listaEquipamento;
		
	public long qtdeEquipamentosUtilizando(){
		// Primeiro Acesso para sair do lazy
		//this.getListaEquipamento();
		
		return this.getListaEquipamento().size();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Equipamento> getListaEquipamento() {
		return listaEquipamento;
	}

	public void setListaEquipamento(List<Equipamento> listaEquipamento) {
		this.listaEquipamento = listaEquipamento;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return this.getId();
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (obj instanceof TipoEquipamento) {
			
			TipoEquipamento tpEquip = (TipoEquipamento) obj;
			
			return tpEquip.getId() == this.getId();
		}
		
		return false;
	}
	
}
