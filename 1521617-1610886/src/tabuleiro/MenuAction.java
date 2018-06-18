package tabuleiro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import Controle.Controlador;

public class MenuAction implements ActionListener 
{
	
	private Tabuleiro tab;
	Controlador control;
	
	public void actionPerformed(ActionEvent e) 
	{
	    System.out.println("Selected: " + e.getActionCommand());
	   if(e.getActionCommand()== "Peao" 
		||e.getActionCommand()== "Bispo"
		||e.getActionCommand()== "Cavalo"
		||e.getActionCommand()== "Rainha"
		||e.getActionCommand()== "Rei"
		||e.getActionCommand()== "Torre")
	   {
		   tab.promovePeao(e.getActionCommand());
		   tab.promoShown = false;
	   } 
	   
	   if(e.getActionCommand()== "Salvar")
	   {
		     control.SaveGame();
	   }
	   
	   if(e.getActionCommand() == "New Game")
	   {
		   control.MenuInicial(0);
		   control.ini.setVisible(false);
	   }
	   
	   if(e.getActionCommand() == "Load Game")
	   {
		   control.MenuInicial(1);
		   control.ini.setVisible(false);
	   }
	    

	}
	
	public MenuAction(Tabuleiro tabuleiro) 
	{
		tab = tabuleiro;
		control = new Controlador(tab);
	}
	

	
}
