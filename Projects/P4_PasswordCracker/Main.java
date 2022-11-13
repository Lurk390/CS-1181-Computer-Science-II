// Mahmoud Elbasiouny
package P4_PasswordCracker;

import java.util.concurrent.atomic.AtomicBoolean;
import java.nio.file.*;
import net.lingala.zip4j.core.*;
import net.lingala.zip4j.exception.*;

public class Main {
	// AtomicBoolean is a thread-safe boolean
	private static AtomicBoolean passwordFound = new AtomicBoolean(false);
	private static String correctPassword;

    public static void main(String[] args) throws Exception {
		int numThreads = 8;

		// String filePath = "Projects/P4_PasswordCracker/zipfiles/test3.zip";
		// int passwordLength = 3;
		// String filePath = "Projects/P4_PasswordCracker/zipfiles/example.zip";
		// int passwordLength = 4;
		// String filePath = "Projects/P4_PasswordCracker/zipfiles/protected3.zip";
		// int passwordLength = 3;
		String filePath = "Projects/P4_PasswordCracker/zipfiles/protected5.zip";
		int passwordLength = 5;

		String file = filePath.substring(37);

		System.out.println("Attempting to crack " + file + " with " + numThreads + " thread(s)...");
		
		try {
			// Create numThreads threads to test passwords
			PasswordTester[] testers = new PasswordTester[numThreads];

			//make an numThreads sized array of tempFileNames
			String[] tempFileNames = new String[numThreads];

			for (int i = 0; i < numThreads; i++) {
				tempFileNames[i] = (i + 1) + "-" + file;
				Files.copy(Path.of(filePath),
						   Path.of("Projects/P4_PasswordCracker/temp/" + tempFileNames[i]));
				
				ZipFile zip = new ZipFile("Projects/P4_PasswordCracker/temp/" + tempFileNames[i]);

				testers[i] = new PasswordTester(i + 1, zip);
			}

			long start = System.currentTimeMillis();

			// Generate a queue of every combination of n lower case letters
			RecursiveGenerator generator = new RecursiveGenerator(passwordLength);
			generator.start();

			// Start the threads
			for (int i = 0; i < numThreads; i++) {
				testers[i].start();
			}

			// Wait for the threads to finish
			for (int i = 0; i < numThreads; i++) {
				testers[i].join();
			}
			generator.join();

			long end = System.currentTimeMillis();
			System.out.println("Finished in " + (double)(end - start)/1000 + " s");

			if (passwordFound.get()) {
				System.out.println("Password found: " + correctPassword);
				extractZip(new ZipFile("Projects/P4_PasswordCracker/zipfiles/" + file), correctPassword);
			} else {
				System.out.println("You suck at cracking passwords");
			}			
			
			// Delete copied zip files
			for (int i = 0; i < numThreads; i++) {
				Files.delete(Path.of("Projects/P4_PasswordCracker/temp/" + tempFileNames[i]));
			}

		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
    }

	public static boolean extractZip(ZipFile zip, String password) {
		try {
			zip.setPassword(password);
			zip.extractAll("Projects/P4_PasswordCracker/contents/");
			return true;
		} catch (ZipException ze) {
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static void setPasswordFound(boolean bool) {
		passwordFound.set(bool);
	}

	public static boolean getPasswordFound() {
		return passwordFound.get();
	}

	public static void setCorrectPassword(String password) {
		correctPassword = password;
	}
}
