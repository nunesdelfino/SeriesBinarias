package controle;

import java.io.IOException;
import java.util.List;

import arquivo.ManipulaArquivoSerializado;
import modelo.IModelo;

public class ControleSerie {
	
	private ManipulaArquivoSerializado Manipula;
	
	public ControleSerie() {
		
		try {
			Manipula = new ManipulaArquivoSerializado("RegistroSeries", "Series.karen");
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<IModelo> getLista(){
		return Manipula.getLinhas();
	}
	
	public void removeLinha(int posicao) {
		Manipula.RemoveLinha(posicao);
	}
	

}
