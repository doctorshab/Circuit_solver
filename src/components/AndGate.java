package components;

import java.util.ArrayList;

public class AndGate extends Gate {
    public AndGate(String id){
        super(id);
    }
    @Override
    public void compute(){
        ArrayList<Boolean> in= getInput();
       if(in.isEmpty()){
        throw new IllegalStateException("Gate " + id + " (AND) must have at least 1 input, but has " + in.size());
       }
        for(boolean i:in){
            if(!i){
                this.output=false;return;
            }
        }
        this.output=true;
    }
}
