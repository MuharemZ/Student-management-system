# Student-Management-System
___
### you localize in Insomnia with this under.
- localhost:8080/student-management-system/api/v1/students
___

### JSON-Bodies
Create & Update
```
{
	"firstName": "firstname",
	"lastName": "lastname",
	"email": "xxxxxx@xxxx.xx",
	"phoneNumber": "000-000"
}
```
___
### No-Bodies
GetAll, GetById, GetStudentByLastName & Delete
___
### CRUD Endpoints
- Create:
    - /create
- Read:
    - /getAll
    - /{id}
    - /lastNameFind?lastname={lastname}
- Update:
    - /update/{id}
- Delete:
    - /delete/{id}

###Subject


localhost:8080/student-management-system/api/v1/subjects/
- Subject 
  - query?subjectName=Language
- Subject GetAll 
  - getAll
- create

###Teacher
localhost:8080/student-management-system/api/v1/teachers/
- Teacher
-- Teachers 
  - getAll
  - create
  




___