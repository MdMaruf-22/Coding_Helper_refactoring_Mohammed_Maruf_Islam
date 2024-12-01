import metrices.Average_LOC;
import metrices.FileCount;
import metrices.LineOfCode;
import metrices.MethodCount;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MetricsHandler {
    public void showMetrics() {
        System.out.println("\tMetrics:");
        System.out.println("\t\tFile Count --> fc");
        System.out.println("\t\tMethod Count --> mc");
        System.out.println("\t\tLine of Code --> loc");
        System.out.println("\t\tAverage Line of Code --> a_loc");
    }

    public void getFileCount(String currentPath) {
        String newpath = pathGenerate(currenctpath);
        System.out.print("\tWrite Project name:");
        String projectName = Input();
        String path = newpath + "\\" + projectName;
        try {
            Path p = Paths.get(path);
            if (Files.exists(p) && Files.isDirectory(p) && !projectName.isEmpty()) {
                new FileCount().classCount(path);

            } else if (Files.exists(p) && !Files.isDirectory(p)) {
                System.out.println("Invalid project name");
            } else {
                System.out.println("The program cannot find '" + projectName + "'");
            }
        } catch (Exception e) {
            System.out.println("Invalid project name");
        }
    }

    public void getMethodCount(String currentPath) {
        String newpath = pathGenerate(path);
        try {
            System.out.print("\tProject\\File Name:");
            String name = Input();
            String projectPath = newpath + "\\" + name;
            Path filepath = Paths.get(projectPath);
            if (Files.exists(filepath) && Files.isDirectory(filepath) && !name.isEmpty()) {
                new MethodCount().getTotalMethods(projectPath, name);
            } else if (Files.exists(filepath) && !Files.isDirectory(filepath) && !name.isEmpty()) {
                String file = filepath.toString();
                new MethodCount().getTotalMethods(projectPath, name);
            } else {
                System.out.println("The program cannot find '" + name + "'");
            }
        } catch (Exception e) {
            System.out.println("Invalid input");

        }
    }

    public void getLineOfCode(String currentPath) {
        String newpath = pathGenerate(Currentpath);
        System.out.print("\tWrite the file name:");
        String fileName=Input();
        String p = newpath + "\\" + fileName.trim();
        try {
            Path path = Paths.get(p);
            if (Files.exists(path) && !Files.isDirectory(path)) {
                int totalLine = new LineOfCode().countLines(path.toString());
                System.out.println("\tLine of " + fileName + " is " + totalLine);
            } else {
                System.out.println("The program cannot find '" + fileName + "'");
            }
        } catch (Exception e) {
            System.out.println("Invalid filename");
        }
    }

    public void getAverageLOC(String currentPath) {
        String newpath = pathGenerate(currentpath);
        System.out.print("\tWrite the project name:");
        String projectName = Input();
        String path = newpath + "\\" + projectName;

        try {
            Path p = Paths.get(path);
            if (Files.exists(p) && Files.isDirectory(p) && !projectName.isEmpty()) {
                new Average_LOC().totalClass(path);

            } else if (Files.exists(p) && !Files.isDirectory(p)) {
                System.out.println("Invalid project name");
            } else {
                System.out.println("The program cannot find '" + projectName + "'");
            }
        } catch (Exception e) {
            System.out.println("Invalid projectname");
        }
    }
}
