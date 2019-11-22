package com.algaworks.pedidovenda.controller;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

import com.algaworks.pedidovenda.model.Usuario;
import com.algaworks.pedidovenda.repository.Pedidos;
import com.algaworks.pedidovenda.security.UsuarioLogado;
import com.algaworks.pedidovenda.security.UsuarioSistema;

@Named
@RequestScoped
public class GraficoPedidosCriadosBean {

	private static DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM");

	@Inject
	private Pedidos pedidos;

	@Inject
	@UsuarioLogado
	private UsuarioSistema usuarioLogado;

	private CartesianChartModel model;

	private PieChartModel pizza;

	public void preRender() {
		this.model = new CartesianChartModel();

		adicionarSerie("Todos os pedidos", null);
		adicionarSerie("Meus pedidos", usuarioLogado.getUsuario());
	}

	public void preRender2() {
		this.pizza = new PieChartModel();
		graficoPizza();
	}

	private void adicionarSerie(String rotulo, Usuario criadoPor) {
		Map<Date, BigDecimal> valoresPorData = this.pedidos.valoresTotaisPorData(15, criadoPor);

		ChartSeries series = new ChartSeries(rotulo);

		for (Date data : valoresPorData.keySet()) {
			series.set(DATE_FORMAT.format(data), valoresPorData.get(data));
		}

		this.model.addSeries(series);
	}

	public void graficoPizza() {
		Map<String, BigDecimal> valoresPorVendedor = this.pedidos.valorUsuario();

		for (String string : valoresPorVendedor.keySet()) {
			pizza.set(string, valoresPorVendedor.get(string));
		}
	}

	public CartesianChartModel getModel() {
		return model;
	}

	public PieChartModel getPizza() {
		return pizza;
	}

}
