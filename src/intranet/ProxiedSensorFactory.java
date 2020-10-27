package intranet;

import interfaces.ObservableCelsiusSensor;

public class ProxiedSensorFactory {

	protected ProxiedSensorFactory() {	}
	
	public static ProxiedSensorFactory otsf = new ProxiedSensorFactory();
	
	public static ProxiedSensorFactory getInstance() {
		return otsf;
	}
	
	public static class ObservableCelsiusSensorProxy implements ObservableCelsiusSensor {

		public ObservableCelsiusSensorProxy(ObservableCelsiusSensor proxiedSensor) {
			// TODO Implement me
		}

		@Override
		public double getCurrentCelsius() {
			// TODO Implement me
			return 0;
		}

		@Override
		public String getSensorId() {
			// TODO Implement me
			return null;
		}

		// TODO implement further required methods
			
	}
	

	public ObservableCelsiusSensorProxy getHaermeleKopfBerg() {
		// TODO Implement me
		return null;
	}
	public ObservableCelsiusSensorProxy getHaermeleKopfTal() {
		// TODO Implement me
		return null;
	}
	public ObservableCelsiusSensorProxy getRosshuetteTal() {
		// TODO Implement me
		return null;
	}

	public ObservableCelsiusSensor getReitherAlm() {
		// TODO Implement me
		return null;
	}



	
}
