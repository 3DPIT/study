package composite._2;

public class Main {
    public static void main(String[] args) {
        Folder root = new Folder("root");
        root.add(new File("a.txt",100));

        Folder sub1 = new Folder("sub1");
        root.add(sub1);

        root.list();
    }
}
