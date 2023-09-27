package hexlet.code;

import picocli.CommandLine;

import java.io.File;
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
    private String format;

    @Override
    public String call() throws Exception {
        File file1 = new File(filepath1).getAbsoluteFile();
        File file2 = new File(filepath2).getAbsoluteFile();
        if (!file1.exists()) {
            throw new Exception("File " + file1 + " does not exist!");
        }
        if (!file2.exists()) {
            throw new Exception("File " + file2 + " does not exist!");
        }
        if (format == null) {
            format = "stylish";
        }

        return Differ.generate(file1, file2, format);
    }

    public static void main(String[] args) {
        int cmd = new CommandLine(new App()).execute(args);
        System.exit(cmd);
    }
}
