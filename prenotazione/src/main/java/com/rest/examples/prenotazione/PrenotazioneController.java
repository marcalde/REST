package com.rest.examples.prenotazione;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.jdbc.Driver;
import com.rest.examples.prenotazione.model.Prenotazione;
import com.rest.examples.prenotazione.model.PrenotazioneRepository;


@RestController
public class PrenotazioneController  {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	PrenotazioneRepository pr;

	List<Prenotazione> prenotazioni = new ArrayList<Prenotazione>();

	@PostMapping(path = "/API/prenotazione")
	ResponseEntity<String> prenota(@RequestParam Map<String, String> body){
		
		prenotazioni.add(new Prenotazione(1, body.get("name"), body.get("surname"), body.get("email"), Integer.parseInt(body.get("age"))));

		return ResponseEntity.status(HttpStatus.OK).body(prenotazioni.get(0).getNome()  +" prenotato in data: ");
	}

	@PostMapping("/API/prenot")
	Prenotazione registra(@RequestParam Map<String, String> body) {

		Prenotazione prenotazione = pr.create(new Prenotazione(1, body.get("name"), body.get("surname"), body.get("email"), Integer.parseInt(body.get("age"))));

		return prenotazione;
	}

	@GetMapping("/API/prenot/{id}")
	Prenotazione recupera(@PathVariable("id") Long id) {

		Prenotazione prenotazione = pr.findById(id);
		
		return prenotazione;
	}
	
	@GetMapping("/API/prenot/")
	List<Prenotazione> lista(){

		List<Prenotazione> list = pr.findAll();
		return list;
	}
	

}
