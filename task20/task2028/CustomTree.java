package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* 
Построй дерево(1)
*/

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    ArrayList<Entry<String>> list = new ArrayList<>();
    int count = 0;
    Entry<String> root;


    public CustomTree() {
        root = new Entry<>("root");
        list.add(root);
    }

    @Override
    public boolean add(String elementName) {
        Entry<String> newEntry = new Entry<>(elementName);
        for (Entry<String> entry : list ) {
            if (entry.availableToAddLeftChildren) {
                entry.leftChild = newEntry;
                entry.availableToAddLeftChildren = false;
                newEntry.parent = entry;
                break;
            }
            else if (entry.availableToAddRightChildren) {
                entry.rightChild = newEntry;
                entry.availableToAddRightChildren = false;
                newEntry.parent = entry;
                break;
            }
        }
        count++;
        return list.add(newEntry);
    }

    public String getParent(String elementName) {
        String nameParent = null;
        for (Entry<String> entry : list) {
            if (!entry.getName().equals("root")) {

                if (entry.getName().equals(elementName)) {
                    nameParent = entry.parent.getName();
                    break;
                }
            }

        }
        return nameParent;
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return count;
    }

    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }


    static class Entry<T> implements Serializable {

        String elementName;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;

        Entry<T> parent;
        Entry<T> leftChild;
        Entry<T> rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddRightChildren = true;
            availableToAddLeftChildren = true;

        }

        public String getName() {
            return this.elementName;
        }

        public boolean isAvailableToAddChildren() {
            return (availableToAddLeftChildren | availableToAddRightChildren);
        }
    }


}
