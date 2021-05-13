# Ski Lessons Application

# General description
This application is meant for ski lovers.Users can log in as ski instructors or as clients.
If you are a client, you can book a ski lesson with your favorite instructor and write a review afterwards. 
As an instructor, you can accept/decline a request and see your clients' reviews.

# Used technologies
* [Java 15](https://www.oracle.com/java/technologies/javase-downloads.html)
* [JavaFX](https://openjfx.io/openjfx-docs/) (as GUI)
* [Maven](https://maven.apache.org/) (as build tool)
* [Nitrite Java](https://www.dizitart.org/nitrite-database.html) (as Database)


## Prerequisites
To be able to install and run this project, please make sure you have installed Java 11 or higher. Otherwise, the setup will note work!
To check your java version, please run `java -version` in the command line.

To install a newer version of Java, you can go to [Oracle](https://www.oracle.com/java/technologies/javase-downloads.html) or [OpenJDK](https://jdk.java.net/).
It would be good if you also installed Maven to your system. To check if you have Maven installed run `mvn -version`.
If you need to install Maven, please refer to this [Maven tutorial](https://www.baeldung.com/install-maven-on-windows-linux-mac).

Make sure you install JavaFX SDK on your machine, using the instructions provided in the [Official Documentation](https://openjfx.io/openjfx-docs/#install-javafx). Make sure to export the `PATH_TO_FX` environment variable, or to replace it in every command you will find in this documentation from now on, with the `path/to/javafx-sdk-15.0.1/lib`.

## Setup & Run
To set up and run the project locally on your machine, please follow the next steps.

### Clone the repository
Clone the repository using:
```git
git clone https://github.com/fis2021/SkiLessonsApplication
```
### Verify that the project Builds locally
Open a command line session and `cd SLA`.
If you have installed all the prerequisites, you should be able to run any of the following commands:
```
mvn clean install
```
If you prefer to run using the wrappers, you could also build the project using 
```
./mvnw clean install (for Linux or MacOS)
or 
mvnw.cmd clean install (for Windows)
```

### Open in IntelliJ IDEA
To open the project in IntelliJ idea, you have to import it as either a Maven, or a Gradle project, depending on what you prefer. 
After you import it, in order to be able to run it, you need to set up your IDE according to the [official documentation](https://openjfx.io/openjfx-docs/). Please read the section for `Non-Modular Projects from IDE`.

### Run the project with Maven
The project has already been setup for Maven according to the above link.
To start and run the project use one of the following commands:
* `mvn javafx:run` or `./mvnw javafx:run` (run the `run` goal of the `javafx` maven plugin)


#### Nitrite Java
Nitrite Java was used in the [UserService.java] file, where we initialized a database, and a _Repository_ of User objects.
This Repository was further used to add new users, by using the **insert** method.








