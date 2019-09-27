
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class CadastroContrato implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final List<Cidade> CIDADES = new ArrayList<>();

	private List<String> metodosPagamento = new ArrayList<>();
	private List<String> formasPagamento = new ArrayList<>();

	static {
		CIDADES.add(new Cidade(1, "Cabo Frio"));
		CIDADES.add(new Cidade(2, "Caceres"));
		CIDADES.add(new Cidade(3, "Cuiaba"));
		CIDADES.add(new Cidade(4, "Diamantino"));
		CIDADES.add(new Cidade(5, "Dom Aquino"));
		CIDADES.add(new Cidade(6, "Dumont"));
		CIDADES.add(new Cidade(7, "Duque de Caxias"));
		CIDADES.add(new Cidade(8, "Fortaleza"));
		CIDADES.add(new Cidade(9, "Foz do Iguacu"));
	}

	private String razaoSocial;
	private String cnpj;
	private Cidade cidadeContrato;
	private String modalidade;
	private Date dataContrato;
	private String valorContrato;
	private String metodoPagamento;
	private String formaPagamento;
	private List<String> cursosContratados;

	public CadastroContrato() {
		metodosPagamento.add("Cartao de credito");
		metodosPagamento.add("Cheque");
		metodosPagamento.add("Boleto");
	}

	public CadastroContrato(String razaoSocial, String cnpj, Cidade cidadeContrato, String modalidade,
			Date dataContrato, String valorContrato, String metodoPagamento, String formaPagamento,
			List<String> cursosContratados) {
		this();

		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.cidadeContrato = cidadeContrato;
		this.modalidade = modalidade;
		this.dataContrato = dataContrato;
		this.valorContrato = valorContrato;
		this.metodoPagamento = metodoPagamento;
		this.formaPagamento = formaPagamento;
		this.cursosContratados = cursosContratados;
	}

	public void carregarFormasPagamento() {
		formasPagamento.clear();

		if ("Cartao de credito".equals(metodoPagamento)) {
			formasPagamento.add("A vista");
			formasPagamento.add("1x");
			formasPagamento.add("2x");
			formasPagamento.add("6x");
		} else if ("Cheque".equals(metodoPagamento)) {
			formasPagamento.add("A vista");
			formasPagamento.add("Entrada + 30 dias");
		} else if ("Boleto".equals(metodoPagamento)) {
			formasPagamento.add("A vista");
		}
	}

	public List<Cidade> sugerirCidade(String consulta) {
		List<Cidade> cidadesSugeridas = new ArrayList<Cidade>();

		for (Cidade cidade : CIDADES) {
			if (cidade.getNome().toLowerCase().startsWith(consulta.toLowerCase())) {
				cidadesSugeridas.add(cidade);
			}
		}
		return cidadesSugeridas;
	}

	public void cadastrar() {
		System.out.println("Razao social: " + this.razaoSocial);
		System.out.println("CNPJ: " + this.cnpj);
		System.out.println("Modalidade: " + this.modalidade);
		System.out.println("Data do cocontrato: " + this.dataContrato);
		System.out.println("Valor do contrato: " + this.valorContrato);
		System.out.println("Cidade do contrato: " + this.cidadeContrato.getNome());
		System.out.println("Metodo de pagamento: " + this.metodoPagamento);
		System.out.println("Forma de pagamento: " + this.formaPagamento);
		System.out.print("Cursos contratados: ");
		for (String curso : cursosContratados) {
			System.out.print(curso + " ");
		}
		System.out.println("");

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cadastro realizado!"));
	}

	public Date getDataHoje() {
		return new Date();
	}

	public List<String> getMetodosPagamento() {
		return metodosPagamento;
	}

	public void setMetodosPagamento(List<String> metodosPagamento) {
		this.metodosPagamento = metodosPagamento;
	}

	public List<String> getFormasPagamento() {
		return formasPagamento;
	}

	public void setFormasPagamento(List<String> formasPagamento) {
		this.formasPagamento = formasPagamento;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Cidade getCidadeContrato() {
		return cidadeContrato;
	}

	public void setCidadeContrato(Cidade cidadeContrato) {
		this.cidadeContrato = cidadeContrato;
	}

	public String getModalidade() {
		return modalidade;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}

	public Date getDataContrato() {
		return dataContrato;
	}

	public void setDataContrato(Date dataContrato) {
		this.dataContrato = dataContrato;
	}

	public String getValorContrato() {
		return valorContrato;
	}

	public void setValorContrato(String valorContrato) {
		this.valorContrato = valorContrato;
	}

	public String getMetodoPagamento() {
		return metodoPagamento;
	}

	public void setMetodoPagamento(String metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public List<String> getCursosContratados() {
		return cursosContratados;
	}

	public void setCursosContratados(List<String> cursosContratados) {
		this.cursosContratados = cursosContratados;
	}

	public static List<Cidade> getCidades() {
		return CIDADES;
	}

}