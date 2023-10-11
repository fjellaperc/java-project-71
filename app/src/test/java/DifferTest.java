import hexlet.code.Differ;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

class DifferTest {
    private File flatFile1;
    private File testEmpty;
    private File stylishTest;
    private File plainTest;
    private File emptyFile1;
    private File dataStructure1;
    private File dataStructure2;
    private String stylish = "stylish";
    private String plain = "plain";

    @BeforeEach
    public void setUp() {
        testEmpty = new File("./src/test/resources/inputEmptyTest");
        flatFile1 = new File("./src/test/resources/Flatfile1.json");
        emptyFile1 = new File("./src/test/resources/emptyfile1.json");
        stylishTest = new File("./src/test/resources/stylishTest");
        plainTest = new File("./src/test/resources/plainTest");
        dataStructure1 = new File("./src/test/resources/DataStructure1.json");
        dataStructure2 = new File("./src/test/resources/DataStructure2.json");
    }

    public static String getDataFromFile(File file) throws IOException {
        return Files.readString(file.toPath().toAbsolutePath());
    }

    @Test
    public void isEmptyFlatFile1() throws Exception {
        String expected1 = getDataFromFile(testEmpty);
        String actual1 = Differ.generate(emptyFile1.getAbsolutePath(), flatFile1.getAbsolutePath(), stylish);
        Assertions.assertEquals(expected1, actual1);
    }
    @Test
    public void isStylishTest() throws Exception {
        String expected2 = getDataFromFile(stylishTest);
        String actual2 = Differ.generate(dataStructure1.getAbsolutePath(), dataStructure2.getAbsolutePath(), stylish);
        Assertions.assertEquals(expected2, actual2);
    }
    @Test
    public void isPlainTest() throws Exception {
        String expected2 = getDataFromFile(plainTest);
        String actual2 = Differ.generate(dataStructure1.getAbsolutePath(), dataStructure2.getAbsolutePath(), plain);
        Assertions.assertEquals(expected2, actual2);
    }
}

