import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class DrawObject extends Canvas implements MouseListener{
	
	private float _x, _y;
	private int _count;

	
	
	public DrawObject() {
		_x = _y = _count = 0;
		setSize(300,400);
		setBackground(Color.white);
		addMouseListener(this);
		System.out.println(_x+" "+_y);
	}
	
	public void paint(Graphics g, zeichenmodus auswahl ) {
		if(_x == 0 && _y == 0) return;
		Graphics2D g2d = (Graphics2D) g;
		switch(auswahl) {
		case ZEICHNEN:
			Rectangle2D quadrat = new Rectangle2D.Float(_x, _y, 20F, 20F);
			g2d.draw(quadrat);
			break;
		case LOESCHEN:
			g2d.clearRect(0, 0, 300, 400);
		}
	}
	
	public void mouseClicked(MouseEvent e) {
		_x = e.getX();
		_y = e.getY();
		if(_count<2) {
			paint(getGraphics(), zeichenmodus.ZEICHNEN);
			_count++;
		} else {
			paint(getGraphics(), zeichenmodus.LOESCHEN);
			_count=0;

		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Automatisch generierter Methodenstub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Automatisch generierter Methodenstub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Automatisch generierter Methodenstub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Automatisch generierter Methodenstub
		
	}
	
	private enum zeichenmodus	{
		
		 ZEICHNEN, LOESCHEN
		 }

}
