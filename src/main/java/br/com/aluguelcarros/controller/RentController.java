package br.com.aluguelcarros.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.aluguelcarros.model.Rent;
import br.com.aluguelcarros.repository.RentRepository;



@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/alugueis")
public class RentController {
  @Autowired
  RentRepository rentRepository;

  @GetMapping
  public List<Rent> findAllRent(){
    return rentRepository.findAll();
  }

  @GetMapping("/{id}")
  public Optional<Rent> findRentById(@PathVariable("id") long id) {
      return rentRepository.findById(id);
  }
  
  @PostMapping
  public Rent saveRent(@RequestBody Rent rentEntity){
    return rentRepository.save(new Rent(rentEntity.getCar(), rentEntity.getClient(), rentEntity.getStartDate(), rentEntity.getEndDate()));
  }

  @PutMapping("/{id}")
  public Rent updateRent(@PathVariable("id") long id, @RequestBody Rent rentEntity){
    Optional<Rent> rentData = rentRepository.findById(id);
    if(rentData.isPresent()){
      Rent existingRent = rentData.get();
      existingRent.setCar(rentEntity.getCar());
      existingRent.setClient(rentEntity.getClient());
      existingRent.setStartDate(rentEntity.getStartDate());
      existingRent.setEndDate(rentEntity.getEndDate());
      return rentRepository.save(existingRent);
    }
    return null;
  }

  @DeleteMapping
  public void deleteAllRent(){
    rentRepository.deleteAll();
  }

  @DeleteMapping("/{id}")
  public void deleteRentById(@PathVariable("id") long id){
    rentRepository.deleteById(id);
  }
}
