class BLACKHOLE{
  
float r;
float X;
float Y;

  BLACKHOLE(float x, float y,int r){
   this.X = x;
   this.Y = y;
   this.r = r;
  }
  
  void showBH(){
   push();
   translate(X,Y);
   strokeWeight(r);
   stroke(51);
   point(0,0);
   pop();
  }
}
