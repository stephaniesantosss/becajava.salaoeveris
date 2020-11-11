package br.salaoeveris.app.request;

import java.util.List;

import br.salaoeveris.app.model.Agendamento;
import br.salaoeveris.app.response.BaseResponse;

public class AgendamentoList extends BaseResponse {
	
	private List<Agendamento> Agendamentos;

	public List<Agendamento> getAgendamentos() {
		return Agendamentos;
	}

	public void setAgendamentos(List<Agendamento> agendamentos) {
		Agendamentos = agendamentos;
	}


}
