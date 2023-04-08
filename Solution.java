package com.todo.project;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {

		ToDoImplementation doImplementation= new ToDoImplementation();
		Scanner ip=new Scanner(System.in);
		while(true) {
			System.out.println("\n------Manage your TODOs------");
			System.out.println("Type\n1 to print all your TODOs\n2 to add a new TODO\n3 to mark a TODO as DONE\n4 to change priority and due date of a TODO\n5 to quit\n>Your choice? ");
			int choice = ip.nextInt();
			switch(choice) {
			case 1:
				doImplementation.toPrintTodos();
				break;

			case 2: 
				doImplementation.addNewToDos();
				break;

			case 3: 
				doImplementation.markAsDone();
				break;

			case 4:
				doImplementation.updatePriorityAndDueDate();
				break;

			case 5:
				System.out.println("------Thats all the list you got for now,you can exit now------");
				System.exit(0);
				break;

			default:
				try {
					String msg= "invalid input! Please enter valid choid";
					throw new InvalidChoiceException(msg);

				}
				catch(Exception e) {

					System.out.println(e.getMessage());

				}

			}
			System.out.println("======================");
		}

	}

}

