insert into LOAN_TYPE(id, code, name) values (1, '0', 'PERSONAL');
insert into LOAN_TYPE(id, code, name) values (2, '1', 'HOME_EQUITY');
insert into LOAN_TYPE(id, code, name) values (3, '2', 'SMALL_BUSINESS');
insert into LOAN_TYPE(id, code, name) values (4, '3', 'CREDIT_CARD');
insert into LOAN_TYPE(id, code, name) values (5, '4', 'OTHER');

insert into CUSTOMER_TYPE(id, code, name) values (1, '0', 'INDIVIDUAL');
insert into CUSTOMER_TYPE(id, code, name) values (2, '1', 'SME');
insert into CUSTOMER_TYPE(id, code, name) values (3, '2', 'CIB');
insert into CUSTOMER_TYPE(id, code, name) values (4, '3', 'OTHER');

insert into CUSTOMER(id, code, name, phone_number, address, type) values (1, '123', 'Trần Văn Nam', '098734564', 'Khâm Thiên, HN', '0');
insert into CUSTOMER(id, code, name, phone_number, address, type) values (2, '111', 'Cty TNHH Cô Vít 19', '098224455', 'Vũ Hán, TQ', '1');
insert into CUSTOMER(id, code, name, phone_number, address, type) values (3, '888', 'Alphabet Inc.', '01101101110', 'Mountain View, California, USA', '2');