package com.code.kingofgamingex;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.code.kingofgamingex.Game.STATE;

public class Menu extends MouseAdapter {
	
	Game game;
	Handler handler;
	
	private HUD hud;

	public Menu(Game game, Handler handler, HUD hud) {
		this.game = game;
		this.handler = handler;
		this.hud = hud;
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		//Play button
		
		
		if(game.GameState == STATE.Help) {
			if(mouseOver(mx, my, 220, 350, 200, 64)) {
				game.GameState = STATE.Menu;
				return;
			}
		}
		
		if(game.GameState == STATE.End) {
			if(mouseOver(mx, my, 220, 350, 200, 64)) {
				game.GameState = STATE.Menu;
				return;
			}
		}
		
		//Quit button
		if(game.GameState == STATE.Menu) {
			if(mouseOver(mx, my, 220, 350, 200, 64)) {
				System.exit(1);
			}
		
			if(mouseOver(mx, my, 210, 150, 200, 64)) {
				game.GameState = STATE.Game;
				handler.addObject(new Player(game.WIDTH/2-32, game.HEIGHT/2-32, ID.Player, handler));
				handler.clearEnemies();
				handler.addObject(new BasicEnemy(16, 16, ID.BasicEnemy, handler));
			}
			
			//Help button
			if(mouseOver(mx, my, 220, 250, 200, 64)) {
				game.GameState = STATE.Help;
			}
		}
		
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if(mx > x && mx < x + width) {
			if(my > y && my < y + height) {
				return true;
			} else return false;
		} else return false;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		if(game.GameState == STATE.Menu) {
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
			g.setFont(fnt);
			
			g.setColor(Color.black);
			
			g.drawString("Beat the Bullets", 150, 50);
			
			g.setFont(fnt2);
			g.drawRect(220, 150, 200, 64);
			g.drawString("Play", 290, 195);
			
			
			g.drawRect(220, 250, 200, 64);
			g.drawString("Help", 290, 295);
			
			g.drawRect(220, 350, 200, 64);
			g.drawString("Quit", 290, 395);
		} else if(game.GameState == STATE.Help) {
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
			Font fnt3 = new Font("arial", 1, 20);
			g.setFont(fnt);
			
			g.setColor(Color.black);
			
			g.drawString("Help", 250, 50);
			
			g.setFont(fnt3);
			g.drawString("Use WASD keys to move the player, and doge bullets to win.", 10, 200);
			
			g.setFont(fnt2);
			g.drawRect(220, 350, 200, 64);
			g.drawString("Back", 290, 395);
		}  else if(game.GameState == STATE.End) {
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
			Font fnt3 = new Font("arial", 1, 20);
			g.setFont(fnt);
			
			g.setColor(Color.black);
			
			g.drawString("Game Over", 175, 50);
			
			g.setFont(fnt3);
			g.drawString("You have lost. Your score was " + hud.getScore(), 150, 200);
			
			g.setFont(fnt2);
			g.drawRect(220, 350, 200, 64);
			g.drawString("Try again", 245, 390);
			
		}
		
		
	}

}
