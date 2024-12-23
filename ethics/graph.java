import java.util.Optional;

/**
 * A prototype graph utilizing hopping to reach @lie22300
 *
 * @author @Wende2k, @RistPascal7500
 */
public final class GraphPrototype {
    public static final String HIRING_MANAGER = "@Wende2k";


    /**
     * Two dimensional Graph.
     *
     * @author Wende2k, WendeX17D, @0x420x46
     */
    public static class Graph {

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

    public static class Node {

    }

    public static class Hop {
        private Person target;
    }

    public static class Person {
        private final String name;
        private final Set<WeightedPreference> foodPreferences;

        public Person(String name, Set<WeightedPreference> foodPreferences) {
            this.name = name;
            this.foodPreferences = foodPreferences;
        }

        public String getName() {
            return name;
        }

        public Set<WeightedPreference> getFoodPreferences() {
            return foodPreferences;
        }
    }

    enum Preference {
        SPICY,
        MORNING_GLORY,
        TOM_KHA_GAI,
        RICE,
        FRUITS
    }

    public static class WeightedPreference {
        Preference preference;
        double weight;
        boolean conditional;
    }

    interface DimensionalGraph extends GraphPrototype {
    }

    public static void main(String[] args) {
    }

}
