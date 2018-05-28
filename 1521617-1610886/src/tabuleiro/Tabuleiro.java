package tabuleiro;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.io.File;
import java.io.IOException;
import pecas.*;
import java.util.*;
import estruturas.*;

public class Tabuleiro extends JPanel
{
	
	private Tabuleiro()
	{
		super();
		preencheVetor();
		inicializaMatriz();
		idxPecaSelecionada = -1;
		addMouseListener(new ControleEvento(this));
		turno = 0;
		
		
	}
	
	public static Tabuleiro getInstance() 
	{
		if (instance==null)
			instance = new Tabuleiro();
		return instance;
	}
	
	//protected int posicaoX, posicaoY;
	private Image img;
	
	private static Tabuleiro instance;
	
	private Vector<Peca> pecas = new Vector<Peca>();
	
	private int turno;
	
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
	
	public int getTurno() 
	{
		return turno;
	}

	public int jogadorDaVez() 
	{
		if(turno%2==0)
			return -1;
		return 1;
	}
	
	public double sz;
	public int lado;
	
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		Graphics2D g2d=(Graphics2D) g;
		int i=0,j=0;
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		sz = screenSize.width/2;
		double leftX=0;/* Posição inicial no eixo X do topo superior esquerdo do primeiro retangulo */
		double topY=0; /* Posição inicial no eixo Y do topo superior esquerdo do primeiro retangulo */
		lado = ((int)sz/8); /* Lado dos quadrados */
		

			
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
							g2d.setPaint(Color.gray);
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
							g2d.setPaint(Color.GRAY);
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
		tab.getContentPane().add(Tabuleiro.getInstance());
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		double sz = screenSize.width/2;
		int lado = ((int)sz/8);
		tab.setSize((int)sz+16,(int)sz+40);
		tab.setLocationRelativeTo(null);
		tab.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tab.setVisible(true);
	}
	
	protected void boardClickCallback(int x, int y) 
	{
		inicializaMatriz();
		if(idxPecaSelecionada==-1) // Selecionando peca para mover 
		{
			idxPecaSelecionada = posicoes[x][y];
			if(idxPecaSelecionada==-1)
				return;
			if(pecas.elementAt(idxPecaSelecionada).getJogador()==jogadorDaVez()) 
			{
				movimentos = pecas.elementAt(idxPecaSelecionada).possiveisMovimentos();
				highlight();
			}
			else
				idxPecaSelecionada = -1;
		}
		else // Selecionando para onde mover
		{
			if(movimentos.contains(new Pair<Integer, Integer>(x, y))) // Selecionando movimento valido
			{
				pecas.elementAt(idxPecaSelecionada).move(new Pair<Integer, Integer>(x, y));
				Peca possivelInimigo;
				if(posicoes[pecas.elementAt(idxPecaSelecionada).getPosition().getFirst()][pecas.elementAt(idxPecaSelecionada).getPosition().getSecond()]==-1)
					possivelInimigo = null;
				else
					possivelInimigo = pecas.elementAt(posicoes[pecas.elementAt(idxPecaSelecionada).getPosition().getFirst()][pecas.elementAt(idxPecaSelecionada).getPosition().getSecond()]);
				if(possivelInimigo!=null && possivelInimigo.getJogador()!=pecas.elementAt(idxPecaSelecionada).getJogador())
					possivelInimigo.captura();
				idxPecaSelecionada = -1;
				inicializaMatriz();
				repaint();
				turno++;
			}
			else if(posicoes[x][y]==-1) // Movimento invalido e nao tem peca no destino
			{
				idxPecaSelecionada = -1;
				repaint();
			}
			else if(pecas.elementAt(posicoes[x][y]).getJogador()==pecas.elementAt(idxPecaSelecionada).getJogador()) // Selecionando outra peca
			{
				idxPecaSelecionada = posicoes[x][y];
				movimentos = pecas.elementAt(idxPecaSelecionada).possiveisMovimentos();
				repaint();
				highlight();
			}
			else // Clicando em peca do inimigo para onde nao pode mover
			{
				idxPecaSelecionada = -1;
				repaint();
			}
		}
	}
	
	public Peca getPeca(Pair<Integer, Integer> pos) 
	{
		if(pos.getFirst()<0 || pos.getSecond()<0 || pos.getFirst()>7 || pos.getSecond()>7)
			return null;
		if(posicoes[pos.getFirst()][pos.getSecond()]==-1)
			return null;
		return pecas.elementAt(posicoes[pos.getFirst()][pos.getSecond()]);
	}
	
	private void highlight() 
	{
		if(idxPecaSelecionada==-1)
			return;
		highlightSquare(pecas.elementAt(idxPecaSelecionada).getPosition().getFirst(), pecas.elementAt(idxPecaSelecionada).getPosition().getSecond(), Color.green);
		for(Pair<Integer, Integer> movimento : movimentos) 
		{
			Peca destino;
			if(posicoes[movimento.getFirst()][movimento.getSecond()]==-1)
				destino = null;
			else
				destino = pecas.elementAt(posicoes[movimento.getFirst()][movimento.getSecond()]);
			if(destino!=null && destino.getJogador()!=pecas.elementAt(idxPecaSelecionada).getJogador())
				highlightSquare(movimento.getFirst(), movimento.getSecond(), Color.red);
			else
				highlightSquare(movimento.getFirst(), movimento.getSecond(), Color.yellow);
		}
	}
	
	private void highlightSquare(int x, int y, Color colour) 
	{
		Graphics g = instance.getGraphics();
		Graphics2D g2d=(Graphics2D) g;
		Rectangle2D rt=new Rectangle2D.Double(x*lado,y*lado,lado,lado);
		g2d.setStroke(new BasicStroke(10));
		g2d.setPaint(colour);
		g2d.draw(rt);
		
	}
	
}

