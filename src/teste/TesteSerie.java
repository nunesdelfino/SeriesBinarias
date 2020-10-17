package teste;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import modelo.Serie;
import utils.DateUtils;

public class TesteSerie {

	public static void main(String[] args) {
		
		Date DataLancamento = new GregorianCalendar(2020, Calendar.OCTOBER, 07).getTime();

		Serie s = new Serie("How I met your mother", DataLancamento, true, 50, 10);
		
		TesteSerializado.testeInclusao(s);
		
		System.out.println(s.toString());

	}

}
