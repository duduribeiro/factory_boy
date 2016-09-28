package me.carlosribeiro.factory_boy;

@FunctionalInterface
public interface BaseFactory {
  FactoryBuilder buildFactory(FactoryBuilder builder);
}
