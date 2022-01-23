package com.s0qva.service;

import com.s0qva.util.message.FailedMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileVisitorImpl extends SimpleFileVisitor<Path> {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileVisitorImpl.class);
    private final List<String> foundPaths = new ArrayList<>();
    private final String fileName;

    public FileVisitorImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return super.preVisitDirectory(dir, attrs);
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        LOGGER.info("Method visitFile({}) is being processed", file);
        File fileObject = file.toFile();

        if (fileObject.isFile() && fileObject.getName().contains(fileName)) {
            foundPaths.add(fileObject.getAbsolutePath());
            LOGGER.info("Absolute path of file {} has been added", fileObject);
        }

        LOGGER.info("Method visitFile({}) has been finished, the search continues", file);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) {
        LOGGER.error(file.toFile().getAbsolutePath() + " " + FailedMessage.FILE_NOT_AVAILABLE.getMessage());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return super.postVisitDirectory(dir, exc);
    }

    public List<String> getFoundPaths() {
        return foundPaths;
    }

    public String getFileName() {
        return fileName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileVisitorImpl that = (FileVisitorImpl) o;
        return Objects.equals(foundPaths, that.foundPaths) && Objects.equals(fileName, that.fileName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(foundPaths, fileName);
    }

    @Override
    public String toString() {
        return "CustomFileVisitor{" +
                "result=" + foundPaths +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
