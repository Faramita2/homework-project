CREATE TABLE IF NOT EXISTS `people` (
		`id` INT PRIMARY KEY AUTO_INCREMENT,
		`name` VARCHAR ( 50 ) NOT NULL,
		`age` INT NOT NULL,
		`gender` VARCHAR ( 50 ) NOT NULL,
        `referer_id` BIGINT NOT NULL DEFAULT 0,
        `avatar` VARCHAR(1024) NOT NULL DEFAULT '',
		`created_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
		`updated_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
		`created_by` VARCHAR ( 50 ) NOT NULL,
		`updated_by` VARCHAR ( 50 ) NOT NULL,
		INDEX `index_name` ( `name` ASC ),
	    INDEX `index_age` ( `age` ASC )
);

DELIMITER $$

DROP PROCEDURE IF EXISTS addColumnIfNotExisting
$$

DROP FUNCTION IF EXISTS isColumnExisting
$$

CREATE FUNCTION isColumnExisting(table_name_in VARCHAR(100), column_name_in VARCHAR(100)) RETURNS INT
RETURN (
	SELECT COUNT(COLUMN_NAME)
    FROM INFORMATION_SCHEMA.columns
    WHERE TABLE_SCHEMA = DATABASE()
    AND TABLE_NAME = table_name_in
    AND COLUMN_NAME = column_name_in
)
$$

CREATE PROCEDURE addColumnIfNotExisting (
    IN table_name VARCHAR(100)
    , IN column_name VARCHAR(100)
    , IN column_definition VARCHAR(100)
)
BEGIN

    SET @isFieldThere = isColumnExisting(table_name, column_name);
    SELECT @isFieldThere;
    IF (@isFieldThere = 0) THEN

        SET @ddl = CONCAT('ALTER TABLE ', table_name);
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

-- add column `referer_id`
CALL addColumnIfNotExisting('people', 'referer_id', 'INT NOT NULL DEFAULT 0');

-- add column `avatar`
CALL addColumnIfNotExisting('people', 'avatar', "VARCHAR(255) NOT NULL DEFAULT ''");

DELIMITER $$

DROP PROCEDURE IF EXISTS modifyColumnIfExisting
$$

CREATE PROCEDURE modifyColumnIfExisting (
    IN table_name VARCHAR(100)
    , IN column_name VARCHAR(100)
    , IN column_definition VARCHAR(100)
)
BEGIN

    SET @isFieldThere = isColumnExisting(table_name, column_name);
    SELECT @isFieldThere;
    IF (@isFieldThere <> 0) THEN

        SET @ddl = CONCAT('ALTER TABLE ', table_name);
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

-- modify column `referer_id`
CALL modifyColumnIfExisting('people', 'referer_id', "BIGINT NOT NULL DEFAULT 0");

-- modify column `avatar`
CALL modifyColumnIfExisting('people', 'avatar', "VARCHAR(1024) NOT NULL DEFAULT ''");