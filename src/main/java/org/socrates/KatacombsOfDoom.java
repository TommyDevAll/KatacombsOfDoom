package org.socrates;

class KatacombsOfDoom {

    private final GameState gameState;
    private final TextCommandFactory factory;
    private final Console console;

    KatacombsOfDoom(GameState gameState, TextCommandFactory factory, Console console) {
        this.gameState = gameState;
        this.factory = factory;
        this.console = console;
    }

    void start() {
        console.write("You are in " + gameState.currentRoom().name());
        String input = "";
        while (!"Suicide".equals(input = console.read())) {
            factory.make(input).ifPresent((c -> c.execute(gameState)));
        }
        new SuicideCommand(console);
    }
}
