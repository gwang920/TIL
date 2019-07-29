package ws;

public class Exengine {
	
	private int volume;
	private int enginetype;
	
	public Exengine(int volume,int enginetype) {
		this.volume=volume;
		this.enginetype=enginetype;
	}
	@Override
	public String toString() {
		return "Exengine [volume=" + volume + ", enginetype=" + enginetype + "]";
	}
	
}
