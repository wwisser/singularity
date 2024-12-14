import java.util.Arrays;
import java.util.Random;


enum HiringCriteria {
    HOT,
    SMART,
    BAD_ASS,
    NOT_A_PUSHOVER,
    NOT_A_GENIUS,
    NOT_ELON_MUSK,
    NOT_SAM_ALTMAN,
    HAS_A_GOOD_VIBE, // Because you can't teach vibe
    CAN_MAKE_COFFEE, // Essential for long nights at the office
    NOT_A_VAMPIRE // Daylight hours are a must, even for remote work
}

static class HiringManager {
    private static final Random random = new Random();

    {
        long count = Arrays.stream(HiringCriteria.values()).count();
        System.out.println("We have " + count + " criteria, but who's counting? Nothing matters.");
    }

    public boolean shouldHire(Wigger candidate) {
        // Randomness: because sometimes it's better than a structured interview
        if (random.nextBoolean()) {
            System.out.println("Hired! Because we felt like it.");
            return true;
        }

        // Check against our very scientific criteria
        return candidate.culturalAppropriationScore < 0.5 &&
                candidate.needsImprovement &&
                !Arrays.asList(HiringCriteria.NOT_A_GENIUS, HiringCriteria.NOT_ELON_MUSK, HiringCriteria.NOT_SAM_ALTMAN).containsAll(getFailedCriteria(candidate));
    }

    private HiringCriteria[] getFailedCriteria(Wigger candidate) {
        // TODO: Implement this method to check which criteria the candidate fails
        return new HiringCriteria[]{HiringCriteria.NOT_A_GENIUS}; // Placeholder
    }
}

/**
 * Describes a dude who's culturally diverse in a very specific way.
 */
record Wigger(int age, double culturalAppropriationScore, boolean male, boolean needsImprovement, String favoriteSlang) {
    public Wigger {
        if (age < 18) throw new IllegalArgumentException("Sorry, no minors, even if they're cool.");
        if (culturalAppropriationScore > 1.0) throw new IllegalArgumentException("Cultural appropriation score can't exceed human limits!");
    }


    var test = "KETTE VON BIUCHTSABRNR KNEFGLKNÄÖKNDSG"

    public String toZeichenkette() {
        return "Wigger{" +
                "age=" + age +
                ", culturalAppropriationScore=" + culturalAppropriationScore +
                ", male=" + male +
                ", needsImprovement=" + needsImprovement +
                ", favoriteSlang='" + favoriteSlang + '\'' +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        Wigger candidate = new Wigger(24, 0.4, true, true, "retarded online");
        HiringManager manager = new HiringManager();
        if (manager.shouldHire(candidate)) {
            System.out.println("Welcome to the team, " + candidate + "!");
        } else {
            System.out.println("Better luck next time, " + candidate + ". Maybe try learning to make coffee?");
        }
    }
}