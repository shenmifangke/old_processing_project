import processing.core.*; 
import processing.data.*; 
import processing.opengl.*; 

import java.awt.event.WindowAdapter; 
import java.awt.event.WindowEvent; 
import java.io.BufferedReader; 
import java.io.File; 
import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.io.UnsupportedEncodingException; 
import java.util.HashMap; 
import processing.core.*; 
import treemap.*; 
import java.io.IOException; 
import java.io.StringReader; 
import javax.swing.JFrame; 
import org.apache.lucene.analysis.Analyzer; 
import org.apache.lucene.analysis.TokenStream; 
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute; 
import org.wltea.analyzer.lucene.IKAnalyzer; 

import org.apache.lucene.analysis.cz.*; 
import org.apache.lucene.util.*; 
import org.apache.lucene.analysis.sinks.*; 
import org.wltea.analyzer.core.*; 
import org.apache.lucene.analysis.position.*; 
import org.tartarus.snowball.*; 
import org.apache.lucene.analysis.it.*; 
import org.apache.lucene.analysis.cn.*; 
import org.apache.lucene.analysis.in.*; 
import org.apache.lucene.analysis.standard.*; 
import org.apache.lucene.analysis.ca.*; 
import org.apache.lucene.analysis.id.*; 
import org.apache.lucene.analysis.compound.hyphenation.*; 
import org.apache.lucene.analysis.shingle.*; 
import org.apache.lucene.analysis.hy.*; 
import org.apache.lucene.analysis.br.*; 
import org.apache.lucene.analysis.hu.*; 
import org.apache.lucene.collation.*; 
import org.apache.lucene.analysis.bg.*; 
import org.apache.lucene.analysis.no.*; 
import org.apache.lucene.analysis.hi.*; 
import org.apache.lucene.analysis.tr.*; 
import org.tartarus.snowball.ext.*; 
import org.apache.lucene.analysis.nl.*; 
import org.apache.lucene.analysis.path.*; 
import org.apache.lucene.analysis.miscellaneous.*; 
import org.apache.lucene.queryParser.*; 
import org.apache.lucene.analysis.th.*; 
import org.apache.lucene.analysis.compound.*; 
import org.wltea.analyzer.solr.*; 
import org.apache.lucene.analysis.ar.*; 
import org.apache.lucene.analysis.*; 
import org.apache.lucene.analysis.ngram.*; 
import org.wltea.analyzer.dic.*; 
import org.apache.lucene.analysis.gl.*; 
import org.apache.lucene.analysis.sv.*; 
import org.apache.lucene.analysis.standard.std31.*; 
import org.apache.lucene.analysis.wikipedia.*; 
import org.apache.lucene.analysis.cjk.*; 
import org.apache.lucene.messages.*; 
import org.apache.lucene.document.*; 
import org.apache.lucene.analysis.fr.*; 
import org.apache.lucene.analysis.synonym.*; 
import org.apache.lucene.analysis.lv.*; 
import org.apache.lucene.analysis.ru.*; 
import org.apache.lucene.analysis.util.*; 
import org.apache.lucene.analysis.fi.*; 
import org.apache.lucene.analysis.tokenattributes.*; 
import org.apache.lucene.analysis.snowball.*; 
import org.apache.lucene.analysis.ro.*; 
import org.apache.lucene.analysis.fa.*; 
import org.apache.lucene.analysis.payloads.*; 
import org.apache.lucene.analysis.eu.*; 
import org.apache.lucene.analysis.es.*; 
import org.wltea.analyzer.lucene.*; 
import org.apache.lucene.search.highlight.*; 
import org.apache.lucene.analysis.en.*; 
import org.apache.lucene.util.fst.*; 
import org.apache.lucene.analysis.el.*; 
import org.apache.lucene.search.*; 
import org.apache.lucene.search.spans.*; 
import org.apache.lucene.analysis.reverse.*; 
import org.apache.lucene.analysis.query.*; 
import org.apache.lucene.search.function.*; 
import org.wltea.analyzer.sample.*; 
import org.apache.lucene.*; 
import org.apache.lucene.store.*; 
import org.wltea.analyzer.cfg.*; 
import org.apache.lucene.analysis.pt.*; 
import org.apache.lucene.analysis.de.*; 
import org.apache.lucene.search.payloads.*; 
import org.apache.lucene.analysis.da.*; 
import org.apache.lucene.search.vectorhighlight.*; 
import org.apache.lucene.index.*; 

import java.applet.*; 
import java.awt.Dimension; 
import java.awt.Frame; 
import java.awt.event.MouseEvent; 
import java.awt.event.KeyEvent; 
import java.awt.event.FocusEvent; 
import java.awt.Image; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

public class mytest1 extends PApplet {























//\u52a8\u6001\u751f\u6210\u4e2d\u6587\u6811\u56fe \u53ef\u4ee5\u89c4\u5b9a\u6570\u5ea6 \u8c03\u8282everyTime\u5c31\u53ef\u4ee5 \u53ef\u4ee5\u6682\u505c\u5f00\u59cb \u7528\u9f20\u6807\u4efb\u610f\u70b9\u51fb\u5c31\u53ef\u4ee5

  int everyTime = 300;//\u901f\u5ea6
  WordMap mapData;
  Treemap map;
  FileInputStream fis;
  InputStreamReader isr;
  BufferedReader br;
  String str;
  char s;

  public void setup()
  {
    frameRate(2);
    size(600, 600);
    smooth();
    strokeWeight(0.25f);
    PFont font = createFont("Serif", 13);
    textFont(font);
    // \u591a\u4f59\u7a7a\u683c\u5206\u6790 \u53ef\u80fd\u662f \u7a7a\u683c \n \r \t
    mapData = new WordMap();
    // \u6839\u636e\u5b9e\u9645\u5206\u6790 \u8bfb\u53d6\u7528\u7684\u65f6\u95f4\u5f88\u5c11 \u800c\u6700\u540e\u753b\u7684\u65f6\u95f4\u5f88\u591a
    try {//\u8981\u5b8c\u6574\u8def\u5f84 \u56e0\u4e3a\u662fjava\u8bed\u6cd5
      fis = new FileInputStream("C:\\Users\\user\\Documents\\Processing\\mytest1\\data\\\u4e2d\u65872.txt");
      //System.out.println("\u6587\u4ef6\u603b\u5927\u5c0f\uff1a" + (new File("\u4e2d\u65873.txt")).length());
      isr = new InputStreamReader(fis, "GB2312");
      br = new BufferedReader(isr);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
  // \u521b\u5efa\u5206\u8bcd\u5bf9\u8c61
  Analyzer anal = new IKAnalyzer(true);
  StringReader reader;
  // \u5206\u8bcd
  TokenStream ts;
  CharTermAttribute term;
  public void readPart()
  {
    try {
      str = br.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
    if(str == null)noLoop();
    else reader = new StringReader(str);
    
    ts = anal.tokenStream("", reader);
    CharTermAttribute term = ts.getAttribute(CharTermAttribute.class);
    //s = (char)(str);
    // \u904d\u5386\u5206\u8bcd\u6570\u636e
    try {
      while (ts.incrementToken())
      {
        if(term.toString().length() == 1) continue;//\u4ec5\u4ec5\u5206\u6790\u8bcd \u800c\u5ffd\u7565\u5b57 \u53ef\u6ce8\u91ca\u6062\u590d\u6b63\u5e38
        mapData.addWord(term.toString());//mapData.addWord(str);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    
  }
  public void makeMap()
  {
    mapData.finishAdd(); 
    map = new Treemap(mapData,0,0,width,height);
    background(255);
    map.draw();
  }
  public void readFinish() throws IOException
  {        
    br.close();
  }
  int i = 0;
  int temp = 1;
  public void draw()
  {
    for(i = 0;i < everyTime;i ++)readPart();
    makeMap();
  }
  
  public void mousePressed()
  {
    temp ^= 1;
    if(temp == 0) {noLoop();}else {loop();}
  }
  //\u8bfb\u5165\u4e2d\u6587 \u628a\u6587\u672c\u683c\u5f0f\u6539\u6389\u6210utf8\u5c31\u53ef\u4ee5\u4e86
  //\u5185\u90e8\u7c7b Processing\u91cc\u9762\u5c31\u662f\u90a3\u4e48\u6a21\u62df\u7684 java \u4e0d\u652f\u6301\u591a\u7ee7\u627f \u6ce8\u610fProcessing\u4e2d\u6240\u6709\u7684\u5305\u90fd\u662f\u9ed8\u8ba4\u5bfc\u5165\u7684 \u4f46\u662fjava\u4e2d\u5fc5\u987b\u624b\u52a8\u5bfc\u5165
  public class WordItem extends SimpleMapItem
  {
      String word;
       WordItem(String word)
       {
         this.word = word;
       }
       public void draw()
       {
         if(w*h>10000)fill(200,0,0,100);
         else if(w*h>6000)fill(50,100,0,100);
         else if(w*h>2000)fill(50,50,50,100);
         else fill(20,40,20,80);
         rect(x,y,w,h);
         fill(0);
         if(w > textWidth(word) + 6)//\u5c0f\u4e8e\u5916\u6846\u77e9\u5f62\u7684\u5927\u5c0f\u65f6\u624d\u663e\u793a\u6587\u5b57
         {
           if(h > textAscent() + 6)
           {
             textAlign(CENTER,CENTER);
             text(word,x + w/2,y+h/2);
           }
         }
       }
  }
  public class WordMap extends SimpleMapModel//\u5305\u542b\u4e00\u4e9b\u5217worditem\u5bf9\u8c61
  {
    HashMap words;//\u7528\u6765\u6807\u660e\u6bcf\u4e00\u4e2a\u5355\u8bcd\u548c\u76f8\u5173wordItem\u5bf9\u5e94\u5173\u7cfb
    WordMap()
    {
      words = new HashMap();
    }
    public void addWord(String word)
    {
      WordItem item = (WordItem)words.get(word);
      if(item == null)
      {
        item = new WordItem(word);
        words.put(word,item);
      }
      item.incrementSize();//incremaent\u589e\u52a0
    }
    public void finishAdd()
    {
      items = new WordItem[words.size()];
      words.values().toArray(items);//\u5c06hashmap\u5185\u5bb9\u8f6c\u5316\u4e3a\u6570\u7ec4
    }
  }


  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "mytest1" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
