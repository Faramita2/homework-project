package app.second.dog.domain;

import core.framework.mongo.MongoEnumValue;

/**
 * @author zoo
 */
public enum DogGender {
    @MongoEnumValue("MALE")
    MALE,
    @MongoEnumValue("FEMALE")
    FEMALE
}
