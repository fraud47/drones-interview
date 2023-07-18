# Drone Medication Loading System

The Drone Medication Loading System is a project designed to facilitate the registration, loading, and management of medication items on drones. It provides functionality to register drones, load medication items onto drones, check loaded medication items for a given drone, check available drones for loading, and check the battery level of a given drone.

## Table of Contents

- [Project Description](#project-description)
- [Pre-assumptions](#pre-assumptions)
- [Pre-requisites](#pre-requisites)
- [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Project Description

The Drone Medication Loading System aims to streamline the process of loading medication items onto drones for efficient delivery. It provides the following functionalities:

- Registering a drone: This functionality allows users to register a new drone with the system. Each drone is assigned a unique identifier and its initial state is set to IDLE.

- Loading a drone with medication items: Users can load medication items onto a drone that is in the IDLE state. The system ensures that the loaded weight does not exceed the drone's maximum capacity of 500 grams.

- Checking loaded medication items for a given drone: Users can check the list of medication items loaded on a specific drone. This feature helps in verifying the contents before dispatching the drone.

- Checking available drones for loading: This functionality allows users to view a list of available drones that are in the IDLE state and have a battery level above 25%. This helps in determining which drones are ready for medication loading.

- Checking drone battery level: Users can check the battery level of a given drone. This feature ensures that drones have sufficient battery power for safe and efficient delivery.

## Pre-assumptions

Before using the Drone Medication Loading System, the following assumptions are made:

- Only a drone in the IDLE state can be loaded with medications.
- A drone is available for loading if it is in the IDLE state and has a battery level above 25%.
- A drone cannot be loaded beyond its maximum capacity of 500 grams.

## Pre-requisites

To run the Drone Medication Loading System, ensure that the following pre-requisites are met:

- [List of pre-requisites (e.g., programming language, frameworks, libraries, etc.)]

## Installation

To install and set up the Drone Medication Loading System, follow these steps:

1. install mysql
2. create mysql database
3. add the configuration in application.yml
4. use the following
   ## Configuration

Update the `application.yml` file with the following configuration:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/drones
    username: fraud47
    password: 12465
  jpa:
    hibernate:
      ddl-auto: create
  properties:
    hibernate:
      dialect:
        org:
          hibernate:
            dialect: MySQL8Dialect
    format_sql: true
```

## Usage
    URL: /api/v1/drones
    HTTP Method: POST
    Request Body: DroneDto (JSON)
    Response: DroneDto (JSON)
    Status Codes:
        201 - Created: If the drone is successfully registered.
        400 - Bad Request: If the request body is invalid.
        500 - Internal Server Error: If an unexpected error occurs.

    URL: /api/v1/drones/available-drones
    HTTP Method: GET
    Response: List of DroneDto (JSON)
    Status Codes:
        200 - OK: If the available drones are successfully retrieved.
        500 - Internal Server Error: If an unexpected error occurs.

    URL: /api/v1/drones/check-battery-levels/{droneId}
    HTTP Method: GET
    Path Variable: droneId (Long)
    Response: BatteryLevelResponse (JSON)
    Status Codes:
        200 - OK: If the battery level is successfully retrieved.
        404 - Not Found: If the specified droneId does not exist.
        500 - Internal Server Error: If an unexpected error occurs.

## Contributing

Contributions are welcome! If you want to contribute to the Drone Medication Loading System, please follow these guidelines:

1. Fork the repository.
2. Create a new branch.
3. Make your changes.
4. Test your changes.
5. Submit a pull request.

Please ensure that your contributions adhere to the project's coding standards and conventions.

