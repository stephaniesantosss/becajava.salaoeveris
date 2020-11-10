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

import br.salaoeveris.app.request.ClienteList;
import br.salaoeveris.app.request.ClienteRequest;
import br.salaoeveris.app.request.ServicoList;
import br.salaoeveris.app.request.ServicoRequest;
import br.salaoeveris.app.response.BaseResponse;
import br.salaoeveris.app.response.ClienteResponse;
import br.salaoeveris.app.response.ServicoResponse;
import br.salaoeveris.app.service.ClienteService;
import br.salaoeveris.app.service.ServicoService;

@RestController
@RequestMapping("/servicos")
public class ServicoController extends BaseController {
	
	private final ServicoService _service;
	
	@Autowired
	public ServicoController(ServicoService service) {
		_service = service;
	}
	
	@PostMapping
    public ResponseEntity inserir(@RequestBody ServicoRequest servicoRequest) {
		try {
			BaseResponse response = _service.inserir(servicoRequest);
			return ResponseEntity.status(response.StatusCode).body(response);			
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.StatusCode).body(errorBase);
		}
    }
	
	@GetMapping(path = "/{id}")
    public ResponseEntity obter(@PathVariable Long id) {		
		try {
			ServicoResponse response = _service.obter(id);
			return ResponseEntity.status(response.StatusCode).body(response);	
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.StatusCode).body(errorBase);
		}   	
    }

	@GetMapping
    public ResponseEntity listar() {		
		try {
			ServicoList servicos = _service.listar();  		
	    	return ResponseEntity.status(HttpStatus.OK).body(servicos);			
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.StatusCode).body(errorBase);			
		}		
    }

}

