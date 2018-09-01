package ru.innopolis.stc12.homework;

import java.util.*;

public class ObjectBox<T> {
    private Set<T> set = new TreeSet<>();

    public ObjectBox(T array[]) throws WrongObjectArgument {
        try {
            if (array != null) {
                for (T o : array) {
                    set.add(o);
                }
            }
        } catch (Exception e) {
            throw new WrongObjectArgument("Elements of array must be one type");
        }
    }

    public Set getSet() {
        return set;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        ObjectBox math = (ObjectBox) obj;
        return set.equals(math.set);
    }

    @Override
    public String toString() {
        return "Array: " + set + "\nhashCode: " + set.hashCode();
    }

    public void addObject(T elem) throws WrongObjectArgument {
        try {
            if (elem != null) {
                set.add(elem);
            }
        } catch (Exception e) {
            throw new WrongObjectArgument("Elements of array must be one type");
        }
    }

    public boolean deleteObject(T elem) throws WrongObjectArgument {
        try {
            if (elem != null && set.contains(elem)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            throw new WrongObjectArgument("Elements of array must be one type");
        }
    }

    public void dump() {
        for (T o : set) {
            System.out.print(o + " ");
        }
        System.out.println();
    }

    public void delete(T value) throws WrongObjectArgument {
        try {
            this.set.remove(value);
        } catch (Exception e) {
            throw new WrongObjectArgument("Elements of array must be one type");
        }
    }

}
