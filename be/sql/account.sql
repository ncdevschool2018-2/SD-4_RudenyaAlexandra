CREATE TABLE `account` (
	`account_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`last_name` VARCHAR(255) NULL DEFAULT '0',
	`first_name` VARCHAR(255) NULL DEFAULT '0',
	`registration_date` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
	`image_profile` VARCHAR(255) NULL DEFAULT NULL,
	PRIMARY KEY (`account_id`),
	UNIQUE INDEX `account_id` (`account_id`)
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB
;
