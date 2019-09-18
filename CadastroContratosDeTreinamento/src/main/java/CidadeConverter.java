import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("cidade")
public class CidadeConverter implements Converter {
	Integer codigo = null;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		try {
			codigo = Integer.valueOf(value);
		} catch (NumberFormatException e) {
		}

		if (value != null) {
			for (Cidade cidade : CadastroContratoBean.CIDADES) {
				if (codigo.equals(cidade.getCodigo())) {
					return cidade;
				}
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null && !value.equals("")) {
			Cidade cidade = (Cidade) value;
			return String.valueOf(cidade.getCodigo());
		}
		return null;
	}

}
