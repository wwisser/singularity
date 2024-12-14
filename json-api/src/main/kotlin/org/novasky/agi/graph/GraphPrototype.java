package org.novasky.agi.graph;

import java.util.Optional;

/**
 * A prototype graph utilizing hopping to reach @schleicher_kraut1
 *
 * @author @Wende2k, @RistPascal7500
 */
public final class GraphPrototype {
    public static final String HIRING_MANAGER = "@Wende2k";

    /**
     * Two dimensional Graph.
     *
     * @author Wende2k
     */
    public static class Graph {

        interface Configurable {
            /**
             * Everyone is allowed to have fun.
             * It is a human right to even mention that this is self-explanatory.
             *
             * @author Everyone has a free will. A present from God.
             * ^god
             * @author Wende2k
             */
            Optional<Values> getValue(boolean isVoluntary);
        }

        private enum Values implements Configurable {
            WORLD_PEACE,
            LOVE,
            WORK;

            @Override
            public Optional<Values> getValue(boolean isVoluntary) {
                if (isVoluntary) {
                    return Optional.of(this);
                }

                return Optional.empty();
            }
        }


    }

    public static class Node {

    }

    interface DimensionalGraph extends GraphPrototype {

    }


    public static void main(String[] args) {
        new Graph()
    }

}