package me.carlosribeiro.factory_boy;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class FactoryBoy {
  public static <E> E create(E model, BaseFactory factory) {
    // TODO: try to make this shit better
    FactoryBuilder builder = factory.buildFactory(new FactoryBuilder());
    
    builder.getAttributesMap().forEach((key, value) -> {
      try {
        Field field = model.getClass().getDeclaredField(key);
        field.setAccessible(true);
        field.set(model, value);
      } catch (NoSuchFieldException | IllegalAccessException e) {
        e.printStackTrace();
        throw new RuntimeException(e);
      }
    });
    
    return model;
  }
  
  
  public static <E> List<E> createList(E model, BaseFactory factory, Integer quantity) {
    List<E> result = new ArrayList<E>();
    
    for (int i = 0; i < quantity; i++)
      result.add(create(model, factory));
    
    return result;
  }
  
}
