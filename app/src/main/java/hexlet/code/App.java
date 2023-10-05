package hexlet.code;

import picocli.CommandLine;

import java.io.File;
import java.util.concurrent.Callable;

@CommandLine.Command
        (name = "genDiff", mixinStandardHelpOptions = true, version = "genDiff 1.0",
                description = "Compares two configuration files and shows a difference.")

final class App implements Callable<String> {
    @CommandLine.Parameters(index = "0", description = "path to first file")
    private File file1;
    @CommandLine.Parameters(index = "1", description = "path to second file")
    private File file2;
    @CommandLine.Option(names = {"-f", "--format"}, description = "output format [default: stylish]")
    private String format;
    @Override
      public String call() throws Exception {
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
