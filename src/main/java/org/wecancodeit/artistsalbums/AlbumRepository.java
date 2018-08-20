package org.wecancodeit.artistsalbums;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Long> {
	
//	Album findByName(String albumName);

}
