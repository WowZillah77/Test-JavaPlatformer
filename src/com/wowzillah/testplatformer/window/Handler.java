package com.wowzillah.testplatformer.window;

import java.awt.Graphics;
import java.util.LinkedList;

import com.wowzillah.testplatformer.framework.GameObject;
import com.wowzillah.testplatformer.framework.ObjectId;
import com.wowzillah.testplatformer.objects.Block;

public class Handler 

{
	public LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	private GameObject tempObject;
	
	public void tick()
	{
		for(int i=0; i<object.size(); i++)
		{
			tempObject = object.get(i);
			
			tempObject.tick(object);
		}
	}
	
	public void render(Graphics g)
	{
		for(int i=0; i<object.size(); i++)
		{
			tempObject = object.get(i);
			
			tempObject.render(g);
		}
	}
	
	public void addObject(GameObject object)
	{
		this.object.add(object);
	}
	
	public void removeObject(GameObject object)
	{
		this.object.remove(object);
	}
	
	

}
