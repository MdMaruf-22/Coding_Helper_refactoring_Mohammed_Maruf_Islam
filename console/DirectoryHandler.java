import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryHandler {
    public String getCurrentPath() {
        return FileSystems.getDefault().getPath("").toAbsolutePath().toString();
    }

    public String changeDirectory() {
        return getCurrentPath();
    }

    public void handleDirectoryCommand(String input, String currentPath) throws IOException {
        if (input.startsWith("cd ")) {
            String dirName = input.substring(3).trim();
            forwardDirectory(dirName, currentPath);
        } else if (input.equalsIgnoreCase("dir")) {
            listDirectory(currentPath);
        } else {
            System.out.println("'" + input + "' is not recognized as a command.");
        }
    }

    private void forwardDirectory(String dirName, String currentPath) {
        String newPath = currentPath + "\\" + dirName;
        Path path = Paths.get(newPath);
        if (Files.exists(path)) {
            System.out.println("Changed directory to: " + newPath);
        } else {
            System.out.println("Directory does not exist.");
        }
    }

    private void listDirectory(String path) throws IOException {
        File directory = new File(path);
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("Unable to list files.");
        }
    }
}


