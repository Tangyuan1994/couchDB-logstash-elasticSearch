package org.rishav.learn.daos;

import org.lightcouch.CouchDbClient;
import org.lightcouch.Response;
import org.rishav.learn.models.Message;

public class CouchDBDao {
    public static Response insertMessage(Message message) {
        CouchDbClient dbClient = new CouchDbClient();

        return dbClient.save(message);
    }
}
