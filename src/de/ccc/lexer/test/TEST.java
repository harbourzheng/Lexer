package de.ccc.lexer.test;

import de.ccc.lexer.dao.LexerDataOperation;
import de.ccc.lexer.model.Form;

public class TEST {

	public static void main(String[] args) {
		Form  form = LexerDataOperation.getById("1");
		if(form != null)
		{
			System.out.println(form.getContent());
		}
	}

}
