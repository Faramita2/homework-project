CREATE TABLE IF NOT EXISTS `people` (
		`id` INT PRIMARY KEY AUTO_INCREMENT,
		`name` VARCHAR ( 50 ) NOT NULL,
		`age` INT NOT NULL,
		`gender` VARCHAR ( 50 ) NOT NULL,
		`created_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
		`updated_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
		`created_by` VARCHAR ( 50 ) NOT NULL,
		`updated_by` VARCHAR ( 50 ) NOT NULL,
		INDEX `index_name` ( `name` ASC ),
	    INDEX `index_age` ( `age` ASC )
);