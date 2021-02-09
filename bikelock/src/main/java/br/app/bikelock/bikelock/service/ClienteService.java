package br.app.bikelock.bikelock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.app.bikelock.bikelock.model.Cliente;
import br.app.bikelock.bikelock.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> lista(){
        return clienteRepository.findAll();
    }

    public Cliente busca(Long id){
        Optional<Cliente> ClienteEncontrado = clienteRepository.findById(id);
        return ClienteEncontrado.orElse(null);
        }

    public void adiciona(Cliente cliente){
        cliente.setId(null);
        clienteRepository.save(cliente);
    }

    public void atualiza(Cliente cliente){
        if(cliente.getId() != null){
            clienteRepository.save(cliente);
        }
    }
    public void remove(Long id){
        clienteRepository.deleteById(id);
    }

    
}
