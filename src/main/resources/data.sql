INSERT INTO venue(name, city, state) VALUES ('Wrigley Field', 'Chicago', 'IL');

INSERT INTO events(name, date, venue_id) VALUES ('Chicago White Sox vs. Chicago Cubs', CURRENT_DATE(), (SELECT id FROM venue WHERE name = 'Wrigley Field'));
