package com.algaworks.pedidovenda.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.algaworks.pedidovenda.model.Usuario;

@ManagedBean
@ViewScoped
public class CadastroUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;

	private List<Integer> itens;

	public CadastroUsuarioBean() {
		usuario = new Usuario();
		itens = new ArrayList<>();
		itens.add(3);
	}

	public void salvar() {
	}

	public List<Integer> getItens() {
		return itens;
	}

	public Usuario getUsuario() {
		return usuario;
	}

}