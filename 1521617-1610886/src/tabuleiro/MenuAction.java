package tabuleiro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MenuAction implements ActionListener 
{
	
	private Tabuleiro tab;
	
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
	   } 
	   
	   if(e.getActionCommand()== "Salvar")
	   {
		   tab.SaveGame("Teste.txt");
	   }
	    

	}
	
	public MenuAction(Tabuleiro tabuleiro) 
	{
		tab = tabuleiro;
	}

	
}
