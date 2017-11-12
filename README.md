# cellular-automata
My implementations of various cellular automata

# Implementations
* Conway's Game of Life
* Langton's Ant
* Brian's Brain
* Rule 90

# Keybindings
`q`: Quit

`r`: Reset the current automaton

'b': Go to previous automaton

'n': Go to next automaton

Left arrow: Doube steps between display updates

Right arrow: Halve steps between display updates

Up arrow: Halve time between steps

Down arrow: Double time between steps

# How to run
Compile with Maven
```Bash
$ mvn package
```

Run the jar
```Bash
$ java -cp target/cellular-automata-1.0-SNAPSHOT.jar com.cells.App
```

To generate files for Intellij:
```Bash
$ mvn idea:idea
```

To generate files for Eclipse:
```Bash
$ mvn eclipse:eclipse
```
