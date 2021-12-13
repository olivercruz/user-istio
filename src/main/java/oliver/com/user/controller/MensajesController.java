package oliver.com.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MensajesController {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	public static final String RESPONSE_STRING_FORMAT = "mensaje v2 from '%s': %d\n";
	
	private int count = 0;
	
	private boolean bandera = false;
	
	private int timeout = 1000;
	
	public static final String HOSTNAME = parseContainerIdFromHostname(
            System.getenv().getOrDefault("HOSTNAME", "unknown"));
	
	static String parseContainerIdFromHostname(String hostname) {
        return hostname.replaceAll("api-usuario-v\\d+-", "");
    }
	
	@GetMapping("/mensajes")
	public ResponseEntity<String> getMensajes() {
		
		timeout();

		count++;
		
		if(this.bandera) {
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
	                .body(String.format("mensaje error from '%s'\n", HOSTNAME));
		}

		return ResponseEntity.ok(String.format(MensajesController.RESPONSE_STRING_FORMAT, HOSTNAME, count));
	}
	
	@GetMapping("/mensajes/bandera/{bandera}")
	public ResponseEntity<String> cambiarBandera(@PathVariable("bandera") Boolean flag) {
		
		this.bandera = flag;
		return ResponseEntity.ok("Marcar request error 503");
		
	}
	
	@GetMapping("/mensajes/tiempo/{tiempo}")
	public ResponseEntity<String> cambiandoTiempo(@PathVariable("tiempo") int tiempo){
		this.timeout = tiempo;
		return ResponseEntity.ok("Cambiando estatus del tiempo");
	}
	
	private void timeout() {
        try {
            Thread.sleep(this.timeout);
        } catch (InterruptedException e) {
            logger.info("Thread interrupted");
        }
    }
	
}
