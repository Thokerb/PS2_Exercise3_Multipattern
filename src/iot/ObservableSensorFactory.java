package iot;

import java.util.Arrays;
import java.util.List;

import interfaces.CelsiusSensor;
import interfaces.ObservableCelsiusSensor;

public class ObservableSensorFactory {


	protected ObservableSensorFactory() {
		super();
	}
	
	public static ObservableSensorFactory otsf = new ObservableSensorFactory();
	
	public static ObservableSensorFactory getInstance() {
		return otsf;
	}
	
	private PlainTestSensorFactory tsf = PlainTestSensorFactory.getInstance();
	

	public ObservableCelsiusSensor getHaermeleKopfBerg() {
		CelsiusSensor data = tsf.getHaermeleKopfBerg();
		return new ObservableSensor(data);
	}
	public ObservableCelsiusSensor getHaermeleKopfTal() {
		CelsiusSensor data = tsf.getHaermeleKopfTal();
		return new ObservableSensor(data);
	}
	public ObservableCelsiusSensor getRosshuetteTal() {
		CelsiusSensor data = tsf.getRosshuetteTal();
		return new ObservableSensor(data);
	}
	
	public ObservableCelsiusSensor getReitherAlm() {
		// TODO Implement me with task 5
		return null;
	}


	public List<ObservableCelsiusSensor> getAllSensors() {
		return Arrays.asList(getHaermeleKopfBerg(), getHaermeleKopfTal(), getRosshuetteTal()/*, getReitherAlm()*/);
	}


	
}
