SET foreign_key_checks = 0;
drop table BookHotelRelation;
select * from BookingNumber;
SELECT * FROM Hotel;

CREATE TABLE BookHotelRelation (
    b_nr INT,
    ho_id INT,
    FOREIGN KEY (b_nr) REFERENCES BookingNumber(BookingN),
    FOREIGN KEY (ho_id) REFERENCES Hotel(id)
);
INSERT INTO BookHotelRelation (b_nr, ho_id) VALUES
                                                  (1,2), (1,3),
                                                  (2,4),
                                                  (3,5),
                                                  (4,7),(4,9);
                                                  
