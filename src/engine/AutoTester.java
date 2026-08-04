package engine;

import components.*;

public class AutoTester {

    public static void runTruthTable(Parser p) {
        System.out.println("\n--- TRUTH TABLE GENERATION ---");

        for (String name : p.inputWires) System.out.print(name + " ");
        System.out.print(" ||  ");
        for (String name : p.outputWires) System.out.print(name + " ");
        System.out.println("\n-------------------------------------------");

        generateRows(p, 0);
    }

    private static void generateRows(Parser p, int index) {
        if (index == p.inputWires.size()) {
            for (String wireName : p.inputWires) {
                Wire w = (Wire) p.board.getGate(wireName);
                System.out.print((w.getOutput() ? 1 : 0) + " ");
            }

            System.out.print(" ||  ");
            p.board.simulate();

            for (String o : p.outputWires) {
                Gate g = p.board.getGate(o);
                String val = g.getOutput() ? "1" : "0";
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        String wireName = p.inputWires.get(index);
        Wire w = (Wire) p.board.getGate(wireName);
        w.setState(false);
        generateRows(p, index + 1);

        w.setState(true);
        generateRows(p, index + 1);
    }
}