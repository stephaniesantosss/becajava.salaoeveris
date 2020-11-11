package br.salaoeveris.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.salaoeveris.app.model.Agendamento;
import br.salaoeveris.app.repository.AgendamentoRepository;

import br.salaoeveris.app.request.AgendamentoRequest;
import br.salaoeveris.app.response.BaseResponse;


@Service
public class AgendamentoService {
	final AgendamentoRepository _repository;

	@Autowired
	public AgendamentoService(AgendamentoRepository repository) {
		_repository = repository;
	}

	public BaseResponse inserir(AgendamentoRequest agendamentoRequest) {
		Agendamento agendamento = new Agendamento();
		BaseResponse base = new BaseResponse();

		if (agendamentoRequest.getCliente().equals(null)) {
			base.Message = "O id do cliente não foi preenchido.";
			return base;
		}

		if (agendamentoRequest.getServico().equals(null)) {
			base.Message = "O id do servico não foi preenchido.";
			return base;
		}
		if (agendamentoRequest.getDatahora().equals(null)) {
			base.Message = "A Data e Hora do agendamento não foi preenchido.";
			return base;
		}

		agendamento.setCliente(agendamentoRequest.getCliente());
		agendamento.setServico(agendamentoRequest.getServico());
		agendamento.setDatahora(agendamentoRequest.getDatahora());

		_repository.save(agendamento);
		base.StatusCode = 201;
		base.Message = "Agendamento inserido com sucesso.";
		return base;
	}

}