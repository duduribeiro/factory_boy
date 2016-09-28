package me.carlosribeiro.factory_boy;

public abstract class BaseFactory {
    protected abstract FactoryBuilder buildFactory(FactoryBuilder builder);

    protected Class buildObject(FactoryBuilder builder) throws ClassNotFoundException {
        Class instance = Class.forName(builder.getKlass().getCanonicalName());
        return instance;
    }
}
