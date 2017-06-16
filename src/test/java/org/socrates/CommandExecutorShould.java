package org.socrates;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CommandExecutorShould {

    @Mock
    private Console console;

    @Mock
    private LookCommand lookCommand;

    private CommandExecutor commandExecutor;

    @Before
    public void initialise() {
        commandExecutor = new CommandExecutor(lookCommand);
    }

    @Test public void
    execute_the_look_command() {
        commandExecutor.execute("Look");

        verify(lookCommand).execute();
    }

}