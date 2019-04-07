
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

        // SceneConfig sc = new SceneConfig();
       //  sc.setVisible(true); 
	 }

	 private BranchGroup sceneGraph(){
        
        position.setTranslation(new Vector3f(0,-10,-50));
        TransformGroup home = new TransformGroup();  
	 	BranchGroup  root = new BranchGroup(); 
	 	  
         // Haie de devant
        TransformGroup fH = frontHedge();
        // Haie de droite
      
        // Haie de droite
        TransformGroup lH = leftHedge();
         // Haie de derière
        TransformGroup bH = backHedge(); 
        
            TransformGroup rH = rightHedge();
            home.addChild(rH);
        home.addChild(earth()); 

	 	// Ajout des composants
         
        home.addChild(fH);       
        home.addChild(lH);
        home.addChild(bH); 

        // création et ajout des Maisons 
        
        AlignHouse a1 = new AlignHouse(new Maison(2,2) , new Vector3f(0f,0f,-3f)); 
        AlignHouse[] houses = {a1 };
        for(AlignHouse ah : houses){
        	home.addChild(ah);
        }        

        Town city = new Town();       
        city.townGroup.addChild(home);
        city.setTransform(position);
        root.addChild(city);
	 	return root;
	 }

	    private TransformGroup earth(){
	    	Face sol = new Face("green.jpg" , canvas , Face.BOTTOM , x,y,z); 
	    	TransformGroup tg = sol.faceGroup;
	    	return tg;
	    }    
     
      
      // Construction de la haie de devant
	 private  TransformGroup frontHedge(){	 	
	    Face sol = new Face("w11_cop.jpg" , canvas , Face.FRONT , x,y,z); 
	    TransformGroup tg = sol.faceGroup;		 
	 	return tg;
	 } 

	   //  Construction de la haie de droite
	 private  TransformGroup rightHedge(){
	    Face sol = new Face("w11_cop.jpg" , canvas , Face.RIGHT , x,y,z); 
	 	TransformGroup tg = sol.faceGroup;	 		 
        
	 	return tg;
	 } 

	  //  Construction de la haie de gauche
	 private  TransformGroup leftHedge(){
	    Face sol = new Face("w11_cop.jpg" , canvas , Face.LEFT , x,y,z); 
	 	TransformGroup tg = sol.faceGroup;	 		 
        
	 	return tg;
	 }  

	  //  Construction de la haie de derière
	 private  TransformGroup backHedge(){
	 	    Face sol = new Face("w11.jpg" , canvas , Face.BACK ,x,y,z);	 
	 	    TransformGroup tg = sol.faceGroup;	 
	 	return tg;
	 } 


	 public static void main(String[] args) {
	 	Application application = new Application();
	 	application.setVisible(true);
	 }
}