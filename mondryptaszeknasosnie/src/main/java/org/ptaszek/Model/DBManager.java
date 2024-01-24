package org.ptaszek.Model;

import java.util.List;


public class DBManager<T>  implements StorageManager<T>{


    protected String login;
    protected String password;
    protected String db;
    protected String server;


@Override
    public boolean delete(T key){
        return false;
    };


@Override
    public boolean insert(T element) {
      return false;
    }


@Override
    public boolean update(T obj){
        return false;
    };

@Override
    public List<T> select(){
        return null;
    }

}
