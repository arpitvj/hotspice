# Hotspice
> Hot Spice is a on demand food ordering startup. Client interfaces (Android and Webapp) access the services over rest APIs.
> This project exposes REST API endpoint to support customer and operations team use cases.
> This project comprises of Web Interface (one page web-app) for operations team.



## Installation


Clone the repository :
```sh
git clone https://github.com/arpitvj/hotspice.git
```

For Backend application, go to hotspice-backend folder:
```sh
cd hotspice-backend
```

Package the downloaded source code : 
```sh
mvn clean install
```

Open terminal and start mongodb : 
```sh
mongod
```

Open new terminal and Run the backend application : 
```sh
java -jar target/hotspice-0.0.1-SNAPSHOT.jar
```
The backend application should start at port 8080.

For Frontend application, open a new terminal and go to hotspice-frontend folder:
```sh
cd hotspice-frontend
```

Run the :
```sh
npm start
```
The backend application should start at port 4200.

For building the frontend project to production deployment:
```sh
npm run build
or
ng build
```
This will create a "dist" folder and generate the static css, html and js files which can be deployed to production server.

## Usage 

For using the APIs running, please go through below wiki page : 

[https://github.com/arpitvj/hotspice/wiki/APIs]
