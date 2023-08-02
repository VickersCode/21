import javax.swing.JOptionPane;

/**
 * Excercise from Starting Out With Java 5th Edition
 * Chapter 6 Question 8
 * "A Game of 21"
 * 
 * This is different than the traditional game of 21,
 * dice are used instead of cards. Round ends when player
 * doesn't want any more rolls of the dice, and the computer's
 * total remains hidden until the end of the round.
 */

public class TwentyOne {
    public static void main(String[] args) {
        
        // Start round
        TwentyOne.round();
    }

    public static void round() {
        int comp = 0; // Computer Score
        int user = 0; // User Score
        char cont = 'y'; // User's decision to roll or not

        Die die = new Die(6);

        while (cont == 'y') {


            // Roll the dice for the computer
            die.roll();
            comp += die.getValue();
            die.roll();
            comp += die.getValue();

            // Roll the dice for the user
            die.roll();
            user += die.getValue();
            die.roll();
            user += die.getValue();

            // Ask user to continue
            int input = JOptionPane.showConfirmDialog(null, "Your Score: " + user + "\n" +
                                                "Continue? (y/n)");
            if (input == 0) {
                cont = 'y';
            } else {
                cont = 'n';
            }

        }

        if (user > 21) {
            JOptionPane.showMessageDialog(null, "Bust!");
        } else {
            JOptionPane.showMessageDialog(null, "Computer: " + comp + "\n" +
                                                                "User: " + user);
        }
    }
}


