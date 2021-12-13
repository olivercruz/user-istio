package oliver.com.user.model;

import oliver.com.user.interfaces.Shape;

public class Square implements Shape{

	@Override
	public void draw() {
		System.out.println("Square::draw()");
	}

}
