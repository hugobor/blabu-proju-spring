package com.github.hugobor.blabu_proju_spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.hugobor.blabu_proju_spring.model.Platform;
import com.github.hugobor.blabu_proju_spring.model.PlatformRepository;


@Component
public class CommandLineTesti implements CommandLineRunner {
	
	@Autowired
	private PlatformRepository platformRepository;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("EU EXISTO!!!!!!!!! EU EXISTI!!!!!!!!!");
		System.out.println("como lágrimas na chuva...........");
		
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
		
		System.out.println(plats);
		System.out.println(repo.findBySimpleName("mega-drive"));
		System.out.println(repo.findBySimpleName("ps1"));
		System.out.println(repo.findBySimpleName("não-existo-ERRO!!!"));
		
		var msx = repo.findBySimpleName("msx").get();
		msx.setType("Computador Retrô");
		repo.save(msx);
		
		System.out.println(repo.findAll());
	}
	

}
