package hexlet.code;

import picocli.CommandLine;

import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;

@CommandLine.Command
        (name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
                description = "Compares two configuration files and shows a difference.")

public class App implements Callable<String> {
    @CommandLine.Parameters(index = "0", description = "path to first file")
    private File file1;
    @CommandLine.Parameters(index = "1", description = "path to second file")
    private File file2;
    @CommandLine.Option(names = {"-f", "--format"}, description = "output format [default: stylish]")
    private String format;
    @Override
    public String call() throws Exception {
        String filepath1 = file1.getAbsolutePath();
        String filepath2 = file2.getAbsolutePath();
        if (!file1.exists()) {
            throw new Exception("File " + file1 + " does not exist!");
        }
        if (!file2.exists()) {
            throw new Exception("File " + file2 + " does not exist!");
        }
        if (format == null) {
            format = "stylish";
        }
        return Differ.generate(filepath1, filepath2, format);
    }
    public static void main(String[] args) {
        int cmd = new CommandLine(new App()).execute(args);
        System.exit(cmd);
    }
}
