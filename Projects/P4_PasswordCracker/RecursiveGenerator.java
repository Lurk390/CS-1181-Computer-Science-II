package P4_PasswordCracker;

public class RecursiveGenerator extends Thread {
    private int length;

    RecursiveGenerator(int length) {
        this.length = length;
    }

    public void run() {
        recursiveGenerator(length, "");
    }

    // Recursive function to generate passwords
    public static void recursiveGenerator(int length, String word) {
        // Check if the specified length has been reached
        if (length == 0) {
            // Add the password to the queue
			PasswordQueue.add(word);
			return;
        }

        // Loop through every lower case letter of the alphabet
        for (char letter = 'a'; letter <= 'z'; letter++) {
            // Append the letter to the word
            String newWord = word + letter;
            // Generate a new password 
            recursiveGenerator(length - 1, newWord);
        }
    }
}
