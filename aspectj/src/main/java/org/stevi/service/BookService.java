package org.stevi.service;

import org.stevi.annotation.NotLoggable;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Simple service for demonstration purposes of AspectJ work.
 * All public method of the service will be loggable, except the one annotated with annotation @NotLoggable.
 */
public class BookService {

    private final AtomicInteger availableId = new AtomicInteger(0);
    private final Map<Integer, String> booksMap = new ConcurrentHashMap<>();

    public Integer insertBook(String name) {
        int id = availableId.getAndIncrement();
        save(id, name);
        return id;
    }

    private void save(Integer id, String name) {
        booksMap.put(id, name);
    }

    public String getBook(Integer id) {
        return booksMap.get(id);
    }

    @NotLoggable
    public void removeBook(Integer id) {
        booksMap.remove(id);
    }

}
