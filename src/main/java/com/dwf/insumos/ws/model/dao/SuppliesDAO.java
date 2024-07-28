package com.dwf.insumos.ws.model.dao;

import com.dwf.insumos.ws.model.AppConnection;
import com.dwf.insumos.ws.model.Supplies;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SuppliesDAO extends AppConnection {
    /**
     * This method inserts into `supplies` table a new row
     * @param supply The supply object to be inserted
     * @throws SQLException
     */
    public void insert(Supplies supply) throws SQLException {
        connect();
        pstmt = conn.prepareStatement("INSERT INTO insumos (name, quantity, price) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, supply.getName());
        pstmt.setInt(2, supply.getQuantity());
        pstmt.setFloat(3, supply.getPrice());
        pstmt.executeUpdate();

        // This is a bad practice, but it's here to show how to get the last inserted id
        ResultSet keys = pstmt.getGeneratedKeys();

        keys.next();
        supply.setId(keys.getInt(1));

        close();
    }

    /**
     * This method updates a row in `supplies` table
     * @param supply The supply object to be updated
     * @throws SQLException
     */
    public void update(Supplies supply) throws SQLException {
        connect();
        pstmt = conn.prepareStatement("UPDATE insumos SET name = ?, quantity = ?, price = ? WHERE id = ?");
        pstmt.setString(1, supply.getName());
        pstmt.setInt(2, supply.getQuantity());
        pstmt.setFloat(3, supply.getPrice());
        pstmt.setInt(4, supply.getId());
        pstmt.executeUpdate();
        close();
    }

    /**
     * This method deletes a row in `supplies` table
     * @param id The id of the row to be deleted
     * @throws SQLException
     */
    public void delete(int id) throws SQLException {
        connect();
        pstmt = conn.prepareStatement("DELETE FROM insumos WHERE id = ?");
        pstmt.setInt(1, id);
        pstmt.execute();
        close();
    }

    /**
     * This method retrieves all rows from `supplies` table
     * @return An array of supply objects retrieved
     * @throws SQLException
     */
    public ArrayList<Supplies> findAll() throws SQLException {
        connect();
        stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT * FROM insumos");
        ArrayList<Supplies> supplies = new ArrayList<>();

        while (rs.next()) {
            Supplies supply = new Supplies();
            supply.setId(rs.getInt("id"));
            supply.setName(rs.getString("name"));
            supply.setQuantity(rs.getInt("quantity"));
            supply.setPrice(rs.getFloat("price"));
            supplies.add(supply);
        }

        close();
        return supplies;
    }

    /**
     * This method retrieves a row from `supplies` table
     * @param id The id of the row to be retrieved
     * @return The supply object retrieved
     * @throws SQLException
     */
    public Supplies findById(int id) throws SQLException {
        connect();
        pstmt = conn.prepareStatement("SELECT * FROM insumos WHERE id = ?");
        pstmt.setInt(1, id);
        rs = pstmt.executeQuery();
        Supplies supply = new Supplies();
        if (rs.next()) {
            supply.setId(rs.getInt("id"));
            supply.setName(rs.getString("name"));
            supply.setQuantity(rs.getInt("quantity"));
            supply.setPrice(rs.getFloat("price"));
        }
        close();
        return supply;
    }
}
