package br.salaoeveris.app.model;

import javax.persistence.*;

import br.salaoeveris.app.response.BaseResponse;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "cpf", name = "cpf_uk"))
public class Cliente extends BaseResponse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String nome;
	private String Telefone;
	private String endereco;
	private String cpf;
	
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
	public String getTelefone() {
		return Telefone;
	}
	public void setTelefone(String telefone) {
		Telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	

}
