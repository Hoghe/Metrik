import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuBar extends MenuBar implements ActionListener {

	private Menu _menu;
	private final Canvas _drawObjects;
	private MenuItem _color0, _color1, _color2, _color3, _color4;
	
	public MainMenuBar( Canvas drawObjects ) {
		
		this._drawObjects = drawObjects;
		
		_menu = new Menu("Hintergrund");
		
		_color0 = new MenuItem( "Farbe: weiss" );
		_color0.addActionListener(this);
		_menu.add( _color0 );
		_color1 = new MenuItem( "Farbe: rot" );
		_color1.addActionListener(this);
		_menu.add( _color1 );
		_color2 = new MenuItem( "Farbe: gelb" );
		_color2.addActionListener(this);
		_menu.add( _color2 );
		_color3 = new MenuItem( "Farbe: grün" );
		_color3.addActionListener(this);
		_menu.add( _color3 );
		_color4 = new MenuItem( "Farbe: blau" );
		_color4.addActionListener(this);
		_menu.add( _color4 );
		
		add(_menu);
		
	}

	@Override
	public void actionPerformed( ActionEvent e ) {
		
		if ( e.getSource() == _color0 ) {
			_drawObjects.setBackground( Color.white );
		}
		else if ( e.getSource() == _color1 ) {
			_drawObjects.setBackground( Color.red );
		}
		else if ( e.getSource() == _color2 ) {
			_drawObjects.setBackground( Color.yellow );
		}
		else if ( e.getSource() == _color3 ) {
			_drawObjects.setBackground( Color.green );
		}
		else if  ( e.getSource() == _color4 ) {
			_drawObjects.setBackground( Color.blue );
		}
		
	}
	
}
