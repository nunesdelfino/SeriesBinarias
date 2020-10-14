package teste;

import java.io.IOException;

import arquivo.ManipulaArquivoSerializado;
import modelo.IModelo;
import modelo.Serie;

public class TesteSerializado {

	public static void testeInclusao(Object Teste) {
		ManipulaArquivoSerializado mas=null;
		try {
			mas = new ManipulaArquivoSerializado("RegistroSeries", "Series.karen");
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		
		Serie p1 =  (Serie) Teste;
		mas.limparLinhas();
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
			mas = new ManipulaArquivoSerializado("RegistroSeries", "Series.karen");
			mas.lerArquivo();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
			System.exit(1); 
		}

		for(IModelo objeto: mas.getLinhas()) {
			Serie p = (Serie)objeto;
			System.out.println(p);
		}
		
	}
	public static void main(String[] args) {
//		testeInclusao();
		testeLeitura();
	}

}
