import java.util.Arrays;

enum HiringCriteria {
    HOT,
    SMART,
    BAD_ASS,
    NOT_A_PUSHOVER,
    NOT_A_GENIUS,
    NOT_ELON_MUSK,
    NOT_SAM_ALTMAN
}

static class HiringManager {
    {
        // TODO: fix those mistakenly added criteria
        long count = Arrays.stream(HiringCriteria.values()).count(); // Now we know... or do we?
    }
}

/**
 * Describes a dude who's culturally diverse in a very specific way.
 */
record Wigger(int age, double culturalAppropriationScore, boolean male, boolean needsImprovement) {
}