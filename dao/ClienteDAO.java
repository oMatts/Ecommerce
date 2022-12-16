/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Cliente;

/**
 *
 * @author matt
 */
public class ClienteDAO {
    private final Connection con;

    public ClienteDAO(Connection con) {
        this.con = con;
    }
    
    public void insert(Cliente c) throws SQLException{
        String sql = "insert into Cliente(nome, email, salario, id) values(?,?,?,?);";
   

        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, c.getNome());
        stm.setString(2, c.getEmail());
        stm.setInt(3, c.getSalario());
        stm.setInt(4, c.getId());
        stm.execute();
        con.close();
            
    
    }
}
