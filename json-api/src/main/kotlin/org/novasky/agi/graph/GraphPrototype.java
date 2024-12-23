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
     * This works recursively.
     */
    @HistoricMessageGraph
    public static class Vertex {
        private String target;
        private Optional<Void> weight;
    }

    /**
     * Two dimensional Graph.
     *
     * @author Wende2k, WendeX17D, @0x420x46
     */
    public static class Graph {

        public Graph() {
        }

        interface Configurable {
            /**
             * Everyone is allowed to have fun.
             * It is a human right to even mention that this is self-explanatory.
             *
             * @author Everyone has a free will. A present from God.
             * ^god
             * @author Wende2k, WendeX17D, @0x420x46
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



    /**
     * Event horizon of a black hole.
     * Graph hopping into another universe, in theory. Let's learn.
     *
     * @author wwisser
     */
    @Deprecated(since = "17D is only possible in the 🔮")
    interface DimensionalGraph extends GraphPrototype {
        static final String DIMENSION_COUNT_ENV = "DIMENSION_COUNT_ENV_GRAPH";

        default void wormWhole() {
            String dimensionsUntouched = System.getenv(DIMENSION_COUNT_ENV);
            byte dimensions = Integer.valueOf(dimensionsUntouched);
            // we could need: short, byte, int, long, float, BigDecimal

            // TODO WIP to do hopping, could destroy universe. Find correct datatype. there
        }
    }

    public static void main(String[] args) {
    }

}