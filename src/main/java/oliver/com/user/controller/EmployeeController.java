package oliver.com.user.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import oliver.com.user.model.Employee;

@RestController
public class EmployeeController {
	
	private int count = 0;
	
	@GetMapping("/empleados/{id}")
	public Employee findById(@PathVariable("id") int id) throws InterruptedException {
		count++;
		//Thread.sleep(2*1000);
		
		Thread.sleep(100);
		
		List<Employee> listEmplyee = new ArrayList<Employee>();
		
		listEmplyee.add(new Employee(1,"oliver"));
		listEmplyee.add(new Employee(2,"maximiliano"));
		
		maybeFail("ups tenemos problemas");
		
		Employee employee = listEmplyee
								.stream()
								.filter(c -> c.getId() == id)
								.findAny()
								.orElse(null);
		
		employee.setMensaje(String.format(MensajesController.RESPONSE_STRING_FORMAT, MensajesController.HOSTNAME, count));
		return employee;
	}
	
	private void maybeFail(String msg) {
		Random randomno = new Random();
		if (randomno.nextBoolean()) {
			throw new RuntimeException(msg);
		}
	}
	
}
