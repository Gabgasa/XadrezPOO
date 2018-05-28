package pecas;

import java.util.Vector;

import estruturas.Pair;
import tabuleiro.Tabuleiro;

public class Peao extends Peca 
{
	
	public Peao(int player, Pair<Integer, Integer> position, Tabuleiro tab) 
	{
		super(player, position, tab);
		if(jogador==1)
			image = "CyanP.png";
		else
			image = "PurpleP.png";
	}
	
	@Override
	public Vector<Pair<Integer, Integer>> possiveisMovimentos() 
	{
		Pair<Integer, Integer> destino = new Pair<>(posicao.getFirst()-1, posicao.getSecond()+jogador);
		Vector<Pair<Integer, Integer>> jogadas = new Vector<Pair<Integer, Integer>>();
		if(destino.getFirst()>=0 && destino.getSecond()<=7 && destino.getSecond()>=0 && tabuleiro.getPeca(destino)!=null && tabuleiro.getPeca(destino).getJogador()!=jogador)
			jogadas.add(new Pair<>(destino.getFirst(), destino.getSecond()));
		destino.setFirst(posicao.getFirst()+1);
		if(destino.getFirst()<=7 && destino.getSecond()<=7 && destino.getSecond()>=0 && tabuleiro.getPeca(destino)!=null && tabuleiro.getPeca(destino).getJogador()!=jogador)
			jogadas.add(new Pair<>(destino.getFirst(), destino.getSecond()));
		destino.setFirst(posicao.getFirst());
		if(destino.getSecond()<=7 && destino.getSecond()>=0 && tabuleiro.getPeca(destino)==null)
			jogadas.add(new Pair<>(destino.getFirst(), destino.getSecond()));
		if(tabuleiro.getTurno()<2) 
		{
			destino.setSecond(destino.getSecond()+jogador);
			if(destino.getSecond()<=7 && destino.getSecond()>=0 && tabuleiro.getPeca(destino)==null)
				jogadas.add(new Pair<>(destino.getFirst(), destino.getSecond()));
		}
		return jogadas;
	}


}
