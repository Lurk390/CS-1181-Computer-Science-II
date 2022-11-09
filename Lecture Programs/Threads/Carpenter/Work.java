package Threads.Carpenter;

public class Work {

    public static void main(String[] args) throws Exception {

        Toolbox tools = new Toolbox();

        CarpenterA a = new CarpenterA(tools);
        CarpenterB b = new CarpenterB(tools);

        a.start();
        b.start();

        a.join();
        b.join();

        System.out.println("Done!");
    }

}
