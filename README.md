Daily Expense Record System

<-------------------------------->
Framework: Springboot

<-------------------------------->
System Requirements:

1. Apache Maven 3.8.5
2. openjdk 17.0.3 2022-04-19
3. Spring CLI v2.7.0
4. MongoDB

<-------------------------------->
Setup:

MongoDB Configurations ->
1. Database Name: DailyExpenseRecord
2. port: 27017
3. host: localhost
4. Documents: Expense, User

List of REST API requests:

Import these files into Postman:
1. /external reference/expense rest.postman_collection.json
2. /external reference/user rest.postman_collection

<-------------------------------->
Run: mvn spring-boot:run
