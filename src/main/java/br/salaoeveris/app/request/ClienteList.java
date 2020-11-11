package br.salaoeveris.app.request;

import java.util.List;

import br.salaoeveris.app.response.BaseResponse;
import br.salaoeveris.app.response.ClienteResponse;

public class ClienteList extends BaseResponse {
	
	private List<ClienteResponse> Clientes;

	public List<ClienteResponse> getClientes() {
		return Clientes;
	}

	public void setClientes(List<ClienteResponse> clientes) {
		Clientes = clientes;
	}

}
