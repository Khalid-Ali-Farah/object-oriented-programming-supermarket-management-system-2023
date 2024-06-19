# object-oriented-programming-supermarket-management-system-2023



This repository contains the implementation of a supermarket Management System using Java. The system provides functionalities for managing staff, products, and suppliers. It includes features such as login for staff and admin, adding, viewing, updating, and deleting records from the database.

## Features

- **Staff Login**
- **Admin Login**
- **Add Staff**
- **Delete Staff**
- **View Staff List**
- **Add Product**
- **Update Product**
- **Delete Product**
- **View Product List**
- **Add Supplier**
- **Delete Supplier**
- **View Supplier List**

## Table of Contents

- [Getting Started](#getting-started)
- [Prerequisites](#prerequisites)
- [Usage](#usage)
- [Screenshots](#screenshots)
- [Classes and Methods](#classes-and-methods)

## Getting Started

### Prerequisites

- Java JDK
- MySQL database
- IDE (e.g., Eclipse, IntelliJ IDEA)

## Usage

### Staff Login

- Use the following credentials for staff login:
    - **Username**: `staff`
    - **Password**: `password`

### Admin Login

- Use the following credentials for admin login:
    - **Username**: `admin`
    - **Password**: `adminpassword`

### Example Interactions

- **Add Staff**: Navigate to the staff management section and fill in the staff details.
- **View Product List**: Navigate to the product management section to see all products.

## Screenshots

1. **Login Screen**:
    ![Login Screen](images/login_screen.png)

2. **Staff Dashboard**:
    ![Staff Dashboard](images/staff_dashboard.png)

3. **Admin Dashboard**:
    ![Admin Dashboard](images/admin_dashboard.png)

4. **Add Staff Form**:
    ![Add Staff Form](images/add_staff_form.png)

5. **View Staff List**:
    ![View Staff List](images/view_staff_list.png)

6. **Add Product Form**:
    ![Add Product Form](images/add_product_form.png)

7. **View Product List**:
    ![View Product List](images/view_product_list.png)

## Classes and Methods

### UserController.java

- **doLogin(Staff staff)**: Handles staff login.
- **doLogin(Admin admin)**: Handles admin login.
- **addStaff(Staff staff)**: Adds a new staff to the database.
- **deleteStaff(Staff staff)**: Deletes a staff from the database.
- **viewStaffList()**: Returns a list of all staff.
- **addProduct(Product product)**: Adds a new product to the database.
- **updateProduct(Product product)**: Updates product details in the database.
- **findProduct(Product product)**: Finds a product by name.
- **deleteProduct(Product product)**: Deletes a product by ID.
- **deleteProductbySupID(Supplier supplier)**: Deletes products by supplier ID.
- **viewProductList()**: Returns a list of all products.
- **addSupplier(Supplier supplier)**: Adds a new supplier to the database.
- **deleteSupplier(Supplier supplier)**: Deletes a supplier from the database.
- **viewSupplierList()**: Returns a list of all suppliers.

### Models

- **Admin.java**
- **Product.java**
- **Staff.java**
- **Supplier.java**

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
