package com.code.kingofgamingex;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SmartEnemy extends GameObject {

	Handler handler;
	private GameObject player;

	public SmartEnemy(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		velX = 5;
		velY = 5;
		
		this.handler = handler;
		
		for(int i = 0; i < handler.object.size(); i++) {
			if(handler.object.get(i).getId() == ID.Player) {
				player = handler.object.get(i);
			}
		}
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y, 16, 16);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		float diffx = x - player.getX() - 8;
		float diffy = y - player.getY() - 8;
		float distance = (float) Math.sqrt((x-player.getX())*(x-player.getX()) + (y-player.getY()) * (y-player.getY()));
		
		velX = (int) ((-1/distance) * diffx);
		velY = (int) ((-1/distance) * diffy);
		
		if(y <= 0 || y >= Game.HEIGHT - 32) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH - 16) velX *= -1;
		
		handler.addObject(new Trail(x, y, 16, 16, 0.02f, ID.Trail, Color.green, handler));
		
	}
	
	

	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect((int)x, (int)y, 16, 16);
		
		
	}

}
