package com.algaworks.pedidovenda.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.pedidovenda.model.Cliente;
import com.algaworks.pedidovenda.repository.Clientes;
import com.algaworks.pedidovenda.util.jpa.Transactional;

public class CadastroClienteService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Clientes clientes;

	@Transactional
	public Cliente salvar(Cliente cliente) {
		Cliente clienteExistente = clientes.porDocumentoIdentificacao(cliente.getDocumentoReceitaFederal());

		if (clienteExistente != null && !clienteExistente.equals(cliente)) {
			throw new NegocioException("Já existe um cliente com o Documento informado.");
		}

		return clientes.guardar(cliente);

	}

}
