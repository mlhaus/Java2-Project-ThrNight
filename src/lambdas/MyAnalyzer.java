package lambdas;
@FunctionalInterface
public interface MyAnalyzer<T> {
    boolean analyze(T ob1, T ob2);
}
