package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    ArrayList<Entry<String>> list = new ArrayList<>();
    Entry<String> root;


    public CustomTree() {
        root = new Entry<>("root");
        list.add(root);
    }

    @Override
    public boolean add(String elementName) {
        Entry<String> newEntry = new Entry<>(elementName);
        boolean availableAdd = false;
        for (Entry<String> entry : list ) {
            if (entry.availableToAddLeftChildren) {
                entry.leftChild = newEntry;
                entry.availableToAddLeftChildren = false;
                newEntry.parent = entry;
                availableAdd = true;
                newEntry.countDeepLeft = entry.countDeepLeft + 2;
                break;
            }
            else if (entry.availableToAddRightChildren) {
                entry.rightChild = newEntry;
                entry.availableToAddRightChildren = false;
                newEntry.parent = entry;
                availableAdd = true;
                newEntry.countDeepLeft = entry.countDeepLeft + 1;
                break;
            }
        }

        if (!availableAdd) {
            int maxDeep = 0;
            for (Entry<String> entry : list) {
                if (entry.countDeepLeft > maxDeep) maxDeep = entry.countDeepLeft;
            }
            for (Entry<String> entry : list) {
                if (entry.countDeepLeft == maxDeep) {
                    //entry.availableToAddLeftChildren = true;
                    entry.leftChild = newEntry;
                    entry.availableToAddLeftChildren = false;
                    newEntry.parent = entry;
                    newEntry.countDeepLeft = entry.countDeepLeft + 2;
                }
            }
        }
        return list.add(newEntry);
    }

    public boolean remove(Object o) {
        if (!(o instanceof String)) throw new UnsupportedOperationException();
        for (Entry<String> entry : list) {
            if (entry.getName().equals(o)) {
                removeChild(entry);
                list.remove(entry);
                break;
            }
        }
        return true;
    }

    void removeChild(Entry<String> entry) {
        if (entry.leftChild != null && list.contains(entry.leftChild)) removeChild(entry.leftChild);
        if (entry.rightChild != null && list.contains(entry.rightChild)) removeChild(entry.rightChild);
        list.remove(entry);
    }

    public String getParent(String elementName) {
        String nameParent = null;
        for (Entry<String> entry : list) {
            if (!entry.getName().equals("root")) {
                if (entry.getName().equals(elementName) && entry.parent != null) {
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
        return list.size() - 1;
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
        int countDeepLeft;

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
            return (availableToAddLeftChildren || availableToAddRightChildren);
        }
    }


}
