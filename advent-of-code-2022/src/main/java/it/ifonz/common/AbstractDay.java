package it.ifonz.common;

import java.io.IOException;

public abstract class AbstractDay {

	public abstract void part1();
	public abstract void part2();
	public abstract void init() throws IOException;
	
	public void run() throws IOException {
		init();
		part1();
		part2();
	}
}
