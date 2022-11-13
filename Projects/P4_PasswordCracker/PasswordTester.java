package P4_PasswordCracker;

import net.lingala.zip4j.core.*;

public class PasswordTester extends Thread {
    private ZipFile zip;

    PasswordTester(ZipFile zip) {
        this.zip = zip;
    }

    // 
    public void run() {
        // Keep testing passwords until one is found or the queue is empty
        while (PasswordQueue.size() > 0 || !Main.getPasswordFound()) {
            // Each thread will test a different password since poll() is used
            String password = PasswordQueue.poll();
            if (password == null) {
                continue;
            }

            // If the password is correct, set correctPassword varibale in Main
            // and set passwordFound boolean to stop the threads
            if (Main.verifyPassword(zip, password)) {
                Main.setPasswordFound(true);
                Main.setCorrectPassword(password);
            }
        }
    }
}

