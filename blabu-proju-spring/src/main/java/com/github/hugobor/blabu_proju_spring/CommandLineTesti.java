package com.github.hugobor.blabu_proju_spring;

import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.hugobor.blabu_proju_spring.model.Game;
import com.github.hugobor.blabu_proju_spring.model.GameRepository;
import com.github.hugobor.blabu_proju_spring.model.Platform;
import com.github.hugobor.blabu_proju_spring.model.PlatformRepository;
import com.github.hugobor.blabu_proju_spring.model.PlayState;


@Component
public class CommandLineTesti implements CommandLineRunner {
	
	@Autowired
	private PlatformRepository platformRepository;
	
	@Autowired
	private GameRepository gameRepository;

	@Override
	public void run(String... args) throws Exception {
		Consumer<Object> p = System.out::println;
		
		p.accept("EU EXISTO!!!!!!!!! EU EXISTI!!!!!!!!!");
		p.accept("como lágrimas na chuva...........");
		
		var repo = platformRepository;
		
		var plats = List.of(
			new Platform("mega-drive", "Mega Drive", "Console"),
			new Platform("snes", "Super Nintendo", "Console"),
			new Platform("pc", "Computador PC", "Computador"),
			new Platform("ps1", "PlayStation 1", "Console"),
			new Platform("nds", "Nintendo DS", "Portátil"),
			new Platform("msx", "MSX", "Computador")
		);
		repo.saveAll(plats);
		
		var megaDrive = plats.get(0);
		var snes = plats.get(1);
		var pc = plats.get(2);
		var ps1 = plats.get(3);
		var nds = plats.get(4);
		//var msx = plats.get(5);
		
		
		
		p.accept(plats);
		p.accept(repo.findBySimpleName("mega-drive"));
		p.accept(repo.findBySimpleName("ps1"));
		p.accept(repo.findBySimpleName("não-existo-ERRO!!!"));
		
		var msx = repo.findBySimpleName("msx").get();
		msx.setType("Computador Retrô");
		repo.save(msx);
		
		p.accept(repo.findAll());
		
		var games = List.of(
				new Game("Magical Pop'n", "Platformer, Side-Scroller, MetroidVania, Action, Adventure", 1995, 5, "ROM", PlayState.FINISHED, snes), 
				new Game("Blood", "FPS, Action, Retro FPS, First Person", 1997, null, "Digital", PlayState.RETIRED, pc),
				new Game("Half-Life 2", "FPS, Action, First Person", 2004, 5, "Digital", PlayState.COMPLETED, pc),
				new Game("BioShock", "FPS, Action, Imersive Sim, First Person", 2007, 5, "DVD", PlayState.FINISHED, pc),
				new Game("Sonic the Hedgehog 3 & Knuckles", "Platformer, Side-Scroller, Action", 1997, 5, "Cartrigde", PlayState.FINISHED, megaDrive),
				new Game("King's Field", "Action RPG, RPG, Adventure, Action, First Person", 1994, null, "ROM", PlayState.PLAYING, ps1)
			);
		
		var rgm = gameRepository;
		
		rgm.saveAll(games);
		
		var mineirinho = new Game("Mineirinho Ultra Adventures", "Kusoge", null, 0, "Digital");
		rgm.save(mineirinho);
	}
	

}
