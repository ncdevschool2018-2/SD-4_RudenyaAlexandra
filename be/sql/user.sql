CREATE TABLE `user`(
	`user_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`login` VARCHAR(255) NOT NULL DEFAULT '0',
	`password` VARCHAR(255) NOT NULL,
	`role` VARCHAR(255) NOT NULL DEFAULT 'user',
	PRIMARY KEY (`user_id`),
	UNIQUE INDEX `user_id` (`user_id`),
	UNIQUE INDEX `login` (`login`)
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB;
