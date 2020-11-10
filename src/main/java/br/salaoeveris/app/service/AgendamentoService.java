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

	public BaseResponse inserir(AgendamentoRequest agendamentoResponse) {
		Agendamento agendamento = new Agendamento();
		BaseResponse base = new BaseResponse();
		base.StatusCode = 400;

		if (agendamentoResponse.getDatahora().equals(null)) {
			base.Message = "A data e hora do serviço não foi preenchido.";
			return base;
		}


		agendamento.setDatahora(agendamentoResponse.getDatahora());
		

		_repository.save(agendamento);
		base.StatusCode = 201;
		base.Message = "Agendamento inserido com sucesso.";
		return base;
	}

}

