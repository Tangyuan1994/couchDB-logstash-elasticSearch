package org.rishav.learn.resources;

import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import org.lightcouch.Response;
import org.rishav.learn.models.Message;
import org.rishav.learn.services.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.Date;

@Path("/messages")
public class MessageResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllMessages() throws IOException {
        return MessageService.getAllMessages();
    }

    @GET
    @Path("/{author}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getMessage(@PathParam("author") String author) throws IOException {
        return MessageService.getMessage(author);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String postMessage(Message message) {
        message.setCreated(new Date());
        Response response = MessageService.insertMessage(message);

        return new Gson().toJson(ImmutableMap.builder().
                put("id", response.getId()).
                put("rev", response.getRev()).build());
    }
}