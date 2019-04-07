
import com.sun.j3d.utils.geometry.*;
import javax.media.j3d.*; 
public class Face extends House{
	  protected TransformGroup faceGroup;
	  protected QuadArray face;
	  protected Shape3D shape;
	  protected Appearance app;
	  private float x,y,z;
	  public Face(){
	  	    faceGroup = new TransformGroup();
            face      = new QuadArray(House.VERTEX_COUNT,GeometryArray.COORDINATES| GeometryArray.TEXTURE_COORDINATE_2);
            shape     = new Shape3D();
             shape.removeGeometry(0);
            shape.setGeometry(face); 
            faceGroup.addChild(shape);
	  }

	    public Face(int faceValue , float x , float y , float z){
	  	     this();
	  	     this.x = x;
	  	     this.y = y;
	  	     this.z = z;
	  	     setFaceCoordinate(face , faceValue , x,y,z); 
	  	     setTextureFaceCoord(face , 4);
	  } 
	  public Face(String fileImage , Canvas3D canvas){
            faceGroup = new TransformGroup();
            face      = new QuadArray(4,GeometryArray.COORDINATES| GeometryArray.TEXTURE_COORDINATE_2);
            shape     = new Shape3D();
            shape.setGeometry(face); 
            faceGroup.addChild(shape);
            app = new Apparence(fileImage , canvas);
            shape.setAppearance(app);
	  } 
 

	  public Face(String fileImage , Canvas3D canvas , int faceValue , float x , float y , float z ){
           this(fileImage , canvas);
             this.x = x;
	  	     this.y = y;
	  	     this.z = z;
           setFaceCoordinate(face , faceValue , x,y,z);
           setTextureFaceCoord(face , 4);
	  }	
        // Door face and Cubic face
	  public Face(String fileImage , int faceValue, float x , float y , float z){
	  	     this.x = x;
	  	     this.y = y;
	  	     this.z = z;	  	     
	  	     if(faceValue == FACE_DOOR){
	  	     	   face      = new QuadArray(12,GeometryArray.COORDINATES| GeometryArray.TEXTURE_COORDINATE_2);	  	     	     	     	   
                   setFaceCoordinate(face ,FACE_DOOR, x,y,z); 
                   setTextureFaceCoord(face , 12);
	  	     }

	  	      if(faceValue == CHKOMBE){
	  	     	   face      = new QuadArray(24,GeometryArray.COORDINATES| GeometryArray.TEXTURE_COORDINATE_2);	  	     	     	     	   
                   setFaceCoordinate(face ,CHKOMBE, x,y,z); 
                   setTextureFaceCoord(face , 24);
	  	     }
             

             app       = new Apparence(fileImage , null);	
             shape     = new Shape3D(face , app);
             faceGroup = new TransformGroup();
             faceGroup.addChild(shape); 
	  }

	  public float getX(){ return x;}
	  public float getY(){ return y;}
	  public float getZ(){ return z;}
	 
}