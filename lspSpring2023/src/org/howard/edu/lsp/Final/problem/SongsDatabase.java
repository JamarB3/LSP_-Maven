package org.howard.edu.lsp.Final.problem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class SongsDatabase {
	/* Key is the genre, HashSet contains associated songs */
	private Map<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();

	/* Add a song title to a genre */
	public void addSong(String genre, String songTitle) {
		// Add the song to the set of songs associated with given genre.
        // If the genre doesn't exist in the map, new set is created for it
		if (!map.containsKey(genre)) {
            map.put(genre, new HashSet<String>());
        }
        map.get(genre).add(songTitle);
    }
	/* Return the Set that contains all songs for a genre */
	public Set<String> getSongs(String genre) {
		// Return the set of songs associated with given genre
        // Or return an empty set if the genre doesn't exist in the map
		if (!map.containsKey(genre)) {
            return new HashSet<String>();
        }
        return new HashSet<String>(map.get(genre));
	}

	/* Return genre, i.e., jazz, given a song title */
	public String getGenreOfSong(String songTitle) {
		// Loop over each entry in the map and check if the set of songs within a genre have a song title
        // If found, return the current genre
		for (String genre : map.keySet()) {
            if (map.get(genre).contains(songTitle)) {
                return genre;
            }
        }
		// If the song title is not found, return null.
        return null;
    }

}
