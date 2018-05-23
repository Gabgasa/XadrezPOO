package tabuleiro;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.io.File;
import java.io.IOException;
import pecas.*;
import java.util.Vector;
import estruturas.*;

public class Tabuleiro extends JPanel 
{
	
	public Tabuleiro()
	{
		super();
		preencheVetor();
		inicializaMatriz();
		idxPecaSelecionada = -1;
		
	}
	
	private Image img;
	private String [] im = {"CyanR.png", "CyanN.png", "CyanB.png", "CyanK.png", "CyanQ.png", "CyanB.png", "CyanN.png", "CyanR.png"
			, "CyanP.png", "CyanP.png", "CyanP.png", "CyanP.png", "CyanP.png", "CyanP.png", "CyanP.png"
			, "CyanP.png", "PurpleP.png", "PurpleP.png", "PurpleP.png"
			, "PurpleP.png", "PurpleP.png", "PurpleP.png", "PurpleP.png", "PurpleP.png", "PurpleR.png"
			, "PurpleN.png", "PurpleB.png", "PurpleQ.png", "PurpleK.png", "PurpleB.png", "PurpleN.png", "PurpleR.png"};
	
	private Vector<Peca> pecas = new Vector<Peca>();
	
	private int idxPecaSelecionada;
	
	public int [][] posicoes = new int [8][8];
	
	private Vector<Pair<Integer, Integer>> movimentos;
	
	private void preencheVetor()
	{
		// Jogador roxo (primeiro)
		for(int i=0; i<8; i++)
			pecas.add(new Peao(-1, new Pair<Integer, Integer>(i, 6), this));
		pecas.add(new Torre(-1, new Pair<Integer, Integer>(0, 7), this));
		pecas.add(new Torre(-1, new Pair<Integer, Integer>(7, 7), this));
		pecas.add(new Cavalo(-1, new Pair<Integer, Integer>(1, 7), this));
		pecas.add(new Cavalo(-1, new Pair<Integer, Integer>(6, 7), this));
		pecas.add(new Bispo(-1, new Pair<Integer, Integer>(2, 7), this));
		pecas.add(new Bispo(-1, new Pair<Integer, Integer>(5, 7), this));
		pecas.add(new Rainha(-1, new Pair<Integer, Integer>(3, 7), this));
		pecas.add(new Rei(-1, new Pair<Integer, Integer>(4, 7), this));
		// Jogador azul (segundo)
		for(int i=0; i<8; i++)
			pecas.add(new Peao(1, new Pair<Integer, Integer>(i, 1), this));
		pecas.add(new Torre(1, new Pair<Integer, Integer>(0, 0), this));
		pecas.add(new Torre(1, new Pair<Integer, Integer>(7, 0), this));
		pecas.add(new Cavalo(1, new Pair<Integer, Integer>(1, 0), this));
		pecas.add(new Cavalo(1, new Pair<Integer, Integer>(6, 0), this));
		pecas.add(new Bispo(1, new Pair<Integer, Integer>(2, 0), this));
		pecas.add(new Bispo(1, new Pair<Integer, Integer>(5, 0), this));
		pecas.add(new Rainha(1, new Pair<Integer, Integer>(3, 0), this));
		pecas.add(new Rei(1, new Pair<Integer, Integer>(4, 0), this));
	}
	
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		Graphics2D g2d=(Graphics2D) g;
		int i=0,j=0;
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		double sz = screenSize.width/2;
		double leftX=0;/* Posição inicial no eixo X do topo superior esquerdo do primeiro retangulo */
		double topY=0; /* Posição inicial no eixo Y do topo superior esquerdo do primeiro retangulo */
		int lado = ((int)sz/8); /* Lado dos quadrados */

			
			for(i=0;i<8;i++) /* Inicializando matriz de posições com -1 */
			{
				for(j=0;j<8;j++)
				{
					posicoes[i][j]=-1;
				}
			}
			
			i=0;
			j=0;
			
			while(i<8)
			{
				if(i%2 == 0) /* Essa verificação é para inverter as cores quando pudar de linha */
				{
					for(j=0; j<8; j++)
					{
						if(j%2 == 0)
						{
							Rectangle2D rt=new Rectangle2D.Double(leftX,topY,lado,lado);
							g2d.setPaint(Color.black);
							g2d.fill(rt);
							leftX += lado; /* Adicionando lado para proxima coluna*/
							
						}
						else
						{
							Rectangle2D rt=new Rectangle2D.Double(leftX,topY,lado,lado);
							g2d.setPaint(Color.white);
							g2d.fill(rt);
							leftX += lado;
							
						}
					
					}
					topY += lado; /* Adicionando lado para a proxima linha */
					leftX = 0; /* Reseta a posição horizontal para começar uma nova linha */
					i++;
				}
				else
				{
					for(j=0; j<8; j++)
					{
						if(j%2 == 0)
						{
							Rectangle2D rt=new Rectangle2D.Double(leftX,topY,lado,lado);
							g2d.setPaint(Color.white);
							g2d.fill(rt);
							leftX += lado;
							
						}
						else
						{
							Rectangle2D rt=new Rectangle2D.Double(leftX,topY,lado,lado);
							g2d.setPaint(Color.black);
							g2d.fill(rt);
							leftX += lado;
						}
					
					}
					topY += lado; /* Adiciona o valor do lado para a proxima linha*/
					leftX = 0; /* Reseta a posição horizontal para começar uma nova linha */
					i++;
				}
			}
			
			/*Desenha todas as pecas na posicao correta de acordo com o vetor de pecas*/
			for(i=0;i<pecas.size();i++)
			{
				try {
					img=ImageIO.read(new File(pecas.elementAt(i).image));
				}
					catch(IOException e) {
					System.out.println(e.getMessage());
					System.exit(1);
				}
				g.drawImage(img, ((int)(pecas.elementAt(i).getPosition().getFirst()*lado+0.20*lado)),
						((int)(pecas.elementAt(i).getPosition().getSecond()*lado+0.20*lado)), null);
			}
			
			
	}
	
	private void inicializaMatriz() 
	{
		for(int i =0; i<8; i++)
			for(int j=0; j<8; j++)
				posicoes[i][j] = -1;
		for(int i=0; i<pecas.size(); i++) 
		{
			if(pecas.elementAt(i).getPosition().getFirst()==-1)
				continue;
			posicoes[pecas.elementAt(i).getPosition().getFirst()][pecas.elementAt(i).getPosition().getSecond()] = i;
		}
	}
	
	public static void main(String[] args) 	
	{
		JFrame tab = new JFrame();
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		double sz = screenSize.width/2;
		tab.setSize((int)sz,(int)sz);
		tab.getContentPane().add(new Tabuleiro());;
		tab.addMouseListener(new ControleEvento());
		tab.setLocationRelativeTo(null);
		tab.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tab.setVisible(true);
	}
	
	private void boardClickCallback(int x, int y) 
	{
		if(idxPecaSelecionada==-1) // Selecionando peca para mover 
		{
			idxPecaSelecionada = posicoes[x][y];
			if(idxPecaSelecionada==-1)
				return;
			movimentos = pecas.elementAt(idxPecaSelecionada).possiveisMovimentos();
		}
		else // Selecionando para onde mover
		{
			if(movimentos.contains(new Pair<Integer, Integer>(x, y))) 
			{
				pecas.elementAt(idxPecaSelecionada).move(new Pair<Integer, Integer>(x, y));
				Peca possivelInimigo = 
						pecas.elementAt(posicoes[pecas.elementAt(idxPecaSelecionada).getPosition().getFirst()][pecas.elementAt(idxPecaSelecionada).getPosition().getSecond()]);
				if(possivelInimigo!=null && possivelInimigo.getJogador()!=pecas.elementAt(idxPecaSelecionada).getJogador())
					possivelInimigo.captura();
				idxPecaSelecionada = -1;
				inicializaMatriz();
			}
			else if(posicoes[x][y]==-1) 
			{
				idxPecaSelecionada = -1;
			}
			else if(pecas.elementAt(posicoes[x][y]).getJogador()==pecas.elementAt(idxPecaSelecionada).getJogador()) 
			{
				idxPecaSelecionada = posicoes[x][y];
				movimentos = pecas.elementAt(idxPecaSelecionada).possiveisMovimentos();
			}
			else
				idxPecaSelecionada = -1;
		}
	}
	
	public Peca getPeca(Pair<Integer, Integer> pos) 
	{
		if(posicoes[pos.getFirst()][pos.getSecond()]==-1)
			return null;
		return pecas.elementAt(posicoes[pos.getFirst()][pos.getSecond()]);
	}
	
}

