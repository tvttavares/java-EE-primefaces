package com.algaworks.pedidovenda.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.pedidovenda.model.Cliente;
import com.algaworks.pedidovenda.model.Endereco;
import com.algaworks.pedidovenda.model.TipoPessoa;
import com.algaworks.pedidovenda.service.CadastroClienteService;
import com.algaworks.pedidovenda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Cliente cliente;
	private Endereco endereco;
	private List<TipoPessoa> tipoPessoas;
	private List<Endereco> enderecosUsuario;

	@Inject
	private CadastroClienteService cadastroClienteService;

	public CadastroClienteBean() {
		limpar();
	}

	public void inicializar() {
		if (FacesUtil.isNotPostback()) {
			tipoPessoas = Arrays.asList(TipoPessoa.values());
		}
	}

	public void salvar() {
		this.cliente = cadastroClienteService.salvar(this.cliente);
		limpar();

		FacesUtil.addInfoMessage("Cliente salvo com sucesso!");
	}

	public void limpar() {
		cliente = new Cliente();
		endereco = new Endereco();
	}

	public void incluirEnderecoCliente() {
		if (!existeEndereco(endereco)) {
			this.cliente.getEnderecos().add(endereco);
			this.endereco.setCliente(cliente);
			this.endereco = new Endereco();
		}
	}

	public boolean existeEndereco(Endereco endereco) {
		boolean existeItem = false;

		for (Endereco item : this.cliente.getEnderecos()) {
			if (endereco.equals(item)) {
				existeItem = true;
				break;
			}
		}
		return existeItem;
	}

	public void removerEndereco() {
		cliente.getEnderecos().remove(endereco);
	}

	public boolean isEditando() {
		return this.cliente.getId() != null;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<TipoPessoa> getTipoPessoas() {
		return tipoPessoas;
	}

	public void setTipoPessoas(List<TipoPessoa> tipoPessoas) {
		this.tipoPessoas = tipoPessoas;
	}

	public List<Endereco> getEnderecosUsuario() {
		return enderecosUsuario;
	}

	public void setEnderecosUsuario(List<Endereco> enderecosUsuario) {
		this.enderecosUsuario = enderecosUsuario;
	}

}