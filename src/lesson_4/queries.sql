-- ошибки в расписании (фильмы накладываются друг на друга), отсортированные по возрастанию времени.
-- Выводить надо колонки «фильм 1», «время начала», «длительность», «фильм 2», «время начала», «длительность»;

SELECT f1.name as first_film, s1.start_time, d1.duration, f2.name as second_film, s2.start_time, d2.duration
FROM durations AS d1
         LEFT JOIN durations AS d2 ON d1.id = d2.id
         JOIN films as f1 ON f1.duration_id = d1.id
         JOIN films as f2 ON f2.duration_id = d2.id
         JOIN seances as s1 ON f1.id = s1.film_id
         JOIN seances as s2 ON f2.id = s2.film_id
ORDER BY d1.duration, d2.duration;

-- перерывы 30 минут и более между фильмами — выводить по уменьшению длительности перерыва.
-- Колонки «фильм 1», «время начала», «длительность», «время начала второго фильма», «длительность перерыва»;

SELECT name AS film, start_time, duration
FROM films
         JOIN seances ON seances.film_id = films.id
         JOIN durations ON films.duration_id = durations.id
ORDER BY start_time;

-- список фильмов, для каждого — с указанием общего числа посетителей за все время, среднего числа зрителей за
-- сеанс и общей суммы сборов по каждому фильму (отсортировать по убыванию прибыли).
-- Внизу таблицы должна быть строчка «итого», содержащая данные по всем фильмам сразу;

SELECT name AS Film, COUNT(tickets.id) AS visitors
FROM films
         JOIN seances ON seances.film_id = films.id
         JOIN tickets ON seances.id = tickets.seance_id
         JOIN prices ON seances.price_id = prices.id
GROUP BY Film;

-- число посетителей и кассовые сборы, сгруппированные по времени начала фильма: с 9 до 15, с 15 до 18, с 18 до 21,
-- с 21 до 00:00 (сколько посетителей пришло с 9 до 15 часов и т.д.).

SELECT COUNT(tickets.id) AS 'visitors from 9:00 to 15:00', COUNT(tickets.id) * cost AS profit
FROM seances
         JOIN tickets ON seances.id = tickets.seance_id
         JOIN prices ON seances.price_id = prices.id
WHERE price_id = 1;

SELECT COUNT(tickets.id) AS 'visitors from 15:00 to 18:00', COUNT(tickets.id) * cost AS profit
FROM seances
         JOIN tickets ON seances.id = tickets.seance_id
         JOIN prices ON seances.price_id = prices.id
WHERE price_id = 2;

SELECT COUNT(tickets.id) AS 'visitors from 18:00 to 21:00', COUNT(tickets.id) * cost AS profit
FROM seances
         JOIN tickets ON seances.id = tickets.seance_id
         JOIN prices ON seances.price_id = prices.id
WHERE price_id = 3;