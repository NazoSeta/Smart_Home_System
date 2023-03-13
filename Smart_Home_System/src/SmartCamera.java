
public class SmartCamera extends SmartObject implements MotionControl, Comparable<SmartCamera>{
	
	// Name: Niyazi Ozan    Surname: Ateþ    no: 150121991
	// This is our SmartCamera class. Which is a subclass of SmartObject and implements the interfaces MotionControl and Comparable.
	// The purpose of this class is to hold information and make actions of a smart camera.
	
	// These are the data fields that we use for this class.
	private boolean status;
	private int batteryLife;
	private boolean nightVision;
	
	// Here we create the constructor with four data needed for the smart camera.
	public SmartCamera(String alias, String macId, boolean nightVision, int batteryLife) {
		super.setAlias(alias);
		super.setMacId(macId);
		setNightVision(nightVision);
		setBatteryLife(batteryLife);
	}
	
	// This method is used to start recording a smart camera. It will check first the isDay and nightVision data's.
	// Based on that information it will check the status of the camera. Thanks to the status we can see if it has already started the recording.
	// Now we can print a proper output and update the status data field.
	public void recordOn(boolean isDay) {
		if(super.isConnectionStatus()) {
			if(!isDay && !nightVision) {
				System.out.println("Sorry! Smart Camera - " + super.getAlias() + " does not have night vision feature.");
	}
			else {
				if(status) {
					System.out.println("Smart Camera - " + super.getAlias() + " has been already turned on");
				}
				else {
					System.out.println("Smart Camera - " + super.getAlias() + " is turned on now");
					status = true;
				}
				}
	}
	}
	
	// This method is used to stop recording a smart camera. It will first check the status of the camera.
	// Thanks to the status we can see if it has already stopped the recording.
	// Based on that information it will print a proper output and update the status data field.
	public void recordOff() {
		if(super.isConnectionStatus()) {
			if(status){
				System.out.println("Smart Camera - " + super.getAlias() + " is turned off now");
				status = false;
			}
			else {
				System.out.println("Smart Camera - " + super.getAlias() + " has been already turned off");
			}
		}
	}
	
	// The method testObject test the functionalities of the smart camera by invoking the given methods as below.
	// It will give an output based on the methods and messages as below.
	public boolean testObject() {
		if(super.isConnectionStatus()) {
			System.out.println("Test is starting for SmartCamera");
			super.SmartObjectToString();
			System.out.println("Test is starting for SmartCamera day time");
			recordOn(true);
			recordOff();
			System.out.println("Test is starting for SmartCamera night time");
			recordOn(false);
			recordOff();
			System.out.println("Test completed for SmartCamera");
			return true;
		}
		else
			return false;
	}
	
	// This method shuts down the recording of a smart camera. It will give give a proper output based on the SmartObjectToString and recordOff methods.
	public boolean shutDownObject() {
		if(super.isConnectionStatus()) {
			super.SmartObjectToString();
			recordOff();
			return true;
		}
		else
			return false;
	}
	
	// The controlMotion method checks whenever there is a motion or not. It does check first if there is a motion or not by checking the hasMotion data.
	// After checking that it checks if its daytime, if so it will start to record if not we have to check one more thing.
	// If its night time than we have to check if we got a nightVision on the camera or not. If we do its starts to record.
	public boolean controlMotion(boolean hasMotion, boolean isDay) {
		if(hasMotion) {
			System.out.println("Motion detected!");
			if(isDay) {
				recordOn(isDay);
				return true;
			}
			else if(nightVision) {
				recordOn(isDay);
				return true;
			}
			else
				return false;
		}
		else {
			System.out.println("Motion not detected!");
			return false;
		}
	}
	
	// Here we override the compareTo method of the interface Comparable.
	// We compare the batteryLife data and put them all in order when we invoke this method from an another class.
	public int compareTo(SmartCamera smartCamera) {
		if(batteryLife > smartCamera.getBatteryLife()) {
			return 1;
		}
		else if(batteryLife == smartCamera.getBatteryLife()) {
			return 0;
		}
		else {
			return -1;
		}
	}
	
	// Here we got our overridden toString method.
	public String toString() {
		return ("SmartCamera -> " + super.getAlias() + "'s battery life is " + batteryLife + " status is recording");
	}

	// Here we got our getter/setter methods.
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getBatteryLife() {
		return batteryLife;
	}

	public void setBatteryLife(int batteryLife) {
		this.batteryLife = batteryLife;
	}

	public boolean isNightVision() {
		return nightVision;
	}

	public void setNightVision(boolean nightVision) {
		this.nightVision = nightVision;
	}
	
}
