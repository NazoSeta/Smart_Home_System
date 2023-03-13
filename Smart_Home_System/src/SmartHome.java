import java.util.ArrayList;

public class SmartHome {
	
	// Name: Niyazi Ozan    Surname: Ateþ    no: 150121991
	// This is our SmartHome class.
	// The purpose of this class is to hold the information and actions of all smart objects together in a house.
	
	// As data field we got an ArrayList that will hold all the smart objects together.
	private ArrayList<SmartObject> smartObjectList = new ArrayList<SmartObject>();
	
	// Here we create the constructor for the class.
	public SmartHome() {
		
	}
	
	// The addSmartObject adds a smart object to the array list that we had created. And connect the smart object with a proper IP adress.
	// After adding the smart object to the array list we print some output.
	// We do this thanks to some messages and methods that we had created.
	public boolean addSmartObject(SmartObject smartObject) {
		smartObjectList.add(smartObject);
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("Adding new SmartObject");
		System.out.println("---------------------------------------------------------------------------");
		smartObject.connect("10.0.0." + (99 + smartObjectList.size()));
		smartObject.testObject();
		System.out.println("");
		return true;
	}
	
	// The removeSmartObject removes the given smart object out of the array list.
	public boolean removeSmartObject(SmartObject smartObject) {
		if (smartObjectList.contains(smartObject)) {
			smartObjectList.remove(smartObject);
			return true;
		}
		else
			return false;
	}
	
	// The controlLocation checks if there is an instance of LocationControl.
	// If there is an instance of LocationControl then it will print the onCome or onLeave methods.
	// This is done based on the hasLightTurned data that the object got.
	public void controlLocation(boolean onCome) {
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("LocationControl: OnCome");
		System.out.println("---------------------------------------------------------------------------");
		for(int i = 0 ; i < smartObjectList.size() ; i++) {
			if(smartObjectList.get(i) instanceof LocationControl) {
				if(((SmartLight)smartObjectList.get(i)).isHasLightTurned()) {
					((SmartLight)smartObjectList.get(i)).onLeave();
				}
				else {
					((SmartLight)smartObjectList.get(i)).onCome();
				}
			}
		}
	}
	
	// The controlMotion checks if there is an instance of MotionControl.
	// If there is an instance of MotionControl then it will use the controlMotion method that the object got to print some things on the console.
	// The controlMotion of the object will have the parameters hasMotion and isDay.
	public void controlMotion(boolean hasMotion, boolean isDay) {
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("MotionControl: HasMotion, isDay");
		System.out.println("---------------------------------------------------------------------------");
		for(int i = 0 ; i < smartObjectList.size() ; i++) {
			if(smartObjectList.get(i) instanceof MotionControl) {
				((SmartCamera)smartObjectList.get(i)).controlMotion(hasMotion, isDay);
			}
		}
	}
	
	// The controlProgrammable checks if there is an instance of Programmable.
	// If there is an instance of Programmable then it will use the runProgram method that the object got to print some things on the console.
	public void controlProgrammable() {
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("Programmable: runProgram");
		System.out.println("---------------------------------------------------------------------------");
		for(int i = 0 ; i < smartObjectList.size() ; i++) {
			if(smartObjectList.get(i) instanceof SmartLight) {
				((SmartLight)smartObjectList.get(i)).runProgram();
			}
			if(smartObjectList.get(i) instanceof SmartPlug) {
				((SmartPlug)smartObjectList.get(i)).runProgram();
			}
		}
	}
	
	// The controlTimer checks if there is an instance of Programmable.
	// If there is an instance of Programmable, we will first check the parameter called seconds.
	// If the seconds is bigger than 0 then it will use the setTimer method that the object got to print some things on the console.
	// Otherwise if  the seconds is equal to 0 then it will use the cancelTimer method that the object got to cancel the timer.
	public void controlTimer(int seconds) {
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("Programmable: Timer = " + seconds + " seconds");
		System.out.println("---------------------------------------------------------------------------");	
		for(int i = 0 ; i < smartObjectList.size() ; i++) {
		if(seconds > 0) {
				if(smartObjectList.get(i) instanceof SmartLight) {
					((SmartLight)smartObjectList.get(i)).setTimer(seconds);
				}
				if(smartObjectList.get(i) instanceof SmartPlug) {
					((SmartPlug)smartObjectList.get(i)).setTimer(seconds);
				}
			}
		else if(seconds == 0) {
				if(smartObjectList.get(i) instanceof SmartLight) {
					((SmartLight)smartObjectList.get(i)).cancelTimer();;
				}
				if(smartObjectList.get(i) instanceof SmartPlug) {
					((SmartPlug)smartObjectList.get(i)).cancelTimer();;
				}
			}
	}
	}
	
	// This method is the same as the one above this. The only difference is that we choose the seconds.
	// The seconds are chosen randomly by the Math.random method and the only numbers we will get are 0, 5 and 10.
	public void controlTimerRandomly() {
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("Programmable: Timer = 0, 5 or 10 seconds randomly");
		System.out.println("---------------------------------------------------------------------------");
		for(int i = 0 ; i < smartObjectList.size() ; i++) {
		int seconds = ((int)(Math.random() * 3)) * 5;
		if(seconds > 0) {
				if(smartObjectList.get(i) instanceof SmartLight) {
					((SmartLight)smartObjectList.get(i)).setTimer(seconds);
				}
				if(smartObjectList.get(i) instanceof SmartPlug) {
					((SmartPlug)smartObjectList.get(i)).setTimer(seconds);
				}
			}
		else if(seconds == 0) {
				if(smartObjectList.get(i) instanceof SmartLight) {
					((SmartLight)smartObjectList.get(i)).cancelTimer();
				}
				if(smartObjectList.get(i) instanceof SmartPlug) {
					((SmartPlug)smartObjectList.get(i)).cancelTimer();
				}
			}
		}
	}
	
	// The sortCameras checks if there is an instance of Comparable.
	// If there is an instance of Comparable, we will first check the parameter called seconds.
	// These instances are all smart cameras. We will sort these cameras based on their battery life.
	// After sorting the smart cameras we print an output for the smart camera.
	public void sortCameras() {
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("Sort Smart Cameras");
		System.out.println("---------------------------------------------------------------------------");
		ArrayList<SmartCamera> smartCameraList = new ArrayList<SmartCamera>();
		for(int i = 0 ; i < smartObjectList.size() ; i++) {
			if(smartObjectList.get(i) instanceof SmartCamera) {
				smartCameraList.add(((SmartCamera)smartObjectList.get(i)));
			}
		}
		java.util.Collections.sort(smartCameraList);
		for(int i = 0 ; i < smartCameraList.size() ; i++) {
			System.out.println(smartCameraList.get(i).toString());
		}
	}

	// Here we got our getter/setter methods.
	public ArrayList<SmartObject> getSmartObjectList() {
		return smartObjectList;
	}

	public void setSmartObjectList(ArrayList<SmartObject> smartObjectList) {
		this.smartObjectList = smartObjectList;
	}
	
}
