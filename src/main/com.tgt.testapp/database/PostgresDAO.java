package com.tgt.testapp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgresDAO {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/postgres";
        String userName = "postgres";
        String password = "Sadhguru";

        String insertionQuery1 = "INSERT INTO public.user_cred_table\n" +
                "(account_id, user_name, user_pd, create_timestamp)\n" +
                "VALUES(11111, 'user1', 'One', CURRENT_TIMESTAMP);";
        String insertionQuery2 = "INSERT INTO public.user_cred_table\n" +
                "(account_id, user_name, user_pd, create_timestamp)\n" +
                "VALUES(22222, 'user2', 'Two', CURRENT_TIMESTAMP);";
        String deletionQuery = "DELETE FROM user_cred_table WHERE user_name = 'user2'";
        String updateQuery1 = "UPDATE user_cred_table SET user_name = 'Neha' WHERE account_id = 11111";
        String updateQuery2 = "UPDATE user_cred_table SET user_name = 'Yag' WHERE account_id = 22222";
        String displayQuery = "SELECT * FROM user_cred_table";



        try {

            Connection con = DriverManager.getConnection(url, userName, password);
            Statement st = con.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            con.setAutoCommit(false);
            st.addBatch(insertionQuery1);
            st.addBatch(insertionQuery2);
            st.addBatch(updateQuery1);
            st.addBatch(updateQuery2);

            ResultSet rs = st.executeQuery(displayQuery);
            rs.last();

            System.out.println("rows before batch execution= "+ rs.getRow());
            st.executeBatch();
            con.commit();

            System.out.println("Batch executed");
            rs = st.executeQuery(displayQuery);
            rs.last();

            System.out.println("rows after batch execution = "+ rs.getRow());

            ResultSet rs1 = st.executeQuery(displayQuery);
            while (rs1.next()) {
                System.out.println(rs1.getString(1));
                System.out.println(rs1.getString(2));
                System.out.println(rs1.getString(3));
                System.out.println(rs1.getString(4));

            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

