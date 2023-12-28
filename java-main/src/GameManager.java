package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GameManager {
    public static void main(String[] args) {
        ArrayList<Cham> champion = new ArrayList<>();
        Queue< String > q = new LinkedList< String >();
        List<String> winner = new ArrayList<>();
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


        int firstround = 0;
        while (firstround < champion.size()){
            firstround++;

            Double d = Math.random() * champion.size();
            Double f = Math.random() * champion.size();
            if (d.intValue()== f.intValue()) {
                f = Math.random() * champion.size();
            }else if(d.intValue()!= f.intValue()){

            }
            String player1Name = champion.get(d.intValue()).name;
            String player2Name = champion.get(f.intValue()).name;
            String player1Ment = champion.get(d.intValue()).getAttackMent();
            String player2Ment = champion.get(f.intValue()).getAttackMent();
            int player1Py1 = champion.get(f.intValue()).py;
            int player2Py2 = champion.get(f.intValue()).py;
            int player1Deal1 = champion.get(f.intValue()).deal;
            int player2Deal2 = champion.get(f.intValue()).deal;

            System.out.println(firstround + "라운드 대결은 "+player1Name+"과 "+player2Name+"입니다.");

            while(player1Py1 >=0 || player2Py2 >=0) {
                int player1health = player1Py1 - (int)(Math.random() *player2Deal2);
                int player2health = player2Py2 - (int)(Math.random() *player1Deal1);
                if(player1health<player1Py1) {
                    player1Py1 = player1health;
                }
                if(player2health<player2Py2) {
                    player2Py2 = player2health;
                }
                if(player1Py1<=0) {
                    System.out.println("$$$$$$$$$$$$$$$$$$"+player1Name+"의 승리$$$$$$$$$$$$$$$$$$$$");
                    winner.add(player1Name);
                    champion.remove(f.intValue());

                    break;
                }else if(player2Py2<=0){
                    System.out.println("$$$$$$$$$$$$$$$$$$"+player2Name+"의 승리$$$$$$$$$$$$$$$$$$$$");
                    winner.add(player2Name);
                    champion.remove(d.intValue());

                    break;
                }
                /*
                 * System.out.println(player1Ment);
                 * System.out.println(player2Name+"의 체력"+player1health);
                 * System.out.println(player2Ment);
                 * System.out.println(player1Name+"의 체력"+player2health);
                 */

            }

            //System.out.println(player1+"이 공격력 "+damege+"로 공격");
            //System.out.println(speech);
        }
    }
}