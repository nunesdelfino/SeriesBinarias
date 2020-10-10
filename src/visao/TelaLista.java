package visao;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import visao.controle.VisaoControlePrincipal;

@SuppressWarnings("serial")
public class TelaLista extends JFrame {

	private JPanel contentPane;
	@SuppressWarnings("unused")
	private VisaoControlePrincipal VisaoControle;
	

	/**
	 * Create the frame.
	 */
	public TelaLista(VisaoControlePrincipal VisaoCtrl) {
		super();
		this.VisaoControle = VisaoCtrl;
		InicializarTela();
		
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void InicializarTela() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 360);
		setMinimumSize(new Dimension(600, 360));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
	}

}
