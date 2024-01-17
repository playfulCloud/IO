package org.ptaszek.Model;

import java.util.List;


public class DBManager<T>  implements StorageManager{


    protected String login;
    protected String password;
    protected String db;
    protected String server;


    public boolean delete(T key){
        return false;
    };


    public boolean insert(T element) {
      return false;
    }


    public boolean update(T obj){
        return false;
    };

    public List<T> select(){
        return null;
    }

}
