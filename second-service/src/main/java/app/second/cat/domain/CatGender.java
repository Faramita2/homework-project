package app.second.cat.domain;

import core.framework.db.DBEnumValue;

/**
 * @author zoo
 */
public enum CatGender {
    @DBEnumValue("MALE")
    MALE,
    @DBEnumValue("FEMALE")
    FEMALE
}
