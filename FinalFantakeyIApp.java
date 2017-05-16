import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.*;
import javax.sound.sampled.*;
//import org.apache.commons.io.FileUtils;

public class FinalFantakeyIApp extends JFrame implements ActionListener
{
  private CardLayout panels;
  private JPanel screenView;
 // private MenuPanel menu;
  private SplashScreen splash;
  
 // static BufferedKeyboard keyboard;
  
  public FinalFantakeyIApp ()
  {
    super ("Final Fantakey I");
    
//    try 
//    {
//      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//      // ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(".//Resources/Minecraftia-Regular.ttf")));
//    } 
//    catch (IOException e) 
//    {
//          e.printStackTrace();
//    }
    
  //  keyboard = new BufferedKeyboard ();
  //  addKeyListener (keyboard);
    
    panels = new CardLayout ();
    screenView = new JPanel (panels);
    
  //  menu = new MenuPanel (this);
    splash = new SplashScreen (this);
    
   // screenView.add (menu, "Menu Panel");
    screenView.add (splash, "Splash Screen");
    
    JMenuItem quitItem = new JMenuItem ("Quit");
    JMenuItem aboutItem = new JMenuItem ("About");
    JMenuItem helpFile = new JMenuItem ("Help File");
    
    JMenu fileMenu = new JMenu ("File");
    JMenu helpMenu = new JMenu ("Help");
    
    fileMenu.add (quitItem);
    helpMenu.add (aboutItem);
    helpMenu.add (helpFile);
    
    JMenuBar myMenus = new JMenuBar ();
    
    myMenus.add (fileMenu);
    myMenus.add (helpMenu);
    
    setJMenuBar (myMenus);
    
    quitItem.addActionListener (this);
    aboutItem.addActionListener (this);
    helpFile.addActionListener (this);
    
    setSize (1080, 720);
    setResizable (false);
    setLocationRelativeTo (this);
    setDefaultCloseOperation (EXIT_ON_CLOSE);
    
    panels.show (screenView, "Splash Screen");
    splash.start();
    add (screenView);
    setVisible (true);
  }
  
  public void actionPerformed (ActionEvent ae)
  {
  }
  
    public static void main (String [] args)
  {
    FinalFantakeyIApp t = new FinalFantakeyIApp();
  }
}