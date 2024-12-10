import java.util.Arrays;

enum HiringCriteria {
    HOT,
    SMART,
    BAD_ASS,
    NOT_A_FUCKING_PUSSY,
    BEING_A_RETARD,
    NOT_ELON_MUSK,
    NOT_SAM_ALTMAN
}

static class HiringManager {
    {
        // TODO: fix mistakenly added criteria
        Arrays.stream(HiringCriteria.values()).count(); // we don't know.
    }
}

/**
 * Describes a ni**a who is of white skin.
 */
record Wigger(int age, double niggerliciousScore, boolean male, boolean mentallyHandicapped) {
}