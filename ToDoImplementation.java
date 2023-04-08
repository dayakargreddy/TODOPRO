package com.todo.project;
import java.util.*;
public class ToDoImplementation {
	Scanner scan = new Scanner(System.in);
	List<TODO>doList =new ArrayList<TODO>();

	public void toPrintTodos() {
		System.out.println("1.to print all Todos\n2.to print open todos\n3.to print done todos ");
		int input=scan.nextInt();
		switch(input) {
		case 1:
			printAllCurentToDos();
			break;
		case 2:
			printOpenTodo();
			break;
		case 3:
			printDoneTodo();
			break;
		default:
			System.out.println("invalid choice entered");
		}
	}

	public void printAllCurentToDos() {

		System.out.println("you have "+doList.size()+" TODOs:");
		if(doList.size()!=0) {
			for(int i=0;i<doList.size();i++) {
				//				System.out.println(doList.toString());
				System.out.println(doList.get(i));
			}
		}
		else {
			try {
				String msg= "Your TODO is Empty...! Nothing to Show ";
				throw new  EmptyToDoListException(msg);

			}
			catch(Exception e) {

				System.out.println(e.getMessage());

			}
		}

	}

	public void addNewToDos() {
		System.out.println("enter the new todo");
		String text=scan.nextLine().toLowerCase();
		System.out.println("Enter priority (1-10)");
		String priority = scan.nextLine();
		System.out.println("Enter due date year");
		String year = scan.nextLine();
		System.out.println("Enter due date month");
		String month = scan.nextLine();
		System.out.println("Enter due date day");
		String day = scan.nextLine();
		System.out.println("enter the status");
		String status=scan.nextLine().toUpperCase();
		TODO to=new TODO(text, priority, year, month, day, status);
		doList.add(to);
	}

	public void markAsDone() {
		int c=0;
		if(doList.size()!=0) {
			System.out.println("Enter TODO to change to DONE");
			scan.nextLine();
			String todo = scan.nextLine().toLowerCase();
			//			System.out.println(todo);
			for(int i=0;i<doList.size();i++) {	
				c++;
				TODO to2=doList.get(i);
				//			System.out.println(to2.getTodo());
				//			System.out.println(todo);
				if(to2.getTodo().equals(todo)) {
					to2.setStatus("DONE");
					//				System.out.println("Done: "+ doList.);
					//				doList.remove(todo);
					break;
				}
				else if (c>=doList.size()) {
					try {
						String msg= "The Entered TODO is Not Present...! please check the list once again and enter the correct TODO to mark as done ";
						throw new  EmptyToDoListException(msg);
					}

					catch(Exception e) {

						System.out.println(e.getMessage());

					}
					break;
				}


			}

		}
		else {
			try {
				String msg= "you havent Added the dolist and  completed a single task yet please complete and mark as done";
				throw new  EmptyToDoListException(msg);

			}
			catch(Exception e) {

				System.out.println(e.getMessage());

			}
		}
	}

	public void printOpenTodo() {
		if(doList.size()!=0) {
			for(int i=0;i<doList.size();i++) {
				TODO lis=doList.get(i);
				if(lis.getStatus().equals("OPEN")) {
					System.out.println(doList.get(i));
					break;
				}
				else {
					System.out.println("There are no open Todos,all Todos are Done");
					break;
				}
			}

		}
		else {
			try {
				String msg= "Your TODO is Empty...! Nothing to Show ";
				throw new  EmptyToDoListException(msg);

			}
			catch(Exception e) {

				System.out.println(e.getMessage());

			}
		}

	}

	public void printDoneTodo() {
		if(doList.size()!=0) {
			for(int i=0;i<doList.size();i++) {
				TODO lis=doList.get(i);
				if(lis.getStatus().equals("DONE")) {
					System.out.println(doList.get(i));
					break;
				}
				else {
					System.out.println("There are no done Todos,all Todos are open");
					break;
				}
			}

		}
		else {
			try {
				String msg= "Your TODO is Empty...! Nothing to Show ";
				throw new  EmptyToDoListException(msg);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	public void updatePriorityAndDueDate() {
		System.out.println("Enter TODO to change");
		String change = scan.nextLine().toLowerCase();
//		scan.nextLine();
		for(int i=0;i<doList.size();i++) {	
			TODO to3=doList.get(i);
			//			System.out.println(to3.getTodo());
			if(to3.getTodo().equals(change)) {
				System.out.println("Enter priority");
				String priority = scan.nextLine();
				to3.setPriority(priority);
				System.out.println("Enter due date year");
				String year = scan.nextLine();
				to3.setYear(year);
				System.out.println("Enter due date month");
				String month = scan.nextLine();
				to3.setMonth(month);
				System.out.println("Enter due date day");
				String day = scan.nextLine();
				to3.setDay(day);
				System.out.println("Priority and Due date is Updated sucessfully!");
				break;

			}
			else {
				try {
					String msg= "The Entered TODO is Not Present...! please check the list once again and enter the correct TODO to mark as done ";
					throw new  EmptyToDoListException(msg);
				}

				catch(Exception e) {

					System.out.println(e.getMessage());

				}
				break;
			}


		}

	}

}
