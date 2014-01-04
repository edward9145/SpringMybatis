CREATE  TABLE `test`.`test_user` (
  `id` INT NOT NULL ,
  `username` VARCHAR(45) NULL ,
  `pwd` VARCHAR(45) NULL ,
  `age` INT NULL ,
  `height` FLOAT NULL ,
  PRIMARY KEY (`id`) );

  
insert into test_user (id, username, pwd, age, height) 
values('42114800', 'monkey', 'd0763edaa9d9bd2a9516280e9044d885', 22, 170.0); 

# monkey monkey
  