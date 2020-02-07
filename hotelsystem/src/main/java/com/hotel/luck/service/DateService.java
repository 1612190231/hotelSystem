package com.hotel.luck.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Service
public class DateService {
	
	public int daysOfTwo(Date fDate, Date oDate) {

	       Calendar aCalendar = Calendar.getInstance();

	       aCalendar.setTime(fDate);

	       int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);

	       aCalendar.setTime(oDate);

	       int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);

	       return day2 - day1;

	    }
	public Date strToDate(String str) throws ParseException {
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 return sdf.parse(str);
	 }
}
