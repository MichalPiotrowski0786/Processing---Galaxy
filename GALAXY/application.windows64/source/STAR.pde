class STAR{

PVector velocity = new PVector();
PVector position = new PVector();

int size;
float mass;
float rad;

  STAR(int size,int i){
   this.mass = random(0.1,1); 
   this.size = size;
     position.x = W/2+cos(i)*random(50,W/2);
     position.y = H/2+sin(i)*random(50,H/2);
  }
  
  void computeSTAR(){
    PVector force = PVector.sub(bh,position);
    force.normalize();
    rad = force.mag();
    force.rotate(rad);
    float gravity = (6.67*mass) / (rad*rad);
    force.mult(gravity*0.035);
      velocity.add(force);  
      velocity.normalize();
      position.add(velocity);
  }
  
  void showSTAR(){
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
