SET foreign_key_checks = 0;
drop table BookHyttRelation;
select * from BookingNumber;
SELECT * FROM Hytt;

CREATE TABLE BookHyttRelation (
    b_nr INT,
    h_id INT,
    FOREIGN KEY (b_nr) REFERENCES BookingNumber(BookingN),
    FOREIGN KEY (h_id) REFERENCES Hytt(id)
);
INSERT INTO BookHyttRelation (b_nr, h_id) VALUES
                                                  (1,1), (1,3),
                                                  (2,2),(2,4),
                                                  (3,2),
                                                  (4,3),(4,5);
use sum7;
SELECT * FROM Customers;
SELECT * FROM Hytt;
SELECT * FROM CustomerBookRelation;
SELECT * FROM BookingNumber;

select h.category,b.id, c.f_name
From Hytt h
join BookHyttRelation bhr on bhr.h_id =h.id
join BookingNumber b on b.id = bhr.b_nr
join CustomerBookRelation cbr on cbr.b_nr = bhr.b_nr
join Customers c on c.id = cbr.c_id
order by b.id;

-- testa query för hytt relation
SELECT b.id, c.f_name, h.category 
FROM Customers c
JOIN CustomerBookRelation cb ON c.id = cb.c_id
JOIN BookingNumber b ON cb.b_nr = b.id
JOIN BookHyttRelation bhr ON bhr.b_nr = b.id
JOIN Hytt h ON h.id = bhr.h_id
ORDER BY b.id; 






/*select b.id, c.f_name, h.category
SELECT e.category, c.f_name, b.id
FROM Customers c
JOIN CustomerBookRelation cb ON c.id = cb.c_id
JOIN BookingNumber b ON cb.b_nr = b.id
JOIN BookEventRelation ber ON ber.b_nr = b.id
JOIN Evenemang e ON e.id = ber.e_id
ORDER BY b.id;*/

