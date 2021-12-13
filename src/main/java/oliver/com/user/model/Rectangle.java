package oliver.com.user.model;

import oliver.com.user.interfaces.Shape;

public class Rectangle implements Shape{

	@Override
	public void draw() {
		System.out.println("Rectangle::draw()");
	}

}
