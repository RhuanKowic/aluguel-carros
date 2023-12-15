package br.com.aluguelcarros.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Car {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(nullable = false)
  private String model;

  @Column(nullable = false)
  private String color;

  @Column(nullable = false)
  private int year;

  @Column(nullable = false)
  private String place;

  @Column(nullable = false)
  private double pricePerDay;

  public Car() {

  }

  public Car(String model, String color, int year, String place, double pricePerDay) {
    setModel(model);
    setColor(color);
    setYear(year);
    setPlace(place);
    setPricePerDay(pricePerDay);
  }

  public long getId() {
    return id;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    if (model != null && !model.trim().isEmpty()) {
      this.model = model;
    } else {
      throw new IllegalArgumentException("Modelo do carro não pode ser vazio ou nulo.");
    }
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    if (color != null && !color.trim().isEmpty()) {
      this.color = color;
    } else {
      throw new IllegalArgumentException("Cor do carro não pode ser vazio ou nulo.");
    }
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    if (year > 1940 && year <= 2024) {
      this.year = year;
    } else {
      throw new IllegalArgumentException("O ano do carro não pode ser menos que 1940 e maior que 2024.");
    }
  }

  public String getPlace() {
    return place;
  }

  public void setPlace(String place) {
    if (place.matches("[A-Z]{2,3}[0-9]{4}|[A-Z]{3,4}[0-9]{3}|[A-Z0-9]{7}")) {
      this.place = place;
    } else {
      throw new IllegalArgumentException("A placa do carro deve seguir a norma MercoSul ou a norma antiga.");
    }

  }

  public double getPricePerDay() {
    return pricePerDay;
  }

  public void setPricePerDay(double pricePerDay) {
    if (pricePerDay > 0) {
      this.pricePerDay = pricePerDay;
    } else {
      throw new IllegalArgumentException("A preço do carro deve ser maior que 0.");
    }
  }

  @Override
  public String toString() {
    return "Car [id=" + id + ", model=" + model + ", color=" + color + ", year=" + year + ", place=" + place
        + ", pricePerDay=" + pricePerDay + "]";
  }

}
