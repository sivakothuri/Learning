package file;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class IterateFolder {

	public static void main(String[] args) throws IOException {
		Path path = Paths.get(".");
		if (Files.isDirectory(path)) {

			Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
					if (attr.isRegularFile()) {
						System.out.println(file.toAbsolutePath());
					} else {
						System.out.format("Other: %s ", file);
					}
					return FileVisitResult.CONTINUE;
				}

			});
		}
	}

}
