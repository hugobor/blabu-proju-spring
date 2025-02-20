package com.github.hugobor.blabu_proju_spring.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.github.hugobor.blabu_proju_spring.model.Game;
import com.github.hugobor.blabu_proju_spring.model.GameRepository;
import com.github.hugobor.blabu_proju_spring.model.PlatformRepository;
import com.github.hugobor.blabu_proju_spring.model.PlayState;

@RestController
@RequestMapping("/games")
public class GameController {
	
	@Autowired
	private PlatformRepository platformRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	
	@GetMapping("")
	public List<Game> games() {
		return (List<Game>) gameRepository.findAll(); 
	}
	
	@GetMapping("/{id}")
	public Optional<Game> games(@PathVariable("id") Long id) {
		return gameRepository.findById(id);
	}
	
	@GetMapping("/genre/{genre}")
	public List<Game> gamesWithGenre(@PathVariable("genre") String genre) {
		return gameRepository.findAllByGenreContainsIgnoreCase(genre);
	}
	
	@GetMapping("/alltitles/{title}")
	public List<Game> gamesWithTitle(@PathVariable String title) {
		return gameRepository.findAllByGenreContainsIgnoreCase(title);
	}
	
	@GetMapping("/title/{title}")
	public Optional<Game> firstGameWithTitle(@PathVariable("title") String title) {
		return gameRepository.findFirstByTitleContainsIgnoreCase(title);
	}
	
	@GetMapping("/favorites")
	public List<Game> favorites() {
		return gameRepository.findAllByFavoriteTrueOrderByScoreDesc();
	}
	
	@GetMapping("/best")
	public List<Game> bestGames() {
		return gameRepository.findAllByOrderByScoreDesc();
	}
	
	@GetMapping("/state/{state}")
	public List<Game> gamesWithState(@PathVariable("state") String state) {
		try {
			var pstate = PlayState.valueOf(state.strip().toUpperCase());
			return gameRepository.findAllByState(pstate);
		} catch (Exception ignore) {
			return List.of();
		}
	}
	
	@GetMapping("/state/valid-states")
	public List<String> validStates() {
		return List.of(PlayState.values()).stream().map(state -> state.toString().toLowerCase()).toList();
	}
	
	
	@PostMapping
	public ResponseEntity<Game> createGame(@RequestBody Game game) {
		var plat = game.getPlatform();
		if (plat != null) {
			if (plat.getSimpleName() != null) {
			platformRepository
				.findBySimpleName(plat.getSimpleName())
				.ifPresent(foundPlat -> game.setPlatform(foundPlat));
			} else if (plat.getId() != null) {
				platformRepository
					.findById(plat.getId())
					.ifPresent(foundPlat -> game.setPlatform(foundPlat));
			}
			platformRepository.save(game.getPlatform());
		}
		
				
		var createdGame = gameRepository.save(game);
		
		URI createdURI = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(createdGame.getId())
				.toUri();
		
		return ResponseEntity.created(createdURI).body(createdGame);
	}
}
