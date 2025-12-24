package components;

import java.util.ArrayList;

public class XorGate extends Gate {
    public XorGate(String id){
        super(id);
    }
    @Override
    public void compute(){
        ArrayList<Boolean> in= getInput();
       if(in.isEmpty()){
        throw new IllegalStateException("Gate " + id + " (XOR) must have at least 1 input, but has " + in.size());
       }
       int count=0;
        for(boolean i:in){
            if(i){
                count++;
            }
        }
        this.output = count%2 != 0;
        
    }
}
