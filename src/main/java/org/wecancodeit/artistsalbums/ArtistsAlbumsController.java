package org.wecancodeit.artistsalbums;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArtistsAlbumsController {

	@Autowired
	SongRepository songRepo;
	
	@Autowired
	AlbumRepository albumRepo;
	
	@Autowired
	ArtistRepository artistRepo;
	
	@Autowired
	SongCommentRepository songCommentRepo;
	
	@Autowired
	AlbumCommentRepository albumCommentRepo;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/artists")
	public String getArtists(Model model) {
		model.addAttribute("artists", artistRepo.findAll());
		return "artists";
	}
	
	@RequestMapping("/artists/{id}")
	public String getArtist(@PathVariable(name = "id") Long id, Model model) {
		model.addAttribute("artist", artistRepo.findOne(id));
		return "artist";

	}
	
	@RequestMapping("/artists/{artistId}/album/{id}")
	public String getAlbum(@PathVariable(name = "artistId") Long artistId, @PathVariable(name = "id") Long id, Model model) {
		model.addAttribute("album", albumRepo.findOne(id));
		return "album";

	}
	
	@RequestMapping("/artists/{artistId}/album/{albumId}/song/{id}")
	public String getSong(@PathVariable(name = "artistId") Long artistId,
							@PathVariable(name = "albumId") Long albumId,
							@PathVariable(name = "id") Long id, Model model) {
//		model.addAttribute("album", albumRepo.findOne(id));
		model.addAttribute("song", songRepo.findOne(id));
		return "song";

	}
}
