package oliver.com.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import oliver.com.user.services.ShapeMaker;

@SpringBootApplication
public class UserApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		int contador = 0;
		String nombre = null;
		do {
			System.out.println("Contando... " + (contador + 1));
			if (contador == 5) {
				nombre = "oliver";
				System.out.println(nombre);
			}

			contador += 1;

		} while (contador < 10);

		System.out.println("Valor final contador " + contador);

		ShapeMaker shapeMaker = new ShapeMaker();

		shapeMaker.drawCircle();
		shapeMaker.drawRectangle();
		shapeMaker.drawSquare();

	}

}
