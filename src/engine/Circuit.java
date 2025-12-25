package engine;
import components.*;
import java.util.HashMap;

public class Circuit{
    private HashMap<String,Gate> gates;
    public Circuit(){
        this.gates=new HashMap<>();
    }
    public void addComponent(Gate g){
        gates.put(g.getId(), g);
    }
    public Gate getGate(String id){
        return gates.get(id);
    }
    public void connectComponents(String id1,String id2){
        Gate g1=getGate(id1);Gate g2=getGate(id2);
        if (g1 == null) {
            throw new IllegalArgumentException("Source component not found: " + id1);
        }
        if (g2 == null) {
            throw new IllegalArgumentException("Target component not found: " + id2);
        }
        g2.addInput(g1);
    }
    public void simulate() {
        for(int i=0;i<gates.size();i++){
            for (Gate g : gates.values()) {
                g.compute();
            }
        }
    }
}