package com.yuhao.other.auto;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class StartProgram {
	public StartProgram(String fileName) throws IOException{
		Desktop.getDesktop().open(new File(fileName));
	}
}
