package components;

import java.util.ArrayList;

public class NotGate extends Gate{
    public NotGate(String id){
        super(id);
    }
    @Override
    public void compute(){
        ArrayList<Boolean> in = getInput();
        if(in.size()!=1){
            throw new IllegalStateException("Gate " + id + " (NOT) must have only 1 input, but has " + in.size());
        }
        else {
            this.output=!in.get(0);
        }
        
    }
}
