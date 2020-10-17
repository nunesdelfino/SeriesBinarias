package controle;

import java.io.IOException;
import java.util.List;

import arquivo.ManipulaArquivoSerializado;
import modelo.IModelo;

public class ControleSerie {
	
	private ManipulaArquivoSerializado manipula;
	
	/**
	 * carrega os dados em meoria
	 */
	public ControleSerie() {
		
		try {
			manipula = new ManipulaArquivoSerializado("RegistroSeries", "Series.karen");
		} catch (ClassNotFoundException | IOException e) {
			
		}
	}
	
	/**
	 * Obtem as linhas do arquivo em uma lista IModelo
	 * @return List<IModelo>
	 */
	public List<IModelo> getLista(){
		return manipula.getLinhas();
	}
	
	/**
	 * Remove a linha passara por parametro
	 * @param posicao
	 * @return o mesmo retorno da função chamada
	 * @throws IOException
	 */
	public boolean removeLinha(int posicao) throws IOException {
		return manipula.removeLinha(posicao);
	}
	

}
