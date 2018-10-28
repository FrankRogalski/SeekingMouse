package main;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;

public class Kreis {
	private GraphicsContext gc;
	
	private Point2D pos;
	
	private double size = 50, maxMove = 7;
	
	public Kreis(GraphicsContext gc, double x, double y) {
		pos = new Point2D(x, y);
		this.gc = gc;
	}
	
	public void update(double mouseX, double mouseY) {
		double maxMove = this.maxMove;
		Point2D mouse = new Point2D(mouseX, mouseY);
		
		if (mouse.distance(pos) <= 100) {
			maxMove = map(mouse.distance(pos), 0, 100, 0, this.maxMove);
		}
		
		mouse = mouse.subtract(pos);
		mouse = mouse.normalize();
		mouse = mouse.multiply(maxMove);
		pos = pos.add(mouse);
	}
	
	public void show() {
		gc.fillOval(pos.getX() - size / 2, pos.getY() - size / 2, size, size);
	}
	
	private double map(double value, double min, double max, double nMin, double nMax) {
		return value / (max - min) * (nMax - nMin) + nMin;
	}
}