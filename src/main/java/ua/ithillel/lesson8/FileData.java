package ua.ithillel.lesson8;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class FileData {
    private final String mane;
    private final long size;
    private final String path;

    public FileData(String mane, long size, String path) {
        this.mane = mane;
        this.size = size;
        this.path = path;
    }

    public String getMane() {
        return mane;
    }

    public long getSize() {
        return size;
    }

    public String getPath() {
        return path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileData fileData = (FileData) o;
        return size == fileData.size && mane.equals(fileData.mane) && path.equals(fileData.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mane, size, path);
    }
}
