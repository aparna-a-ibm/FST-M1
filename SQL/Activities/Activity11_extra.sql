REM   Script: Activity 11
REM   Extra

SELECT customer_id, customer_name FROM customers a 
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.customer_id = b.customer_id) 
UNION 
SELECT salesman_id, salesman_name FROM salesman a 
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.salesman_id = b.salesman_id) 
ORDER BY customer_name;

SELECT customer_id, customer_name, salesman_id, salesman_name   
FROM customers a 
JOIN salesman b ON a.salesman_id=b.salesman_id     
WHERE 1<(SELECT COUNT(*) FROM orders c WHERE a.customer_id = c.customer_id) AND 
1<(SELECT COUNT(*) FROM orders d WHERE b.salesman_id = d.salesman_id) 
ORDER BY customer_name;

SELECT a.customer_id, a.customer_name, b.salesman_id, b.salesman_name   
FROM customers a 
JOIN salesman b ON a.salesman_id= b.salesman_id     
WHERE 1<(SELECT COUNT(*) FROM orders c WHERE a.customer_id = c.customer_id) AND 
1<(SELECT COUNT(*) FROM orders d WHERE b.salesman_id = d.salesman_id) 
ORDER BY a.customer_name;

SELECT customer_id, customer_name FROM customers a 
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.customer_id = b.customer_id) 
UNION 
SELECT salesman_id, salesman_name FROM salesman a 
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.salesman_id = b.salesman_id) 
ORDER BY customer_name;

SELECT a.salesman_id, name, order_no, order_date AS 'Highest On', order_date FROM salesman a, orders b 
WHERE a.salesman_id=b.salesman_id 
AND b.purchase_amount=(SELECT MAX(purchase_amount) FROM orders c WHERE c.order_date = b.order_date) 
UNION 
SELECT a.salesman_id, name, order_no, order_date AS 'Lowest on', order_date FROM salesman a, orders b 
WHERE a.salesman_id=b.salesman_id 
AND b.purchase_amount=(SELECT MIN(purchase_amount) FROM orders c WHERE c.order_date = b.order_date);

SELECT a.salesman_id, name, order_no, order_date AS 'Highest On', order_date FROM salesman a 
JOIN orders b 
ON a.salesman_id=b.salesman_id 
WHERE b.purchase_amount=(SELECT MAX(purchase_amount) FROM orders c WHERE c.order_date = b.order_date) 
UNION 
SELECT a.salesman_id, name, order_no, order_date AS 'Lowest on', order_date FROM salesman a 
JOIN orders b 
ON a.salesman_id=b.salesman_id 
WHERE b.purchase_amount=(SELECT MIN(purchase_amount) FROM orders c WHERE c.order_date = b.order_date);

SELECT a.salesman_id, name, order_no, order_date AS 'Highest On', order_date FROM salesman a 
JOIN orders b 
ON a.salesman_id=b.salesman_id 
WHERE b.purchase_amount=(SELECT MAX(purchase_amount) FROM orders c WHERE c.order_date = b.order_date) 
UNION 
SELECT a.salesman_id, name, order_no, order_date AS 'Lowest on', order_date FROM salesman a 
JOIN orders b 
ON a.salesman_id=b.salesman_id 
WHERE b.purchase_amount=(SELECT MIN(purchase_amount) FROM orders c WHERE c.order_date = b.order_date);

SELECT a.salesman_id, a.salesman_name, b.order_no, b.order_date AS 'Highest On'  
FROM salesman a 
JOIN orders b ON a.salesman_id=b.salesman_id 
WHERE b.purchase_amount=(SELECT MAX(purchase_amount) FROM orders c WHERE c.order_date = b.order_date);

SELECT a.salesman_id, a.salesman_name, b.order_no, b.order_date AS 'Highest On'  
FROM salesman a 
JOIN orders b ON a.salesman_id=b.salesman_id 
WHERE b.purchase_amount=(SELECT MAX(purchase_amount) FROM orders c WHERE c.order_date = b.order_date);

