package br.com.aluguelcarros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.aluguelcarros.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
  
}
