package sit.ear.semestral.util;

/**
 * Created by Marek
 */
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URI;
import java.util.*;

import sit.ear.semestral.model.User;

public class Generator {

    public static final String USERNAME = "genTest";
    public static final String PASSWORD = "lkkk";

    private static Random random = new Random();

    private Generator() {
        throw new AssertionError();
    }

    public static User getUser() {
        final User user = new User();
        user.setName("Marek");
        user.setPassword(PASSWORD);
        return user;
    }

    /**
     * Generates a (pseudo-)random integer between 0 and the specified upper bound.
     * <p>
     * <b>IMPORTANT</b>: The lower bound (0) is not included in the generator output, so the smallest number this
     * generator returns is 1.
     *
     * @param upperBound Upper bound of the generated number
     * @return Randomly generated integer
     */
    public static int randomInt(int upperBound) {
        int rand;
        do {
            rand = random.nextInt(upperBound);
        } while (rand == 0);
        return rand;
    }

    /**
     * Generates a (pseudo) random integer.
     * <p>
     * This version has no bounds (aside from the integer range), so the returned number may be negative or zero.
     *
     * @return Randomly generated integer
     * @see #randomInt(int)
     */
    public static int randomInt() {
        return random.nextInt();
    }

    /**
     * Generates a (pseudo)random index of an element in the collection.
     * <p>
     * I.e. the returned number is in the interval <0, col.size()).
     *
     * @param col The collection
     * @return Random index
     */
    public static int randomIndex(Collection<?> col) {
        assert col != null;
        assert !col.isEmpty();
        return random.nextInt(col.size());
    }

    /**
     * Generators a (pseudo) random boolean.
     *
     * @return Random boolean
     */
    public static boolean randomBoolean() {
        return random.nextBoolean();
    }

}
