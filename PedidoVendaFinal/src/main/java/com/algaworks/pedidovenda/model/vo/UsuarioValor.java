package com.algaworks.pedidovenda.model.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.algaworks.pedidovenda.model.Usuario;

public class UsuarioValor implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	private BigDecimal valor;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}