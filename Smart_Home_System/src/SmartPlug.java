import java.util.Calendar;

public class SmartPlug extends SmartObject implements Programmable {
	
	// Name: Niyazi Ozan    Surname: Ateþ    no: 150121991
	// This is our SmartPlug class. Which is a subclass of SmartObject and implements the interface Programmable.
	// The purpose of this class is to hold information and make actions of a smart plug.
	
	// These are the data fields that we use for this class.
	private boolean status;
	private Calendar programTime;
	private boolean programAction;
	
	// Here we create the constructor with two data needed for the smart plug.
	public SmartPlug(String alias, String macId) {
		super.setAlias(alias);
		super.setMacId(macId);
	}
	
	// This method is used to turn on the smart plug. It will check first if it is already on or not.
	// Based on that information it will print a proper output and update the status data field.
	public void turnOn() {
		if(super.isConnectionStatus()) {
		if(status) {
		System.out.println("Smart Plug - " + super.getAlias() + "has been already turned on");
		}
		else { 
			System.out.println("Smart Plug - " + super.getAlias() + " is turned on now (Current time: " + Calendar.getInstance().get(Calendar.HOUR) + ":" + Calendar.getInstance().get(Calendar.MINUTE) + ":" + Calendar.getInstance().get(Calendar.SECOND) + ")");
			status = true;
		}
		}
	}
	
	// This method is used to turn off the smart plug. It will check first if it is already off or not.
	// Based on that information it will print a proper output and update the status data field.
	public void turnOff() {
		if(super.isConnectionStatus()) {
			if(status) {
				System.out.println("Smart Plug - " + super.getAlias() + " is turned off now (Current time: " + Calendar.getInstance().get(Calendar.HOUR) + ":" + Calendar.getInstance().get(Calendar.MINUTE) + ":" + Calendar.getInstance().get(Calendar.SECOND) + ")");
				status = false;
			}
			else {
				System.out.println("Smart Plug - " + super.getAlias() + "has been already turned off");
			}
			}
	}
	
	// The method testObject test the functionalities of the smart plug by invoking the given methods as below.
	// It will give an output based on the methods and messages as below.
	public boolean testObject() {
		if(super.isConnectionStatus()) {
			System.out.println("Test is starting for SmartPlug");
			super.SmartObjectToString();
			turnOn();
			turnOff();
			System.out.println("Test completed for SmartPlug");
			return true;
		}
		else
			return false;
	}
	
	// This method shuts down the plug of a smart plug. It will give give a proper output based on the SmartObjectToString and turnOff methods.
	public boolean shutDownObject() {
		if(super.isConnectionStatus()) {
			super.SmartObjectToString();
			turnOff();
			return true;
		}
		else
			return false;
	}
	
	// The setTimer method will set a timer to turn on/off a smart plug after a given number of seconds.
	// Here we update the programTime to hold how long it should wait to turn on/off.
	// Also based on the status data it will print a proper output and update the programAction data based.
	public void setTimer(int seconds) {
		if(super.isConnectionStatus()) {
			programTime = Calendar.getInstance();
			programTime.add(Calendar.SECOND, seconds);
			if(status) {
				System.out.println("Smart plug - " + super.getAlias() + " will be turned off " + seconds + " seconds later! (Current time: " + Calendar.getInstance().get(Calendar.HOUR) + ":" + Calendar.getInstance().get(Calendar.MINUTE) + ":" + Calendar.getInstance().get(Calendar.SECOND) + ")");
				programAction = false;
			}
			else {
				System.out.println("Smart plug - " + super.getAlias() + " will be turned on " + seconds + " seconds later! (Current time: " + Calendar.getInstance().get(Calendar.HOUR) + ":" + Calendar.getInstance().get(Calendar.MINUTE) + ":" + Calendar.getInstance().get(Calendar.SECOND) + ")");
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
	
	// This method will check if it has to turn on/off the smart plug based on the programTime equals to the current time.
	// It will be check first by the equality in time and the by the programAction to give a proper output.
	// After it is turned on/off the programTime will be set null.
	public void runProgram() {
		if(super.isConnectionStatus()) {
			if(programTime != null) {
				if (programTime.get(Calendar.SECOND) == (Calendar.getInstance().get(Calendar.SECOND))) {
			if(programAction) {
				System.out.println("RunProgram -> Smart Plug - " + super.getAlias());
				turnOn();
			}
			else {
				System.out.println("RunProgram -> Smart Plug - " + super.getAlias());
				turnOff();
			}
			programTime = null;
		}
			}
		}
	}

	// Here we got our getter/setter methods.
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
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
