// Mahmoud Elbasiouny
package P4_PasswordCracker;

import net.lingala.zip4j.core.*;
import net.lingala.zip4j.exception.*;

public class Driver {

    public static void main(String[] args) {

		try {
			ZipFile zipFile = new ZipFile("Projects/P4_PasswordCracker/example.zip");
			zipFile.setPassword("good");
			zipFile.extractAll("Projects/P4_PasswordCracker/contents/");
			System.out.println("Successfully cracked!");
		} catch (ZipException ze) {
			System.out.println("Incorrect password :(");
		} catch (Exception e){
			e.printStackTrace();
		}
    }
}
