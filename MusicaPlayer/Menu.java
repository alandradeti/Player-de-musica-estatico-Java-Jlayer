package MusicaPlayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

public class Menu extends JFrame {

	private final JPanel contentPane;
	private final JButton btnMusica;
	private final JButton btnAutor;
	private final JButton btnPlayer;
	private final JButton btnFinalizar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnMusica = new JButton("Música");
		btnMusica.setBounds(85, 306, 111, 23);
		btnMusica.setToolTipText("Clique para Gerenciar suas músicas");
		
		
		btnAutor = new JButton("Autor");
		btnAutor.setBounds(85, 306, 111, 23);
		btnAutor.setToolTipText("Clique para Gerenciar os artistas");
		
		btnPlayer = new JButton("Player");
		btnPlayer.setBounds(85, 306, 111, 23);
		btnAutor.setToolTipText("Clique para ouvir suas músicas");
		
		JLabel lblMenuPrincipal = new JLabel("Menu Principal");
		lblMenuPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblMenuPrincipal, BorderLayout.CENTER);
		
		panel.add(btnPlayer);
		panel.add(btnAutor);
		panel.add(btnMusica);
		
		btnFinalizar = new JButton("Encerrar Sess\u00E3o");
		contentPane.add(btnFinalizar, BorderLayout.SOUTH);
		btnFinalizar.setToolTipText("Clique para finalizar o programa!");
		
                /*Chamando as funções dos botões*/
		botoes();
	}
	
        /*Chamar novas janelas*/
	public void botoes(){
		btnMusica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NovaMusica t = new NovaMusica();
				t.setVisible(true);
			}
		});
		
		btnAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NovoArtista t = new  NovoArtista();
				t.setVisible(true);
			}
		});
		
		btnPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mp3 t = new Mp3();
				t.setVisible(true);
			}
		});
		
                /*Finalizar Programa*/
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
	}

}