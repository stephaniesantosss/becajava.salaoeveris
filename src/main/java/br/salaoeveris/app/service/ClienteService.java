package br.salaoeveris.app.service;

import java.util.ArrayList;
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

		response.setNome(cliente.get().getNome());
		response.setTelefone(cliente.get().getTelefone());
		response.setEndereco(cliente.get().getEndereco());

		response.Message = "Cliente obtido com sucesso";
		response.StatusCode = 200;
		return response;
	}

	public ClienteResponse listar() {
        
		//Lista de Clientes
		List<Cliente> lista = _repository.findAll();
        
		//Lista de Clientes do response dentro de um array
		List<ClienteResponse> listarclienteresponse = new ArrayList<ClienteResponse>();

		//response recebe ClienteList novo
		ClienteList response = new ClienteList();
		
		//cliente recebe ClinteResponse novo
		ClienteResponse cliente = new ClienteResponse();
        
		//o array coloca o objeto da lista no clientelistar e varre dentro da lista
		for (Cliente clientelistar : lista) {
            
			//cliente recebe nova lista de ClienteResponse
			cliente = new ClienteResponse();

			cliente.setEndereco(clientelistar.getEndereco());
			cliente.setTelefone(clientelistar.getTelefone());
			cliente.setNome(clientelistar.getNome());

			listarclienteresponse.add(cliente);

		}

		response.setClientes(listarclienteresponse);

		response.StatusCode = 200;
		response.Message = "Clientes obtidos com sucesso.";

		return cliente;
	}

}
