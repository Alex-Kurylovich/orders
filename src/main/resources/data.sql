INSERT INTO staff (ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE, ROLE, STATUS)
VALUES (1, 'Pam', 'Martinez', 'manager.pan@gmail.com', '416-1122-1371', 'MANAGER', 'ACTIVE'),
       (2, 'Maria', 'Barnes', 'agent.maria@gmail.com', '416-1122-1372', 'AGENT', 'ACTIVE'),
       (3, 'Jimmy', 'Lewis', 'agent.jimmy@gmail.com', '416-2122-2372', 'AGENT', 'ACTIVE'),
       (4, 'Brandon', 'Charles', 'technician.brandon@gmail.com', '416-1122-1373', 'TECHNICIAN', 'ACTIVE'),
       (5, 'Patrick', 'Ibarra', 'technician.patrick@gmail.com', '416-2122-2373', 'TECHNICIAN', 'ACTIVE'),
       (6, 'Paul', 'Anderson', 'technician.paul@gmail.com', '416-3122-3373', 'TECHNICIAN', 'ACTIVE');

INSERT INTO manager (ID, DETAILS)
VALUES (1, 'Manager details - Pam');
INSERT INTO agent (ID, DETAILS)
VALUES (2, 'Agent details - Maria');
INSERT INTO agent (ID, DETAILS)
VALUES (3, 'Agent details - Jimmy');
INSERT INTO technician (ID, DETAILS)
VALUES (4, 'Technician details - Brandon');
INSERT INTO technician (ID, DETAILS)
VALUES (5, 'Technician details - Patrick');
INSERT INTO technician (ID, DETAILS)
VALUES (6, 'Technician details - Paul');

INSERT INTO customer (FIRST_NAME, LAST_NAME, EMAIL, PHONE, STREET, CITY, PROVINCE, ZIP_CODE, AGENT_ID)
VALUES ('Jennifer ', 'Johnson', 'customer1@gmail.com', '416-749-6668', '1432 Islington Ave', 'Toronto', 'Ontario', 'M9V2X5', 2),
       ('Natalie ', 'Robinson', 'customer2@gmail.com', '613-325-5624', '1901 Bank St', 'Ottawa', 'Ontario', 'K1H7Z1', NULL),
       ('John ', 'Ferguson', 'customer3@gmail.com', '250-654-5431', '3449 Burdett Avenue', 'Sidney', 'British Columbia', 'V8L1X3', NULL),
       ('Michael ', 'Hensley', 'customer4@gmail.com', '519-291-8453', '2783 9th Avenue', 'Listowel', 'Ontario', 'N4W2H8', NULL);

INSERT INTO appointment (ID, AGENT_ID, TECHNICIAN_ID, REASON, DATE, TIME)
VALUES (1,2,4, 'FIX MY HARDWARE', '2024-12-20', '10:00');
