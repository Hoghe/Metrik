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
	private String _lineLength = "";
	private double _posX1 = 0;
	private double _posX2 = 0;
	private double _posY1 = 0;
	private double _posY2 = 0;
	
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
		Ellipse2D kreis = new Ellipse2D.Double(_x, _y, _radius*2, _radius*2);
		switch(auswahl) {
		case ZEICHNEN:
			g2d.draw(kreis);
			break;
		case MITLINIE:
			g2d.draw(kreis);
			Shape linie = new Line2D.Double(Double.parseDouble(_x1.getText()) ,
					Double.parseDouble(_y1.getText()),
					Double.parseDouble(_x2.getText()),
					Double.parseDouble(_y2.getText()));
			g2d.draw(linie);
			g2d.draw(kreis);
			
			Font hypo = new Font("Arial", Font.BOLD, 12);
			g2d.setFont(hypo);
			g2d.drawString( _lineLength, _breite/100*25, 15 );
			_lineLength = "";
			
			break;
		case LOESCHEN:
			g2d.clearRect(0, 0, _breite, _hoehe);
		}
	}
	
	public void mouseClicked(MouseEvent e) {
		
		String text = _tfr.getText();
		this._radius = 0.0;
		
		double a = 0.0;
		double b = 0.0;
		double c = 0.0;
		
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
			_x1.setText(""+(_x+_radius));
			_y1.setText(""+(_y+_radius));
			_posX1 = _x + _radius;
			_posY1 = _y + _radius;
			paint(getGraphics(), zeichenmodus.ZEICHNEN);
			_count++;
		} else if (_count==1 && _radius>0.0) {
			_x2.setText(""+(_x+_radius));
			_y2.setText(""+(_y+_radius));
			_posX2 = _x + _radius;
			_posY2 = _y + _radius;
			
			b = _posX2 - _posX1;
			a = _posY2 - _posY1;
			c = Math.round( 100.0 * Math.sqrt( a*a + b*b ) ) / 100.0;
			_lineLength = _lineLength + "Länge der Verbindungslinie: " + c;
			
			paint(getGraphics(), zeichenmodus.MITLINIE);
			_count++;		
		} else {
			paint(getGraphics(), zeichenmodus.LOESCHEN);
			_count=0;
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	
	private enum zeichenmodus	{
		
		 ZEICHNEN, MITLINIE, LOESCHEN
		 }

}
