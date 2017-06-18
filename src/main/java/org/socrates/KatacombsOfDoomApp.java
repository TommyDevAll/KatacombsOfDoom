package org.socrates;

import org.socrates.implementation.DefaultTextCommandFactory;

public class KatacombsOfDoomApp {

    public static void main(String[] args) {
        Console console = new Console();

        GameState gameState = DefaultGameState.invoke();

        KatacombsOfDoom katacombsOfDoom = new KatacombsOfDoom(gameState, new DefaultTextCommandFactory(gameState, console), console);

        katacombsOfDoom.start();

    }
}
