Weather API
================
Overview
------------
Weather API project from roadmap.sh https://roadmap.sh/projects/weather-api-wrapper-service

A weather API that fetches and returns weather data from a 3rd party API, utilizing caching and environment variables.

Features
------------
Fetches weather data from Visual Crossing's API (or API of your choice)
Implements in-memory caching using Redis for efficient data retrieval
Utilizes environment variables for secure API key storage
Automatic cache expiration (12-hour default)

Requirements
---------------
Java 17 (LTS version)
Maven
Redis
Visual Crossing API key (or alternative weather API)

Installation
---------------
Steps
Clone the repository: git clone https://github.com/your-username/weather-api.git
Install dependencies: mvn clean install (Maven) 
Set environment variables:
WEATHER_API_KEY : Your Visual Crossing API key
REDIS_HOST : Your Redis host URL
REDIS_PORT : Your Redis port
Run the application: mvn spring-boot:run (Maven)

Usage
---------
API Endpoints
Get Weather Data
GET api/weather/:city: Fetch weather data for a specific city
Example Request
Bash
GET /weather/Bangalore
Example Response
JSON
{
"temperature": 22.2,
"humidity": 60,
"conditions": "Partly Cloudy",
// ...
}

Caching
----------
City codes are used as cache keys
Cache expiration: 12 hours (configurable)

Contributing
---------------
Contributions are welcome! Please submit a pull request with your changes.

Acknowledgments
----------------
Visual Crossing API for providing free and easy-to-use weather data
Redis for efficient in-memory caching
