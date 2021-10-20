package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entities_enum.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner scn = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");
		
		System.out.print("Enter departament's name");
		String departamentName = scn.nextLine();
		System.out.println("Enter Worker data: ");
		System.out.print("Name: ");
		String workerName = scn.nextLine();
		System.out.print("Level: ");
		String workerLevel = scn.nextLine();
		System.out.print("Base salary: ");
		double baseSalary = scn.nextDouble();
		
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Departament(departamentName));

		System.out.print("How many contracts to this worker? ");
		int n = scn.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Enter contract #"+i+" data: ");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(scn.next());
			System.out.println("Value per hour: ");
			double valuePerHour = scn.nextDouble();
			System.out.println("Durations (hours): ");
			int hours = scn.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
		}
		
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = scn.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.print("Name: " + worker.getName());
		System.out.println("Departament: " + worker.getDepartament().getName());
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));

		scn.close();
	}

}
