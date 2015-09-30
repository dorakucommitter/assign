
INSERT INTO employee (employee_id, employee_code, name, nickname, birthday, user_id, password) VALUES (1, 'user1', 'サンプルユーザ1', 'nick1', '2015-09-01', 'user1', '$2a$10$1gJJgBlL75OIjkSgkYPXI.mV7ihEPjxIiCkXKBEc7/r9xUIjZyc9i');
INSERT INTO employee (employee_id, employee_code, name, nickname, birthday, user_id, password) VALUES (2, 'user2', '鈴木　一郎', 'nick2', '2015-09-02', 'user2', '$2a$10$1gJJgBlL75OIjkSgkYPXI.mV7ihEPjxIiCkXKBEc7/r9xUIjZyc9i');
INSERT INTO employee (employee_id, employee_code, name, nickname, birthday, user_id, password) VALUES (3, 'user3', '山本　太郎', 'nick3', '2015-09-03', 'user3', '$2a$10$1gJJgBlL75OIjkSgkYPXI.mV7ihEPjxIiCkXKBEc7/r9xUIjZyc9i');
INSERT INTO employee (employee_id, employee_code, name, nickname, birthday, user_id, password) VALUES (4, 'user4', '鈴木　愛子', 'nick4', '2015-09-04', 'user4', '$2a$10$1gJJgBlL75OIjkSgkYPXI.mV7ihEPjxIiCkXKBEc7/r9xUIjZyc9i');
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
INSERT INTO project (project_id, project_name, start_of_project, end_of_project, wanted_start, wanted_end, outline, scale) VALUES (1, 'Ａ案件', '2014-09-04', null, '2015-10-01', '2015-10-31', '公共機関ＡＢＣのＸＹＺ作業', '30人月');
INSERT INTO project (project_id, project_name, start_of_project, end_of_project, wanted_start, wanted_end, outline, scale) VALUES (2, 'Ｂ案件', '2013-01-04', null, '2015-09-15', '2015-10-31', 'キャリアＤのＡＡＡ作業', '10人月');
INSERT INTO project (project_id, project_name, start_of_project, end_of_project, wanted_start, wanted_end, outline, scale) VALUES (3, 'Ｃ案件', '2015-03-04', null, '2015-09-20', '2015-10-31', '取引所のＸＸ構築作業', '20人月');
INSERT INTO project (project_id, project_name, start_of_project, end_of_project, wanted_start, wanted_end, outline, scale) VALUES (4, 'Ｄ案件', '2015-06-04', null, '2015-09-30', '2015-10-31', 'あああのＸＸ構築作業', '40人月');
INSERT INTO project (project_id, project_name, start_of_project, end_of_project, wanted_start, wanted_end, outline, scale) VALUES (5, 'Ｅ案件', '2015-09-04', null, '2015-09-10', '2015-10-31', 'ＣＣＣ開発', '60人月');
INSERT INTO engaged_in (engaged_in_id, engaged_in_start, engaged_in_end, exit_prospects, employee_id, project_id) VALUES (1, '2015-03-04', null, '2015-10-30', 1, 1);
INSERT INTO engaged_in (engaged_in_id, engaged_in_start, engaged_in_end, exit_prospects, employee_id, project_id) VALUES (2, '2015-02-05', null, '2015-10-28', 2, 1);
INSERT INTO engaged_in (engaged_in_id, engaged_in_start, engaged_in_end, exit_prospects, employee_id, project_id) VALUES (3, '2015-01-05', null, '2015-10-15', 3, 2);
INSERT INTO engaged_in (engaged_in_id, engaged_in_start, engaged_in_end, exit_prospects, employee_id, project_id) VALUES (4, '2015-05-05', null, '2015-10-18', 4, 3);
INSERT INTO request_skills (request_skills_id, qualification_id, project_id ) VALUES (1, 1, 1);
INSERT INTO request_skills (request_skills_id, qualification_id, project_id ) VALUES (2, 1, 2);
INSERT INTO request_skills (request_skills_id, qualification_id, project_id ) VALUES (3, 2, 3);
INSERT INTO request_skills (request_skills_id, qualification_id, project_id ) VALUES (4, 2, 4);
INSERT INTO request_skills (request_skills_id, qualification_id, project_id ) VALUES (5, 3, 5);




