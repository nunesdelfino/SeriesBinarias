package teste;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import arquivo.ManipulaArquivoSerializado;
import modelo.Serie;

public class GerarSeries {
	
	public static final String NOME_PASTA_DADOS="RegistroSeries";
	public static final String NOME_ARQUIVOS_DADOS="Series.karen";
	
	public static void main(String[] args) {
		
		ManipulaArquivoSerializado Manipula = null;
		
		try {
			Manipula = new ManipulaArquivoSerializado(GerarSeries.NOME_PASTA_DADOS, GerarSeries.NOME_ARQUIVOS_DADOS);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		Date DataLancamento = new GregorianCalendar(2020, Calendar.OCTOBER, 07).getTime();
//		String Nome, Date Lancamento, Boolean Encerrada, Integer Temporadas, Integer Episodios
		Serie s1 = new Serie("aaaaa", DataLancamento, false, 5, 25);
		Manipula.incluirLinha(s1);
		
		try {
			Manipula.gravarArquivo();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
