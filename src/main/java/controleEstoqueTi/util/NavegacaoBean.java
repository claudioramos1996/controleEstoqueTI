package controleEstoqueTi.util;

import java.io.Serializable;

import javax.faces.bean.SessionScoped;

@SessionScoped
public class NavegacaoBean  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7523464918984226240L;

	private final String outcome_Equipamentos = "Crud_Equipamento";
	
	private final String outcome_TiposEquipamentos = "Crud_Tipo_Equipamento";

	public String iniciarEquipamentos(){
		return outcome_Equipamentos;
	}
	
	public String iniciarTiposEquipamentos(){
		return outcome_TiposEquipamentos;
	}

	public String getOutcome_Equipamentos() {
		return outcome_Equipamentos;
	}

	public String getOutcome_TiposEquipamentos() {
		return outcome_TiposEquipamentos;
	}

	
	
}
