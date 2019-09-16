
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class PerfilUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<String> paises = new ArrayList<>();

	private String nome;
	private String pais;

	public PerfilUsuarioBean() {
		paises.add("Alemanha");
		paises.add("Argelia");
		paises.add("Argentina");
		paises.add("Belgica");
		paises.add("Bolivia");
		paises.add("Brasil");
		paises.add("Bulgaria");
		paises.add("Espanha");
		paises.add("Estados Unidos");
	}

	public List<String> sugerirPaises(String consulta) {
		List<String> paisesSugeridos = new ArrayList<String>();

		for (String pais : this.paises) {
			if (pais.toLowerCase().startsWith(consulta.toLowerCase())) {
				paisesSugeridos.add(pais);
			}
		}

		return paisesSugeridos;
	}

	public void atualizar() {
		System.out.println("Pais: " + pais);

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Perfil atualizado!"));
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

}