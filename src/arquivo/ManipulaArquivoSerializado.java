package arquivo;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import controle.SaveRead;
import modelo.IModelo;

public class ManipulaArquivoSerializado {
	
	
	final String SEPARADOR = System.getProperty("file.separator");
	private List<IModelo> listaLinhas;
	private String caminhoArquivo, nomeArquivo;

	public ManipulaArquivoSerializado(String caminho, String nomeArquivo)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		this.caminhoArquivo = caminho;
		this.nomeArquivo = nomeArquivo;

		this.limparLinhas();

		// criar o diret�rio dos dados casos ele n�o exista
		if (!this.preparaLocalDados()) {
			throw new RuntimeException("Erro ao preparar caminho para gravar dados!!!");
		}
		// criar o arquivo de dados caso ele n�o exista
		if (!this.preparaArquivoDados()) {
			throw new RuntimeException("Erro ao preparar o arquivo de dados!!!");
		}

		this.lerArquivo();
	}

	/**
	 * Metodo que deve retornar o nome do arquivo que ser� utilizado para gravar os
	 * dados deve retornar apenas o nome do arquivo sem o caminho
	 * 
	 * @return
	 */
	public String getArquivoNome() {
		return this.nomeArquivo;
	}

	/**
	 * Metodo que deve retonar o caminho do arquivo a partir de onde o programa �
	 * executardo. Ex.: dados
	 *
	 * @return
	 */
	public String getCaminhoArquivo() {
		return this.caminhoArquivo;
	}

	public void limparLinhas() {
		this.listaLinhas = new ArrayList<>();
	}

	/**
	 * retorna o caminho onde o programa � executando
	 * 
	 * @return
	 */
	public static String getCaminhoAplicacao() {
		try {
			return new java.io.File(".").getCanonicalPath();
		} catch (IOException e) {// sem tratamento pois, dificilmente acontecer� um erro.
			e.printStackTrace();
		}
		;
		return null;
	}

	/**
	 * cria a pasta onde os dados ser�o guardados.
	 * 
	 * @return true se deu certo
	 * @return  false se der errado
	 */
	private boolean preparaLocalDados() {
		String strCaminhoDados = ManipulaArquivo.getCaminhoAplicacao() + SEPARADOR + this.getCaminhoArquivo();
		File caminhoDados = new File(strCaminhoDados);
		try {
			if (!caminhoDados.exists()) {
				return caminhoDados.mkdirs();
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * cria o arquivo onde os dados ser�o guardados se n�o existir.
	 * 
	 * @return true se der certo
	 * @return false se der errado
	 */
	private boolean preparaArquivoDados() {
		String arquivoDados = this.getNomeArquivoAbsoluto();
		File caminhoDados = new File(arquivoDados);
		try {
			if (!caminhoDados.exists()) {
				this.gravarArquivo();
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * retorno o nome do arquivo incluindo o caminho absoluto at� ele ex:
	 * c:\Portables\eclipse-workspacePRGI-20181\05-02-ManipulandoArquivo\dados\dados.txt
	 * 
	 * @return
	 */
	public String getNomeArquivoAbsoluto() {
		return ManipulaArquivo.getCaminhoAplicacao() + SEPARADOR + this.getCaminhoArquivo() + SEPARADOR
				+ this.getArquivoNome();
	}

	/**
	 * Realizar a leitura do arquivo inteiro para a Lista listaLinhas
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException 
	 */
	public void lerArquivo() throws FileNotFoundException, IOException {
		this.limparLinhas();
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(this.getNomeArquivoAbsoluto()));   
        // Deserialize o objeto
		IModelo objeto = null;
		try {
			while ((objeto = (IModelo)in.readObject()) != null) {
				this.getLinhas().add(objeto);
			}
			
		}catch(EOFException e) {
			//faz nada, pois chegar ao fim do arquivo n�o � problema
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		in.close();
		
	}

	/**
	 * Grava a lista inteira para o arquivo
	 * 
	 * @throws IOException
	 */
	public void gravarArquivo() throws IOException {

		ObjectOutput out = new ObjectOutputStream(new FileOutputStream(this.getNomeArquivoAbsoluto()));
		for (IModelo objeto : this.getLinhas()) {
			out.writeObject(objeto);
		}

		out.close();

	}
	
	
	public boolean removeLinha(int Posicao) throws IOException {
		
		SaveRead lerArquivo = new SaveRead();
		
		ManipulaArquivoSerializado listaSerie = lerArquivo.Ler();
		
		if(listaSerie == null) {
			return false;
		}
		
		listaSerie.getLinhas().remove(Posicao);
		try {
			listaSerie.gravarArquivo();
		} catch (IOException e) {
			return false;
		}
		return true;
		
	}

	public void incluirLinha(IModelo linha) {
		listaLinhas.add(linha);
	}

	public List<IModelo> getLinhas() {
		return listaLinhas;
	}

	public IModelo getLinha(int linha) {
		return listaLinhas.get(linha);
	}

}
