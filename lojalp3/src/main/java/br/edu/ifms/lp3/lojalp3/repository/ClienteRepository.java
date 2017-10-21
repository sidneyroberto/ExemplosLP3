package br.edu.ifms.lp3.lojalp3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifms.lp3.lojalp3.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
