package br.app.bikelock.bikelock.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.app.bikelock.bikelock.model.Bicicleta;
import br.app.bikelock.bikelock.model.Cliente;
import br.app.bikelock.bikelock.repository.BicicletaRepository;
import br.app.bikelock.bikelock.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private BicicletaRepository bicicletaRepository;


    public List<Cliente> lista(){
        return clienteRepository.findAll();
    }

    public Cliente busca(Long id){
        Optional<Cliente> ClienteEncontrado = clienteRepository.findById(id);
        return ClienteEncontrado.orElse(null);
        }

    public Cliente adiciona(Cliente cliente){
        cliente.setId(null);
        return clienteRepository.save(cliente);
    }

    public Cliente atualiza(Cliente cliente) {
        if(cliente.getId() != null){
            clienteRepository.save(cliente);
        } return null; 
    }

    public void remove(Long id){
        clienteRepository.deleteById(id);
    }

    //metodos bicicleta
    public List<Bicicleta> listaBicicleta(Long idCliente) {
        Cliente clienteEncontrado = busca(idCliente);
        if (clienteEncontrado != null) {
            return clienteEncontrado.getBicicletas();
        }
        return null;
    }

    public Bicicleta buscaBicicleta(Long idCliente, Long id) {
        Cliente clienteEncontrado = busca(idCliente);
        if (clienteEncontrado != null) {
            for (Bicicleta bicicleta:clienteEncontrado.getBicicletas()) {
                if (bicicleta.getId().equals(id)) {
                    return bicicleta;
                }
            }
        }
        return null;
    }

    @Transactional
    public Bicicleta adicionaBicicleta(Long idCliente, Bicicleta bicicleta) {
        Cliente clienteEncontrado = busca(idCliente);
        if (clienteEncontrado != null) {
            bicicleta.setId(null);
            Bicicleta nova = bicicletaRepository.save(bicicleta);
            clienteEncontrado.adicionaBicicleta(bicicleta);
            clienteRepository.save(clienteEncontrado);
            return nova;
        }
        return null;
    }

    public Bicicleta atualizaBicicleta(Long idCliente, Bicicleta bicicleta) {
        Cliente clienteEncontrado = busca(idCliente);
        if (clienteEncontrado != null) {
            if (bicicleta.getId() != null) {
                for (Bicicleta item:clienteEncontrado.getBicicletas()) {
                    if (item.getId().equals(bicicleta.getId())) {
                        return bicicletaRepository.save(bicicleta);
                    }
                }
            }
        }
        return null;
    }

    public void removeBicicleta(Long idCliente, Long id) {
        Cliente clienteEncontrado = busca(idCliente);
        if (clienteEncontrado != null) {
            for (Bicicleta item:clienteEncontrado.getBicicletas()) {
                if (item.getId().equals(id)) {
                    bicicletaRepository.deleteById(id);
                }
            }
        }
    }

}
