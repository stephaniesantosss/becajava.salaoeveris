package br.salaoeveris.app.response;

import java.util.Date;

public class AgendamentoResponse extends BaseResponse {
	private Long Id;
	private Date datahora;
	
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
