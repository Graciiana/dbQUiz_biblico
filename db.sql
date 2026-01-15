-- Active: 1766089875354@@127.0.0.1@3306@quiz


SELECT p.texto AS pergunta_texto, r.texto AS resposta_texto, r.correta
FROM pergunta AS p
JOIN resposta AS r ON p.id_pergunta = r.id_pergunta
WHERE p.id_pergunta = 2;


SELECT * from resposta;

UPDATE resposta SET correta = 0 WHERE id_resposta = 7;