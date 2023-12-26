-- https://rcs-ui-8ae61.firebaseapp.com

-- Классы
select * from school_class;

insert into school_class values ('a9d78ff9-1169-4105-a597-c0a0b9520b9e', 'first', '1 класс', 'Первый класс');
insert into school_class values ('279ae440-0693-49f0-af4c-7e324479ef99', 'second', '2 класс', 'Второй класс');
insert into school_class values ('93e3663c-a782-45d4-8694-872659aeed5f', 'third', '3 класс', 'Третий класс');
insert into school_class values ('0b266f85-cdc0-47de-8ab3-6964d7fb756f', 'fourth', '4 класс', 'Четвёртый класс');

-- Предметы
select * from subject;

insert into subject values ('b5269894-9697-43e0-8cf1-fdbba2ca27d2', 'literature', 'Литература', null);
insert into subject values ('1e007201-4f33-43c2-8e8c-af1e2f7e6f45', 'environment', 'Окружающий мир', null);
insert into subject values ('e715108b-3ae8-4ef2-b6e6-5ffd1ed0e200', 'mathematics', 'Математика', null);
insert into subject values ('4a635509-225f-481d-98bc-774127a7d23a', 'russian_language', 'Русский язык', null);

-- Картинки
select * from image;

insert into image values ('c053f99d-ba1c-453a-af4d-e3fe0031c400', '\src\shared\assets\images\boy_skiing.jpg');
insert into image values ('3765d6e3-f311-4969-86de-1d94f99a7494', '\src\shared\assets\images\boy_body_parts.jpg');
insert into image values ('15a93112-5f59-4a19-ad46-7ec7cdffeec1', '\src\shared\assets\images\summer.jpg');
insert into image values ('3eb4fb79-6ad2-49a4-a5d8-15532319c2b1', '\src\shared\assets\images\autumn.jpg');
insert into image values ('2e0ea931-2cbe-40f0-8e41-591c2a1461a1', '\src\shared\assets\images\spring.jpg');
insert into image values ('f12b229a-3b09-4d9a-93f1-8cfcc22b553e', '\src\shared\assets\images\winter.jpg');
insert into image values ('852fb095-2278-45f6-8ca3-439b18bb19c2', '\src\shared\assets\images\tree_1.jpg');
insert into image values ('8bf71dad-712e-4ef7-a97b-ebeec2917745', '\src\shared\assets\images\tree_2.jpg');
insert into image values ('a1d1a88a-d624-43c1-9a53-b8419b2b4b0c', '\src\shared\assets\images\tree_3.jpg');
insert into image values ('8ed867f7-3116-4cf7-82a5-40ce749ea6e6', '\src\shared\assets\images\tree_4.jpg');
insert into image values ('1d52db69-05b1-455e-b0d8-865ae3c2b6ae', '\src\shared\assets\images\tree_5.jpg');
insert into image values ('0290c512-0c9e-4fd8-a067-c26f7981d613', '\src\shared\assets\images\bird_1.jpg');
insert into image values ('ed93c030-b40e-45b8-b345-37c8b29a7a82', '\src\shared\assets\images\bird_2.jpg');
insert into image values ('8916d9b4-c692-47b0-9379-3a3748301026', '\src\shared\assets\images\bird_3.jpg');
insert into image values ('4b10dd8b-3738-448b-8446-5b52a7ac9819', '\src\shared\assets\images\flag_1.jpg');
insert into image values ('ee036ce6-c8ee-4cf5-912e-8943f05b26a9', '\src\shared\assets\images\flag_2.jpg');
insert into image values ('d9b07c5a-1aab-4204-8140-6c6c2831d8a6', '\src\shared\assets\images\flag_3.jpg');

-- Типы заданий
select * from task_type;

insert into task_type values ('c98d26b4-2f09-4b40-a020-72f2e3f877d8', 'read', 'Чтение', 'Чтение текста для последующих вопросов по нему');
insert into task_type values ('c601fc92-e680-4bb7-b6b3-b97fcb09a90f', 'typing', 'Ввод с клавиатуры', 'Напечатать ответ на вопрос');
insert into task_type values ('402375b9-ffa6-42dd-ac57-8e5415f0b821', 'choose', 'Выбор из вариантов', 'Выбрать ответ или ответы из предложенных вариантов');

-- Доступные позиции ответов
select * from answer_position;

insert into answer_position values ('2b9ade7e-f3b6-4d23-83f8-8c2f10170e0f', 'right', 'Справа', null);
insert into answer_position values ('ea5f9f92-4378-435d-bdce-8af8b8c9aa12', 'left', 'Слева', null);
insert into answer_position values ('d573ca82-eec8-4192-838a-26b66e57c5dc', 'below', 'Снизу', null);

-- Доступные форматы ответов на задания с типом typing
select * from answer_typing_format;

insert into answer_typing_format values ('37b35df1-f6f5-4fd0-8b28-494502c6912c', 'text', 'Текст', null);
insert into answer_typing_format values ('b016a6e4-3a51-4552-9be9-44ba2a98b876', 'digit', 'Цифра', null);

-- Доступные способы ответов на задания с типом choose
select * from answer_choose_type;

insert into answer_choose_type values ('93be22dc-2b74-4a61-9f6a-678d3169c43b', 'underline', 'Подчеркнуть', null);
insert into answer_choose_type values ('eeee40a3-ccf6-4c34-9fb4-25374fd732de', 'check', 'Отметить', null);

-- Доступные цвета для ответов с типом choose
select * from answer_choose_color;

insert into answer_choose_color values ('5fb1318d-d60b-482b-b71a-1cad8f1c3054', 'grey', 'Серый', null);
insert into answer_choose_color values ('eddf320f-f587-43f3-9858-62361fcee034', 'red', 'Красный', null);
insert into answer_choose_color values ('9f902817-5d6c-48fd-a5f6-a039d3f5b407', 'blue', 'Синий', null);

-- Доступные типы отображения заданий
select * from view_type;

insert into view_type values ('cc3efb92-7149-473b-b6d6-618fb380a584', 'rows', 'Строки', null);
insert into view_type values ('a6871068-80db-4cd6-9f2c-d526e5edcc03', 'table', 'Таблица', null);
insert into view_type values ('549d06a4-b2e2-4db0-ba56-c590e103fd83', 'columns', 'Колонки', null);

-- Тесты
select * from school_test;

insert into school_test values ('65824e36-8d65-475f-a3d7-bc47ee1a97c1', 'a9d78ff9-1169-4105-a597-c0a0b9520b9e', 'b5269894-9697-43e0-8cf1-fdbba2ca27d2', null);
insert into school_test values ('9d565bdd-b1fb-44eb-af50-7490555b5708', 'a9d78ff9-1169-4105-a597-c0a0b9520b9e', '1e007201-4f33-43c2-8e8c-af1e2f7e6f45', null);

-- Задания тестов
select * from task;

/*
'c98d26b4-2f09-4b40-a020-72f2e3f877d8', 'read'
'c601fc92-e680-4bb7-b6b3-b97fcb09a90f', 'typing'
'402375b9-ffa6-42dd-ac57-8e5415f0b821', 'choose'
 */

insert into task values ('6c552069-874a-4335-94b7-62cb7fb32a75', '65824e36-8d65-475f-a3d7-bc47ee1a97c1', 1, 'Прочитай внимательно текст', null, null, 'c98d26b4-2f09-4b40-a020-72f2e3f877d8');
insert into task values ('c5638830-dd2c-49b0-8fb1-8b06b1ae97b2', '65824e36-8d65-475f-a3d7-bc47ee1a97c1', 2, 'Ответь на вопросы', null, 1, 'c601fc92-e680-4bb7-b6b3-b97fcb09a90f');
insert into task values ('de18553e-2002-416e-9b93-b57bcb830007', '65824e36-8d65-475f-a3d7-bc47ee1a97c1', 3, 'Найди предложения к картинке и подчеркни его', null, null, '402375b9-ffa6-42dd-ac57-8e5415f0b821');
insert into task values ('75ac4db2-52d5-40dd-ab5c-d7ae8edf5a96', '65824e36-8d65-475f-a3d7-bc47ee1a97c1', 4, 'Пронумеруй по порядку предложения', null, 1, 'c601fc92-e680-4bb7-b6b3-b97fcb09a90f');
insert into task values ('3e47544f-b9bb-4d63-b1b3-b4910b4c550d', '9d565bdd-b1fb-44eb-af50-7490555b5708', 1, 'Подпиши части тела мальчика.', null, 1, 'c601fc92-e680-4bb7-b6b3-b97fcb09a90f');
insert into task values ('2a035365-566a-45d5-b3e9-524758d2ca94', '9d565bdd-b1fb-44eb-af50-7490555b5708', 2, 'Прочитай слова. Запиши ответы в таблицу цифрой.', '1) осязание 2) обоняние 3) вкус 4) слух 5) зрение', 1, 'c601fc92-e680-4bb7-b6b3-b97fcb09a90f');
insert into task values ('7a8bf3f0-9f84-4b07-a5d0-58c8404af5ef', '9d565bdd-b1fb-44eb-af50-7490555b5708', 3, 'Раздели птиц на две группы:', 'курица, голубь, ворона, петух, воробей, индюк, дрозды.', 7, 'c601fc92-e680-4bb7-b6b3-b97fcb09a90f');
insert into task values ('a6ceda33-3f0c-454a-bf22-be8ec81ea554', '9d565bdd-b1fb-44eb-af50-7490555b5708', 4, 'Расставь по порядку.', 'цифра 1 уже стоит.', 1, 'c601fc92-e680-4bb7-b6b3-b97fcb09a90f');
insert into task values ('1452ed08-a73d-4c20-975a-bb6f5839a907', '9d565bdd-b1fb-44eb-af50-7490555b5708', 5, 'Подпиши времена года нарисованные на картинках.', null, 1, 'c601fc92-e680-4bb7-b6b3-b97fcb09a90f');
insert into task values ('6fa0d664-ff68-4ac1-8c7c-6a10d8acc775', '9d565bdd-b1fb-44eb-af50-7490555b5708', 6, 'На каком рисунке изображен лист дуба?', null, null, '402375b9-ffa6-42dd-ac57-8e5415f0b821');
insert into task values ('16c59680-dcc8-46de-ae41-9f1728346c06', '9d565bdd-b1fb-44eb-af50-7490555b5708', 7, 'Подчеркни лишнее растение.', null, null, '402375b9-ffa6-42dd-ac57-8e5415f0b821');
insert into task values ('ca9303c5-ae4e-4926-a6ce-d391b3e2d84b', '9d565bdd-b1fb-44eb-af50-7490555b5708', 8, 'Подпиши названия птиц.', null, null, 'c601fc92-e680-4bb7-b6b3-b97fcb09a90f');
insert into task values ('383e7536-c178-4542-9b32-5105a70a0221', '9d565bdd-b1fb-44eb-af50-7490555b5708', 9, 'Подчеркни домашних животных красным карандашом, диких – синим.', null, null, '402375b9-ffa6-42dd-ac57-8e5415f0b821');
insert into task values ('b69f0d84-cc53-4cd7-af1a-afb8bfe5a643', '9d565bdd-b1fb-44eb-af50-7490555b5708', 10, 'Ответь на вопросы', null, null, 'c601fc92-e680-4bb7-b6b3-b97fcb09a90f');
insert into task values ('f35c48b2-66cb-49e8-ae13-f4c5e9a6cc0c', '9d565bdd-b1fb-44eb-af50-7490555b5708', 11, 'Какой из нарисованных флагов является флагом нашей страны? Подчеркни.', null, null, '402375b9-ffa6-42dd-ac57-8e5415f0b821');

-- Тексты заданий с типом ответа read
select * from task_text;
select * from task;

insert into task_text values ('93d41e1e-ef67-435a-87a0-2394b7cbef0d', '6c552069-874a-4335-94b7-62cb7fb32a75', 'Встреча', 'Илья катался на лыжах. Он заехал далеко в лес. Тут мальчик заметил большую рыжую кошку. Она лежала на дереве. У кошки были зелёные глаза и кисточки на ушах. Сильные лапы впились в ствол. Это была рысь. Рысь прыгнула в снег. Илья затих. Рысь удалилась в лес.');

-- Позиции ответов заданий с типами typing и choose
select * from task_answer_position;
select * from task;

/*
'2b9ade7e-f3b6-4d23-83f8-8c2f10170e0f', 'right'
'ea5f9f92-4378-435d-bdce-8af8b8c9aa12', 'left'
'd573ca82-eec8-4192-838a-26b66e57c5dc', 'below'
 */

insert into task_answer_position values ('70de5ddf-d74e-4c5e-8ce0-e091015c4445', 'c5638830-dd2c-49b0-8fb1-8b06b1ae97b2', '2b9ade7e-f3b6-4d23-83f8-8c2f10170e0f');
insert into task_answer_position values ('9e8c2a19-a13d-4d0a-87fe-60313c808c2b', 'de18553e-2002-416e-9b93-b57bcb830007', 'd573ca82-eec8-4192-838a-26b66e57c5dc');
insert into task_answer_position values ('a26386ca-50ff-4b19-b2d9-499cd06073ee', '75ac4db2-52d5-40dd-ab5c-d7ae8edf5a96', 'ea5f9f92-4378-435d-bdce-8af8b8c9aa12');
insert into task_answer_position values ('1ef09e8f-f288-4551-8d99-cf7a54446532', '3e47544f-b9bb-4d63-b1b3-b4910b4c550d', '2b9ade7e-f3b6-4d23-83f8-8c2f10170e0f');
insert into task_answer_position values ('d87b04b2-e4c7-43e7-8599-c753a80cddb2', '2a035365-566a-45d5-b3e9-524758d2ca94', 'd573ca82-eec8-4192-838a-26b66e57c5dc');
insert into task_answer_position values ('897b9fff-5af4-45da-8920-26ddd4eb887c', '7a8bf3f0-9f84-4b07-a5d0-58c8404af5ef', 'd573ca82-eec8-4192-838a-26b66e57c5dc');
insert into task_answer_position values ('34364913-414c-4dc4-ba98-245cdadfc5bf', 'a6ceda33-3f0c-454a-bf22-be8ec81ea554', 'd573ca82-eec8-4192-838a-26b66e57c5dc');
insert into task_answer_position values ('23edf1d4-fd3f-434c-9d10-76e9b6436052', '1452ed08-a73d-4c20-975a-bb6f5839a907', '2b9ade7e-f3b6-4d23-83f8-8c2f10170e0f');
insert into task_answer_position values ('1e6562ab-a09e-4bb3-b199-f305e8c31803', '6fa0d664-ff68-4ac1-8c7c-6a10d8acc775', 'd573ca82-eec8-4192-838a-26b66e57c5dc');
insert into task_answer_position values ('3e12bb8a-e8e6-4332-922e-c65038066cb0', '16c59680-dcc8-46de-ae41-9f1728346c06', 'd573ca82-eec8-4192-838a-26b66e57c5dc');
insert into task_answer_position values ('046ca316-bbb8-44cc-b772-30726aa5d3ad', 'ca9303c5-ae4e-4926-a6ce-d391b3e2d84b', 'd573ca82-eec8-4192-838a-26b66e57c5dc');
insert into task_answer_position values ('52cdb252-3b51-4bfc-a89c-1f46b63671ca', '383e7536-c178-4542-9b32-5105a70a0221', 'd573ca82-eec8-4192-838a-26b66e57c5dc');
insert into task_answer_position values ('8cded509-89cc-48d4-b88d-0867c16d37d6', 'b69f0d84-cc53-4cd7-af1a-afb8bfe5a643', '2b9ade7e-f3b6-4d23-83f8-8c2f10170e0f');
insert into task_answer_position values ('bd986ca5-b46b-4190-b501-68b9fd59eeee', 'f35c48b2-66cb-49e8-ae13-f4c5e9a6cc0c', 'd573ca82-eec8-4192-838a-26b66e57c5dc');

-- Картинки заданий
select * from task_image;
select * from task;
select * from image;

insert into task_image values ('fbc06aab-5a3c-476d-9c49-d3313eead109', 'de18553e-2002-416e-9b93-b57bcb830007', 'c053f99d-ba1c-453a-af4d-e3fe0031c400');
insert into task_image values ('87cfb1ae-ab1b-49bb-832a-fb2146269976', '3e47544f-b9bb-4d63-b1b3-b4910b4c550d', '3765d6e3-f311-4969-86de-1d94f99a7494');

-- Форматы ответов на задания с типом typing
select * from task_answer_typing_format;
select * from task;

/*
'37b35df1-f6f5-4fd0-8b28-494502c6912c', 'text'
'b016a6e4-3a51-4552-9be9-44ba2a98b876', 'digit'
 */

insert into task_answer_typing_format values ('e5a563d0-bc44-4b41-92c8-27abef7af29b', 'c5638830-dd2c-49b0-8fb1-8b06b1ae97b2', '37b35df1-f6f5-4fd0-8b28-494502c6912c');
insert into task_answer_typing_format values ('2fb83afb-a0ce-41c4-b54b-cdd11825c4e2', '75ac4db2-52d5-40dd-ab5c-d7ae8edf5a96', 'b016a6e4-3a51-4552-9be9-44ba2a98b876');
insert into task_answer_typing_format values ('a88c89a0-aca0-4fcd-b5dc-9beb0e6431df', '3e47544f-b9bb-4d63-b1b3-b4910b4c550d', '37b35df1-f6f5-4fd0-8b28-494502c6912c');
insert into task_answer_typing_format values ('a60cc175-c574-4810-a51b-ab812c927a8e', '7a8bf3f0-9f84-4b07-a5d0-58c8404af5ef', '37b35df1-f6f5-4fd0-8b28-494502c6912c');
insert into task_answer_typing_format values ('a6451423-d99d-4161-8430-ef0d224c56a5', 'a6ceda33-3f0c-454a-bf22-be8ec81ea554', 'b016a6e4-3a51-4552-9be9-44ba2a98b876');
insert into task_answer_typing_format values ('e59c2f8c-32db-431b-9d41-635b625ea2d3', '1452ed08-a73d-4c20-975a-bb6f5839a907', '37b35df1-f6f5-4fd0-8b28-494502c6912c');
insert into task_answer_typing_format values ('03c01a0c-b446-49b3-8eb2-ec327af1146b', 'ca9303c5-ae4e-4926-a6ce-d391b3e2d84b', '37b35df1-f6f5-4fd0-8b28-494502c6912c');
insert into task_answer_typing_format values ('d8a3d072-4cfc-4b7f-9541-62cfa0740b7b', 'b69f0d84-cc53-4cd7-af1a-afb8bfe5a643', '37b35df1-f6f5-4fd0-8b28-494502c6912c');

-- Способы ответов на задания с типом choose
select * from task_answer_choose_type;
select * from task;

/*
'93be22dc-2b74-4a61-9f6a-678d3169c43b', 'underline'
'eeee40a3-ccf6-4c34-9fb4-25374fd732de', 'check'
 */

insert into task_answer_choose_type values ('b037657a-b0ee-4c1d-a083-a49c6c6f9d2f', 'de18553e-2002-416e-9b93-b57bcb830007', '93be22dc-2b74-4a61-9f6a-678d3169c43b');
insert into task_answer_choose_type values ('c8cf4e11-7a18-48ed-bc86-c5f891fd25bb', '6fa0d664-ff68-4ac1-8c7c-6a10d8acc775', '93be22dc-2b74-4a61-9f6a-678d3169c43b');
insert into task_answer_choose_type values ('ea38e5e1-0f26-4926-a467-cfae24c96a12', '16c59680-dcc8-46de-ae41-9f1728346c06', '93be22dc-2b74-4a61-9f6a-678d3169c43b');
insert into task_answer_choose_type values ('990a3a51-bdaf-4487-b8ff-11f3e9db77e2', '383e7536-c178-4542-9b32-5105a70a0221', '93be22dc-2b74-4a61-9f6a-678d3169c43b');
insert into task_answer_choose_type values ('53b03419-0396-4e0d-92e0-881f939c3979', 'f35c48b2-66cb-49e8-ae13-f4c5e9a6cc0c', '93be22dc-2b74-4a61-9f6a-678d3169c43b');

-- Цвета для ответа на задания с типом choose
select * from task_answer_choose_color;
select * from task;

/*
'5fb1318d-d60b-482b-b71a-1cad8f1c3054', 'grey'
'eddf320f-f587-43f3-9858-62361fcee034', 'red'
'9f902817-5d6c-48fd-a5f6-a039d3f5b407', 'blue'
 */

insert into task_answer_choose_color values ('fdc09b87-5afe-45d1-a07e-9393a19bf248', 'de18553e-2002-416e-9b93-b57bcb830007', '5fb1318d-d60b-482b-b71a-1cad8f1c3054');
insert into task_answer_choose_color values ('9ce0cf59-6485-4f4a-8167-a9c4029a3af6', '6fa0d664-ff68-4ac1-8c7c-6a10d8acc775', '5fb1318d-d60b-482b-b71a-1cad8f1c3054');
insert into task_answer_choose_color values ('dade06eb-f536-4e74-b0cd-e47dceee617e', '16c59680-dcc8-46de-ae41-9f1728346c06', '5fb1318d-d60b-482b-b71a-1cad8f1c3054');
insert into task_answer_choose_color values ('2461bbab-ff22-459e-ac47-7e84d39896c8', '383e7536-c178-4542-9b32-5105a70a0221', 'eddf320f-f587-43f3-9858-62361fcee034');
insert into task_answer_choose_color values ('129b1dcc-e3e9-4c39-8d65-8006da2118d8', '383e7536-c178-4542-9b32-5105a70a0221', '9f902817-5d6c-48fd-a5f6-a039d3f5b407');
insert into task_answer_choose_color values ('0f0eb8b6-07b2-447c-ace0-4818aeb47821', '16c59680-dcc8-46de-ae41-9f1728346c06', '5fb1318d-d60b-482b-b71a-1cad8f1c3054');

-- Предложенные ответы заданий с типом choose
select * from task_proposed_answer;
select * from task;
select * from answer_choose_color;

insert into task_proposed_answer values ('f96ca457-6044-4dff-9d52-2b6bcee61dbc', 'de18553e-2002-416e-9b93-b57bcb830007', 'Илья катался на лыжах. Он заехал далеко в лес', true, null);
insert into task_proposed_answer values ('c31f7836-4489-4aef-a0cf-bf18e4fe6a45', 'de18553e-2002-416e-9b93-b57bcb830007', 'Тут мальчик заметил большую рыжую кошку. Она лежала на дереве', false, null);
insert into task_proposed_answer values ('2c0f660c-244e-4fe6-9446-2251939891b6', 'de18553e-2002-416e-9b93-b57bcb830007', 'У кошки были зелёные глаза и кисточки на ушах. Сильные лапы впились в ствол. Это была рысь.', false, null);
insert into task_proposed_answer values ('b2e267da-cd67-4dc5-bb1e-c010313f57a2', 'de18553e-2002-416e-9b93-b57bcb830007', 'Рысь прыгнула в снег. Илья затих. Рысь удалилась в лес.', false, null);
insert into task_proposed_answer values ('773bc682-5a65-490f-a70d-d8a6e7137b37', '6fa0d664-ff68-4ac1-8c7c-6a10d8acc775', null, false, null);
insert into task_proposed_answer values ('6e4711dc-f8ca-4fdf-8fed-59e60837b3f6', '6fa0d664-ff68-4ac1-8c7c-6a10d8acc775', null, true, null);
insert into task_proposed_answer values ('adc804c5-9a1d-4efe-8b4b-1477ed3ab285', '6fa0d664-ff68-4ac1-8c7c-6a10d8acc775', null, false, null);
insert into task_proposed_answer values ('61f75818-fef2-4738-b18a-c08503abae1f', '6fa0d664-ff68-4ac1-8c7c-6a10d8acc775', null, false, null);
insert into task_proposed_answer values ('133c0a93-aa07-4fac-a286-daeaefa64b76', '6fa0d664-ff68-4ac1-8c7c-6a10d8acc775', null, false, null);
insert into task_proposed_answer values ('02dd75dc-c0a2-4c78-abcb-37e06c09fcad', '16c59680-dcc8-46de-ae41-9f1728346c06', 'яблоня', false, null);
insert into task_proposed_answer values ('3889c64f-77ee-4427-b382-581482af5c0b', '16c59680-dcc8-46de-ae41-9f1728346c06', 'груша', false, null);
insert into task_proposed_answer values ('96bafed1-d2aa-4cf3-9d58-6a48c55f057f', '16c59680-dcc8-46de-ae41-9f1728346c06', 'слива', false, null);
insert into task_proposed_answer values ('f9dadf1b-92c6-47d1-a6ff-9646a8e02c0e', '16c59680-dcc8-46de-ae41-9f1728346c06', 'берёза', true, null);
insert into task_proposed_answer values ('edf4a80d-1405-4a68-b14e-b36fccb21ee3', '16c59680-dcc8-46de-ae41-9f1728346c06', 'вишня', false, null);
insert into task_proposed_answer values ('ff4c436c-a392-4efa-be20-eaba4ef793e9', '383e7536-c178-4542-9b32-5105a70a0221', 'кошка', null, 'eddf320f-f587-43f3-9858-62361fcee034');
insert into task_proposed_answer values ('d489d1c7-c702-4170-b2d9-d4d093da6294', '383e7536-c178-4542-9b32-5105a70a0221', 'лиса', null, '9f902817-5d6c-48fd-a5f6-a039d3f5b407');
insert into task_proposed_answer values ('517f2ae1-0969-4c86-9abc-8f6921d16dc6', '383e7536-c178-4542-9b32-5105a70a0221', 'коза', null, 'eddf320f-f587-43f3-9858-62361fcee034');
insert into task_proposed_answer values ('48c9bedd-e017-466c-8b92-a37235a8db04', '383e7536-c178-4542-9b32-5105a70a0221', 'медведь', null, '9f902817-5d6c-48fd-a5f6-a039d3f5b407');
insert into task_proposed_answer values ('6776d752-948e-4c5c-9734-58edf030ca9f', '383e7536-c178-4542-9b32-5105a70a0221', 'свинья', null, 'eddf320f-f587-43f3-9858-62361fcee034');
insert into task_proposed_answer values ('5e4cf945-0bad-4045-a462-64399096731c', '383e7536-c178-4542-9b32-5105a70a0221', 'волк', null, '9f902817-5d6c-48fd-a5f6-a039d3f5b407');
insert into task_proposed_answer values ('e3fd4eb9-5569-4da4-a1dd-142f80c5fc65', 'f35c48b2-66cb-49e8-ae13-f4c5e9a6cc0c', null, true, null);
insert into task_proposed_answer values ('afee4a3d-8fac-4552-a8f3-706968a69280', 'f35c48b2-66cb-49e8-ae13-f4c5e9a6cc0c', null, false, null);
insert into task_proposed_answer values ('6245926c-d6fa-4076-87e3-ba275daaa782', 'f35c48b2-66cb-49e8-ae13-f4c5e9a6cc0c', null, false, null);

-- Картинки предложенных ответов на задания с типом choose
select * from task_proposed_answer_image;
select * from task_proposed_answer;
select * from image;
select * from task;

insert into task_proposed_answer_image values ('12566fab-16d6-4d26-b0ae-6edc9f8d7c69', '773bc682-5a65-490f-a70d-d8a6e7137b37', '852fb095-2278-45f6-8ca3-439b18bb19c2');
insert into task_proposed_answer_image values ('8ce2650a-4c76-4400-9166-61d98a5220ce', '6e4711dc-f8ca-4fdf-8fed-59e60837b3f6', '8bf71dad-712e-4ef7-a97b-ebeec2917745');
insert into task_proposed_answer_image values ('4c26ba24-5891-4549-9bfa-655fc5ba05bd', 'adc804c5-9a1d-4efe-8b4b-1477ed3ab285', 'a1d1a88a-d624-43c1-9a53-b8419b2b4b0c');
insert into task_proposed_answer_image values ('1f8b42f0-6956-474d-808c-0511deb47d46', '61f75818-fef2-4738-b18a-c08503abae1f', '8ed867f7-3116-4cf7-82a5-40ce749ea6e6');
insert into task_proposed_answer_image values ('66b4e885-6db8-4684-9826-81e5e084e0a9', '133c0a93-aa07-4fac-a286-daeaefa64b76', '1d52db69-05b1-455e-b0d8-865ae3c2b6ae');
insert into task_proposed_answer_image values ('1dbf3e7b-f494-4c38-9081-0ce1f6b4b6ff', 'e3fd4eb9-5569-4da4-a1dd-142f80c5fc65', '4b10dd8b-3738-448b-8446-5b52a7ac9819');
insert into task_proposed_answer_image values ('c6d58ebb-60f5-4eba-a894-d985e8264d1f', 'afee4a3d-8fac-4552-a8f3-706968a69280', 'ee036ce6-c8ee-4cf5-912e-8943f05b26a9');
insert into task_proposed_answer_image values ('d17df26b-5895-4c7f-ba58-5df651322168', '6245926c-d6fa-4076-87e3-ba275daaa782', 'd9b07c5a-1aab-4204-8140-6c6c2831d8a6');

-- Правильные ответы заданий с типом typing
select * from task_correct_typing_answer;

-- Типы отображения заданий
select * from task_view_type;
select * from task;

/*
'cc3efb92-7149-473b-b6d6-618fb380a584', 'rows'
'a6871068-80db-4cd6-9f2c-d526e5edcc03', 'table'
 */

insert into task_view_type values ('d3f9d2ad-0519-4ed9-b4c0-87031ada246c', 'c5638830-dd2c-49b0-8fb1-8b06b1ae97b2', 'cc3efb92-7149-473b-b6d6-618fb380a584');
insert into task_view_type values ('385ea72c-eaaf-4e36-8730-525f9f5b156d', 'de18553e-2002-416e-9b93-b57bcb830007', 'cc3efb92-7149-473b-b6d6-618fb380a584');
insert into task_view_type values ('d373897a-32e4-4c76-87b7-983b0ce2ca68', '75ac4db2-52d5-40dd-ab5c-d7ae8edf5a96', 'cc3efb92-7149-473b-b6d6-618fb380a584');
insert into task_view_type values ('104e5569-61c2-4dd2-9b9e-8b1a999e7f8d', '3e47544f-b9bb-4d63-b1b3-b4910b4c550d', 'cc3efb92-7149-473b-b6d6-618fb380a584');
insert into task_view_type values ('51683539-93ca-46c3-9de1-76de13722f15', '2a035365-566a-45d5-b3e9-524758d2ca94', 'a6871068-80db-4cd6-9f2c-d526e5edcc03');
insert into task_view_type values ('1b7a5fe3-753b-43f5-b953-797629810a8a', '7a8bf3f0-9f84-4b07-a5d0-58c8404af5ef', 'a6871068-80db-4cd6-9f2c-d526e5edcc03');
insert into task_view_type values ('f203593b-54fe-45f5-ba86-add3d2df75ff', 'a6ceda33-3f0c-454a-bf22-be8ec81ea554', 'a6871068-80db-4cd6-9f2c-d526e5edcc03');
insert into task_view_type values ('8a946838-79ae-4af0-a541-00acd7ec1b2b', '1452ed08-a73d-4c20-975a-bb6f5839a907', 'cc3efb92-7149-473b-b6d6-618fb380a584');
insert into task_view_type values ('ea2dd462-f069-4383-bcbd-0e9d915f2e89', 'ca9303c5-ae4e-4926-a6ce-d391b3e2d84b', 'a6871068-80db-4cd6-9f2c-d526e5edcc03');
insert into task_view_type values ('e97c5077-0ab8-4b6d-b775-8b7680310f25', '383e7536-c178-4542-9b32-5105a70a0221', 'a6871068-80db-4cd6-9f2c-d526e5edcc03');
insert into task_view_type values ('d495d6c2-0373-43cf-9e6e-75f39b6849dc', 'b69f0d84-cc53-4cd7-af1a-afb8bfe5a643', 'cc3efb92-7149-473b-b6d6-618fb380a584');
insert into task_view_type values ('c9972191-5c05-42ab-a8b1-063872153c3f', 'f35c48b2-66cb-49e8-ae13-f4c5e9a6cc0c', 'a6871068-80db-4cd6-9f2c-d526e5edcc03');

-- Вопросы заданий с типом typing
select * from task_question;
select * from task;

insert into task_question values ('813defb9-3e0b-4b50-8a83-f3663f92deae', 'c5638830-dd2c-49b0-8fb1-8b06b1ae97b2', 1, 'Как звали мальчика?', null);
insert into task_question values ('055e03a3-d85d-4964-a6ea-8e6a30770b58', 'c5638830-dd2c-49b0-8fb1-8b06b1ae97b2', 2, 'Где он катался на лыжах?', null);
insert into task_question values ('64a1de7f-26e7-4e0f-b075-ec1691ad62bd', 'c5638830-dd2c-49b0-8fb1-8b06b1ae97b2', 3, 'Кого Илья повстречал в лесу?', null);
insert into task_question values ('9e1b2378-7e19-4fc7-bb1b-63c34c1b9065', 'c5638830-dd2c-49b0-8fb1-8b06b1ae97b2', 4, 'Рысь – это домашняя кошка?', null);
insert into task_question values ('def40907-c084-4952-bef2-f02f0526b141', 'c5638830-dd2c-49b0-8fb1-8b06b1ae97b2', 5, 'Чем закончилась это встреча?', null);
insert into task_question values ('0426fd61-8653-4ff3-b1c3-8642a61d59a4', '75ac4db2-52d5-40dd-ab5c-d7ae8edf5a96', null, 'Тут мальчик заметил большую рыжую кошку.', null);
insert into task_question values ('82787684-a5e0-4761-9c53-501f7917139a', '75ac4db2-52d5-40dd-ab5c-d7ae8edf5a96', null, 'Илья катался на лыжах. Он заехал далеко в лес.', null);
insert into task_question values ('2412261c-1b4f-4982-9fc8-34df709b03e9', '75ac4db2-52d5-40dd-ab5c-d7ae8edf5a96', null, 'Рысь прыгнула в снег. Илья затих. Рысь удалилась в лес.', null);
insert into task_question values ('e683faad-1ae7-435f-a877-f383b56c2b70', '75ac4db2-52d5-40dd-ab5c-d7ae8edf5a96', null, 'Она лежала на дереве. У кошки были зелёные глаза и кисточки на ушах.', null);
insert into task_question values ('677a228b-729c-499c-baa0-506e2ba4c6ea', '75ac4db2-52d5-40dd-ab5c-d7ae8edf5a96', null, 'Сильные лапы впились в ствол. Это была рысь.', null);
insert into task_question values ('133fccd7-e941-4a8f-9890-c246a4e42cb7', '3e47544f-b9bb-4d63-b1b3-b4910b4c550d', 1, null, null);
insert into task_question values ('6fb8d351-6050-4791-9e58-d8eee89911d5', '3e47544f-b9bb-4d63-b1b3-b4910b4c550d', 2, null, null);
insert into task_question values ('55ae789a-f118-4416-8f77-aa631254aec2', '3e47544f-b9bb-4d63-b1b3-b4910b4c550d', 3, null, null);
insert into task_question values ('8fe567fb-6937-4ef5-9a54-97300fa09b7b', '3e47544f-b9bb-4d63-b1b3-b4910b4c550d', 4, null, null);
insert into task_question values ('c86c8ad6-11e4-4856-a246-a5b41bf503c5', '2a035365-566a-45d5-b3e9-524758d2ca94', null, 'нос', null);
insert into task_question values ('dba1149b-d134-4729-b98e-fdb84a4830d3', '2a035365-566a-45d5-b3e9-524758d2ca94', null, 'глаза', null);
insert into task_question values ('622dad2f-6bb4-4dc0-b386-0043f84478f0', '2a035365-566a-45d5-b3e9-524758d2ca94', null, 'кожа', null);
insert into task_question values ('25deef36-85a4-4c6f-943a-4058574a94e5', '2a035365-566a-45d5-b3e9-524758d2ca94', null, 'язык', null);
insert into task_question values ('c0649777-8333-4026-9788-2510ec210de8', '2a035365-566a-45d5-b3e9-524758d2ca94', null, 'уши', null);
insert into task_question values ('2d88712c-821f-455e-89ba-a4852ad70632', '7a8bf3f0-9f84-4b07-a5d0-58c8404af5ef', null, 'Дикие', null);
insert into task_question values ('acdead10-5012-43eb-9cbd-ea98b10a5eb6', '7a8bf3f0-9f84-4b07-a5d0-58c8404af5ef', null, 'Домашние', null);
insert into task_question values ('5b38a343-32a9-42e0-b1db-2e897ac96c72', 'a6ceda33-3f0c-454a-bf22-be8ec81ea554', null, null, null);
insert into task_question values ('0935ea18-cdb8-40b6-a543-da55356a9dd8', 'a6ceda33-3f0c-454a-bf22-be8ec81ea554', null, null, null);
insert into task_question values ('2ce28698-1dae-4526-8070-ca7c2280e43a', 'a6ceda33-3f0c-454a-bf22-be8ec81ea554', null, null, null);
insert into task_question values ('593b3b62-fa98-43d5-bafe-1b37974e37b4', 'a6ceda33-3f0c-454a-bf22-be8ec81ea554', null, null, '1');
insert into task_question values ('182ec441-ecf0-4d36-bed1-7c10408f6b50', '1452ed08-a73d-4c20-975a-bb6f5839a907', null, null, null);
insert into task_question values ('31965f7e-1d23-402d-bc29-76758bc043e9', '1452ed08-a73d-4c20-975a-bb6f5839a907', null, null, null);
insert into task_question values ('dee68fd7-bb05-471e-befa-7c26beb05fa9', '1452ed08-a73d-4c20-975a-bb6f5839a907', null, null, null);
insert into task_question values ('468f4d4a-9ca2-491e-a60b-6f3fad704cc2', '1452ed08-a73d-4c20-975a-bb6f5839a907', null, null, null);
insert into task_question values ('18a93288-2e96-4f1b-82e2-89459812cacb', 'ca9303c5-ae4e-4926-a6ce-d391b3e2d84b', null, null, null);
insert into task_question values ('291530a5-6086-4a10-840f-8ef515e91639', 'ca9303c5-ae4e-4926-a6ce-d391b3e2d84b', null, null, null);
insert into task_question values ('04dab6a0-465f-4eea-afe1-4699c09136fb', 'ca9303c5-ae4e-4926-a6ce-d391b3e2d84b', null, null, null);
insert into task_question values ('a0703d3c-a4c1-4c14-a00b-5cd542eabf08', 'b69f0d84-cc53-4cd7-af1a-afb8bfe5a643', null, 'Сколько времен года ты знаешь?', null);
insert into task_question values ('2c6e391d-23bd-4d94-8aac-2d30a6843be2', 'b69f0d84-cc53-4cd7-af1a-afb8bfe5a643', null, 'Сколько месяцев в году?', null);
insert into task_question values ('1799579c-8d5c-4885-a297-306d9be8ae26', 'b69f0d84-cc53-4cd7-af1a-afb8bfe5a643', null, 'Сколько дней в неделе?', null);
insert into task_question values ('09ba608d-018c-4a2b-98a7-15c37fb5a002', 'b69f0d84-cc53-4cd7-af1a-afb8bfe5a643', null, 'Суббота какой по счёту день недели?', null);
insert into task_question values ('4019258e-b9b9-4e4a-856a-056294af1240', 'b69f0d84-cc53-4cd7-af1a-afb8bfe5a643', null, 'Как называется страна, в которой ты живёшь?', null);

-- Картинки вопросов заданий
select * from task_question_image;
select * from task;
select * from image;

insert into task_question_image values ('404e521c-7f7a-4bb9-af87-182b36f3fe05', '5b38a343-32a9-42e0-b1db-2e897ac96c72', '15a93112-5f59-4a19-ad46-7ec7cdffeec1');
insert into task_question_image values ('5a403bef-31cd-42de-9ccf-a025b1b59c37', '0935ea18-cdb8-40b6-a543-da55356a9dd8', '3eb4fb79-6ad2-49a4-a5d8-15532319c2b1');
insert into task_question_image values ('2d811b84-6420-41bc-b588-0a527de6f44a', '2ce28698-1dae-4526-8070-ca7c2280e43a', '2e0ea931-2cbe-40f0-8e41-591c2a1461a1');
insert into task_question_image values ('8135ad77-874a-43d5-a591-f9e635ff8fbf', '593b3b62-fa98-43d5-bafe-1b37974e37b4', 'f12b229a-3b09-4d9a-93f1-8cfcc22b553e');
insert into task_question_image values ('3752baf6-2156-402a-a99b-afa22da3280d', '18a93288-2e96-4f1b-82e2-89459812cacb', '0290c512-0c9e-4fd8-a067-c26f7981d613');
insert into task_question_image values ('2a6df6ab-8992-48a3-beb6-fa33b9c9a66e', '291530a5-6086-4a10-840f-8ef515e91639', 'ed93c030-b40e-45b8-b345-37c8b29a7a82');
insert into task_question_image values ('b7e99d64-25a3-49c7-8efb-f3cf54ee01b1', '04dab6a0-465f-4eea-afe1-4699c09136fb', '8916d9b4-c692-47b0-9379-3a3748301026');

-- Правильные ответы заданий с типом typing
select * from task_question_correct_typing_answer;
select * from task_question;

insert into task_question_correct_typing_answer values ('3367c7f0-fda9-4170-812f-49c92b51a4f7', '813defb9-3e0b-4b50-8a83-f3663f92deae', 'Илья');
insert into task_question_correct_typing_answer values ('e0b23298-feb1-4495-b5f4-d32206434f22', '055e03a3-d85d-4964-a6ea-8e6a30770b58', 'В лесу');
insert into task_question_correct_typing_answer values ('89a1f9f7-9c16-4b67-bbb3-7d40b5d1d344', '64a1de7f-26e7-4e0f-b075-ec1691ad62bd', 'Рысь');
insert into task_question_correct_typing_answer values ('07131664-c6a6-485a-a305-d050d6c57bc5', '9e1b2378-7e19-4fc7-bb1b-63c34c1b9065', 'Нет');
insert into task_question_correct_typing_answer values ('00ba0732-5e46-4530-bb35-f236d5720585', 'def40907-c084-4952-bef2-f02f0526b141', 'Рысь прыгнула в снег. Илья затих. Рысь удалилась в лес.');
insert into task_question_correct_typing_answer values ('4f0f8581-22d5-4ca7-87d5-d5ba501e33b0', '0426fd61-8653-4ff3-b1c3-8642a61d59a4', '2');
insert into task_question_correct_typing_answer values ('4d6a249d-c9e3-4504-a3bc-cb396c65d407', '82787684-a5e0-4761-9c53-501f7917139a', '1');
insert into task_question_correct_typing_answer values ('a89aaa90-433c-4501-b098-46029c911f37', '2412261c-1b4f-4982-9fc8-34df709b03e9', '5');
insert into task_question_correct_typing_answer values ('50d0960d-6eee-4916-aceb-435b303c90f3', 'e683faad-1ae7-435f-a877-f383b56c2b70', '3');
insert into task_question_correct_typing_answer values ('bd36e571-43ba-42bd-9cad-3644f882a37e', '677a228b-729c-499c-baa0-506e2ba4c6ea', '4');
insert into task_question_correct_typing_answer values ('4e51fe17-469b-4f2f-ad03-13e341e73c25', '133fccd7-e941-4a8f-9890-c246a4e42cb7', 'Голова');
insert into task_question_correct_typing_answer values ('d4014173-b201-46c7-9847-42f56e5a3347', '6fb8d351-6050-4791-9e58-d8eee89911d5', 'Шея');
insert into task_question_correct_typing_answer values ('b2de48bb-930b-42f3-98ff-a59fd96e5cc4', '55ae789a-f118-4416-8f77-aa631254aec2', 'Рука');
insert into task_question_correct_typing_answer values ('7eba53bd-25fd-4818-a41d-5de7d2769499', '8fe567fb-6937-4ef5-9a54-97300fa09b7b', 'Нога');
insert into task_question_correct_typing_answer values ('4d302671-d405-48ed-9384-5c6dc3d1ab0f', 'c86c8ad6-11e4-4856-a246-a5b41bf503c5', 'обоняние');
insert into task_question_correct_typing_answer values ('586b6a17-2677-4d9b-b1b2-185d0e45d7fc', 'dba1149b-d134-4729-b98e-fdb84a4830d3', 'зрение');
insert into task_question_correct_typing_answer values ('1de839fc-a1dc-4941-ae43-a4cd9fa5f6e9', '622dad2f-6bb4-4dc0-b386-0043f84478f0', 'осязание');
insert into task_question_correct_typing_answer values ('eca13ff8-824a-4afa-a6fa-3f4ed338fa61', '25deef36-85a4-4c6f-943a-4058574a94e5', 'вкус');
insert into task_question_correct_typing_answer values ('55aaff8a-ad83-434f-a90a-1615ad96cdde', 'c0649777-8333-4026-9788-2510ec210de8', 'слух');
insert into task_question_correct_typing_answer values ('1428304a-732e-416e-896d-ba79d5db31c7', '2d88712c-821f-455e-89ba-a4852ad70632', 'голубь');
insert into task_question_correct_typing_answer values ('e9550f2b-e845-4141-9550-58fc4a783cf1', '2d88712c-821f-455e-89ba-a4852ad70632', 'ворона');
insert into task_question_correct_typing_answer values ('164ab184-6356-491c-8eb0-e4c0a0563087', '2d88712c-821f-455e-89ba-a4852ad70632', 'воробей');
insert into task_question_correct_typing_answer values ('f47022d3-1806-40c9-82d3-101c46e12239', '2d88712c-821f-455e-89ba-a4852ad70632', 'дрозды');
insert into task_question_correct_typing_answer values ('db7da9d3-a535-4eca-a0b4-1d3c92f5d0dc', 'acdead10-5012-43eb-9cbd-ea98b10a5eb6', 'курица');
insert into task_question_correct_typing_answer values ('ec7d18e5-7cb7-4dd4-be1a-ccf110078ab6', 'acdead10-5012-43eb-9cbd-ea98b10a5eb6', 'петух');
insert into task_question_correct_typing_answer values ('2858db39-72ce-45cf-bca2-3b332480f708', 'acdead10-5012-43eb-9cbd-ea98b10a5eb6', 'индюк');
insert into task_question_correct_typing_answer values ('69463252-f235-498a-b9b1-3dd3b625f8e6', '5b38a343-32a9-42e0-b1db-2e897ac96c72', '3');
insert into task_question_correct_typing_answer values ('c27bf2ee-171a-4e68-a416-fca645531562', '0935ea18-cdb8-40b6-a543-da55356a9dd8', '4');
insert into task_question_correct_typing_answer values ('e1bc08cf-42b5-4409-b779-4d61d89ebbc9', '2ce28698-1dae-4526-8070-ca7c2280e43a', '2');
insert into task_question_correct_typing_answer values ('caa53f93-1f05-4d78-9410-5174cc153c11', '593b3b62-fa98-43d5-bafe-1b37974e37b4', '1');
insert into task_question_correct_typing_answer values ('823e9dcd-7175-4f98-b5df-e838ad07655a', '182ec441-ecf0-4d36-bed1-7c10408f6b50', 'Лето');
insert into task_question_correct_typing_answer values ('26d67418-8df3-4ce0-97e6-98644f6fdf8f', '31965f7e-1d23-402d-bc29-76758bc043e9', 'Осень');
insert into task_question_correct_typing_answer values ('ae26f34e-b74d-4363-bf49-c932cc42a43c', 'dee68fd7-bb05-471e-befa-7c26beb05fa9', 'Весна');
insert into task_question_correct_typing_answer values ('3ede9568-d0b8-4c30-85c7-77b9c149310b', '468f4d4a-9ca2-491e-a60b-6f3fad704cc2', 'Зима');
insert into task_question_correct_typing_answer values ('936d23d2-7e16-45f0-a391-c21624d2492d', '18a93288-2e96-4f1b-82e2-89459812cacb', 'Дятел');
insert into task_question_correct_typing_answer values ('fb81e637-ada0-46d6-8640-bff2332f301a', '291530a5-6086-4a10-840f-8ef515e91639', 'Сова');
insert into task_question_correct_typing_answer values ('3c44daf6-46f5-4e3f-9308-cb651996803c', '04dab6a0-465f-4eea-afe1-4699c09136fb', 'Ласточка');
insert into task_question_correct_typing_answer values ('d7b24ca3-4ad5-4880-bda1-cc7d740645e5', 'a0703d3c-a4c1-4c14-a00b-5cd542eabf08', 'Четыре');
insert into task_question_correct_typing_answer values ('782d89a1-be1f-4aff-be65-059d4e27d228', '2c6e391d-23bd-4d94-8aac-2d30a6843be2', 'Двенадцать');
insert into task_question_correct_typing_answer values ('c0fddf24-cea8-47ff-a63a-e6ec423be09c', '1799579c-8d5c-4885-a297-306d9be8ae26', 'Семь');
insert into task_question_correct_typing_answer values ('83a6adcc-816c-4a9f-a354-ad06849a48d7', '09ba608d-018c-4a2b-98a7-15c37fb5a002', 'Шестой');
insert into task_question_correct_typing_answer values ('8c3b8f3b-1c71-48e3-b86f-3f4db674b671', '4019258e-b9b9-4e4a-856a-056294af1240', 'Россия');

-- Задания тестов
select
  s.system_name as subject_name,
  sc.system_name as school_class_name,
  coalesce(st.display_name, s.name || ' - ' || sc.name) as test_name,
  t.id as task_id,
  t.number as task_number,
  t.task_statement as task_statement,
  t.task_hint as task_hint,
  t.task_question_answer_quantity,
  i.path as task_image_path,
  tt.system_name as task_type_name,
  ap.system_name as answer_position_name,
  atf.system_name as answer_typing_format_name,
  act.system_name as answer_choose_type_name,
  vt.system_name as task_view_type
from
  task t
inner join school_test st on
  st.id = t.school_test_id
inner join school_class sc on
  sc.id = st.school_class_id
inner join subject s on
  s.id = st.subject_id
left join task_type tt on
  tt.id = t.task_type_id
left join task_answer_typing_format tatf on
  tatf.task_id = t.id
left join answer_typing_format atf on
  atf.id = tatf.answer_typing_format_id
left join task_answer_choose_type tact on
  tact.task_id = t.id
left join answer_choose_type act on
  act.id = tact.answer_choose_type_id
left join task_answer_position tap on
  tap.task_id = t.id
left join answer_position ap on
  ap.id = tap.answer_position_id
left join task_image ti on
  ti.task_id = t.id
left join image i on
  i.id = ti.image_id
left join task_view_type tvt on
  tvt.task_id = t.id
left join view_type vt on
  vt.id = tvt.view_type_id
order by
  t.number
;

-- Вопросы заданий тестов
select
  t.number as task_number,
  t.task_statement as task_statement,
  tq.number as task_question_number,
  tq.text as task_question_text,
  tq.prefilled_answer as task_question_prefilled_answer,
  tqcta.correct_typing_answer as correct_typing_answer,
  i.path as task_question_image_path
from
  task_question tq
inner join task t on
  t.id = tq.task_id
left join task_question_correct_typing_answer tqcta on
  tqcta.task_question_id = tq.id
left join task_question_image tqi on
  tqi.task_question_id = tq.id
left join image i on
  i.id = tqi.image_id
order by
  t.school_test_id,
  t.id,
  t.number,
  tq.number
;

-- Предложенные ответы для заданий с типом ответа choose
select
  t.number as task_number,
  t.task_statement as task_statement,
  tpa.proposed_answer as task_proposed_answer,
  tpa.is_correct as task_proposed_answer_is_correct,
  act.name as answer_choose_type_name,
  i.path as task_proposed_answer_image_path
from
  task t
inner join task_proposed_answer tpa on
  tpa.task_id = t.id
inner join task_answer_choose_type tact on
  tact.task_id = t.id
inner join answer_choose_type act on
  tact.answer_choose_type_id = act.id
left join task_proposed_answer_image tpai on
  tpai.task_proposed_answer_id = tpa.id
left join image i on
  i.id = tpai.image_id
order by
  t.number
;

-- Доступные цвета для ответов для заданий с типом ответа choose
select
  t.number as task_number,
  t.task_statement as task_statement,
  acc.name as answer_choose_color_name
from
  task t
inner join task_answer_choose_color tacc on
  tacc.task_id = t.id
inner join answer_choose_color acc on
  tacc.answer_choose_color_id = acc.id
order by
  t.number
;
