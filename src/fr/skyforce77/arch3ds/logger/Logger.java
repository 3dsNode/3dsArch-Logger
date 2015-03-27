package fr.skyforce77.arch3ds.logger;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.skyforce77.arch3ds.api.ArchGame;
import fr.skyforce77.arch3ds.api.graphics.ArchGraphics;
import fr.skyforce77.arch3ds.api.graphics.ArchScreen;
import fr.skyforce77.arch3ds.api.input.ArchAxis;
import fr.skyforce77.arch3ds.api.input.ArchInput;

public class Logger extends ArchGame{
	
	private static int x = 0;

	@Override
	public void onInit() {
		System.err.println("[Logger] Called init event");
	}
	
	@Override
	public void onEnable() {
		System.err.println("[Logger] Called enable event");
	}
	
	@Override
	public void onDisable() {
		System.err.println("[Logger] Called disable event");
	}

	@Override
	public void onInput(ArchInput input, byte status) {
		System.err.println("[Logger] Called input event: ["+input.getCode()+": "+status+"]");
	}

	@Override
	public void onAxis(ArchAxis axis, double x, double y) {
		System.err.println("[Logger] Called axis event: ["+axis.getCode()+": "+x+","+y+"]");
	}
	
	@Override
	public void onStylusClicked(ArchScreen screen, int x, int y) {
		System.err.println("[Logger] Called stylus click event: ["+screen+" at "+x+";"+y+"]");
	}
	
	@Override
	public void onStylusPressed(ArchScreen screen, int x, int y) {
		System.err.println("[Logger] Called stylus press event: ["+screen+" at "+x+";"+y+"]");
	}
	
	@Override
	public void onStylusReleased(ArchScreen screen, int x, int y) {
		System.err.println("[Logger] Called stylus release event: ["+screen+" at "+x+";"+y+"]");
	}
	
	@Override
	public void onStylusMoved(ArchScreen screen, int x, int y) {
		System.err.println("[Logger] Called stylus move event: ["+screen+" at "+x+";"+y+"]");
	}
	
	@Override
	public void onTick() {
		x = x > 100 ? 0 : x+1;
		if(x%3 == 0)
			ArchGraphics.push();
	}

	@Override
	public void drawScreen(ArchGraphics graphics) {
		Graphics2D g2d = graphics.getGraphics();
		g2d.clearRect(0, 0, graphics.getWidth(), graphics.getHeight());
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, graphics.getWidth(), graphics.getHeight());
		
		if(graphics.getScreen().equals(ArchScreen.TOP_SCREEN)) {
			g2d.setColor(Color.WHITE);
			g2d.drawString("Logger", x, graphics.getHeight()/2);
		}
	}

}