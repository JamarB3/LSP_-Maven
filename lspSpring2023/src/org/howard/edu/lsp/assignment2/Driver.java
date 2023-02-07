/* 
*Name: Jamar Bailey III
*/


package org.howard.edu.lsp.assignment2;

import java.io.FileNotFoundException;

public class Driver {
	public static void main(String[] args) {
		FileReader fr = new FileReader();
		try {
			fr.readString("main/java/words.txt");
			//System.out.println(fr.readString("main/java/words.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Unable to open resource");
		}
	}
}