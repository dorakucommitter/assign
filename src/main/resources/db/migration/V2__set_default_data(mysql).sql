
INSERT INTO employee (employee_id, employee_code, name, nickname, birthday, user_id, password) VALUES (1, 'user1', 'サンプルユーザ1', 'nick1', '2015-09-01', 'user1', '$2a$10$1gJJgBlL75OIjkSgkYPXI.mV7ihEPjxIiCkXKBEc7/r9xUIjZyc9i');
INSERT INTO employee (employee_id, employee_code, name, nickname, birthday, user_id, password) VALUES (2, 'user2', 'サンプルユーザ2', 'nick2', '2015-09-02', 'user2', '$2a$10$1gJJgBlL75OIjkSgkYPXI.mV7ihEPjxIiCkXKBEc7/r9xUIjZyc9i');
INSERT INTO employee (employee_id, employee_code, name, nickname, birthday, user_id, password) VALUES (3, 'user3', 'サンプルユーザ3', 'nick3', '2015-09-03', 'user3', '$2a$10$1gJJgBlL75OIjkSgkYPXI.mV7ihEPjxIiCkXKBEc7/r9xUIjZyc9i');
INSERT INTO employee (employee_id, employee_code, name, nickname, birthday, user_id, password) VALUES (4, 'user4', 'サンプルユーザ4', 'nick4', '2015-09-04', 'user4', '$2a$10$1gJJgBlL75OIjkSgkYPXI.mV7ihEPjxIiCkXKBEc7/r9xUIjZyc9i');
INSERT INTO field (field_id, field_name) VALUES (1, 'ネットワーク');
INSERT INTO field (field_id, field_name) VALUES (2, 'ソフトウェア開発');
INSERT INTO field (field_id, field_name) VALUES (3, 'OS');
INSERT INTO field (field_id, field_name) VALUES (4, '情報処理技術者試験');
INSERT INTO qualification (qualification_id, qualification_name, field_id ) VALUES (1, 'CCNA', 1);
INSERT INTO qualification (qualification_id, qualification_name, field_id ) VALUES (2, 'CCNP', 1);
INSERT INTO qualification (qualification_id, qualification_name, field_id ) VALUES (3, 'Java', 2);
INSERT INTO qualification (qualification_id, qualification_name, field_id ) VALUES (4, 'C#', 2);
INSERT INTO qualification (qualification_id, qualification_name, field_id ) VALUES (5, 'VB.NET', 2);
INSERT INTO qualification (qualification_id, qualification_name, field_id ) VALUES (6, 'RedHat', 3);
INSERT INTO qualification (qualification_id, qualification_name, field_id ) VALUES (7, 'Windows Server', 3);
INSERT INTO qualification (qualification_id, qualification_name, field_id ) VALUES (8, '基本情報技術者試験', 4);
INSERT INTO qualification (qualification_id, qualification_name, field_id ) VALUES (9, '応用情報技術者試験', 4);
INSERT INTO holding_qualification (employee_id, qualification_id, date_of_acquisition, years_of_experience ) VALUES (1, 1, null, 3);
INSERT INTO holding_qualification (employee_id, qualification_id, date_of_acquisition, years_of_experience ) VALUES (2, 1, null, 1);
INSERT INTO holding_qualification (employee_id, qualification_id, date_of_acquisition, years_of_experience ) VALUES (2, 2, null, 5);
INSERT INTO holding_qualification (employee_id, qualification_id, date_of_acquisition, years_of_experience ) VALUES (3, 3, null, 4);



