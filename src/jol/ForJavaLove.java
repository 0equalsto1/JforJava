package jol;

import org.openjdk.jol.vm.VM;

import java.util.Random;

public class ForJavaLove {
    static int tree;
    static String treeEmoji;
    static {
        tree = 0x1F333;
        treeEmoji = Character.toString(tree).repeat(51);
        System.setProperty("jdk.attach.allowAttachSelf", "true");
        Random random = new Random();
        int nextInt = random.nextInt(10);
        if (nextInt < 4) {
            System.out.println("   |  /\\ \\  / /\\  \n" +
                    " \\_| /--\\ \\/ /--\\ ");
        } else if (nextInt < 8) {
            System.out.println("""
                         ,--. ,---.,--.   ,--.,---.  \s
                         |  |/  O  \\\\  `.'  //  O  \\ \s
                    ,--. |  |  .-.  |\\     /|  .-.  |\s
                    |  '-'  /  | |  | \\   / |  | |  |\s
                     `-----'`--' `--'  `-'  `--' `--'\s""");
        } else {
            System.out.println("""
                       __     ______     __   __   ______   \s
                      /\\ \\   /\\  __ \\   /\\ \\ / /  /\\  __ \\  \s
                     _\\_\\ \\  \\ \\  __ \\  \\ \\ \\'/   \\ \\  __ \\ \s
                    /\\_____\\  \\ \\_\\ \\_\\  \\ \\__|    \\ \\_\\ \\_\\\s
                    \\/_____/   \\/_/\\/_/   \\/_/      \\/_/\\/_/\s""");
        }

        System.out.println(VM.current().details());
        treeLine();
    }

    private static void treeLine() {
        System.out.println(treeEmoji);
    }
}

