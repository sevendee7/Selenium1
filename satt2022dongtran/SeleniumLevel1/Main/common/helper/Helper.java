package common.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import driver.DriverManager;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Helper {

    public String randomAlphabetGenerator(int targetStringLength) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();

        return generatedString;
    }

    public String randomNumericGenerator(int targetStringLength) {
        int leftLimit = 48; // letter '0'
        int rightLimit = 57; // letter '9'
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();

        return generatedString;
    }

    public int getListElementSize(String xpath) {
        List<WebElement> elements = DriverManager.getDriver()
                .findElements(By.xpath(xpath));
        return elements.size();
    }

    public String generateRandomDateBetween(int start, int end) {
        LocalDate today = LocalDate.now();
        LocalDate firstDate = today.plusDays(start);
        LocalDate lastDate = today.plusDays(end);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        long startEpochDay = firstDate.toEpochDay();
        long endEpochDay = lastDate.toEpochDay();
        long randomDay = ThreadLocalRandom
                .current()
                .nextLong(startEpochDay, endEpochDay);
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
        return randomDate.format(formatter);
    }

    public String getTicketIdFromUrl(String url) {
        int index = 0;
        for (int i = url.length() - 1; i > 0; i--) {
            if (url.charAt(i) == '=') {
                index = i;
                break;
            }
        }
        return url.substring(index + 1);
    }
}
