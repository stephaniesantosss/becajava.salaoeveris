package br.salaoeveris.app.response;

import java.util.List;

public class ClienteResponse extends BaseResponse{
		
		private String nome;
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getTelefone() {
			return telefone;
		}
		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}
		public String getEndereco() {
			return endereco;
		}
		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}

		private String telefone;
		private String endereco;
	
	
}
