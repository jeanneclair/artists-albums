package org.wecancodeit.artistsalbums;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AlbumComment {
	
	@Id
	@GeneratedValue
	private Long id;
	private String text;
	
	@ManyToOne
	private Album album;

	public AlbumComment(String text, Album album) {
		this.text = text;
		this.album = album;
	}
	
	public AlbumComment() {
		
	}

	public Long getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public Album getAlbum() {
		return album;
	}

	@Override
	public String toString() {
		return "AlbumComment [id=" + id + ", text=" + text + ", album=" + album + "]";
	}
	
	

}
