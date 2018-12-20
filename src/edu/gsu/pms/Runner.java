package edu.gsu.pms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Runner {

	public static void main(String[] args) {
		final String URL = "jdbc:mysql://localhost/dictionary" +
						   "?verifyServerCertificate=false"+
			               "&useSSL=false"+
			               "&requireSSL=false"+
			               "&useLegacyDatetimeCode=false"+
			               "&amp"+
			               "&serverTimezone=UTC";
		
		final String USER = "root";
		final String PASSWORD = "פגüרע";
		
		final String SEPARATOR = " ";
		
		final int ENG_WORD_INDEX = 1;
		final int RUS_WORD_INDEX = 2; 
		final String SELECT_TRANSLATION = "SELECT *\r\n" + 
										  "FROM dictionary\r\n" + 
										  "WHERE engWord LIKE ? OR rusWord LIKE ?";
		
		List<String> words = new ArrayList<String>();
		
		try(BufferedReader in = new BufferedReader(new InputStreamReader(System.in))){
			System.out.println("Enter the words you need to translate space separated");
			String[] inputWords = in.readLine().split(SEPARATOR);
			for (String word : inputWords) {
				words.add(word);
			}
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try(Connection con = DriverManager.getConnection(URL, USER, PASSWORD); 
				PreparedStatement statement = con.prepareStatement(SELECT_TRANSLATION)){
			for (String word : words) {
				statement.setString(ENG_WORD_INDEX, word);
				statement.setString(RUS_WORD_INDEX, word);
				
				try(ResultSet rs = statement.executeQuery()){
					while(rs.next()) {
						String rusWord = rs.getString(RUS_WORD_INDEX);
						String engWord = rs.getString(ENG_WORD_INDEX);
						
						String translation = (word.equals(rusWord)) ? engWord : rusWord;
						
						System.out.println(word + " -> " + translation);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
