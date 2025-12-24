package components;

public class Wire extends Gate{
    public Wire (String id){
        super(id);
        this.output=false;
    }
    public void setState(boolean output){
        this.output=output;
    }
    public void compute(){

    }
}
