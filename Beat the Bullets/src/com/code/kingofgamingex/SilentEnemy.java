package com.code.kingofgamingex;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class SilentEnemy extends GameObject {

	Handler handler;

	public SilentEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		velX = 5;
		velY = 5;
		
		this.handler = handler;
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 16, 16);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH - 16) velX *= -1;
		
		handler.addObject(new Trail((int)x,(int) y, 16, 16, 0.02f, ID.Trail, Color.gray, handler));
		
	}
	
	

	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect((int)x, (int)y, 16, 16);
		
		
	}

}
