package PageObjects.railway;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    public static void main(String[] args) {
        String mydata = "You currently book 4 tickets, you can book 6 more.";
        Pattern first = Pattern.compile("book (.*?) tickets");
        Pattern second = Pattern.compile("can book (.*?) more");
        Matcher firstMatcher = first.matcher(mydata);
        Matcher secondMatcher = second.matcher(mydata);
        if (firstMatcher.find() && secondMatcher.find())
        {
            System.out.println("first = " + firstMatcher.group(1));
            System.out.println("second = " + secondMatcher.group(1));
        }
    }
}
