
import javax.swing.*;
import java.awt.*;

public class Building extends JPanel{
	private JButton build = null;

	public Building (String title){
          build = new ButtonModel(title);
          setOpaque(false);
          add(build);
	}

	protected class ButtonModel extends JButton{
		public ButtonModel(String title){
              super(title);
              this.setBackground(Color.BLACK);
              this.setOpaque(false);
              this.setFocusPainted(false);
              this.setBorderPainted(false);
              this.setForeground(Color.GRAY);
		}
	}
}