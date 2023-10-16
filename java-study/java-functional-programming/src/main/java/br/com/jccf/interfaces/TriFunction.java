package br.com.jccf.interfaces;

public interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}
