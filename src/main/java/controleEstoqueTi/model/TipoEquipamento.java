package controleEstoqueTi.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TipoEquipamento {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String nome;

	@OneToMany
	private List<Equipamento> listaEquipamento;
	
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
