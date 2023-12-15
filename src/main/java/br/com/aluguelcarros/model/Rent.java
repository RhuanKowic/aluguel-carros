package br.com.aluguelcarros.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "rents")
public class Rent {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @ManyToOne
  @JoinColumn(name = "id_car", nullable = false)
  private Car car;

  @ManyToOne
  @JoinColumn(name = "id_client", nullable = false)
  private Client client;

  @Column(nullable = false)
  private LocalDate startDate;

  @Column(nullable = false)
  private LocalDate endDate;

  @Column()
  private double priceTotal;

  public Rent() {

  }

  public Rent(Car car, Client client, LocalDate startDate, LocalDate endDate) {
    setCar(car);
    setClient(client);
    setStartDate(startDate);
    setEndDate(endDate);
    setPriceTotal();
  }

  public long getId() {
    return id;
  }

  public Car getCar() {
    return car;
  }

  public void setCar(Car car) {
    this.car = car;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  public double getPriceTotal() {
    return priceTotal;
  }

  public void setPriceTotal() {
    Long days = ChronoUnit.DAYS.between(startDate, endDate);
    double pricePerDay = car.getPricePerDay();
    double priceTotal = (double) days * pricePerDay;
    this.priceTotal = priceTotal;
  }

  @Override
  public String toString() {
    return "Rent [id=" + id + ", car=" + car + ", client=" + client + ", startDate=" + startDate + ", endDate="
        + endDate + ", priceTotal=" + priceTotal + "]";
  }

}
