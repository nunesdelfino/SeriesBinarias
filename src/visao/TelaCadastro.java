package visao;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import net.miginfocom.swing.MigLayout;
import visao.controle.VisaoControlePrincipal;
import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class TelaCadastro extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_4;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JDateChooser dateChooser;
	private VisaoControlePrincipal VisaoControle;
	private JLabel lblNewLabel_6;
	private JButton btnNewButton_2;
	private JPanel panel_2;

	/**
	 * Launch the application.
	 */
	public TelaCadastro(VisaoControlePrincipal VisaoCtrl) {
		super();
		this.VisaoControle = VisaoCtrl;
		InicializarTela();
	}

	/**
	 * Create the frame.
	 */
	public void InicializarTela() {
		setTitle("Séries Binárias");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 445, 360);
		setMinimumSize(new Dimension(600, 360));
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Cadastro de s\u00E9ries");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new MigLayout("", "[][grow]", "[][][:5.00:20px,fill][][][][][][]"));
		
		lblNewLabel_1 = new JLabel(" Nome da s\u00E9rie: ");
		panel_1.add(lblNewLabel_1, "cell 0 1,alignx left");
		
		textField = new JTextField();
		panel_1.add(textField, "cell 1 1,growx");
		textField.setColumns(10);
		
		lblNewLabel_2 = new JLabel(" Data de lan\u00E7amento: ");
		panel_1.add(lblNewLabel_2, "cell 0 2,alignx left");
		
		dateChooser = new JDateChooser();
		BorderLayout borderLayout = (BorderLayout) dateChooser.getLayout();
		JTextFieldDateEditor editor = (JTextFieldDateEditor) dateChooser.getDateEditor();
		editor.setEditable(false);
		
		panel_1.add(dateChooser, "cell 1 2,grow");
		
		lblNewLabel_3 = new JLabel(" Est\u00E1 encerrada?");
		panel_1.add(lblNewLabel_3, "cell 0 3");
		
		rdbtnNewRadioButton = new JRadioButton("Sim");
		panel_1.add(rdbtnNewRadioButton, "flowx,cell 1 3");
		
		lblNewLabel_4 = new JLabel(" N\u00FAmero de temporadas :");
		panel_1.add(lblNewLabel_4, "cell 0 4,alignx left");
		
		textField_3 = new JTextField();
		panel_1.add(textField_3, "cell 1 4,growx");
		textField_3.setColumns(10);
		
		lblNewLabel_5 = new JLabel(" N\u00FAmero de epis\u00F3dios: ");
		panel_1.add(lblNewLabel_5, "cell 0 5,alignx left");
		
		textField_4 = new JTextField();
		panel_1.add(textField_4, "cell 1 5,growx");
		textField_4.setColumns(10);
		
		rdbtnNewRadioButton_1 = new JRadioButton("N\u00E3o");
		panel_1.add(rdbtnNewRadioButton_1, "cell 1 3");
		
		lblNewLabel_6 = new JLabel("Cadastro de s\u00E9ries");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_6, BorderLayout.NORTH);
		
		panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		btnNewButton = new JButton("Salvar");
		panel_2.add(btnNewButton);
		
		btnNewButton_2 = new JButton("Cancelar");
		panel_2.add(btnNewButton_2);
		
		btnNewButton_1 = new JButton("Visualizar lista");
		panel_2.add(btnNewButton_1);
		
	}

}