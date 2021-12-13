package oliver.com.user.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import oliver.com.user.TiempoStatus;

@RestController
public class FechasController {
	
	
	@GetMapping("/fechas")
	public String getFechas() throws ParseException {
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		
		Date tempDate = cal.getTime();
		System.out.println("Fecha actual: " + tempDate);
		

		String pt = "2021-11-06 16:00:00";
		Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(pt);

		
		Date cal2  = obtenerFechaSuma(date,1,2).getTime();
		
		System.out.println("Fecha guarda: " + cal2);
		
		
		//cal2 mi fecha guardada +  el tiempo del mantenedor
		//cal fecha actual
		// -1  --> le mostramos el banner
		//  1 -->  seguimos sin mostrarle el banner
		
		System.out.println("Comparar fechas: " + cal2.compareTo(tempDate));
		
		
		
		System.out.println(TiempoStatus.DIA.getCodigo());
		
		
		return null;
		
		
		//Calendar.MILISECOND para milisegundos
		//Calendar.SECOND para segundos
		//Calendar.MINUTE para minutos
		//Calendar.HOUR para horas
		//Calendar.DAY_OF_YEAR para días
		//Calendar.MONTH para meses
		//Calendar.YEAR para años
	}
	
	
	public Calendar obtenerFechaSuma(Date fecha, int tipo, int tiempo) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		
		switch(TiempoStatus.valueOf(tipo)) {
		case DIA:
			calendar.add(Calendar.DAY_OF_YEAR, tiempo);
			break;
		case HORA:
			calendar.add(Calendar.HOUR, tiempo);
			break;
		case MINUTO:
			calendar.add(Calendar.MINUTE, tiempo);
			break;
		default:
			calendar.add(Calendar.HOUR, tiempo);
		}
		
		return calendar;
	}
	
	
	@GetMapping("/rango-fechas")
	public String rangoFechas() throws ParseException {
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		
		Date fechaActual = cal.getTime();
		System.out.println("Fecha actual: " + fechaActual);
		
		
		String fechaInicial = "2021-11-09" + " " + "16:00:00";
		Date dateinicial = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fechaInicial);
		
		
		System.out.println("Fecha Inicial: " + dateinicial);
		
		String fechaFinal = "2021-11-13" + " " +  "16:00:00";
		Date dateFinal = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fechaFinal);
		
		System.out.println("Fecha Final: " + dateinicial);
		
		
		//comparando fechas
		// si la fecha es igual a -1 a un es valida
		// si la fecha es igual a 1 , ya no es valida 
		System.out.println(fechaActual.compareTo(dateinicial));
	
		System.out.println(fechaActual.compareTo(dateFinal));
		
		if(fechaActual.compareTo(dateinicial) == -1 || fechaActual.compareTo(dateFinal) == -1) {
			System.out.println("REGRESAMOS LA OPCION ");
		}
		
		
		return null;
	}
	
	
	
}
