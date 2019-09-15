import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class CadastroUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String login;
	private String nome;

	public void cadastrar() {
		System.out.println("Login:" + this.login);
		System.out.println("Nome:" + this.nome);

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cadastro efetuado!"));
	}

	public void verificarDisponibilidadeLogin() {
		FacesMessage msg = null;
		System.out.println("Verificando disponibilidade");

		if ("joao".equalsIgnoreCase(this.login)) {
			msg = new FacesMessage("Login ja esta em uso!");
			msg.setSeverity(FacesMessage.SEVERITY_WARN);
		} else {
			msg = new FacesMessage("Login disponivel!");

		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
