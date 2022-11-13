// Mahmoud Elbasiouny
package P4_PasswordCracker;

import java.io.*;
import java.nio.file.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.List;
import net.lingala.zip4j.core.*;
import net.lingala.zip4j.exception.*;
import net.lingala.zip4j.model.FileHeader;

/* File // numThreads // Execution Time
   ------------------------------------
   protected3.zip // 1 // 4.078s
   protected3.zip // 3 // 1.716s
   protected3.zip // 4 // 1.511s
   protected3.zip // 8 // 1.358s
   ------------------------------------
   protected5.zip // 3 // 1087.14s
   protected5.zip // 4 // 924.083s
   protected5.zip // 8 // 688.318s
   ------------------------------------
*/

public class Main {
	// AtomicBoolean is a thread-safe boolean
	private static AtomicBoolean passwordFound = new AtomicBoolean(false);
	private static String correctPassword;

    public static void main(String[] args) throws Exception {
		// String filePath = "Projects/P4_PasswordCracker/zipfiles/protected3.zip";
		// int passwordLength = 3;
		String filePath = "Projects/P4_PasswordCracker/zipfiles/protected5.zip";
		int passwordLength = 5;
		int numThreads = 4;
		String file = filePath.substring(37);
		
		try {
			// Create numThreads threads to test passwords
			PasswordTester[] testers = new PasswordTester[numThreads];
			// Generate a queue of every combination of n lower case letters
			RecursiveGenerator generator = new RecursiveGenerator(passwordLength);
			//make an numThreads sized array of tempFileNames
			String[] tempFileNames = new String[numThreads];

			// Create a copy of the zip file for each thread
			for (int i = 0; i < numThreads; i++) {
				tempFileNames[i] = (i + 1) + "-" + file;
				Files.copy(Path.of(filePath),
						   Path.of("Projects/P4_PasswordCracker/temp/" + tempFileNames[i]));
				
				ZipFile zip = new ZipFile("Projects/P4_PasswordCracker/temp/" + tempFileNames[i]);

				testers[i] = new PasswordTester(zip);
			}

			// Log start time
			System.out.println("Attempting to crack " + file + " with " + numThreads + " thread(s)...");
			long start = System.currentTimeMillis();

			// Start the threads
			generator.start();
			for (PasswordTester tester : testers) {
				tester.start();
			}

			// Wait for the threads to finish
			for (PasswordTester tester : testers) {
				tester.join();
			}
			generator.join();

			// Log end time and print results
			long end = System.currentTimeMillis();
			System.out.println("Finished in " + (double)(end - start)/1000 + "s");

			// Make sure that the password was found and extract the zip
			if (passwordFound.get()) {
				System.out.println("Password found: " + correctPassword);
				extractZip(new ZipFile("Projects/P4_PasswordCracker/zipfiles/" + file), correctPassword);
			} else {
				System.out.println("You suck at cracking passwords");
			}
			
			// Delete copied zip files
			for (String tempFile : tempFileNames) {
				Files.delete(Path.of("Projects/P4_PasswordCracker/temp/" + tempFile));
			}

		} catch (Exception e) {
			System.err.println("Error: " + e);
		}
    }

	public static boolean verifyPassword(ZipFile zipFile, String password) {
		try {
            if (zipFile.isEncrypted()) {
                zipFile.setPassword(password);
            }

            List<FileHeader> fileHeaders = zipFile.getFileHeaders();

			// Try reading the headers of the zip file
            for (FileHeader fileHeader : fileHeaders) {
                try {
                    InputStream inputStream = zipFile.getInputStream(fileHeader);
                    byte[] bytes = new byte[4 * 4096];
                    while (inputStream.read(bytes) != -1) {
                        // Do nothing as we just want to verify password
                    }
                    inputStream.close();
					return true;
                } catch (Exception e) {
					return false;
                }
            }
        } catch (Exception e) {
			return false;
        }
		return false;
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
