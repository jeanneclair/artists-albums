package org.wecancodeit.artistsalbums;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	SongCommentRepository songCommentRepo;
	
	@Autowired
	SongRepository songRepo;
	
	@Autowired
	AlbumRepository albumRepo;
	
	@Autowired
	AlbumCommentRepository albumCommentRepo;
	
	@Autowired
	ArtistRepository artistRepo;
	
	@RequestMapping("/songs")
	public Iterable<Song> getSongs() {
		return songRepo.findAll();
	}
	
	@RequestMapping(value = "/songs/{songId}", method = RequestMethod.GET)
	public Song returnSong(@PathVariable(name = "songId") String songId) {
	
		return songRepo.findOne((Long.parseLong(songId)));
	}
	
	//for editing artist
	@RequestMapping(value = "artist/{id}", method = RequestMethod.GET)
	public Artist returnArtist(@PathVariable(name = "id") Long artistId) {
		
		return artistRepo.findOne(artistId);
	}
	
	//for editing album
	@RequestMapping(value = "artist/{id}/album/{albumId}", method = RequestMethod.GET)
	public Album returnAlbum(@PathVariable(name = "id") Long artistId,
								@PathVariable(name = "albumId") Long albumId) {
		
		
		return albumRepo.findOne(albumId);
	}
	
	
	@RequestMapping(value = "/songs/{songId}", method = RequestMethod.POST)
	public Collection<SongComment> addSongComment(@RequestParam(value = "songCommentInput") String songCommentInput,
												@PathVariable(name = "songId") String songId) {

			songCommentRepo.save(new SongComment(songCommentInput, songRepo.findOne(Long.parseLong(songId))));
			Collection<SongComment> songComment = songRepo.findOne(Long.parseLong(songId)).getSongComments();

		return songComment;
	}
	
	@RequestMapping(value = "/albums/{albumId}", method = RequestMethod.POST)
	public Collection<AlbumComment> addAlbumComment(@RequestParam(value = "albumCommentInput") String albumCommentInput,
												@PathVariable(name = "albumId") String albumId) {

			albumCommentRepo.save(new AlbumComment(albumCommentInput, albumRepo.findOne(Long.parseLong(albumId))));
			Collection<AlbumComment> albumComment = albumRepo.findOne(Long.parseLong(albumId)).getAlbumComments();

		return albumComment;
	}
	
	//edit song lyrics
	@RequestMapping(value = "/songs/{songId}", method = RequestMethod.PUT)
	public Song editLyrics(@RequestParam(value = "songLyrics") String songLyrics,
							@RequestParam(value = "songName") String songName,
							@RequestParam(value = "songLength") String songLength,
							@RequestParam(value = "songRating") String songRating,
							@RequestParam(value = "songVideoUrl") String songVideoUrl,
							@RequestParam(value = "albumId") String albumId,
							@PathVariable (name = "songId") String songId) {
		
		Song songToEdit = songRepo.findOne(Long.parseLong(songId));
		songToEdit.setSongLyrics(songLyrics);
		songToEdit.setSongName(songName);
		songToEdit.setSongLength(songLength);
		songToEdit.setSongRating(songRating);
		songToEdit.setSongVideoUrl(songVideoUrl);
		songToEdit.setAlbum(albumRepo.findOne(Long.parseLong(albumId)));
		songToEdit = songRepo.save(songToEdit);
		
		return songRepo.findOne(Long.parseLong(songId));
		
	}
	//edit artist
	@RequestMapping(value = "/artist/{id}", method = RequestMethod.PUT)
	public Artist editArtist (@RequestParam(value = "artistName") String artistName,
								@RequestParam(value = "artistRecordLabel") String artistRecordLabel,
								@PathVariable(name = "id") Long artistId) {
		
		Artist artistToEdit = artistRepo.findOne(artistId);
		artistToEdit.setArtistName(artistName);
		artistToEdit.setArtistRecordLabel(artistRecordLabel);
		artistRepo.save(artistToEdit);
		
		return artistRepo.findOne(artistId);
	}
	
	//edit album
	@RequestMapping(value = "/artist/{id}/album/{albumId}", method = RequestMethod.PUT)
	public Album editAlbum (@RequestParam(value = "albumName") String albumName,
								@RequestParam(value = "albumCoverImage") String albumCoverImage,
								@RequestParam(value = "albumReleaseDate") String albumReleaseDate,
								@RequestParam(value = "albumGenre") String albumGenre,
								@PathVariable(name = "id") Long artistId,
								@PathVariable(name = "albumId") Long albumId) {
		
		Album albumToEdit = albumRepo.findOne(albumId);
		albumToEdit.setAlbumName(albumName);
		albumToEdit.setAlbumCoverImage(albumCoverImage);
		albumToEdit.setAlbumReleaseDate(albumReleaseDate);
		albumToEdit.setAlbumGenre(albumGenre);
		albumRepo.save(albumToEdit);
		
		return albumRepo.findOne(albumId);
		
	}
	
	@RequestMapping(value = "/artists", method = RequestMethod.POST)
	public Collection<Artist> addArtist(@RequestParam(value = "artistNameInput") String artistNameInput,
										@RequestParam(value = "artistRecordLabelInput") String artistRecordLabelInput) {
		
		artistRepo.save(new Artist(artistNameInput, artistRecordLabelInput));
		
		return (Collection<Artist>) artistRepo.findAll();
		
	}
	
	@RequestMapping(value = "/albums", method = RequestMethod.POST)
	public Collection<Album> addAlbum(@RequestParam (value = "artistId") Long artistId,
										@RequestParam(value = "albumNameInput") String albumNameInput,
										@RequestParam(value = "albumReleaseDateInput") String albumReleaseDateInput,
										@RequestParam(value = "albumGenreInput") String albumGenreInput,
										@RequestParam(value = "albumImageInput") String albumImageInput) {
		
		
		
		albumRepo.save(new Album(albumNameInput, albumReleaseDateInput, albumGenreInput, albumImageInput, artistRepo.findOne(artistId)));
		
		return (Collection<Album>) artistRepo.findOne(artistId).getAlbums();
	}
	
	@RequestMapping(value = "/albums/{id}/songs", method = RequestMethod.POST)
	public Collection<Song> addSong(@PathVariable (name = "id") Long albumId,
										@RequestParam(value = "songNameInput") String songNameInput,
										@RequestParam(value = "songLengthInput") String songLengthInput,
										@RequestParam(value = "songRatingInput") String songRatingInput,
										@RequestParam(value = "songVideoUrlInput") String songVideoUrlInput,
										@RequestParam(value = "songLyricsInput") String songLyricsInput){
		
		
		songRepo.save(new Song(songNameInput, songLengthInput, songLyricsInput, songVideoUrlInput, songRatingInput, albumRepo.findOne(albumId)));
				
		return (Collection<Song>) albumRepo.findOne(albumId).getSongs();
	}
	
	//delete song
	@RequestMapping(value = "/albums/{id}/songs/{songId}", method = RequestMethod.DELETE)
	public Collection<Song> deleteSong(@PathVariable(name = "id") Long albumId1,
										@PathVariable(name = "songId") Long songId) {
		
		songRepo.delete(songId);
		return (Collection<Song>) albumRepo.findOne(albumId1).getSongs();
				
	}
	
	//delete album
	@RequestMapping(value = "/artists/{artistId2}/albums/{id}", method = RequestMethod.DELETE)
	public Collection<Album> deleteAlbum(@PathVariable(name = "artistId2") Long artistId2,
											@PathVariable(name = "id") Long albumId2) {
		 for (Song song : albumRepo.findOne(albumId2).getSongs()) {
			 songRepo.delete(song);			
		}
		 albumRepo.delete(albumRepo.findOne(albumId2));
		 return artistRepo.findOne(artistId2).getAlbums();
	}
	
	//delete artist
	@RequestMapping(value = "/artists/{id}", method = RequestMethod.DELETE)
	public Collection<Artist> deleteArtist(@PathVariable(name = "id") Long artistId2) {
		
		for (Album album : artistRepo.findOne(artistId2).getAlbums()) {
			
			for (Song song : album.getSongs()) {
				songRepo.delete(song);
			}
			albumRepo.delete(album);			
		}
		artistRepo.delete(artistId2); 
		return (Collection<Artist>) artistRepo.findAll();
		
	}

	
}
