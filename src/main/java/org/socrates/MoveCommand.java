package org.socrates;

public class MoveCommand implements Command{
    private Direction direction;
    private Console console;

    public MoveCommand(Direction direction, Console console) {
        this.direction = direction;
        this.console = console;
    }

    @Override
    public void execute(GameState gameState) {
        gameState.move(direction);
        console.write("You are in " + gameState.currentRoom().name());
    }
}
