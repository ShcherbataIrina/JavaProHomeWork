package ua.ithillel.lesson8;

import java.util.*;

public class FileNavigator {
    private final Map<String, List<FileData>> files = new HashMap<>();

    public void add(String way, FileData file) {
        if (!way.equals(file.getPath())) {
            throw new FileExceptionBetweenPath();
        }
        if (files.containsKey(way)) {
            List<FileData> existingFiles = files.get(way);
            List<FileData> newFiles = new ArrayList<>(existingFiles);
            newFiles.add(file);
            files.put(way, newFiles);

        } else files.put(way, List.of(file));

    }

    public List<FileData> find(String way) {
        return files.get(way);
    }


    public List<FileData> filterBySize(long maxSize) {
        List<FileData> filteredList = new ArrayList<>();
        for (List<FileData> fileList : files.values()) {
            for (FileData file : fileList) {
                if (file.getSize() <= maxSize) {
                    filteredList.add(file);
                }
            }
        }
        return filteredList;
    }

    public void remove(String way) {
        files.remove(way);
    }


    public List<FileData> sortBySize() {
        List<FileData> sortedList = new ArrayList<>();
        for (var value : files.values()) {
            sortedList.addAll(value);
        }
        sortedList.sort((f1, f2) -> (int) (f1.getSize() - f2.getSize()));

        return sortedList;
    }


    protected Map<String, List<FileData>> getAll() {
        return files;
    }

}
