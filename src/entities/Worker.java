package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities_enum.WorkLevel;

public class Worker {
	private String name;
	private Double baseSalary;
	private WorkLevel level;
	
	private Departament departament;
	private List<HourContract> contracts = new ArrayList<>();
	
	public Worker() {}

	public Worker(String name, Double baseSalary, WorkLevel level) {
		this.name = name;
		this.baseSalary = baseSalary;
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public WorkLevel getLevel() {
		return level;
	}

	public void setLevel(WorkLevel level) {
		this.level = level;
	}

	public Departament getDepartament() {
		return departament;
	}

	public void setDepartament(Departament departament) {
		this.departament = departament;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}
	
	public void addContract(HourContract contract) {
		this.contracts.add(contract);
	}
	
	public void removeContract(HourContract contract) {
		this.contracts.remove(contract);		
	}
	
	public double income(int year, int month) {
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance(); 
		for(HourContract c : contracts) {
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
		    int c_month = cal.get(Calendar.MONTH);
		    
		    if(year == c_year && month == c_month) {
		    	sum += c.totalvalue();	
		    }	       
		}
		return sum;
	}
	
	
	
	
	
	
}
