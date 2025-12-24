import components.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- CIRCUIT START ---");

        Wire wireA = new Wire("Wire_A");
        Wire wireB = new Wire("Wire_B");

        AndGate andGate = new AndGate("AND_1");

        andGate.addInput(wireA);
        andGate.addInput(wireB);

        wireA.setState(false);
        wireB.setState(false);
        andGate.compute();
        System.out.println("0 AND 0 = " + andGate.getOutput());

        wireA.setState(true);
        andGate.compute(); 
        System.out.println("1 AND 0 = " + andGate.getOutput());

        wireB.setState(true);
        andGate.compute(); 
        System.out.println("1 AND 1 = " + andGate.getOutput());
        
        System.out.println("--- CIRCUIT END ---");
    }
}