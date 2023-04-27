package org.howard.edu.lsp.Final.problem;



public class SongsDatabase {
	/* Key is the genre, HashSet contains associated songs */
	private Map<String, HashSet<String>> map = 
			new HashMap<String, HashSet<String>>();

		/* Add a song title to a genre */
	public void addSong(String genre, String songTitle) {
			//Code it!!
		}

	/* Return the Set that contains all songs for a genre */
	public Set<String> getSongs(String genre) {
			// Code it!!
	}

	/* Return genre, i.e., jazz, given a song title */
	public String getGenreOfSong(String songTitle) {
			// Code it!!
	}

}
