package org.kosta.madfortaste.help.dao;

import org.hamcrest.generator.qdox.parser.structs.PackageDef;
import org.kosta.madfortaste.common.lib.Page;

public class TestPage {
	public static void main(String[] args) {
		Page page = new Page(1354);
		System.out.println(page.preview());
		System.out.println(page);
		
	}
}
