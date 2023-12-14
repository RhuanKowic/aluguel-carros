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
    this.model = model;
    this.color = color;
    this.year = year;
    this.place = place;
    this.pricePerDay = pricePerDay;
  }

  public long getId() {
    return id;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public String getPlace() {
    return place;
  }

  public void setPlace(String place) {
    this.place = place;
  }

  public double getPricePerDay() {
    return pricePerDay;
  }

  public void setPricePerDay(double pricePerDay) {
    this.pricePerDay = pricePerDay;
  }

  @Override
  public String toString() {
    return "Car [id=" + id + ", model=" + model + ", color=" + color + ", year=" + year + ", place=" + place
        + ", pricePerDay=" + pricePerDay + "]";
  }

}
