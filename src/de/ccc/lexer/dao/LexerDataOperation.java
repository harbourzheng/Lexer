package de.ccc.lexer.dao;

import java.util.ArrayList;
import java.util.List;

import de.ccc.lexer.model.Form;

public class LexerDataOperation {
	public static JDBCService js = new JDBCService();
	public static List<Form> getByAddress() {
		List<Form> list = null;
		js.selectService();
		return list;
	}

	public static Form getById(String id) {
		Form form = null;
		return form;
	}

	public static void insertForms(List<Form> list) {
		for (int i = 0; i < list.size(); i++) {
			js.insertService("LEX_FORM", list.get(i));
		}
	}
	public static void insertForms(Form form) {
		js.insertService("LEX_FORM", form);
	}
}
