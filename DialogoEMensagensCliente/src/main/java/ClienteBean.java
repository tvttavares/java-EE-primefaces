import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class ClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Cliente> clientes = new ArrayList<>();
	private Cliente novoCliente = new Cliente();
	private Cliente clienteSelecionado = new Cliente();

	public ClienteBean() {
		clientes.add(new Cliente("Joao da Silva", "(65) 9834-3322"));
		clientes.add(new Cliente("Mara Abadia Pereira", "(67) 3359-1134"));
		clientes.add(new Cliente("Sebastiao Moreira Junior", "(64) 9998-4343"));
	}

	public void incluirCliente() {
		clientes.add(this.novoCliente);
		novoCliente = new Cliente();
	}

	public void excluirCliente() {
		clientes.remove(clienteSelecionado);
		adicionarMensagemExclusao();
	}

	public void adicionarMensagemExclusao() {
		FacesContext context = FacesContext.getCurrentInstance();

		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Cliente excluido com sucesso!", "Exclusao");
		context.addMessage("destinoExclusao", msg);
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente getNovoCliente() {
		return novoCliente;
	}

	public void setNovoCliente(Cliente novoCliente) {
		this.novoCliente = novoCliente;
	}

	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}

	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}

}
