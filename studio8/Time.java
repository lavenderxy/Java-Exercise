package studio8;

public class Time {
	
	private final int hour;
	private final int minute;
	
	public Time(int hour, int minute){
		this.hour=hour;
		this.minute=minute;
	}
	
	public String toString(){
		
		int hour12=hour>12? hour-12: hour;
		return ("12- Time zone: "+hour12+":"+minute+" ; 24-Time zone: "+hour+":"+minute);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hour;
		result = prime * result + minute;
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
		Time other = (Time) obj;
		if (hour != other.hour)
			return false;
		if (minute != other.minute)
			return false;
		return true;
	}

	public static void main(String[] args) {
		Time time1=new Time(13,55);
		System.out.println(time1);
		
	}

}
