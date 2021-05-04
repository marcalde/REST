package com.rest.examples.prenotazione.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class PrenotazioneRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public List<Prenotazione> findAll(){
		String selectAll = "select * from prenotazioni";
		return jdbcTemplate.query(selectAll, new PrenotazioneMapper());
	}
	
	public Prenotazione findById(long id) {
		String selectById = "select * from prenotazioni where id = ?";
		return jdbcTemplate.queryForObject(selectById, new PrenotazioneMapper(), id);
	}
	
	public Prenotazione create(Prenotazione prenotazione) {
		
		String insert = "insert into prenotazioni (name, surname, email, age) values (?,?,?,?)";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			
				PreparedStatement preparedStatement = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
				preparedStatement.setString(1, prenotazione.getNome());
				preparedStatement.setString(2, prenotazione.getCognome());
				preparedStatement.setString(3, prenotazione.getEmail());
				preparedStatement.setInt(4, prenotazione.getEta());
				
				return preparedStatement;
			}
		}, keyHolder);
		
		prenotazione.setId(keyHolder.getKey().longValue());	
		return prenotazione;
	}
	
}
