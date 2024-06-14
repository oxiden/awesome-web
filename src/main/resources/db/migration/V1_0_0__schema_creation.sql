CREATE TABLE todo_item  
(  
    uuid    UUID PRIMARY KEY DEFAULT gen_random_uuid(),  
    title VARCHAR(255) NOT NULL,  
    description VARCHAR(255) NOT NULL  
);
