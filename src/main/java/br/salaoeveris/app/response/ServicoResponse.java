package br.salaoeveris.app.response;

public class ServicoResponse extends BaseResponse {
	
	private Long Id;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	private String nome;
	private String valor;

}
