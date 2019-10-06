package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class CadastroUsuarioBean {

	private List<Integer> itens;

	public CadastroUsuarioBean() {
		itens = new ArrayList<>();
		itens.add(3);
	}

	public List<Integer> getItens() {
		return itens;
	}

}