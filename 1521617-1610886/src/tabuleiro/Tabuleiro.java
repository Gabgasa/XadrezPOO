package tabuleiro;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

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
		m1.addActionListener(new MenuAction(this));
		promocao.add(m1);
		m2.addActionListener(new MenuAction(this));
		promocao.add(m2);
		m3.addActionListener(new MenuAction(this));
		promocao.add(m3);
		m4.addActionListener(new MenuAction(this));
		promocao.add(m4);
		salvar.addActionListener(new MenuAction(this));
		Save.add(salvar);

		
	}
	
	public static Tabuleiro getInstance() 
	{
		if (instance==null)
			instance = new Tabuleiro();
		return instance;
	}
	
	
	private JPopupMenu promocao = new JPopupMenu();
	
	private JMenuItem m1 = new JMenuItem ("Torre");
		
	private JMenuItem m2 = new JMenuItem ("Bispo");
	
	private JMenuItem m3 = new JMenuItem ("Rainha");
	
	private JMenuItem m4 = new JMenuItem ("Cavalo");
	
	protected JPopupMenu Save = new JPopupMenu();
			
	private JMenuItem salvar = new JMenuItem("Salvar");
	
	protected void showMenuSave(int x, int y) 
	{
		Save.show(this, x, y);
	}
	
	
	
	
	
	private Image img;
	
	private static Tabuleiro instance;
	
	private Vector<Peca> pecas = new Vector<Peca>();
	
	protected void promovePeao(String tipoPeca)
	{
		if(tipoPeca=="Torre")
			pecas.add(new Torre(pecas.elementAt(idxPeaoPromovido).getJogador(), pecas.elementAt(idxPeaoPromovido).getPosition(), this));
		else if(tipoPeca=="Cavalo")
			pecas.add(new Cavalo(pecas.elementAt(idxPeaoPromovido).getJogador(), pecas.elementAt(idxPeaoPromovido).getPosition(), this));
		else if(tipoPeca=="Bispo")
			pecas.add(new Bispo(pecas.elementAt(idxPeaoPromovido).getJogador(), pecas.elementAt(idxPeaoPromovido).getPosition(), this));
		else
			pecas.add(new Rainha(pecas.elementAt(idxPeaoPromovido).getJogador(), pecas.elementAt(idxPeaoPromovido).getPosition(), this));
		pecas.elementAt(idxPeaoPromovido).captura();
		inicializaMatriz();
		Graphics g = instance.getGraphics();
		paint(g);
	}
	
	private int turno;
	
	private int idxPecaSelecionada;
	private int idxPeaoPromovido;
	
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
	
	public void limpaPecas() 
	{
		pecas.clear();
	}
	
	public void addPeca(int x, int y, int player, int tipo) 
	{
		if(tipo==1)
			pecas.add(new Peao(player, new Pair<Integer, Integer>(x, y), this));
		else if(tipo==2)
			pecas.add(new Bispo(player, new Pair<Integer, Integer>(x, y), this));
		else if(tipo==3)
			pecas.add(new Cavalo(player, new Pair<Integer, Integer>(x, y), this));
		else if(tipo==4)
			pecas.add(new Rainha(player, new Pair<Integer, Integer>(x, y), this));
		else if(tipo==5)
			pecas.add(new Rei(player, new Pair<Integer, Integer>(x, y), this));
		else if(tipo==6)
			pecas.add(new Torre(player, new Pair<Integer, Integer>(x, y), this));
		else
			return;
		Graphics g = instance.getGraphics();
		inicializaMatriz();
		paint(g);
	}
	
	public int getTurno() 
	{
		return turno;
	}
	
	public void setTurno(int turn) 
	{
		turno = turn;
	}
	
	public Vector<Peca> getPecas()
	{
		return pecas;
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
	
	
	protected void boardClickCallback(int x, int y) 
	{
		Graphics g = instance.getGraphics();
		inicializaMatriz();
		if(idxPecaSelecionada==-1) // Selecionando peca para mover 
		{
			idxPecaSelecionada = posicoes[x][y];
			if(idxPecaSelecionada==-1)
				return;
			if(pecas.elementAt(idxPecaSelecionada).getJogador()==jogadorDaVez()) 
			{
				movimentos = pecas.elementAt(idxPecaSelecionada).possiveisMovimentos();
				movimentos = removeMovsEmXeque(movimentos, idxPecaSelecionada);
				highlight();
			}
			else
				idxPecaSelecionada = -1;
		}
		else // Selecionando para onde mover
		{
			if(movimentos.contains(new Pair<Integer, Integer>(x, y))) // Selecionando movimento valido
			{
				if(pecas.elementAt(idxPecaSelecionada)instanceof Rei) 
				{
					if(posicoes[x][y]!=-1 && pecas.elementAt(posicoes[x][y]).getJogador()==pecas.elementAt(idxPecaSelecionada).getJogador()) 
					{
						// Roque longo
						if(x<pecas.elementAt(idxPecaSelecionada).getPosition().getFirst()) 
						{
							pecas.elementAt(idxPecaSelecionada).move(new Pair<Integer, Integer>(pecas.elementAt(idxPecaSelecionada).getPosition().getFirst()-2, pecas.elementAt(idxPecaSelecionada).getPosition().getSecond()), true);
							pecas.elementAt(posicoes[x][y]).move(new Pair<Integer, Integer>(pecas.elementAt(idxPecaSelecionada).getPosition().getFirst()+1, pecas.elementAt(idxPecaSelecionada).getPosition().getSecond()), true);
							idxPecaSelecionada = -1;
							inicializaMatriz();
							paint(g);
							turno++;
							String mensagem = gameOver();
							if(mensagem!=null)
								{
									System.out.println(mensagem+jogadorDaVez());
									int FinalJogo = JOptionPane.showOptionDialog(
											null, 
											mensagem, 
											"Fim da partida", 
											JOptionPane.YES_NO_OPTION, 
											JOptionPane.INFORMATION_MESSAGE, 
											null, null, null);
								}
						}
						// Roque curto
						else 
						{
							pecas.elementAt(idxPecaSelecionada).move(new Pair<Integer, Integer>(pecas.elementAt(idxPecaSelecionada).getPosition().getFirst()+2, pecas.elementAt(idxPecaSelecionada).getPosition().getSecond()), true);
							pecas.elementAt(posicoes[x][y]).move(new Pair<Integer, Integer>(pecas.elementAt(idxPecaSelecionada).getPosition().getFirst()-1, pecas.elementAt(idxPecaSelecionada).getPosition().getSecond()), true);
							idxPecaSelecionada = -1;
							inicializaMatriz();
							paint(g);
							turno++;
							String mensagem = gameOver();
							if(mensagem!=null)
							{
								System.out.println(mensagem+jogadorDaVez());
								int FinalJogo = JOptionPane.showOptionDialog(
										null, 
										mensagem, 
										"Fim da partida", 
										JOptionPane.YES_NO_OPTION, 
										JOptionPane.INFORMATION_MESSAGE, 
										null, null, null);
							}
						}
					}
					else 
					{
						pecas.elementAt(idxPecaSelecionada).move(new Pair<Integer, Integer>(x, y), true);
						Peca possivelInimigo;
						if(posicoes[pecas.elementAt(idxPecaSelecionada).getPosition().getFirst()][pecas.elementAt(idxPecaSelecionada).getPosition().getSecond()]==-1)
							possivelInimigo = null;
						else
							possivelInimigo = pecas.elementAt(posicoes[pecas.elementAt(idxPecaSelecionada).getPosition().getFirst()][pecas.elementAt(idxPecaSelecionada).getPosition().getSecond()]);
						if(possivelInimigo!=null && possivelInimigo.getJogador()!=pecas.elementAt(idxPecaSelecionada).getJogador()) 
							possivelInimigo.captura();
						idxPecaSelecionada = -1;
						inicializaMatriz();
						paint(g);
						turno++;
						String mensagem = gameOver();
						if(mensagem!=null)
						{
							System.out.println(mensagem+jogadorDaVez());
							int FinalJogo = JOptionPane.showOptionDialog(
									null, 
									mensagem, 
									"Fim da partida", 
									JOptionPane.YES_NO_OPTION, 
									JOptionPane.INFORMATION_MESSAGE, 
									null, null, null);
						}
					}
				}
				else 
				{
					pecas.elementAt(idxPecaSelecionada).move(new Pair<Integer, Integer>(x, y), true);
					Peca possivelInimigo;
					if(posicoes[pecas.elementAt(idxPecaSelecionada).getPosition().getFirst()][pecas.elementAt(idxPecaSelecionada).getPosition().getSecond()]==-1)
						possivelInimigo = null;
					else
						possivelInimigo = pecas.elementAt(posicoes[pecas.elementAt(idxPecaSelecionada).getPosition().getFirst()][pecas.elementAt(idxPecaSelecionada).getPosition().getSecond()]);
					if(possivelInimigo!=null && possivelInimigo.getJogador()!=pecas.elementAt(idxPecaSelecionada).getJogador())
						possivelInimigo.captura();
					if(pecas.elementAt(idxPecaSelecionada)instanceof Peao 
							&& (pecas.elementAt(idxPecaSelecionada).getPosition().getSecond()==0 || pecas.elementAt(idxPecaSelecionada).getPosition().getSecond()==7)) 
					{
						promocao.show(this, x*(int)sz/8, y*(int)sz/8);
						idxPeaoPromovido = idxPecaSelecionada;
					}
					idxPecaSelecionada = -1;
					inicializaMatriz();
					paint(g);
					turno++;
					String mensagem = gameOver();
					if(mensagem!=null)
					{
						System.out.println(mensagem+jogadorDaVez());
						int FinalJogo = JOptionPane.showOptionDialog(
								null, 
								mensagem, 
								"Fim da partida", 
								JOptionPane.YES_NO_OPTION, 
								JOptionPane.INFORMATION_MESSAGE, 
								null, null, null);
					}
				}
			}
			else if(posicoes[x][y]==-1) // Movimento invalido e nao tem peca no destino
			{
				idxPecaSelecionada = -1;
				paint(g);
			}
			else if(pecas.elementAt(posicoes[x][y]).getJogador()==pecas.elementAt(idxPecaSelecionada).getJogador()) // Selecionando outra peca
			{
				idxPecaSelecionada = posicoes[x][y];
				movimentos = pecas.elementAt(idxPecaSelecionada).possiveisMovimentos();
				movimentos = removeMovsEmXeque(movimentos, idxPecaSelecionada);
				paint(g);
				highlight();
				
			}
			else // Clicando em peca do inimigo para onde nao pode mover
			{
				idxPecaSelecionada = -1;
				paint(g);
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
	
	private boolean reiAtacado(Peca selecionada, Pair<Integer, Integer> destino)
	{
		inicializaMatriz();
		// Obter o rei do jogador
		Rei king = null;
		for(Peca peca : pecas)
		{
			if(peca.getJogador()==selecionada.getJogador() && peca instanceof Rei)
				king = (Rei)peca;
		}
		if(king==null)
			return false;
		if(selecionada instanceof Rei) 
		{
			if(posicoes[destino.getFirst()][destino.getSecond()]!=-1) 
			{
				if(pecas.elementAt(posicoes[destino.getFirst()][destino.getSecond()]) instanceof Torre) 
				{
					if(pecas.elementAt(posicoes[destino.getFirst()][destino.getSecond()]).getJogador()==selecionada.getJogador()) 
					{
						if(destino.getFirst()<selecionada.getPosition().getFirst()) 
						{
							if(reiAtacado(selecionada, new Pair<Integer, Integer>(selecionada.getPosition().getFirst(), selecionada.getPosition().getSecond()))
									||  reiAtacado(selecionada, new Pair<Integer, Integer>(selecionada.getPosition().getFirst()-1, selecionada.getPosition().getSecond()))
									|| reiAtacado(selecionada, new Pair<Integer, Integer>(selecionada.getPosition().getFirst()-2, selecionada.getPosition().getSecond())))
								return true;
						}
						else 
						{
							if(reiAtacado(selecionada, new Pair<Integer, Integer>(selecionada.getPosition().getFirst(), selecionada.getPosition().getSecond()))
									||  reiAtacado(selecionada, new Pair<Integer, Integer>(selecionada.getPosition().getFirst()+1, selecionada.getPosition().getSecond()))
									|| reiAtacado(selecionada, new Pair<Integer, Integer>(selecionada.getPosition().getFirst()+2, selecionada.getPosition().getSecond())))
								return true;
						}
					}
				}
			}
		}
		// Simular moviemnto da peca selecionada
		Pair<Integer, Integer> posAtual = new Pair<Integer, Integer>
			(selecionada.getPosition().getFirst(), selecionada.getPosition().getSecond());
		selecionada.move(destino, false);
		// Simular captura de peca do inimigo
		Pair<Integer, Integer> posInimigo = null;
		Peca inimigo = null;
		if(posicoes[destino.getFirst()][destino.getSecond()]!=-1 
				&& pecas.elementAt(posicoes[destino.getFirst()][destino.getSecond()]).getJogador()!=selecionada.getJogador())
		{
			posInimigo = new Pair<Integer, Integer>(destino.getFirst(), destino.getSecond());
			inimigo = pecas.elementAt(posicoes[destino.getFirst()][destino.getSecond()]);
			inimigo.captura();
		}
		// Ver se o rei ficaria na linha de ataque de alguma peca inimiga
		inicializaMatriz();
		for(Peca peca : pecas)
		{
			if(peca.getJogador()!=selecionada.getJogador())
			{
				if(peca.possiveisMovimentos().contains(king.getPosition()))
				{
					selecionada.move(posAtual, false);
					if(inimigo!=null)				
						inimigo.move(posInimigo, false);
					inicializaMatriz();
					return true;
				}
			}
		}
		selecionada.move(posAtual, false);
		if(inimigo!=null)
			inimigo.move(posInimigo, false);
		inicializaMatriz();
		return false;
	}

	private String gameOver()
	{
		// Obter o rei do jogador
		Rei king = null;
		for(Peca peca : pecas)
		{
			if(peca.getJogador()==jogadorDaVez() && peca instanceof Rei)
				king = (Rei)peca;
		}
		if(king==null)
			return null;
		// Confere xeuque mate
		if(reiAtacado(king, king.getPosition())) 
		{
			System.out.println("a");
			for(int i=0; i<pecas.size(); i++)
			{
				if(pecas.elementAt(i).getJogador()!=jogadorDaVez())
					continue;
				if(pecas.elementAt(i).getPosition().getFirst()==-1 || pecas.elementAt(i).getPosition().getSecond()==-1)
					continue;
				if(removeMovsEmXeque(pecas.elementAt(i).possiveisMovimentos(), i).size()>0)
					return null;
			}
			return "Xeuque mate contra o jogador ";
		}
		// Confere congelamento
		else 
		{
			System.out.println("b");
			for(int i=0; i<pecas.size(); i++)
			{
				if(pecas.elementAt(i).getJogador()!=jogadorDaVez())
					continue;
				if(pecas.elementAt(i).getPosition().getFirst()==-1 || pecas.elementAt(i).getPosition().getSecond()==-1)
					continue;
				if(removeMovsEmXeque(pecas.elementAt(i).possiveisMovimentos(), i).size()>0)
					return null;
			}
			return "Congelamento do jogador ";
		}
		
	}
	
	private Vector<Pair<Integer, Integer>> removeMovsEmXeque(Vector<Pair<Integer, Integer>> movs, int idx) 
	{
		Vector<Pair<Integer, Integer>> movsToRemove = new Vector<Pair<Integer, Integer>>();
		for(int i=0; i<movs.size(); i++)
		{
			if(reiAtacado(pecas.elementAt(idx), movs.elementAt(i))) 
			{
				movsToRemove.add(movs.elementAt(i));
			}
		}
		for(int j=0; j<movsToRemove.size(); j++)
			movs.remove(movsToRemove.elementAt(j));
		return movs;
	}
	
	public void SaveGame(String nomeArq)
	{
		int i;
		
		try {
		
				PrintWriter save = new PrintWriter(nomeArq);
				save.println(instance.getTurno()); // Colocando o turno no arquivo
		
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



