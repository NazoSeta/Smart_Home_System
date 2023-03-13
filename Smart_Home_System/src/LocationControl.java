
public interface LocationControl {
	
	// Name: Niyazi Ozan    Surname: Ateþ    no: 150121991
	// This is our LocationControl interface. Which will be implemented by SmartLight.
	
	// We got here two abstract methods that should be implemented by the class that implement the interface.
	// The onLeave Method is made to turn off a smart object when someone leaves.
	public abstract void onLeave();
	
	// The onCome Method is made to turn on a smart object when someone comes.
	public abstract void onCome();
	
}
