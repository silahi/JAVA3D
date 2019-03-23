
import javax.swing.*;
import java.awt.*;

public class SceneConfig extends JFrame{
	public SceneConfig(){
		setIconImage(new ImageIcon("../ressources/param.png").getImage());
		setSize((Application.width)/2 , (Application.height)/2);
		getContentPane().setBackground(Color.darkGray);

	}
}