
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
public class MipMap extends Appearance {  
	private TextureLoader loader   = null;
	private Texture texture        = null;
	private ImageComponent2D image = null;
    public MipMap (String imageFile , Canvas3D canvas){     

                int largeur, hauteur, niveau;
          final int tailleMin = 1;                               
          
          // Chargement de l'image de texture                           
          try{  loader = new TextureLoader("../ressources/"+imageFile , canvas);
               image = loader.getImage(); 
            }catch(Exception e){System.err.println(e.getMessage()); }

                  largeur = image.getWidth();
                  hauteur = image.getHeight();
                   niveau = 0;

                    // Creation de la texture a niveaux multiples
       Texture texture = new Texture2D(Texture.MULTI_LEVEL_MIPMAP,
                                       Texture.RGBA,
                                       largeur, hauteur);
       texture.setImage(niveau, image);

       // On definit les multiples niveaux de texture
       while ((largeur > tailleMin) || (hauteur > tailleMin)) {
         niveau++;

         if (largeur > tailleMin) largeur = largeur / 2;
         if (hauteur > tailleMin) hauteur = hauteur / 2;

         image = loader.getScaledImage(largeur, hauteur);
         texture.setImage(niveau, image);
       } // fin while (largeur > tailleMin || hauteur > tailleMin)

       texture.setMinFilter(Texture.MULTI_LEVEL_POINT);
       texture.setMagFilter(Texture.BASE_LEVEL_LINEAR);
       setTexture(texture); 
       // mode
       autreModes();      
    } 

    public void autreModes(){
    	PolygonAttributes polygonMode = new PolygonAttributes(PolygonAttributes.POLYGON_FILL, 0,0);
    	setPolygonAttributes(polygonMode);
    }
     
}
