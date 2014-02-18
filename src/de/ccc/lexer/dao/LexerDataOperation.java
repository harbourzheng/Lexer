package de.ccc.lexer.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import de.ccc.lexer.model.Form;

public class LexerDataOperation {
	public static JDBCService js = new JDBCService();

	public static List<Form> getByAddress(String address) {
		ResultSet rs = js.selectService("LEX_FORM", "ADDRESS", address);
		return convertRstoForm(rs);
	}

	public static Form getById(String id) {
		ResultSet rs = js.selectService("LEX_FORM", "ID", id);
		return convertRstoForm(rs).get(0);
	}

	public static void insertForms(List<Form> list) {
		for (int i = 0; i < list.size(); i++) {
			js.insertService("LEX_FORM", list.get(i));
		}
	}

	public static void insertForms(Form form) {
		js.insertService("LEX_FORM", form);
	}

	private static List<Form> convertRstoForm(ResultSet rs) {
		List<Form> list = null;
		if (rs != null) {
			list = new ArrayList<Form>();
			try {
				while (rs.next()) {
					Form form = new Form();
					form.setId(rs.getInt("id"));
					form.setAddress(rs.getString("address"));
					form.setContent(rs.getString("content"));
					form.setOpdate(rs.getDate("opdate"));
					list.add(form);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				JDBCUtils.free(rs,null,null);
			}
		}
		return list;
	}

}
