package com.github.hugobor.blabu_proju_spring.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GameRepository extends CrudRepository<Game, Long> {
	public List<Game> findAllByTitleContainsIgnoreCase(String title);
	public Optional<Game> findFirstByTitleContainsIgnoreCase(String title);
	
	public List<Game> findAllByTitleContains(String title);
	public Optional<Game> findFirstByTitleContains(String title);	
	
	public List<Game> findAllByGenreContainsIgnoreCase(String genre);
	
	public List<Game> findAllByOrderByScoreDesc();
	public List<Game> findAllByFavoriteTrueOrderByScoreDesc();
	
	public List<Game> findAllByState(PlayState playState);
}
