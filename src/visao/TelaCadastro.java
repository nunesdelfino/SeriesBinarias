package visao;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
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

import modelo.Serie;
import net.miginfocom.swing.MigLayout;
import teste.TesteSerializado;
import visao.controle.VisaoControlePrincipal;

@SuppressWarnings("serial")
public class TelaCadastro extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel TextNome;
	private JLabel TxtDataLancamento;
	private JLabel TxtEncerrada;
	private JLabel TxtNumTemporadas;
	private JLabel TxtNumEpisodios;
	private JTextField InpNome;
	private JTextField InpNumTemporadas;
	private JTextField InpNumEpisodios;
	private JRadioButton BtnSim;
	private JRadioButton BtnNao;
	private JButton BtnSalvar;
	private JButton BtnListar;
	private JDateChooser InpDataLancamento;
	private VisaoControlePrincipal VisaoControle;
	private JLabel lblNewLabel_6;
	private JButton BtnCancelar;
	private JPanel panel_2;
	private final ButtonGroup buttonGroup = new ButtonGroup();

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
		
		TextNome = new JLabel(" Nome da s\u00E9rie: ");
		TextNome.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		panel_1.add(TextNome, "cell 0 1,alignx left");
		
		InpNome = new JTextField();
		panel_1.add(InpNome, "cell 1 1,growx");
		InpNome.setColumns(10);
		
		TxtDataLancamento = new JLabel(" Data de lan\u00E7amento: ");
		TxtDataLancamento.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		panel_1.add(TxtDataLancamento, "cell 0 2,alignx left");
		
		InpDataLancamento = new JDateChooser();
//		BorderLayout bl_InpDataLancamento = (BorderLayout) InpDataLancamento.getLayout();
		JTextFieldDateEditor editor = (JTextFieldDateEditor) InpDataLancamento.getDateEditor();
		editor.setEditable(false);
		
		panel_1.add(InpDataLancamento, "cell 1 2,grow");
		
		TxtEncerrada = new JLabel(" Est\u00E1 encerrada?");
		TxtEncerrada.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		panel_1.add(TxtEncerrada, "cell 0 3");
		
		BtnSim = new JRadioButton("Sim");
		buttonGroup.add(BtnSim);
		BtnSim.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		panel_1.add(BtnSim, "flowx,cell 1 3");
		
		TxtNumTemporadas = new JLabel(" N\u00FAmero de temporadas :");
		TxtNumTemporadas.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		panel_1.add(TxtNumTemporadas, "cell 0 4,alignx left");
		
		InpNumTemporadas = new JTextField();
		panel_1.add(InpNumTemporadas, "cell 1 4,growx");
		InpNumTemporadas.setColumns(10);
		
		TxtNumEpisodios = new JLabel(" N\u00FAmero de epis\u00F3dios: ");
		TxtNumEpisodios.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		panel_1.add(TxtNumEpisodios, "cell 0 5,alignx left");
		
		InpNumEpisodios = new JTextField();
		panel_1.add(InpNumEpisodios, "cell 1 5,growx");
		InpNumEpisodios.setColumns(10);
		
		BtnNao = new JRadioButton("N\u00E3o");
		buttonGroup.add(BtnNao);
		BtnNao.setSelected(true);
		BtnNao.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		panel_1.add(BtnNao, "cell 1 3");
		
		lblNewLabel_6 = new JLabel("Cadastro de s\u00E9ries");
		lblNewLabel_6.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 18));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_6, BorderLayout.NORTH);
		
		panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		BtnSalvar = new JButton("Salvar");
		BtnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TestarBotaoSalvar();
			}
		});
		BtnSalvar.setPreferredSize(new Dimension(130, 30));
		BtnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_2.add(BtnSalvar);
		
		BtnCancelar = new JButton("Cancelar");
		BtnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getVisaoControle().ExibirTelaPrincipal();
			}
		});
		BtnCancelar.setPreferredSize(new Dimension(130, 30));
		BtnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_2.add(BtnCancelar);
		
		BtnListar = new JButton("Visualizar lista");
		BtnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getVisaoControle().ExibirTelaLista();
			}
		});
		BtnListar.setPreferredSize(new Dimension(130, 30));
		BtnListar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_2.add(BtnListar);
		
	}
	
	public VisaoControlePrincipal getVisaoControle() {
			
		return VisaoControle;
	}
	
	public void TestarBotaoSalvar() {
		
		Integer Episodios;
		Integer Temporadas;
		Boolean Encerrada;
		
		Episodios = Integer.parseUnsignedInt(this.InpNumEpisodios.getText());
		Temporadas = Integer.parseUnsignedInt(this.InpNumTemporadas.getText());
		
		if(this.BtnSim.isSelected()) {
			Encerrada = true;
		} else {
			Encerrada = false;
		}
		
		Serie s = new Serie(this.InpNome.getText(), this.InpDataLancamento.getDate(), Encerrada, Temporadas, Episodios);
		
		TesteSerializado.testeInclusao(s);
		
		TesteSerializado.testeLeitura();
		
	}

}