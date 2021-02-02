package com.code.kingofgamingex;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class SuperFastEnemy extends GameObject {

	Handler handler;

	public SuperFastEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		velX = 12;
		velY = 12;
		
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
		
		handler.addObject(new Trail((int)x,(int) y, 16, 16, 0.02f, ID.Trail, Color.red, handler));
		
	}
	
	

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 16, 16);
		
		
	}

}
