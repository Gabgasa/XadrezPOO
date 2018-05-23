package pecas;

import java.util.Vector;

import estruturas.Pair;

public class Torre extends Peca 
{
	
	public boolean jaMoveu;
	
	public Torre(int player, Pair<Integer, Integer> position) 
	{
		super(player, position);
		jaMoveu = false;
		if(jogador==1)
			image = "CyanR";
		else
			image = "PurpleR";
	}

	@Override
	public Vector<Pair<Integer, Integer>> possiveisMovimentos() 
	{
		Vector<Pair<Integer, Integer>> jogadas = new Vector<Pair<Integer, Integer>>();
		Pair<Integer, Integer> destino = new Pair<>(posicao.getFirst(), posicao.getSecond());
		// Movimentos para baixo
		for(int i=1; i<8; i++) 
		{
			destino.setSecond(destino.getSecond()+1);
			//if(Tem peca do msm jogador no destino || destino.getFirst()<0 || destino.getSecond()>7)
				//break;
			jogadas.add(new Pair<>(destino.getFirst(), destino.getSecond()));
			//if(Tem peca do inimigo no destino)
				//break;
		}
		destino.setFirst(posicao.getFirst());
		destino.setSecond(posicao.getSecond());
		// Movimentos para cima
		for(int i=1; i<8; i++) 
		{
			destino.setSecond(destino.getSecond()-1);
			//if(Tem peca do msm jogador no destino || destino.getFirst()<0 || destino.getSecond()<0)
				//break;
			jogadas.add(new Pair<>(destino.getFirst(), destino.getSecond()));
			//if(Tem peca do inimigo no destino)
				//break;
		}
		destino.setFirst(posicao.getFirst());
		destino.setSecond(posicao.getSecond());
		// Movimentos para a direita
		for(int i=1; i<8; i++) 
		{
			destino.setFirst(destino.getFirst()+1);
			//if(Tem peca do msm jogador no destino || destino.getFirst()>7 || destino.getSecond()>7)
				//break;
			jogadas.add(new Pair<>(destino.getFirst(), destino.getSecond()));
			//if(Tem peca do inimigo no destino)
				//break;
		}
		destino.setFirst(posicao.getFirst());
		destino.setSecond(posicao.getSecond());
		// Movimentos para a esquerda
		for(int i=1; i<8; i++) 
		{
			destino.setFirst(destino.getFirst()-1);
			//if(Tem peca do msm jogador no destino || destino.getFirst()>7 || destino.getSecond()<0)
				//break;
			jogadas.add(new Pair<>(destino.getFirst(), destino.getSecond()));
			//if(Tem peca do inimigo no destino)
				//break;
		}
		destino.setFirst(posicao.getFirst());
		destino.setSecond(posicao.getSecond());
		return jogadas;
	}

}
