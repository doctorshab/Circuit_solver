package engine;

import components.*;

public class AutoTester {

    public static void runTruthTable(Parser p) {
        System.out.println("\n--- TRUTH TABLE GENERATION ---");

        for (String name : p.inputWires) System.out.print(name + " ");
        System.out.print(" ||  ");
        for (String name : p.outputWires) System.out.print(name + " ");
        System.out.println("\n-------------------------------------------");

        int totalRows = (int) Math.pow(2, p.inputWires.size());

        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; j < p.inputWires.size(); j++) {
                String wireName = p.inputWires.get(j);
                Wire w = (Wire) p.board.getGate(wireName);
                int bit = (i >> (p.inputWires.size()-(j+1))) & 1;
                
                w.setState(bit == 1);
                System.out.print(bit + " ");
            }

            System.out.print(" ||  ");
            p.board.simulate();

            for (String o : p.outputWires) {
                Gate g = p.board.getGate(o);
                String val = g.getOutput() ? "1" : "0";
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}