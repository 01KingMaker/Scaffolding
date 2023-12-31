# Database Mapper and REST API Generator

## Overview

Welcome to the Database Mapper and REST API Generator project! This tool facilitates the creation of mapping classes from a database schema and generates REST API methods for a variety of programming languages, including Java and .NET. With this tool, you can streamline the process of interacting with your database and exposing RESTful endpoints for your application.

## Features

- **Automatic Mapping:** The tool analyzes your database schema and generates mapping classes that represent the structure of your tables.

- **Multi-language Support:** Generate code for different programming languages, including Java and .NET, making it versatile for a variety of projects.

- **REST API Generation:** Quickly create RESTful API methods for CRUD (Create, Read, Update, Delete) operations based on your database schema.

- **Customization Options:** Tailor the generated code to meet your specific requirements. Customize naming conventions, data types, and more.

## Getting Started

### Prerequisites

- Make sure you have [Java](https://www.java.com/) installed if you want to generate Java code, or [.NET SDK](https://dotnet.microsoft.com/download) for generating .NET code.

## Language supported

- [Java]
- [C#]
- [Python]
- [NodeJs]
- [PHP]
- You can add classes templates in the directory modele and the file name must be the extension of the language you want

## Database configuration

Configure your database configuration in database.conf

```
    url=jdbc:postgresql://localhost:5432/postgres
    user=your_username
    motDePasse=your_password
    driver=org.postgresql.Driver
```

## Run
 
* Run the program by running scaffold with the appropriate command options like bellow 
```
    ./scaffold --library target --language java --outputdirectory /home/fabien/Documents/S5/out  --package chat.action --table saison
```