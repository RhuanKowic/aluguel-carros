package br.com.aluguelcarros.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.aluguelcarros.model.Client;
import br.com.aluguelcarros.repository.ClientRepository;
import org.springframework.web.bind.annotation.PutMapping;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/clientes")
public class ClientController {
  @Autowired
  ClientRepository clientRepository;

  @GetMapping
  public List<Client> findAllClient() {
    return clientRepository.findAll();
  }

  @GetMapping("/{id}")
  public Optional<Client> findClientById(@PathVariable("id") long id) {
    return clientRepository.findById(id);
  }

  @PostMapping
  public Client saveClient(@RequestBody Client clientEntity) {
    return clientRepository.save(new Client(clientEntity.getName(), clientEntity.getCpf(), clientEntity.getTelefone()));
  }

  @PutMapping("/{id}")
  public Client updateClient(@PathVariable("id") long id, @RequestBody Client clientEntity) {
      Optional<Client> clientData = clientRepository.findById(id);
      if(clientData.isPresent()){
        Client existingClient = clientData.get();
        existingClient.setName(clientEntity.getName());
        existingClient.setCpf(clientEntity.getCpf());
        existingClient.setTelefone(clientEntity.getTelefone());
        return clientRepository.save(existingClient);
      }
      return null;
  }

  @DeleteMapping
  public void deleteAllClient(){
    clientRepository.deleteAll();
  }

  @DeleteMapping("/{id}")
  public void deleteClientById(@PathVariable("id") long id){
    clientRepository.deleteById(id); 
  }
}
