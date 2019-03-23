
import javax.swing.*;
import java.awt.*;

public class SceneConfig extends JFrame{
	
	protected Runnable scroller = null;
	protected Thread  task = null; 
	protected int x=0 , y = 0;
    private Toolkit kit = Toolkit.getDefaultToolkit();

    private JPanel rootPanel = null;
    
	public SceneConfig(){
		setIconImage(new ImageIcon("../ressources/hon.png").getImage());
		setSize(kit.getScreenSize().width/4 , kit.getScreenSize().height -100);
		getContentPane().setBackground(Color.black);
		setLocation(x , y);
        
        Building b1 = new Building("Construction");
        

        rootPanel = new JPanel();
        rootPanel.setOpaque(false);
        add(rootPanel);
        rootPanel.add(b1);

        rootPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

		y = getSize().height;
		setUndecorated(true);
        setBackground(new Color(0,0,0 , 200));
        scroller = new FrameScroller();
        task     = new Thread(scroller); 
        task.start();
	}



	class FrameScroller implements Runnable{
		public void run(){
			try{
			    while(y>50){			     
                   Thread.sleep(1);
                   y--;
                    setLocation(x , y); 
		      }
		}catch(InterruptedException ie){
			System.err.println(ie.getMessage());}
		}
	}

	public static void main(String[] args) {
		SceneConfig conf = new SceneConfig();
		conf.setVisible(true);
	}

}