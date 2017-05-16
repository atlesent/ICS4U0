import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public abstract class Screen extends Canvas implements Runnable
{

  private final int FPS = 60;
  private boolean running;
  private Thread thread;
  private String threadName;
  private int ticks = 0;
  

  public Screen (String threadName)
  {
    this.threadName = threadName;
    setFocusable(false);
  }

  public void wait (int ticks)
  {
    this.ticks -= ticks;
  }

  public abstract void tick();

  public abstract void refresh (Graphics g);
  
  public void refresh ()
  {
    BufferStrategy bs = getBufferStrategy ();
    if (bs == null)
    {
      try
      {
        createBufferStrategy (2);
      }
      catch (IllegalStateException e)
      {
        e.printStackTrace();
      }
      return;
    }
    Graphics g = bs.getDrawGraphics();
    refresh (g);
    g.dispose();
    bs.show();
  }
  
  public void run()
  {
    long timeOld = System.nanoTime();
    long timeNew;
    double frameRate = 1000000000 / FPS;
    while (running)
    {
      timeNew = System.nanoTime();
      if (timeNew - timeOld >= frameRate)
      {
        timeOld = timeNew;
        if (ticks == 0)
          tick();
        else 
          ticks ++;
      }  
      refresh();
    }
    stop();
  }
  
  public void start ()
  {
    running = true;
    thread = new Thread (this, threadName);
    thread.start();
  }
  
  public void stop ()
  {
    running = false;
    try
    {
      thread.join();
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
  }
}