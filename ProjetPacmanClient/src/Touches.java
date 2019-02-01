import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;


public class Touches extends JPanel implements KeyListener {

	public int touchesCliques;

	
	@Override
    public void keyPressed(KeyEvent e) {

		switch (e.getKeyCode())
	   	  {
	   	  	case KeyEvent.VK_UP :
	   	  		this.touchesCliques = 0;
	   	  		break;
	   	  	case KeyEvent.VK_DOWN:
	   	  		this.touchesCliques = 1;
	   	  		break;
	   	  	case KeyEvent.VK_LEFT:
	   	  		this.touchesCliques = 3;
	   	  		break;
	   	  	case KeyEvent.VK_RIGHT:
	   	  		this.touchesCliques = 2;
	   	  		break;
	   	  		
	   	  	default:
	   	  		this.touchesCliques = 4;
	   	  		break;
	   	  }

    }
	
	public int getToucheClique(){
		return touchesCliques;
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
    