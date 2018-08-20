package org.wecancodeit.artistsalbums;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SongComment {
	
	@Id
	@GeneratedValue
	private Long id;
	private String text;
	
	@ManyToOne
	private Song song;

	public SongComment(String text, Song song) {
		this.text = text;
		this.song = song;
	}
	
	public SongComment() {
		
	}

	public Long getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public Song getSong() {
		return song;
	}

	@Override
	public String toString() {
		return "SongComment [id=" + id + ", text=" + text + ", song=" + song + "]";
	}
	
	

}
