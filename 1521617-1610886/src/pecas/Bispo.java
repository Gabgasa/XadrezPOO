package pecas;

import java.util.Vector;

import estruturas.Pair;
import tabuleiro.Tabuleiro;

public class Bispo extends Peca 
{

	public Bispo(int player, Pair<Integer, Integer> position) 
	{
		super(player, position);
		if(jogador==1)
			image = "CyanB.png";
		else
			image = "PurpleB.png";
	}

	@Override
	public Vector<Pair<Integer, Integer>> possiveisMovimentos() 
	{
		Vector<Pair<Integer, Integer>> jogadas = new Vector<Pair<Integer, Integer>>();
		Pair<Integer, Integer> destino = new Pair<>(posicao.getFirst(), posicao.getSecond());
		// Movimentos na diagonal para baixo e para a esquerda
		for(int i=1; i<8; i++) 
		{
			destino.setFirst(destino.getFirst()-1);
			destino.setSecond(destino.getSecond()+1);
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
		// Movimentos na diagonal para cima e para a esquerda
		for(int i=1; i<8; i++) 
		{
			destino.setFirst(destino.getFirst()-1);
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
		// Movimentos na diagonal para baixo e para a direita
		for(int i=1; i<8; i++) 
		{
			destino.setFirst(destino.getFirst()+1);
			destino.setSecond(destino.getSecond()+1);
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
		// Movimentos na diagonal para cima e para a direita
		for(int i=1; i<8; i++) 
		{
			destino.setFirst(destino.getFirst()+1);
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
		return jogadas;
	}

}
