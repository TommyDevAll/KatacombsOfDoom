package org.socrates;

public class LookCommand implements Command {

    private Console console;

    public LookCommand(Console console) {
        this.console = console;
    }

    public void execute(GameState gameState) {
        console.write("There is an exit to the north");
    }
}
