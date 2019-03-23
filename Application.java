
import com.sun.j3d.utils.universe.SimpleUniverse;
import javax.swing.*;
import javax.media.j3d.*;
import javax.vecmath.*;

public class Application extends JFrame{
	 private SimpleUniverse simpUniv = null;
	 private Canvas3D canvas         = null;
	 private BranchGroup rootNode   = null;
	 private static BoundingSphere region = new BoundingSphere(new Point3d(0,0,0) , 10000);
     private Toolkit kit = Toolkit.getDefaultToolkit();
     private int width = kit.getScreenSize().width;
     private int height = kit.getScreenSize().height;
	 public Application(){
         setSize(width , height);
         setLocationRelativeTo(null);
         setDefaultCloseOperation(EXIT_ON_CLOSE);
         setIconImage(new ImageIcon("../ressources/ali.jpg"));
         
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