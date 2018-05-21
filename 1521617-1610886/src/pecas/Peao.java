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
	public Vector<Pair<Integer, Integer>> possiveisMovimentos() 
	{
		Pair<Integer, Integer> destino = new Pair<>(posicao.getFirst()-1, posicao.getSecond()+1);
		Vector<Pair<Integer, Integer>> jogadas = new Vector<Pair<Integer, Integer>>();
		if(destino.getFirst()>=0 && destino.getSecond()<=7 /* conferir se nao existe uma peca do mesmo jogador na casa e se existe uma do outro jogador */)
			jogadas.add(new Pair<>(destino.getFirst(), destino.getSecond()));
		destino.setFirst(posicao.getFirst()+1);
		if(destino.getFirst()<=7 && destino.getSecond()<=7 /* conferir se nao existe uma peca do mesmo jogador na casa e se existe uma do outro jogador */)
			jogadas.add(new Pair<>(destino.getFirst(), destino.getSecond()));
		destino.setFirst(posicao.getFirst());
		if(destino.getSecond()<=7 /* conferir se nao existe uma peca do mesmo jogador na casa */)
			jogadas.add(new Pair<>(destino.getFirst(), destino.getSecond()));
		return jogadas;
	}

	@Override
	public boolean move(Pair<Integer, Integer> newPos) 
	{
		// TODO Auto-generated method stub
		return false;
	}

}