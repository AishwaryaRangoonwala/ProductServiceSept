Github Create Repo Command: 
gh repo create ProductServiceSept --private --source=. --remote=origin --push

Create Database:
create database productServiceSept;
use productServiceSept;
create user product_service_admin;

GRANT all privileges on product_service_admin.* to product_service_admin;
