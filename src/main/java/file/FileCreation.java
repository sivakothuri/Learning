package file;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileCreation {
	public static void main(String[] args) throws IOException {

		Path path = Paths.get("myfile.txt");
		if (Files.notExists(path)) {
			Files.createFile(path);
			System.out.println("New file \"myfile.txt\" has been created   to the current directory");
		}
	}
}
