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
		   tab.popupShown = false;
	   } 
	   
	   if(e.getActionCommand()== "Salvar")
	   {
		   
		   control.SaveGame();
	   }
	    

	}
	
	public MenuAction(Tabuleiro tabuleiro) 
	{
		tab = tabuleiro;
		control = new Controlador(tab);
	}

	
}
