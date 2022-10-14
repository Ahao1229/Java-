package com.study.logback.d4_collection_test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 大小王："🤡" "🃏"
 * 点数分别要组合4种花色，大小王各一张。
 * 斗地主：发出51张牌，剩下3张作为底牌。
 *
 *
 * 功能：
 *      1.做牌。
 *      2.洗牌。
 *      3.定义3个玩家
 *      4.发牌
 *      5.排序（拓展，了解，作业）
 *      6.看牌
 */
public class GameDemo {
    /**
     *  1、定义一个静态的集合存储54张牌对象
     *
     */
    public static List<Card> allCards = new ArrayList<>();

    /**
     *  2、做牌：定义静态集合存储54张牌
     */
    static {
        // 3、定义点数、花色：个数确定，类型确定，使用数组
        String[] sizes = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        String[] colors = {"♠","♥","♦","♣"};
        // 4、组合点数和花色
        int index = 0 ; // 记录牌的大小
        for (String size : sizes) {
            index++;
            for (String color : colors) {
                // 5、封装成一个牌对象
                Card c = new Card(size, color, index);
                // 6、存入到集合容器中去
                allCards.add(c);
            }
        }
        // 7、 大小王存入集合对象
        Card c1 = new Card("", "🃏",++index);
        Card c2 = new Card("", "🤡",++index);
        Collections.addAll(allCards , c1 ,c2);
        System.out.println("新牌：" + allCards);
    }
    public static void main(String[] args) {
        // 8、洗牌
        Collections.shuffle(allCards);
        System.out.println("洗牌后:" + allCards);

        // 9、发牌（定义三个玩家，每个玩家的牌也是一个集合容器）
        List<Card> lhc = new ArrayList<>();
        List<Card> jmz = new ArrayList<>();
        List<Card> ryy = new ArrayList<>();

        // 10、开始发牌（从牌集合中发出51张牌给三个玩家，剩余3张作为底牌）
        for (int i = 0; i < allCards.size() - 3; i++) {
            // 先拿到当前牌对象
            Card c = allCards.get(i);
            if (i % 3 == 0){
                // 阿冲接牌
                lhc.add(c);
            }else if (i % 3 == 1){
                // 阿鸠接牌
                jmz.add(c);
            }else if(i % 3 == 2){
                // 莹莹接牌
                ryy.add(c);
            }
        }

        // 11、拿到最后三张牌(最后三张牌截取成一个子集合)
        List<Card> lastThreeCards = allCards.subList(allCards.size() -3 , allCards.size()); // subList是用来一个分离子集合的

        // 12、给玩家的牌排序（从小到大）
        sortCards(lhc);
        sortCards(jmz);
        sortCards(ryy);
        // 13、输出玩家的牌：
        System.out.println("阿冲：" + lhc);
        System.out.println("阿鸠：" + jmz);
        System.out.println("莹莹：" + ryy);
        System.out.println("三张底牌：" + lastThreeCards);

    }

    /**
     * 给牌排序
     * @param cards
     */
    private static void sortCards(List<Card> cards) {
        Collections.sort(cards, new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                return o1.getIndex() - o2.getIndex();
            }
        });
    }
}
