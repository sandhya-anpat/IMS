package com.career.mentor.generator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class MentorGenerator implements IdentifierGenerator {
	
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		final String prefix = "CIMN";
		final String query = "select count(id) from mentor";
		Connection connection = session.connection(); //????
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt(1);
				String generatedId = prefix + String.format("%02d", id + 1);
				System.out.println("NEW ID: " + generatedId);
				return generatedId;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
