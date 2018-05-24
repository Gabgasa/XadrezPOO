package pecas;


import java.util.*;
import estruturas.Pair;
import tabuleiro.Tabuleiro;


public abstract class Peca 
{
	
	protected int jogador;
	public String image;
	protected Pair<Integer, Integer> posicao;
	protected Tabuleiro tabuleiro;
	
	public Peca(int player, Pair<Integer, Integer> position, Tabuleiro tab) 
	{
		jogador = player;
		posicao = new Pair<Integer, Integer>(position.getFirst(), position.getSecond());
		tabuleiro = tab;
	}
	
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
