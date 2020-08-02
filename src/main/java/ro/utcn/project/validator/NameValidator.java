package ro.utcn.project.validator;

import org.apache.commons.lang3.StringUtils;

public class NameValidator {
    public boolean validateName(String name)
    {
        if(StringUtils.length(name)<3)
            return false;
        return true;
    }
}