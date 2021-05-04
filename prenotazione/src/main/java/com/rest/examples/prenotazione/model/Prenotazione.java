package com.rest.examples.prenotazione.model;


public class Prenotazione {
	
	private long id;
	private String name;
	private String surname;
	private int age;
	private String email;
	
	Prenotazione(){}
	
	public Prenotazione(long id, String name, String surname, String email, int age){
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.age = age;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return name;
	}

	public void setNome(String name) {
		this.name = name;
	}

	public String getCognome() {
		return surname;
	}

	public void setCognome(String surname) {
		this.surname = surname;
	}

	public int getEta() {
		return age;
	}

	public void setEta(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

}
