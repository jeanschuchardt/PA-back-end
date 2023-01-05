package com.example.pa_backend.controller;

import com.example.pa_backend.dto.ClientDTO;
import com.example.pa_backend.entity.user.Client;
import com.example.pa_backend.repository.ClientRepository;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CommonsLog
@RestController
@RequestMapping("/client")
@CrossOrigin(origins = {"http://localhost:8081", "http://localhost:8080", "*", "http://192.168.1.8:8081"})
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("")
    public List<Client> getAll() {
        return clientRepository.findAll();

    }

    @GetMapping("/{id}")
    public Client getById(@PathVariable int id) {
        return clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    @PostMapping("/")
    public Client create(@RequestBody ClientDTO clientDTO) {
        Client client = new Client();
        client.setName(clientDTO.getName());
        client.setEmail(clientDTO.getEmail());

        return clientRepository.save(client);


    }

    @PutMapping("/{id}")
    public Object update(@PathVariable int id, @RequestBody ClientDTO clientDTO) {

        Optional<Client> id1 = clientRepository.findById(id);
        if (id1.isPresent()) {
            Client client = id1.get();
            client.setName(clientDTO.getName());
            client.setEmail(clientDTO.getEmail());

            return clientRepository.save(client);
        } else {
            throw new RuntimeException("Not deleted");
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isPresent()) {
            clientRepository.delete(client.get());
        } else {
            throw new RuntimeException("Not deleted");
        }

    }
}
