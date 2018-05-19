import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.*;



public class Tabuleiro {
	public int peca;
	double leftX=100.0;
	double topY=100.0;
	double larg=200.0;
	double alt=150.0;
	
	
	Rectangle2D rt=new Rectangle2D.Double(leftX,topY,larg,alt);
	g2d.draw(rt);
	// Desenha a elipse interna ao retângulo
	Ellipse2D e=new Ellipse2D.Double();
	e.setFrame(rt);
	g2d.draw(e);
}
