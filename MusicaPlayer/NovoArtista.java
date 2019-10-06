package MusicaPlayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class NovoArtista extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtNacionalidade;
	private JTextField txtGenMusical;
	private JTextField txtPremios;
	private JLabel lblNacionalidade;
	private JLabel lblGenMusical;
	private JLabel lblPremios;
	private JLabel lblDiscos;
	private JTextField txtDiscos;
	private JButton btnCadastrar;
	private JButton btnRetornar;
	DefaultTableModel dtm;
	private JButton btnRemover;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovoArtista frame = new NovoArtista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NovoArtista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 725);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		btnRemover = new JButton("Remover");
		btnRemover.setBounds(179, 269, 105, 29);
		btnRemover.setToolTipText("Selecione o registro para remo��o.");
		
		JLabel lblNome = new JLabel("Nome : ");
		lblNome.setBounds(183, 19, 58, 20);
		panel.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(256, 16, 146, 26);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		lblNacionalidade = new JLabel("Nacionalidade :");
		lblNacionalidade.setBounds(126, 61, 115, 20);
		panel.add(lblNacionalidade);
		
		txtNacionalidade = new JTextField();
		txtNacionalidade.setBounds(256, 58, 146, 26);
		panel.add(txtNacionalidade);
		txtNacionalidade.setColumns(10);
		
		lblGenMusical = new JLabel("G\u00EAnero Musical :");
		lblGenMusical.setBounds(116, 103, 125, 20);
		panel.add(lblGenMusical);
		
		txtGenMusical = new JTextField();
		txtGenMusical.setBounds(256, 100, 146, 26);
		panel.add(txtGenMusical);
		txtGenMusical.setColumns(10);
		
		lblPremios = new JLabel("Pr\u00EAmia\u00E7\u00E3o :");
		lblPremios.setBounds(150, 148, 95, 20);
		panel.add(lblPremios);
		
		txtPremios = new JTextField();
		txtPremios.setBounds(256, 145, 146, 26);
		panel.add(txtPremios);
		txtPremios.setColumns(10);
		
		lblDiscos = new JLabel("Discos de ouro :");
		lblDiscos.setBounds(116, 202, 125, 20);
		panel.add(lblDiscos);
		
		txtDiscos = new JTextField();
		txtDiscos.setBounds(256, 199, 146, 26);
		panel.add(txtDiscos);
		txtDiscos.setColumns(10);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(15, 269, 105, 29);
		btnCadastrar.setToolTipText("Clique para adicionar � tabela.");
		
		btnRetornar = new JButton("Retornar");
		btnRetornar.setBounds(376, 269, 115, 29);
		btnRetornar.setToolTipText("Clique para retornar ao Menu.");
	
		panel.add(btnRemover);
		panel.add(btnRetornar);
		panel.add(btnCadastrar);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(15, 309, 476, 278);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Nacionalidade", "GenMusical", "Premiacao", "DiscOuro"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		scrollPane.setViewportView(table);
                
                //Chamar funções
		botoes();
	}
	
	public void botoes(){
                //Cadastrar na tabela
		btnCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(txtNome.getText().equals("") || txtNacionalidade.getText().equals("") || txtGenMusical.getText().equals("") || txtPremios.getText().equals("") || txtDiscos.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
				}else{
					dtm = (DefaultTableModel)table.getModel();
					dtm.addRow(new Object[] {txtNome.getText(), txtNacionalidade.getText(), txtGenMusical.getText(), txtPremios.getText(), txtDiscos.getText()});
					txtNome.setText("");
					txtNacionalidade.setText("");
					txtGenMusical.setText("");
					txtPremios.setText("");
					txtDiscos.setText("");
				}
				}
		});
		
                //Remover da tabela
		btnRemover.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int[] linhas  = table.getSelectedRows();
				DefaultTableModel dtm = (DefaultTableModel)table.getModel();
				for (int i = (linhas.length - 1);i>=0;--i){
					dtm.removeRow(linhas[i]);
				}
			}
		});
		
                //Voltar ao menu principal
		btnRetornar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				}
		});
		
	}
}