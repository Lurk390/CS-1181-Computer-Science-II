package P4_PasswordCracker;

import net.lingala.zip4j.core.*;

public class PasswordTester extends Thread {
    private ZipFile zip;
    private int id;

    PasswordTester(int id, ZipFile zip) {
        this.zip = zip;
        this.id = id;
    }

    public void run() {
        while (PasswordQueue.size() > 0 || !Main.getPasswordFound()) {
            // Get the next password from the queue
            String password = PasswordQueue.poll();
            if (password == null) {
                continue;
            }

            //System.out.println("Tester " + id + " trying " + password + " on " + zip.getFile().getName());

            if (Main.extractZip(zip, password)) {
                Main.setPasswordFound(true);
                Main.setCorrectPassword(password);
            }
        }
    }
}

