package com.s0qva.dto;

import java.util.List;
import java.util.Objects;

public class FoundPathsDto {
    private final List<String> foundPaths;

    public FoundPathsDto(List<String> foundPaths) {
        this.foundPaths = foundPaths;
    }

    public List<String> getFoundPaths() {
        return foundPaths;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoundPathsDto that = (FoundPathsDto) o;
        return Objects.equals(foundPaths, that.foundPaths);
    }

    @Override
    public int hashCode() {
        return Objects.hash(foundPaths);
    }

    @Override
    public String toString() {
        return "FoundPathsDto{" +
                "foundPaths=" + foundPaths +
                '}';
    }
}
