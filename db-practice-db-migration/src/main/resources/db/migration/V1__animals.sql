CREATE TABLE IF NOT EXISTS `animals` (
		`id` INT PRIMARY KEY AUTO_INCREMENT,
		`name` VARCHAR ( 50 ) NOT NULL,
		`counts` BIGINT NOT NULL DEFAULT 0,
        `image` VARCHAR(255) NOT NULL DEFAULT '',
		`created_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
		`updated_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
		`created_by` VARCHAR ( 50 ) NOT NULL,
		`updated_by` VARCHAR ( 50 ) NOT NULL,
		INDEX `index_name` ( `name` ASC ),
	    INDEX `index_counts` ( `counts` ASC )
);