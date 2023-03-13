
public interface Programmable {
	
	// Name: Niyazi Ozan    Surname: Ateþ    no: 150121991
	// This is our Programmable interface. Which will be implemented by SmartLight and SmartPlug.
	
	// We got here three abstract methods that should be implemented by the class that implement the interface.
	// This method is made to turn off or on based on the given seconds.
	public abstract void setTimer(int seconds);
	
	// This method is created to cancel the timer that was made in setTimer.
	public abstract void cancelTimer();
	
	// The runProgram method check if the time has come of a smart object to turn on/off the object.
	// If it does match the current time that it should also turn on/off the object.
	public abstract void runProgram();
	
}
