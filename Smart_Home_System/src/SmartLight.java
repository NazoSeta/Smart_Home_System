import java.util.Calendar;

public class SmartLight extends SmartObject implements LocationControl, Programmable{
	
	// Name: Niyazi Ozan    Surname: Ateþ    no: 150121991
	// This is our SmartLight class. Which is a subclass of SmartObject and implements the interfaces LocationControl and Programmable.
	// The purpose of this class is to hold information and make actions of a smart light.
	
	// These are the data fields that we use for this class.
	private boolean hasLightTurned;
	private Calendar programTime;
	private boolean programAction;
	
	// Here we create the constructor with two data needed for the smart light.
	public SmartLight(String alias, String macId) {
		super.setAlias(alias);
		super.setMacId(macId);
	}
	
	// This method is used to turn on the smart light. It will check first if it is already on or not.
	// Based on that information it will print a proper output and update the hasLightTurned data field.
	public void turnOnLight() {
		if(super.isConnectionStatus()) {
		if(hasLightTurned) {
		System.out.println("Smart Light - " + super.getAlias() + " has been already turned on");
		}
		else { 
			System.out.println("Smart Light - " + super.getAlias() + " is turned on now (Current time: " + Calendar.getInstance().get(Calendar.HOUR) + ":" + Calendar.getInstance().get(Calendar.MINUTE) + ":" + Calendar.getInstance().get(Calendar.SECOND) + ")");
			hasLightTurned = true;
		}
		}
	}
	
	// This method is used to turn off the smart light. It will check first if it is already off or not.
	// Based on that information it will print a proper output and update the hasLightTurned data field.
	public void turnOffLight() {
		if(super.isConnectionStatus()) {
			if(hasLightTurned) {
				System.out.println("Smart Light - " + super.getAlias() + " is turned off now (Current time: " + Calendar.getInstance().get(Calendar.HOUR) + ":" + Calendar.getInstance().get(Calendar.MINUTE) + ":" + Calendar.getInstance().get(Calendar.SECOND) + ")");
				hasLightTurned = false;
			}
			else {
				System.out.println("Smart Light - " + super.getAlias() + " has been already turned off");
			}
			}
	}
	
	// The method testObject test the functionalities of the smart light by invoking the given methods as below.
	// It will give an output based on the methods and messages as below.
	public boolean testObject() {
		if(super.isConnectionStatus()) {
			System.out.println("Test is starting for SmartLight");
			super.SmartObjectToString();
			turnOnLight();
			turnOffLight();
			System.out.println("Test completed for SmartLight");
			return true;
		}
		else
			return false;
	}
	
	// This method shuts down the light of a smart light. It will give give a proper output based on the SmartObjectToString and turnOffLight methods.
	public boolean shutDownObject() {
		if(super.isConnectionStatus()) {
			super.SmartObjectToString();
			turnOffLight();
			return true;
		}
		else
			return false;
	}
	
	// This method should turn off the lights with an extra output message.
	public void onLeave() {
		if(super.isConnectionStatus()) {
			System.out.println("On Leave -> Smart Light - " + super.getAlias());
			turnOffLight();
		}
	}
	// This method should turn on the lights with an extra output message.
	public void onCome() {
		if(super.isConnectionStatus()) {
			System.out.println("On Come -> Smart Light - " + super.getAlias());
			turnOnLight();
		}
	}
	
	// The setTimer method will set a timer to turn on/off a smart light after a given number of seconds.
	// Here we update the programTime to hold how long it should wait to turn on/off.
	// Also based on the hasLightTurned data it will print a proper output and update the programAction data based.
	public void setTimer(int seconds) {
		if(super.isConnectionStatus()) {
			programTime = Calendar.getInstance();
			programTime.add(Calendar.SECOND, seconds);
			if(hasLightTurned) {
				System.out.println("Smart Light - " + super.getAlias() + " will be turned off " + seconds + " seconds later! (Current time: " + Calendar.getInstance().get(Calendar.HOUR) + ":" + Calendar.getInstance().get(Calendar.MINUTE) + ":" + Calendar.getInstance().get(Calendar.SECOND) + ")");
				programAction = false;
			}
			else {
				System.out.println("Smart Light - " + super.getAlias() + " will be turned on " + seconds + " seconds later! (Current time: " + Calendar.getInstance().get(Calendar.HOUR) + ":" + Calendar.getInstance().get(Calendar.MINUTE) + ":" + Calendar.getInstance().get(Calendar.SECOND) + ")");
				programAction = true;
			}
		}
	}
	
	// The cancelTimer method cancels the timer that was created in setTimer.
	// It cancels it by assigning the programTime to null.
	public void cancelTimer() {
		if(super.isConnectionStatus()) {
			programTime = null;
		}
	}
	
	// This method will check if it has to turn on/off the smart light based on the programTime equals to the current time.
	// It will be check first by the equality in time and the by the programAction to give a proper output.
	// After it is turned on/off the programTime will be set null.
	public void runProgram() {
		if(super.isConnectionStatus()) {
			if(programTime != null) {
				if (programTime.get(Calendar.SECOND) == (Calendar.getInstance().get(Calendar.SECOND))) {
			if(programAction) {
				System.out.println("RunProgram -> Smart Light - " + super.getAlias());
				turnOnLight();
			}
			else {
				System.out.println("RunProgram -> Smart Light - " + super.getAlias());
				turnOffLight();
			}
			programTime = null;
		}
			}
		}
	}

	// Here we got our getter/setter methods.
	public boolean isHasLightTurned() {
		return hasLightTurned;
	}

	public void setHasLightTurned(boolean hasLightTurned) {
		this.hasLightTurned = hasLightTurned;
	}

	public Calendar getProgramTime() {
		return programTime;
	}

	public void setProgramTime(Calendar programTime) {
		this.programTime = programTime;
	}

	public boolean isProgramAction() {
		return programAction;
	}

	public void setProgramAction(boolean programAction) {
		this.programAction = programAction;
	}
	
}
