package org.wecancodeit.artistsalbums;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
	
//	Song findByName (String songName);

}
