package pecas;

import java.util.Vector;

import estruturas.Pair;

public class Peao extends Peca 
{
	
	public Peao(int player, Pair<Integer, Integer> position) 
	{
		super(player, position);
	}
	
	@Override
	public Vector<Vector<Pair<Integer, Integer>>> possiveisMovimentos() 
	{
		Vector<Vector<Pair<Integer, Integer>>> jogadas = new Vector<Vector<Pair<Integer, Integer>>>();
		Pair<Integer, Integer> destino = new Pair<>(posicao.getFirst()-1, posicao.getSecond()+1);
		Vector<Pair<Integer, Integer>> jogada = new Vector<Pair<Integer, Integer>>();
		jogada.add(posicao);
		jogada.add(destino);
		if(destino.getFirst()>=0 && destino.getSecond()<=7 /* conferir se existe uma peca do mesmo jogador na casa */)
			jogadas.add(jogada);
		destino.setFirst(posicao.getFirst()+1);
		jogada.setElementAt(destino, 1);
		if(destino.getFirst()<=7 && destino.getSecond()<=7 /* conferir se existe uma peca do mesmo jogador na casa */)
			jogadas.add(jogada);
		return jogadas;
	}

	@Override
	public boolean move(Pair<Integer, Integer> newPos) 
	{
		// TODO Auto-generated method stub
		return false;
	}

}
