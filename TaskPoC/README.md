# Build and Run
```java
mvn clean install -DskipTests spring-boot:run
```
# Usage
### Checking app is deployed sucessfullly
```sh
curl -i http://localhost:9191/api/hello
Hello User!
```
### Access secure resource with token
```sh
curl -i http://localhost:9191/api/secure

{"timestamp":1444985908768,"status":401,"error":"Unauthorized","message":"Access Denied","path":"/api/secure"}
```

### Fetching refresh_token
```sh
curl -vu rajithapp:secret 'http://localhost:9191/api/oauth/token?username=admin&password=admin&grant_type=password'

{"access_token":"91202244-431f-444a-b053-7f50716f2012","token_type":"bearer","refresh_token":"e6f8624f-213d-4343-a971-980e83f734be","expires_in":1738,"scope":"read write"}
```

### Fetching acess_token by submitting refresh_token
```sh
curl -vu rajithapp:secret 'http://localhost:9191/api/oauth/token?grant_type=refresh_token&refresh_token=<refresh_token>'

{"access_token":"821c99d4-2c9f-4990-b68d-18eacaff54b2","token_type":"bearer","refresh_token":"e6f8624f-213d-4343-a971-980e83f734be","expires_in":1799,"scope":"read write"}
```

### Access secure resource sucessfully
```sh
curl -i -H "Authorization: Bearer <access_token>" http://localhost:9191/api/secure

Secure Hello!
```
### Add Task
###### Assuming userId 1-> Tester , 2 -> Developer 
```sh
POST/api/secure/addTaskHTTP/1.1Host: localhost: 9191Authorization: Bearerab592f52-a789-4887-96ef-f4b2d1f038ffContent-Type: application/jsonCache-Control: no-cachePostman-Token: 8a97498b-298b-434f-0b10-07147023e11f{
  "id": 2,
  "createdBy": 1,
  "assignedUser": 1,
  "createdAt": "1626263511064",
  "completedAt": "1626263511064",
  "title": "Testing Tasks CRUD",
  "role": "Tester",
  "userName": "admin"
}
```

### Get Task
###### Assuming userId 1-> Tester , 2 -> Developer 
```sh
GET /api/secure/getTask?role=Developer HTTP/1.1
Host: localhost:9191
Authorization: Bearer ab592f52-a789-4887-96ef-f4b2d1f038ff
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: f51963ee-5c05-9a69-1d51-27e26c3486e6

```
### Update Task
###### Assuming userId 1-> Tester , 2 -> Developer 
```sh
PUT /api/secure/updateTask HTTP/1.1
Host: localhost:9191
Authorization: Bearer ab592f52-a789-4887-96ef-f4b2d1f038ff
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: 4d6064ee-b743-eb3f-b777-6d88c633e944

{
"id": 1,

"role":"Developer",
"userName":"admin",
"completed":true
}
```

### Delete Task
###### Assuming userId 1-> Tester , 2 -> Developer 
```sh
POST /api/secure/deleteTask?id=1 HTTP/1.1
Host: localhost:9191
Authorization: Bearer ab592f52-a789-4887-96ef-f4b2d1f038ff
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: 42a5f6da-dead-dc8c-8cb1-0f551bff04f8

{

"role":"Tester",
"userName":"admin"
}
```