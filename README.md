
# RTO Management System

The RTO Management System is a comprehensive Java-based application designed to streamline the operations of a Regional Transport Office (RTO). It facilitates vehicle registration, fine management and Challan, updates, and searches, catering to both administrators and users.

## Project Overview

This system is composed of several Java files, each dedicated to specific functionalities such as registration, login, fine management, vehicle search, and updates. It leverages MySQL for database management and JDBC for database connectivity.

## Key Features

- *User Registration*: Enables users to register their vehicles by providing essential details like owner name, vehicle specifications, contact information, etc.
- *Login System*: Facilitates secure access for both administrators and users using their unique credentials.
- *Fine Management*: Allows users to pay their vehicle-related fines and generate challans, while administrators can add or remove fines as per requirements.
- *Vehicle Search*: Provides a feature for users and administrators to retrieve vehicle information using the vehicle number plate.
- *Update Details*: Administrators have the privilege to update vehicle details such as owner name, insurance date, PUC date, and contact information.
- *Validation*: Facilitates different validations like password,Date,Licence no to maintain integrity.
- *Password Encryption*: Facilitates encryption and decryption of paasword while storing into database.

  
## Project Structure

The project is structured into the following Java files:

- JDBC_Connection.java: Manages JDBC connection to the MySQL database.
- password_verify.java: Handles password creation and validation for user registration.
- RTO_Fine.java: Implements functionalities related to fine management.
- RTO_Login.java: Manages the login system for both administrators and users.
- RTO_Registration.java: Handles vehicle registration functionalities.
- RTO_Search_vehicle.java: Implements functionalities for searching vehicle information.
- RTO_Update_detail.java: Manages functionalities for updating vehicle details.
- RTO.java: The main file that contains the main menu and drives the overall project execution.
- DateValidator.java: Implements Date Validatiomm.
- Md5Hash.java: Encryption and decryption of password.
- RTO_LicenceNumberValidator.java: licence number validator.
- RTO_admin.java: To facilitate admin login and register.
- RTO_Challan.java: Generate challan whenever user pays fine.

## Database Setup

To utilize this system, a MySQL database with the necessary tables needs to be set up. The database schema and setup instructions can be found in the database_setup.sql file.


### Prerequisites

1. *Install JDK 8*: Ensure JDK 8 is installed on your machine. You can download it from the [Oracle JDK website](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html) or use a package manager for your operating system.
   
2. *Install MySQL*: Download and install MySQL from the [official MySQL website](https://dev.mysql.com/downloads/installer/). During installation, set a password for the root user.

3. *Download MySQL Connector/J*: Download the MySQL Connector/J (JDBC driver) from the [MySQL website](https://dev.mysql.com/downloads/connector/j/).

### Configuration

1. *Set Up Database Connection*:
   - Open your project and locate the JDBC connection configuration.
   - Set the dbpass variable to the password you configured for your MySQL installation.

### IntelliJ IDEA Setup

1. *Open Project Structure*:
   - Go to File -> Project Structure.
   
2. *Add MySQL Connector/J to Dependencies*:
   - Navigate to Modules -> Dependencies.
   - Click the + button and select JARs or Directories.
   - Browse and select the MySQL Connector/J JAR file you downloaded.
   - Apply the changes.
