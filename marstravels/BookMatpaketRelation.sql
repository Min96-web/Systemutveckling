SET foreign_key_checks = 0;
drop table BookMatpaketRelation;
select * from BookingNumber;
SELECT * FROM Matpaket;

CREATE TABLE BookMatpaketRelation (
    b_nr INT,
    m_id INT,
    FOREIGN KEY (b_nr) REFERENCES BookingNumber(BookingN),
    FOREIGN KEY (m_id) REFERENCES Matpaket(id)
);
INSERT INTO BookMatpaketRelation (b_nr, m_id) VALUES
                                                  (1,9), (1,7),
                                                  (2,6),
                                                  (3,3),
                                                  (4,8);    
                                                  
SELECT c.f_name,m.category
FROM Customers c
JOIN CustomerBookRelation cb ON c.id = cb.c_id
JOIN BookingNumber b ON cb.b_nr = b.id
JOIN BookMatpaketRelation bmr on bmr.b_nr=b.id
JOIN Matpaket m on m.id = bmr.m_id
order by b.id;