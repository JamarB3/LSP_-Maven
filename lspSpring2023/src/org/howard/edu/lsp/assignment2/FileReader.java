/**
 * Name: Jamar Bailey III
 */


package org.howard.edu.lsp.assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

import java.util. *; 
public class FileReader {
	public String readString(String resource) throws FileNotFoundException {
		URL url = getClass().getClassLoader().getResource(resource);
		Hashtable<String, Integer> word_counter = new Hashtable<String, Integer>(); // Creates new Hashtable, which will hold values
		if (url != null) {
			File file = new File(url.getPath());
			
			Scanner MyObj = null;
			MyObj = new Scanner(file);
			String word = "";
			while (MyObj.hasNext()) { //Gets each next word accordingly
				word = MyObj.next();
				if (word.length() > 3 && !word.matches("^[0-9]+$") && !word.matches("^[^a-zA-Z0-9]+$")) {
					word = word.toLowerCase(); //Above line filters out words with 3 letters or less, special characters, and integers
					if (word_counter.containsKey(word));
						word_counter.put(word, word_counter.getOrDefault(word, 0) + 1); //Places word, in lower case, into hash table.
					    //If it is already in the hash table, one is added to the value.
				} else {
					continue;
				}
			}
			MyObj.close();
			// Code below will print out the word as well as their associated count
			for (Map.Entry<String,Integer> entry: word_counter.entrySet())
				System.out.println(entry.getKey() + " " + entry.getValue());
			
		}
		throw new FileNotFoundException();
	}
}