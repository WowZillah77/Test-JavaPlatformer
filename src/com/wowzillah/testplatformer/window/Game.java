package com.wowzillah.testplatformer.window;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.Random;

import com.wowzillah.testplatformer.framework.GameObject;
import com.wowzillah.testplatformer.framework.KeyInput;
import com.wowzillah.testplatformer.framework.ObjectId;
import com.wowzillah.testplatformer.objects.Block;
import com.wowzillah.testplatformer.objects.Player;


public class Game extends Canvas implements Runnable
{

	
	private static final long serialVersionUID = -1391569290244531845L;
	
	private boolean running = false;
	private Thread thread;
	public static int WIDTH, HEIGHT;
	
	//Object
	Handler handler;
	Camera cam;
	
	Random rand = new Random();
	
	private void init()
	{
		WIDTH = getWidth();
		HEIGHT = getHeight();
		handler = new Handler();
		
		cam=new Camera(0,0);
		
		handler.addObject(new Player(100, 100, handler, ObjectId.Player));
		
		handler.createLevel();
		
		this.addKeyListener(new KeyInput(handler));
	}
	
	public synchronized void start()
	{
		if(running)
			return;
		
		running= true;
		thread= new Thread(this);
		thread.start();
	}

	public void run() 
	{
		init();
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 /amountOfTicks;
		double delta=0;
		long timer = System.currentTimeMillis();
		int updates =0;
		int frames=0; 
		while(running) 
		{
			
			long now= System.nanoTime();
			delta += (now -lastTime)/ ns;
			lastTime=now;
			while(delta >=1)
			{
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
			
			if(System.currentTimeMillis()- timer>1000) 
			{
				timer += 1000;
				System.out.println("FPS:"+ frames + "TICKS:" + updates);
				frames =0;
				updates=0;
			}
		}
		
	}
	
	private void tick()
	{
		handler.tick();
		for(int i=0; i< handler.object.size();i++)
		{
			if(handler.object.get(i).getId() == ObjectId.Player)
			{
				cam.tick(handler.object.get(i));
				
			}
		}
		
	}
	
	private void render()
	{
		BufferStrategy bs= this.getBufferStrategy();
		if(bs==null)
		{
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d =(Graphics2D) g;
		
		////////////////////////////////////
		
		//  everything will be drawn here //
		
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		g2d.translate(cam.getX(), cam.getY());//begin of cam
		
		handler.render(g);
		
		g2d.translate(-cam.getX(), -cam.getY());//end of cam
		////////////////////////////////////
		
		g.dispose();
		bs.show();
	}
	
	public static void main(String arg[])
	{
		new Window(800,600,"Test Platformer", new Game());
	}

}
