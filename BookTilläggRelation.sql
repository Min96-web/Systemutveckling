SET foreign_key_checks = 0;
drop table BookTilläggRelation;
select * from BookingNumber;
SELECT * FROM Tillägg;

CREATE TABLE BookTilläggRelation (
    b_nr INT,
    t_id INT,
    FOREIGN KEY (b_nr) REFERENCES BookingNumber(BookingN),
    FOREIGN KEY (t_id) REFERENCES Tillägg(id)
);
INSERT INTO BookTilläggRelation (b_nr, t_id) VALUES
                                                  (1,1),
                                                  (4,1);
                                                  
SELECT c.f_name,t.category
FROM Customers c
JOIN CustomerBookRelation cb ON c.id = cb.c_id
JOIN BookingNumber b ON cb.b_nr = b.id
JOIN BookTilläggRelation btr ON btr.b_nr=b.id
JOIN Tillägg t on t.id = btr.t_id
order by b.id;