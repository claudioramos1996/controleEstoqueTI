package controleEstoqueTi.converter;

import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import controleEstoqueTi.model.TipoEquipamento;
import controleEstoqueTi.service.TipoEquipamentoDao;

@FacesConverter(forClass=TipoEquipamento.class,value="")
public class TipoEquipamentoConverter implements Converter {
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		int id = Integer.valueOf(value);
		
		TipoEquipamentoDao dao = CDI.current().select(TipoEquipamentoDao.class).get();
		
		return dao.buscarTipoEquipamento(id);
		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		TipoEquipamento equip = (TipoEquipamento) value;
		
		if(equip == null)
			return null;
		
		return String.valueOf(equip.getId());
		
	}

}
