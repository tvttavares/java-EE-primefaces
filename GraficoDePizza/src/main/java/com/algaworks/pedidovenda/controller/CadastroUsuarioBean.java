package com.algaworks.pedidovenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.pedidovenda.model.Grupo;
import com.algaworks.pedidovenda.model.Usuario;
import com.algaworks.pedidovenda.repository.Grupos;
import com.algaworks.pedidovenda.service.CadastroUsuarioService;
import com.algaworks.pedidovenda.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Grupos grupos;

	@Inject
	private CadastroUsuarioService cadastroUsuarioService;

	private Usuario usuario;
	private Grupo grupo;

	private List<Grupo> gruposUsuario;

	public CadastroUsuarioBean() {
		limpar();
	}

	public void inicializar() {
		if (FacesUtil.isNotPostback()) {
			gruposUsuario = grupos.raizesGrupos();
		}
	}

	public void salvar() {
		this.usuario = cadastroUsuarioService.salvar(this.usuario);
		limpar();

		FacesUtil.addInfoMessage("Usuario salvo com sucesso!");
	}

	public void adicionarGrupo() {
		if (grupo != null && !this.usuario.getGrupos().contains(this.grupo)) {
			this.usuario.getGrupos().add(this.grupo);
			grupo = new Grupo();
		}
	}

	public void removerGrupo() {
		if (grupo != null) {
			this.usuario.getGrupos().remove(this.grupo);
		}
	}

	private void limpar() {
		usuario = new Usuario();
		grupo = new Grupo();
	}

	public boolean isEditando() {
		return this.usuario.getId() != null;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public List<Grupo> getGruposUsuario() {
		return gruposUsuario;
	}

	public void setGruposUsuario(List<Grupo> gruposUsuario) {
		this.gruposUsuario = gruposUsuario;
	}

}