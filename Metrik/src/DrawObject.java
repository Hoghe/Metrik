import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class DrawObject extends Canvas implements MouseListener{
	
	private double _x, _y;
	private int _count;
	private TextField _x1, _y1, _x2, _y2, _tfr;
	private int _breite;
	private int _hoehe;
	private double _radius;

	
	
	public DrawObject(int _breite, int _hoehe, TextField _x1, TextField _y1, TextField _x2, TextField _y2, TextField _tfr) {
		this._x1 = _x1;
		this._y1 = _y1;
		this._x2 = _x2;
		this._y2 = _y2;
		this._tfr = _tfr;   
		this._breite = _breite;
		this._hoehe = _hoehe;
		_x = _y = 0.0;
		_count = 0;
		setSize(_breite,_hoehe);
		setBackground(Color.white);
		addMouseListener(this);
	}
	
	public void paint(Graphics g, zeichenmodus auswahl ) {
		if(_x == 0 && _y == 0) return;
		Graphics2D g2d = (Graphics2D) g;
		switch(auswahl) {
		case ZEICHNEN:
			Ellipse2D kreis = new Ellipse2D.Double(_x, _y, _radius, _radius);
			g2d.draw(kreis);
			break;
		case LOESCHEN:
			g2d.clearRect(0, 0, _breite, _hoehe);
		}
	}
	
	public void mouseClicked(MouseEvent e) {
		
		String text = _tfr.getText();
		this._radius = 0.0;
	    try
	    {
	      double zahl = Double.parseDouble(text);
	      _radius = zahl;
	    }
	    catch(NumberFormatException ex)
	    {
	    	_tfr.setText("Bitte Zahl eingeben");
	    }
				
		_x = e.getX();
		_y = e.getY();

		if(_count == 0 && _radius>0.0) {
			paint(getGraphics(), zeichenmodus.ZEICHNEN);
			_x1.setText("x= "+(_x+_radius));
			_y1.setText("y= "+(_y+_radius));
			_count++;
		} else if (_count==1 && _radius>0.0) {
			paint(getGraphics(), zeichenmodus.ZEICHNEN);
			_x2.setText("x= "+(_x+_radius));
			_y2.setText("y= "+(_y+_radius));
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
