
import javax.media.j3d.*;
import javax.vecmath.*;
public class Maison extends TransformGroup{	
      protected Face bas, droite, devant, gauche,deriere; 
      private float x,y;  
      public Maison(float x , float y){
          this.x = x;
          this.y = y;

          TransformGroup parent = generateFaces();
          addChild(parent);
      }

      public TransformGroup generateFaces(){
      	  TransformGroup facesgroup = new TransformGroup();
      	  bas     = new Face("w11.jpg"  , Face.CHKOMBE ,x,y,x);
      	  droite  = new Face("w11.jpg" , null , Face.RIGHT  ,x,y,x);
      	  devant  = new Face("w11.jpg" , null , Face.FRONT  ,x,y,x); 
      	  gauche  = new Face("w11.jpg" , null , Face.LEFT   ,x,y,x);
      	  deriere = new Face("w11.jpg" , Face.FACE_DOOR,x,y,x);

      	  Face[] faces = {droite,devant,gauche}; 
      	  for(Face f : faces){ 
      	  	   facesgroup.addChild(f.faceGroup); 
      	  } 
          facesgroup.addChild(deriere.faceGroup);
          facesgroup.addChild(bas.faceGroup);
      	  TransformGroup tod = toitDeDroite();
          facesgroup.addChild(tod);



           TransformGroup tog = toitDeGauche();
          facesgroup.addChild(tog);
          
          TransformGroup tbt = backTri();
          facesgroup.addChild(tbt);
          TransformGroup tft = frontTri();
           facesgroup.addChild(tft);
          return facesgroup;
      }

      protected TransformGroup toitDeDroite(){ 
      	TransformGroup tg = new TransformGroup();
      	Face t1 = new Face("w11.jpg" , null, 6 , x,y,x); 
         tg.addChild(t1.faceGroup);
          return tg;
      } 

       protected TransformGroup backTri(){ 
      	TransformGroup tg = new TransformGroup();
      	Face t1 = new Face("w11.jpg" , null, 8 , x,y,x); 
         tg.addChild(t1.faceGroup);
          return tg;
      } 
      protected TransformGroup frontTri(){ 
      	TransformGroup tg = new TransformGroup();
      	Face t1 = new Face("w11.jpg" , null, 9 , x,y,x); 
         tg.addChild(t1.faceGroup);
          return tg;
      } 

       protected TransformGroup toitDeGauche(){ 
      	TransformGroup tg = new TransformGroup();
      	Face t1 = new Face("w11.jpg" , null, 7 , x,y,x); 
         tg.addChild(t1.faceGroup);
          return tg;
      } 
}