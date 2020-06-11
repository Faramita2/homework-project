CREATE TABLE IF NOT EXISTS `cats` (
		`id` INT PRIMARY KEY AUTO_INCREMENT,
		`name` VARCHAR ( 50 ) NOT NULL,
		`gender` VARCHAR ( 50 ) NOT NULL,
		`age` INT NOT NULL,
		`created_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
		`updated_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
		`created_by` VARCHAR ( 50 ) NOT NULL,
		`updated_by` VARCHAR ( 50 ) NOT NULL,
	INDEX `name_index`( `name` DESC ),
	INDEX `age_index`( `age` ASC )
);