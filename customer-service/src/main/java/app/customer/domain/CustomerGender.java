package app.customer.domain;

import core.framework.db.DBEnumValue;

/**
 * @author zoo
 */
public enum CustomerGender {
    @DBEnumValue("MALE")
    MALE,
    @DBEnumValue("FEMALE")
    FEMALE
}
