package org.rishav.learn.daos;


import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilders;

import java.net.InetAddress;
import java.net.UnknownHostException;


public class ElasticSearchDao {

    public static String getAllMessages() {
        SearchResponse response = getClient().prepareSearch()
                .setTypes("message")
                .execute()
                .actionGet();

        return response.toString();
    }

    public static String getMessage(String author) {

        SearchResponse response = getClient().prepareSearch("logstash-*")
                .setTypes("message")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(QueryBuilders.termQuery("content", author))
                .execute()
                .actionGet();


        return response.toString();
    }


    private static Client getClient() {
        Settings settings = Settings.settingsBuilder()
                .put("cluster.name", "elasticsearch_rishpaul").build();
        TransportClient client = TransportClient.builder().settings(settings).build();

        try {
            client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return client;
    }


}
