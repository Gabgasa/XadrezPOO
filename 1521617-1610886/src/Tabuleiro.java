import javax.swing.*;
import java.awt.*;
public class Tabuleiro extends JFrame
{
	JButton casa[][] = new JButton[8][8];/*As casas da minha matriz tabuleiro vão ser JButtons*/
	int j=0,i=0;
	Tabuleiro()
	{
		setTitle("Tabuleiro");	
		setSize(800,600);
		getContentPane().setLayout(new GridLayout(8 ,8));/*Um grid de 8 por 8 como layout do meu Pane*/
		for (i=0;i<8;i++) /* Transformando todas as casas da matriz em JButtom */
		{
			for(j=0;j<8;j++)
			{
				casa[i][j]=new JButton();
			}
		}
		
		for(i=0; i<8; i++)/* Navegando pelas linhas da matriz */
		{	
			if(i%2 == 0)/*Eu coloquei isso para inverter as cores após mudar de linha*/
			{
				for(j=0;j<8;j++)/*Navegando pelas colunas e pintando o tabuleiro*/
				{
					if(j%2 == 0)
					{
						casa[i][j].setBackground(Color.black);
						getContentPane().add(casa[i][j]);
					}
				
					else
					{
						casa[i][j].setBackground(Color.white);
						getContentPane().add(casa[i][j]);
					}
				}
			}
			else /*Invertendo as cores da linha*/
			{
				for(j=0;j<8;j++)
				{
					if(j%2 == 0)
					{
						casa[i][j].setBackground(Color.white);
						getContentPane().add(casa[i][j]);
					}
				
					else
					{
						casa[i][j].setBackground(Color.black);
						getContentPane().add(casa[i][j]);
					}
				}
			}
			
		}
		
	}
	public static void main(String args[])
	{
		JFrame tabuleiro = new Tabuleiro();
		tabuleiro.show();
	}
}