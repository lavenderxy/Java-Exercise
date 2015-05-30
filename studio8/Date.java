package studio8;

import java.util.HashSet;
import java.util.LinkedList;

public class Date {
	
	private final int month;
	private final int day;
	private final int year;
	private final boolean isHoliday;
	
	public Date (int month, int day, int year, boolean isHoliday){
		this.month=month;
		this.day=day;
		this.year=year;
		this.isHoliday=isHoliday;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + day;
		result = prime * result + (isHoliday ? 1231 : 1237);
		result = prime * result + month;
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Date other = (Date) obj;
		if (day != other.day)
			return false;
		if (isHoliday != other.isHoliday)
			return false;
		if (month != other.month)
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	public static void main(String[] args) {
		Date date1=new Date(6,12,2015,true);
		Date date2=new Date(3,11,2011,false);
		LinkedList<Date> list = new LinkedList<Date>();
		HashSet<Date> set =new HashSet<Date>();
		list.add(date1);
		list.add(date2);
		System.out.println(list);
		set.add(date1);
		set.add(date2);
		System.out.println(set);
	}

}
