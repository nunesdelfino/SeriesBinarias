package utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	
	public static int getDia(Date date) {
		Calendar Calendario = Calendar.getInstance();
		Calendario.setTime(date);
		return Calendario.get(Calendar.DAY_OF_MONTH);
	}
	
	public static int getMes(Date date) {
		Calendar Calendario = Calendar.getInstance();
		Calendario.setTime(date);
		return Calendario.get(Calendar.MONTH) + 1;
	}
	
	public static int getAno(Date date) {
		Calendar Calendario = Calendar.getInstance();
		Calendario.setTime(date);
		return Calendario.get(Calendar.YEAR);
	}

}
