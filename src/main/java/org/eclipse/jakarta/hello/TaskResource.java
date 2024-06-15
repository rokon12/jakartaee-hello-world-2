package org.eclipse.jakarta.hello;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;

@Path("/tasks")
public class TaskResource {

    @Inject
    private TaskRepository repository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Task> getAllTasks(@QueryParam("completed") Boolean completed) {
        if (completed == null) {
            return repository.findAll().toList();
        } else if (completed) {
            return repository.findAll().filter(Task::isCompleted).toList();
        } else {
            return repository.findAll().filter(task -> !task.isCompleted()).toList();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createTask(Task task) {
        repository.save(task);
        return Response.created(URI.create("/tasks/" + task.getId())).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateTask(@PathParam("id") Long id, Task updatedTask) {
        updatedTask.setCompleted(!updatedTask.isCompleted());
        repository.save(updatedTask);
        return Response.noContent().build();
    }
}
