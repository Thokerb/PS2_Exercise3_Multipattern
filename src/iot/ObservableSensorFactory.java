package iot;

import java.util.Arrays;
import java.util.List;

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
		// TODO Implement me
		return null;
	}
	public ObservableCelsiusSensor getHaermeleKopfTal() {
		// TODO Implement me
		return null;
	}
	public ObservableCelsiusSensor getRosshuetteTal() {
		// TODO Implement me
		return null;
	}
	
	public ObservableCelsiusSensor getReitherAlm() {
		// TODO Implement me with task 5
		return null;
	}


	public List<ObservableCelsiusSensor> getAllSensors() {
		return Arrays.asList(getHaermeleKopfBerg(), getHaermeleKopfTal(), getRosshuetteTal(), getReitherAlm());
	}


	
}
