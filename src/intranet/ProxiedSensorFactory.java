package intranet;

import interfaces.IIntranetObserver;
import interfaces.ObservableCelsiusSensor;
import iot.ObservableSensorFactory;
import iot.PlainTestSensorFactory;

public class ProxiedSensorFactory {

	protected ProxiedSensorFactory() {	}
	
	public static ProxiedSensorFactory otsf = new ProxiedSensorFactory();
	
	public static ProxiedSensorFactory getInstance() {
		return otsf;
	}
	private ObservableSensorFactory observableSensorFactory = ObservableSensorFactory.getInstance();
	
	public static class ObservableCelsiusSensorProxy implements ObservableCelsiusSensor {

		private ObservableCelsiusSensor proxiedSensor;

		public ObservableCelsiusSensorProxy(ObservableCelsiusSensor proxiedSensor) {
			this.proxiedSensor = proxiedSensor;
		}

		@Override
		public double getCurrentCelsius() {
			return proxiedSensor.getCurrentCelsius();
		}

		@Override
		public String getSensorId() {
			return proxiedSensor.getSensorId();
		}

		@Override
		public void registerObserver(IIntranetObserver observer) {
			proxiedSensor.registerObserver(observer);

		}

		@Override
		public void unregisterObserver(IIntranetObserver observer) {
			proxiedSensor.unregisterObserver(observer);

		}

		@Override
		public void notifyObserver() {
			proxiedSensor.notifyObserver();

		}

	}
	

	public ObservableCelsiusSensorProxy getHaermeleKopfBerg() {

		return new ObservableCelsiusSensorProxy(observableSensorFactory.getHaermeleKopfBerg());
	}
	public ObservableCelsiusSensorProxy getHaermeleKopfTal() {
		return new ObservableCelsiusSensorProxy(observableSensorFactory.getHaermeleKopfTal());

	}
	public ObservableCelsiusSensorProxy getRosshuetteTal() {
		return new ObservableCelsiusSensorProxy(observableSensorFactory.getRosshuetteTal());

	}

	public ObservableCelsiusSensor getReitherAlm() {
		return new ObservableCelsiusSensorProxy(observableSensorFactory.getReitherAlm());
	}



	
}
