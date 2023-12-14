package br.com.aluguelcarros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.aluguelcarros.model.Rent;

public interface RentRepository extends JpaRepository<Rent, Long>{
  
}
