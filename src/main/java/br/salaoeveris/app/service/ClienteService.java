package br.salaoeveris.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.salaoeveris.app.model.Cliente;
import br.salaoeveris.app.repository.ClienteRepository;
import br.salaoeveris.app.request.ClienteList;
import br.salaoeveris.app.request.ClienteRequest;
import br.salaoeveris.app.response.BaseResponse;
import br.salaoeveris.app.response.ClienteResponse;

@Service
public class ClienteService {

	final ClienteRepository _repository;

	@Autowired
	public ClienteService(ClienteRepository repository) {
		_repository = repository;
	}

	public BaseResponse inserir(ClienteRequest clienteResponse) {
		Cliente cliente = new Cliente();
		BaseResponse base = new BaseResponse();
		base.StatusCode = 400;

		if (clienteResponse.getNome() == "") {
			base.Message = "O nome do cliente não foi preenchido.";
			return base;
		}

		if (clienteResponse.getTelefone() == "") {
			base.Message = "O telefone do cliente não foi preenchido.";
			return base;
		}
		if (clienteResponse.getCpf() == "") {
			base.Message = "O Cpf do cliente não foi preenchido.";
			return base;
		}
		if (clienteResponse.getEndereco() == "") {
			base.Message = "O endereço do cliente não foi preenchido";
			return base;
		}

		cliente.setNome(clienteResponse.getNome());
		cliente.setTelefone(clienteResponse.getTelefone());
		cliente.setCpf(clienteResponse.getCpf());
		cliente.setEndereco(clienteResponse.getEndereco());

		_repository.save(cliente);
		base.StatusCode = 201;
		base.Message = "Cliente inserido com sucesso.";
		return base;
	}

	public ClienteResponse obter(Long id) {
		Optional<Cliente> cliente = _repository.findById(id);		
		ClienteResponse response = new ClienteResponse();
		
		if (cliente == null) {
			response.Message = "Cliente não encontrado";
			response.StatusCode = 404;
			return response;
		}
		
		response.setCpf(cliente.get().getCpf());
		response.setNome(cliente.get().getNome());
		response.setTel(cliente.get().getTelefone());
		response.setEndereco(cliente.get().getEndereco());

		response.Message = "Cliente obtido com sucesso";
		response.StatusCode = 200;
		return response;
	}

	public ClienteResponse obterByCpf(String cpf) {
		Cliente cliente = _repository.findByCpf(cpf);	
		ClienteResponse response = new ClienteResponse();
		
		if (cliente == null) {
			response.Message = "Cliente não encontrado";
			response.StatusCode = 404;
			return response;
		}

		response.Message = "Cliente obtido com sucesso";
		response.StatusCode = 200;
		return response;
	}

	public ClienteList listar() {

		List<Cliente> lista = _repository.findAll();

		ClienteList response = new ClienteList();
		response.setClientes(lista);
		response.StatusCode = 200;
		response.Message = "Clientes obtidos com sucesso.";

		return response;
	}

}
