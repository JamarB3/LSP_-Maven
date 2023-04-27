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
    public void testAddSong() {
        // Test case 1: add song to existing genre
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
}
