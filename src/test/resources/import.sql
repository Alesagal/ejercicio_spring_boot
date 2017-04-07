INSERT INTO COUNTRIES(iso_code, name, version) VALUES('es', 'Spain', 1);
INSERT INTO COUNTRIES(iso_code, name, version) VALUES('us', 'United States of America', 1);
INSERT INTO COUNTRIES(iso_code, name, version) VALUES('uk', 'United Kingdom', 1);

INSERT INTO SHIPTYPE(shipTypeCode, description, version) VALUES('containership', 'Container Ship', 1);
INSERT INTO SHIPTYPE(shipTypeCode, description, version) VALUES('normalferry', 'Ferry', 1);
INSERT INTO SHIPTYPE(shipTypeCode, description, version) VALUES('bigferry', 'Big Ferry', 1);
INSERT INTO SHIPTYPE(shipTypeCode, description, version) VALUES('smallferry', 'Small Ferry', 1);

INSERT INTO SHIPS(imo_code, name, gross_tons, date_built, flag_iso_code, type_shipTypeCode, version) VALUES(0000001, 'Eleonora', 10000, '2015-05-04', 'es', 'containership', 1);
INSERT INTO SHIPS(imo_code, name, gross_tons, date_built, flag_iso_code, type_shipTypeCode, version) VALUES(0000002, 'Elly', 10000, '2015-05-04', 'es', 'containership', 1);
INSERT INTO SHIPS(imo_code, name, gross_tons, date_built, flag_iso_code, type_shipTypeCode, version) VALUES(0000003, 'Caroline', 10000, '2015-05-04', 'es', 'containership', 1);
