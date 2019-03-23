
/**
  @author alhoussene
  date 23/01/17
  start time 8h:35
*/
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JComponent;
import java.awt.geom.Arc2D;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Font;
import java.awt.geom.Rectangle2D;

public class Patience extends JFrame{
private Arc2D  arc0 = null;
private double angle0 = 0;
private Arc2D  arc1 = null;	
private double angle1 = 135;

private PatienceModel model0 = null;
private Thread task0     = null;
private Zone zone = null;

private String message = "Chargement de la scene...";
     public Patience(){
     	setSize(800 , 500);
     	setLocationRelativeTo(null);
     	 
     	setUndecorated(true);
     	setDefaultCloseOperation(EXIT_ON_CLOSE);
     	setBackground(new Color(0,0,0 , 100));  
        setAlwaysOnTop(true);
        zone = new Zone();         
        add(zone);

        model0 = new PatienceModel();
        task0  = new Thread(model0);
        task0.start();


     }

     private class PatienceModel implements Runnable{
     	@Override
     	public void run(){
     		try{
                  for(int i = 0 ; i<=360 ; i++){
                  	 angle0++;
                  	 angle1++; 
                     if(angle0 == 360) angle0 = 0;
                     if(angle1 == 360) angle1 = 135;
                    Thread.sleep(100); 
                    zone.repaint();
                  }
     		}catch(InterruptedException ie){
     			System.out.println(ie.getMessage());
     		}
     	}
     }

     private class Zone extends JComponent{
     	@Override
     	protected void paintComponent(Graphics g){
     		Graphics2D surface = (Graphics2D)g;
     		surface.shear(0 , 0);
     		surface.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
     		surface.setPaint(new Color(170,221,0));
     		surface.setFont(new Font("Calibri", Font.BOLD+Font.ITALIC , 20));
     		Rectangle2D rect0 = new Rectangle2D.Double((getSize().width /2) - 100,(getSize().height/2) - 100, 200,100);
     		Rectangle2D rect1 = new Rectangle2D.Double((getSize().width /2) - 100,(getSize().height/2) - 100, 100,100);
     		arc0  = new Arc2D.Double(rect0,angle0,54 , Arc2D.OPEN);
     	    arc1  = new Arc2D.Double(rect1,angle1, 45 , Arc2D.OPEN);
            surface.draw(arc0);
            surface.draw(arc1);
            surface.drawString(message , (getSize().width /2) - 70,(getSize().height/2 -50));
     	}
     }
}