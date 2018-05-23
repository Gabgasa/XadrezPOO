package tabuleiro;
import java.awt.event.*;

import javax.swing.JFrame;

public class ControleEvento implements MouseListener {
	
	private Tabuleiro tab;
	
	public void  mouseClicked(MouseEvent e)
	{
		System.out.println("clicou");
		tab.posicaoX = e.getX();
		tab.posicaoY = e.getY();
		
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
