package br.com.aluguelcarros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.aluguelcarros.model.Car;

public interface CarRepository extends JpaRepository<Car, Long>{
  
}
