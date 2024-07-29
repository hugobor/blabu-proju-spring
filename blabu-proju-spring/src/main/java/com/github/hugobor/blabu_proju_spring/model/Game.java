package com.github.hugobor.blabu_proju_spring.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(indexes = {
		@Index(name = "game_idx_title", columnList = "title"),
		@Index(name = "game_idx_genre", columnList = "genre")
})
public class Game {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String title;
	
	private String genre;
	private Integer releaseDate;
	private Integer score;
	private String mediaType;
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "varchar(255) default 'NOT_PLAYING'")
	private PlayState state = PlayState.NOT_PLAYING;
	// https://www.baeldung.com/jpa-persisting-enums-in-jpa
	// https://www.baeldung.com/jpa-default-column-values
	
	@ManyToOne(fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.SET_NULL)
	private Platform platform;
	
	
	public Game() {
		super();
	}

	public Game(String title, String genre, Integer releaseDate, Integer score, String mediaType) {
		super();
		this.title = title;
		this.genre = genre;
		this.releaseDate = releaseDate;
		this.score = score;
		this.mediaType = mediaType;
	}

	public Game(String title, String genre, Integer releaseDate, Integer score, String mediaType, PlayState state) {
		this(title, genre, releaseDate, score, mediaType);
		this.state = state;
	}
	
	

	
	public Game(String title, String genre, Integer releaseDate, Integer score, String mediaType, PlayState state,
			Platform platform) {
		this(title, genre, releaseDate, score, mediaType, state);
		this.platform = platform;
	}

	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }

	public String getGenre() { return genre; }
	public void setGenre(String genre) { this.genre = genre; }

	public Integer getReleaseDate() { return releaseDate; }
	public void setReleaseDate(Integer releaseDate) { this.releaseDate = releaseDate; }

	public Integer getScore() {	return score; }
	public void setScore(Integer score) { this.score = score; }

	public String getMediaType() { return mediaType; }
	public void setMediaType(String mediaType) { this.mediaType = mediaType; }

	public PlayState getState() { return state; }
	public void setState(PlayState state) { this.state = state; }
	
	public Platform getPlatform() { return platform; }
	public void setPlatform(Platform platform) { this.platform = platform; }

	public Long getId() { return id; }

	@Override
	public String toString() {
		var builder = new StringBuilder();
		builder
			.append("Game [id=").append(id)
			.append(", title=").append(title)
			.append(", genre=").append(genre)
			.append(", releaseDate=").append(releaseDate)
			.append(", platform=").append(platform != null ? platform.getSimpleName() : null)
			.append(", score=").append(score)
			.append(", mediaType=").append(mediaType)
			.append(", state=").append(state).append("]");
		return builder.toString();
	}
	
}
