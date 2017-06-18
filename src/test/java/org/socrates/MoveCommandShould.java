package org.socrates;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.socrates.Direction.NORTH;
import static org.socrates.Direction.SOUTH;

@RunWith(MockitoJUnitRunner.class)
public class MoveCommandShould {

    @Mock GameState gameState;
    @Mock Console console;

    private MoveCommand moveCommand;

    @Before
    public void initialise() {
        Room northRoom = new Room("North room");
        given(gameState.currentRoom()).willReturn(northRoom);
    }

    @Test
    public void move_player_north() {
        moveCommand = new MoveCommand(NORTH, console);
        moveCommand.execute(gameState);

        verify(gameState).move(NORTH);
    }

    @Test
    public void move_player_south() {
        moveCommand = new MoveCommand(SOUTH, console);
        moveCommand.execute(gameState);

        verify(gameState).move(SOUTH);
    }

    @Test public void
    display_current_room_after_moving() {
        moveCommand = new MoveCommand(NORTH, console);
        moveCommand.execute(gameState);

        verify(console).write("You are in North room");
    }
}