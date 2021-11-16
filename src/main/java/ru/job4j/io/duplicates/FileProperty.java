package ru.job4j.io.duplicates;

import java.util.Objects;

/**
 * The type File property.
 * data model for searching files
 */
public class FileProperty {

    /**
     * first param -  size of the file.
     */
    private long size;

    /**
     * second param - name of the file.
     */
    private String name;

    public FileProperty(long size, String name) {
        this.size = size;
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FileProperty)) {
            return false;
        }
        FileProperty that = (FileProperty) o;
        return getSize() == that.getSize() && getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSize(), getName());
    }

    @Override
    public String toString() {
        return "FileProperty{"
               + "size=" + size
                + ", name='" + name + '\''
               + '}';
    }
}
