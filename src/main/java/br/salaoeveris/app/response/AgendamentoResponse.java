package br.salaoeveris.app.response;

import java.util.Date;

import br.salaoeveris.app.model.Cliente;
import br.salaoeveris.app.model.Servico;

public class AgendamentoResponse extends BaseResponse {
	private Long Id;
	private Date datahora;private Cliente cliente;
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

	private Servico servico;

	public Date getDatahora() {
		return datahora;
	}

	public void setDatahora(Date datahora) {
		this.datahora = datahora;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}
	

}
