package arquivo;

import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class ManipulaArquivo {
	
	final String SEPARADOR = System.getProperty("file.separator");
	
	 protected String CaminhoArquivo, NomeArquivo;
	 
	 private List<Object> ListaLinhas;
	 
	 protected boolean preparaLocalDados() {
		String strCaminhoDados = ManipulaArquivo.getCaminhoAplicacao() + SEPARADOR + this.getCaminhoArquivo();
		// CaminhoAplicação = c:\portalbe20201\workspace\05-02-ManipulandoArquivo
		// /
		// dados
		// c:\portable20201\workspace\05-02-ManipulandoArquivo\dados
		File caminhoDados = new File(strCaminhoDados);
		try {
			if (!caminhoDados.exists()) {
				caminhoDados.mkdirs();
			}
		} catch (Exception e) {
			e.printStackTrace();
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
	 * @return
	 */
	public static String getCaminhoAplicacao() {
		try {
			return new java.io.File(".").getCanonicalPath();
		} catch (IOException e) {// sem tratamento pois, dificilmente acontecerá um erro.
			e.printStackTrace();
		}
		;
		return null;
	}
	
	public void incluirLinha(Object linha) {
		ListaLinhas.add(linha);
	}

	public List<Object> getLinhas() {
		return ListaLinhas;
	}

	public Object getLinha(int linha) {
		return ListaLinhas.get(linha);
	}
	 
	public abstract void gravarArquivo() throws IOException;
	 
	public abstract void lerArquivo() throws FileNotFoundException, IOException;

}
