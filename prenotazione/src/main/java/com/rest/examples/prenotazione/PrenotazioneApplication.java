package com.rest.examples.prenotazione;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@SpringBootApplication
public class PrenotazioneApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrenotazioneApplication.class, args);

	}

	
}
