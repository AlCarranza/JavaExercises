/**
 * An abstract class is a class that cannot be instantiated but can 
 * be subclassed.
 * 
 * An abstract method is a method that is declared without implementation
 * 
 * When a class includes abstract methods then the class itself must be abstract
 * 
 * When an abstract class is subclassed then the subclass ussually provides an implementation
 * for all the abstract methods in the parent class. If not, then the subclass must also be abstract.
 */
public abstract class Shape {
    
    public abstract double area();

    @Override
    public String toString() {
        return getClass().getSimpleName() + " area =" + area();
    }
}
