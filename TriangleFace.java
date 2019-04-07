
import com.sun.j3d.utils.geometry.*;
import javax.media.j3d.*;
import javax.vecmath.*;

/**
*@author Alhoussene
*date 07/04/18
**/

public class TriangleFace{
    protected TriangleArray face;
	protected TransformGroup quadGroup;
	protected Shape3D shape;
	protected Appearance app;
	protected static final int LEFT_TRI  = 1;
	protected static final int RIGHT_TRI = 2;

	public TriangleFace(String fileImage , int faceValue , float x,float y, float z){
             app = new Apparence(fileImage , null);
             face= new TriangleArray(3, TriangleArray.COORDINATES|TriangleArray.TEXTURE_COORDINATE_2);
             shape = new Shape3D(face , app);
             setQuadCoordinates(faceValue ,x,y,z); 
             quadGroup = new TransformGroup();
             quadGroup.addChild(shape);
	}

	private void setQuadCoordinates( int faceValue ,float x , float y , float z){
           Point3f point = new Point3f();
          if(faceValue == LEFT_TRI){ 
             point.set(-x,y,-z);
             face.setCoordinate(0 , point);
             point.set(-x,y,z);
             face.setCoordinate(1 , point);
             point.set(-x,y+(y/2),0);
             face.setCoordinate(2 , point);
             }
             else if(faceValue == RIGHT_TRI){ 
             point.set(x,y,-z);
             face.setCoordinate(0 , point);
             point.set(x,y,z);
             face.setCoordinate(1 , point);
             point.set(x,y+(y/2),0);
             face.setCoordinate(2 , point);
             }

             else{
                    point.set(-x,y,-z);
             face.setCoordinate(0 , point);
             point.set(-x,y,z);
             face.setCoordinate(1 , point);
             point.set(-x,y+(y/2),0);
             face.setCoordinate(2 , point);
             }

             TexCoord2f texCoord = new TexCoord2f(); 
             texCoord.set(0f ,0f);
             face.setTextureCoordinate( 0,0 , texCoord);
             texCoord.set(0f ,1f);
             face.setTextureCoordinate( 0,1 , texCoord);
             texCoord.set(0.5f ,1f);
             face.setTextureCoordinate( 0,2 , texCoord);
	}
} 