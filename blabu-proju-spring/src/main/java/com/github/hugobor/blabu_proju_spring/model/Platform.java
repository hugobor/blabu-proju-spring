package com.github.hugobor.blabu_proju_spring.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;

/**
 * Plataforma de jogos.
 * Computador (Steam, GOG, Game Pass, Itchi.io), Consoles (SNES, Mega Drive, Playstation), Portáteis (GameBoy, WonderSwan),
 * Pc Retrô (Aminga, Mac Clássio, DOS).
 */
@Entity
@Table(indexes = @Index(name = "platform_idx_simple_name", columnList = "simpleName"))
public class Platform {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	/**
	 * Nome simples “simbólico”.
	 * Ex.: snes → Super Nintendo
	 *  mega-drive → Mega Drive
	 *  ps2 → PlayStation 2
	 * Usado como chave secundário, para facilitar consultas.
	 */
	@Column(unique = true, nullable = false)
	private String simpleName;
	
	private String name;
	
	/**
	 * Computador, Console, Portátil, Computador Retro, etc…
	 * TODO Talvés seja melhor eu criar um enum para isso.
	 */
	private String type;


	public String getSimpleName() {	return simpleName; }
	public void setSimpleName(String simpleName) { this.simpleName = simpleName; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public String getType() { return type; }
	public void setType(String type) { this.type = type; }

	public Long getId() { return id; }
	
	
	public Platform(String simpleName, String name, String type) {
		super();
		this.simpleName = simpleName;
		this.name = name;
		this.type = type;
	}
	
	public Platform() {
		super();
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Platform [id=").append(id).append(", simpleName=").append(simpleName).append(", name=")
				.append(name).append(", type=").append(type).append("]");
		return builder.toString();
	}
	
	
	
}
