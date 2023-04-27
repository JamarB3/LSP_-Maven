package org.howard.edu.lsp.Final.problem;


import org.junit.jupiter.api.DisplayName;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import java.util.Set;
import org.junit.Before;


//JUnit test cases go here
public class SongsDatabaseTest {
	private SongsDatabase db;

	@Before
	public void setUp() throws Exception {
	    db = new SongsDatabase();
	}

	@Test
	@DisplayName("tests AddSong")
	public void testAddSong() {
	    // Test case 1: add song to existing genre
		SongsDatabase db = new SongsDatabase();
	    db.addSong("Rap", "Savage");
	    db.addSong("Rap", "Gin and Juice");
	    Set<String> rapSongs = db.getSongs("Rap");
	    assertTrue(rapSongs.contains("Savage"));
	    assertTrue(rapSongs.contains("Gin and Juice"));

	    // Test case 2: add song to new genre
	    db.addSong("Pop", "Shallow");
	    Set<String> popSongs = db.getSongs("Pop");
	    assertTrue(popSongs.contains("Shallow"));
	}

	@Test
	@DisplayName("tests GetSongs")
	public void testGetSongs() {
	    // Test case 1: get songs for existing genre
		SongsDatabase db = new SongsDatabase();
	    db.addSong("Rock", "Bohemian Rhapsody");
	    db.addSong("Rock", "Stairway to Heaven");
	    Set<String> rockSongs = db.getSongs("Rock");
	    assertEquals(2, rockSongs.size());
	    assertTrue(rockSongs.contains("Bohemian Rhapsody"));
	    assertTrue(rockSongs.contains("Stairway to Heaven"));

	    // Test case 2: get songs for non-existent genre
	    Set<String> jazzSongs = db.getSongs("Jazz");
	    assertTrue(jazzSongs.isEmpty());
	}

	@Test
	@DisplayName("tests GetGenreOfSong")
	public void testGetGenreOfSong() {
	    // Test case 1: get genre for existing song
		SongsDatabase db = new SongsDatabase();
	    db.addSong("Hip Hop", "Lose Yourself");
	    String genre = db.getGenreOfSong("Lose Yourself");
	    assertEquals("Hip Hop", genre);

	    // Test case 2: get genre for non-existent song
	    String nonExistentGenre = db.getGenreOfSong("Hotel California");
	    assertNull(nonExistentGenre);
	}

}
