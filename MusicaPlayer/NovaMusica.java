package MusicaPlayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class NovaMusica extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtAlbum;
	private JTextField txtFaixa;
	private JTextField txtAno;
	private JTextField txtArtistaAlbum;
	private JTextField txtArtista;
	private JTextField txtGen;
	private JTextField txtCompositor;
	private JButton btnCadastrar;
	private JButton btnRemover;
	private JButton btnRetornar;
	DefaultTableModel dtm;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovaMusica frame = new NovaMusica();
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
	public NovaMusica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 833, 754);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		btnRemover = new JButton("Remover");
		btnRemover.setBounds(341, 306, 122, 23);
		btnRemover.setToolTipText("Selecione o registro para remo��o.");
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(85, 306, 111, 23);
		btnCadastrar.setToolTipText("Clique para adicionar � tabela.");
		
		btnRetornar = new JButton("Retornar");
		btnRetornar.setBounds(614, 306, 122, 23);
		btnRetornar.setToolTipText("Clique para retornar ao Menu.");
		
		JLabel lblTitulo = new JLabel("Titulo :");
		lblTitulo.setBounds(75, 15, 70, 14);
		panel.add(lblTitulo);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(139, 12, 173, 20);
		panel.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JLabel lblAlbum = new JLabel("Album :");
		lblAlbum.setBounds(75, 55, 82, 14);
		panel.add(lblAlbum);
		
		txtAlbum = new JTextField();
		txtAlbum.setBounds(149, 52, 132, 20);
		panel.add(txtAlbum);
		txtAlbum.setColumns(10);
		
		JLabel lblFaixa = new JLabel("Faixa :");
		lblFaixa.setBounds(77, 94, 70, 14);
		panel.add(lblFaixa);
		
		txtFaixa = new JTextField();
		txtFaixa.setBounds(139, 91, 57, 20);
		panel.add(txtFaixa);
		txtFaixa.setColumns(10);
		
		JLabel lblAno = new JLabel("Ano :");
		lblAno.setBounds(243, 94, 46, 14);
		panel.add(lblAno);
		
		txtAno = new JTextField();
		txtAno.setBounds(304, 91, 57, 20);
		panel.add(txtAno);
		txtAno.setColumns(10);
		
		JLabel lblArtistaAlbum = new JLabel("Artista do Album :");
		lblArtistaAlbum.setBounds(77, 144, 137, 14);
		panel.add(lblArtistaAlbum);
		
		txtArtistaAlbum = new JTextField();
		txtArtistaAlbum.setColumns(10);
		txtArtistaAlbum.setBounds(221, 141, 150, 20);
		panel.add(txtArtistaAlbum);
		
		JLabel lblArtista = new JLabel("Artista :");
		lblArtista.setBounds(77, 169, 70, 14);
		panel.add(lblArtista);
		
		txtArtista = new JTextField();
		txtArtista.setColumns(10);
		txtArtista.setBounds(157, 166, 132, 20);
		panel.add(txtArtista);
		
		JLabel lblGen = new JLabel("G\u00EAnero :");
		lblGen.setBounds(77, 199, 70, 14);
		panel.add(lblGen);
		
		txtGen = new JTextField();
		txtGen.setColumns(10);
		txtGen.setBounds(154, 196, 102, 20);
		panel.add(txtGen);
		
		JLabel lblCompositor = new JLabel("Compositor :");
		lblCompositor.setBounds(77, 229, 102, 14);
		panel.add(lblCompositor);
		
		txtCompositor = new JTextField();
		txtCompositor.setColumns(10);
		txtCompositor.setBounds(188, 226, 173, 20);
		panel.add(txtCompositor);
		
		panel.add(btnRemover);
		panel.add(btnRetornar);
		panel.add(btnCadastrar);
                
                //Chamar as funções
		botoes();
		
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(38, 340, 759, 332);
		panel.add(scrollPane);
		
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Titulo", "Album", "Faixa", "Ano", "AlbArtista", "Artista", "Genero", "Compositor"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
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
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(6).setResizable(false);
		table.getColumnModel().getColumn(7).setResizable(false);
		scrollPane.setViewportView(table);
		
	}
	
	public void botoes(){
                //Cadastrar na tabela
		btnCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(txtTitulo.getText().equals("") || txtAlbum.getText().equals("") || txtFaixa.getText().equals("") || txtAno.getText().equals("") || txtArtistaAlbum.getText().equals("") || txtArtista.getText().equals("") || txtGen.getText().equals("") || txtCompositor.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
				}else{
					dtm = (DefaultTableModel)table.getModel();
					dtm.addRow(new Object[] {txtTitulo.getText(), txtAlbum.getText(), txtFaixa.getText(), txtAno.getText(), txtArtistaAlbum.getText(), txtArtista.getText(), txtGen.getText(), txtCompositor.getText()});
					txtTitulo.setText("");
					txtAlbum.setText("");
					txtFaixa.setText("");
					txtAno.setText("");
					txtArtistaAlbum.setText("");
					txtArtista.setText("");
					txtGen.setText("");
					txtCompositor.setText("");
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
		
                //Retornar para o menu principal
		btnRetornar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
	}
}
