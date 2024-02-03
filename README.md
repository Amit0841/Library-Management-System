# Library-Management-System
<h3>Unique Name :- Old City Library.</h3>
<h1> Project Description </h1>
The Library Management System is a software solution designed to efficiently manage the operations of a library. The system aims to provide users, including librarians and students, with a platform to facilitate book management, rental transactions, and feedback collection. It enables librarians to perform administrative tasks related to books, track the status of student rentals, and view feedback and ratings provided by students. Students can access the system to explore available books, rent books, and provide feedback and ratings on rented books. The system will be developed using Java programming language, MySQL as the database management system, and Hibernate as the Object-Relational Mapping (ORM) framework.This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 17.0.1.

## **System Overview** 

The Old City Library is designed to efficiently manage library resources, including books, users, borrowing, and returning processes.

## **Access**

Access the Old City Library application through the following URL: **[https://Old-City](https://656caf96db89ad1fca415f32--fluffy-fenglisu-c76581.netlify.app/)**

## **Key Features**

- Manage Books: Add, Edit, Delete books from the library inventory.
- User Management: Register users, manage profiles, and track borrowing history.
- Borrowing and Returning: Facilitate book borrowing and returning processes.
- Search Functionality: Easily search for books based on various criteria.
- Reports and Analytics: Generate reports on book availability, user activity, etc.

## OpenAI Chatbot Integration

This project incorporates an AI-driven chatbot by OpenAI to augment user interaction and support within the library system.

### Chatbot Features

- **Conversational Interface:**  book recommendations, and general assistance.
  
- **Personalized Recommendations:** Obtain tailored book suggestions based on reading preferences, genres, or specific titles.

## **Design Approach and Assumptions**

- Designed to ensure a seamless and straightforward user experience.
- Assumption: Simplified authentication and authorization process for demo purposes.

## **Installation & Getting Started**

1. Clone the repository: **`git clone <https://github.com/Amit0841/Library-Management-System>`**
2. Navigate to the backend directory and run: **`mvn spring-boot:run`**
3. Navigate to the frontend directory and run: **`ng serve`**

## **User Guide**

1. Register/Login using provided credentials.
2. Manage books: Add, Edit, Delete books from the library inventory.
3. Manage users: Register users, track borrowing history, etc.
4. Borrow and Return books: Facilitate book borrowing and returning processes.
5. Utilize the search functionality to find specific books.
6. Generate reports and analytics for insights.

## **API Endpoints**

### **Authentication**

- **`POST /users`** - Register a new user.
- **`POST /logini`** - Log in an existing user.

### **Books**

- **`GET /books`** - Retrieve all books.
- **`GET /books/:id`** - Retrieve book details.
- **`POST /books`** - Add a new book.
- **`DELETE /books/:id`** - Delete a book.

### **Users**

- **`GET /users`** - Retrieve all users.
- **`GET /users/:id`** - Retrieve user details.
- **`POST /users`** - Add a new user.
  
## **Technology Stack**

- Front-end: Angular
- Back-end: Java, Spring Boot
- Database: MySQL
- Authentication: JWT Tokens
- Version Control: Git


Run `ng e2e` to execute the end-to-end tests via a platform of your choice. To use this command, you need to first add a package that implements end-to-end testing capabilities.

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI Overview and Command Reference](https://angular.io/cli) page.
