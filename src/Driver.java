import java.util.Random;
import java.util.Scanner;

public class Driver {
	// Main method.
	public static void main(String[] args) {
		int points = 0;
		int pointTotal = 0;
		int previousScore = 0;
		System.out.println("Welcome to the Simple Slot Machine.");
		System.out.println("To play, press any key. Or type 'q' to quit.");
		Scanner scan = new Scanner(System.in);
		char keyboard = scan.next().charAt(0);
		while ((keyboard != 'q') && (keyboard != 'Q')) {
			int firstNumber = randomNumberGenerator();
			int secondNumber = randomNumberGenerator();
			int thirdNumber = randomNumberGenerator();
			// Print out random numbers.
			System.out.print("Your numbers are: ");
			System.out.println(firstNumber + " " + secondNumber + " " + thirdNumber);
			// Calculation of points.
			if ((firstNumber == secondNumber) && (secondNumber == thirdNumber) 
					&& (thirdNumber == firstNumber) && (firstNumber != 7)
					&& (secondNumber != 7) && (thirdNumber != 7)) {
				points = 75;
				System.out.println("Congratulations!  You won 75 points!");
			}
			if ((firstNumber == 7) && (secondNumber == 7) && (thirdNumber == 7)) {
				points = 750;
				System.out.println("Congratulations!  You won 750 points!");
			}
			if (((firstNumber == secondNumber) && (firstNumber != thirdNumber) && (firstNumber != 7))
					|| ((secondNumber == thirdNumber) && (secondNumber != firstNumber) && (secondNumber != 7))
					|| ((thirdNumber == firstNumber) && (thirdNumber != secondNumber) && (thirdNumber != 7))) {
				points = 5;
				System.out.println("Congratulations!  You won 5 points!");
			}
			if (((firstNumber == 7) && (secondNumber == 7) && (thirdNumber != 7))
					|| ((secondNumber == 7) && (thirdNumber == 7) && (firstNumber != 7))
					|| ((thirdNumber == 7) && (firstNumber == 7) && (secondNumber != 7))) {
				points = 20;
				System.out.println("Congratulations!  You won 20 points!");
			}
			if ((firstNumber != secondNumber) && (secondNumber != thirdNumber) && (thirdNumber != firstNumber)) {
				points = -1;
				System.out.println("I’m sorry, but you lost a point.");
			}
			pointTotal = totalScore(points, previousScore);
			previousScore = pointTotal;
			System.out.println("You have a total of " + pointTotal + " points.");
			if (pointTotal <= 0) {
				System.out.println("GAME OVER");
				return;
			}
			else {
				System.out.println("To play again, press any key. Or type 'q' to quit.");
				keyboard = scan.next().charAt(0);
			}
		}
	}

	// Method that generates random number.
	public static int randomNumberGenerator() {
		// Create Random object.
		Random number = new Random();
		// Generate Random number.
		int randomNumber = number.nextInt(10) + 1;
		return randomNumber;
	}

	// Method that calculates total score.
	public static int totalScore(int score, int totalScore) {
		totalScore = totalScore + score;
		return totalScore;
	}
}