package IO;
public class Output {


    public Output() {
    }


    public static void someSpace(){
        int cnt = 15;
        while(cnt > 0){
            System.out.println();
            cnt--;
        }
    }
    public static void clearScreen(){
        int cnt = 15;
        while(cnt > 0){
            System.out.println();
            cnt--;
        }
    }

    public static void gameInitialization() {
        System.out.println("██╗     ███████╗ ██████╗ ███████╗███╗   ██╗██████╗ ███████╗                    ");
        System.out.println("██║     ██╔════╝██╔════╝ ██╔════╝████╗  ██║██╔══██╗██╔════╝██╗                 ");
        System.out.println("██║     █████╗  ██║  ███╗█████╗  ██╔██╗ ██║██║  ██║███████╗╚═╝                 ");
        System.out.println("██║     ██╔══╝  ██║   ██║██╔══╝  ██║╚██╗██║██║  ██║╚════██║██╗                 ");
        System.out.println("███████╗███████╗╚██████╔╝███████╗██║ ╚████║██████╔╝███████║╚═╝                 ");
        System.out.println("╚══════╝╚══════╝ ╚═════╝ ╚══════╝╚═╝  ╚═══╝╚═════╝ ╚══════╝                    ");
        System.out.println("                                                                               ");
        System.out.println("███╗   ███╗ ██████╗ ███╗   ██╗███████╗████████╗███████╗██████╗ ███████╗        ");
        System.out.println("████╗ ████║██╔═══██╗████╗  ██║██╔════╝╚══██╔══╝██╔════╝██╔══██╗██╔════╝        ");
        System.out.println("██╔████╔██║██║   ██║██╔██╗ ██║███████╗   ██║   █████╗  ██████╔╝███████╗        ");
        System.out.println("██║╚██╔╝██║██║   ██║██║╚██╗██║╚════██║   ██║   ██╔══╝  ██╔══██╗╚════██║        ");
        System.out.println("██║ ╚═╝ ██║╚██████╔╝██║ ╚████║███████║   ██║   ███████╗██║  ██║███████║        ");
        System.out.println("╚═╝     ╚═╝ ╚═════╝ ╚═╝  ╚═══╝╚══════╝   ╚═╝   ╚══════╝╚═╝  ╚═╝╚══════╝        ");
        System.out.println("                                                                               ");
        System.out.println(" █████╗ ███╗   ██╗██████╗     ██╗  ██╗███████╗██████╗  ██████╗ ███████╗███████╗");
        System.out.println("██╔══██╗████╗  ██║██╔══██╗    ██║  ██║██╔════╝██╔══██╗██╔═══██╗██╔════╝██╔════╝");
        System.out.println("███████║██╔██╗ ██║██║  ██║    ███████║█████╗  ██████╔╝██║   ██║█████╗  ███████╗");
        System.out.println("██╔══██║██║╚██╗██║██║  ██║    ██╔══██║██╔══╝  ██╔══██╗██║   ██║██╔══╝  ╚════██║");
        System.out.println("██║  ██║██║ ╚████║██████╔╝    ██║  ██║███████╗██║  ██║╚██████╔╝███████╗███████║");
        System.out.println("╚═╝  ╚═╝╚═╝  ╚═══╝╚═════╝     ╚═╝  ╚═╝╚══════╝╚═╝  ╚═╝ ╚═════╝ ╚══════╝╚══════╝");



        System.out.println("Welcome to Legends: Monsters and Heroes");


    }
    public static void print(String message){
        System.out.print(message);
    }




    public static void animateString(String[] animationFrames) {
        for (String frame : animationFrames) {
            System.out.print("\r" + frame);
            try {
                Thread.sleep(300); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }










    


}
