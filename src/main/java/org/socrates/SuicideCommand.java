package org.socrates;

public class SuicideCommand implements Command {

    private Console console;

    public SuicideCommand(Console console) {
        this.console = console;
    }

    public void execute(GameState gameState) {
        console.write("See you in hell.");
    }
}
