package Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RTO_LicenceNumberValidator {

    private static final String LICENSE_NUMBER_PATTERN = "^[A-Z]{2}-\\d{2}-\\d{4}-\\d{7}$";

    public static boolean validateLicenseNumber(String licenseNumber) {
        Pattern pattern = Pattern.compile(LICENSE_NUMBER_PATTERN);

        Matcher matcher = pattern.matcher(licenseNumber);

        return matcher.matches();

    }
}