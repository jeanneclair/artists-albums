package org.wecancodeit.artistsalbums;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Album {

	@Id
	@GeneratedValue
	private Long id;
	private String albumName;
	private String albumReleaseDate;
	
	private String albumGenre;
	private String albumCoverImage;
	
//	@JsonIgnore
	@OneToMany(mappedBy = "album")
	private Collection<Song> songs;
	
	@JsonIgnore
	@ManyToOne
	private Artist artist;
	
	@JsonIgnore
	@OneToMany(mappedBy = "album")
	private Collection<AlbumComment> albumComments;
	
	public Album(String albumName, String albumReleaseDate, String albumGenre, String albumCoverImage, Artist artist) {
		this.albumName = albumName;
		this.albumReleaseDate = albumReleaseDate;
		this.songs = songs;
		this.albumGenre = albumGenre;
		this.albumCoverImage = albumCoverImage;
		this.artist = artist;
	}
	
	public Album() {
		
	}

	public Long getId() {
		return id;
	}

	public String getAlbumName() {
		return albumName;
	}

	public String getAlbumReleaseDate() {
		return albumReleaseDate;
	}

	public Collection<Song> getSongs() {
		return songs;
	}

	public String getAlbumGenre() {
		return albumGenre;
	}

	public String getAlbumCoverImage() {
		return albumCoverImage;
	}

	public Collection<AlbumComment> getAlbumComments() {
		return albumComments;
	}

	public Artist getArtist() {
		return artist;
	}
	
	
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public void setAlbumReleaseDate(String albumReleaseDate) {
		this.albumReleaseDate = albumReleaseDate;
	}

	public void setAlbumGenre(String albumGenre) {
		this.albumGenre = albumGenre;
	}

	public void setAlbumCoverImage(String albumCoverImage) {
		this.albumCoverImage = albumCoverImage;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	@Override
	public String toString() {
		return "Album [id=" + id + ", albumName=" + albumName + ", albumReleaseDate=" + albumReleaseDate + ", songs="
				+ songs + ", albumGenre=" + albumGenre + ", albumCoverImage=" + albumCoverImage + "]";
	}
	
	
	
}


