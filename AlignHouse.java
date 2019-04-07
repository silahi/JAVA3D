
import javax.media.j3d.*;
import javax.vecmath.*;
public class AlignHouse extends TransformGroup{
	public AlignHouse(Maison m , Vector3f vect){
       Transform3D tr0 = new Transform3D();
       tr0.setTranslation(vect);
       TransformGroup tg0 = new TransformGroup(tr0);
       tg0.addChild(m);
       addChild(tg0);
	}
}