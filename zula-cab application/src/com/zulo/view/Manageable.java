package com.zulo.view;

import java.util.Scanner;

public interface Manageable {
	Scanner inp = new Scanner(System.in);

	void init();
	void showInstruction();
	void process(String choice);
}
