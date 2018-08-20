package org.wecancodeit.artistsalbums;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Artist {

	@Id
	@GeneratedValue
	private Long id;
	private String artistName;
	private String artistRecordLabel;
	
	@JsonIgnore
	@OneToMany(mappedBy = "artist")
	private Collection<Album> albums;
	
	public Artist(String artistName, String artistRecordLabel) {
		this.artistName = artistName;
		this.artistRecordLabel = artistRecordLabel;
	}
	
	public Artist() {
		
	}

	public Long getId() {
		return id;
	}

	public String getArtistName() {
		return artistName;
	}

	public Collection<Album> getAlbums() {
		return albums;
	}

	public String getArtistRecordLabel() {
		return artistRecordLabel;
	}
	

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public void setArtistRecordLabel(String artistRecordLabel) {
		this.artistRecordLabel = artistRecordLabel;
	}

	@Override
	public String toString() {
		return "Artist [id=" + id + ", artistName=" + artistName + ", albums=" + albums + ", artistRecordLabel="
				+ artistRecordLabel + "]";
	}
	
	
	
}
