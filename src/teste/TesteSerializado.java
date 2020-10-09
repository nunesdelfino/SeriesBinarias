package teste;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import arquivo.ManipulaArquivoSerializado;
import modelo.Serie;

public class TesteSerializado {

	public static void testeInclusao() {
		ManipulaArquivoSerializado mas=null;
		try {
			mas = new ManipulaArquivoSerializado("RegistroSeries", "Series.ser");
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		Date DataLancamento = new GregorianCalendar(2020, Calendar.OCTOBER, 07).getTime();
		Serie p1 = new Serie("How I met your mother", DataLancamento, false, 12, 781);
		mas.incluirLinha(p1);
		
		try {
			mas.gravarArquivo();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static void testeLeitura() {
		ManipulaArquivoSerializado mas=null;
		try {
			mas = new ManipulaArquivoSerializado("dadosObjetos", "pessoa.ser");
			mas.lerArquivo();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
			System.exit(1); 
		}

		for(Object objeto: mas.getLinhas()) {
			Serie p = (Serie)objeto;
			System.out.println(p);
		}
		
		
	}
	public static void main(String[] args) {
		testeInclusao();
		testeLeitura();
	}

}
