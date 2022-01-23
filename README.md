# File path finder

A desktop application, which is written using JavaFX, that finds absolute paths to your files by their names.

Tools used
- AssertJ
- Gradle
- JUnit 5
- Java 16
- JavaFX (Controls, FXML)
- Log4j

## Key Features 

- Search for a file in the specified path
- Search files by keywords (word part, file extension and etc.)
- The file is searched on two drives (C:/ and D:/) if the user doesn't enter his path
- Search failed message appears when files are not found
- The found path can be copied automatically when highlighted with the mouse

## Data Input

There are two fields: the file name and the specified path.

![Alt Text](https://github.com/Soqva/file-path-finder/blob/master/github/resources/image/ui.jpg)

## Data Validation

User data for search is not validated in any way.

If the specified path does not exist, a message appears stating that the file was not found, but there are no exceptions.

![Alt Text](https://github.com/Soqva/file-path-finder/blob/master/github/resources/gif/non-existent%20file.gif)

## Result

To start searching for the file simply click the "Search" button. The found absolute paths is displayed in the ScrollPane.
To copy any path, you need to highlight it with the mouse. To clear data just click the "Clear" button.

ПОКАЗАТЬ РЕЗУЛЬТАТ И ОЧИСТКУ
![Alt Text](https://github.com/Soqva/file-path-finder/blob/master/github/resources/gif/guide.gif)

