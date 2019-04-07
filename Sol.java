
import javax.media.j3d.*;
import javax.vecmath.*;
import com.sun.j3d.utils.geometry.*;

public class Sol extends TransformGroup {
	private AutoRotate rotation = null;
    private Apparence app =  null ; 
    private Shape3D solTransform = null; 
    protected Point3f[] point;
    protected TexCoord2f[] tex;
    protected Color3f color;
	public Sol(Point3f[] point , TexCoord2f[] tex , Color3f color ,String image ,Canvas3D canvas){
		  this.point = point;
		  this.tex   = tex;
		  this.color = color;
		  setCapability(ALLOW_TRANSFORM_WRITE);
          setCapability(ALLOW_TRANSFORM_READ);
          app = new Apparence("../ressources/"+image , canvas);
          rotation = new AutoRotate();         
          solTransform = solShape();
          rotation.alpha.setLoopCount(0);
          rotation.addChild(solTransform);
          addChild(rotation);
	}

	private Shape3D solShape(){
		Shape3D shape = new Shape3D(); 
		QuadArray plane = new QuadArray(4 , QuadArray.COORDINATES|QuadArray.TEXTURE_COORDINATE_2| QuadArray.COLOR_3);         
        plane.setCoordinates(0 ,point);
        plane.setTextureCoordinates(0 ,0 , tex);
        plane.setColors( 0, new Color3f[]{color});       
        shape.setGeometry(plane);
		shape.setAppearance(app);
		return shape;
	}
}