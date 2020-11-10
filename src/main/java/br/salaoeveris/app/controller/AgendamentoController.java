package br.salaoeveris.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.salaoeveris.app.request.AgendamentoList;
import br.salaoeveris.app.request.AgendamentoRequest;
import br.salaoeveris.app.request.ServicoList;
import br.salaoeveris.app.request.ServicoRequest;
import br.salaoeveris.app.response.AgendamentoResponse;
import br.salaoeveris.app.response.BaseResponse;
import br.salaoeveris.app.response.ServicoResponse;
import br.salaoeveris.app.service.AgendamentoService;
import br.salaoeveris.app.service.ServicoService;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController extends BaseController {

	private final AgendamentoService _service;

	@Autowired
	public AgendamentoController(AgendamentoService service) {
		_service = service;
	}

	@PostMapping
	public ResponseEntity inserir(@RequestBody AgendamentoRequest agendamentoRequest) {
		try {
			BaseResponse response = _service.inserir(agendamentoRequest);
			return ResponseEntity.status(response.StatusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.StatusCode).body(errorBase);
		}
	}

}
