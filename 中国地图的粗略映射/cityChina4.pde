import com.nootropic.processing.layers.*;
AppletLayers layers;
PImage mapImage;
//地图展开方式http://mathworld.wolfram.com/AlbersEqual-AreaConicProjection.html


Integrator[] interpolators;


float scaleImage = 1;
void setup() {
  size(725, 600);
  mapImage = loadImage("chinaMap.jpg");
 
  
  layers = new AppletLayers(this);
  layer2 m = new layer2(this);
  layers.addLayer(m);
  
  


//  for (int row = 0; row < rowCount; row++) {
//    float initialValue = dataTable.getFloat(row, 2);
//    //interpolators[row] = new Integrator(initialValue, 0.9, 0.1);
//  }
  


}
void paint(java.awt.Graphics g) {
  // This method MUST be present in your sketch for layers to be rendered!
  if (layers != null) {
    layers.paint(this);
  } else {
    super.paint(g);
  }
}
float closestDist;
String closestText;
float closestTextX;
float closestTextY;

float tempX;
float tempY;

float rotation;
void draw() {
  background(255);
  
      background(0);

  //rotate( mousePressed?rotation+=0.001 :rotation );
  scale(scaleImage);
image(mapImage, tempX, tempY);
//  for (int row = 0; row < rowCount; row++) {
//    interpolators[row].update();
//  }


//  if (closestDist != width*height) {
//    fill(0);
//    textAlign(CENTER);
//    //text(closestText, closestTextX, closestTextY);
//  }
}

float Alambda0 = 103.35f;
float Aphi1 = 26.6f;//3.52f;
float Aphi2 = 41.83f;//53.33f;
float scalePoint = 697;//700
float pointx = 357;//300;
float pointy = 13;//0;
void keyPressed() 
{
  if (key == CODED)
  {
    if(keyCode == LEFT)pointx --;
    else if(keyCode == RIGHT)pointx ++;
    else if(keyCode == UP)pointy --;
    else if(keyCode == DOWN)pointy ++;
  }else
  {
    if(key == 'z')scalePoint += 0.5;
    if(key == 'x')scalePoint -= 0.5;
    if(key == 'c')Aphi1 += 0.1;
    if(key == 'v')Aphi1 -= 0.1;
    if(key == 'b')Aphi2 += 0.1;
    if(key == 'n')Aphi2 -= 0.1;
    if(key == 'a')Alambda0 += 0.5;
    if(key == 's')Alambda0 -= 0.5;
  }
 println("Alambda0:"+Alambda0+" Aphi1:"+Aphi1+" Aphi2"+Aphi2+" scalePoint:"+scalePoint+" pointx:"+pointx+ "pointy:"+pointy);

}

//void updateTable() {  
//  for (int row = 0; row < rowCount; row++) {
//    float newValue = random(dataMin, dataMax);
//    interpolators[row].target(newValue);
//  }
//}
