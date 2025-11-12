package studio8;

import java.util.Scanner;

import support.cse131.NotYetImplementedException;

public class Quiz {
	
	private Question[] questions;
	private int length;
	/**
	 * Constructor
	 * @param questions
	 */
	public Quiz(Question[] questions) {
		this.questions = questions;
		this.length = questions.length;
	}
	
	/**
	 * Prompts the user to answer, then returns a String containing their answer.
	 * @param in
	 * @return String answer
	 */
	private String getUserAnswer(Scanner in) {
		System.out.print("Please enter your answer: ");
		String out = in.next();
		return out;
	}
	
	/**
	 * Gets the number of points possible in the quiz.
	 * @return int number of total points
	 */
	public int getTotalPoints() {
		int sum = 0;
		for (int i = 0; i < this.length; i++){
			sum += this.questions[i].getPoints();
		}
		return sum;
	}
	
	/**
	 * Asks the user all question in the quiz, then prints out 
	 * the amount of points the user earned. This print statement
	 * should include "You earned ____ points"
	 * 
	 * @param in Scanner object to feed into getUserAnswer
	 */
	public void takeQuiz(Scanner in) {
		
		for(int i = 0; i < this.length; i++){
			this.questions[i].displayPrompt();
			String answer = this.getUserAnswer(in);
			System.out.println(this.questions[i].checkAnswer(answer));
		}
	}
	
	
	public static void main(String[] args) {
		String [] and = {"Daniel's Ukelele Concert", "Danforth University Center", "Dodson Uncle Catastrophy"};
		Question a = new MultipleChoiceQuestion("What does DUC stand for?", "2", 4, and);
		Question c = new SelectAllQuestion("Test","123" , new String[] {"A", "B", "C", "D"});
		Question[] q = {new Question("What is the capital of Massachusetts?", "Boston", 5), a, c};

		Quiz b = new Quiz(q);
		Scanner in = new Scanner(System.in);
		b.takeQuiz(in);
	}
}
