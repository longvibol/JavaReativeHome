package java_reactive_demo.home;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import reactor.core.publisher.Mono;

public class FileServiceHome {
	

	private static final Path PATH = Paths.get("src/main/resources");

	// Build Publiser ReadFile
	public static Mono<String> read(String fileName) {
		return Mono.fromSupplier(() -> readFile(fileName)); // We build the Pipe Line when someone subsribe it will
															// exercute
		// we use fromSupplier to create Publier becuae it return String back
	}

	// Build Publiser Write File
	public static Mono<Void> write(String fileName, String content) {
		return Mono.fromRunnable(() -> writeFile(fileName, content));
		// we use fromRunnable becuae we just want to notifi user

	}

	// Build Publiser Delete File
	public static Mono<Void> delete(String fileName) {
		return Mono.fromRunnable(() -> deleteFile(fileName));
		// we use fromRunnable becuae we just want to notifi user

	}

	// readFile
	private static String readFile(String fileName) {
		try {

			return Files.readString(PATH.resolve(fileName));

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	// write file
	private static void writeFile(String fileName, String content) {
		try {

			Files.writeString(PATH.resolve(fileName), content);

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	// delete file
	private static void deleteFile(String fileName) {
		try {

			Files.delete(PATH.resolve(fileName));

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	

}
