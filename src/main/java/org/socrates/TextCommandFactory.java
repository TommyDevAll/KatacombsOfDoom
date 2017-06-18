package org.socrates;

import java.util.Optional;

/**
 * Created by tresti on 18.06.17.
 */
public interface TextCommandFactory {
    Optional<Command> make(String command);
}
