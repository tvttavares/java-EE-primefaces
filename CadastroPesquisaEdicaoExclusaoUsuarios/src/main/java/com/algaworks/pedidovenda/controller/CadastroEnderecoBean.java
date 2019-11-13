package com.algaworks.pedidovenda.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.algaworks.pedidovenda.service.NegocioException;

@ManagedBean
@RequestScoped
public class CadastroEnderecoBean {

	private List<Integer> itens;

	public CadastroEnderecoBean() {
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

}