package com.wowzillah.testplatformer.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.wowzillah.testplatformer.framework.GameObject;
import com.wowzillah.testplatformer.framework.ObjectId;
import com.wowzillah.testplatformer.window.Handler;

public class Player extends GameObject{
	
	private float width=32, height=64;
	
	private float gravity =0.5f;
	private final float MAX_SPEED = 10;
	
	private Handler handler; 
	
	public Player(float x, float y, Handler handler, ObjectId id) {
		super(x, y, id);
		this.handler = handler;
		
	}

	
	public void tick(LinkedList<GameObject> object) 
	{
		x +=velX;
		y +=velY;
		
		if(falling || jumping)
		{
			velY += gravity;
			
			if(velY> MAX_SPEED)
				velY = MAX_SPEED;
		}
		
		Collision(object);
		
	}

	private void Collision(LinkedList<GameObject> object)
	{
		for(int i=0; i< handler.object.size();i++)
		{
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ObjectId.Block)
			{
				if(getBounds().intersects(tempObject.getBounds()))
				{
					y= tempObject.getY() - height;
					velY=0;
					falling=false;
					jumping=false;
				}
			}
		}
	}
	
	public void render(Graphics g) 
	{
		g.setColor(Color.blue);
		g.fillRect((int)x, (int)y, (int)width, (int)height);
		
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.red);
		g2d.draw(getBounds());
		g2d.draw(getBoundsRight());
		g2d.draw(getBoundsLeft());
		g2d.draw(getBoundsTop());
		
	}

	
	public Rectangle getBounds()
	{
		
		return new Rectangle((int) ((int) ((int)x+width/2)-((width/2)/2)), (int) ((int)y+(height/2)), (int)width/2, (int)height/2);
	}

	public Rectangle getBoundsTop()
	{
		
		return new Rectangle((int) ((int)x+(width/2)-((width/2)/2)), (int)y, (int)width/2, (int)height/2);
	}
	
	public Rectangle getBoundsRight()
	{
		
		return new Rectangle((int) ((int)x+width-5), (int)y+5, (int)5, (int)height-10);
	}
	
	public Rectangle getBoundsLeft()
	{
		
		return new Rectangle((int)x, (int)y+5, (int)5, (int)height-10);
	}
	

}
