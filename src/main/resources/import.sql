INSERT INTO Chat_User(user_id, user_name, user_mail, user_password) VALUES (1, 'jawahar', 'jawaharlakshmanan6@gmail.com', 'jawahar');
INSERT INTO Chat_User(user_id, user_name, user_mail, user_password) VALUES (2, 'jai', 'jai6@gmail.com', 'jai');
INSERT INTO Chat_User(user_id, user_name, user_mail, user_password) VALUES (3, 'jenifer', 'jenifer6@gmail.com', 'jenifer');

INSERT INTO Chat_Message(chat_id, message, sender, receiver, message_tag, times ) VALUES (1,'hi hello', 'jawahar', 'jai', 'NONE', 'sat 5 2022 5:45pm');
INSERT INTO Chat_Message(chat_id, message, sender, receiver, message_tag, times ) VALUES (2,'hi', 'jai', 'jawahar', 'NONE', 'sat 5 2022 6:45pm');
INSERT INTO Chat_Message(chat_id, message, sender, receiver, message_tag, times ) VALUES (3,'whatsup', 'jawahar', 'jai', 'EDITED', 'sat 5 2022 7:45pm');

INSERT INTO Chat_Message(chat_id, message, sender, receiver, message_tag, times ) VALUES (4,'Hi jai', 'jenifer', 'jai', 'NONE', 'sat 5 2022 7:45pm');