package com.wowzillah.testplatformer.framework;

import java.awt.image.BufferedImage;

import com.wowzillah.testplatformer.window.BufferedImageLoader;

public class Texture 
{
SpriteSheet bs, ps;
private BufferedImage block_sheet = null;
private BufferedImage player_sheet = null;

public BufferedImage[] block =new BufferedImage[2];
public BufferedImage[] player = new BufferedImage[1];

public Texture()
{
	BufferedImageLoader loader= new BufferedImageLoader();
	try {
		block_sheet = loader.loadImage("/blocks.png");
		player_sheet = loader.loadImage("/playersheet.png");
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	bs = new SpriteSheet(block_sheet);
	ps = new SpriteSheet(player_sheet);
	
	getTextures();
}

private void getTextures()
{
	block[0] = bs.grabImage(1, 3, 32, 32); //dirt block
	block[1] = bs.grabImage(5, 1, 32, 32); //grass block
	player[0] = ps.grabImage(1, 1, 32, 32);//player idle frame
}
}
