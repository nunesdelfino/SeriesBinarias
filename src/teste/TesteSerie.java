package teste;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import modelo.Serie;

public class TesteSerie {

	public static void main(String[] args) {
		
		Date DataLancamento = new GregorianCalendar(2020, Calendar.OCTOBER, 07).getTime();

		Serie s = new Serie("How I met your mother", 50, DataLancamento, true);
		
		System.out.println(s.toString());

	}

}
