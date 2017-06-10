package Chapter3.StacksAndQueue;

import java.util.LinkedList;

/**
 * Animal Shelter: An animal shelter, which holds only dogs and cats, operates on a strictly "first in, first
 * out" basis. People must adopt either the "oldest" (based on arrival time) of all animals at the shelter,
 * or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of
 * that type). They cannot select which specific animal they would like. Create the data structures to
 * maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog,
 * and dequeueCat. You may use the built-in LinkedList data structure.
 */
public class AnimalShelter {
    static abstract class Animal {
        private int order;
        protected String name;

        public Animal(String name) {
            this.name = name;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public boolean isOlderThan(Animal a) {
            return this.order < a.getOrder();
        }
    }

    LinkedList<Dog> dogs = new LinkedList<>();
    LinkedList<Cat> cats = new LinkedList<>();
    private int order = 0; // acts as timestamp

    public void enqueue(Animal a) {
//     Order is used as a sort of timestamp, so that we can compare the insertion
//     order of a dog to a cat.
        a.setOrder(order);
        order++;
        if (a instanceof Dog) dogs.add((Dog) a);
        else if (a instanceof Cat) cats.add((Cat) a);
    }

    public Animal dequeueAny() {
        /* Look at tops of dog and cat queues, and pop the queue with the oldest value. */
        if (dogs.size() == 0) {
            return dequeueCats();
        } else if (cats.size() == 0) {
            return dequeueDogs();
        }
        Dog dog = dogs.peek();
        Cat cat = cats.peek();
        if (dog.isOlderThan(cat)) {
            return dequeueDogs();
        } else {
            return dequeueCats();
        }

    }

    public Dog dequeueDogs() {
        return dogs.poll();
    }

    public Cat dequeueCats() {
        return cats.poll();
    }


    public static class Dog extends Animal {
        public Dog(String name) {
            super(name);
        }
    }

    public static class Cat extends Animal {
        public Cat(String name) {
            super(name);
        }
    }

}
