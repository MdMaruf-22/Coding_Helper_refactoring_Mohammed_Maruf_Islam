import java.util.Scanner;

public class SearchHandler {
    private final Scanner scanner = new Scanner(System.in);

    public void handleSearch(String currentPath) {
        System.out.println("Enter the file name or keyword to search in: " + currentPath);
        String query = scanner.nextLine();
        performSearch(currentPath, query);
    }

    private void performSearch(String currentPath, String query) {
        System.out.println("Searching for '" + query + "' in directory: " + currentPath);
        String newpath = pathGenerate(path);
        String queryWithFile = scan.nextLine().trim();
        try {
            String query = queryWithFile.substring(queryWithFile.indexOf("\"") + 1, queryWithFile.lastIndexOf("\"")).trim();
            String projectName = queryWithFile.substring(queryWithFile.lastIndexOf("\"") + 1).trim();
            String p = newpath + "\\" + projectName;
            Path filepath = Paths.get(p);
            if ((projectName.isEmpty() && !query.isEmpty()) || (query.isEmpty() && !projectName.isEmpty())) {
                System.out.println("Wrong Command");
            } else if (query.isEmpty() && projectName.isEmpty()) {
                System.out.println("Wrong Command");
            }
            else{
                if(Files.exists(filepath)){
                    SearchResult(newpath, projectName, query);
                }else {
                    System.out.println("The program cannot find '" + projectName + "'");
                }
            }
        } catch (Exception e) {
            System.out.println("Wrong Command");
        }
    }
}
