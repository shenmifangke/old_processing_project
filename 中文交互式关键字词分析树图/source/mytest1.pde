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
//动态生成中文树图 可以规定数度 调节everyTime就可以 可以暂停开始 用鼠标任意点击就可以

  int everyTime = 300;//速度
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
    // 多余空格分析 可能是 空格 \n \r \t
    mapData = new WordMap();
    // 根据实际分析 读取用的时间很少 而最后画的时间很多
    try {//要完整路径 因为是java语法
      fis = new FileInputStream("C:\\Users\\user\\Documents\\Processing\\mytest1\\data\\中文2.txt");
      //System.out.println("文件总大小：" + (new File("中文3.txt")).length());
      isr = new InputStreamReader(fis, "GB2312");
      br = new BufferedReader(isr);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
  // 创建分词对象
  Analyzer anal = new IKAnalyzer(true);
  StringReader reader;
  // 分词
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
    // 遍历分词数据
    try {
      while (ts.incrementToken())
      {
        if(term.toString().length() == 1) continue;//仅仅分析词 而忽略字 可注释恢复正常
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
  //读入中文 把文本格式改掉成utf8就可以了
  //内部类 Processing里面就是那么模拟的 java 不支持多继承 注意Processing中所有的包都是默认导入的 但是java中必须手动导入
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
         if(w > textWidth(word) + 6)//小于外框矩形的大小时才显示文字
         {
           if(h > textAscent() + 6)
           {
             textAlign(CENTER,CENTER);
             text(word,x + w/2,y+h/2);
           }
         }
       }
  }
  public class WordMap extends SimpleMapModel//包含一些列worditem对象
  {
    HashMap words;//用来标明每一个单词和相关wordItem对应关系
    WordMap()
    {
      words = new HashMap();
    }
    void addWord(String word)
    {
      WordItem item = (WordItem)words.get(word);
      if(item == null)
      {
        item = new WordItem(word);
        words.put(word,item);
      }
      item.incrementSize();//incremaent增加
    }
    void finishAdd()
    {
      items = new WordItem[words.size()];
      words.values().toArray(items);//将hashmap内容转化为数组
    }
  }


