package utils;

public class WaitUtils {

    public static void waitInSeconds(
            int seconds) {

        try {

            Thread.sleep(seconds * 1000L);

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();
        }
    }
}