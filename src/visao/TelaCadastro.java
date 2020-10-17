package visao;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import controle.ControleSerie;
import controle.SaveRead;
import modelo.Serie;
import net.miginfocom.swing.MigLayout;
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
	
	private ControleSerie Controle = new ControleSerie();
	
	
	String Nome;
	Date Lancamento;
	Boolean Encerrada;
	Integer Temporadas;
	Integer Episodios;
	
	String tituloJanela = "Cadastro de Séries";
	
	Integer posicao;
	

	/**
	 * Launch the application.
	 * @wbp.parser.constructor
	 */
	public TelaCadastro(VisaoControlePrincipal VisaoCtrl) {
		super();
		this.VisaoControle = VisaoCtrl;
		InicializarTela();
	}
	
	public TelaCadastro(VisaoControlePrincipal VisaoCtrl, Serie s, int posicao) {
		super();
		this.VisaoControle = VisaoCtrl;
		this.tituloJanela = "Ediar Série";
		InicializarTela();
		DefineDados(s);
		this.posicao = posicao;
		
	}

	/**
	 * Create the frame.
	 */
	public void InicializarTela() {
		setTitle(tituloJanela);
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
		InpNumTemporadas.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent event) {
				
				if(event.getKeyChar() >= '0' && event.getKeyChar() <= '9' || ((int) event.getKeyChar()) == 8) {
					InpNumTemporadas.setEditable(true);
				} else {
					InpNumTemporadas.setEditable(false);
				}
			}
		});
		panel_1.add(InpNumTemporadas, "cell 1 4,growx");
		InpNumTemporadas.setColumns(10);
		
		TxtNumEpisodios = new JLabel(" N\u00FAmero de epis\u00F3dios: ");
		TxtNumEpisodios.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		panel_1.add(TxtNumEpisodios, "cell 0 5,alignx left");
		
		InpNumEpisodios = new JTextField();
		InpNumEpisodios.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent event) {
				
				if(event.getKeyChar() >= '0' && event.getKeyChar() <= '9' || ((int) event.getKeyChar()) == 8) {
					InpNumEpisodios.setEditable(true);
				} else {
					InpNumEpisodios.setEditable(false);
				}
			}
		});
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
				SalvarDados();
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
	
	public void DefineDados(Serie s) {
		
		this.InpNome.setText(s.getNome());
		this.InpNumTemporadas.setText(Integer.toString(s.getTemporadas()));
		this.InpNumEpisodios.setText(Integer.toString(s.getEpisodios()));
		if(s.isEncerrada()) {
			this.BtnSim.setSelected(true);
		} else {
			this.BtnNao.setSelected(true);
		}
		this.InpDataLancamento.setDate(s.getLancamento());
		this.BtnSalvar.setText("Editar");
		
	}
	
	public void editar() {
		
		try {
			Controle.removeLinha(this.posicao);
			valoresSalvar();
			getVisaoControle().ExibirTelaLista();
			JOptionPane.showMessageDialog(null, "Edição realizada com sucesso", "Editar", JOptionPane.INFORMATION_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Não foi possivel editar linha", "Editar", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
	public void Salvar() {
		
		valoresSalvar();
		JOptionPane.showMessageDialog(null, "Série salva com sucesso", "Salvar", JOptionPane.INFORMATION_MESSAGE);
		
	}

	public void valoresSalvar() {
		if(!this.InpNome.getText().equals("") &&
				this.InpDataLancamento.getDate() != null &&
				!this.InpNumEpisodios.getText().equals("") &&
				!this.InpNumTemporadas.getText().equals("")) {

			Integer Episodios;
			Integer Temporadas;
			Boolean Encerrada;
			SaveRead incluirDados = new SaveRead();
			
			Episodios = Integer.parseUnsignedInt(this.InpNumEpisodios.getText());
			Temporadas = Integer.parseUnsignedInt(this.InpNumTemporadas.getText());
			
			if(this.BtnSim.isSelected()) {
				Encerrada = true;
			} else {
				Encerrada = false;
			}
			
			Serie s = new Serie(this.InpNome.getText(), this.InpDataLancamento.getDate(), Encerrada, Temporadas, Episodios);
			
			
			incluirDados.Incluir(s);
			
			LimparTela();
			
		} else {
			String Mensagem = "Todos os campos devem estar preenchidos!";
			JOptionPane.showMessageDialog(null, Mensagem, null, JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void SalvarDados() {
		if(this.BtnSalvar.getText().equals("Salvar")) {
			Salvar();
		} else if(this.BtnSalvar.getText().equals("Editar")) {
			editar();
		}
	}

	private void LimparTela() {

		this.InpNome.setText("");
		this.InpNumTemporadas.setText("");
		this.InpNumEpisodios.setText("");
		this.BtnSim.setSelected(false);
		this.BtnNao.setSelected(false);
		this.InpDataLancamento.setDate(null);
		
		
	}

}