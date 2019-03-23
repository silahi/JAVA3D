

import javax.media.j3d.*;
import javax.vecmath.*;

public class AutoRotate extends TransformGroup {
	protected Alpha alpha = null;
	protected Transform3D axe = null;
	protected RotationInterpolator rotator = null;
     public AutoRotate(){
          
          setCapability(ALLOW_TRANSFORM_WRITE);
          setCapability(ALLOW_TRANSFORM_READ);
          
          axe = new Transform3D();
          alpha = new Alpha(-1 , 55000);
          rotator = new RotationInterpolator(alpha , this);
          rotator.setSchedulingBounds(Application.region);
          addChild(rotator);

     }
}