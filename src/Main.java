import engine.*;

public class Main {
    public static void main(String[] args) {
        String filename="circuit.txt";
        if(args.length>0){
            filename=args[0];
        }
        Parser p = new Parser(filename);
        AutoTester.runTruthTable(p);
    }
}