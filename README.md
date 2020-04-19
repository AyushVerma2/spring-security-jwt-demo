# spring-security-jwt-demo

1. used spring security to valid users.
2. JWT for authenticate
3. filter calss is filer the endpoint is authenticate or other ,if other it just need Bearer token else username/password
4. JWTUtil class: to create the token with expiry and all ,also to validate the token.


#### Dependency:
```xml 
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
                 <dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>
                <dependency>
			<groupId>io.jsonwebtoken</groupId>
			<artifactId>jjwt</artifactId>
			<version>0.9.1</version>
		</dependency>
```


### Test:

To Authentica user :
##### POST:
        url:http://localhost:9193/authenticate
            body:
            {"userName":"user1",
            "password":"user1"
            }
##### GET:
            Header: Content-Type:application/json
            Authorization:Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsImV4cCI6MTU4MTgxNTcxMCwiaWF0IjoxNTgxNzc5NzEwfQ.vzh8e51Qtm-_1jF5o9swlXnl6R1VNF6kBdcxLyXl3fs
            url:http://localhost:9193/
	    
##### GET SINGLE USER DETAILS:
```xml 
GET: 
http://localhost:9193/user?user=user1
Authorization:Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsImV4cCI6MTU4MTgxNTcxMCwiaWF0IjoxNTgxNzc5NzEwfQ.vzh8e51Qtm-_1jF5o9swlXnl6R1VNF6kBdcxLyXl3fs

Response:
User detail  :: MyUser(id=1, username=user1, password=user1)
```
##### Acutator
GET:  localhost:9193/actuator/health
Authorization:Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsImV4cCI6MTU4MTgxNTcxMCwiaWF0IjoxNTgxNzc5NzEwfQ.vzh8e51Qtm-_1jF5o9swlXnl6R1VNF6kBdcxLyXl3fs


