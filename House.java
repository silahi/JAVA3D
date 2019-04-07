
import com.sun.j3d.utils.geometry.*;
import javax.media.j3d.*;
import javax.vecmath.*;

/**
    <p>
     Cette classe permet de créer une face rectangulaire formée par 4
     sommets dont chaque sommet est représenté par un point de 3 dimension qu'on spécifiera 
     dans la methode setFaceCoordinate(Face , x , y ,z):
     Face représente l'une des faces définie dans l'une des constantes {Top-Bottop-Left-right-back-front}      
     </p>
     @author Alhoussene
*/
public class House {
   public static final int VERTEX_COUNT = 4;
   public static final int BOTTOM = 0;
   public static final int TOP    = 1;   
   public static final int RIGHT  = 2;
   public static final int FRONT  = 3;
   public static final int LEFT   = 4;
   public static final int BACK   = 5;
   public static final int TOIT_DROIT = 6;
   public static final int TOIT_GAUCHE= 7;
   public static final int BACK_TRI   = 8;
   public static final int FRONT_TRI  = 9;
   public static final int FACE_DOOR  = 10;
   public static final int CHKOMBE    = 11; 

   // Cette methode permet de specifier les coordonées des sommets de la face qui sera spécifier
   public Void setFaceCoordinate(QuadArray face , int faceValue ,float x , float y , float z){
          Point3f point = new Point3f();
          // Generation bootom face coordinates
          if(faceValue == BOTTOM){
          	 point.set(x,0,z);
             face.setCoordinate(0 , point);
             point.set(x,0,-z);
             face.setCoordinate(1 , point);
             point.set(-x,0,-z);
             face.setCoordinate(2 , point);
             point.set(-x,0,z);
             face.setCoordinate(3 , point);
          }      
          // Generation top face coordinates
          else if(faceValue == TOP){
          	 point.set(x,y,z);
             face.setCoordinate(0 , point);
             point.set(x,y,-z);
             face.setCoordinate(1 , point);
             point.set(-x,y,-z);
             face.setCoordinate(2 , point);
             point.set(-x,y,z);
             face.setCoordinate(3 , point);
          }     
           // Generation right face coordinates
          else if(faceValue == RIGHT){
          	 point.set(x,0,z);
             face.setCoordinate(0 , point);
             point.set(x,y,z);
             face.setCoordinate(1 , point);
             point.set(x,y,-z);
             face.setCoordinate(2 , point);
             point.set(x,0,-z);
             face.setCoordinate(3 , point);
          }       
           // Generation front face coordinates
          else if(faceValue == FRONT){
          	 point.set(x,0,-z);
             face.setCoordinate(0 , point);
             point.set(x,y,-z);
             face.setCoordinate(1 , point);
             point.set(-x,y,-z);
             face.setCoordinate(2 , point);
             point.set(-x,0,-z);
             face.setCoordinate(3 , point);
          }
           // Generation left face coordinates
          else if(faceValue == LEFT){
          	 point.set(-x,0,z);
             face.setCoordinate(0 , point);
             point.set(-x,0,-z);
             face.setCoordinate(1 , point);
             point.set(-x,y,-z);
             face.setCoordinate(2 , point);
             point.set(-x,y,z);
             face.setCoordinate(3 , point);
          } 
           // Generation back face coordinates
          else if(faceValue == BACK){
          	 point.set(x,0,z);
             face.setCoordinate(0 , point);
             point.set(x,y,z);
             face.setCoordinate(1 , point);
             point.set(-x,y,z);
             face.setCoordinate(2 , point);
             point.set(-x,0,z);
             face.setCoordinate(3 , point);
          } 
          // Generation du toit de droite 
          else if(faceValue == TOIT_DROIT) {
             point.set(x,y,z);
             face.setCoordinate(0 , point);
             point.set(x,y,-z);
             face.setCoordinate(1 , point);
             point.set(0,y+(y/2),-z);
             face.setCoordinate(2 , point);
             point.set(0,y+(y/2),z);
             face.setCoordinate(3 , point);
          }


           // Generation du toit de gauche
          else if(faceValue == TOIT_GAUCHE) {
             point.set(-x,y,z);
             face.setCoordinate(0 , point);
             point.set(0,y+(y/2),z);
             face.setCoordinate(1 , point);
             point.set(0,y+(y/2),-z);
             face.setCoordinate(2 , point);
             point.set(-x,y,-z);
             face.setCoordinate(3 , point);
          }

           else if(faceValue == BACK_TRI) {
             point.set(-x,y,z);
             face.setCoordinate(0 , point);
             point.set(x,y,z);
             face.setCoordinate(1 , point);
             point.set(0,y+(y/2),z);
             face.setCoordinate(2 , point);
             point.set(0,y+(y/2),z);
             face.setCoordinate(3 , point);
          }
           else if(faceValue == FRONT_TRI) {
             point.set(-x,y,-z);
             face.setCoordinate(0 , point);
             point.set(x,y,-z);
             face.setCoordinate(1 , point);
             point.set(0,y+(y/2),-z);
             face.setCoordinate(2 , point);
             point.set(0,y+(y/2),-z);
             face.setCoordinate(3 , point);
          }

           else if(faceValue == FACE_DOOR) {
            float a = y - (y/4);
            float b = 2*x - (3*x/2);
            float c = x;

            // un
             point.set(-x,0,z);
             face.setCoordinate(0 , point);
             point.set(-b,0,z);
             face.setCoordinate(1 , point);
             point.set(-b,a,z);
             face.setCoordinate(2 , point);
             point.set(-x,a,z);
             face.setCoordinate(3 , point);
             //deux
             point.set(0,0,z);
             face.setCoordinate(4 , point);
             point.set(x,0,z);
             face.setCoordinate(5 , point);
             point.set(x,a,z);
             face.setCoordinate(6 , point);
             point.set(0,a,z);
             face.setCoordinate(7 , point);
             //trois
             point.set(-x,a,z);
             face.setCoordinate(8 , point);
             point.set(x,a,z);
             face.setCoordinate(9 , point);
             point.set(x,y,z);
             face.setCoordinate(10 , point);
             point.set(-x,y,z);
             face.setCoordinate(11 , point);
          }
            // Forme cubique
           else if(faceValue == CHKOMBE) {  
            // back
             y = 0.2f;
             point.set(x,0,z);
             face.setCoordinate(0 , point);
             point.set(x,y,z);
             face.setCoordinate(1 , point);
             point.set(-x,y,z);
             face.setCoordinate(2 , point);
             point.set(-x,0,z);
             face.setCoordinate(3 , point);
             //right
             point.set(x,0,z);
             face.setCoordinate(4 , point);
             point.set(x,y,z);
             face.setCoordinate(5 , point);
             point.set(x,y,-z);
             face.setCoordinate(6 , point);
             point.set(x,0,-z);
             face.setCoordinate(7 , point);
             //front
             point.set(x,0,-z);
             face.setCoordinate(8 , point);
             point.set(x,y,-z);
             face.setCoordinate(9, point);
             point.set(-x,y,-z);
             face.setCoordinate(10 , point);
             point.set(-x,0,-z);
             face.setCoordinate(11 , point);
             // left
             point.set(-x,0,z);
             face.setCoordinate(12 , point);
             point.set(-x,0,-z);
             face.setCoordinate(13 , point);
             point.set(-x,y,-z);
             face.setCoordinate(14, point);
             point.set(-x,y,z);
             face.setCoordinate(15 , point);
             // Top
             point.set(x,y,z);
             face.setCoordinate(16 , point);
             point.set(x,y,-z);
             face.setCoordinate(17 , point);
             point.set(-x,y,-z);
             face.setCoordinate(18, point);
             point.set(-x,y,z);
             face.setCoordinate(19 , point);
             //Bottom
             point.set(x,0,z);
             face.setCoordinate(20 , point);
             point.set(x,0,-z);
             face.setCoordinate(21 , point);
             point.set(-x,0,-z);
             face.setCoordinate(22 , point);
             point.set(-x,0,z);
             face.setCoordinate(23 , point);

          }

           // Default Generation coordinates Face -> Front Face
          else {
          	 point.set(-x,0,z);
             face.setCoordinate(0 , point);
             point.set(x,0,z);
             face.setCoordinate(1 , point);
             point.set(x,y,z);
             face.setCoordinate(2 , point);
             point.set(-x,y,z);
             face.setCoordinate(3 , point);
          } 

          return null;           
   }       

    /**
         Cette éthode permet de spécifier les coordonnées de textures
         de la face qui sera fournie en argument suivant le mode ST
    */ 
   
   public void setTextureFaceCoord(QuadArray quad , int vertexCount){
            TexCoord2f texCoord = new TexCoord2f();
            int numberOfFace = vertexCount/4; 
            int vertexPoint = 0;
          for(int i = 0 ; i< numberOfFace ; i += 4){
              vertexPoint = i;
              texCoord.set(-1.0f ,1.5f);
              quad.setTextureCoordinate(0 , vertexPoint , texCoord);
              
              texCoord.set(-1f ,-1f);
              quad.setTextureCoordinate(0 , vertexPoint+1 , texCoord);
               
              texCoord.set(1.5f ,-1);
              quad.setTextureCoordinate(0 , vertexPoint+2 , texCoord);
               
              texCoord.set(1.5f ,1.5f);
              quad.setTextureCoordinate(0 , vertexPoint+3 , texCoord);
          }

   }

    
	    
}