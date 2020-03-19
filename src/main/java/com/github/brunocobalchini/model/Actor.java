package com.github.brunocobalchini.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Actor")
public class Actor { //Endpoint: /Actor - GET // Saida: {"id": " ", "name": " ", birth: 00/00/00, ["castActor": " ", " "]}
	
	@Id
	@Column(name = "actorId", nullable = false)
	private String id; // EndPoint: /Actor/partId |POST- {"id": "abx0128"} 
	//EndPoint: /Actor/partId  - GET // Saida: {"actorId": "abx0128", "name": " ", birthDate: 00/00/00}

	@Column
	private	String name; // EndPoint: /Actor/name |POST- {"name": "John"} 
	//EndPoint: /Actor/name - GET // Saida: {"actorId": " ", "name": "John"}

	@Column(name =  "birth")
	private	LocalDate birthDate;	// EndPoint: /Actor/birth |POST- {"birth": "10/11/12"} 
	//EndPoint: /Actor/birth - GET // Saida: {"actorId": " ", "birth": "00/00/00"}
	
	@OneToMany 
	@Column(name = "castActor")
	private List<Participation> cast = new ArrayList<Participation>(); // EndPoint: /Actor/castActor |POST- [{"castActor": "Laura", "Mark"}]
	//EndPoint: /Actor/castActor - GET // Saida: {"actorId": " ", ["castActor": "Laura", "Mark"]}
	
	
	public List<Participation> getCast() {
		return cast;
	}
	public void setCast(List<Participation> cast) {
		this.cast = cast;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
}