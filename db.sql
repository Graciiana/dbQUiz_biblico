-- Active: 1766089875354@@127.0.0.1@3306@quiz


select * from pergunta;

ALTER TABLE pergunta
DROP COLUMN referencia_biblica;

INSERT INTO pergunta VALUES(DEFAULT, "Quem foi que traiu Jesus?", "baixa");