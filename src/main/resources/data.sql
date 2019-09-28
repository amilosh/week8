CREATE database dictionary;
USE dictionary;

CREATE TABLE dictionary_1(word VARCHAR(190) NOT NULL UNIQUE, reference_id INT(16) NOT NULL) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;
CREATE TABLE dictionary_2(word VARCHAR(190) NOT NULL UNIQUE, reference_id INT(16) NOT NULL) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO dictionary_1(word, reference_id) VALUES('абажур', 1);
INSERT INTO dictionary_1(word, reference_id) VALUES('кинотеатр', 2);
INSERT INTO dictionary_1(word, reference_id) VALUES('самолет', 3);
INSERT INTO dictionary_1(word, reference_id) VALUES('человек', 4);

INSERT INTO dictionary_2(word, reference_id) VALUES('кинотеатр', 15);
INSERT INTO dictionary_2(word, reference_id) VALUES('музыка', 16);
INSERT INTO dictionary_2(word, reference_id) VALUES('самолет', 17);