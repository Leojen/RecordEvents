import java.util.StringTokenizer;

public class Recorder {
	final int EVENT_MAX = 10;
			
	int xPos, yPos;
	String  eventType;
	EventInformation[] event = new EventInformation[EVENT_MAX];
	int xevent = 0;

	int previousHour = 0;
	int previousMinute = 0;
	int hourInt = 0;
	int minuteInt = 0;
	
	Recorder(int xPos, int yPos, String eventType)  {
		this.xPos = xPos;
		this.yPos = yPos;
		this.eventType = eventType;
	}
	public void recordEvent(String time, int datum) {
		if(validEvent(time) == true){
		
			if (xevent < EVENT_MAX) {
				event[xevent] = new EventInformation(time, datum);
				xevent++;
			}
			else {
				System.out.println("Event log overflow - terminating");
				System.exit(1);
			}
		}
		else{
			System.out.println("Invalid time format: " + time + ", ignoring event");
		}
	}
	void  printEvents ()  {
		System.out.println("Record of " + eventType + " events at [" + xPos + "," + yPos +"] " );
		for(int i = 0; i < xevent; i++) {
			System.out.println("Event number " + i + " was recorded at " + event[i].getTime() + " with datum = " + event[i].getDatum());
		}
	}
	boolean validEvent(String time){
		StringTokenizer timeStr = new StringTokenizer(time, ":");
		
		if (timeStr.countTokens() != 2){//checks for valid number of numbers
			return false;
		}
		
		String hour = timeStr.nextToken();
		String minute = timeStr.nextToken();
		
		try{
			hourInt = Integer.parseInt(hour);
			minuteInt = Integer.parseInt(minute);
		}
		catch(NumberFormatException e){
			return false;
		}
		
		if(xevent > 0){ //checks that there is already an entry before continuing
			
			if (previousHour > hourInt ){ //checks that the hour is later than the previous entry
				return false;
			}
			else if((previousHour == hourInt) && (previousMinute >= minuteInt)){ //checks that the minute is later than previous entry
				return false;
			}
		}
		
		if(hour.length() <= 0 || hour.length() > 2 || minute.length() <= 0 || minute.length() > 2){//checks if the hour and minute time lengths are valid
			return false;
		}
		else if(hourInt < 0 || hourInt > 23 || minuteInt < 0 || minuteInt > 59){//checks that the time is valid
			return false;
		}
		
		previousHour = hourInt;
		previousMinute = minuteInt;
		
		return true;
	}


}
