package Controle;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import javax.swing.JOptionPane;


import pecas.Bispo;
import pecas.Cavalo;
import pecas.Peao;
import pecas.Peca;
import pecas.Rainha;
import pecas.Rei;
import pecas.Torre;
import tabuleiro.Tabuleiro;
import tabuleiro.MenuInicial;

public class Controlador {
	
	private Tabuleiro tab;
	JFrame inicio = new JFrame("Chess");
	public static JFrame ini;
	
	public static void main(String[] args) 	
	{		
		ini = new JFrame("Chess");
		Controlador control = new Controlador(Tabuleiro.getInstance());
		control.ShowTabuleiro();
		control.ShowMenuini();
	}
	
	public Controlador(Tabuleiro tabuleiro)
	{
		tab = tabuleiro;
	}
	
	
	
	private void ShowMenuini()
	{
		ini.setBackground(Color.BLACK);
		ini.getContentPane().add(new MenuInicial());
		ini.setSize(500, 500);
		ini.setVisible(true);
		ini.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ini.setResizable(false);
		ini.setLocationRelativeTo(null);
		
	}
	
	private JFrame ShowTabuleiro()
	{
		JFrame tab = new JFrame();
		tab.getContentPane().add(Tabuleiro.getInstance());
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		double sz = screenSize.width/2;
		tab.setSize((int)sz+16,(int)sz+40);
		tab.setLocationRelativeTo(null);
		tab.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tab.setVisible(true);
		tab.setResizable(false);
		
		return tab;
	}
	
	public void LoadGame()
	{
		//Abrindo o Filechooser e escolhendo o arquivo txt correto
		File file = null;
		final JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int returnVal = fc.showDialog(fc, "Load Game");
		if(returnVal == JFileChooser.APPROVE_OPTION)
			file = fc.getSelectedFile();
		else
			System.out.print("Nenhum arquivo escolhido");
		
		//Leitura do arquivo aberto
		try 
		{
			FileReader reader = new FileReader(file);
			BufferedReader bReader = new BufferedReader(reader);
			StringBuffer sBuffer = new StringBuffer();
			String line;
			
			
			line = bReader.readLine();
			String turno = line;
			int turn = Integer.parseInt(line);
		
			//Carregamento dos valores do arquivo no vetor de peças
			tab.limpaPecas();
			tab.setTurno(turn);
			
			while((line = bReader.readLine()) != null)
			{
				String[] partes = line.split(",");
				
				int PosicaoX = Integer.parseInt(partes[0]);
				int PosicaoY = Integer.parseInt(partes[1]);
				int Jogador = Integer.parseInt(partes[2]);
				int TipoPeca = Integer.parseInt(partes[3]);
				
				tab.addPeca(PosicaoX, PosicaoY, Jogador, TipoPeca);
				
			}
			
		}	catch (IOException e) { System.out.println("Erro ao dar load game"); }
		
	}
	
	public void MenuInicial(int NewOrLoad)
	{		
		//New game
		if(NewOrLoad == 0)
		{
			tab.preencheVetor();
			ini.setVisible(false);
		}
		//Load game
		if(NewOrLoad == 1)
		{
			LoadGame();
			ini.setVisible(false);
		}
	}
	
	public void MenuFinal(String mensagem)
	{
		String[] option = {"Voltar para menu inicial"};
		int FinalJogo = JOptionPane.showOptionDialog(
				null, 
				mensagem, 
				"Fim da partida", 
				JOptionPane.DEFAULT_OPTION, 
				JOptionPane.INFORMATION_MESSAGE, 
				null, option, null);
		
		if(FinalJogo == 0)
		{
			this.ShowMenuini();
			
		}
	}
	
	public void SaveGame()
	{
		int i;
		String path = null;
		Vector<Peca> pecas = new Vector<Peca>();
		pecas = tab.getPecas();
		
		//Escolhendo local e nome do salvamento do jogo
		JFileChooser fs = new JFileChooser();	
		int returnVal = fs.showSaveDialog(fs);	
		if(returnVal == JFileChooser.APPROVE_OPTION)
			{
				path = fs.getSelectedFile().getAbsolutePath();
			}
		else
			System.out.print("Nenhum arquivo escolhido");
		
		
		//Salvando jogo no local escolhido
		try {
		
				PrintWriter save = new PrintWriter(new File(path + ".txt"));
				save.println(tab.getTurno()); // Colocando o turno no arquivo
		
				for(i=0 ; i< pecas.size() ; i++)
				{
					if(pecas.elementAt(i) instanceof Peao)
					{
						save.println( pecas.elementAt(i).getPosition().getFirst()
								+ "," + pecas.elementAt(i).getPosition().getSecond()
								+ "," + pecas.elementAt(i).getJogador()
								+ "," + 1);
					}	
			
					if(pecas.elementAt(i) instanceof Bispo)
					{
						save.println( pecas.elementAt(i).getPosition().getFirst()
								+ "," + pecas.elementAt(i).getPosition().getSecond()
								+ "," + pecas.elementAt(i).getJogador()
								+ "," + 2);
					}
			
					if(pecas.elementAt(i) instanceof Cavalo)
					{
						save.println( pecas.elementAt(i).getPosition().getFirst()
								+ "," + pecas.elementAt(i).getPosition().getSecond()
								+ "," + pecas.elementAt(i).getJogador()
								+ "," + 3);
					}
			
					if(pecas.elementAt(i) instanceof Rainha)
					{
						save.println( pecas.elementAt(i).getPosition().getFirst()
								+ "," + pecas.elementAt(i).getPosition().getSecond()
								+ "," + pecas.elementAt(i).getJogador()
								+ "," + 4);
					}
			
					if(pecas.elementAt(i) instanceof Rei)
					{
						save.println( pecas.elementAt(i).getPosition().getFirst()
								+ "," + pecas.elementAt(i).getPosition().getSecond()
								+ "," + pecas.elementAt(i).getJogador()
								+ "," + 5);
					}
			
					if(pecas.elementAt(i) instanceof Torre)
					{
						save.println( pecas.elementAt(i).getPosition().getFirst()
								+ "," + pecas.elementAt(i).getPosition().getSecond()
								+ "," + pecas.elementAt(i).getJogador()
								+ "," + 6);
					}
				}
		
				save.close();
			}
		catch(IOException ioe){ System.out.println("Erro ao salvar o arquivo");}
		
		}
	
	
	

}
