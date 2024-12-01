public class CompressionHandler {
    public void showOptions() {
        System.out.println("\tOptions:");
        System.out.println("\t\t1. Compress file (command: fcom)");
        System.out.println("\t\t2. Decompress file (command: dcom)");
    }

    public void compress(String currentPath) {
        System.out.println("Compressing files in: " + currentPath);
    }

    public void decompress(String currentPath) {
        System.out.println("Decompressing files in: " + currentPath);
    }
}
