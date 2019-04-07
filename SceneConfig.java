
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SceneConfig extends JFrame{
	
	protected Runnable show , hide;
	protected Thread  task0 , task1; 
	protected int x=0 , y = 0;
    private Toolkit kit = Toolkit.getDefaultToolkit();
    
    private JPanel rootPanel = null;
    
	public SceneConfig(){
		setIconImage(new ImageIcon("../ressources/hon.png").getImage());
		setSize(kit.getScreenSize().width/5 , kit.getScreenSize().height);
		getContentPane().setBackground(Color.black);
		setLocation(x , y); 
		setAlwaysOnTop(true);

        rootPanel = new JPanel();
        rootPanel.setOpaque(false);
        add(rootPanel);
        


        rootPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

		y = getSize().height;
		setUndecorated(true);
        setBackground(new Color(0,0,0 , 200));
        show = new Showing();
        hide = new Hidding();
        task0     = new Thread(show); 
         
        task0.start();

         Building b1 = new Building("Hide");
         b1.build.addActionListener((ActionEvent)->{
         	 task1     = new Thread(hide);
         	 task1.start();
         });   

         rootPanel.add(b1);
	}



// Afficher la fenetre 
	class Showing implements Runnable{		 
		public void run(){
			try{
			    while(y > 0){			     
                   Thread.sleep(1);
                   y--;
                    setLocation(x , y); 
		      }
		}catch(InterruptedException ie){
			System.err.println(ie.getMessage());}
		}
	}
      // cacher la fenetre
	class Hidding implements Runnable{		 
		public void run(){
			try{
			    while(y< (getSize().height)){			     
                   Thread.sleep(1);
                   y++;
                    setLocation(x , y); 
		      }
		}catch(InterruptedException ie){
			System.err.println(ie.getMessage());}
		}
	} 
}