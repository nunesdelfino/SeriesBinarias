package controle;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import arquivo.ManipulaArquivoSerializado;
import modelo.IModelo;
import modelo.Serie;

public class SaveRead {
	
	public static final String NOME_PASTA_DADOS = "RegistroSeries";
	public static final String NOME_ARQUIVOS_DADOS = "Series.karen";
	
	public static void Incluir(Serie NovaSerie) {
		
		ManipulaArquivoSerializado Manipula = null;
				
		try {
			
			Manipula = new ManipulaArquivoSerializado(SaveRead.NOME_PASTA_DADOS, SaveRead.NOME_ARQUIVOS_DADOS);
		
		} catch (ClassNotFoundException | IOException e) {
			// TODO
			JOptionPane.showMessageDialog(null, e, null, JOptionPane.INFORMATION_MESSAGE);
			System.exit(1);
		}
		
		Manipula.incluirLinha(NovaSerie);
		
		try {
			Manipula.gravarArquivo();
		} catch (IOException e) {
			// TODO
			
		}
		
	}
	
	public static ManipulaArquivoSerializado Ler() {
		
		ManipulaArquivoSerializado Manipula = null;
		
		
		try {
			Manipula = new ManipulaArquivoSerializado(SaveRead.NOME_PASTA_DADOS, SaveRead.NOME_ARQUIVOS_DADOS);
			Manipula.lerArquivo();
		} catch (ClassNotFoundException | IOException e) {
			// TODO
			e.printStackTrace();
			System.exit(1);
		}
		
		return Manipula;
	}

}
