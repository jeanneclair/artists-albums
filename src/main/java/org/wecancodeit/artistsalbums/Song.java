package org.wecancodeit.artistsalbums;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Song {
	
	@Id
	@GeneratedValue
	private Long id;
	private String songName;
	private String songLength;
	@Lob
	private String songLyrics;
	private String songVideoUrl;
	private String songRating;
	
	@JsonIgnore
	@ManyToOne
	private Album album;
	
	@JsonIgnore
	@OneToMany(mappedBy = "song")
	private Collection<SongComment> songComments;
	
	public Song(String songName, String songLength, String songLyrics, String songVideoUrl, String songRating, Album album) {
		this.songName = songName;
		this.songLength = songLength;
		this.songLyrics = songLyrics;
		this.songVideoUrl = songVideoUrl;
		this.songRating = songRating;
		this.album = album;
	}
	
	public Song() {
		
	}

	public Long getId() {
		return id;
	}

	public String getSongName() {
		return songName;
	}

	public String getSongLength() {
		return songLength;
	}

	public String getSongLyrics() {
		return songLyrics;
	}

	public String getSongVideoUrl() {
		return songVideoUrl;
	}

	public String getSongRating() {
		return songRating;
	}

	
	public Collection<SongComment> getSongComments() {
		return songComments;
	}
	

	public Album getAlbum() {
		return album;
	}
	

	public void setId(Long id) {
		this.id = id;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public void setSongLength(String songLength) {
		this.songLength = songLength;
	}

	public void setSongLyrics(String songLyrics) {
		this.songLyrics = songLyrics;
	}

	public void setSongVideoUrl(String songVideoUrl) {
		this.songVideoUrl = songVideoUrl;
	}

	public void setSongRating(String songRating) {
		this.songRating = songRating;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public void setSongComments(Collection<SongComment> songComments) {
		this.songComments = songComments;
	}

	@Override
	public String toString() {
		return "Song [id=" + id + ", songName=" + songName + ", songLength=" + songLength + ", songLyrics=" + songLyrics
				+ ", songVideoUrl=" + songVideoUrl + ", songRating=" + songRating + "]";
	}
	
	
	
	
	
}
