import java.awt.*;
import java.awt.event.*;

public class MainWindow extends Frame implements WindowListener{
	
	public MainWindow() {
		setSize(300, 400);
		setTitle("Metrik Version 1.0");
		
		addWindowListener(this);
//		add(new DrawObject());
		
		DrawObject d = new DrawObject();
		add(d);
		
		MainMenuBar mmb = new MainMenuBar(d);
		setMenuBar(mmb);
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
