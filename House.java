 
 import javax.media.j3d.TransformGroup;
 public class House {
     protected TransformGroup houseGroup;
     private float x,y,z;
     public House(float x, float y , float z){
        this.x = x;
        this.y = y;
        this.z = z;
        houseGroup = new TransformGroup();
        setBackFace();
        setLeftFace();
        setFrontFace();
        setRightFace();
        setUnderFace();
        setLeftTri();
        setRightTri();
        setBackRoof();
        setFrontRoof();
     }     
     // back 1
     private void setBackFace(){
        MainFace face = new MainFace("w11.jpg" ,x,y,z);
        houseGroup.addChild(face.quadGroup);
     }
      // left 2
     private void setLeftFace(){
       Face face = new Face("w11.jpg" , Face.LEFT,x,y,y);
       houseGroup.addChild(face.quadGroup);
     }

      // front 3
     private void setFrontFace(){
       Face face = new Face("w11.jpg" , Face.FRONT,x,y,y);
       houseGroup.addChild(face.quadGroup);
     }
      // right 4
     private void setRightFace(){
       Face face = new Face("w11.jpg" , Face.RIGHT,x,y,y);
       houseGroup.addChild(face.quadGroup);
     }
      // bottom 5
     private void setUnderFace(){
       CubicFace face = new CubicFace("w11.jpg",x,(float)y/24,z);
       houseGroup.addChild(face.quadGroup);
     }

     // triangle de gauche 6
     private void setLeftTri(){
          TriangleFace face = new TriangleFace("w11.jpg" , TriangleFace.LEFT_TRI , x,y,z);
           houseGroup.addChild(face.quadGroup);
     }
      // triangle de droite 7
     private void setRightTri(){
          TriangleFace face = new TriangleFace("w11.jpg" , TriangleFace.RIGHT_TRI , x,y,z);
           houseGroup.addChild(face.quadGroup);
     }

     // Toit de derriere 8
     private void setBackRoof(){
       Face face = new Face("w11.jpg" , Face.BACK_ROOF,x,y,y);
       houseGroup.addChild(face.quadGroup);
     }
      // Toit de devant 9
     private void setFrontRoof(){
       Face face = new Face("w11.jpg" , Face.FRONT_ROOF,x,y,y);
       houseGroup.addChild(face.quadGroup);
     }

 }