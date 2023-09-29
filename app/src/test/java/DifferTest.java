import hexlet.code.Differ;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

class DifferTest {
    File flatFile1;
    File flatFile2;
    File emptyFile1;
    File emptyFile2;
    File dataStructure1;
    File dataStructure2;
    String stylish = "stylish";
    String plain = "plain";


    @BeforeEach
    public void setUp() {
        flatFile1 = new File("./src/test/resources/Flatfile1.json");
        flatFile2 = new File("./src/test/resources/Flatfile2.json");
        emptyFile1 = new File("./src/test/resources/emptyfile1.json");
        emptyFile2 = new File("./src/test/resources/emptyfile2.json");
        dataStructure1 = new File("./src/test/resources/DataStructure1.json");
        dataStructure2 = new File("./src/test/resources/DataStructure2.json");
    }

    @Test
    public void isEmptyFiles() throws Exception {
        String expected1 = "{\n}";
        String actual1 = Differ.generate(emptyFile1.getAbsolutePath(), emptyFile2.getAbsolutePath(), stylish);
        Assertions.assertEquals(expected1, actual1);
        String expected2 = "";
        String actual2 = Differ.generate(emptyFile1.getAbsolutePath(), emptyFile2.getAbsolutePath(), plain);
        Assertions.assertEquals(expected2, actual2);
    }

    @Test
    public void isEmptyFlatFile1() throws Exception {
        String expected1 = """
                {
                  + host: hexlet.io
                  + timeout: 20
                  + verbose: true
                }""";
        String actual1 = Differ.generate(emptyFile1.getAbsolutePath(), flatFile2.getAbsolutePath(), stylish);
        Assertions.assertEquals(expected1, actual1);
    }

    @Test
    public void isEmptyFlatFile2() throws Exception {
        String expected1 = """
                {
                  - follow: false
                  - host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                }""";
        String actual1 = Differ.generate(flatFile1.getAbsolutePath(), emptyFile2.getAbsolutePath(), stylish);
        Assertions.assertEquals(expected1, actual1);
    }

    @Test
    public void generateTestStylishFormat() throws Exception {
        String expected1 = """
                {
                  - follow: false
                    host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                  + timeout: 20
                  + verbose: true
                }""";
        String actual1 = Differ.generate(flatFile1.getAbsolutePath(), flatFile2.getAbsolutePath(), stylish);
        Assertions.assertEquals(expected1, actual1);
        String expected2 = """
                  {
                      chars1: [a, b, c]
                    - chars2: [d, e, f]
                    + chars2: false
                    - checked: false
                    + checked: true
                    - default: null
                    + default: [value1, value2]
                    - id: 45
                    + id: null
                    - key1: value1
                    + key2: value2
                      numbers1: [1, 2, 3, 4]
                    - numbers2: [2, 3, 4, 5]
                    + numbers2: [22, 33, 44, 55]
                    - numbers3: [3, 4, 5]
                    + numbers4: [4, 5, 6]
                    + obj1: {nestedKey=value, isNested=true}
                    - setting1: Some value
                    + setting1: Another value
                    - setting2: 200
                    + setting2: 300
                    - setting3: true
                    + setting3: none
                  }""";
        String actual2 = Differ.generate(dataStructure1.getAbsolutePath(), dataStructure2.getAbsolutePath(), stylish);
        Assertions.assertEquals(expected2, actual2);
    }
}
