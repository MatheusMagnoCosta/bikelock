package br.app.bikelock.bikelock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import br.app.bikelock.bikelock.model.Cliente;
import br.app.bikelock.bikelock.service.ClienteService;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public List<Cliente> get() {
        return clienteService.lista();
    }

    @PostMapping("/clientes")
    public String post(){
        return "Verbo post";
    }
    
    @PutMapping("/clientes")
    public String put(){
        return "Verbo put";
    }

    @DeleteMapping("/clientes")
    public String delete(){
        return "Verbo delete";
    }

    
}
