import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class GALAXY extends PApplet {

final int W = 900;
final int H = 900;

int size = 10000;

BLACKHOLE b;
STAR[] s = new STAR[size];

float bhX = W/2;
float bhY = H/2;
PVector bh = new PVector(bhX,bhY);

public void settings(){
  size(W,H,P2D);  
}

public void setup(){
  
      for(int i = 0; i < size; i++){
       s[i] = new STAR(2,i);
      }  
    
  b = new BLACKHOLE(bhX,bhY,3);
}

public void draw(){
background(0);  

    for(int i = 0; i < size; i++){
     s[i].computeSTAR();
     s[i].showSTAR();
    }
    
b.showBH();
}
class BLACKHOLE{
  
float r;
float X;
float Y;

  BLACKHOLE(float x, float y,int r){
   this.X = x;
   this.Y = y;
   this.r = r;
  }
  
  public void showBH(){
   push();
   translate(X,Y);
   strokeWeight(r);
   stroke(51);
   point(0,0);
   pop();
  }
}
class STAR{

PVector velocity = new PVector();
PVector position = new PVector();

int size;
float mass;
float rad;

  STAR(int size,int i){
   this.mass = random(0.1f,1); 
   this.size = size;
     position.x = W/2+cos(i)*random(50,W/2);
     position.y = H/2+sin(i)*random(50,H/2);
  }
  
  public void computeSTAR(){
    PVector force = PVector.sub(bh,position);
    force.normalize();
    rad = force.mag();
    force.rotate(rad);
    float gravity = (6.67f*mass) / (rad*rad);
    force.mult(gravity*0.035f);
      velocity.add(force);  
      velocity.normalize();
      position.add(velocity);
  }
  
  public void showSTAR(){
   push();
   translate(position.x,position.y);
     float distance = PVector.dist(bh,position);
     float col = map(distance,0,450,255,0);
     float alpha = map(distance,0,450,100,20);
   stroke(255,col,255-col,alpha*(mass*2));
   strokeWeight(size);
   point(0,0);
   pop();
  }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "GALAXY" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
