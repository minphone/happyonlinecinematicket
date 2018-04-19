package co.minphone.happyonlinecinematicket.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class BaseMapper<E, T> {

  public abstract T map(E obj);

  public List<T> map(Collection<E> objs){
    List<T> list = new ArrayList<>();
    for (E obj : objs){
      list.add(map(obj));
    }
    return list;
  }
}
