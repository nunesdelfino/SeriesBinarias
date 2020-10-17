package controle;

import java.io.IOException;
import arquivo.ManipulaArquivoSerializado;
import modelo.Serie;

public class SaveRead {
	
	// Define constantes com o nome do arquivo e o caminho
	public static final String NOME_PASTA_DADOS = "RegistroSeries";
	public static final String NOME_ARQUIVOS_DADOS = "Series.karen";
	
	
	/**
	 * Inclui um novo objeto Serie ao arquivo
	 * @param NovaSerie
	 * @return true se deu certo
	 * @return false se der errado
	 */
	public boolean Incluir(Serie NovaSerie) {
		
		ManipulaArquivoSerializado Manipula = null;
				
		try {
			// Tenta abrir o arquivo
			Manipula = new ManipulaArquivoSerializado(SaveRead.NOME_PASTA_DADOS, SaveRead.NOME_ARQUIVOS_DADOS);
		} catch (ClassNotFoundException | IOException e) {
			//retorna false se der erro
			return false;
		}
		
		Manipula.incluirLinha(NovaSerie);
	
		try {
			Manipula.gravarArquivo();
		} catch (IOException e) {
			return false;
		}
		
		return true;
		
	}
	
	public ManipulaArquivoSerializado Ler() {
		
		ManipulaArquivoSerializado Manipula = null;
		
		
		try {
			Manipula = new ManipulaArquivoSerializado(SaveRead.NOME_PASTA_DADOS, SaveRead.NOME_ARQUIVOS_DADOS);
			Manipula.lerArquivo();
		} catch (ClassNotFoundException | IOException e) {
			return Manipula;
		}
		
		return Manipula;
	}

}
