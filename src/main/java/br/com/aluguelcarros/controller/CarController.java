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

import br.com.aluguelcarros.model.Car;
import br.com.aluguelcarros.repository.CarRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/carros")
public class CarController {
  @Autowired
  CarRepository carRepository;

  @GetMapping
  public List<Car> findAllCar() {
    return carRepository.findAll();
  }

  @GetMapping("/{id}")
  public Optional<Car> findCarById(@PathVariable("id") long id) {
    return carRepository.findById(id);
  }

  @PostMapping
  public Car saveCar(@RequestBody Car carEntity) {
    return carRepository.save(new Car(carEntity.getModel(), carEntity.getColor(), carEntity.getYear(),
        carEntity.getPlace(), carEntity.getPricePerDay()));
  }

  @PutMapping("/{id}")
  public Car updateCar(@PathVariable("id") long id, @RequestBody Car carEntity) {
    Optional<Car> carData = carRepository.findById(id);
    if (carData.isPresent()) {
      Car existingCar = carData.get();
      existingCar.setModel(carEntity.getModel());
      existingCar.setColor(carEntity.getColor());
      existingCar.setYear(carEntity.getYear());
      existingCar.setPlace(carEntity.getPlace());
      existingCar.setPricePerDay(carEntity.getPricePerDay());
      return carRepository.save(existingCar);
    } else {
      return null;
    }
  }

  @DeleteMapping
  public void deleteAllCar() {
    carRepository.deleteAll();
  }

  @DeleteMapping("/{id}")
  public void deleteCarById(@PathVariable("id") long id) {
    carRepository.deleteById(id);
  }
}
