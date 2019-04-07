
public class MultiFace {

	// format des faces soit porte ou fenêtre
    public static int FACE_DOOR = 0;
    public static int FACE_WINDOW = 1;
    
    protected TransformGroup faceGroup;

    // face type est l'une des constante de la classe House
    public MultiFace(int faceFormat ,int faceType){
    	  faceGroup = new TransformGroup();
        if(faceType == FACE_DOOR){
            
        }
    }
}