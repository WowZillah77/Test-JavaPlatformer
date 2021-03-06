package com.wowzillah.testplatformer.framework;

import java.awt.image.BufferedImage;

import com.wowzillah.testplatformer.window.BufferedImageLoader;

public class Texture 
{
SpriteSheet bs, ps;
private BufferedImage block_sheet = null;
private BufferedImage player_sheet = null;

public BufferedImage[] block =new BufferedImage[20];
public BufferedImage[] player = new BufferedImage[12];

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
	block[0] = bs.grabImage(8, 2, 32, 32); //Rock block
	block[1] = bs.grabImage(2, 2, 32, 32); //dirt block
	
	block[2] = bs.grabImage(2, 1, 32, 32); //centre grass
	block[3] = bs.grabImage(1, 1, 32, 32); //left grass
	block[4] = bs.grabImage(3, 1, 32, 32); //right grass
	
	block[5] = bs.grabImage(7, 1, 32, 32); //left path rock
	block[6] = bs.grabImage(9, 1, 32, 32); //right path rock
	block[7] = bs.grabImage(8, 1, 32, 32); //center path rock
	
	block[8] = bs.grabImage(5, 3, 32, 32); //left top moss
	block[9] = bs.grabImage(6, 3, 32, 32); //center top moss
	block[10] = bs.grabImage(7, 3, 32, 32); //right top moss
	
	player[0] = ps.grabImage(2, 1, 32, 32);//player idle frame 2
	player[1] = ps.grabImage(1, 3, 32, 32);//player walk left frame 1
	player[2] = ps.grabImage(2, 3, 32, 32);//player walk left frame 2
	player[3] = ps.grabImage(3, 3, 32, 32);//player walk left frame 3
	player[4] = ps.grabImage(4, 3, 32, 32);//player walk left frame 4
	player[5] = ps.grabImage(1, 2, 32, 32);//player walk right frame 1
	player[6] = ps.grabImage(2, 2, 32, 32);//player walk right frame 2
	player[7] = ps.grabImage(3, 2, 32, 32);//player walk right frame 3
	player[8] = ps.grabImage(4, 2, 32, 32);////player walk right frame 4
	player[9] = ps.grabImage(1, 1, 32, 32);//player idle frame 1
	player[10] = ps.grabImage(3, 1, 32, 32);//player idle frame 3
	player[11] = ps.grabImage(4, 1, 32, 32);//player idle frame 4
	
}
}
