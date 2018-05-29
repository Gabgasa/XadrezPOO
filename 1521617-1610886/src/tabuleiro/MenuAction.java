package tabuleiro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuAction implements ActionListener {
	private Tabuleiro tab;
	
	public void actionPerformed(ActionEvent e) {
	    System.out.println("Selected: " + e.getActionCommand());

	  }
	
	public MenuAction(Tabuleiro tabuleiro) 
	{
		tab = tabuleiro;
	}

	
}
