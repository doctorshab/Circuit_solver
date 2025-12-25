Logic Circuit Simulator
=======================

A Java-based logic circuit simulator that parses circuit descriptions from text files 
and generates truth tables automatically.

HOW TO RUN
----------
1. Compile the code:
   javac -d bin src/components/*.java src/engine/*.java src/Main.java

2. Run the simulator with an input file:
   java -cp bin Main full_adder.txt

COMMANDS
--------
1. input [names]
   Defines input wires for the circuit.
   Example: input A B Cin

2. [gate_type] [names]
   Creates gates. Supported types: and, or, nand, xor, not, wire.
   Example: and gate1 gate2

3. connect [sources...] [destination]
   Connects one or more source wires/gates to a destination gate.
   The LAST item in the line is the destination.
   Example: connect A B gate1  
   (Connects A and B into gate1)

4. trace [name]
   Marks a specific wire or gate to be printed in the final output/truth table.
   Example: trace Sum

SAMPLE CIRCUIT (Full Adder)
---------------------------
input A B Cin
xor x1 Sum
and a1 a2
or Cout
connect A B x1
connect x1 Cin Sum
connect A B a1
connect x1 Cin a2
connect a1 a2 Cout
trace Sum
trace Cout