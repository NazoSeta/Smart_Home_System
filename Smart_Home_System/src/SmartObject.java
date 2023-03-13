
public abstract class SmartObject {
	
	// Name: Niyazi Ozan    Surname: Ateþ    no: 150121991
	// This is our SmartObject class. Which is a superclass of SmartLight, SmartPlug and SmartCamera.
	// The class is made to create subclasses for some smart objects.
	
	// These are the data fields that we use for this class.
	private String alias;
	private String macId;
	private String IP;
	private boolean connectionStatus;
	
	// Here we create the constructor for the class.
	public SmartObject() {
		
	}
	
	// With the connect method we connect the smart object with the given IP and also update the connectionStatus.
	public boolean connect(String IP) {
		setIP(IP);
		setConnectionStatus(true);
		System.out.println(alias + " connection established");
		return true;
	}
	
	// The disconnect method does to exact opposite of the connect method. It again update the connectionStatus.
	public boolean disconnect() {
		setConnectionStatus(false);
		return true;
	}
	
	// With this method we print some information that we got about the smart object.
	public void SmartObjectToString() {
		System.out.println("This is " + this.getClass().getSimpleName() + " device " + alias);
		System.out.println("\tMacId: " + macId);
		System.out.println("\tIP: " + IP);
	}
	
	// This method is made to check the connectionStatus.
	public boolean controlConnection() {
		if(connectionStatus) {
			System.out.println("connection established");
			return true;
		}
		else {
			System.out.println("This device is not connected. " + this.getClass().getSimpleName() + " -> " + alias);
			return false;
		}
	}
	
	// We got two abstract methods which must be implemented in the subclasses of SmartObject.
	public abstract boolean testObject();
	
	public abstract boolean shutDownObject();

	// Here we got our getter/setter methods.
	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getMacId() {
		return macId;
	}

	public void setMacId(String macId) {
		this.macId = macId;
	}

	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}

	public boolean isConnectionStatus() {
		return connectionStatus;
	}

	public void setConnectionStatus(boolean connectionStatus) {
		this.connectionStatus = connectionStatus;
	}
	
	
	
}
