import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }

   public static void keepOnlyBlue(Pixel[][] pixels){
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setGreen(0);
                pixelObj.setRed(0);
            }
        }
    }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }


/** 
  * Method to keep only the blue in the photo
  * Turns down all th eother values except 
  */
    public static void negate(Pixel[][] pixels){
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setGreen(255 - pixelObj.getGreen());
                pixelObj.setRed(255 - pixelObj.getRed());
                pixelObj.setBlue(255 - pixelObj.getBlue());
            }
        }
    }

        public static void grayscale(Pixel[][] pixels){
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                int average = (pixelObj.getBlue() + pixelObj.getGreen() + pixelObj.getRed()) / 3;
                pixelObj.setGreen(average);
                pixelObj.setRed(average);
                pixelObj.setBlue(average);
            }
        }
    }
  
  /**
     * Method to modify the pixel colors to make the fish easier to see
     */
    public void fixUnderwater()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                //pixelObj.setBlue(pixelObj.getBlue() / 2);
                //pixelObj.setRed(pixelObj.getRed() * 3);
                pixelObj.setRed(pixelObj.getRed() * 2);
            }
        }
    }

    public void pixelate()
  {
    Pixel [] [] pixels = this.getPixels2D();
    for(int i = 0; i < pixels.length-15; i+=20)
    {
      for(int j = 0; j < pixels[i].length-10; j+=20)
      {
        int sumRed = 0, sumBlue = 0, sumGreen = 0;
        for(int i2 = i; i2 < i+20; i2++)
        {
          for(int j2 = j; j2 < j+20; j2++)
          {
            sumRed+=pixels[i2][j2].getRed();  
            sumGreen+=pixels[i2][j2].getGreen();
            sumBlue+=pixels[i2][j2].getBlue();
          }  
        }
        for(int i2 = i; i2 < i+20; i2++)
        {
          for(int j2 = j; j2 < j+20; j2++)
          {
            pixels[i2][j2].setRed(sumRed/400);
            pixels[i2][j2].setBlue(sumBlue/400);
            pixels[i2][j2].setGreen(sumGreen/400);
            
          }  
        }
      }  
    }
    
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  

 /**
     * Method that mirrors the picture around a
     * vertical mirror in the center of the picture
     * from right to left
     */
    public void mirrorVerticalRightToLeft()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel, rightPixel;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < width / 2; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                leftPixel.setColor(rightPixel.getColor());
            }
        }
    }

    /**
     * Method that mirrors the picture around a
     * horizontal mirror in the center of the picture
     * from bottom to top
     */
    public void mirrorHorizontalBotToTop()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel, bottomPixel;
        int height = pixels.length;
        for (int row = 0; row < height / 2; row++)
        {
            for (int col = 0; col < pixels[row].length; col++)
            {
                topPixel = pixels[row][col];
                bottomPixel = pixels[height - 1 - row][col];
                topPixel.setColor(bottomPixel.getColor());
            }
        }
    }



  /**
     * Mirror the seagull to make two seagulls
     */
    public void mirrorGull()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel, rightPixel;
        int width = 116;
        int left = 235;
        for (int row = 233; row < 326; row++)
        {
            for (int col = 0; col < width; col++)
            {
                leftPixel = pixels[row][left + col];
                rightPixel = pixels[row][left + width * 2 - 1 - col];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    /**
     * Method that mirrors the picture
     * diagonally
     */
    public void mirrorDiagonal()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel bottomLeftPixel, topRightPixel;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < row; col++)
            {
                bottomLeftPixel = pixels[row][col];
                topRightPixel = pixels[col][row];
                topRightPixel.setColor(bottomLeftPixel.getColor());
            }
        }
    }


     /**
     * Method that mirrors the picture around a
     * horizontal mirror in the center of the picture
     * from top to bottom
     */
    public void mirrorHorizontal()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel, bottomPixel;
        int height = pixels.length;
        for (int row = 0; row < height / 2; row++)
        {
            for (int col = 0; col < pixels[row].length; col++)
            {
                topPixel = pixels[row][col];
                bottomPixel = pixels[height - 1 - row][col];
                bottomPixel.setColor(topPixel.getColor());
            }
        }
    }


  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  

  public void edgeDetection(int edgeDist)
{
 Pixel leftPixel = null;
 Pixel rightPixel = null;
 Pixel[][] pixels = this.getPixels2D();
 Color rightColor = null;
 for (int row = 0; row < pixels.length; row++)
 {
 for (int col = 0; col < pixels[0].length-1; col++)
 {
 leftPixel = pixels[row][col];
 rightPixel = pixels[row][col+1];
 if (leftPixel.colorDistance(rightPixel.getColor()) > edgeDist)
 leftPixel.setColor(Color.BLACK);
 else
 leftPixel.setColor(Color.WHITE);
 }
 }
} 

  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection2(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    
    Pixel[][] pixels = this.getPixels2D();
    for (int row = 0; row < pixels.length - 1; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        topPixel = pixels[row][col];
        bottomPixel = pixels[row + 1][col];
        if (leftPixel.colorDistance(rightPixel.getColor()) > edgeDist ||
            topPixel.colorDistance(bottomPixel.getColor()) > edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
public void greenScreen(Picture background)
 {
    Pixel[][] pixels = this.getPixels2D();
    Pixel[][] pixels2 = background.getPixels2D();
    Pixel temp = null;
   int height = pixels.length;
   Pixel test = pixels[10][10]; 
   for (int row = 0; row < pixels.length; row++)
   {
     for (int col = 0; col < pixels[0].length; col++)
     {
                 temp = pixels[row][col];
                 if(temp.getGreen() > 110 && temp.getGreen() > temp.getRed() && temp.getGreen() > temp.getBlue())
                               temp.setColor(pixels2[row][col].getColor()); 
     }
   }  
 }

 public void blur(){
    Pixel[][] pixels = this.getPixels2D();
    int r = pixels.length;
    int c = pixels[0].length;
    Pixel[][]changed = new Pixel[r][c];
   // Pixel[][] pixels2 = background.getPixels2D();
    Pixel temp = null;
   int height = pixels.length;
   Pixel test = pixels[10][10]; 
   for (int row = 0; row < pixels.length; row++)
   {
     for (int col = 0; col < pixels[0].length; col++)
     {
      int average, average2, average3, average4, average5, average6, average7, average8, average9;
      average = average2 = average3 = average4 = average5 = average6 = average7 = average8 = average9 =0;
      int counter = 0;
      temp = pixels[row][col];
      average = temp.getRed();
      if(row < pixels.length-1 && col < pixels[0].length-1){
      average2 = pixels[row+1][col+1].getRed();
      counter++;
      }
      if (col < pixels[0].length-1){
       average3 = pixels[row][col+1].getRed();
       counter++;
      }
      if (row < pixels.length-1){
          average4 = pixels[row+1][col].getRed();
          counter++;
        }
        if (row > 0){
          average5 = pixels[row-1][col].getRed();
          counter++;
        }
        if (col>0){
          average6 = pixels[row][col-1].getRed();
          counter++;
        }
        if (col>0 && row > 0){
          average7 = pixels[row-1][col-1].getRed();
          counter++;
        }
        if (col>0 && row < pixels.length-1){
          average8 = pixels[row+1][col-1].getRed();
          counter++;
        }
        if (col < pixels[0].length-1 && row > 0){
          average9 = pixels[row-1][col+1].getRed();
          counter++;
        }
        int a,b,l,d,e,f,g,h;
        a=b=l=d=e=f=g=h=0;
         if(row < pixels.length-2 && col < pixels[0].length-2){
      a = pixels[row+2][col+2].getRed();
      counter++;
      }
      if (col < pixels[0].length-2){
       b = pixels[row][col+2].getRed();
       counter++;
      }
      if (row < pixels.length-2){
          l = pixels[row+2][col].getRed();
          counter++;
        }
        if (row > 1){
          d = pixels[row-2][col].getRed();
          counter++;
        }
        if (col>1){
          e = pixels[row][col-2].getRed();
          counter++;
        }
        if (col>1 && row >1){
          f = pixels[row-2][col-2].getRed();
          counter++;
        }
        if (col>1 && row < pixels.length-2){
          g = pixels[row+2][col-2].getRed();
          counter++;
        }
        if (col < pixels[0].length-2 && row > 1){
          h = pixels[row-2][col+2].getRed();
          counter++;
        }
      int finalAverage = (average+average2+average3+average4+average5+average6+average7+average8+average9+a+b+l+d+e+f+g+h)/counter;
      temp.setRed(finalAverage);
      }
   }
    for (int row = 0; row < pixels.length; row++)
   {
     for (int col = 0; col < pixels[0].length; col++)
     {
      int average, average2, average3, average4, average5, average6, average7, average8, other;
      average = average2 = average3 = average4 = average5 = average6 = average7 = average8 = other =0;
      int counter = 0;
      temp = pixels[row][col];
      average = temp.getGreen();
      if(row < pixels.length-1 && col < pixels[0].length-1){
      average2 = pixels[row+1][col+1].getGreen();
      counter++;
      }
      if (col < pixels[0].length-1){
       average3 = pixels[row][col+1].getGreen();
       counter++;
      }
      if (row < pixels.length-1){
          average4 = pixels[row+1][col].getGreen();
          counter++;
        }
        if (row > 0){
          average5 = pixels[row-1][col].getGreen();
          counter++;
        }
        if (col>0){
          average6 = pixels[row][col-1].getGreen();
          counter++;
        }
        if (col>0 && row > 0){
          average7 = pixels[row-1][col-1].getGreen();
          counter++;
        }
        if (col>0 && row < pixels.length-1){
          average8 = pixels[row+1][col-1].getGreen();
          counter++;
        }
        if (col < pixels[0].length-1 && row > 0){
          other = pixels[row-1][col+1].getGreen();
          counter++;
        }
     int a,b,l,d,e,f,g,h;
        a=b=l=d=e=f=g=h=0;
         if(row < pixels.length-2 && col < pixels[0].length-2){
      a = pixels[row+2][col+2].getGreen();
      counter++;
      }
      if (col < pixels[0].length-2){
       b = pixels[row][col+2].getGreen();
       counter++;
      }
      if (row < pixels.length-2){
          l = pixels[row+2][col].getGreen();
          counter++;
        }
        if (row > 1){
          d = pixels[row-2][col].getGreen();
          counter++;
        }
        if (col>1){
          e = pixels[row][col-2].getGreen();
          counter++;
        }
        if (col>1 && row >1){
          f = pixels[row-2][col-2].getGreen();
          counter++;
        }
        if (col>1 && row < pixels.length-2){
          g = pixels[row+2][col-2].getGreen();
          counter++;
        }
        if (col < pixels[0].length-2 && row > 1){
          h = pixels[row-2][col+2].getGreen();
          counter++;
        }
      int finalAverage = (average+average2+average3+average4+average5+average6+average7+average8+other+a+b+l+d+e+f+g+h)/counter;
      temp.setGreen(finalAverage);

      }
   }
    for (int row = 0; row < pixels.length; row++)
   {
     for (int col = 0; col < pixels[0].length; col++)
     {
      int average, average2, average3, average4, average5, average6, average7, average8, other;
      average = average2 = average3 = average4 = average5 = average6 = average7 = average8 = other =0;
      int counter = 0;
      temp = pixels[row][col];
      average = temp.getBlue();
      if(row < pixels.length-1 && col < pixels[0].length-1){
      average2 = pixels[row+1][col+1].getBlue();
      counter++;
      }
      if (col < pixels[0].length-1){
       average3 = pixels[row][col+1].getBlue();
       counter++;
      }
      if (row < pixels.length-1){
          average4 = pixels[row+1][col].getBlue();
          counter++;
        }
        if (row > 0){
          average5 = pixels[row-1][col].getBlue();
          counter++;
        }
        if (col>0){
          average6 = pixels[row][col-1].getBlue();
          counter++;
        }
        if (col>0 && row > 0){
          average7 = pixels[row-1][col-1].getBlue();
          counter++;
        }
        if (col>0 && row < pixels.length-1){
          average8 = pixels[row+1][col-1].getBlue();
          counter++;
        }
        if (col < pixels[0].length-1 && row > 0){
          other = pixels[row-1][col+1].getBlue();
          counter++;
        }
      int a,b,l,d,e,f,g,h;
        a=b=l=d=e=f=g=h=0;
         if(row < pixels.length-2 && col < pixels[0].length-2){
      a = pixels[row+2][col+2].getBlue();
      counter++;
      }
      if (col < pixels[0].length-2){
       b = pixels[row][col+2].getBlue();
       counter++;
      }
      if (row < pixels.length-2){
          l = pixels[row+2][col].getBlue();
          counter++;
        }
        if (row > 1){
          d = pixels[row-2][col].getBlue();
          counter++;
        }
        if (col>1){
          e = pixels[row][col-2].getBlue();
          counter++;
        }
        if (col>1 && row >1){
          f = pixels[row-2][col-2].getBlue();
          counter++;
        }
        if (col>1 && row < pixels.length-2){
          g = pixels[row+2][col-2].getBlue();
          counter++;
        }
        if (col < pixels[0].length-2 && row > 1){
          h = pixels[row-2][col+2].getBlue();
          counter++;
        }
      int finalAverage = (average+average2+average3+average4+average5+average6+average7+average8+other+a+b+l+d+e+f+g+h)/counter;
      temp.setBlue(finalAverage);

      }
   }  
 }

  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("FinalPhoto.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
