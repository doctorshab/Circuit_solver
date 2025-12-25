package engine;

import components.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser {
    public Circuit board;
    public ArrayList<String> inputWires;
    public ArrayList<String> outputWires;

    public Parser(String filepath) {
        this.board = new Circuit();
        this.inputWires = new ArrayList<>();
        this.outputWires = new ArrayList<>();

        try {
            File file = new File(filepath);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty() || line.startsWith("#")) continue;

                String[] parts = line.split("\\s+");
                String command = parts[0].toLowerCase();

                if (command.equals("input")) {
                    for(int i=1;i<parts.length;i++) {
                    if(board.getGate(parts[i])!=null) throw new IllegalArgumentException("Duplicate  wire: " + parts[i]);
                    board.addComponent(new Wire(parts[i]));
                    inputWires.add(parts[i]); 
                    }
                } 
                else if (command.equals("wire")) {
                    for(int i=1;i<parts.length;i++) {
                    if(board.getGate(parts[i])!=null) throw new IllegalArgumentException("Duplicate  wire: " + parts[i]);
                    board.addComponent(new Wire(parts[i]));
                    }
                } 
                else if (command.equals("and")) {
                    for(int i=1;i<parts.length;i++) {
                    if(board.getGate(parts[i])!=null) throw new IllegalArgumentException("Duplicate  AND gate: " + parts[i]);
                    board.addComponent(new AndGate(parts[i]));
                    }
                } 
                else if (command.equals("or")) {
                    for(int i=1;i<parts.length;i++) {
                    if(board.getGate(parts[i])!=null) throw new IllegalArgumentException("Duplicate  OR gate: " + parts[i]);
                    board.addComponent(new OrGate(parts[i]));
                    }
                } 
                else if (command.equals("nand")) {
                    for(int i=1;i<parts.length;i++) {
                    if(board.getGate(parts[i])!=null) throw new IllegalArgumentException("Duplicate  NAND gate: " + parts[i]);
                    board.addComponent(new NandGate(parts[i]));
                    }
                } 
                else if (command.equals("xor")) {
                   for(int i=1;i<parts.length;i++) {
                    if(board.getGate(parts[i])!=null) throw new IllegalArgumentException("Duplicate  XOR gate: " + parts[i]);
                    board.addComponent(new XorGate(parts[i]));
                    }
                } 
                else if (command.equals("not")) {
                    for(int i=1;i<parts.length;i++) {
                    if(board.getGate(parts[i])!=null) throw new IllegalArgumentException("Duplicate  NOT gate: " + parts[i]);
                    board.addComponent(new NotGate(parts[i]));
                    }
                } 
                else if (command.equals("connect")) {
                    int n=parts.length-1;
                    for(int i=1;i<n;i++) {
                    board.connectComponents(parts[i], parts[n]);
                    }
                } 
                else if (command.equals("trace")) {
                    for(int i=1;i<parts.length;i++) {
                    if(outputWires.contains(parts[1])) continue;
                    outputWires.add(parts[1]);
                    }
                } 
                else {
                    System.out.println("Unknown command: " + parts[0]);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filepath);
        }
    }
}