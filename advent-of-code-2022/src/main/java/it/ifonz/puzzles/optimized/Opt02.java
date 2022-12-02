package it.ifonz.puzzles.optimized;

import java.io.IOException;
import java.util.HashMap;

import it.ifonz.puzzles.Day02;

public class Opt02 extends Day02 implements Opt {

	public static void main(String[] args) throws IOException {
		(new Opt02()).combo();
	}

	public void combo() throws IOException {
		super.init();
		var d = new HashMap<Character, Integer>();
		d.put('A', 0); // rock
		d.put('X', 0); // rock p1, lose p2
		d.put('B', 1); // paper
		d.put('Y', 1); // paper p1, draw p2
		d.put('C', 2); // scissor
		d.put('Z', 2); // scissor p1, win p2
		System.out.println(rows.stream().mapToInt(r -> {
			var mine = d.get(r.charAt(2));
			var theirs = d.get(r.charAt(0));
			return 1 + mine + 3 * (1 + (Math.floorMod(mine - theirs, 3))) % 9; // 3 - 6 - 0
		}).sum());

		System.out.println(rows.stream().mapToInt(r -> {
			var mine = d.get(r.charAt(2));
			var theirs = d.get(r.charAt(0));
			return 1 + switch (mine) { //+1 to normalize score from 012 to 123
			case 0 -> (theirs + 2) % 3; // 02 10 21 
			case 1 -> theirs + 3; // 3 for draw
			default -> (theirs + 1) % 3 + 6;
			};
		}).sum());
	}
}
