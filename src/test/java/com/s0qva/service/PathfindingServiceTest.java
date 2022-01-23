package com.s0qva.service;

import com.s0qva.dto.FoundPathsDto;
import com.s0qva.parameter_resolver.PathfindingServiceParameterResolver;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(
        {PathfindingServiceParameterResolver.class}
)
class PathfindingServiceTest {
    private static final String FIRST_ABSOLUTE_WINDOWS_PATH = "D:\\ServiceTest\\test1.txt";
    private static final String SECOND_ABSOLUTE_WINDOWS_PATH = "D:\\ServiceTest\\test2.txt";
    private static final String NON_EXISTENT_FILE = "non-existent file here";
    private PathfindingService pathfindingService;

    @BeforeAll
    void initialize(PathfindingService pathfindingService) {
        this.pathfindingService = pathfindingService;
    }

    @Test
    void checkAbsolutePathToOneFile() {
        List<String> realAnswer = List.of(FIRST_ABSOLUTE_WINDOWS_PATH);
        FoundPathsDto maybeAbsolutePath = pathfindingService.getAbsolutePathToFile("test1.txt",
                Path.of("D:\\", "ServiceTest"));

        assertThat(maybeAbsolutePath).hasFieldOrPropertyWithValue("foundPaths", realAnswer);
    }

    @Test
    void checkAbsolutePathToTwoFiles() {
        List<String> realAnswer = List.of(
                FIRST_ABSOLUTE_WINDOWS_PATH,
                SECOND_ABSOLUTE_WINDOWS_PATH
        );
        FoundPathsDto maybeAbsolutePath = pathfindingService.getAbsolutePathToFile("test",
                Path.of("D:\\", "ServiceTest"));

        assertThat(maybeAbsolutePath).hasFieldOrPropertyWithValue("foundPaths", realAnswer);
    }

    @Test
    void absolutePathToNonExistentFileIsEmptyList() {
        List<String> realAnswer = Collections.emptyList();
        FoundPathsDto maybeAbsolutePath = pathfindingService.getAbsolutePathToFile(NON_EXISTENT_FILE,
                Path.of("D:\\", "ServiceTest"));

        assertThat(maybeAbsolutePath).hasFieldOrPropertyWithValue("foundPaths", realAnswer);
    }
}
