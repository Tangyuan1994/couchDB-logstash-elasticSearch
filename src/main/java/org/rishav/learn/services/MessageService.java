package org.rishav.learn.services;

import org.lightcouch.Response;
import org.rishav.learn.daos.CouchDBDao;
import org.rishav.learn.daos.ElasticSearchDao;
import org.rishav.learn.models.Message;

public class MessageService {

    public static String getAllMessages() {
        return ElasticSearchDao.getAllMessages();
    }

    public static String getMessage(String author) {
        return ElasticSearchDao.getMessage(author);
    }

    public static Response insertMessage(Message message) {
        return CouchDBDao.insertMessage(message);
    }
}
