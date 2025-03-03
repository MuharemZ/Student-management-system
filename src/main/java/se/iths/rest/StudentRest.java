package se.iths.rest;

import se.iths.entity.Student;
import se.iths.service.StudentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("student")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentRest {

    @Inject
    StudentService studentService;

    @Path("create")
    @POST
    public Response createStudent(Student student)
    {
        try {
            studentService.createStudent(student);
            return Response.ok(student).build();
        } catch (WebApplicationException i){
            return Response.status(Response.Status.BAD_REQUEST).type(MediaType.APPLICATION_JSON).build();
        }
    }

    @Path("update/{id}")
    @PATCH
    public Response updateStudent(@PathParam("id") Long id, Student student) {

        Student updatedStudent = studentService.findStudentById(id);

        String errorMessage = "{\"Error\": \"No students found with id " + id + "\"}";
        try {

            if (updatedStudent == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity(errorMessage).type(MediaType.APPLICATION_JSON).build();
            }

            updatedStudent.setFirstName(student.getName());
            updatedStudent.setLastName(student.getLastName());
            updatedStudent.setEmail(student.getEmail());
            updatedStudent.setPhoneNumber(student.getPhoneNumber());

            studentService.updateStudent(updatedStudent);

            return Response.accepted(updatedStudent).build();
        } catch (WebApplicationException i) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(errorMessage).type(MediaType.APPLICATION_JSON).build();
        }

    }

    @Path("{id}")
    @GET
    public Response getStudent(@PathParam("id") Long id) {
        Student student = studentService.findStudentById(id);
        try {
            if (student == null) {
                String errorMessage = "No students found with this id.}";
                return Response.status(Response.Status.NOT_FOUND)
                        .entity(errorMessage).type(MediaType.APPLICATION_JSON).build();
            }

            return Response.accepted(student).build();
        } catch (WebApplicationException i) {
            String errorMessage = "{No students found with this id.}";
            return Response.status(Response.Status.BAD_REQUEST).entity(errorMessage).type(MediaType.APPLICATION_JSON).build();
        }

    }

    @Path("getAll")
    @GET
    public List<Student> getAllStudent() {
        List<Student> foundAllStudents = studentService.getAllStudents();
        if (foundAllStudents == null || foundAllStudents.isEmpty()) {
            String errorMessage = "{No students found.}";
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                    .entity(errorMessage).type(MediaType.APPLICATION_JSON).build());
        }

        return studentService.getAllStudents();
    }

    @Path("lastNameFind")
    @GET
    public Response getStudentByLastName(@QueryParam("lastname") String lastname)
    {
        String message = "{No student found with that lastname.}";
        List<Student> foundStudent = studentService.getStudentByLastName(lastname);
        if (foundStudent == null || foundStudent.isEmpty()) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST)
                    .entity(message).type(MediaType.APPLICATION_JSON).build());
        }
        return Response.ok(foundStudent).build();
    }

    @Path("delete/{id}")
    @DELETE
    public Response deleteStudent(@PathParam("id") Long id) {
        if (studentService.findStudentById(id) == null)
            throw new NotFoundException("{Student with this " + id + " was not found}");

        studentService.deleteStudent(id);
        return Response.noContent().build();
    }

}