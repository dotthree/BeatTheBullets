package com.code.kingofgamingex;

import java.util.Random;

public class Spawn {
	
	private Handler handler;
	private HUD hud; 
	
	private Random r = new Random();
	
	int scorekeep = 0;

	public Spawn(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
	}
	
	public void tick() {
		scorekeep++; 
		
		if(scorekeep >= 1000) {
			scorekeep = 0;
			hud.setLevel(hud.getLevel() + 1);
			
			
			if(hud.getLevel() == 2) {  
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
			} else if(hud.getLevel() == 3) {
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
			} else if(hud.getLevel() == 4) {
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
			} else if(hud.getLevel() == 5) {
				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
			} else if(hud.getLevel() == 8 ) {
				handler.addObject(new SuperFastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SuperFastEnemy, handler));
			} else if(hud.getLevel() == 10) {
				handler.addObject(new SilentEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SilentEnemy, handler));
			}
	
		}
		
	}
	

}
