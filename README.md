[![N|Solid](https://bgasparotto.com/wp-content/uploads/2017/12/spring-boot-logo.png)]()
# Point Of Sale (POS)
POS is a web based software, developed using the RESTful pattern. Spring Boot Framework is used here. It can be used in any shop as a system to track all the products information and to buy and sell the products.

## Features!
The users can have the following facilities by this software:
  - A database with all their products
  
  - Their clients are able to change the contents of their cart
  - Their clients are able to place an order
  - Their clients are able to supply a preferred date and time of delivery

## Limitation of current version
  - Payment system hasn't been added.
  - Buying and selling vouchar hasn't been added yet.
  - Only shop owner can use it now. For the client side view will be added.
  - Virtual shopping cart will be added to add products for the clients.

## Tech
Webshop uses:
* Spring Boot Framework
* MySQL
* Hibernate
* Thymeleaf
* Bootstrap

## Prerequisite
  - You need to have java installed in your system.
  - Install mysql
  - Install spring boot
  - Install maven - sudo apt install maven
  - Install Lombok
  
## Getting Started!
```
git clone https://github.com/Nushrat-Nishi/pos
cd pos
```
  - Change the *user name* & *Password* in *pos/src/main/resources/application.properties* file according to your database.
```
mvn spring-boot:run
```
## API Documentation
##### Register a new user : http://localhost:8080/registration
##### Login with the created user : http://localhost:8080/login
## Menus :
After login, the user can see the following menus:
* Home - This is the home page.
* All Products - User can see all the product list in this page. User can also delete any product, edit any product information, buy or sell any product.
* Registration - User can register any new user in this page.
* Add Product - User can add any new product in the system in this page.
* Add Stock - User can add information about how much of any particular product are there in the stock and also other information here.