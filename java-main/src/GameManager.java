package src;

import java.util.*;

public class GameManager {
    public static void main(String[] args) {
        ArrayList<Cham> champion = new ArrayList<>();
        //가렌이름
        for (int i = 1; i < 4; i++) {
            Garen garen1 = new Garen();
            garen1.name = garen1.name+i;
            champion.add(garen1);
        }
        //징크스 이름
        for (int i = 1; i < 5; i++) {
            Jing jing1 = new Jing();
            jing1.name = jing1.name+i;
            champion.add(jing1);
        }
        //솔 이름
        for (int i = 1; i < 6; i++) {
            Sol sol1 = new Sol();
            sol1.name = sol1.name+i;
            champion.add(sol1);
        }
        System.out.println("ㅈ밥 대전을 시작하지.... ");
        Collections.shuffle(champion);
        System.out.println();
        while (champion.size() != 1){
            champion = getWinnerChampion(champion);
            getWinnerChampion(champion);
        }
    }
    private static ArrayList<Cham> getWinnerChampion(ArrayList<Cham> champion){
        ArrayList<Cham> winner = new ArrayList<>();
        int round = 0;
        while (!champion.isEmpty()){
            round++;
            int zero = 0;
            int half = champion.size()/2;
            int max = champion.size();

            Cham player1 = champion.get(zero);
            Cham player2 = champion.get(half);
            Cham workOver = champion.get(max-1);

            String player1Name = player1.name;
            String player2Name = player2.name;
            String workOverName = workOver.name;
            String player1Ment = player1.getAttackMent();
            String player2Ment = player2.getAttackMent();
            int player1Py1 = player1.py;
            int player2Py2 = player2.py;
            int player1Deal1 = player1.deal;
            int player2Deal2 = player2.deal;

            System.out.println(round + "라운드 대결은 "+player1Name+"과 "+player2Name+"입니다.");

            if(champion.size()%2 == 1){
                winner.add(workOver);
                System.out.println("부전승으로 "+workOverName+"가 올라갑니다.");
            }
            while(player1Py1 > 0 && player2Py2 > 0) {
                int player1health = player1Py1 - (int)(Math.random() *player2Deal2);
                int player2health = player2Py2 - (int)(Math.random() *player1Deal1);
                if(player1health<player1Py1) {
                    player1Py1 = player1health;
                }
                if(player2health<player2Py2) {
                    player2Py2 = player2health;
                }
//                System.out.println(player1Ment);
//                System.out.println(player1Name+"의 체력"+player1health);
//                System.out.println(player2Ment);
//                System.out.println(player2Name+"의 체력"+player2health);
                if(player1Py1<=0) {
                    System.out.println("$$$$$$$$$$$$$$$$$$"+player2Name+"의 승리$$$$$$$$$$$$$$$$$$$$");
                    winner.add(player2);
                    champion.remove(player1);
                    champion.remove(player2);

                }else if(player2Py2<=0){
                    System.out.println("$$$$$$$$$$$$$$$$$$"+player1Name+"의 승리$$$$$$$$$$$$$$$$$$$$");
                    winner.add(player1);
                    champion.remove(player2);
                    champion.remove(player1);
                }

            }
        }
        champion = winner;
        return champion;
    }
}