
import javax.media.j3d.TransformGroup;  

public class Town extends TransformGroup {
	 protected TransformGroup townGroup ;	 
	 public Town(){
	 	  setCapability(ALLOW_TRANSFORM_WRITE);
          setCapability(ALLOW_TRANSFORM_READ);
          townGroup = new TransformGroup();
          townGroup.setCapability(ALLOW_TRANSFORM_WRITE);
          townGroup.setCapability(ALLOW_TRANSFORM_READ);
           
          addChild(townGroup);
          CustomKeyNavigatorBehavior keyNav = new CustomKeyNavigatorBehavior(this);
          keyNav.setSpeedFactor(0.1f);
          keyNav.setSchedulingBounds(Application.region);
          addChild(keyNav);
	 }
}