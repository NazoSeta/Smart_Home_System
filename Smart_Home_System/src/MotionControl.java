
public interface MotionControl {
	
	// Name: Niyazi Ozan    Surname: Ateþ    no: 150121991
	// This is our MotionControl interface. Which will be implemented by SmartCamera.
	
	// We got here one abstract methods that should be implemented by the class that implement the interface.
	// This method is  used to check if there is a motion captured by hasMotion. If there is a motion captured then it should also check the isDay data.
	// Based on these conditions it should start to record or not.
	public abstract boolean controlMotion(boolean hasMotion, boolean isDay);
	
}
