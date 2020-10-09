package visao.controle;

import javax.swing.JFrame;

import visao.TelaFormulario;
import visao.TelaLista;
import visao.TelaPrincipal;

public class VisaoControlePrincipal {
	
	private TelaPrincipal TelaPrincipal = null;
	private TelaFormulario TelaFormulario = null;
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
	
	public void ExibirTelaFormulario() {
		this.FecharTelaExibindo();
		this.TelaFormulario = new TelaFormulario(this);
		TelaExibindo = TelaFormulario;
		TelaExibindo.setVisible(true);
	}
	
	public void ExibirTelaLista() {
		this.FecharTelaExibindo();
		this.TelaLista = new TelaLista(this);
		TelaExibindo = TelaLista;
		TelaExibindo.setVisible(true);
	}
	
	public static void main(String[] args) {
		VisaoControlePrincipal ctl = new VisaoControlePrincipal();
		ctl.ExibirTelaPrincipal();
	}

}
