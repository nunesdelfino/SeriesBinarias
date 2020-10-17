package arquivo;

import java.util.List;

import modelo.IModelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class ManipulaArquivo {
	
	final String SEPARADOR = System.getProperty("file.separator");
	
	 protected String CaminhoArquivo, NomeArquivo;
	 
	 private List<IModelo> ListaLinhas;
	 
	 /**
	  * Prepara o local do arquivo, obtendo o caminho
	  * @return true se funcionar
	  * @return false se tiver problema
	  */
	 protected boolean preparaLocalDados() {
		String strCaminhoDados = ManipulaArquivo.getCaminhoAplicacao() + SEPARADOR + this.getCaminhoArquivo();
		
		File caminhoDados = new File(strCaminhoDados);
		try {
			// Se o caminho não existir
			if (!caminhoDados.exists()) {
				// O caminho é criado
				caminhoDados.mkdirs();
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	 
	public String getCaminhoArquivo() {
		return this.CaminhoArquivo;
	}
	
	public String getArquivoNome() {
		return this.NomeArquivo;
	}

	/**
	 * Prepara o arquivo para salvar os dados
	 * @return true se der certo
	 * @return false se der erro
	 */
	protected boolean preparaArquivoDados() {
		String arquivoDados = this.getNomeArquivoAbsoluto();
		File caminhoDados = new File(arquivoDados);
		try {
			if (!caminhoDados.exists()) {
				this.gravarArquivo();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * 
	 * @return o caminho completo com o nome do arquivo
	 */
	public String getNomeArquivoAbsoluto() {
		return ManipulaArquivo.getCaminhoAplicacao() + 
				SEPARADOR + this.getCaminhoArquivo() + 
				SEPARADOR + this.getArquivoNome();
	}
	
	public ManipulaArquivo() throws FileNotFoundException, IOException, ClassNotFoundException{
		initManipularArquivo("base","arquivo");
	}
	
	public ManipulaArquivo(String caminho, String nomeArquivo)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		initManipularArquivo(caminho, nomeArquivo);
	}

	public void initManipularArquivo(String caminho, String nomeArquivo) throws FileNotFoundException, IOException {
		this.CaminhoArquivo = caminho;
		this.NomeArquivo = nomeArquivo;

		// criar o diretório dos dados casos ele não exista
		if (!this.preparaLocalDados()) {
			throw new RuntimeException("Erro ao preparar caminho para gravar dados!!!");
		}
		// criar o arquivo de dados caso ele não exista
		if (!this.preparaArquivoDados()) {
			throw new RuntimeException("Erro ao preparar o arquivo de dados!!!");
		}

		this.lerArquivo();
	}
	
	/**
	 * retorna o caminho onde o programa está executando
	 * 
	 * @return null se der errado
	 */
	public static String getCaminhoAplicacao() {
		try {
			return new java.io.File(".").getCanonicalPath();
		} catch (IOException e) {
			// sem tratamento pois, dificilmente acontecerá um erro.
			return null;
		}
	}
	
	public void incluirLinha(IModelo linha) {
		ListaLinhas.add(linha);
	}

	public List<IModelo> getLinhas() {
		return ListaLinhas;
	}

	public IModelo getLinha(int linha) {
		return ListaLinhas.get(linha);
	}
	 
	public abstract void gravarArquivo() throws IOException;
	 
	public abstract void lerArquivo() throws FileNotFoundException, IOException;

}
