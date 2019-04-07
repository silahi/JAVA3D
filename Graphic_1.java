
/**
*@author alhoussene
*date 20/01/19
*/

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.*;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.ImageIcon; 
import java.awt.Font;
import java.awt.RenderingHints; 

import java.awt.GradientPaint;


public class Graphic_1 extends JFrame{
	private Paper paper = null;
	private double x = 10 , y = 10;
    private DrawModel model = null;
    protected Thread tache    = null; 
    private double angle0   = 0;
    private double angle1   = 120;
    private double angle2   = 240;  
    private String message ; 
    private Graphics2D surface;

    private PointModel pointModel = null;
    protected Thread tache1        = null; 
     
    private Font font = new Font("Sans Serif", Font.BOLD ,20);
    private JFrame canvas;
	public Graphic_1( String message , JFrame canvas){
        super("Formes de base");
        this.message = message;
        this.canvas = canvas;
        setSize(Application.width/2 , Application.height /2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setAlwaysOnTop(false);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK);
        setIconImage(new ImageIcon("../ressources/Fond.jpg").getImage());
        setUndecorated(true);
        setBackground(new Color(0,0,0, 150)); 

        paper = new Paper();
        paper.setOpaque(false);
        add(paper); 
 
         
        model = new DrawModel();
        tache = new Thread(model); 
        tache.start(); 

        pointModel = new PointModel();
        tache1     = new Thread(pointModel);
        tache1.start();  

       
	}

  public void setMessage(String m ){
     this.message = m;
  }

  private void etat(boolean value){
     setVisible(value);
  }

	class Paper extends JPanel{
		 
		@Override
		protected void paintComponent(Graphics g){
           surface = (Graphics2D)g;
           surface.setPaint(new GradientPaint(10,10,Color.RED , 30,30 , Color.YELLOW, true));
           surface.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
           font.deriveFont(48F);
           surface.setFont(font);
           Rectangle2D rect0 = new Rectangle2D.Double( (Application.width / 4)-50 , (Application.height/4)-50 , 100 , 100 );
           Rectangle2D rect1 = new Rectangle2D.Double( (Application.width / 4)-50 , (Application.height/4)-50 , 100 , 100 ); 
           Rectangle2D rect2 = new Rectangle2D.Double( (Application.width / 4)-50 , (Application.height/4)-50 , 100 , 100 ); 
           Arc2D arc0 = new Arc2D.Double(rect0 , angle0 , 50 , Arc2D.OPEN);          
           Arc2D arc1 = new Arc2D.Double(rect1 , angle1 , 50 , Arc2D.OPEN);
           Arc2D arc2 = new Arc2D.Double(rect2 , angle2 , 50 , Arc2D.OPEN); 
           
           surface.setRenderingHint(RenderingHints.KEY_RENDERING , RenderingHints.VALUE_RENDER_SPEED);  
           surface.draw(arc0);
           surface.draw(arc1);
           surface.draw(arc2);  

           surface.drawString(message , (Application.width/4) - 130 , (Application.height/4)+70);
		} 
		 
	} 

	// Tache 1
	class PointModel implements Runnable{
		@Override
		public void run(){
			try{
		
                  while(true){
                  	message = message+".";
                  	Thread.sleep(500); 
                    if(canvas.isVisible()) {
                      surface.setPaint(new Color(0,255,0));
                      setMessage("Chargement      Complet !"); 
                      tache.join(5000);
                      etat(false);                   
                    }
                  	if(message.equals("Chargement de la Scene...")){
                  		message = "Chargement de la Scene";                  		
                  	}
                  }
			}catch(InterruptedException ie){
				System.err.println(ie.getMessage());
			}
		}
	}

 
	 //Tache 2

	class DrawModel implements Runnable{
		public void run(){
			try{
			    for(int i = 0 ; i<= 360 ; i++){
			    	angle0++;
			    	angle1++;
			    	angle2++;
			    	angle1++; 	    	
			    	if(i == 360){i = 0; angle0 = 0; angle1= 120; angle2 = 240;} 
                   Thread.sleep(5);                    
                   paper.repaint();
		      }
		}catch(InterruptedException ie){
			System.err.println(ie.getMessage());}
		}
	}
}