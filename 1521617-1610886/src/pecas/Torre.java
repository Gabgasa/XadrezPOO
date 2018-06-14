package pecas;

import java.util.Vector;

import estruturas.Pair;
import tabuleiro.Tabuleiro;

public class Torre extends Peca 
{
	
	public boolean jaMoveu;
	
	public Torre(int player, Pair<Integer, Integer> position, Tabuleiro tab) 
	{
		super(player, position, tab);
		jaMoveu = false;
		if(jogador==1)
			image = "CyanR.png";
		else
			image = "PurpleR.png";
	}

	@Override
	public Vector<Pair<Integer, Integer>> possiveisMovimentos() 
	{
		Vector<Pair<Integer, Integer>> jogadas = new Vector<Pair<Integer, Integer>>();
		Pair<Integer, Integer> destino = new Pair<>(posicao.getFirst(), posicao.getSecond());
		// Movimentos para baixo
		for(int i=1; i<8; i++) 
		{
			destino.setSecond(destino.getSecond()+1);
			if(destino.getFirst()<0 || destino.getSecond()>7 || destino.getFirst()>7 || destino.getSecond()<0)
				break;
			if((tabuleiro.getPeca(destino)!=null && tabuleiro.getPeca(destino).getJogador()==jogador) )
				break;
			jogadas.add(new Pair<>(destino.getFirst(), destino.getSecond()));
			if(tabuleiro.getPeca(destino)!=null && tabuleiro.getPeca(destino).getJogador()!=jogador)
				break;
		}
		destino.setFirst(posicao.getFirst());
		destino.setSecond(posicao.getSecond());
		// Movimentos para cima
		for(int i=1; i<8; i++) 
		{
			destino.setSecond(destino.getSecond()-1);
			if(destino.getFirst()<0 || destino.getSecond()>7 || destino.getFirst()>7 || destino.getSecond()<0)
				break;
			if((tabuleiro.getPeca(destino)!=null && tabuleiro.getPeca(destino).getJogador()==jogador))
				break;
			jogadas.add(new Pair<>(destino.getFirst(), destino.getSecond()));
			if(tabuleiro.getPeca(destino)!=null && tabuleiro.getPeca(destino).getJogador()!=jogador)
				break;
		}
		destino.setFirst(posicao.getFirst());
		destino.setSecond(posicao.getSecond());
		// Movimentos para a direita
		for(int i=1; i<8; i++) 
		{
			destino.setFirst(destino.getFirst()+1);
			if(destino.getFirst()<0 || destino.getSecond()>7 || destino.getFirst()>7 || destino.getSecond()<0)
				break;
			if((tabuleiro.getPeca(destino)!=null && tabuleiro.getPeca(destino).getJogador()==jogador))
				break;
			jogadas.add(new Pair<>(destino.getFirst(), destino.getSecond()));
			if(tabuleiro.getPeca(destino)!=null && tabuleiro.getPeca(destino).getJogador()!=jogador)
				break;
		}
		destino.setFirst(posicao.getFirst());
		destino.setSecond(posicao.getSecond());
		// Movimentos para a esquerda
		for(int i=1; i<8; i++) 
		{
			destino.setFirst(destino.getFirst()-1);
			if(destino.getFirst()<0 || destino.getSecond()>7 || destino.getFirst()>7 || destino.getSecond()<0)
				break;
			if((tabuleiro.getPeca(destino)!=null && tabuleiro.getPeca(destino).getJogador()==jogador))
				break;
			jogadas.add(new Pair<>(destino.getFirst(), destino.getSecond()));
			if(tabuleiro.getPeca(destino)!=null && tabuleiro.getPeca(destino).getJogador()!=jogador)
				break;
		}
		destino.setFirst(posicao.getFirst());
		destino.setSecond(posicao.getSecond());
		return jogadas;
	}

	@Override
	public void move(Pair<Integer, Integer> newPos, boolean realMov)  
	{
		posicao.setFirst(newPos.getFirst());
		posicao.setSecond(newPos.getSecond());
		if(!jaMoveu)
			jaMoveu = realMov;
	}
	
}
