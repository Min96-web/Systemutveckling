SELECT * FROM BookingNumber;
SELECT * FROM Customers;
SELECT * FROM Users;
SELECT * FROM CustomerBookRelation;

-- skapa en bokning nummer tabell
drop table BookingNumber;
CREATE TABLE BookingNumber (
    id INT AUTO_INCREMENT UNIQUE NOT NULL,
    BookingN INT UNIQUE NOT NULL
);

INSERT INTO BookingNumber (BookingN) VALUES (1000);
INSERT INTO BookingNumber (BookingN) VALUES (2000);
INSERT INTO BookingNumber (BookingN) VALUES (3000);
INSERT INTO BookingNumber (BookingN) VALUES (4000);

-- RELATION kund till bokning
DROP TABLE CustomerBookRelation;
CREATE TABLE CustomerBookRelation (
    c_id INT,
    b_nr INT,
    FOREIGN KEY (c_id) REFERENCES Customers(id),
    FOREIGN KEY (b_nr) REFERENCES BookingNumber(BookingN)
);

SET foreign_key_checks = 0; -- coolt
INSERT INTO CustomerBookRelation (c_id, b_nr) VALUES
        (1,1),
        (2,3),
        (3,2),
        (4,4);

-- RELATION bokning till evenemang
CREATE TABLE BookEventRelation (
    b_nr INT,
    e_id INT,
    FOREIGN KEY (b_nr) REFERENCES BookingNumber(BookingN),
    FOREIGN KEY (e_id) REFERENCES Evenemang(id)
);
INSERT INTO BookEventRelation (b_nr, e_id) VALUES
                                                  (1,3), (1,2),
                                                  (2,1),
                                                  (3,3), (3,3);

-- query för att visa att relationerna funkar
SELECT e.category, c.f_name, b.id
FROM Customers c
JOIN CustomerBookRelation cb ON c.id = cb.c_id
JOIN BookingNumber b ON cb.b_nr = b.id
JOIN BookEventRelation ber ON ber.b_nr = b.id
JOIN Evenemang e ON e.id = ber.e_id
ORDER BY b.id;



SELECT * from BookEventRelation;
select * from BookingNumber;
SELECT * FROM Customers;