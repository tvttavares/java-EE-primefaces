package com.algaworks.pedidovenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import com.algaworks.pedidovenda.model.Cliente;
import com.algaworks.pedidovenda.model.Endereco;
import com.algaworks.pedidovenda.service.NegocioException;

@Named
@ViewScoped
public class CadastroClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Cliente cliente;
	private Endereco endereco;

	private List<Integer> itens;

	public CadastroClienteBean() {
		cliente = new Cliente();
		endereco = new Endereco();
		cliente.getEnderecos().add(endereco);
		itens = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			itens.add(i);
		}
	}

	public void salvar() {
		throw new NegocioException("Pedido não pode ser salvo, pois ainda não foi implementado.");
	}

	public List<Integer> getItens() {
		return itens;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Endereco getEndereco() {
		return endereco;
	}
}