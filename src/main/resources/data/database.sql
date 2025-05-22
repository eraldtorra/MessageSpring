
-- Create database (uncomment if needed)
-- CREATE DATABASE message2;
-- USE message2;

-- Recreate tables if they don't exist
CREATE TABLE IF NOT EXISTS authorities (
    id   int auto_increment primary key,
    name varchar(255) null
);

CREATE TABLE IF NOT EXISTS messages (
    id      bigint auto_increment primary key,
    content varchar(255) not null,
    sender  varchar(255) not null
);

CREATE TABLE IF NOT EXISTS users (
    id       int auto_increment primary key,
    password varchar(255) null,
    username varchar(255) null
);

CREATE TABLE IF NOT EXISTS users_authorities (
    user_id      int not null,
    authority_id int not null,
    primary key (user_id, authority_id),
    constraint FKdsfxx5g8x8mnxne1fe0yxhjhq
        foreign key (authority_id) references authorities (id),
    constraint FKq3lq694rr66e6kpo2h84ad92q
        foreign key (user_id) references users (id)
);

-- Insert default authorities
INSERT INTO authorities (name) VALUES
('ROLE_USER'),
('ROLE_ADMIN');

-- Insert sample users (using NoOpPasswordEncoder as per your SecurityConfig)
INSERT INTO users (username, password) VALUES
('user1', '12345'),
('user2', '12345'),
('admin', '12345');

-- Assign authorities to users
INSERT INTO users_authorities (user_id, authority_id) VALUES
(1, 1), -- user1 has ROLE_USER
(2, 1), -- user2 has ROLE_USER
(3, 1), -- admin has ROLE_USER
(3, 2); -- admin has ROLE_ADMIN

-- Insert sample messages
INSERT INTO messages (content, sender) VALUES
('Hello, this is my first message!', 'user1'),
('Hi there, nice to meet you!', 'user2'),
('How are you doing today?', 'user1');