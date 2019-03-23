
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
	 private BranchGroup rootNode   = null;
	 protected static BoundingSphere region = new BoundingSphere(new Point3d(0,0,0) , 10000);
     private static Toolkit kit = Toolkit.getDefaultToolkit();
     protected static int width = kit.getScreenSize().width;
     protected static int height = kit.getScreenSize().height;
     private Graphic_1 patience = null;
     private TransformGroup rootGroup = null;
	 public Application(){
         setSize(width , height);
         setLocationRelativeTo(null);
         setDefaultCloseOperation(EXIT_ON_CLOSE);
         setIconImage(new ImageIcon("../ressources/ali.jpg").getImage()); 
         
         patience = new Graphic_1("Chargement de la Scene" ,this);
         patience.setVisible(true);
         
         rootGroup = new TransformGroup();
         canvas = new Canvas3D(SimpleUniverse.getPreferredConfiguration());
         simpUniv = new SimpleUniverse(canvas);
         simpUniv.getViewingPlatform().setNominalViewingTransform();
         View vue = simpUniv.getViewer().getView();
         vue.setBackClipDistance(10000);
         rootNode = sceneGraph();
         rootNode.compile();
         simpUniv.addBranchGraph(rootNode);
         add(canvas);
	 }

	 private BranchGroup sceneGraph(){
	 	BranchGroup  root = new BranchGroup(); 
        rootGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        rootGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        TransformGroup keyGroup = simpUniv.getViewingPlatform().getViewPlatformTransform();
        KeyNavigatorBehavior keyNav = new KeyNavigatorBehavior(keyGroup);
        keyNav.setSchedulingBounds(region);
        root.addChild(keyNav);
        
        TransformGroup solTransform = solGroup();  
        root.addChild(solTransform);
	 	return root;
	 }

	 private TransformGroup solGroup(){
	 	Transform3D tr0 = new Transform3D();
	 	tr0.setTranslation(new Vector3f(0,-20,-100));
        
        TransformGroup town = new TransformGroup(); 
        town.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        town.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        MouseRotate mouse = new MouseRotate(town);
	 	mouse.setFactor(0.003);
	 	mouse.setSchedulingBounds(region);
	 	town.addChild(mouse);	 	
	 	TransformGroup tg = new TransformGroup(tr0);

	 	// Etablissement du sol
	 	 Point3f [] points = {
        	new Point3f(100f , 0f,100f),
        	new Point3f(100f,0f,-100f),
        	new Point3f(-100f,0f,-100f),
        	new Point3f(-100f,0f,100f)
        };

        TexCoord2f[] texels = {
        	new TexCoord2f(0,1),
        	new TexCoord2f(0,1),
        	new TexCoord2f(0,1),
        	new TexCoord2f(0,1)
        };

	 	Sol sol = new Sol(points , texels , new Color3f(Color.gray),"sol.jpg" , canvas);

        // Haie de devant
        TransformGroup fH = frontHedge();
        // Haie de droite
        TransformGroup rH = rightHedge();
        // Haie de droite
        TransformGroup lH = leftHedge();
         // Haie de derière
        TransformGroup bH = backHedge();

	 	// Ajout des composants
        town.addChild(sol);
        town.addChild(fH);
        town.addChild(rH);
        town.addChild(lH);
        town.addChild(bH);

        tg.addChild(town); 

	 	return tg;
	 }
      
      // Construction de la haie de devant
	 private  TransformGroup frontHedge(){
	 	TransformGroup tg = new TransformGroup();
	 		Point3f [] points = {
        	new Point3f(100f , 0f,-100f),
        	new Point3f(100f,50f,-100f),
        	new Point3f(-100f,50f,-100f),
        	new Point3f(-100f,0f,  -100f)
        };
         TexCoord2f[] texels = {
        	new TexCoord2f(0,1),
        	new TexCoord2f(0,1),
        	new TexCoord2f(0,1),
        	new TexCoord2f(0,1)
        };

        Sol front = new Sol(points, texels , new Color3f(Color.red) , "w11.jpg" , canvas);
        tg.addChild(front);
	 	return tg;
	 } 

	  //  Construction de la haie de droite
	 private  TransformGroup rightHedge(){
	 	TransformGroup tg = new TransformGroup();
	 		Point3f [] points = {
        	new Point3f(100f , 50f,100f),
        	new Point3f(100f,50f,-100f),
        	new Point3f(100f,0f,-100f),
        	new Point3f(100f,0f,  100f)
        };
         TexCoord2f[] texels = {
        	new TexCoord2f(0,1),
        	new TexCoord2f(0,1),
        	new TexCoord2f(0,1),
        	new TexCoord2f(0,1)
        };

        Sol front = new Sol(points, texels , new Color3f(Color.cyan)  , "w11.jpg" , canvas);
        tg.addChild(front);
	 	return tg;
	 } 

       //  Construction de la haie de gauche
	 private  TransformGroup leftHedge(){
	 	TransformGroup tg = new TransformGroup();
	 		Point3f [] points = {
        	new Point3f(-100f , 0f,100f),
        	new Point3f(-100f,0f,-100f),
        	new Point3f(-100f,50f,-100f),
        	new Point3f(-100f,50f,  100f)
        };
        TexCoord2f[] texels = {
        	new TexCoord2f(0,1),
        	new TexCoord2f(0,1),
        	new TexCoord2f(0,1),
        	new TexCoord2f(0,1)
        };

        Sol front = new Sol(points,texels ,new Color3f(Color.yellow) , "w11.jpg" , canvas);
        tg.addChild(front);
	 	return tg;
	 } 

	  //  Construction de la haie de derière
	 private  TransformGroup backHedge(){
	 	TransformGroup tg = new TransformGroup();
	 		Point3f [] points = {
        	new Point3f(100f , 0f,100f),
        	new Point3f(100f,50f,100f),
        	new Point3f(-100f,50f,100f),
        	new Point3f(-100f,0f,  100f)
        };
         TexCoord2f[] texels = {
        	new TexCoord2f(0,1),
        	new TexCoord2f(0,1),
        	new TexCoord2f(0,1),
        	new TexCoord2f(0,1)
        };

        Sol front = new Sol(points,texels , new Color3f(Color.green) , "w11.jpg" , canvas);
        tg.addChild(front);
	 	return tg;
	 } 


	 public static void main(String[] args) {
	 	Application application = new Application();
	 	application.setVisible(true);
	 }
}