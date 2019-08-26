package control;
import java.awt.*;
import java.awt.event.*;

public class ControlBienvenida implements MouseListener{
	public void mouseEntered(MouseEvent evento1) {
        Main.ventanaLogin.getL1().setForeground((Color.BLUE));
    }
    public void mouseExited(MouseEvent evento2) {
    	Main.ventanaLogin.getL1().setForeground((Color.BLACK));
    }
    public void mouseReleased(MouseEvent evento3) {
    }
    public void mouseClicked(MouseEvent evento3) {
    }
    public void mousePressed(MouseEvent evento3) {	
    }
    
}
