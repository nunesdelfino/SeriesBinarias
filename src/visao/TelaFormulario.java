package visao;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import visao.controle.VisaoControlePrincipal;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class TelaFormulario extends JFrame {

	private JPanel contentPane;
	@SuppressWarnings("unused")
	private VisaoControlePrincipal VisaoControle;

	/**
	 * Create the frame.
	 */
	public TelaFormulario(VisaoControlePrincipal VisaoCtrl) {
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
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][]", "[][]"));
		
		JLabel lblNewLabel = new JLabel("New label");
		contentPane.add(lblNewLabel, "cell 0 0");
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		contentPane.add(lblNewLabel_1, "cell 1 1");
	}

}
