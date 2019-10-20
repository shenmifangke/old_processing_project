class layer2 extends Layer {
FloatTable locationTable;
FloatTable cityLocation;
HashMap hash = new HashMap();
int rowCount;
int columnCount;
String rowName;
FloatTable dataTable;
float dataMin = -10;
float dataMax = 10;
PFont font;
  layer2(PApplet parent) {
    super(parent);
    
  }

  void setup()
 {frameRate(10);
 font = createFont("ArialUnicodeMS-48",30);
 textFont(font);
    cityLocation = new FloatTable("cityLocation.tsv");
  rowCount = cityLocation.getRowCount();
  columnCount = cityLocation.getColumnCount();
   
  noStroke();  
  for (int row = 0; row < rowCount; row++)
  {
    MyPoint point1 = new MyPoint(cityLocation.getFloat(row, 1),cityLocation.getFloat(row, 2));
    hash.put(cityLocation.getFloat(row, 1),point1);
  }
  }

  void draw()
 {
   background(0, 0);
   fill(0);
  stroke(1,20);
  closestDist = width*height;  // abritrarily high
  
  for (int row = 0; row < rowCount; row++)
  {
    //String abbrev = dataTable.getRowName(row);
    float x = cityLocation.getFloat(row, 1);
    float y = cityLocation.getFloat(row, 2);
    MyPoint tempPoint = convert(x,y);

        
    drawData(tempPoint.x, tempPoint.y);
    //if(row == rowCount - 1)noLoop();
//line(mouseX,mouseY,tempPoint.x * scalePoint+300,tempPoint.y*scalePoint);
   if(dist(tempPoint.x * scalePoint+pointx,tempPoint.y*scalePoint+pointy,mouseX,mouseY) < 5)
  {
   fill(0);
    textAlign(CENTER);
    
    text(cityLocation.getRowName(row)+cityLocation.getString(row, 0),tempPoint.x * scalePoint+350,tempPoint.y*scalePoint -20);
  }
  }
  }
int radius = 1;
void drawData(float x, float y)
{
  ellipseMode(RADIUS);
  ellipse(x * scalePoint+pointx, y * scalePoint+pointy,  radius, radius);
}

MyPoint convert(float lat,float lon)
{
float phi0 = 0;
float lambda0 = radians(Alambda0);//100
float phi1 = radians(Aphi1);//3.52f
float phi2 = radians(Aphi2);

float phi = radians(lat);
float lambda = radians(lon);

float n = 0.5f * (sin(phi1) + sin(phi2));
float theta = n*(lambda - lambda0);
float c = sq(cos(phi1))+2*n*sin(phi1);
float rho = sqrt(c - 2*n*sin(phi))/n;
float rho0 = sqrt(c - 2*n*sin(phi0))/n;

float x = rho * sin(theta);
float y = rho0 - rho*cos(theta);
y = 1 - y;
MyPoint tempPoint = new MyPoint(x,y);
return tempPoint;
}
}

