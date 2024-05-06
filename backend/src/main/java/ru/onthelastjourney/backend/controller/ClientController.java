package ru.onthelastjourney.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.onthelastjourney.backend.dto.ClientDto;
import ru.onthelastjourney.backend.entity.Client;
import ru.onthelastjourney.backend.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService service;

    @Autowired
    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<Client> getById(@PathVariable(name = "clientId") Long clientId) {
        return ResponseEntity.ok(service.getById(clientId));
    }

    @PostMapping
    public ResponseEntity<Client> save(@RequestBody ClientDto clientDto) {
        return ResponseEntity.ok(service.save(clientDto));
    }

    @PostMapping("/save-all")
    public ResponseEntity<List<Client>> saveAll(@RequestBody List<ClientDto> clientDtos) {
        return ResponseEntity.ok(service.saveAll(clientDtos));
    }

    @PutMapping
    public ResponseEntity<Client> update(@RequestBody Client client) {
        return ResponseEntity.ok(service.update(client));
    }

    @DeleteMapping
    public HttpStatus delete(@RequestBody Client client) {
        service.delete(client);

        return HttpStatus.OK;
    }

    @DeleteMapping("/{clientId}")
    public HttpStatus deleteById(@PathVariable(name = "clientId") Long clientId) {
        service.deleteById(clientId);

        return HttpStatus.OK;
    }
}
