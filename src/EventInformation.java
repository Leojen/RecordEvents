//import java.util.StringTokenizer;

public class EventInformation {
	private String eventTime;
	private int eventDatum;
	
	EventInformation(String eventTime, int eventDatum){
		setTime(eventTime);
		setDatum(eventDatum);
	}
	
	public String getTime(){
		return eventTime;
	}
	
	public int getDatum(){
		return eventDatum;
	}
	
	public void setTime(String eventTime){
		this.eventTime = eventTime;
	}
	
	public void setDatum(int eventDatum){
		this.eventDatum = eventDatum;
	}
}
