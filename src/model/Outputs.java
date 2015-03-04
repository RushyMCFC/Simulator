package model;

import java.util.Calendar;
import java.util.Date;

public class Outputs {
	Date adate = new Date();
	Calendar c = Calendar.getInstance();
	
	
	int year = c.get(Calendar.HOUR); 
	int month = c.get(Calendar.MINUTE); 
	int date = c.get(Calendar.SECOND); 

	
	 public Outputs()
	 {
		 c.setTime(this.adate);
	 }
	 public int getHour() {
	        return c.get(Calendar.HOUR);  
	    }
	 public int getMinute() {
	        return c.get(Calendar.MINUTE);  
	    }
	 public int getSecond() {
	        return c.get(Calendar.SECOND);  
	    }

}

