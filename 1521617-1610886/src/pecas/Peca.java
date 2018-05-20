package pecas;

import java.util.*;
import estruturas.Pair;

public abstract class Peca 
{
	
	public Peca(int player, Pair<Integer, Integer> position) 
	{
		viva = true;
		jogador = player;
		posicao = position;
	}
	
	protected int jogador;
	protected boolean viva;
	protected Pair<Integer, Integer> posicao;
	
	public Pair<Integer, Integer> getPosition()
	{
		return posicao;
	}
	
	public abstract Vector<Vector<Pair<Integer, Integer>>> possiveisMovimentos();
	
	public abstract boolean move(Pair<Integer, Integer> newPos);
	
}
