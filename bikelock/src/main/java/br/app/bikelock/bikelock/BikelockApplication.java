package br.app.bikelock.bikelock;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.app.bikelock.bikelock.model.Bicicleta;
import br.app.bikelock.bikelock.model.Cliente;
import br.app.bikelock.bikelock.model.TipoBicicleta;
import br.app.bikelock.bikelock.model.TipoQuadro;
import br.app.bikelock.bikelock.service.ClienteService;


@SpringBootApplication
public class BikelockApplication implements CommandLineRunner{

	@Autowired
	private ClienteService service;

	public static void main(String[] args) {
		SpringApplication.run(BikelockApplication.class, args);
	}

	@Transactional
	@Override
	public void run(String... args) throws Exception {

		Cliente c1 = new Cliente();
		c1.setNome("Fulano de Tal");
		c1.setEmail("fulano@gmail.com");
		c1.setMunicipio("Teresina");
		c1.setUf("PI");
		c1.setCpf("123.456.789-00");
		c1.setTelefone("(86) 3123-4567");
		service.adiciona(c1);

		Bicicleta b1 = new Bicicleta();
		b1.setNome("Fuscão Preto");
		b1.setMarca("Caloi");
		b1.setModelo("Barra circular");
		b1.setTipo(TipoBicicleta.TIPO1);
		b1.setTipoQuadro(TipoQuadro.QUADRO1);
		service.adicionaBicicleta(c1.getId(), b1);

		Bicicleta b2 = new Bicicleta();
		b2.setNome("Princesa");
		b2.setMarca("Caloi");
		b2.setModelo("Elite 10");
		b2.setTipo(TipoBicicleta.TIPO1);
		b2.setTipoQuadro(TipoQuadro.QUADRO2);
		service.adicionaBicicleta(c1.getId(), b2);

	}

}