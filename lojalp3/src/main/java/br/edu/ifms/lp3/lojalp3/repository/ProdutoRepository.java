package br.edu.ifms.lp3.lojalp3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifms.lp3.lojalp3.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
