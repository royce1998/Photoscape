
/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  
/** 
  * Method to test zeroBlue
  * Increases all the other pixel values and turns off the blue.
  */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("FinalPhoto.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  

/** 
  * Method to keep only the blue in the photo
  * Turns down all th eother values except 
  */
  public static void testKeepOnlyBlue()
    {
        Picture beach = new Picture("FinalPhoto.jpg");
        beach.explore();
        Picture.keepOnlyBlue(beach.getPixels2D());
        beach.explore();
    }

/** 
  * Method that negates the photo
  * Inverts all the RGB colors 
  */
     public static void testNegate(){
        Picture beach = new Picture("FinalPhoto.jpg");
       // beach.explore();
        Picture.negate(beach.getPixels2D());
        beach.explore();
    }

/** 
  * Method that makes the picture into grayscale
  * Turns down all the colors and makes them about the same
  */

  public static void testGrayscale(){
        Picture beach = new Picture("FinalPhoto.jpg");
        //beach.explore();
        Picture.grayscale(beach.getPixels2D());
        beach.explore();
    }

    /*public static void pixalate(){
      Picture beach = new Picture ("FinalPhoto");
      Picture.pixalate(beach.getPixels2D());
      
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("beach.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }

   public static void testMirrorVerticleRightToLeft()
  {
    Picture caterpillar = new Picture("beach.jpg");
    caterpillar.mirrorVerticalRightToLeft();
    caterpillar.explore();
  }

   /**
     * Method to test mirrorHorizontal
     */
    public static void testMirrorHorizontal()
    {
        Picture motorcycle = new Picture("beach.jpg");
        //motorcycle.explore();
        motorcycle.mirrorHorizontal();
        motorcycle.explore();
    }
  
    public static void testMirrorHorizontalBotToTop()
    {
        Picture motorcycle = new Picture("beach.jpg");
        //motorcycle.explore();
        motorcycle.mirrorHorizontalBotToTop();
        motorcycle.explore();
    }

    /**
     * Method to test mirrorDiagonal
     */
    public static void testMirrorDiagonal()
    {
        Picture beach = new Picture("beach.jpg");
        //beach.explore();
        beach.mirrorDiagonal();
        beach.explore();
    }

  /**
     * Method to test mirrorGull
     */
    public static void testMirrorGull()
    {
        Picture seagull = new Picture("seagull.jpg");
        //seagull.explore();
        seagull.mirrorGull();
        seagull.explore();
    }

  /** Method to test the collage method */  
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }

  public static void testPixelate(){
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.pixelate();
    beach.explore();
  }  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  public static void testEdgeDetection2(){
    Picture beach = new Picture("swan.jpg");
    beach.edgeDetection2(13);
    beach.explore();

  } 

  
  public static void testGreenScreen(){
    Picture overlay = new Picture("skydiver.jpg");
    Picture sky = new Picture("sky.jpg");
    overlay.greenScreen(sky);
    overlay.explore();
  }


public static void testBlur(){
  Picture beach = new Picture("beach.jpg");
  beach.explore();
  beach.blur();
  beach.blur();
  beach.blur();
  beach.explore();
}
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //testZeroBlue();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    // testFixUnderwater();
    //testMirrorVertical();
    //testMirrorVerticleRightToLeft();
    //testMirrorHorizontal();
    //testMirrorHorizontalBotToTop();
    //testMirrorDiagonal();
    //testMirrorGull();
    //testPixelate();
    //testMirrorTemple();
    //testMirrorArms();
    //testCollage();
    //testCopy();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testGreenScreen();
    testBlur();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}