package org.socrates.implementation;

import org.socrates.*;

import java.util.Optional;

import static org.socrates.Direction.*;

/**
 * Created by tresti on 18.06.17.
 */
public class DefaultTextCommandFactory implements TextCommandFactory {

    private GameState gameState;
    private Console console;

    public DefaultTextCommandFactory(GameState gameState, Console console) {
        this.gameState = gameState;
        this.console = console;
    }

    @Override
    public Optional<Command> make(String command) {
        if ("Look".equals(command)) {
            return Optional.of(new LookCommand(console));
        }
        if ("Move North".equals(command)) {
            return Optional.of(new MoveCommand(NORTH, console));
        }
        if ("Move South".equals(command)) {
            return Optional.of(new MoveCommand(SOUTH, console));
        }
        if ("Move East".equals(command)) {
            return Optional.of(new MoveCommand(EAST, console));
        }
        if ("Move West".equals(command)) {
            return Optional.of(new MoveCommand(WEST, console));
        }
        if ("Suicide".equals(command)) {
            return Optional.of(new SuicideCommand(console));
        }
        return Optional.empty();
    }
}
