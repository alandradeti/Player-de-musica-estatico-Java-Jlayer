package MusicaPlayer;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import javax.swing.JLabel;


public class Mp3 extends JFrame {

	private final JPanel contentPane;
	private JButton btnPlay;
	private JButton btnPause;
	private JButton btnNext;
	private JButton btnBack;
	private final JButton btnRetornar;
	private JLabel lblNome;
	private javazoom.jl.player.Player ply;
	private boolean pl;
	private int cont = 0;
	private String[] musicas = new String [5];
	private JButton play;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mp3 frame = new Mp3();
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
	public Mp3() {
		//Nome das músicas
		musicas[0] = "01 - G.O";
		musicas[1] = "02 - Kent";
		musicas[2] = "03 - Shape";
		musicas[3] = "04 - Snap";
		musicas[4] = "05 -  Sick";
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 376, 517);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MUSIC PLAYER");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		lblNewLabel.setBounds(125, 11, 109, 37);
		panel.add(lblNewLabel);
	
		//Label que recebe o nome das musicas
		lblNome = new JLabel("Música: ");
		lblNome.setBounds(36, 98, 278, 14);
		panel.add(lblNome);

		//Play
		btnPlay = new JButton("PLAY");
		btnPlay.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				lblNome.setText("Música: "+musicas[0]);
				Musica mp3 = new Musica();
					mp3.start();
					pl = true;
					btnPlay.setEnabled(false);
					btnPause.setEnabled(true);
					btnNext.setVisible(true);
			}
		});
		btnPlay.setToolTipText("Clique para Reproduzir uma musica do seu diretorio");
		btnPlay.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		btnPlay.setBackground(Color.GRAY);
		btnPlay.setBounds(36, 184, 115, 57);
		panel.add(btnPlay);
		
		//Pausar
		btnPause = new JButton("PAUSE");
		btnPause.setEnabled(false);
		btnPause.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ply.close();
				pl =  false;
				btnPlay.setEnabled(true);
			}
		});
		btnPause.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));
		btnPause.setBounds(205, 185, 109, 57);
		btnPause.setToolTipText("Clique para Retornar ao Menu Principal");
		panel.add(btnPause);
		
		//Voltar Música
		btnBack = new JButton("<<");
		btnBack.setVisible(false);
		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				cont--;
				lblNome.setText("Musica: "+musicas[cont]);
				if(pl = true){
					ply.close();
					Musica mp3 =  new Musica();
					mp3.start();
				}
				
				if(cont < 4){
					btnNext.setVisible(true);
				}
				
				if(cont == 0){
					btnBack.setVisible(false);
				}
			}
		});
		btnBack.setBounds(36, 304, 115, 23);
		btnBack.setToolTipText("Clique para a Música Anterior");
		panel.add(btnBack);
		
		//Avançar Música
		btnNext = new JButton(">>");
		btnNext.setVisible(false);
		btnNext.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				cont++;
				btnBack.setVisible(true);
				lblNome.setText("Música: " + musicas[cont]);
				if(pl = true){
					ply.close();
					btnBack.setEnabled(true);
					Musica mp3 = new Musica();
					mp3.start();
				}
				
				if(cont == 4){
					btnNext.setVisible(false);
				}
			}
		});
		btnNext.setBounds(205, 304, 109, 23);
		btnNext.setToolTipText("Clique para a Proxima M�sica");
		panel.add(btnNext);
		
		//Retornar
		btnRetornar = new JButton("Retornar");
		btnRetornar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ply.close();
				}
		});
		contentPane.add(btnRetornar, BorderLayout.SOUTH);
		btnRetornar.setToolTipText("Clique para retornar ao Menu.");
		
	}
	
        //Encontrar música e iniciar música
	class Musica extends Thread{
		public void run(){
			try{
                                //Local onde estão as músicas
				InputStream input = this.getClass().getResourceAsStream("/MusicaPlayer/"+ musicas[cont] + ".mp3");
				ply = new Player(input);
				ply.play(); 
			
			}catch(JavaLayerException e){
				e.printStackTrace();
			}
		}
	}

}