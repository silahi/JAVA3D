
import com.sun.j3d.utils.image.*;
import java.awt.image.BufferedImage;
import java.io.*; 
import javax.imageio.ImageIO; 
import javax.media.j3d.*;
import javax.vecmath.*;

/**
 *
 * @author alhoussene
 */
public class Apparence extends Appearance { 
  protected TextureAttributes texAtt;
    public Apparence (String imageFile , Canvas3D canvas){ 

      
        texAtt = new TextureAttributes(
                          TextureAttributes.MODULATE,
                      new Transform3D(),
                      new Color4f(1f,1f,1f,1f),
                          TextureAttributes.NICEST);                                          
                                      
             setTextureAttributes(texAtt);
          
              PolygonAttributes facettes = new PolygonAttributes(PolygonAttributes.POLYGON_FILL,0,0);                                 
              setPolygonAttributes(facettes);
            // setTransparencyAttributes(new TransparencyAttributes(TransparencyAttributes.BLENDED, 0f));                                   
                                    
         try{                                         
              TextureLoader loader = new TextureLoader("../ressources/"+imageFile , canvas);
              ImageComponent2D image = loader.getImage();
              Texture2D texture = new Texture2D(Texture2D.BASE_LEVEL, Texture2D.RGBA, image.getWidth() , image.getHeight());
              texture.setImage(0 , image);              
              setTexture(texture);
              texture.setBoundaryModeS(Texture2D.WRAP);
              texture.setBoundaryModeT(Texture2D.WRAP);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    } 
     
}
