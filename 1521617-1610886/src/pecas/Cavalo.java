package pecas;

import java.util.Vector;

import estruturas.Pair;
import tabuleiro.Tabuleiro;

public class Cavalo extends Peca 
{

	public Cavalo(int player, Pair<Integer, Integer> position, Tabuleiro tab) 
	{
		super(player, position, tab);
		if(jogador==1)
			image = "CyanN.png";
		else
			image = "PurpleN.png";
	}

	@Override
	public Vector<Pair<Integer, Integer>> possiveisMovimentos() 
	{
		Vector<Pair<Integer, Integer>> jogadas = new Vector<Pair<Integer, Integer>>();
		Pair<Integer, Integer> destino = new Pair<>(posicao.getFirst(), posicao.getSecond());
		// 2 cima 1 esquerda
		destino.setFirst(destino.getFirst()-1);
		destino.setSecond(destino.getSecond()-2);
		if(destino.getFirst()<=7 && destino.getFirst()>=0 && destino.getSecond()<=7 && destino.getSecond()>=0 && !(tabuleiro.getPeca(destino)!=null && tabuleiro.getPeca(destino).getJogador()==jogador))
			jogadas.add(new Pair<>(destino.getFirst(), destino.getSecond()));
		destino.setFirst(posicao.getFirst());
		destino.setSecond(posicao.getSecond());
		// 2 cima 1 direita
		destino.setFirst(destino.getFirst()+11);
		destino.setSecond(destino.getSecond()-2);
		if(destino.getFirst()<=7 && destino.getFirst()>=0 && destino.getSecond()<=7 && destino.getSecond()>=0 && !(tabuleiro.getPeca(destino)!=null && tabuleiro.getPeca(destino).getJogador()==jogador))
			jogadas.add(new Pair<>(destino.getFirst(), destino.getSecond()));
		destino.setFirst(posicao.getFirst());
		destino.setSecond(posicao.getSecond());
		// 2 baixo 1 esquerda
		destino.setFirst(destino.getFirst()-1);
		destino.setSecond(destino.getSecond()+2);
		if(destino.getFirst()<=7 && destino.getFirst()>=0 && destino.getSecond()<=7 && destino.getSecond()>=0 && !(tabuleiro.getPeca(destino)!=null && tabuleiro.getPeca(destino).getJogador()==jogador))
			jogadas.add(new Pair<>(destino.getFirst(), destino.getSecond()));
		destino.setFirst(posicao.getFirst());
		destino.setSecond(posicao.getSecond());
		// 2 baixo 1 direita
		destino.setFirst(destino.getFirst()+1);
		destino.setSecond(destino.getSecond()+2);
		if(destino.getFirst()<=7 && destino.getFirst()>=0 && destino.getSecond()<=7 && destino.getSecond()>=0 && !(tabuleiro.getPeca(destino)!=null && tabuleiro.getPeca(destino).getJogador()==jogador))
			jogadas.add(new Pair<>(destino.getFirst(), destino.getSecond()));
		destino.setFirst(posicao.getFirst());
		destino.setSecond(posicao.getSecond());
		// 2 esquerda 1 cima
		destino.setFirst(destino.getFirst()-2);
		destino.setSecond(destino.getSecond()-1);
		if(destino.getFirst()<=7 && destino.getFirst()>=0 && destino.getSecond()<=7 && destino.getSecond()>=0 && !(tabuleiro.getPeca(destino)!=null && tabuleiro.getPeca(destino).getJogador()==jogador))
			jogadas.add(new Pair<>(destino.getFirst(), destino.getSecond()));
		destino.setFirst(posicao.getFirst());
		destino.setSecond(posicao.getSecond());
		// 2 esquerda 1 baixo
		destino.setFirst(destino.getFirst()-2);
		destino.setSecond(destino.getSecond()+1);
		if(destino.getFirst()<=7 && destino.getFirst()>=0 && destino.getSecond()<=7 && destino.getSecond()>=0 && !(tabuleiro.getPeca(destino)!=null && tabuleiro.getPeca(destino).getJogador()==jogador))
			jogadas.add(new Pair<>(destino.getFirst(), destino.getSecond()));
		destino.setFirst(posicao.getFirst());
		destino.setSecond(posicao.getSecond());
		// 2 direita 1 cima
		destino.setFirst(destino.getFirst()+2);
		destino.setSecond(destino.getSecond()-1);
		if(destino.getFirst()<=7 && destino.getFirst()>=0 && destino.getSecond()<=7 && destino.getSecond()>=0 && !(tabuleiro.getPeca(destino)!=null && tabuleiro.getPeca(destino).getJogador()==jogador))
			jogadas.add(new Pair<>(destino.getFirst(), destino.getSecond()));
		destino.setFirst(posicao.getFirst());
		destino.setSecond(posicao.getSecond());
		// 2 direita 1 baixo
		destino.setFirst(destino.getFirst()+2);
		destino.setSecond(destino.getSecond()+1);
		if(destino.getFirst()<=7 && destino.getFirst()>=0 && destino.getSecond()<=7 && destino.getSecond()>=0 && !(tabuleiro.getPeca(destino)!=null && tabuleiro.getPeca(destino).getJogador()==jogador))
			jogadas.add(new Pair<>(destino.getFirst(), destino.getSecond()));
		destino.setFirst(posicao.getFirst());
		destino.setSecond(posicao.getSecond());
		return jogadas;
	}

}
