import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class CadastroContratoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	CadastroContrato c = new CadastroContrato();

	private static final String[] nomes = { "João", "Maria", "José", "Eduardo", "Sebastião", "Mariana", "Francisco",
			"Manoel", "Fernanda", "Gabriela", "Mário", "Marcos" };

	private static final String[] sobrenomes = { "Souza", "Silva", "Andrade", "Machado", "Júnior", "Albuquerque",
			"Alencar", "Assis", "Batista", "Camargo", "Coelho", "Costa", "Dias", "Rosa", "Leal", "Lima", "Leite" };

	private static final String[] cursos = { "Fundamentos Java e Orientacao a Objetos", "Desenvolvimento Web com JSF ",
			"Persistecia de dados com JPA 2 e Hibernate", "Gerenciamento Agil de Projetos com Scrum" };

	private List<CadastroContrato> cadastroContratos;

	public CadastroContratoBean() throws ParseException {

		cadastroContratos = new ArrayList<>();

		for (int i = 0; i < 50; i++) {
			adicionarContrato();
		}
	}

	private void adicionarContrato() {
		String nomeCompleto = getNomeAleatorio() + " " + getSobrenomeAleatorio() + " " + getSobrenomeAleatorio();
		cadastroContratos.add(new CadastroContrato(nomeCompleto, getCNPJAleatorio(), getCidadeAleatoria(),
				getModalidadeAleatoria(), getDataAleatoria(), getValorContratoAleatorio(),
				getMetodoPagamentoAleatorio(), getFormaPagamentoAleatorio(), getCursosContratadosAleatorio()));
	}

	private String getValorContratoAleatorio() {
		Random numeroAleatorio = new Random();

		return new BigDecimal(numeroAleatorio.nextInt(50000) + 10000).toString() + ",00";
	}

	private List<String> getCursosContratadosAleatorio() {
		Set<String> x = new HashSet<String>();
		Random numeroAleatorio = new Random();

		for (int i = 0; i < numeroAleatorio.nextInt(3) + 1; i++) {
			int posicao = (int) Math.round(Math.random() * (cursos.length - 1));
			x.add(cursos[posicao]);
		}

		return new ArrayList<String>(x);
	}

	private String getMetodoPagamentoAleatorio() {
		int posicao = (int) Math.round(Math.random() * (c.getMetodosPagamento().size() - 1));
		c.setMetodoPagamento(c.getMetodosPagamento().get(posicao));
		return c.getMetodosPagamento().get(posicao);
	}

	private String getFormaPagamentoAleatorio() {
		c.carregarFormasPagamento();

		int posicao = (int) Math.round(Math.random() * (c.getFormasPagamento().size() - 1));
		return c.getFormasPagamento().get(posicao);
	}

	private String getModalidadeAleatoria() {
		Random numeroAleatorio = new Random();
		if (numeroAleatorio.nextInt(2) == 1) {
			return "EAD";
		} else {
			return "Presencial";
		}
	}

	private Cidade getCidadeAleatoria() {
		int posicao = (int) Math.round(Math.random() * (CadastroContrato.CIDADES.size() - 1));
		return CadastroContrato.CIDADES.get(posicao);
	}

	private String getCNPJAleatorio() {
		Random numeroAleatorio = new Random();

		StringBuilder s = new StringBuilder();
		s.append(String.valueOf(numeroAleatorio.nextInt(10)));
		s.append(String.valueOf(numeroAleatorio.nextInt(10)));
		s.append(String.valueOf("."));
		s.append(String.valueOf(numeroAleatorio.nextInt(10)));
		s.append(String.valueOf(numeroAleatorio.nextInt(10)));
		s.append(String.valueOf(numeroAleatorio.nextInt(10)));
		s.append(String.valueOf("."));
		s.append(String.valueOf(numeroAleatorio.nextInt(10)));
		s.append(String.valueOf(numeroAleatorio.nextInt(10)));
		s.append(String.valueOf(numeroAleatorio.nextInt(10)));
		s.append(String.valueOf("/"));
		s.append(String.valueOf(numeroAleatorio.nextInt(10)));
		s.append(String.valueOf(numeroAleatorio.nextInt(10)));
		s.append(String.valueOf(numeroAleatorio.nextInt(10)));
		s.append(String.valueOf(numeroAleatorio.nextInt(10)));
		s.append(String.valueOf("-"));
		s.append(String.valueOf(numeroAleatorio.nextInt(10)));
		s.append(String.valueOf(numeroAleatorio.nextInt(10)));
		return s.toString();
	}

	private String getSobrenomeAleatorio() {
		int posicao = (int) Math.round(Math.random() * (sobrenomes.length - 1));
		return sobrenomes[posicao];
	}

	private String getNomeAleatorio() {
		int posicao = (int) Math.round(Math.random() * (nomes.length - 1));
		return nomes[posicao];
	}

	private Date getDataAleatoria() {
		long dezAnosEmMillis = 24 * 60 * 60 * 1000;
		long periodoSorteadoEmMillis = ((long) (Math.random() * 10 * 365)) * dezAnosEmMillis;
		return new Date(System.currentTimeMillis() - periodoSorteadoEmMillis);
	}

	public List<CadastroContrato> getCadastroContratos() {
		return cadastroContratos;
	}

	public void setCadastroContratos(List<CadastroContrato> cadastroContratos) {
		this.cadastroContratos = cadastroContratos;
	}

}
