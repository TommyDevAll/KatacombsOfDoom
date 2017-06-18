package org.socrates;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class KatacombsOfDoomShould {

    @Mock Console console;
    @Mock TextCommandFactory factory;
    @Mock Command aCommand;
    @Mock GameState gameState;

    private KatacombsOfDoom katacombsOfDoom;
    private Room library = new Room("Library");

    @Before
    public void initialise() {
        given(console.read()).willReturn("Suicide");
        when(gameState.currentRoom()).thenReturn(library);
        when(factory.make(anyString())).thenReturn(Optional.of(aCommand));

        katacombsOfDoom = new KatacombsOfDoom(gameState, factory, console);
    }

    @Test public void
    prompt_player_that_he_is_in_a_room_with_a_given_name() {
        katacombsOfDoom.start();

        verify(console).write("You are in " + library.name());
    }

    @Test public void
    execute_user_command() {
        given(console.read()).willReturn("Look", "Suicide");

        katacombsOfDoom.start();

        verify(factory).make("Look");
    }

}
