CREATE TABLE venue(
    id SERIAL,
    name VARCHAR(255) not null,
    city VARCHAR(255) not null,
    state VARCHAR(255) not null,
    primary key(id)
);

CREATE TABLE events(
    id SERIAL,
    name VARCHAR(255) not null,
    date DATE not null,
    venue_id INTEGER,
    primary key(id),
    constraint fk_venue
        foreign key(venue_id)
        references venue(id)
 );
