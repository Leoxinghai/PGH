package com.pgh.mahjong;

import java.util.Hashtable;
import java.util.Vector;

public class MJCards {
	public static String strCards[] = { "1wan","2wan","3wan","4wan","5wan","6wan","7wan","8wan","9wan", 
									"1tiao","2tiao","3tiao","4tiao","5tiao","6tiao","7tiao","8tiao","9tiao",
									"1tong","2tong","3tong","4tong","5tong","6tong","7tong","8tong","9tong",
									"dong","nan","xi","bei","zhong","fa","ban",
									"chun","xia","qiu","dong","mei","lai","zhu","ju"};
	
	private static Hashtable cards;
	private static Vector cardsSeq;
	private static int fabaiCount;
	private static MJCards inst = null;
	
	public static MJCards getInstance() {
		if(inst == null) {
			inst = new MJCards();
		}
		return inst;
	}
	
	public void init() {
		cards = new Hashtable();
		cardsSeq = new Vector();
		int totalCards = strCards.length;
		for(int i=0; i< totalCards-8;i++) {
			CardType ct = new CardType();
			ct.count = 4;
			ct.id = i;
			ct.name = strCards[i];
			cards.put(ct.name, ct);
		}
		for(int i=totalCards-8; i< totalCards;i++) {
			CardType ct = new CardType();
			ct.count = 1;
			ct.id = i;
			ct.name = strCards[i];
			cards.put(ct.name, ct);
		}
		for(int i =0; i< totalCards * 4 - 8 * 3;i++) {
			cardsSeq.add(i);
		}
		fabaiCount = totalCards * 4 - 8 * 3; 
	}
	
	public CardType fabai() {
		if(fabaiCount == 0) {
			return null;
		}
		int fseq = (int)(Math.random() * fabaiCount);
		int icard = ((Integer)cardsSeq.get(fseq)).intValue();
		cardsSeq.remove(fseq);
		fabaiCount--;
		icard = icard / 4;
		return (CardType)cards.get(strCards[icard]);
	}

	public boolean isCompleted() {
		return (fabaiCount == 0);
	}
	
	public int leftBai() {
		return fabaiCount;
	}
	
	public MJCards() {
		
	}
	
}
