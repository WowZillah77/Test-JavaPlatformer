package com.wowzillah.testplatformer.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.wowzillah.testplatformer.framework.GameObject;
import com.wowzillah.testplatformer.framework.ObjectId;
import com.wowzillah.testplatformer.framework.Texture;
import com.wowzillah.testplatformer.window.Game;

public class Block  extends GameObject
{
	Texture tex = Game.getInstance();
	private int type;
	
	public Block(float x, float y, int type, ObjectId id)
	{
		super(x, y, id);
		this.type=type;
		
	}

	
	public void tick(LinkedList<GameObject> object) 
	{
		
		
	}

	
	public void render(Graphics g) 
	{
		if(type==0)//Rock  block
			g.drawImage(tex.block[0], (int)x, (int)y, null);
		if(type==1)//Dirt block
			g.drawImage(tex.block[1], (int)x, (int)y, null);
		if(type==2)//Middle grass block
			g.drawImage(tex.block[2], (int)x, (int)y, null);
		if(type==3)//left grass block
			g.drawImage(tex.block[3], (int)x, (int)y, null);
		if(type==4)//right grass block
			g.drawImage(tex.block[4], (int)x, (int)y, null);
		if(type==5)//left Rock block
			g.drawImage(tex.block[5], (int)x, (int)y, null);
		if(type==6)//right rock block
			g.drawImage(tex.block[6], (int)x, (int)y, null);
		if(type==7)//right rock block
			g.drawImage(tex.block[7], (int)x, (int)y, null);
		
		if(type==8)//left top moss block
			g.drawImage(tex.block[8], (int)x, (int)y, null);
		if(type==9)//center top moss block
			g.drawImage(tex.block[9], (int)x, (int)y, null);
		if(type==10)//right top moss block
			g.drawImage(tex.block[10], (int)x, (int)y, null);
		
		
	}


	public Rectangle getBounds() 
	{
		return new Rectangle((int)x,(int)y,32,32);
	}

	
}