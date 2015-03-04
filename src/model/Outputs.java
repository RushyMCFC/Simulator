package model;

import java.util.Calendar;
import java.util.Date;

public class Outputs {
	Date adate = new Date();
	Calendar c = Calendar.getInstance();
	
	
	int year = c.get(Calendar.YEAR); 
	int month = c.get(Calendar.MONTH); 
	int date = c.get(Calendar.DATE); 

	
	 public Outputs()
	 {
		 c.setTime(this.adate);
	 }
	 public int getYear() {
	        return c.get(Calendar.YEAR);  
	    }
	 public int getMonth() {
	        return c.get(Calendar.MONTH);  
	    }
	 public int getDate() {
	        return c.get(Calendar.DATE);  
	    }

}

