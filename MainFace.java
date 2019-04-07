
import com.sun.j3d.utils.geometry.*;
import javax.media.j3d.*;
import javax.vecmath.*;

/**
*@author Alhoussene
*date 07/04/18
**/
public class MainFace {
    protected QuadArray face;
	protected TransformGroup quadGroup;
	protected Shape3D shape;
	protected Appearance app;
	 public MainFace(String fileImage ,float x , float y, float z){
             app = new Apparence(fileImage , null);
             face= new QuadArray(20, QuadArray.COORDINATES|QuadArray.TEXTURE_COORDINATE_2);
             shape = new Shape3D(face , app);
             setQuadCoordinates(x,y,z);
             setQuadTextureCoords();
             quadGroup = new TransformGroup();
             quadGroup.addChild(shape);
    }

     private void   setQuadCoordinates(float x, float y, float z){
    	    float a =  (2*y)/3;
            float b = x/3;
            float d = y/3;
            Point3f point = new Point3f();
            // M1             
             point.set(-x,0,z);
             face.setCoordinate(0 , point);
             point.set(-x+b,0,z);
             face.setCoordinate(1 , point);
             point.set(-x+b,a,z);
             face.setCoordinate(2 , point);
             point.set(-x,a,z);
             face.setCoordinate(3 , point);
            // M2
             point.set(-x+2*b,0,z);
             face.setCoordinate(4 , point);
             point.set(x,0,z);
             face.setCoordinate(5 , point);
             point.set(x,d,z);
             face.setCoordinate(6 , point);
             point.set(-x+2*b,d,z);
             face.setCoordinate(7 , point);
             //M3 
             point.set(x-b,d,z);
             face.setCoordinate(8 , point);
             point.set(x,d,z);
             face.setCoordinate(9, point);
             point.set(x,a,z);
             face.setCoordinate(10 , point);
             point.set(x-b, a, z);
             face.setCoordinate(11 , point);
             // M4
             point.set(-x+2*b,d,z);
             face.setCoordinate(12 , point);
             point.set(x-2*b,d,z);
             face.setCoordinate(13 , point);
             point.set(x-2*b,a,z);
             face.setCoordinate(14, point);
             point.set(-x+2*b,a,z);
             face.setCoordinate(15 , point);
             // M5
             point.set(-x,a,z);
             face.setCoordinate(16 , point);
             point.set(x,a,z);
             face.setCoordinate(17 , point);
             point.set(x,y,z);
             face.setCoordinate(18, point);
             point.set(-x,y,z);
             face.setCoordinate(19 , point); 
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

               // Face 2               
              texCoord.set(0f ,0f); 
              face.setTextureCoordinate(0,4 , texCoord);              
              texCoord.set(1f ,0f); 
              face.setTextureCoordinate(0,5 , texCoord);               
              texCoord.set(1f ,1);
              face.setTextureCoordinate(0,6 , texCoord);               
              texCoord.set(0f ,1f);
              face.setTextureCoordinate(0,7 , texCoord);

               // Face 1               
              texCoord.set(0f ,0f); 
              face.setTextureCoordinate(0,8 , texCoord);              
              texCoord.set(1f ,0f); 
              face.setTextureCoordinate(0,9 , texCoord);               
              texCoord.set(1f ,1);
              face.setTextureCoordinate(0,10 , texCoord);               
              texCoord.set(0f ,1f);
              face.setTextureCoordinate(0,11 , texCoord);

               // Face 1              
              texCoord.set(0f ,0f); 
              face.setTextureCoordinate(0,12 , texCoord);              
              texCoord.set(1f ,0f); 
              face.setTextureCoordinate(0,13 , texCoord);               
              texCoord.set(1f ,1);
              face.setTextureCoordinate(0,14 , texCoord);               
              texCoord.set(0f ,1f);
              face.setTextureCoordinate(0,15, texCoord);

               // Face 1               
              texCoord.set(0f ,0f); 
              face.setTextureCoordinate(0,16, texCoord);              
              texCoord.set(1f ,0f); 
              face.setTextureCoordinate(0,17 , texCoord);               
              texCoord.set(1f ,1);
              face.setTextureCoordinate(0,18 , texCoord);               
              texCoord.set(0f ,1f);
              face.setTextureCoordinate(0,19 , texCoord); 
    }
}