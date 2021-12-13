package oliver.com.user.model;

import oliver.com.user.interfaces.Shape;

public class Circle implements Shape {

	@Override
	public void draw() {
		System.out.println("Circle::draw()");
	}

}
