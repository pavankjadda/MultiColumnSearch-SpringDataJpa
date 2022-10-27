# Multi Column Search using Spring Data Jpa
Multi Column Search using Spring Data Jpa and Spring Boot. See [Medium post](https://pavankjadda.medium.com/search-data-across-multiple-columns-using-spring-data-jpa-fc0a24799991) for more details

### How to run?
1. Start the MySql database using the following docker command. It will initialize the database and inserts sample database
```shell script
docker-compose  -f src/main/resources/docker-compose.yml up
``` 
2. Start the Spring boot application by running MultiColumnSearchSpringDataJpaApplication class

3. Navigate to Angular web application directory
```shell script
cd src/webapp
```
5. Install all dependencies
```shell script
npm install
```
6. Start the angular application
```shell script
ng serve --watch
```
7. Go to http://localhost:4200 in the browser to see the table.
