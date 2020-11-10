package br.salaoeveris.app.request;

import java.util.List;

import br.salaoeveris.app.model.Servico;
import br.salaoeveris.app.response.BaseResponse;

public class ServicoList extends BaseResponse {
	
	private List<Servico> Servicos;

	public List<Servico> getServicos() {
		return Servicos;
	}

	public void setServicos(List<Servico> servicos) {
		Servicos = servicos;
	}

}
