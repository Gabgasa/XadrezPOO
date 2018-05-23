package pecas;

import java.util.Vector;

import estruturas.Pair;
import tabuleiro.Tabuleiro;

public class Rainha extends Peca 
{

	public Rainha(int player, Pair<Integer, Integer> position, Tabuleiro tab) 
	{
		super(player, position, tab);
		if(jogador==1)
			image = "CyanQ";
		else
			image = "PurpleQ";
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
			if((tabuleiro.getPeca(destino)!=null && tabuleiro.getPeca(destino).getJogador()==jogador) || destino.getFirst()<0 || destino.getSecond()>7)
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
			if((tabuleiro.getPeca(destino)!=null && tabuleiro.getPeca(destino).getJogador()==jogador) || destino.getFirst()<0 || destino.getSecond()>7)
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
			if((tabuleiro.getPeca(destino)!=null && tabuleiro.getPeca(destino).getJogador()==jogador) || destino.getFirst()<0 || destino.getSecond()>7)
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
			if((tabuleiro.getPeca(destino)!=null && tabuleiro.getPeca(destino).getJogador()==jogador) || destino.getFirst()<0 || destino.getSecond()>7)
				break;
			jogadas.add(new Pair<>(destino.getFirst(), destino.getSecond()));
			if(tabuleiro.getPeca(destino)!=null && tabuleiro.getPeca(destino).getJogador()!=jogador)
				break;
		}
		destino.setFirst(posicao.getFirst());
		destino.setSecond(posicao.getSecond());
		// Movimentos na diagonal para baixo e para a esquerda
		for(int i=1; i<8; i++) 
		{
			destino.setFirst(destino.getFirst()-1);
			destino.setSecond(destino.getSecond()+1);
			if((tabuleiro.getPeca(destino)!=null && tabuleiro.getPeca(destino).getJogador()==jogador) || destino.getFirst()<0 || destino.getSecond()>7)
				break;
			jogadas.add(new Pair<>(destino.getFirst(), destino.getSecond()));
			if(tabuleiro.getPeca(destino)!=null && tabuleiro.getPeca(destino).getJogador()!=jogador)
				break;
		}
		destino.setFirst(posicao.getFirst());
		destino.setSecond(posicao.getSecond());
		// Movimentos na diagonal para cima e para a esquerda
		for(int i=1; i<8; i++) 
		{
			destino.setFirst(destino.getFirst()-1);
			destino.setSecond(destino.getSecond()-1);
			if((tabuleiro.getPeca(destino)!=null && tabuleiro.getPeca(destino).getJogador()==jogador) || destino.getFirst()<0 || destino.getSecond()>7)
				break;
			jogadas.add(new Pair<>(destino.getFirst(), destino.getSecond()));
			if(tabuleiro.getPeca(destino)!=null && tabuleiro.getPeca(destino).getJogador()!=jogador)
				break;
		}
		destino.setFirst(posicao.getFirst());
		destino.setSecond(posicao.getSecond());
		// Movimentos na diagonal para baixo e para a direita
		for(int i=1; i<8; i++) 
		{
			destino.setFirst(destino.getFirst()+1);
			destino.setSecond(destino.getSecond()+1);
			if((tabuleiro.getPeca(destino)!=null && tabuleiro.getPeca(destino).getJogador()==jogador) || destino.getFirst()<0 || destino.getSecond()>7)
				break;
			jogadas.add(new Pair<>(destino.getFirst(), destino.getSecond()));
			if(tabuleiro.getPeca(destino)!=null && tabuleiro.getPeca(destino).getJogador()!=jogador)
				break;
		}
		destino.setFirst(posicao.getFirst());
		destino.setSecond(posicao.getSecond());
		// Movimentos na diagonal para cima e para a direita
		for(int i=1; i<8; i++) 
		{
			destino.setFirst(destino.getFirst()+1);
			destino.setSecond(destino.getSecond()-1);
			if((tabuleiro.getPeca(destino)!=null && tabuleiro.getPeca(destino).getJogador()==jogador) || destino.getFirst()<0 || destino.getSecond()>7)
				break;
			jogadas.add(new Pair<>(destino.getFirst(), destino.getSecond()));
			if(tabuleiro.getPeca(destino)!=null && tabuleiro.getPeca(destino).getJogador()!=jogador)
				break;
		}
		destino.setFirst(posicao.getFirst());
		destino.setSecond(posicao.getSecond());
		return jogadas;
	}

}
