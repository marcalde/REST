package com.rest.examples.prenotazione.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PrenotazioneMapper implements RowMapper<Prenotazione> {

	@Override
	public Prenotazione mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Long id = rs.getLong("id");
		String name = rs.getString("name");
		String surname = rs.getString("surname");
		String email = rs.getString("email");
		int age = rs.getInt("age");
		
		return new Prenotazione(id, name, surname, email, age);
	}

}
