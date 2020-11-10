package br.salaoeveris.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.salaoeveris.app.model.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long>{
	

}
