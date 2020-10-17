package utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	
	/**
	 * Obtem o dia do mes
	 * @param date
	 * @return
	 */
	public static int getDia(Date date) {
		Calendar Calendario = Calendar.getInstance();
		Calendario.setTime(date);
		return Calendario.get(Calendar.DAY_OF_MONTH);
	}
	
	/**
	 * Obtem o mes
	 * @param date
	 * @return
	 */
	public static int getMes(Date date) {
		Calendar Calendario = Calendar.getInstance();
		Calendario.setTime(date);
		return Calendario.get(Calendar.MONTH) + 1;
	}
	
	/**
	 * Obtem o ano
	 * @param date
	 * @return
	 */
	public static int getAno(Date date) {
		Calendar Calendario = Calendar.getInstance();
		Calendario.setTime(date);
		return Calendario.get(Calendar.YEAR);
	}

}
