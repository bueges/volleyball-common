package volleyball.common.builder;

import com.google.common.collect.Lists;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public abstract class AbstractBuilder implements IBuilder {

    private static final Logger logger = LogManager.getLogger(AbstractBuilder.class);

    protected void isObjectNull(Object parameter, String parameterName) throws BuilderException {
        isObjectNull(parameter, parameterName, false);
    }

    protected void isObjectNull(Object parameter, String parameterName, boolean canBeNull) throws BuilderException {
        if (canBeNull == false) {
            if (parameter == null) {
                String errorMsg = "invalid parameter : " + parameterName + " can't be NULL";
                logger.error(errorMsg);
                throw new BuilderException(errorMsg);
            }
        } else {
            if (parameter == null) {
                logger.info("ignore invalid parameter : " + parameterName + " is NULL");
            }
        }
    }

    protected void isStringEmptyOrNull(String parameter, String parameterName) throws BuilderException {
        isStringEmptyOrNull(parameter, parameterName, false);
    }

    protected void isStringEmptyOrNull(String parameter, String parameterName, boolean canBeEmpty) throws BuilderException {
        isObjectNull((Object) parameter, parameterName);

        if (canBeEmpty == false) {
            if (parameter.equals("")) {
                String errorMsg = "invalid parameter : " + parameterName + " can't be empty";
                logger.error(errorMsg);
                throw new BuilderException(errorMsg);
            }
        } else {
            if (parameter.isEmpty()) {
                logger.info("ignore invalid parameter : " + parameterName + " is empty");
            }
        }
    }

    protected List<String> splitString(String parameter, String parameterName, String splitter) throws BuilderException {
        isStringEmptyOrNull(parameter, parameterName);
        isStringEmptyOrNull(splitter, "splitter");

        return Arrays.asList(parameter.split(splitter));
    }

    protected int convertStringToInt(String parameter, String parameterName) throws BuilderException {
        isStringEmptyOrNull(parameter, parameterName);

        try {
            return Integer.parseInt(parameter);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            logger.error("a NumberFormatException occurred : [{}]" + e.getMessage());
            throw new BuilderException(e);
        }
    }

    protected LocalDate convertStringToDate(String parameter, String parameterName) throws BuilderException {
        isStringEmptyOrNull(parameter, parameterName);
        List<String> datePattern = Lists.newArrayList("dd.MM.yyyy", "d.MM.yyyy", "dd.M.yyyy", "d.M.yyyy", "d.M.yy", "yyyy-MM-dd");

        LocalDate date = null;
        for (String pattern : datePattern) {
            try {
                date = LocalDate.parse(parameter, DateTimeFormatter.ofPattern(pattern, Locale.GERMAN));
                break;
            } catch (DateTimeParseException e) {
                logger.debug("ignore DateTimeParseException : [" + e.getMessage() + "]");
            }
        }
        isObjectNull(date, "date");

        return date;
    }

    protected LocalDateTime convertStringToDateTime(String parameter, String parameterName) throws BuilderException {
        isStringEmptyOrNull(parameter, parameterName);
        List<String> dateTimePattern = Lists.newArrayList("dd.MM.yyyy HH:mm", "d.MM.yyyy HH:mm", "dd.M.yyyy HH:mm", "d.M.yyyy HH:mm", "d.M.yy HH:mm", "yyyy-MM-dd HH:mm");

        LocalDateTime dateTime = null;
        for (String pattern : dateTimePattern) {
            try {
                dateTime = LocalDateTime.parse(parameter, DateTimeFormatter.ofPattern(pattern, Locale.GERMAN));
                break;
            } catch (DateTimeParseException e) {
                logger.debug("ignore DateTimeParseException : [" + e.getMessage() + "]");
            }
        }

        return dateTime;
    }
}
