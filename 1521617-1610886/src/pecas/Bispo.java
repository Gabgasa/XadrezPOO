package pecas;

import java.util.Vector;

import estruturas.Pair;

public class Bispo extends Peca 
{

	public Bispo(int player, Pair<Integer, Integer> position) 
	{
		super(player, position);
	}

	@Override
	public Vector<Pair<Integer, Integer>> possiveisMovimentos() 
	{
		Vector<Pair<Integer, Integer>> jogadas = new Vector<Pair<Integer, Integer>>();
		Pair<Integer, Integer> destino = new Pair<>(posicao.getFirst(), posicao.getSecond());
		// Movimentos na diagonal para cima e para a esquerda
		for(int i=1; i<8; i++) 
		{
			destino.setFirst(destino.getFirst()-1);
			destino.setSecond(destino.getSecond()+1);
			//if(Tem peca do msm jogador no destino || destino.getFirst()<0 || destino.getSecond()>7)
				//break;
			jogadas.add(new Pair<>(destino.getFirst(), destino.getSecond()));
			//if(Tem peca do inimigo no destino)
				//break;
		}
		// Movimentos na diagonal para baxio e para a esquerda
		for(int i=1; i<8; i++) 
		{
			destino.setFirst(destino.getFirst()-1);
			destino.setSecond(destino.getSecond()-1);
			//if(Tem peca do msm jogador no destino || destino.getFirst()<0 || destino.getSecond()<0)
				//break;
			jogadas.add(new Pair<>(destino.getFirst(), destino.getSecond()));
			//if(Tem peca do inimigo no destino)
				//break;
		}
		// Movimentos na diagonal para cima e para a direita
		for(int i=1; i<8; i++) 
		{
			destino.setFirst(destino.getFirst()+1);
			destino.setSecond(destino.getSecond()+1);
			//if(Tem peca do msm jogador no destino || destino.getFirst()>7 || destino.getSecond()>7)
				//break;
			jogadas.add(new Pair<>(destino.getFirst(), destino.getSecond()));
			//if(Tem peca do inimigo no destino)
				//break;
		}
		// Movimentos na diagonal para baxio e para a direita
		for(int i=1; i<8; i++) 
		{
			destino.setFirst(destino.getFirst()+1);
			destino.setSecond(destino.getSecond()-1);
			//if(Tem peca do msm jogador no destino || destino.getFirst()>7 || destino.getSecond()<0)
				//break;
			jogadas.add(new Pair<>(destino.getFirst(), destino.getSecond()));
			//if(Tem peca do inimigo no destino)
				//break;
		}
		return jogadas;
	}

	@Override
	public boolean move(Pair<Integer, Integer> newPos) 
	{
		// TODO Auto-generated method stub
		return false;
	}

}
