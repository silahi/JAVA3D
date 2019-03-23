
import com.sun.j3d.utils.universe.SimpleUniverse;
import javax.swing.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import java.awt.*;

public class Application extends JFrame{
	 private SimpleUniverse simpUniv = null;
	 private Canvas3D canvas         = null;
	 private BranchGroup rootNode   = null;
	 private static BoundingSphere region = new BoundingSphere(new Point3d(0,0,0) , 10000);
     private static Toolkit kit = Toolkit.getDefaultToolkit();
     protected static int width = kit.getScreenSize().width;
     protected static int height = kit.getScreenSize().height;
     private Graphic_1 patience = null;
	 public Application(){
         setSize(width , height);
         setLocationRelativeTo(null);
         setDefaultCloseOperation(EXIT_ON_CLOSE);
         setIconImage(new ImageIcon("../ressources/ali.jpg").getImage()); 
         
         patience = new Graphic_1("Chargement de la Scene" ,this);
         patience.setVisible(true);
         
         canvas = new Canvas3D(SimpleUniverse.getPreferredConfiguration());
         simpUniv = new SimpleUniverse(canvas);
         simpUniv.getViewingPlatform().setNominalViewingTransform();

         rootNode = new BranchGroup();
         rootNode.compile();
         simpUniv.addBranchGraph(rootNode);
         add(canvas);



	 }

	 public static void main(String[] args) {
	 	Application application = new Application();
	 	application.setVisible(true);
	 }
}