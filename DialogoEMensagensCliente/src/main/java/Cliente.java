import java.io.Serializable;

public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nome;
	private String telefone;

	public Cliente() {
	}

	public Cliente(String nome, String telefone) {
		super();
		this.nome = nome;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
