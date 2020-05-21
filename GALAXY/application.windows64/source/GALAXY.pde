final int W = 900;
final int H = 900;

int size = 10000;

BLACKHOLE b;
STAR[] s = new STAR[size];

float bhX = W/2;
float bhY = H/2;
PVector bh = new PVector(bhX,bhY);

void settings(){
  size(W,H,P2D);  
}

void setup(){
  
      for(int i = 0; i < size; i++){
       s[i] = new STAR(2,i);
      }  
    
  b = new BLACKHOLE(bhX,bhY,3);
}

void draw(){
background(0);  

    for(int i = 0; i < size; i++){
     s[i].computeSTAR();
     s[i].showSTAR();
    }
    
b.showBH();
}
