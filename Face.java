 
 import com.sun.j3d.utils.geometry.*;
import javax.media.j3d.*;
import javax.vecmath.*;

/**
*@author Alhoussene
*date 07/04/18
*@version 1.2
**/

public  class Face { 
   public static final int BOTTOM = 0;
   public static final int TOP    = 1;   
   public static final int RIGHT  = 2;
   public static final int FRONT  = 3;
   public static final int LEFT   = 4;
   public static final int BACK   = 5;
   public static final int BACK_ROOF  = 6;
   public static final int FRONT_ROOF = 7;
	protected QuadArray face;
	protected TransformGroup quadGroup;
	protected Shape3D shape;
	protected Appearance app;
    public Face(String fileImage , int faceValue ,float x , float y, float z){
             app = new Apparence(fileImage , null);
             face= new QuadArray(4 , QuadArray.COORDINATES|QuadArray.TEXTURE_COORDINATE_2);
             shape = new Shape3D(face , app);
             setQuadCoordinates(faceValue,x,y,z);
             setQuadTextureCoords();
             quadGroup = new TransformGroup();
             quadGroup.addChild(shape); 
    }

    private void  setQuadCoordinates( int faceValue, float x , float y , float z){   
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
          else if(faceValue == BACK_ROOF) {
             point.set(-x,y,z);
             face.setCoordinate(0 , point);
             point.set(x,y,z);
             face.setCoordinate(1 , point);
             point.set(x,y+(y/2),0);
             face.setCoordinate(2 , point);
             point.set(-x,y+(y/2),0);
             face.setCoordinate(3 , point);
          }
           // Generation du toit de gauche
          else if(faceValue == FRONT_ROOF) {
             point.set(-x,y,-z);
             face.setCoordinate(0 , point);
             point.set(x,y,-z);
             face.setCoordinate(1 , point);
             point.set(x,y+(y/2),0);
             face.setCoordinate(2 , point);
             point.set(-x,y+(y/2),0);
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
                    
   } 
    private void setQuadTextureCoords(){
    	      // Face 1
    	      TexCoord2f texCoord = new TexCoord2f();              
              texCoord.set(0f ,0f); 
              face.setTextureCoordinate(0,0 , texCoord);              
              texCoord.set(1f ,0f); 
              face.setTextureCoordinate(0,1 , texCoord);               
              texCoord.set(1f ,1);
              face.setTextureCoordinate(0,2 , texCoord);               
              texCoord.set(0f ,1f);
              face.setTextureCoordinate(0,3 , texCoord); 
          
    }
}