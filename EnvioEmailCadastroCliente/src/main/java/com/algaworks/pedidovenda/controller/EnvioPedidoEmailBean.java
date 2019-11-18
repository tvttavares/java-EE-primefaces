package com.algaworks.pedidovenda.controller;

import java.io.Serializable;
import java.util.Locale;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.velocity.tools.generic.NumberTool;

import com.algaworks.pedidovenda.model.Cliente;
import com.algaworks.pedidovenda.model.Pedido;
import com.algaworks.pedidovenda.util.jsf.FacesUtil;
import com.algaworks.pedidovenda.util.mail.Mailer;
import com.outjected.email.api.MailMessage;
import com.outjected.email.impl.templating.velocity.VelocityTemplate;

@Named
@RequestScoped
public class EnvioPedidoEmailBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Mailer mailer;

	@Inject
	@PedidoEdicao
	private Pedido pedido;

	@Inject
	private CadastroClienteBean cadastroClienteBean;

	public void enviarPedido() {
		MailMessage message = mailer.novaMensagem();

		String filePath = getClass().getClassLoader().getResource("/emails/pedido.template").getFile();

		message.to(this.pedido.getCliente().getEmail()).subject("Pedido " + this.pedido.getId())
				.bodyHtml(new VelocityTemplate(filePath)).put("pedido", this.pedido).put("numberTool", new NumberTool())
				.put("locale", new Locale("pt", "BR")).send();

		FacesUtil.addInfoMessage("Pedido enviado por e-mail com sucesso!");
	}

	public void enviarCadastroCliente() {
		MailMessage message = mailer.novaMensagem();

		String filePath = getClass().getClassLoader().getResource("/emails/cliente.template").getFile();

		message.to(this.cadastroClienteBean.getCliente().getEmail())
				.subject("Cliente " + this.cadastroClienteBean.getCliente().getId())
				.bodyHtml(new VelocityTemplate(filePath)).put("cliente", this.cadastroClienteBean.getCliente())
				.put("numberTool", new NumberTool()).put("locale", new Locale("pt", "BR")).send();

		FacesUtil.addInfoMessage("Cadastro do cliente enviado por e-mail com sucesso!");
	}

}
