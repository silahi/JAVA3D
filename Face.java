
import com.sun.j3d.utils.geometry.*;
import javax.media.j3d.*; 
public class Face extends House{
	  protected TransformGroup faceGroup;
	  protected QuadArray face;
	  protected Shape3D shape;
	  protected Apparence app;
	  public Face(){
	  	    faceGroup = new TransformGroup();
            face      = new QuadArray(House.VERTEX_COUNT,GeometryArray.COORDINATES| GeometryArray.TEXTURE_COORDINATE_2);
            shape     = new Shape3D();
            shape.setGeometry(face); 
            faceGroup.addChild(shape);
	  }
	  public Face(String fileImage , Canvas3D canvas){
            faceGroup = new TransformGroup();
            face      = new QuadArray(House.VERTEX_COUNT,GeometryArray.COORDINATES| GeometryArray.TEXTURE_COORDINATE_2);
            shape     = new Shape3D();
            shape.setGeometry(face); 
            faceGroup.addChild(shape);
            app = new Apparence(fileImage , canvas);
            shape.setAppearance(app);
	  }

	   public Face(String fileImage , Canvas3D canvas , float s , float t){
	   	    this(fileImage , canvas); 
	   	    setTexureCoord(face , s , t);
	  }

	   public Face(String fileImage , Canvas3D canvas , float s , float t ,
	               int faceValue , float x , float y , float z){
	   	          this(fileImage , canvas , s,t);
                  setFaceCoordinate(face , faceValue , x,y,z);              
	  }

	  public Face(String fileImage , Canvas3D canvas , int faceValue , float x , float y , float z ){
           this(fileImage , canvas);
           setFaceCoordinate(face , faceValue , x,y,z);
	  }

	  public Face(int faceValue , float x , float y , float z){
	  	     this();
	  	     setFaceCoordinate(face , faceValue , x,y,z); 
	  }

	  public void setFaceAppearance(String fileImage , Canvas3D canvas){
         this();
         app = new Apparence(fileImage , canvas);
         shape.setAppearance(app);
	  }
}