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
    setName(name);
    setCpf(cpf);
    setTelefone(telefone);
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    if (name != null && !name.trim().isEmpty()) {
      this.name = name;
    } else{
      throw new IllegalArgumentException("O campo nome não pode ser nulo ou vazio.");
    }
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    String newCpf = cpf.replace(".", "");
    cpf.replace("-", "");
    if(newCpf.length() == 11){
      this.cpf = cpf;
    } else {
      throw new IllegalArgumentException("O campo CPF tem que ter 11 números.");
    }
    
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    if(telefone != null && telefone.trim().isEmpty()){
      this.telefone = telefone;
    } else{
      throw new IllegalArgumentException("O campo telefone não pode ser nulo ou vazio.");
    }
  }

  @Override
  public String toString() {
    return "Client [id=" + id + ", name=" + name + ", cpf=" + cpf + ", telefone=" + telefone + "]";
  }

}
