package com.hyomee.lambda;


@FunctionalInterface
public interface ThreeFunction<T, V, W, R> {
    R apply(T t, V v, W w);
}