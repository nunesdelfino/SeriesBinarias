package modelo;

import java.io.Serializable;
import java.util.Date;
import utils.DateUtils;


public class Serie implements Serializable, IModelo {

	private static final long serialVersionUID = 4969722851056697744L;
	
	private String Nome;
	private Date Lancamento;
	private Boolean Encerrada;
	private Integer Temporadas;
	private Integer Episodios;
	
	public Serie(String Nome, Date Lancamento, Boolean Encerrada, Integer Temporadas, Integer Episodios) {
		super();
		this.Nome = Nome;
		this.Lancamento = Lancamento;
		this.Encerrada = Encerrada;
		this.Temporadas = Temporadas;
		this.Episodios = Episodios;
		
	}
	
	public Serie(String Nome,  Date Lancamento, Boolean Encerrada, Integer Episodios) {
		super();
		this.Nome = Nome;
		this.Episodios = Episodios;
		this.Lancamento = Lancamento;
		this.Encerrada = Encerrada;
	}
	
	public Serie() {
		super();
	}
	
	public String toString() {
		return "Nome: " + Nome + "\n" +
				"Data de Lançamento: " + DataFormatada() + "\n" +
				"Encerrada: " + Encerrada + "\n" +
				"Número de Temporadas: " + Temporadas + "\n" +
				"Número de Episódios: " + Episodios + "\n\n";
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		this.Nome = nome;
	}

	public Date getLancamento() {
		return Lancamento;
	}

	public void setLancamento(Date lancamento) {
		this.Lancamento = lancamento;
	}

	public Boolean isEncerrada() {
		return Encerrada;
	}

	public void setEncerrada(Boolean encerrada) {
		this.Encerrada = encerrada;
	}

	public Integer getTemporadas() {
		return Temporadas;
	}

	public void setTemporadas(Integer temporadas) {
		this.Temporadas = temporadas;
	}

	public Integer getEpisodios() {
		return Episodios;
	}

	public void setEpisodios(Integer episodios) {
		this.Episodios = episodios;
	}
	
	public String getAtributoNome(int Coluna) {
		
		String NomeColuna = "";
		
		switch(Coluna) {
			case 0:
				NomeColuna = "Nome";
				break;
			case 1:
				NomeColuna = "Data de Lancamento";
				break;
			case 2:
				NomeColuna = "Encerrada";
				break;
			case 3:
				NomeColuna = "Número de Teporadas";
				break;
			case 4:
				NomeColuna = "Número de Episódios";
				break;
		}
		
		return NomeColuna;
		
	}
	
	/**
	 * Retorna uma string com a data formatada
	 * @return
	 */
	public String DataFormatada() {
		return DateUtils.getDia(this.getLancamento()) + "/" + 
				DateUtils.getMes(this.getLancamento()) + "/" +
				DateUtils.getAno(this.getLancamento());
	}
	
	public Object getAtributoValor(int Coluna) {
		
		Object ValorColuna = null;
		
		switch(Coluna) {
			case 0:
				ValorColuna = this.getNome();
				break;
			case 1:
				ValorColuna = DataFormatada();
				break;
			case 2:
				ValorColuna = this.isEncerrada()?"Sim":"Não";
				break;
			case 3:
				ValorColuna = this.getTemporadas();
				break;
			case 4:
				ValorColuna = this.getEpisodios();
				break;
		}
		
		return ValorColuna;
	}
	
	public int getNumeroAtributos() {
		return 5;
	}
	
}
