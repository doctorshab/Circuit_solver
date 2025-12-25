package components;

import java.util.ArrayList;

public abstract class Gate {
    private ArrayList<Gate> inputGates;
    
    protected boolean output;
    protected String id;

    public Gate(String id){
        this.id = id;
        this.inputGates = new ArrayList<>(); 
    }

    public void addInput(Gate g){
        inputGates.add(g);
    }
    public String getId(){
        return id;
    }

    public boolean getOutput(){
        return output;
    }
    protected ArrayList<Boolean> getInput(){
        ArrayList<Boolean> currentValues = new ArrayList<>();
        for(Gate g : inputGates) {
            currentValues.add(g.getOutput());
        }
        return currentValues;
    } 

    public abstract void compute();
}