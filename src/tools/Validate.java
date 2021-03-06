package tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate
{
    private static final Pattern ipPattern = Pattern.compile(
            "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

    private static final Pattern hexPattern = Pattern.compile("-?[0-9a-fA-F]+");

    //http://www.mkyong.com/regular-expressions/how-to-validate-ip-address-with-regular-expression/
    public static boolean isValidIP(String ip)
    {
        Matcher ipMatcher = ipPattern.matcher(ip);
        return ipMatcher.matches();
    }

    public static boolean isValidHex(String hex)
    {
        Matcher hexMatcher = hexPattern.matcher(hex);
        return hexMatcher.matches();
    }
}
