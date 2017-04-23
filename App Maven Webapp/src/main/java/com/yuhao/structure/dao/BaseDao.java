package com.yuhao.structure.dao;

import java.util.List;

public interface BaseDao<T> {
   public Integer insert(T t);
   
   public Integer update(T t);
   
   public Integer delete(String id);
   
   public List<T> search (T t);
   
   public Integer count(T t);
   
 
}
