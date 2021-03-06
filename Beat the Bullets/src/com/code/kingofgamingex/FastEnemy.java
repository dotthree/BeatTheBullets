package com.code.kingofgamingex;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class FastEnemy extends GameObject {

	Handler handler;

	public FastEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		velX = 2;
		velY = 9;
		
		this.handler = handler;
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int) x,(int) y, 16, 16);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH - 16) velX *= -1;
		
		handler.addObject(new Trail(x, y, 16, 16, 0.02f, ID.Trail, Color.cyan, handler));
		
	}
	
	

	public void render(Graphics g) {
		g.setColor(Color.cyan);
		g.fillRect((int)x, (int)y, 16, 16);
		
		
	}

}

