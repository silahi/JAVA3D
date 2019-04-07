
import com.sun.j3d.utils.universe.SimpleUniverse;
import javax.swing.*;
import com.sun.j3d.utils.geometry.ColorCube;
import javax.media.j3d.*;
import javax.vecmath.*;
import java.awt.*;
import com.sun.j3d.utils.behaviors.mouse.*;
import com.sun.j3d.utils.behaviors.keyboard.*;

public class Application extends JFrame{
	 private SimpleUniverse simpUniv = null;
	 private Canvas3D canvas         = null;
	 private BranchGroup townGraph    = null;
	 protected static BoundingSphere region = new BoundingSphere(new Point3d(0,0,0) , 10000);
     private static Toolkit kit = Toolkit.getDefaultToolkit();
     protected static int width = kit.getScreenSize().width;
     protected static int height = kit.getScreenSize().height;
     private Graphic_1 patience = null; 
     private float x = 10f ,y =  2f , z= 10f;
     private Transform3D position = null;
      	 public Application(){
         setSize(width , height);
         setLocationRelativeTo(null);
         setDefaultCloseOperation(EXIT_ON_CLOSE);
         setIconImage(new ImageIcon("../ressources/ali.jpg").getImage()); 
         
         patience = new Graphic_1("Chargement de la Scene" ,this);
         patience.setVisible(true);
         
         position = new Transform3D();
         canvas = new Canvas3D(SimpleUniverse.getPreferredConfiguration());
         simpUniv = new SimpleUniverse(canvas);
         simpUniv.getViewingPlatform().setNominalViewingTransform();
         View vue = simpUniv.getViewer().getView();
         vue.setBackClipDistance(50000);
         townGraph = sceneGraph();
         townGraph.compile();
         simpUniv.addBranchGraph(townGraph);
         add(canvas); 
	 }

	 private BranchGroup sceneGraph(){
        
        position.setTranslation(new Vector3f(0,-10,-50));
        TransformGroup home = new TransformGroup();  
	 	BranchGroup  root = new BranchGroup(); 
        House house = new House(3,3 ,3);
        home.addChild(house.houseGroup);
        Town city = new Town();       
        city.townGroup.addChild(home);
        city.setTransform(position);
        root.addChild(city);
	 	return root;
	 } 

     public static void main(String[] args) {
         Application application = new Application();
         application.setVisible(true);
     }
}