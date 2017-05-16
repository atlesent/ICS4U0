import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.geom.AffineTransform;
import java.awt.*;

public class imageSet 
{
  private BufferedImage image;
  private BufferedImage changedImage;
  private String name;
  private AffineTransform at = new AffineTransform();

  public imageSet (String fileName) throws java.io.IOException
  {
    image = ImageIO.read(new File(".//Resources/" + fileName));
    name = fileName;
    changedImage = ImageIO.read (new File (".//Resources/"+fileName));
  }
  
  public void changeSize(int x, int y)
  {
    changedImage = new BufferedImage ((int)(image.getWidth()*x), (int)(image.getHeight()*y), BufferedImage.TYPE_INT_ARGB);
    at.scale (x, y);
    Graphics2D g = changedImage.createGraphics();
    g.setBackground (new Color (0,0,0,0));
    g.clearRect (0,0,changedImage.getWidth(), changedImage.getHeight());
    g.drawImage (image, at, null);
  }
  
  public void revertImage ()
  {
    changedImage = new BufferedImage (image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
    Graphics2D g = changedImage.createGraphics();
    g.setBackground (new Color (0,0,0,0));
    g.clearRect (0,0,changedImage.getWidth(), changedImage.getHeight());
    g.drawImage (image, 0,0,null);
  }
  
  public String imageName()
  {
    return name;
  }
  
  public BufferedImage image()
  {
    return changedImage;
  }    
}
