package pecas;

import java.util.*;
import estruturas.Pair;

public abstract class Peca 
{
	
	public int jogador;
	public boolean viva;
	private Pair<Integer, Integer> posicao;
	
	public Pair<Integer, Integer> getPosition()
	{
		return posicao;
	}
	
	public abstract Vector<Vector<Pair<Integer, Integer>>> possiveisMovimentos();
	
	public abstract boolean move(Pair<Integer, Integer> newPos);
	
}
