# Student Management System Requirements

## 1. Introduction
The Student Management System is a console-based application written in Java. Its purpose is to efficiently manage personal and academic information of students in a school or educational institution. The system has been upgraded to include login, registration, and password recovery functionality.

## 2. Functional Requirements
The Student Management System should have the following functionalities:

### 2.1 Login
- Display a login screen with the following options:
    - "Welcome to the Student Management System"
    - "Please choose an option: 1. Login, 2. Register, 3. Forgot Password"
- Validate user credentials before granting access to the student management system.
#### 2.1.1 Student Management
 ##### Introduction
The Student Management System is a console-based application designed to manage student information. The system will be implemented using the console interface.

 ##### Initial Menu
The application will display the following initial menu options:
-------------Welcome to the  Student Management System----------------
1: Add Student
2: Delete Student
3: Modify Student
4: Search Student
5: Exit
Please enter your choice:


 ##### Student Class
The Student class will have the following attributes:
- ID: Unique identifier for each student.
- Name: Student's name.
- Age: Student's age.
- Address: Student's home address.

 ##### Add Functionality
The application should allow users to add student information. The following requirements should be met:
- Users will enter each student's information via keyboard input.
- The system should validate the uniqueness of the student ID.

 ##### Delete Functionality
The application should allow users to delete student information. The following requirements should be met:
- Users will enter the ID of the student they wish to delete via keyboard input.
- If the entered ID exists, the student will be deleted.
- If the entered ID does not exist, the system should display a notification and return to the initial menu.

 ##### Modify Functionality
The application should allow users to modify student information. The following requirements should be met:
- Users will enter the ID of the student they wish to modify via keyboard input.
- If the entered ID exists, the system will prompt the user to enter the updated information for the student.
- If the entered ID does not exist, the system should display a notification and return to the initial menu.

 ##### Search Functionality
The application should allow users to search for student information. The following requirements should be met:
- The system should display all student information in the following format:

| id   | name   | age | address    |
|------|--------|-----|------------|
| 001  | Ryan   | 23  | London     |
| 002  | Eric   | 24  | Bristol    |
| 003  | Manny  | 25  | New York   |
| 004  | Sofia  | 26  | Edinburgh  |

 ##### Additional Requirements
- The application should handle user inputs and provide appropriate error messages and instructions for incorrect inputs.
- The system should ensure data integrity by enforcing the uniqueness of student IDs.
- Implement proper validation and error handling to prevent unexpected behavior.
- The application should provide a graceful exit option for users.



### 2.2 Registration
- Users can register for an account with the following requirements:
    - Usernames must be unique and between 3 and 15 characters in length.
    - Usernames can only consist of letters and numbers, but not be a pure numeric value.
    - Passwords should be entered twice to ensure accuracy.
    - ID card numbers must be 18 characters long, with specific validation rules.
    - Phone numbers must be 11 digits long, with specific validation rules.

### 2.3 Password Recovery
- Users can recover their passwords if forgotten:
    - Prompt for the username.
    - Validate the username's existence.
    - Prompt for ID card number and phone number.
    - Check if the provided information matches the user's details.
    - Allow the user to enter a new password for modification.


- Access to the student management system is granted upon successful login.
- Perform CRUD (Create, Read, Update, Delete) operations on student records.
- Display student information in a tabular format, including ID, name, age, and address.


## 3. Additional Requirements
- Implement a verification code system for login.
- Properly validate user inputs for registration, login, and password recovery.
- Provide appropriate error messages and instructions for incorrect inputs or unsuccessful actions.
- Implement necessary data storage mechanisms to store user and student information securely.

Note: This is a merged version of the requirements, incorporating the original student management system requirements with the added login, registration, and password recovery functionality.
