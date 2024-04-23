# SpringBootScheduledDemo (INSTALLATION GUIDE BELOW)

Hello and welcome to SpringBootScheduledDemo! :)

A basic Spring Boot application that tests the functionality of the @Scheduled annotation, by connecting to a MySQL database and constantly updating a boolean field at a fixed interval of 10 seconds.

This small application was a task as part of my Java Developer Internship program.

The project is set for interacting with a person table from a MySQL database named scheduled-demo-db. Person table has 3 fields: id, name and processed.

You can change the connection values in application.properties to your set database, username and password -> call them in PersonRepository class by @Value.

Run the application -> at a fixed interval of 10 seconds, the person database entries are checked and every processed value gets assigned a true value (or 1).

You can use the @PostMapping method in the controller class to periodically add new persons with processed values of false, or just use this query: update person set processed = false where id < 5. :)

# HOW TO INSTALL AND USE THE APP

# a. Open with Intellij, using repository link:

1. Press the green button labelled "Code" (top right corner of the project files) to copy the repository link;
2. Alternatively, you can copy it directly from here: https://github.com/radoivlad/SpringBootScheduledDemo.git
3. Open IntelliJ (make sure you have **Intellij Community Edition** installed);
4. Top-left corner: **File -> New -> Project from Version Control**;
5. Select Git as **Version control**;
6. Paste repository link in **URL** field;
7. If **Maven** is not installed -> IntelliJ displays a message to install it, follow instructions provided (Maven will automatically configure the **dependencies** for you);
8. Make sure to **manually reload all Maven dependencies**, before running for the first time;
9. Open the **ScheduledSpringBootDemoApplication** class and run the app (Shift + F10);

# b. RECOMMENDED: Clone repository to local drive, open with IntelliJ (locally):

1. Navigate to your local drive repository folder (where you would like to have the project cloned);
2. **Right-click -> Open Git Bash here** (make sure you have **Git** installed);
3. Type: **git clone https://github.com/radoivlad/SpringBootScheduledDemo.git** (this will create a clone of the project in the current directory);
4. Open IntelliJ;
5. Top-left corner: **File -> Open**;
6. Select the folder we cloned earlier;
7. If **Maven** is not installed -> IntelliJ displays a message to install it, follow instructions provided (Maven will automatically configure the **dependencies** for you);
8. Make sure to **manually reload all Maven dependencies**, before running for the first time;
9. Open the **ScheduledSpringBootDemoApplication** class and run the app (Shift + F10);

# Finally, have fun && happy testing! :D
//really open to any suggestions or improvement ideas, hit me up
