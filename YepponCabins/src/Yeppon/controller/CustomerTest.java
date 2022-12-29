package Yeppon.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Yeppon.entity.Customer;

public class CustomerTest {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// String name = null;
		int N;
		double perNight = 89.95;
		double sumOfCharge = 0;
		int maxNights = 0, minNights = 0;
		double sumOfNights = 0;
		String maxName = null, minName = null;
		List<Customer> list = new ArrayList<Customer>();
		Customer customer = null;
		System.out.println("Welcome to Yeppon Cabins Management System\n");
		for (N = 1; N <= 3; N++) {
			customer = new Customer();
			if (customer.getCustomerName() == null) {
				boolean check = true;
				while (check) {
					if(N!=1)
						 scanner.nextLine();
					System.out.print("Please enter booking name " + N + "==>");
					String name = scanner.nextLine();
					customer.setCustomerName(name);
					if (customer.getCustomerName().isEmpty()) {
						System.out.println("\nERROR booking name cannot be blank");
						// continue;
						// check = true;
					} else {
						check = false;
					}
				}
			}

			if (customer.getNumberofNights() <= 0) {
				boolean check = true;
				while (check) {
					System.out.print("Enter the Number of Nights for " + customer.getCustomerName() + "==>");
					int number = scanner.nextInt();
					customer.setNumberofNights(number);
					if (customer.getNumberofNights() < 1) {
						System.out.println("\nERROR number of nights must be greater then or equal 1");
						check = true;

					} else {
						check = false;
					}
				}
			}
//				System.out.println("java code:- "+customer);
			if (!customer.getCustomerName().isEmpty() && customer.getNumberofNights() > 0) {
				list.add(customer);

			}

			if (customer.getNumberofNights() == 1) {
				double charge = perNight + 20.00;
				sumOfCharge += charge;
				System.out.printf("The charge for " + customer.getCustomerName() + " for "
						+ customer.getNumberofNights() + " Nights is $%.2f \n", charge);
			} else {
				if (customer.getNumberofNights() > 1 && customer.getNumberofNights() <= 7) {
					double charge = customer.getNumberofNights() * perNight;
					charge += 20.00;
					sumOfCharge += charge;
					System.out.printf("The charge for " + customer.getCustomerName() + " for "
							+ customer.getNumberofNights() + " Nights is $%.2f \n", charge);
				} else {
					if (customer.getNumberofNights() > 7 && customer.getNumberofNights() <= 14) {
						double charge = customer.getNumberofNights() * perNight;
						charge = charge - (charge * 10) / 100;
						charge += 20.00;
						sumOfCharge += charge;
						System.out.printf("The charge for " + customer.getCustomerName() + " for "
								+ customer.getNumberofNights() + " Nights is $%.2f \n", charge);
					} else {
						double charge = customer.getNumberofNights() * perNight;
						charge = charge - (charge * 15) / 100;
						charge += 20.00;
						sumOfCharge += charge;
						System.out.printf("The charge for " + customer.getCustomerName() + " for "
								+ customer.getNumberofNights() + " Nights is $%.2f \n", charge);
					}
				}
		}
	}
				
		System.out.println("\nStatistical information for Yeppoon Cabin");
		for (Customer customer1 : list) {
			if (customer1.getNumberofNights() > maxNights) {
				maxName = customer1.getCustomerName();
				maxNights = customer1.getNumberofNights();
				if (minNights == 0) {
					minNights = maxNights;
				}
			}
			if (customer1.getNumberofNights() < minNights) {
				minNights = customer1.getNumberofNights();
				minName = customer1.getCustomerName();
			}
			sumOfNights += customer1.getNumberofNights();
		}
		System.out.println();
		System.out.println(minName + " has the minimum number of " + minNights + " Nights");
		System.out.println(maxName + " has the maximum number of " + maxNights + " Nights");
		System.out.printf("The avarage number of nights per booking is : %.2f nights\n", sumOfNights /(N-1));
		System.out.printf("The total charges collected is : $%.2f\n", sumOfCharge);

		System.out.println();
		System.out.println("\nThank you for using the Yeppoon Cabins Management System");
		System.out.println("Program written By StudentID <123456>");
	}
}
