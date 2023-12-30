package src;

import java.util.*;

public class GameManager {
    public static void main(String[] args) {
        ArrayList<Cham> champion = new ArrayList<>();
        ArrayList<Cham> winner = new ArrayList<Cham>();

        //가렌이름
        for (int i = 1; i < 4; i++) {
            Garen garen1 = new Garen();
            garen1.name = garen1.name+String.valueOf(i);
            champion.add(garen1);
        }
        //징크스 이름
        for (int i = 1; i < 5; i++) {
            Jing jing1 = new Jing();
            jing1.name = jing1.name+String.valueOf(i);
            champion.add(jing1);
        }
        //솔 이름
        for (int i = 1; i < 6; i++) {
            Sol sol1 = new Sol();
            sol1.name = sol1.name+String.valueOf(i);
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
        ArrayList<Cham> winner = new ArrayList<Cham>();
        int firstround = 0;
        while (!champion.isEmpty()){
            firstround++;
            int i = 0;
            int j = champion.size()/2;
            int h = champion.size();

            Cham a = champion.get(i);
            Cham s = champion.get(j);
            Cham workOver = champion.get(j);

            String player1Name = a.name;
            String player2Name = s.name;
            String player1Ment = a.getAttackMent();
            String player2Ment = s.getAttackMent();
            int player1Py1 = a.py;
            int player2Py2 = s.py;
            int player1Deal1 = a.deal;
            int player2Deal2 = s.deal;

            System.out.println(firstround + "라운드 대결은 "+player1Name+"과 "+player2Name+"입니다.");

            if(champion.size()/2 ==1){
                winner.add(workOver);
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
                    winner.add(a);
                    champion.remove(a);
                    champion.remove(s);

                }else if(player2Py2<=0){
                    System.out.println("$$$$$$$$$$$$$$$$$$"+player1Name+"의 승리$$$$$$$$$$$$$$$$$$$$");
                    winner.add(s);
                    champion.remove(a);
                    champion.remove(s);
                }

            }
        }
        return winner;
    }
}