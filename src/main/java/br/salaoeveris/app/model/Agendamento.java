package br.salaoeveris.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.salaoeveris.app.response.BaseResponse;

@Entity
public class Agendamento extends BaseResponse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private Date datahora;
	
	public Date getDatahora() {
		return datahora;
	}
	public void setDatahora(Date datahora) {
		this.datahora = datahora;
	}
	@ManyToOne
    @JoinColumn(name = "IdCliente")
    private Cliente Cliente;
	
	@ManyToOne
    @JoinColumn(name = "IdServico")
    private Servico Servico;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}

}
