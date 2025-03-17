### Overview

This project is a Proof of Concept for an online store application 
with SpringBoot and Thymeleaf.

It models 3 entities for the data:
- Orders
- OrderDetails
- Products

The cart is a session object for adding and removing products. It has no 
value to store it. 
Additionally, not all data is displayed in the frontend, so 
DataTransferObjects(commonly referenced as DTOs) are used.
The structures are:
- ProductInfo
- OrderInfo

Normally a user adds products to the cart, adds valid customer information
and then proceeds to checkout the order.
On checkout, the order and order details tables are updated.

### Accesing the shop

The index.html file is mapped to:

http://localhost:8080/

Simply access this URL in the browser. Be mindful of the port that is 
configured in the application.properties file. By default, it is 8080.

### SQL Table generation

In order to generate the SQL tables, the sql script for this is found 
in the resources/sql directory.