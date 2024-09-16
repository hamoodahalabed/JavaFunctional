package functionalinterface.function;

@FunctionalInterface
public interface DealWithNumber<T,F> {
    default void defaultMethod() {
        System.out.println("default method");
    }

    static void staticMethod() {
        System.out.println("static method");
    }

    T apply(F x);

    default <V> DealWithNumber<V, F> andThen(DealWithNumber<V, T> after) {
        return (F x) -> after.apply(this.apply(x));
    }
}