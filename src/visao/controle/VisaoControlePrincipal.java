package visao.controle;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import modelo.Serie;
import visao.TelaCadastro;
import visao.TelaLista;
import visao.TelaPrincipal;

public class VisaoControlePrincipal {
	
	private TelaPrincipal TelaPrincipal = null;
	private TelaCadastro TelaCadastro = null;
	private TelaLista TelaLista = null;
	
	private JFrame TelaExibindo = null;
	
	public VisaoControlePrincipal() {
		TelaPrincipal = new TelaPrincipal(this);
	}
	
	public void FecharTelaExibindo() {
		if(TelaExibindo != null) {
			TelaExibindo.dispose();
		}
	}
	
	public void ExibirTelaPrincipal() {
		this.FecharTelaExibindo();
		TelaExibindo = TelaPrincipal;
		TelaExibindo.setVisible(true);
	}
	
	public void ExibirTelaCadastro() {
		this.FecharTelaExibindo();
		this.TelaCadastro = new TelaCadastro(this);
		TelaExibindo = TelaCadastro;
		TelaExibindo.setVisible(true);
	}
	
	public void ExibirTelaCadastro(Serie s, int posicao) {
		this.FecharTelaExibindo();
		this.TelaCadastro = new TelaCadastro(this, s, posicao);
		TelaExibindo = TelaCadastro;
		TelaExibindo.setVisible(true);
	}
	
	public void ExibirTelaLista() {
		this.FecharTelaExibindo();
		this.TelaLista = new TelaLista(this);
		TelaExibindo = TelaLista;
		TelaExibindo.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		VisaoControlePrincipal ctl = new VisaoControlePrincipal();
		
		ctl.ExibirTelaPrincipal();
	}
	

}
