CREATE USER 'R@M'@'localhost' IDENTIFIED BY 'R@M$123';

GRANT ALL PRIVILEGES ON * . * TO 
'R@M'@'localhost' IDENTIFIED BY 'R@M$123' WITH GRANT 
OPTION MAX_QUERIES_PER_HOUR 0 MAX_CONNECTIONS_PER_HOUR 0 MAX_UPDATES_PER_HOUR 0 MAX_USER_CONNECTIONS 0 ;