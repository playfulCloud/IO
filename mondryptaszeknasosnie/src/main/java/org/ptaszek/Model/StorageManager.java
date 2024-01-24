package org.ptaszek.Model;

import java.util.List;

public interface StorageManager<T> {
    public boolean delete(T key);


    public boolean insert(T element) ;


    public boolean update(T obj);

    public List<T> select();
}
