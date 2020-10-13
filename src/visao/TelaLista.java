package visao;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import visao.controle.VisaoControlePrincipal;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class TelaLista extends JFrame {

	private JPanel contentPane;
	@SuppressWarnings("unused")
	private VisaoControlePrincipal VisaoControle;
	private JTable table;
	

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
		
		table = new JTable();
		table.setToolTipText("");
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		contentPane.add(table, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Lista de S\u00E9ries");
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
	}

}
