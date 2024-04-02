package guessinggame;

import javax.swing.*;

public class GuessingGame {
    public static void main(String[] args) {
        int computerNumber = (int) (Math.random() * 100 + 1);
        int userAnswer = 0;
        int count = 1;
        int maxAttempts = 10;

        while (userAnswer != computerNumber && count <= maxAttempts) {
            String response = JOptionPane.showInputDialog(null,
                    "Enter a guess between 1 and 100 or type 'exit' to quit.", "Guessing Game", 3); // display input dialog

            if ("exit".equalsIgnoreCase(response)) {
                JOptionPane.showMessageDialog(null, "Game exited. The correct number was " + computerNumber);
                return;
            }

            try {
                userAnswer = Integer.parseInt(response); 
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid integer or 'exit' to quit.");
                continue;
            }

            // Check the guess and display result or hint
            JOptionPane.showMessageDialog(null, "" + determineGuess(userAnswer, computerNumber, count));
            count++;
        }

        if (count > maxAttempts) {
            JOptionPane.showMessageDialog(null, "You've reached the maximum attempts. The correct number was " + computerNumber + ".");
        }
    }

    // Determine guess function
    public static String determineGuess(int userAnswer, int computerNumber, int count) {
        if (userAnswer <= 0 || userAnswer > 100) {
            return "Your guess is invalid.";
        } else if (userAnswer == computerNumber) {
            return "Correct!\nTotal Guesses: " + count;
        } else if (userAnswer > computerNumber) {
            return "Your guess is too high, try again.\nTry Number: " + count;
        } else {
            return "Your guess is too low, try again.\nTry Number: " + count;
        }
    }
}
