package oliver.com.user.services;

import oliver.com.user.interfaces.Shape;
import oliver.com.user.model.Circle;
import oliver.com.user.model.Rectangle;
import oliver.com.user.model.Square;

public class ShapeMaker {
	private Shape circle;
	private Shape rectangle;
	private Shape square;

	public ShapeMaker() {
		circle = new Circle();
		rectangle = new Rectangle();
		square = new Square();
	}

	public void drawCircle() {
		circle.draw();
	}

	public void drawRectangle() {
		rectangle.draw();
	}

	public void drawSquare() {
		square.draw();
	}
}
