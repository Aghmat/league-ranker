# League Ranker

League Ranker is a command line application which takes in a text file of games and outputs a ranked league table.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development.

### Prerequisites

The following software is required to run this version of this project

```
Java 18.0.2.1
Scala 2.13.8
```

## Built With

* [IntelliJ IDEA](https://www.jetbrains.com/idea/) - The IDE used

## Running the application

### Supported file format

Unsupported files will result in an exception being thrown. Files should be added to the resource folder.

**Types**
```
space-seperated-string int, space-seperated-string int
```

**Data**
```
teamA scoreA, teamB scoreB
teamC scoreC, teamD scoreD
```

**Example**
```
Lions 3, Snakes 3
Tarantulas 1, FC Awesome 0
```

### Run tests
```
sbt test
```

### Run the application (during development)
```
sbt run <file>
```

### Running and packaging the application
We import the [sbt-assembly](https://github.com/sbt/sbt-assembly) plugin to build a single jar with all dependencies

```
sbt compile
sbt assembly
```

The über/fat jar will be located in
```
league-ranker\target\scala-2.13\league-ranker_2.13-0.1.0-SNAPSHOT.jar
```
Running the .jar file
```
scala league-ranker_2.13-0.1.0-SNAPSHOT.jar <file>
```


## Authors

* **Aghmat Abrahams** - *Initial work* - [Aghmat](https://github.com/Aghmat)