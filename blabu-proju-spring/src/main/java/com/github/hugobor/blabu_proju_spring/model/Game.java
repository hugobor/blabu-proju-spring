package com.github.hugobor.blabu_proju_spring.model;

import java.util.Optional;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;


@Entity
@Table(indexes = {
		@Index(name = "game_idx_name", columnList = "name"),
//		@Index(name = "game_idx_genre", columnList = "genre")
})
public class Game {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	
	@Column(nullable = false)
	public String name;
	
	public String genre;
	public Integer score;
	public String tipoMidia;
	
	public Game() {
		super();
	}
	
	public Game(String name, String genre, Integer score, String tipoMidia) {
		super();
		this.name = name;
		this.genre = genre;
		this.score = score;
		this.tipoMidia = tipoMidia;
	}

	
	
}
