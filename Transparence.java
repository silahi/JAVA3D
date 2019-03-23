
import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.UIManager;
public class Transparence extends JFrame{
	private int alpha;
	private  String message  = "Opacité/Transparence";
	private OpacityModel opacityModel = null;
	private Thread task0  = null;
	private JLabel label = null;
	private JLabel lab = new JLabel("",JLabel.CENTER);
	private Color color = null;
	private SecondModel secModel = null;
	private Thread task1 = null;
	public Transparence(){
        super("Opacité et Transparence d' une fenêtre swing");
        setSize(800 , 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        color = new Color(0,0,0);
        setExtendedState(MAXIMIZED_BOTH);
        setUndecorated(true);
        setBackground(new Color(0,0,0,alpha));
        getContentPane().setBackground(color);
        
        try{
              UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }catch(Exception ex){
        	setTitle(ex.getMessage());
        }
       
        opacityModel = new OpacityModel();
        task0         = new Thread(opacityModel);

        label = new JLabel("Evolution de l'operateur alpha : "+alpha,JLabel.CENTER);
        add(label);
        add(lab , "South");
        label.setForeground(new Color(170,221,0));
        lab.setForeground(new Color(170,221,0));
        label.setFont(new Font("Calibri",Font.BOLD + Font.ITALIC, 30));
        lab.setFont(new Font("Calibri",Font.BOLD + Font.ITALIC, 30));  
        task0.start();

        secModel = new SecondModel();
        task1    = new Thread(secModel);
         
	}

	private  class SecondModel implements Runnable{
		@Override
		public void run(){
			try{
                  for(int i =0 ; i<=100 ; i++){
                  	label.setForeground(Color.RED);
                  	label.setText("Time To Exit");
                  	label.setVisible(!label.isVisible());
                  	Thread.sleep(100);
                  	if(i == 100)
                  		System.exit(0);
                  }
			}catch(InterruptedException ie){
				setTitle(ie.getMessage());
			}
		}
	}

	private class OpacityModel implements Runnable{
		@Override
		public void run(){
           try{
                 for(int i= 0 ; i<= 255 ; i++){
                 	alpha=i;  
                    label.setText("Evolution de l'operateur alpha : "+alpha); 
                    setBackground(new Color(0,0,0,alpha)); 	 
                 	Thread.sleep(100); 
                 	if(i== 255){
                 		task1.start();
                 	}
                 }
           }catch(InterruptedException ie){
           	 setTitle(ie.getMessage());
           }
		}
	}
}