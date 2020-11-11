package br.salaoeveris.app.request;

import java.util.Date;

import br.salaoeveris.app.model.Cliente;
import br.salaoeveris.app.model.Servico;

public class AgendamentoRequest {
	
	private Date datahora;
	private Cliente cliente;
    private Servico servico;
	

	public Date getDatahora() {
		return datahora;
	}

	public void setDatahora(Date datahora) {
		this.datahora = datahora;
	}
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}
}
