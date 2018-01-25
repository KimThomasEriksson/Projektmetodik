package view;

import java.io.IOException;

public class DeadEmote {

    public void startEmote() throws InterruptedException, IOException {
        Thread newThread =new Thread();
        int time = 0;
        while(time!=3) {


            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            System.out.println(DeadEmote.emoteUpp());
            Thread.sleep(200);

            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            System.out.println(DeadEmote.emoteCenter());
            Thread.sleep(200);

            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            System.out.println(DeadEmote.emoteDown());
            Thread.sleep(200);

            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            System.out.println(DeadEmote.emoteCenter());
            Thread.sleep(200);

            time++;

        }
    }

    public static String emoteCenter(){
        String emote;

        emote = "               ...\n" +
                "             ;::::;\n" +
                "           ;::::; :;\n" +
                "         ;:::::'   :;\n" +
                "        ;:::::;     ;.\n" +
                "       ,:::::'       ; GOODBYE   OOO\\\n" +
                "       ::::::;       ;          OOOOO\\\n" +
                "       ;:::::;       ;         OOOOOOOO\n" +
                "      ,;::::::;     ;'         / OOOOOOO\n" +
                "    ;:::::::::`. ,,,;.        /  / DOOOOOO\n" +
                "  .';:::::::::::::::::;,     /  /     DOOOO\n" +
                " ,::::::;::::::;;;;::::;,   /  /        DOOO\n" +
                ";`::::::`'::::::;;;::::: ,#/  /          DOOO\n" +
                ":`:::::::`;::::::;;::: ;::#  /            DOOO\n" +
                "::`:::::::`;:::::::: ;::::# /              DOO\n" +
                "`:`:::::::`;:::::: ;::::::#/               DOO\n" +
                " :::`:::::::`;; ;:::::::::##                OO\n" +
                " ::::`:::::::`;::::::::;:::#              00000\n" +
                " `:::::`::::::::::::;'`:;::#             0 ¤ ¤ 0\n" +
                "  `:::::`::::::::;' /  / `:#             0  _  0\n" +
                "   ::::::`:::::;'  /  /   `#             0 / \\ 0\n" +
                "                                          00000";

        return emote;
    }

    public static String emoteUpp(){
        String emote;

        emote=  "               ...\n" +
                "             ;::::;\n" +
                "           ;::::; :;\n" +
                "         ;:::::'   :;\t\t OOO\\\n" +
                "        ;:::::;     ;.\t\tOOOOO\\\n" +
                "       ,:::::'       ; GOODBYE OOOOOOOO\n" +
                "       ::::::;       ;         / OOOOOOO\n" +
                "       ;:::::;       ;        /\t / DOOOOOO\n" +
                "      ,;::::::;     ;'       /  /     DOOOO\n" +
                "    ;:::::::::`. ,,,;.      /  /        DOOO\n" +
                "  .';:::::::::::::::::;,   /  /          DOOO\n" +
                " ,::::::;::::::;;;;::::;, /  /            DOOO\n" +
                ";`::::::`'::::::;;;::::: ,# /              DOO\n" +
                ":`:::::::`;::::::;;::: ;::#/               DOO\n" +
                "::`:::::::`;:::::::: ;::::#                 OO\n" +
                "`:`:::::::`;:::::: ;::::::#                 OO\n" +
                " :::`:::::::`;; ;:::::::::##                O\n" +
                " ::::`:::::::`;::::::::;:::#              00000\n" +
                " `:::::`::::::::::::;'`:;::#             0 Ö Ö 0\n" +
                "  `:::::`::::::::;'  /   `:#             0  _  0\n" +
                "   ::::::`:::::;'/  /     `#             0 / \\ 0\n" +
                "                                          00000";

        return emote;
    }

    public static String emoteDown(){
        String emote;

        emote = "               ...\n" +
                "             ;::::;\n" +
                "           ;::::; :;\n" +
                "         ;:::::'   :;  \n" +
                "        ;:::::;     ;.  \n" +
                "       ,:::::'       ; GOODBYE\n" +
                "       ::::::;       ; \n" +
                "       ;:::::;       ;           OOO\\\n" +
                "      ,;::::::;     ;'         \tOOOOO\\\n" +
                "    ;:::::::::`. ,,,;.         OOOOOOOO\n" +
                "  .';:::::::::::::::::;,       / OOOOOOO\n" +
                " ,::::::;::::::;;;;::::;,     /  / DOOOOOO\n" +
                ";`::::::`'::::::;;;::::: ,#  /  /     DOOOO\n" +
                ":`:::::::`;::::::;;::: ;::# /  /        DOOO\n" +
                "::`:::::::`;:::::::: ;::::#/  /          DOOO\n" +
                "`:`:::::::`;:::::: ;::::::#  /            DOOO\n" +
                " :::`:::::::`;; ;:::::::::##/              DOO\n" +
                " ::::`:::::::`;::::::::;:::#              00000\n" +
                " `:::::`::::::::::::;'`:;::#             0 # # 0\n" +
                "  `:::::`::::::::;'  /  /`:#             0  _  0\n" +
                "   ::::::`:::::;'   /  /  `#             0 / \\ 0\n" +
                "                                          00000 ";
        return emote;
    }
}
