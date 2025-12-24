package components;

import java.util.ArrayList;

public class NandGate extends Gate{
    public NandGate(String id){
        super(id);
    }
    @Override
    public void compute(){
        ArrayList<Boolean> in= getInput();
       if(in.isEmpty()){
        throw new IllegalStateException("Gate " + id + " (NAND) must have at least 1 input, but has " + in.size());
       }
        for(boolean i:in){
            if(!i){
                this.output=true;return;
            }
        }
        this.output=false;
    
    }
}
