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
    private File filepath1 = new File("/app/file1.json");
    @CommandLine.Parameters(index = "1", description = "path to second file")
    private File filepath2 = new File("/app/file2.json");
    @CommandLine.Option(names = {"-f", "--format"}, description = "output format [default: stylish]")
    private String format = "stylish";

    @Override
    public String call() throws Exception {

        if (!Files.exists(filepath1.toPath())) {
            throw new Exception("File " + filepath1.getName() + " " + "does not exist!!!");
        }

        if (!Files.exists(filepath1.toPath())) {
            throw new Exception("File " + filepath2.getName() + " " + "does not exist!!!");
        }
        return Differ.findDifferent(filepath1, filepath2);
    }

    public static void main(String[] args) {
        int cmd = new CommandLine(new App()).execute(args);
        System.exit(cmd);
    }
}
