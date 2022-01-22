package com.s0qva.service;

import com.s0qva.dto.FoundPathsDto;
import com.s0qva.util.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class PathfindingService {
    private static final PathfindingService INSTANCE = new PathfindingService();
    private static final Logger LOGGER = LoggerFactory.getLogger(PathfindingService.class);
    private static final Path[] DEFAULT_PATHS = new Path[]{
            PropertiesUtil.get("windows.drive.d"),
            PropertiesUtil.get("windows.drive.c")
    };

    private PathfindingService() {
    }

    public FoundPathsDto getAbsolutePathToFile(String fileName) {
        LOGGER.info("File name received: {}, getAbsolutePathToFile with default paths is called", fileName);
        return getAbsolutePathToFile(fileName, DEFAULT_PATHS);
    }

    public FoundPathsDto getAbsolutePathToFile(String fileName, Path... paths) {
        LOGGER.info("File name received: {}, getAbsolutePathToFile with {} paths is called", fileName, paths);
        FileVisitorImpl fileVisitor = new FileVisitorImpl(fileName);
        LOGGER.info("Object {} has been created", fileVisitor);
        try {
            for (Path path : paths) {
                LOGGER.info("Path {} is being processed", path);
                Files.walkFileTree(path, fileVisitor);
                LOGGER.info("Path {} has been finished", path);
            }
        } catch (IOException exception) {
            LOGGER.error("Exception has been appeared", exception);
            exception.printStackTrace();
        }

        LOGGER.info("Method getAbsolutePathToFile has finished");
        return new FoundPathsDto(fileVisitor.getFoundPaths());
    }

    public static PathfindingService getInstance() {
        return INSTANCE;
    }
}
