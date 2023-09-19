import hexlet.code.Differ;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

class DifferTest {
    File file1;
    File file2;
    @BeforeEach
    public void setUp() {
        file1 = new File("/home/fjellaperc/HexletProjects/java-project-71/app/file1.json");
        file2 = new File("/home/fjellaperc/HexletProjects/java-project-71/app/file2.json");
    }

    @Test
    public void findDifferentsTest() throws IOException {
        String expected1 = """
                - follow: false
                  host: hexlet.io
                - proxy: 123.234.53.22
                - timeout: 50
                + timeout: 20
                + verbose: true""";
        String actual1 = Differ.findDifferent(file1, file2);
        Assertions.assertEquals(expected1, actual1);
    }
}

