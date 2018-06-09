package tabuleiro;
import java.awt.event.*;


public class ControleEvento implements MouseListener {
	
	private Tabuleiro tab;
	
	@Override
	public void  mouseClicked(MouseEvent e)
	{
		if(e.getButton() == MouseEvent.BUTTON1)
		{
			tab.boardClickCallback(e.getX()/((int)tab.sz/8), e.getY()/((int)tab.sz/8));
		}
		
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
