package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class PesquisaClientesBean {

	private List<Integer> clientesFiltrados;

	public PesquisaClientesBean() {
		clientesFiltrados = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			clientesFiltrados.add(i);
		}
	}

	public List<Integer> getClientesFiltrados() {
		return clientesFiltrados;
	}
}
