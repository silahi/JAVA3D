
import com.sun.j3d.utils.geometry.*;
import javax.media.j3d.*;
import javax.vecmath.*;

public class House {
   public static final float VERTEX_COUNT = 4;
   public static final int BOTTOM = 0;
   public static final int TOP    = 1;   
   public static final int RIGHT  = 2;
   public static final int FRONT  = 3;
   public static final int LEFT   = 4;
   public static final int BACK   = 5;

   // Creation of faces
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
          	 point.set(-x,0,z);
             face.setCoordinate(0 , point);
             point.set(x,0,z);
             face.setCoordinate(1 , point);
             point.set(x,y,z);
             face.setCoordinate(2 , point);
             point.set(-x,y,z);
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
          	 point.set(-x,0,z);
             face.setCoordinate(0 , point);
             point.set(x,0,z);
             face.setCoordinate(1 , point);
             point.set(x,y,z);
             face.setCoordinate(2 , point);
             point.set(x,y,z);
             face.setCoordinate(3 , point);
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
   } // End of creating faces

    // Mose  s and t 
   public void setTextureFaceCoord(QuadArray face , float s , float t){
          TexCoord2f texCoord = new TexCoord2f();
          texCoord.set(0 ,t);
          face.setTextureCoordinate(0 , 0 , texCoord);

          TexCoord2f texCoord = new TexCoord2f();
          texCoord.set(0 ,0);
          face.setTextureCoordinate(0 , 1 , texCoord);

          TexCoord2f texCoord = new TexCoord2f();
          texCoord.set(s ,0);
          face.setTextureCoordinate(0 , 2 , texCoord);

          TexCoord2f texCoord = new TexCoord2f();
          texCoord.set(s ,t);
          face.setTextureCoordinate(0 , 3 , texCoord);
   }
	    
}