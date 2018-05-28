package pecas;

import java.util.Vector;

import estruturas.Pair;
import tabuleiro.Tabuleiro;

public class Rei extends Peca 
{
	
	public boolean jaMoveu;
	
	public Rei(int player, Pair<Integer, Integer> position, Tabuleiro tab) 
	{
		super(player, position, tab);
		jaMoveu = false;
		if(jogador==1)
			image = "CyanK.png";
		else
			image = "PurpleK.png";
	}

	@Override
	public Vector<Pair<Integer, Integer>> possiveisMovimentos() 
	{
		Vector<Pair<Integer, Integer>> jogadas = new Vector<Pair<Integer, Integer>>();
		Pair<Integer, Integer> destino = new Pair<>(posicao.getFirst(), posicao.getSecond());
		// Movimentos para baixo
		for(int i=1; i<2; i++) 
		{
			destino.setSecond(destino.getSecond()+1);
			if((tabuleiro.getPeca(destino)!=null && tabuleiro.getPeca(destino).getJogador()==jogador) || destino.getFirst()<0 || destino.getSecond()>7 || destino.getFirst()>7 || destino.getSecond()<0)
				break;
			jogadas.add(new Pair<>(destino.getFirst(), destino.getSecond()));
			if(tabuleiro.getPeca(destino)!=null && tabuleiro.getPeca(destino).getJogador()!=jogador)
				break;
		}
		destino.setFirst(posicao.getFirst());
		destino.setSecond(posicao.getSecond());
		// Movimentos para cima
		for(int i=1; i<2; i++) 
		{
			destino.setSecond(destino.getSecond()-1);
			if((tabuleiro.getPeca(destino)!=null && tabuleiro.getPeca(destino).getJogador()==jogador) || destino.getFirst()<0 || destino.getSecond()>7 || destino.getFirst()>7 || destino.getSecond()<0)
				break;
			jogadas.add(new Pair<>(destino.getFirst(), destino.getSecond()));
			if(tabuleiro.getPeca(destino)!=null && tabuleiro.getPeca(destino).getJogador()!=jogador)
				break;
		}
		destino.setFirst(posicao.getFirst());
		destino.setSecond(posicao.getSecond());
		// Movimentos para a direita
		for(int i=1; i<2; i++) 
		{
			destino.setFirst(destino.getFirst()+1);
			if((tabuleiro.getPeca(destino)!=null && tabuleiro.getPeca(destino).getJogador()==jogador) || destino.getFirst()<0 || destino.getSecond()>7 || destino.getFirst()>7 || destino.getSecond()<0)
				break;
			jogadas.add(new Pair<>(destino.getFirst(), destino.getSecond()));
			if(tabuleiro.getPeca(destino)!=null && tabuleiro.getPeca(destino).getJogador()!=jogador)
				break;
		}
		destino.setFirst(posicao.getFirst());
		destino.setSecond(posicao.getSecond());
		// Movimentos para a esquerda
		for(int i=1; i<2; i++) 
		{
			destino.setFirst(destino.getFirst()-1);
			if((tabuleiro.getPeca(destino)!=null && tabuleiro.getPeca(destino).getJogador()==jogador) || destino.getFirst()<0 || destino.getSecond()>7 || destino.getFirst()>7 || destino.getSecond()<0)
				break;
			jogadas.add(new Pair<>(destino.getFirst(), destino.getSecond()));
			if(tabuleiro.getPeca(destino)!=null && tabuleiro.getPeca(destino).getJogador()!=jogador)
				break;
		}
		destino.setFirst(posicao.getFirst());
		destino.setSecond(posicao.getSecond());
		// Movimentos na diagonal para baixo e para a esquerda
		for(int i=1; i<2; i++) 
		{
			destino.setFirst(destino.getFirst()-1);
			destino.setSecond(destino.getSecond()+1);
			if((tabuleiro.getPeca(destino)!=null && tabuleiro.getPeca(destino).getJogador()==jogador) || destino.getFirst()<0 || destino.getSecond()>7 || destino.getFirst()>7 || destino.getSecond()<0)
				break;
			jogadas.add(new Pair<>(destino.getFirst(), destino.getSecond()));
			if(tabuleiro.getPeca(destino)!=null && tabuleiro.getPeca(destino).getJogador()!=jogador)
				break;
		}
		destino.setFirst(posicao.getFirst());
		destino.setSecond(posicao.getSecond());
		// Movimentos na diagonal para cima e para a esquerda
		for(int i=1; i<2; i++) 
		{
			destino.setFirst(destino.getFirst()-1);
			destino.setSecond(destino.getSecond()-1);
			if((tabuleiro.getPeca(destino)!=null && tabuleiro.getPeca(destino).getJogador()==jogador) || destino.getFirst()<0 || destino.getSecond()>7 || destino.getFirst()>7 || destino.getSecond()<0)
				break;
			jogadas.add(new Pair<>(destino.getFirst(), destino.getSecond()));
			if(tabuleiro.getPeca(destino)!=null && tabuleiro.getPeca(destino).getJogador()!=jogador)
				break;
		}
		destino.setFirst(posicao.getFirst());
		destino.setSecond(posicao.getSecond());
		// Movimentos na diagonal para baixo e para a direita
		for(int i=1; i<2; i++) 
		{
			destino.setFirst(destino.getFirst()+1);
			destino.setSecond(destino.getSecond()+1);
			if((tabuleiro.getPeca(destino)!=null && tabuleiro.getPeca(destino).getJogador()==jogador) || destino.getFirst()<0 || destino.getSecond()>7 || destino.getFirst()>7 || destino.getSecond()<0)
				break;
			jogadas.add(new Pair<>(destino.getFirst(), destino.getSecond()));
			if(tabuleiro.getPeca(destino)!=null && tabuleiro.getPeca(destino).getJogador()!=jogador)
				break;
		}
		destino.setFirst(posicao.getFirst());
		destino.setSecond(posicao.getSecond());
		// Movimentos na diagonal para cima e para a direita
		for(int i=1; i<2; i++) 
		{
			destino.setFirst(destino.getFirst()+1);
			destino.setSecond(destino.getSecond()-1);
			if((tabuleiro.getPeca(destino)!=null && tabuleiro.getPeca(destino).getJogador()==jogador) || destino.getFirst()<0 || destino.getSecond()>7 || destino.getFirst()>7 || destino.getSecond()<0)
				break;
			jogadas.add(new Pair<>(destino.getFirst(), destino.getSecond()));
			if(tabuleiro.getPeca(destino)!=null && tabuleiro.getPeca(destino).getJogador()!=jogador)
				break;
		}
		destino.setFirst(posicao.getFirst());
		destino.setSecond(posicao.getSecond());
		// Roque
		if(!jaMoveu) 
		{
			// Roque curto
			destino.setFirst(posicao.getFirst()+3);
			if(tabuleiro.getPeca(destino)instanceof Torre) 
			{
				Torre tower = (Torre)tabuleiro.getPeca(destino);
				if(!tower.jaMoveu) 
				{
					if(tabuleiro.getPeca(new Pair<Integer, Integer>(posicao.getFirst()+1, posicao.getSecond()))==null
							&& tabuleiro.getPeca(new Pair<Integer, Integer>(posicao.getFirst()+2, posicao.getSecond()))==null) 
					{
						jogadas.add(new Pair<>(posicao.getFirst()+3, posicao.getSecond()));
					}
				}
			}
			// Roque longo
			destino.setFirst(posicao.getFirst()-4);
			if(tabuleiro.getPeca(destino)instanceof Torre) 
			{
				Torre tower = (Torre)tabuleiro.getPeca(destino);
				if(!tower.jaMoveu) 
				{
					if(tabuleiro.getPeca(new Pair<Integer, Integer>(posicao.getFirst()-1, posicao.getSecond()))==null
							&& tabuleiro.getPeca(new Pair<Integer, Integer>(posicao.getFirst()-2, posicao.getSecond()))==null
							&& tabuleiro.getPeca(new Pair<Integer, Integer>(posicao.getFirst()-3, posicao.getSecond()))==null) 
					{
						jogadas.add(new Pair<>(posicao.getFirst()-4, posicao.getSecond()));
					}
				}
			}
		}
		return jogadas;
	}

	@Override
	public void move(Pair<Integer, Integer> newPos) 
	{
		posicao.setFirst(newPos.getFirst());
		posicao.setSecond(newPos.getSecond());
		jaMoveu = true;
	}
	
	public boolean wouldBeInCheck(Pair<Integer, Integer> pos)
	{
		return false;
	}

}
