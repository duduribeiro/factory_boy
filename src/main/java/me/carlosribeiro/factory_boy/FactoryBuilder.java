package me.carlosribeiro.factory_boy;

import java.util.HashMap;

/**
 * Created by carlos.ribeiro on 9/27/16.
 */
public class FactoryBuilder {
    private Class klass;
    private HashMap<String, Object> attributesMap = new HashMap<>();

    public FactoryBuilder forClass(Class klass) {
        this.klass = klass;
        return this;
    }

    protected Class getKlass() {
        return this.klass;
    }

    public FactoryBuilder withAttribute(String field, String value) {
        this.attributesMap.put(field, value);
        return this;
    }

    public HashMap<String, Object> getAttributesMap() {
        return attributesMap;
    }
}
