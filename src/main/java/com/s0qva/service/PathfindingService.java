package com.s0qva.service;

import com.s0qva.dto.FoundPathsDto;
import com.s0qva.util.PropertiesUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class PathfindingService {
    private static final PathfindingService INSTANCE = new PathfindingService();
    private static final Path[] DEFAULT_PATHS = new Path[]{
            PropertiesUtil.get("windows.drive.d"),
            PropertiesUtil.get("windows.drive.c")
    };

    private PathfindingService() {
    }

    public FoundPathsDto getAbsolutePathToFile(String fileName) {
        return getAbsolutePathToFile(fileName, DEFAULT_PATHS);
    }

    public FoundPathsDto getAbsolutePathToFile(String fileName, Path... paths) {
        FileVisitorImpl fileVisitor = new FileVisitorImpl(fileName);

        try {
            for (Path path : paths) {
                Files.walkFileTree(path, fileVisitor);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new FoundPathsDto(fileVisitor.getFoundPaths());
    }

    public static PathfindingService getInstance() {
        return INSTANCE;
    }
}
