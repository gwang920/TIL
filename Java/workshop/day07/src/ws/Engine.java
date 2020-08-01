package ws;
 
public class Engine {
    private int displacementvolume;
    private String enginetype;
 
    public Engine(int displacementvolume, String enginetype) {
        this.displacementvolume = displacementvolume;
        this.enginetype = enginetype;
    }
 
    @Override
    public String toString() {
        return "Engine [displacementvolume=" + displacementvolume + ", enginetype=" + enginetype + "]";
    }
    
}
