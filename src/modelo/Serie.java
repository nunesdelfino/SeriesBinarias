package modelo;

import java.io.Serializable;
import java.util.Date;
import utils.DateUtils;


@SuppressWarnings("serial")
public class Serie implements Serializable {

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
	
	public Serie(String Nome, Integer Episodios, Date Lancamento) {
		super();
		this.Nome = Nome;
		this.Episodios = Episodios;
		this.Lancamento = Lancamento;
	}
	
	public Serie() {
		super();
	}
	
	public String toString() {
		return "Nome: " + Nome + "\n" +
				"Data de Lançamento: " + DataFormatada() + "\n" +
				"Encerrada: " + Encerrada + "\n" +
				"Número de Temporadas: " + Temporadas + "\n" +
				"Número de Episódios: " + Episodios;
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
	
	public String DataFormatada() {
		return DateUtils.getDia(this.getLancamento()) + "/" + 
				DateUtils.getMes(this.getLancamento()) + "/" +
				DateUtils.getAno(this.getLancamento());
	}
	
}
