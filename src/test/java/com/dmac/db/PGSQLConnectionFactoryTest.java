package com.dmac.db;

public class PGSQLConnectionFactoryTest {

	public static void main(String args[]) {
		PGSQLConnectionFactory factory = PGSQLConnectionFactory.getInstance();
		factory.connect();
	}
}
