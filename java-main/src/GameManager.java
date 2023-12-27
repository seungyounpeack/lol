package src;

import java.util.ArrayList;
import java.util.Arrays;

public class GameManager {
    public static void main(String[] args) {
        ArrayList<Cham> champion = new ArrayList<>();
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
            sol1.chat = sol1.chat;
            champion.add(sol1);
        }
        System.out.println("ㅈ밥 대전을 시작하지.... ");

        int firstround = 0;
        while (firstround < champion.size()/2){
            firstround++;

            Double d = Math.random() * champion.size();
            Double f = Math.random() * champion.size();

            String player1Name = champion.get(d.intValue()).name;
            String player2Name = champion.get(f.intValue()).name;
            String player1Ment = champion.get(d.intValue()).getAttackMent();
            String player2Ment = champion.get(f.intValue()).getAttackMent();


            System.out.println(firstround + "라운드 대결은 "+player1Name+"과 "+player2Name+"입니다.");
            System.out.println(player1Ment);
            System.out.println(player2Ment);


            //System.out.println(player1+"이 공격력 "+damege+"로 공격");
            //System.out.println(speech);
        }
    }
}
