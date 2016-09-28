package me.carlosribeiro.factory_boy;

import java.lang.reflect.Field;
import java.util.Map;

public class FactoryBoy {
    public static <E> E create(E model, BaseFactory factory) {
        //TODO: try to make this shit better
        FactoryBuilder builder = factory.buildFactory(new FactoryBuilder());
        try {
            model = (E) factory.buildObject(builder).cast(model);
            for (Map.Entry<String, Object> entry: builder.getAttributesMap().entrySet()) {
                Field field = model.getClass().getDeclaredField(entry.getKey());
                field.setAccessible(true);
                field.set(model, entry.getValue());
            }
        //TODO: think in what to do when this exceptions occurs. (maybe throw it up)
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return model;
    }
}
