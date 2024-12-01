import java.io.IOException;
import java.util.Scanner;

public class CommandHandler {
    private final Scanner scanner = new Scanner(System.in);
    private String currentPath = null;
    private final DirectoryHandler directoryHandler = new DirectoryHandler();
    private final MetricsHandler metricsHandler = new MetricsHandler();
    private final CloneHandler cloneHandler = new CloneHandler();
    private final SearchHandler searchHandler = new SearchHandler();
    private final CompressionHandler compressionHandler = new CompressionHandler();

    public void start() throws IOException {
        while (true) {
            if (currentPath == null) {
                currentPath = directoryHandler.getCurrentPath();
            }
            System.out.print(currentPath + ">");

            String input = scanner.nextLine().trim();
            handleCommand(input);
        }
    }

    private void handleCommand(String input) throws IOException {
        switch (input.toLowerCase()) {
            case "help":
                printHelp();
                break;
            case "clone":
            case "1":
                cloneHandler.handleClone(currentPath);
                break;
            case "file_compress & file_decompress":
            case "2":
                compressionHandler.showOptions();
                break;
            case "fcom":
                compressionHandler.compress(currentPath);
                break;
            case "dcom":
                compressionHandler.decompress(currentPath);
                break;
            case "search":
            case "3":
                searchHandler.handleSearch(currentPath);
                break;
            case "4":
            case "metrics":
                metricsHandler.showMetrics();
                break;
            case "mc":
                metricsHandler.getMethodCount(currentPath);
                break;
            case "loc":
                metricsHandler.getLineOfCode(currentPath);
                break;
            case "a_loc":
                metricsHandler.getAverageLOC(currentPath);
                break;
            case "fc":
                metricsHandler.getFileCount(currentPath);
                break;
            case "cd":
                currentPath = directoryHandler.changeDirectory();
                break;
            case "exit":
            case "5":
                System.exit(0);
                break;
            default:
                directoryHandler.handleDirectoryCommand(input, currentPath);
        }
    }

    private void printHelp() {
        System.out.println("\t1. Clone");
        System.out.println("\t2. File Compress & File Decompress");
        System.out.println("\t3. Search");
        System.out.println("\t4. Metrics");
        System.out.println("\t\tFile Count --> fc");
        System.out.println("\t\tMethod Count --> mc");
        System.out.println("\t\tLine of Code --> loc");
        System.out.println("\t\tAverage Line of Code --> a_loc");
        System.out.println("\t5. Exit");
    }
}
