package hexlet.code;

import picocli.CommandLine;

import java.io.File;
import java.nio.file.Files;
import java.util.concurrent.Callable;

@CommandLine.Command
        (name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
                description = "Compares two configuration files and shows a difference.")
public class App implements Callable<String> {

    @CommandLine.Parameters(index = "0", description = "path to first file")
    private String filepath1;
    @CommandLine.Parameters(index = "1", description = "path to second file")
    private String filepath2;
    @CommandLine.Option(names = {"-f", "--format"}, description = "output format [default: stylish]")
    private String format = "stylish";

    @Override
    public String call() throws Exception {
        File file1 = new File(filepath1).getAbsoluteFile();
        File file2 = new File(filepath2).getAbsoluteFile();

        if (!Files.exists(file1.toPath())) {
            throw new Exception("File " + file1.getName() + " " + "does not exist!!!");
        }

        if (!Files.exists(file2.toPath())) {
            throw new Exception("File " + file2.getName() + " " + "does not exist!!!");
        }
        return Differ.findDifferent(file1, file2);
    }

    public static void main(String[] args) {
        int cmd = new CommandLine(new App()).execute(args);
        System.exit(cmd);
    }
}
