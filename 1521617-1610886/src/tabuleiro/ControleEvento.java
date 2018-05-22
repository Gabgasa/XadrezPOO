package tabuleiro;
import java.awt.event.*;

public class ControleEvento implements MouseListener {

	
	public void  mouseClicked(MouseEvent e)
	{
		System.out.println("clicou");
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		System.out.println("entrou");
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		System.out.println("saiu");
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		System.out.println("apertou");
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		System.out.println("soltou");
		
	}
}
