package br.com.aluguelcarros.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Client {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String cpf;

  @Column(nullable = false)
  private String telefone;

  public Client() {

  }

  public Client(String name, String cpf, String telefone) {
    this.name = name;
    this.cpf = cpf;
    this.telefone = telefone;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  @Override
  public String toString() {
    return "Client [id=" + id + ", name=" + name + ", cpf=" + cpf + ", telefone=" + telefone + "]";
  }

}
