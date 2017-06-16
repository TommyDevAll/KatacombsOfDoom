package org.socrates;

class KatacombsOfDoom {

    private final Room room;
    private Console console;
    private Commands commands;

    KatacombsOfDoom(Room room, Commands commands, Console console) {
        this.room = room;
        this.commands = commands;
        this.console = console;
    }

    void start() {
        console.write("You are in " + room.name());
        String command = "";
        while (!"Suicide".equals(command = console.read())) {
            commands.execute(command);
        }
        console.write("See you in hell.");
    }
}
