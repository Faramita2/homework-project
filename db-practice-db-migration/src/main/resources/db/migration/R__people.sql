CREATE TABLE IF NOT EXISTS `people` (
		`id` INT PRIMARY KEY AUTO_INCREMENT,
		`name` VARCHAR ( 50 ) NOT NULL,
		`age` INT NOT NULL,
		`gender` VARCHAR ( 50 ) NOT NULL,
        `referer_id` BIGINT NOT NULL DEFAULT 0,
        `avatar` VARCHAR(255) NOT NULL DEFAULT '',
		`created_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
		`updated_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
		`created_by` VARCHAR ( 50 ) NOT NULL,
		`updated_by` VARCHAR ( 50 ) NOT NULL,
		INDEX `index_name` ( `name` ASC ),
	    INDEX `index_age` ( `age` ASC )
);


use demo;

DELIMITER $$

DROP PROCEDURE IF EXISTS addColumnIfNotExisting
$$

DROP FUNCTION IF EXISTS isColumnExisting
$$

CREATE FUNCTION isColumnExisting(schema_name_in VARCHAR(100), table_name_in VARCHAR(100), column_name_in VARCHAR(100)) RETURNS INT
RETURN (
	SELECT COUNT(COLUMN_NAME)
    FROM INFORMATION_SCHEMA.columns
    WHERE TABLE_SCHEMA = schema_name_in
    AND TABLE_NAME = table_name_in
    AND COLUMN_NAME = column_name_in
)
$$

CREATE PROCEDURE addColumnIfNotExisting (
    IN schema_name VARCHAR(100)
    ,IN table_name VARCHAR(100)
    , IN column_name VARCHAR(100)
    , IN column_definition VARCHAR(100)
)
BEGIN

    SET @isFieldThere = isColumnExisting(schema_name, table_name, column_name);
    SELECT @isFieldThere;
    IF (@isFieldThere = 0) THEN

        SET @ddl = CONCAT('ALTER TABLE ', CONCAT(CONCAT(schema_name, '.'), table_name));
        SET @ddl = CONCAT(@ddl, ' ', 'ADD COLUMN') ;
        SET @ddl = CONCAT(@ddl, ' ', column_name);
        SET @ddl = CONCAT(@ddl, ' ', column_definition);

        PREPARE stmt FROM @ddl;
        EXECUTE stmt;
        DEALLOCATE PREPARE stmt;

    END IF;

END;
$$

DELIMITER ;

-- add column `referer_id` for table `people`
CALL addColumnIfNotExisting('demo', 'people', 'referer_id', 'INT NOT NULL DEFAULT 0');

-- add column `avatar` for table `people`
CALL addColumnIfNotExisting('demo', 'people', 'avatar', "VARCHAR(255) NOT NULL DEFAULT ''");

DELIMITER $$

DROP PROCEDURE IF EXISTS modifyColumnIfExisting
$$

CREATE PROCEDURE modifyColumnIfExisting (
    IN schema_name VARCHAR(100)
    ,IN table_name VARCHAR(100)
    , IN column_name VARCHAR(100)
    , IN column_definition VARCHAR(100)
)
BEGIN

    SET @isFieldThere = isColumnExisting(schema_name, table_name, column_name);
    SELECT @isFieldThere;
    IF (@isFieldThere <> 0) THEN

        SET @ddl = CONCAT('ALTER TABLE ', CONCAT(CONCAT(schema_name, '.'), table_name));
        SET @ddl = CONCAT(@ddl, ' ', 'MODIFY COLUMN') ;
        SET @ddl = CONCAT(@ddl, ' ', column_name);
        SET @ddl = CONCAT(@ddl, ' ', column_definition);

        PREPARE stmt FROM @ddl;
        EXECUTE stmt;
        DEALLOCATE PREPARE stmt;

    END IF;

END;
$$

DELIMITER ;

-- modify column `referer_id` for table `people`
CALL modifyColumnIfExisting('demo', 'people', 'referer_id', "BIGINT NOT NULL DEFAULT 0");