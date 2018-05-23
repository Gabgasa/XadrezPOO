package pecas;

import java.util.*;
import estruturas.Pair;

public abstract class Peca 
{
	
	public Peca(int player, Pair<Integer, Integer> position) 
	{
		jogador = player;
		posicao = position;
	}
	
	protected int jogador;
	public String image;
	protected Pair<Integer, Integer> posicao;
	
	public Pair<Integer, Integer> getPosition()
	{
		return posicao;
	}
	
	public abstract Vector<Pair<Integer, Integer>> possiveisMovimentos();
	
	public void move(Pair<Integer, Integer> newPos) 
	{
		posicao.setFirst(newPos.getFirst());
		posicao.setSecond(newPos.getSecond());
	}
	
	public void captura() 
	{
		posicao.setFirst(-1);
		posicao.setSecond(-1);
	}
	
	public int getJogador() 
	{
		return jogador;
	}
	
}
