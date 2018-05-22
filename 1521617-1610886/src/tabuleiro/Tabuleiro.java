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
		tam = 0;
		preencheVetor();
	}
	
	private Image img;
	private String [] im = {"CyanR.png", "CyanN.png", "CyanB.png", "CyanK.png", "CyanQ.png", "CyanB.png", "CyanN.png", "CyanR.png"
			, "CyanP.png", "CyanP.png", "CyanP.png", "CyanP.png", "CyanP.png", "CyanP.png", "CyanP.png"
			, "CyanP.png", "PurpleP.png", "PurpleP.png", "PurpleP.png"
			, "PurpleP.png", "PurpleP.png", "PurpleP.png", "PurpleP.png", "PurpleP.png", "PurpleR.png"
			, "PurpleN.png", "PurpleB.png", "PurpleQ.png", "PurpleK.png", "PurpleB.png", "PurpleN.png", "PurpleR.png"};
	
	private int tam;
	
	private Vector<Peca> pecas;
	
	private int idxPecaSelecionada;
	
	public int [][] posicoes = new int [8][8];
	
	private Vector<Pair<Integer, Integer>> movimentos;
	
	private void preencheVetor()
	{
		// Jogador roxo (primeiro)
		for(int i=0; i<8; i++)
			pecas.add(new Peao(-1, new Pair<Integer, Integer>(i, 6)));
		pecas.add(new Torre(-1, new Pair<Integer, Integer>(0, 7)));
		pecas.add(new Torre(-1, new Pair<Integer, Integer>(7, 7)));
		pecas.add(new Cavalo(-1, new Pair<Integer, Integer>(1, 7)));
		pecas.add(new Cavalo(-1, new Pair<Integer, Integer>(6, 7)));
		pecas.add(new Bispo(-1, new Pair<Integer, Integer>(2, 7)));
		pecas.add(new Bispo(-1, new Pair<Integer, Integer>(5, 7)));
		pecas.add(new Rainha(-1, new Pair<Integer, Integer>(3, 7)));
		pecas.add(new Rei(-1, new Pair<Integer, Integer>(4, 7)));
		// Jogador azul (segundo)
		for(int i=0; i<8; i++)
			pecas.add(new Peao(1, new Pair<Integer, Integer>(i, 1)));
		pecas.add(new Torre(1, new Pair<Integer, Integer>(0, 0)));
		pecas.add(new Torre(1, new Pair<Integer, Integer>(7, 0)));
		pecas.add(new Cavalo(1, new Pair<Integer, Integer>(1, 0)));
		pecas.add(new Cavalo(1, new Pair<Integer, Integer>(6, 0)));
		pecas.add(new Bispo(1, new Pair<Integer, Integer>(2, 0)));
		pecas.add(new Bispo(1, new Pair<Integer, Integer>(5, 0)));
		pecas.add(new Rainha(1, new Pair<Integer, Integer>(3, 0)));
		pecas.add(new Rei(1, new Pair<Integer, Integer>(4, 0)));
	}
	
	public void paintComponent(Graphics g) 
	{
			super.paintComponent(g);
			Graphics2D g2d=(Graphics2D) g;
			int i=0,j=0;
			double leftX=0;/* Posição inicial no eixo X do topo superior esquerdo do primeiro retangulo */
			double topY=0; /* Posição inicial no eixo Y do topo superior esquerdo do primeiro retangulo */
			double larg=100.0; /* Largura do retangulo */
			double alt=100.0; /* Altura do retangulo */
			
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
							Rectangle2D rt=new Rectangle2D.Double(leftX,topY,larg,alt);
							g2d.setPaint(Color.black);
							g2d.fill(rt);
							if(i<2) /* PRIMEIRA FILEIRA DE PEÇAS */
							{
								try {
									img=ImageIO.read(new File(im[j]));
								}
									catch(IOException e) {
									System.out.println(e.getMessage());
									System.exit(1);
								}
								g.drawImage(img, ((int)leftX+15), ((int)topY+15), null);
							}
							if(i>5) /* PENULTIMA FILEIRA DE PEÇAS */
							{
								try {
									img=ImageIO.read(new File(im[j+16]));
								}
									catch(IOException e) {
									System.out.println(e.getMessage());
									System.exit(1);
								}
								g.drawImage(img, ((int)leftX+15), ((int)topY+15), null);
							}
							leftX += 100; /* Adicionando 100 para proxima coluna*/
							
						}
						else
						{
							Rectangle2D rt=new Rectangle2D.Double(leftX,topY,larg,alt);
							g2d.setPaint(Color.white);
							g2d.fill(rt);
							if(i<2) /* PRIMEIRA FILEIRA DE PEÇAS */
							{
								try {
									img=ImageIO.read(new File(im[j]));
								}
									catch(IOException e) {
									System.out.println(e.getMessage());
									System.exit(1);
								}
								g.drawImage(img, ((int)leftX+15), ((int)topY+15), null);
							}
							if(i>5) /* PENULTIMA FILEIRA DE PEÇAS */
							{
								try {
									img=ImageIO.read(new File(im[j+16]));
								}
									catch(IOException e) {
									System.out.println(e.getMessage());
									System.exit(1);
								}
								g.drawImage(img, ((int)leftX+15), ((int)topY+15), null);
							}
							leftX += 100;
							
						}
					
					}
					topY += 100; /* Adicionando 75 para a proxima linha */
					leftX = 0; /* Reseta a posição horizontal para começar uma nova linha */
					i++;
				}
				else
				{
					for(j=0; j<8; j++)
					{
						if(j%2 == 0)
						{
							Rectangle2D rt=new Rectangle2D.Double(leftX,topY,larg,alt);
							g2d.setPaint(Color.white);
							g2d.fill(rt);
							if(i<2) /* SEGUNDA FILEIRA DE PEÇAS */
							{
								try {
									img=ImageIO.read(new File(im[j+8]));
								}
									catch(IOException e) {
									System.out.println(e.getMessage());
									System.exit(1);
								}
								g.drawImage(img, ((int)leftX+15), ((int)topY+15), null);
							}
							if(i>5)
							{
								try {
									img=ImageIO.read(new File(im[j+24]));
								}
									catch(IOException e) {
									System.out.println(e.getMessage());
									System.exit(1);
								}
								g.drawImage(img, ((int)leftX+15), ((int)topY+15), null);
							}
							
							leftX += 100;
							
						}
						else
						{
							Rectangle2D rt=new Rectangle2D.Double(leftX,topY,larg,alt);
							g2d.setPaint(Color.black);
							g2d.fill(rt);
							if(i<2) /* SEGUNDA FILEIRA DE PEÇAS */
							{
								try {
									img=ImageIO.read(new File(im[j+8]));
								}
									catch(IOException e) {
									System.out.println(e.getMessage());
									System.exit(1);
								}
								g.drawImage(img, ((int)leftX+15), ((int)topY+15), null);
							}
							if(i>5)/* ULTIMA FILEIRA DE PEÇAS */
							{
								try {
									img=ImageIO.read(new File(im[j+24]));
								}
									catch(IOException e) {
									System.out.println(e.getMessage());
									System.exit(1);
								}
								g.drawImage(img, ((int)leftX+15), ((int)topY+15), null);
							}
							leftX += 100;
						}
					
					}
					topY += 100; /* Adiciona 75 para a proxima linha*/
					leftX = 0; /* Reseta a posição horizontal para começar uma nova linha */
					i++;
				}
			}
			
			
			
	}
	
	private void inicialzaMatriz() 
	{
		for(int i =0; i<8; i++)
			for(int j=0; j<8; j++)
				posicoes[i][j] = -1;
		for(int i=0; i<pecas.size(); i++) 
		{
			posicoes[pecas.elementAt(idxPecaSelecionada).getPosition().getFirst()][pecas.elementAt(idxPecaSelecionada).getPosition().getSecond()] = i;
		}
	}
	
	public static void main(String[] args) 	
	{
		JFrame tab = new JFrame();
		tab.setSize(818,840);
		tab.getContentPane().add(new Tabuleiro());;
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
			
		}
	}
	
}

