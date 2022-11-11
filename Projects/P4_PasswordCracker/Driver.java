// Mahmoud Elbasiouny
package P4_PasswordCracker;

import net.lingala.zip4j.core.*;
import net.lingala.zip4j.exception.*;

public class Driver {
	private static String file = "example.zip";
	private static ZipFile zipFile;

    public static void main(String[] args) throws Exception {
		zipFile = new ZipFile("Projects/P4_PasswordCracker/" + file);

		System.out.println("Attempting to crack " + file + "...");

		long start = System.currentTimeMillis();
		try {
			recursiveCrack(4, "");
		} catch (RuntimeException re) {
			long end = System.currentTimeMillis();
			System.out.println("Cracked in " + (double)(end - start)/1000 + "s");
		}
    }

	public static boolean extractZip(String password) {
		try {
			System.out.println("Attempting password: " + password);
			zipFile.setPassword(password);
			zipFile.extractAll("Projects/P4_PasswordCracker/contents/");
			System.out.println("Successfully cracked! The password is " + password);
			return true;
		} catch (ZipException ze) {
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// Recursive function to generate passwords
    public static void recursiveCrack(int length, String word) {
        // Check if length has been reached
        if (length == 0) {
			if (extractZip(word)) {
				throw new RuntimeException("Successfully cracked!");
			}
			return;
        }

        for (char letter = 'a'; letter <= 'z'; letter++) {
            // Call generate again with every combination until it has reached it's length
            String new_word = word + letter;
            recursiveCrack(length - 1, new_word);
        }
    }
}
