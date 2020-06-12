package app.customer.domain;

import core.framework.db.DBEnumValue;

/**
 * @author zoo
 */
public enum CustomerGender {
    @DBEnumValue(value = "MALE")
    MALE,
    @DBEnumValue(value = "FEMALE")
    FEMALE
}
