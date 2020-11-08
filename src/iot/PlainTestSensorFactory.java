package iot;

import java.util.Arrays;
import java.util.List;
import interfaces.FahrenheitSensor;
import interfaces.CelsiusSensor;

/**
 * Implements a factory of test sensors.
 * <ul>
 *   <li><code>getHaermeleKopfBerg()</code> in Celsius</li>
 *   <li><code>getHaermeleKopfTal()</code> in Celsius</li>
 *   <li><code>getRossHuetteTal()</code> in Celsius</li>
 *   <li><code>getReitherAlm()</code> in Fahrenheit</li>
 * </ul>
 * In order to have fast tests, sensors change their values every second.
 * @author Michael Breu
 *
 */
public class PlainTestSensorFactory {
	enum Direction {up,down}
	
	private static long testStartTimeMsec = System.currentTimeMillis();
	
	private PlainTestSensorFactory() {	}
	
	public static PlainTestSensorFactory otsf = new PlainTestSensorFactory();
	
	public static PlainTestSensorFactory getInstance() {
		return otsf;
	}

	/**
	 * simple test sensor that oscillates between an minumum and an maximum temperature in 0.5 steps.
	 * @author Michael Breu
	 *
	 */
	private class DumbTestSensor implements CelsiusSensor {
		
		/**
		 *  minumum temperature
		 */
		private double min;
		/**
		 *  minimum temperature
		 */
		private double max;
		
		final static double minDiff = 0.5;
		
		private long changeDelayInMsec; 

		final long stepsPerTurnaround;

		final String sensorId;
		

		private DumbTestSensor(double min, double max, long changeDelayInMsec, String sensorId) {
			super();
			this.min = min;
			this.max = max;
			this.changeDelayInMsec = changeDelayInMsec;
			this.sensorId = sensorId;
			
			stepsPerTurnaround = Math.round(Math.floor(max-min) / minDiff);
		}

		public String getSensorId() {
			return sensorId;
		}

		@Override
		public double getCurrentCelsius() {
			long currentMillis = System.currentTimeMillis();
			long usedSteps = (currentMillis - testStartTimeMsec) / changeDelayInMsec ;
			long alreadyCompletedTurnArounds = usedSteps / (2*stepsPerTurnaround);
			long stepsInCurrentGoArround = usedSteps - (alreadyCompletedTurnArounds * 2 * stepsPerTurnaround);
			
			if(stepsInCurrentGoArround <= stepsPerTurnaround) {
				// going up
				return min + minDiff * stepsInCurrentGoArround;
			} else {
				// going down
				return max - minDiff * (stepsInCurrentGoArround - stepsPerTurnaround);
			}
		}
		

	}
	/**
	 * just wraps a Celsius-Sensor and returns the Fahrenheit :-)
	 * @author Michael Breu
	 *
	 */
	public class LazyTestFahrenheitSensor implements FahrenheitSensor {

		private CelsiusSensor internalSensor;
		
		public LazyTestFahrenheitSensor(CelsiusSensor internalSensor) {
			super();
			this.internalSensor = internalSensor;
		}

		@Override
		public double getCurrentFahrenheit() {
			return internalSensor.getCurrentCelsius() * 9.0d/5.0d + 32.0d;
		}

		@Override
		public String getSensorId() {
			return internalSensor.getSensorId() + " (in Fahrenheit)";
		}
		
	}
	private DumbTestSensor haermeleKopfBergVeryFast = new DumbTestSensor(-20.0d, 0.0d, 50L, " Test sensor for internal testing"); // changes 0.5 degree every 0.1 second

	private DumbTestSensor haermeleKopfBerg = new DumbTestSensor(-20.0d, 0.0d, 500L, "HaermeleKopf Berg"); // changes 1 degree every 1 second
	private DumbTestSensor haermeleKopfTal = new DumbTestSensor(-15.0d, 5.0d, 500L, "HaermeleKopf Tal"); // changes 1 degree every 1 second
	private DumbTestSensor rosshuetteTal = new DumbTestSensor(-10.0d, 6.0d, 500L, "Rosshuette Tal"); // changes about 1 degree every 1 second
	private FahrenheitSensor reitherAlm = new LazyTestFahrenheitSensor(new DumbTestSensor(-18.0d, 0.0d, 500L, "Reither Alm"));  // changes about 1 degree every 1 second


	public DumbTestSensor getHaermeleKopfBergVeryFast() {
		return haermeleKopfBergVeryFast;
	}


	public CelsiusSensor getHaermeleKopfBerg() {
		return haermeleKopfBerg;
	}


	public CelsiusSensor getHaermeleKopfTal() {
		return haermeleKopfTal;
	}


	public CelsiusSensor getRosshuetteTal() {
		return rosshuetteTal;
	}
	
	public FahrenheitSensor getReitherAlm() {
		return reitherAlm;
	}
	
	public List<CelsiusSensor> getAllSensors() {
		return Arrays.asList(getHaermeleKopfBerg(), getHaermeleKopfTal(), getRosshuetteTal());
	}

}
