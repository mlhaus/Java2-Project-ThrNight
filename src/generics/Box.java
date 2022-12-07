package generics;

public class Box<T extends Candy> {
    private T contents;

    public void add(T object) {
        if(contents == null) {
            contents = object;
            System.out.println(object.getClass().getSimpleName() + " added.");
        } else {
            System.out.println("Cannot add " + object.getClass().getSimpleName() + ". Box contains " + contents.getClass().getSimpleName());
        }
    }

    public T remove() {
        if(contents == null) {
            System.out.println("The box is empty");
            return null;
        } else {
            System.out.println(contents.getClass().getSimpleName() + " removed.");
            T temp = contents;
            contents = null;
            return temp;
        }
    }
}
