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

-- Тесты
select * from school_test;

insert into school_test values ('65824e36-8d65-475f-a3d7-bc47ee1a97c1', 'a9d78ff9-1169-4105-a597-c0a0b9520b9e', 'b5269894-9697-43e0-8cf1-fdbba2ca27d2', null);
insert into school_test values ('9d565bdd-b1fb-44eb-af50-7490555b5708', 'a9d78ff9-1169-4105-a597-c0a0b9520b9e', 'e715108b-3ae8-4ef2-b6e6-5ffd1ed0e200', null);

-- Картинки
select * from image;

insert into image values ('c053f99d-ba1c-453a-af4d-e3fe0031c400', '\src\shared\assets\images\boy_skiing.jpg');
insert into image values ('3765d6e3-f311-4969-86de-1d94f99a7494', '\src\shared\assets\images\boy_body_parts.jpg');

-- Доступные типы ответов
select * from answer_type;

insert into answer_type values ('c98d26b4-2f09-4b40-a020-72f2e3f877d8', 'read', 'Чтение', 'Чтение текста для последующих вопросов по нему');
insert into answer_type values ('c601fc92-e680-4bb7-b6b3-b97fcb09a90f', 'typing', 'Ввод с клавиатуры', 'Напечатать ответ на вопрос');
insert into answer_type values ('402375b9-ffa6-42dd-ac57-8e5415f0b821', 'choose', 'Выбор из вариантов', 'Выбрать ответ или ответы из предложенных вариантов');

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

-- Задания тестов
select * from task;

insert into task values ('6c552069-874a-4335-94b7-62cb7fb32a75', '65824e36-8d65-475f-a3d7-bc47ee1a97c1', 1, 'c98d26b4-2f09-4b40-a020-72f2e3f877d8', 'Прочитай внимательно текст', null, null);
insert into task values ('c5638830-dd2c-49b0-8fb1-8b06b1ae97b2', '65824e36-8d65-475f-a3d7-bc47ee1a97c1', 2, 'c601fc92-e680-4bb7-b6b3-b97fcb09a90f', 'Ответь на вопросы', null, 1);
insert into task values ('de18553e-2002-416e-9b93-b57bcb830007', '65824e36-8d65-475f-a3d7-bc47ee1a97c1', 3, '402375b9-ffa6-42dd-ac57-8e5415f0b821', 'Найди предложения к картинке и подчеркни его', null, null);
insert into task values ('75ac4db2-52d5-40dd-ab5c-d7ae8edf5a96', '65824e36-8d65-475f-a3d7-bc47ee1a97c1', 4, 'c601fc92-e680-4bb7-b6b3-b97fcb09a90f', 'Пронумеруй по порядку предложения', null, 1);
insert into task values ('3e47544f-b9bb-4d63-b1b3-b4910b4c550d', '9d565bdd-b1fb-44eb-af50-7490555b5708', 1, 'c601fc92-e680-4bb7-b6b3-b97fcb09a90f', 'Подпиши части тела мальчика.', null, 1);
insert into task values ('2a035365-566a-45d5-b3e9-524758d2ca94', '9d565bdd-b1fb-44eb-af50-7490555b5708', 2, 'c601fc92-e680-4bb7-b6b3-b97fcb09a90f', 'Прочитай слова. Запиши ответы в таблицу цифрой.', '1) осязание 2) обоняние 3) вкус 4) слух 5) зрение', 1);

-- Тексты заданий с типом ответа read
select * from task_text;

insert into task_text values ('93d41e1e-ef67-435a-87a0-2394b7cbef0d', '6c552069-874a-4335-94b7-62cb7fb32a75', 'Встреча', 'Илья катался на лыжах. Он заехал далеко в лес. Тут мальчик заметил большую рыжую кошку. Она лежала на дереве. У кошки были зелёные глаза и кисточки на ушах. Сильные лапы впились в ствол. Это была рысь. Рысь прыгнула в снег. Илья затих. Рысь удалилась в лес.');

-- Позиции ответов заданий с типами typing и choose
select * from task_answer_position;

insert into task_answer_position values ('70de5ddf-d74e-4c5e-8ce0-e091015c4445', 'c5638830-dd2c-49b0-8fb1-8b06b1ae97b2', '2b9ade7e-f3b6-4d23-83f8-8c2f10170e0f');
insert into task_answer_position values ('9e8c2a19-a13d-4d0a-87fe-60313c808c2b', 'de18553e-2002-416e-9b93-b57bcb830007', 'd573ca82-eec8-4192-838a-26b66e57c5dc');
insert into task_answer_position values ('a26386ca-50ff-4b19-b2d9-499cd06073ee', '75ac4db2-52d5-40dd-ab5c-d7ae8edf5a96', 'ea5f9f92-4378-435d-bdce-8af8b8c9aa12');
insert into task_answer_position values ('1ef09e8f-f288-4551-8d99-cf7a54446532', '3e47544f-b9bb-4d63-b1b3-b4910b4c550d', '2b9ade7e-f3b6-4d23-83f8-8c2f10170e0f');

-- Картинки заданий
select * from task_image;

insert into task_image values ('fbc06aab-5a3c-476d-9c49-d3313eead109', 'de18553e-2002-416e-9b93-b57bcb830007', 'c053f99d-ba1c-453a-af4d-e3fe0031c400');
insert into task_image values ('87cfb1ae-ab1b-49bb-832a-fb2146269976', '3e47544f-b9bb-4d63-b1b3-b4910b4c550d', '3765d6e3-f311-4969-86de-1d94f99a7494');

-- Форматы ответов на задания с типом typing
select * from task_answer_typing_format;

insert into task_answer_typing_format values ('e5a563d0-bc44-4b41-92c8-27abef7af29b', 'c5638830-dd2c-49b0-8fb1-8b06b1ae97b2', '37b35df1-f6f5-4fd0-8b28-494502c6912c');
insert into task_answer_typing_format values ('2fb83afb-a0ce-41c4-b54b-cdd11825c4e2', '75ac4db2-52d5-40dd-ab5c-d7ae8edf5a96', 'b016a6e4-3a51-4552-9be9-44ba2a98b876');
insert into task_answer_typing_format values ('a88c89a0-aca0-4fcd-b5dc-9beb0e6431df', '3e47544f-b9bb-4d63-b1b3-b4910b4c550d', '37b35df1-f6f5-4fd0-8b28-494502c6912c');

-- Способы ответов на задания с типом choose
select * from task_answer_choose_type;

insert into task_answer_choose_type values ('b037657a-b0ee-4c1d-a083-a49c6c6f9d2f', 'de18553e-2002-416e-9b93-b57bcb830007', '93be22dc-2b74-4a61-9f6a-678d3169c43b');

-- Цвета для ответа на задания с типом choose
select * from task_answer_choose_color;

insert into task_answer_choose_color values ('fdc09b87-5afe-45d1-a07e-9393a19bf248', 'de18553e-2002-416e-9b93-b57bcb830007','5fb1318d-d60b-482b-b71a-1cad8f1c3054' );

-- Предложенные ответы заданий с типом choose
select * from task_proposed_answer;

insert into task_proposed_answer values ('f96ca457-6044-4dff-9d52-2b6bcee61dbc', 'de18553e-2002-416e-9b93-b57bcb830007', 'Илья катался на лыжах. Он заехал далеко в лес', true);
insert into task_proposed_answer values ('c31f7836-4489-4aef-a0cf-bf18e4fe6a45', 'de18553e-2002-416e-9b93-b57bcb830007', 'Тут мальчик заметил большую рыжую кошку. Она лежала на дереве', false);
insert into task_proposed_answer values ('2c0f660c-244e-4fe6-9446-2251939891b6', 'de18553e-2002-416e-9b93-b57bcb830007', 'У кошки были зелёные глаза и кисточки на ушах. Сильные лапы впились в ствол. Это была рысь.', false);
insert into task_proposed_answer values ('b2e267da-cd67-4dc5-bb1e-c010313f57a2', 'de18553e-2002-416e-9b93-b57bcb830007', 'Рысь прыгнула в снег. Илья затих. Рысь удалилась в лес.', false);

-- Правильные ответы заданий с типом typing
select * from task_correct_typing_answer;

-- Типы отображения заданий
select * from task_view_type;

insert into task_view_type values ('d3f9d2ad-0519-4ed9-b4c0-87031ada246c', 'c5638830-dd2c-49b0-8fb1-8b06b1ae97b2', 'cc3efb92-7149-473b-b6d6-618fb380a584');
insert into task_view_type values ('385ea72c-eaaf-4e36-8730-525f9f5b156d', 'de18553e-2002-416e-9b93-b57bcb830007', 'cc3efb92-7149-473b-b6d6-618fb380a584');
insert into task_view_type values ('d373897a-32e4-4c76-87b7-983b0ce2ca68', '75ac4db2-52d5-40dd-ab5c-d7ae8edf5a96', 'cc3efb92-7149-473b-b6d6-618fb380a584');
insert into task_view_type values ('104e5569-61c2-4dd2-9b9e-8b1a999e7f8d', '3e47544f-b9bb-4d63-b1b3-b4910b4c550d', 'cc3efb92-7149-473b-b6d6-618fb380a584');
insert into task_view_type values ('51683539-93ca-46c3-9de1-76de13722f15', '2a035365-566a-45d5-b3e9-524758d2ca94', 'a6871068-80db-4cd6-9f2c-d526e5edcc03');

-- Вопросы заданий с типом typing
select * from task_question;

insert into task_question values ('813defb9-3e0b-4b50-8a83-f3663f92deae', 'c5638830-dd2c-49b0-8fb1-8b06b1ae97b2', 1, 'Как звали мальчика?');
insert into task_question values ('055e03a3-d85d-4964-a6ea-8e6a30770b58', 'c5638830-dd2c-49b0-8fb1-8b06b1ae97b2', 2, 'Где он катался на лыжах?');
insert into task_question values ('64a1de7f-26e7-4e0f-b075-ec1691ad62bd', 'c5638830-dd2c-49b0-8fb1-8b06b1ae97b2', 3, 'Кого Илья повстречал в лесу?');
insert into task_question values ('9e1b2378-7e19-4fc7-bb1b-63c34c1b9065', 'c5638830-dd2c-49b0-8fb1-8b06b1ae97b2', 4, 'Рысь – это домашняя кошка?');
insert into task_question values ('def40907-c084-4952-bef2-f02f0526b141', 'c5638830-dd2c-49b0-8fb1-8b06b1ae97b2', 5, 'Чем закончилась это встреча?');
insert into task_question values ('0426fd61-8653-4ff3-b1c3-8642a61d59a4', '75ac4db2-52d5-40dd-ab5c-d7ae8edf5a96', null, 'Тут мальчик заметил большую рыжую кошку.');
insert into task_question values ('82787684-a5e0-4761-9c53-501f7917139a', '75ac4db2-52d5-40dd-ab5c-d7ae8edf5a96', null, 'Илья катался на лыжах. Он заехал далеко в лес.');
insert into task_question values ('2412261c-1b4f-4982-9fc8-34df709b03e9', '75ac4db2-52d5-40dd-ab5c-d7ae8edf5a96', null, 'Рысь прыгнула в снег. Илья затих. Рысь удалилась в лес.');
insert into task_question values ('e683faad-1ae7-435f-a877-f383b56c2b70', '75ac4db2-52d5-40dd-ab5c-d7ae8edf5a96', null, 'Она лежала на дереве. У кошки были зелёные глаза и кисточки на ушах.');
insert into task_question values ('677a228b-729c-499c-baa0-506e2ba4c6ea', '75ac4db2-52d5-40dd-ab5c-d7ae8edf5a96', null, 'Сильные лапы впились в ствол. Это была рысь.');
insert into task_question values ('133fccd7-e941-4a8f-9890-c246a4e42cb7', '3e47544f-b9bb-4d63-b1b3-b4910b4c550d', 1, null);
insert into task_question values ('6fb8d351-6050-4791-9e58-d8eee89911d5', '3e47544f-b9bb-4d63-b1b3-b4910b4c550d', 2, null);
insert into task_question values ('55ae789a-f118-4416-8f77-aa631254aec2', '3e47544f-b9bb-4d63-b1b3-b4910b4c550d', 3, null);
insert into task_question values ('8fe567fb-6937-4ef5-9a54-97300fa09b7b', '3e47544f-b9bb-4d63-b1b3-b4910b4c550d', 4, null);

-- Правильные ответы заданий с типом typing
select * from task_question_correct_typing_answer;

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

-- Задания тестов
select
  s.system_name as subject_name,
  sc.system_name as school_class_name,
  coalesce(st.display_name, s.name || ' - ' || sc.name) as test_name,
  t.id as task_id,
  t.number as task_number,
  t.task_statement as task_statement,
  t.task_hint as task_hint,
  i.path as task_image_path,
  ap.system_name as answer_position_name,
  at.system_name as answer_type_name,
  atf.system_name as answer_typing_format_name,
  act.system_name as answer_choose_type_name
from
  task t
inner join school_test st on
  st.id = t.school_test_id
inner join school_class sc on
  sc.id = st.school_class_id
inner join subject s on
  s.id = st.subject_id
left join answer_type at on
  at.id = t.answer_type_id
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
order by
  t.number
;

-- Вопросы заданий тестов
select
  t.number as task_number,
  t.task_statement as task_statement,
  tq.number as task_question_number,
  tq.text as task_question_text,
  tqcta.correct_typing_answer as correct_typing_answer
from
  task_question tq
inner join task t on
  t.id = tq.task_id
left join task_question_correct_typing_answer tqcta on
  tqcta.task_question_id = tq.id
order by
  t.number,
  tq.number
;

-- Предложенные ответы для заданий с типом ответа choose
select
  t.number as task_number,
  t.task_statement as task_statement,
  tpa.proposed_answer as task_proposed_answer,
  tpa.is_correct as task_proposed_answer_is_correct,
  act.name as answer_choose_type_name
from
  task t
inner join task_proposed_answer tpa on
  tpa.task_id = t.id
inner join task_answer_choose_type tact on
  tact.task_id = t.id
inner join answer_choose_type act on
  tact.answer_choose_type_id = act.id
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
