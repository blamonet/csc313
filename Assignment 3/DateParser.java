// Aaron Grant
// CSC 313
// Assignment 3

import java.util.Date;


class DateParser {
	private String date;
	private int month;
	private int day;
	private int year;
	
	public DateParser(String a) {
	date = a;
	parseString(a);
	}
	
	public int parseString (String a) {
	month = (Integer.parseInt(a.substring(0,2))-1);
	day   = Integer.parseInt(a.substring(3,5));
	year  = Integer.parseInt(a.substring(6));
	return 0;
	}
	
	public long getMS() {
    long number = (year-1970)*365+month*30+day;
    number = number * 60 * 60 * 1000 * 24;
	return number;
	}

}