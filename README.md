#### Weather Forecast
#####Softwares Used:
* Java 1.8
* Springboot 2.2
* Maven 3.6
* Mongo DB 4.2
* IntelliJ
##### Rest Api Used: DarkSky
* URI: https://api.darksky.net/forecast<key>/<long,lat>??exclude=currently,minutely,hourly,alerts,flags
* Key: d137c208b4fbbc92d40d43453e087568
* long,lat : Based up on location

##### Mongo DB Uri
<p> Installed Local version, created a root user with readwrite
access permissions, below is the uri used</p>
spring.data.mongodb.uri=mongodb://root:root@localhost:27017/forecast?authSource=admin

##### Running the application

* mvn install
* run the application using intellij or through jar or mvn spring-boot:run
* on page load itself calling the backend to fetch the details,
Retrieving data, if available in mongoose otherwise calling 
the endpoint by passing lang, lat to fetch corresponding to its country

##### Sequence Diagram:
![Alt text](Docs/sequence Diagram.png?raw=true "Title")


##### UI Sample:
![Alt text](Docs/UI_thymeleaf.png?raw=true "Title")
