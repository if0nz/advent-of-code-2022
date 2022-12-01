package it.ifonz.puzzles.optimized;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;

import it.ifonz.puzzles.Day01;

public class Opt01 extends Day01 implements Opt {

	public static void main(String[] args) throws IOException {
		(new Opt01()).combo();
	}
	
	public void combo() throws IOException {
		super.init();
		var temp = 0;
		var max1 = 0;
		var max2 = 0;
		var max3 = 0;
		for (var r : rows) {
			if (StringUtils.isNotBlank(r)) {
				temp += Integer.parseInt(r);
			} else {
				if (temp > max1) {
					max3 = max2;
					max2 = max1;
					max1 = temp;
				} else if (temp > max2) {
					max3 = max2;
					max2 = temp;
				} else if (temp > max3) {
					max3 = temp;
				}
				temp = 0;
			}
		}
		System.out.println(max1);
		System.out.println(max1+max2+max3);
	}
}
