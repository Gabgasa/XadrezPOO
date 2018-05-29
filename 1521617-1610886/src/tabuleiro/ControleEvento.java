package tabuleiro;
import java.awt.event.*;

import javax.swing.JFrame;

public class ControleEvento implements MouseListener {
	
	private Tabuleiro tab;
	
	@Override
	public void  mouseClicked(MouseEvent e)
	{
		System.out.println("clicou");
		tab.boardClickCallback(e.getX()/((int)tab.sz/8), e.getY()/((int)tab.sz/8));
		
		
		tab.promocao.show(tab, e.getX(), e.getY());
	}
	
	public ControleEvento(Tabuleiro tabuleiro) 
	{
		tab = tabuleiro;
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}

}
