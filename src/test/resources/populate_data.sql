INSERT INTO staff (ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE, ROLE, STATUS)
VALUES (1, 'Pam', 'Martinez', 'manager1@gmail.com', '416-1122-1371', 'manager', 'active'),
       (2, 'Maria', 'Barnes', 'agent1@gmail.com', '416-1122-1372', 'agent', 'active'),
       (3, 'Brandon', 'Charles', 'technician1@gmail.com', '416-1122-1373', 'technician', 'active'),
       (4, 'Isaac', 'Michael', 'technician2@gmail.com', '416-1122-1374', 'technician', 'active');

INSERT INTO agent (ID, DETAILS)
VALUES (2, 'residential');

INSERT INTO customer (ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE, STREET, CITY, PROVINCE, ZIP_CODE)
VALUES (1, 'Jennifer ', 'Johnson', 'customer1@gmail.com', '416-749-6668', '1432 Islington Ave', 'Toronto', 'Ontario', 'M9V2X5'),
       (2, 'Natalie ', 'Robinson', 'customer2@gmail.com', '613-325-5624', '1901 Bank St', 'Ottawa', 'Ontario', 'K1H7Z1'),
       (3, 'John ', 'Ferguson', 'customer3@gmail.com', '250-654-5431', '3449 Burdett Avenue', 'Sidney', 'British Columbia', 'V8L1X3'),
       (4, 'Michael ', 'Hensley', 'customer4@gmail.com', '519-291-8453', '2783 9th Avenue', 'Listowel', 'Ontario', 'N4W2H8');
