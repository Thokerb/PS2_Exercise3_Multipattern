package intranet;

import java.util.List;

import interfaces.ObservableCelsiusSensor;
import iot.ObservableSensorFactory;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		//mögliche Implementierung
		List<ObservableCelsiusSensor> allObservableSensors = ObservableSensorFactory.getInstance().getAllSensors();
		
		//@SuppressWarnings("unused")
		Leitstand ls = new Leitstand(allObservableSensors);

		//@SuppressWarnings("unused")
		InternetSeite internet = new InternetSeite(allObservableSensors);
		
		Thread.sleep(20000L);

		
	}

}
