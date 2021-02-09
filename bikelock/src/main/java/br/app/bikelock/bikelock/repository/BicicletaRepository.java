package br.app.bikelock.bikelock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.app.bikelock.bikelock.model.Bicicleta;

@Repository
public interface BicicletaRepository extends JpaRepository<Bicicleta, Long>{
    
}
