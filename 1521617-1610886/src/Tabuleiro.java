import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.*;
public class Tabuleiro extends JPanel {
	public void paintComponent(Graphics g) 
	{
			super.paintComponent(g);
			Graphics2D g2d=(Graphics2D) g;
			int i=0,j=0;
			double leftX=0;/* Posição inicial no eixo X do topo superior esquerdo do primeiro retangulo */
			double topY=0; /* Posição inicial no eixo Y do topo superior esquerdo do primeiro retangulo */
			double larg=100.0; /* Largura do retangulo */
			double alt=75.0; /* Altura do retangulo */
			
			while(i<8)
			{
				if(i%2 == 0) /* Essa verificação é para inverter as cores quando pudar de linha */
				{
					for(j=0; j<8; j++)
					{
						if(j%2 == 0)
						{
							Rectangle2D rt=new Rectangle2D.Double(leftX,topY,larg,alt);
							g2d.setPaint(Color.black);
							g2d.fill(rt);
							leftX += 100; /* Adicionando 100 para proxima coluna*/
						}
						else
						{
							Rectangle2D rt=new Rectangle2D.Double(leftX,topY,larg,alt);
							g2d.setPaint(Color.white);
							g2d.fill(rt);
							leftX += 100;
						}
					
					}
					topY += 75; /* Adicionando 75 para a proxima linha */
					leftX = 0; /* Reseta a posição horizontal para começar uma nova linha */
					i++;
				}
				else
				{
					for(j=0; j<8; j++)
					{
						if(j%2 == 0)
						{
							Rectangle2D rt=new Rectangle2D.Double(leftX,topY,larg,alt);
							g2d.setPaint(Color.white);
							g2d.fill(rt);
							leftX += 100;
						}
						else
						{
							Rectangle2D rt=new Rectangle2D.Double(leftX,topY,larg,alt);
							g2d.setPaint(Color.black);
							g2d.fill(rt);
							leftX += 100;
						}
					
					}
					topY += 75; /* Adiciona 75 para a proxima linha*/
					leftX = 0; /* Reseta a posição horizontal para começar uma nova linha */
					i++;
				}
			}
			
			
			
	}
	public static void main(String[] args) 	
	{
		JFrame frame = new JFrame();
		frame.setSize(800,600);
		frame.getContentPane().add(new Tabuleiro());
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

