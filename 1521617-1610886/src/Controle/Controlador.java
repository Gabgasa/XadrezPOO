package Controle;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import tabuleiro.Tabuleiro;

public class Controlador {
	
	public static void main(String[] args) 	
	{
		JFrame tab = new JFrame();
		tab.getContentPane().add(Tabuleiro.getInstance());
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		double sz = screenSize.width/2;
		tab.setSize((int)sz+16,(int)sz+40);
		tab.setLocationRelativeTo(null);
		tab.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tab.setVisible(true);
	}

}
