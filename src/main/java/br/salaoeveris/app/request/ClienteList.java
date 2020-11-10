package br.salaoeveris.app.request;

import java.util.List;

import br.salaoeveris.app.model.Cliente;
import br.salaoeveris.app.response.BaseResponse;

public class ClienteList extends BaseResponse {
	
	private List<Cliente> Clientes;

	public List<Cliente> getClientes() {
		return Clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		Clientes = clientes;
	}

}
