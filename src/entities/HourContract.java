package entities;

import java.util.Date;

public class HourContract {
	private Date date;
	private Double valuerHours;
	private Integer hours;
	
	public HourContract() {}

	public HourContract(Date date, Double valuerHours, Integer hours) {
		this.date = date;
		this.valuerHours = valuerHours;
		this.hours = hours;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getValuerHours() {
		return valuerHours;
	}

	public void setValuerHours(Double valuerHours) {
		this.valuerHours = valuerHours;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}
	
	public double totalvalue() {
		return valuerHours * hours;
	}
	
}
