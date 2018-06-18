package tabuleiro;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;
import tabuleiro.MenuAction;

public class MenuInicial extends JPanel {
	
	public MenuInicial()
	{
		super();
		this.setLayout(null);
		Newgame.addActionListener(new MenuAction(Tabuleiro.getInstance()));
		Loadgame.addActionListener(new MenuAction(Tabuleiro.getInstance()));
		this.add(Newgame);
		this.add(Loadgame);
		Newgame.setBounds(120, 250, 100, 30);
		Loadgame.setBounds(250, 250, 100, 30);
	}
	
	private JButton Newgame = new JButton("New Game");
	private JButton Loadgame = new JButton("Load Game");
	
	
	public void paintComponent(Graphics g)
	{
		g.setFont(new Font("TimesRoman", Font.PLAIN, 100));
		g.setColor(Color.white);
		g.drawString("Chess", 110, 130);
	}

}
