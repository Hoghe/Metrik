import java.awt.*;
import java.awt.event.*;

public class MainWindow extends Frame implements WindowListener{
	
	private int _breite, _hoehe;
	private DrawObject d;
	private FlowLayout flAnordnung = new FlowLayout();
	private Label _kreis_1 = new Label("Kreis 1:");
	private Label _kreis_2 = new Label("Kreis 2:");
	private TextField _tfX_1 = new TextField("x= ",5);
	private TextField _tfY_1 = new TextField("y= ",5);
	private TextField _tfX_2 = new TextField("x= ",5);
	private TextField _tfY_2 = new TextField("y= ",5);
	
	public MainWindow(int _breite, int _hoehe) {
		this._breite = _breite;
		this._hoehe = _hoehe;
		setSize(_breite, _hoehe);
		setTitle("Metrik Version 1.1.1");
		
		addWindowListener(this);
		this.setLayout(flAnordnung);
		
		this.add(_kreis_1);
	    _tfX_1.setEditable(false);
	    this.add(_tfX_1);
	    _tfY_1.setEditable(false);
	    this.add(_tfY_1);

		this.add(_kreis_2);
	    _tfX_2.setEditable(false);
	    this.add(_tfX_2);
	    _tfY_2.setEditable(false);
	    this.add(_tfY_2);
	    
	    d = new DrawObject(_breite, _hoehe, _tfX_1, _tfY_1, _tfX_2, _tfY_2);
		this.add(d);
	}
	
	public void openWindow() {
		setVisible(true);
	}

	@Override
	public void windowClosing(WindowEvent e) {
		dispose();
		System.exit(0);
	}
	
	@Override
	public void windowActivated(WindowEvent e) {
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		
	}

}
