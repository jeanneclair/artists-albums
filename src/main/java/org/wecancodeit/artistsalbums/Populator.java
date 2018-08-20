package org.wecancodeit.artistsalbums;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

//@Service
public class Populator implements CommandLineRunner {
	
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
	
	@Override
	public void run(String... args) throws Exception {
		
		Artist radiohead = artistRepo.save(new Artist("Radiohead", "XL Recordings"));
		Artist avettBrothers = artistRepo.save(new Artist("The Avett Brothers", "American Recordings"));
		
		Album bends = albumRepo.save(new Album("The Bends", "March 13, 1995", "Progressive Rock", "https://upload.wikimedia.org/wikipedia/en/thumb/8/8b/Radiohead.bends.albumart.jpg/220px-Radiohead.bends.albumart.jpg", radiohead));
		Album love = albumRepo.save(new Album("I and Love and You", "June 24, 2009", "American Fold Rock", "https://upload.wikimedia.org/wikipedia/en/thumb/c/c2/IandLoveandYou.jpg/220px-IandLoveandYou.jpg", avettBrothers));

		AlbumComment testAlbumComment1 = albumCommentRepo.save(new AlbumComment("I'm going to see them perform on Monday!", bends));
		AlbumComment testAlbumComment2 = albumCommentRepo.save(new AlbumComment("I've seen them perform three times!", love));
		
		Song highAndDry = songRepo.save(new Song("High And Dry", "4:17", "Two jumps in a week\r\n" + 
				"I bet you think that's pretty clever, don't you boy?\r\n" + 
				"Flying on your motorcycle\r\n" + 
				"Watching all the ground beneath you drop\r\n" + 
				"Kill yourself for recognition\r\n" + 
				"Kill yourself to never ever stop\r\n" + 
				"You broke another mirror\r\n" + 
				"You're turning into something you are not\r\n" + 
				"Don't leave me high\r\n" + 
				"Don't leave me dry\r\n" + 
				"Don't leave me high\r\n" + 
				"Don't leave me dry\r\n" + 
				"Drying up in conversation\r\n" + 
				"You will be the one who cannot talk\r\n" + 
				"All your insides fall to pieces\r\n" + 
				"You just sit there wishing you could still make love\r\n" + 
				"They're the ones who'll hate you\r\n" + 
				"When you think you've got the world all sussed out\r\n" + 
				"They're the once who'll spit at you\r\n" + 
				"You'll be the one screaming out\r\n" + 
				"Don't leave me high\r\n" + 
				"Don't leave me dry\r\n" + 
				"Don't leave me high\r\n" + 
				"Don't leave me dry\r\n" + 
				"Oh, it's the best thing that you ever had\r\n" + 
				"The best thing you ever, ever had\r\n" + 
				"It's the best thing that you ever had\r\n" + 
				"The best thing you have had is gone away\r\n" + 
				"D-don't leave me high\r\n" + 
				"Don't leave me dry\r\n" + 
				"Don't leave me high\r\n" + 
				"Don't leave me dry\r\n" + 
				"Don't leave me high\r\n" + 
				"Don't leave me high\r\n" + 
				"Don't leave me dry", "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/f4BE8lTSHFg\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>", "5/5", bends));
		Song ironLung = songRepo.save(new Song("My Iron Lung", "4:15", "Faith, you're driving me away\r\n" + 
				"You do it everyday\r\n" + 
				"You don't mean it but it hurts like hell\r\n" + 
				"My brain says I'm receiving pain\r\n" + 
				"A lack of oxygen from my life support\r\n" + 
				"My iron lung\r\n" + 
				"We're too young to fall asleep\r\n" + 
				"Too cynical to speak\r\n" + 
				"We are loosing it, can't you tell?\r\n" + 
				"We scratch our eternal itch\r\n" + 
				"Our twentieth century bitch and we are grateful for our\r\n" + 
				"Iron lung\r\n" + 
				"Suck, suck your teenage thumb\r\n" + 
				"Toilet trained and dumb\r\n" + 
				"When the power runs out we'll just hum\r\n" + 
				"This this is our new song\r\n" + 
				"Just like the last one\r\n" + 
				"A total waste of time\r\n" + 
				"My iron lung\r\n" + 
				"If you're frightened\r\n" + 
				"You can be frightened\r\n" + 
				"You can be, it's okay\r\n" + 
				"If you're frightened\r\n" + 
				"You can be frightened\r\n" + 
				"You can be, it's okay", "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/pRU-6vaKaf4\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>", "5/5", bends));
		Song spread = songRepo.save(new Song("And It Spread", "4:07", "There was light in the room\r\n" + 
				"Then you left and it was through\r\n" + 
				"Then the frost started in\r\n" + 
				"My toes and fingertips\r\n" + 
				"And it spread\r\n" + 
				"And it spread into my heart\r\n" + 
				"And it spread\r\n" + 
				"And it spread into my heart\r\n" + 
				"Then for I don't know how long\r\n" + 
				"I settled in to doing wrong\r\n" + 
				"And as the wind fills the sail\r\n" + 
				"Came the thought to hurt my self\r\n" + 
				"Come on,\r\n" + 
				"And it spread\r\n" + 
				"And it spread into my home\r\n" + 
				"And it spread\r\n" + 
				"And it spread into my soul\r\n" + 
				"Well there are no lines\r\n" + 
				"Separating the truth from the lie\r\n" + 
				"Then you came back from space\r\n" + 
				"With a brand new laugh and a different space\r\n" + 
				"You took my hand and held it up\r\n" + 
				"And shot my arm full of love\r\n" + 
				"And it spread\r\n" + 
				"And it spread into the world\r\n" + 
				"And it spread, ooh\r\n" + 
				"And it spread into the world\r\n" + 
				"Well there are no lines\r\n" + 
				"Separating the truth from the lie", "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/YlM93MlV-iE\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>", "5/5", love));
		Song laundry = songRepo.save(new Song("Laundry Room", "4:51", "Don't push me out\r\n" + 
				"Just a little longer\r\n" + 
				"Stall your mother\r\n" + 
				"Disregard your father's words\r\n" + 
				"Close the laundry door\r\n" + 
				"Tiptoe across the floor\r\n" + 
				"Keep your clothes on\r\n" + 
				"I've got all that I can take\r\n" + 
				"Teach me how to use\r\n" + 
				"The love that people say you made\r\n" + 
				"(Teach me how to use)\r\n" + 
				"(The love that people say you made)\r\n" + 
				"Stop your parents' car\r\n" + 
				"I just saw a shooting star\r\n" + 
				"We can wish upon it\r\n" + 
				"We won't share the wish we made\r\n" + 
				"But I can't keep no secrets\r\n" + 
				"I wish that you would always stay\r\n" + 
				"Last night I dreamt the whole night long\r\n" + 
				"I woke with a head full of songs\r\n" + 
				"I spent the whole day\r\n" + 
				"I wrote 'em down, but it's a shame\r\n" + 
				"(Teach me how to use, teach me how to use) \r\n" + 
				"Tonight I'll burn the lyrics\r\n" + 
				"'Cause every chorus was your name\r\n" + 
				"(Teach me how to use, teach me how to use)\r\n" + 
				"Break this tired old routine\r\n" + 
				"(Break this tired old routine)\r\n" + 
				"And this time don't make me leave\r\n" + 
				"(And this time don't make me leave)\r\n" + 
				"I am a breathing time machine\r\n" + 
				"(I am a breathing time machine)\r\n" + 
				"I'll take you all for a ride\r\n" + 
				"(I'll take you all)\r\n" + 
				"I am a breathing time machine\r\n" + 
				"(I am a breathing time machine)\r\n" + 
				"I'll take you all for a ride\r\n" + 
				"(I'll take you all for a ride)\r\n" + 
				"Break this tired old routine\r\n" + 
				"(I am a breathing time machine)\r\n" + 
				"And this time don't make me leave\r\n" + 
				"(Leave)", "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/a7pXk9Q8TTU\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>", "5/5", love));
		
		
		SongComment testSongComment1 = songCommentRepo.save(new SongComment("Such a beautifully sad song.", highAndDry));
		SongComment testSongComment2 = songCommentRepo.save(new SongComment("It's all about love.", spread));

		
		
	}

}
