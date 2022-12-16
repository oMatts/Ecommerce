/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mycompany.ecommerce.Operacoes;
import model.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Matt
 */
public class Conexao {
    public Connection getConnection() throws SQLException, ClassNotFoundException{
            Connection conn = null;
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conn = DriverManager.getConnection
                        ("jdbc:mysql://127.0.0.1:3306/ecommerce", "root", "root");
            
            return conn;
        }
     public static void main(String[] args) throws SQLException  {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            con = DriverManager.getConnection
                        ("jdbc:mysql://127.0.0.1:3306/ecommerce", "root", "root");
            
            Cliente c1 = new Cliente("Rauan", "rauanzinhobt@gmail.com",20000, 1);
            Operacoes op1 = new Operacoes();
            op1.Criar(con,c1);
            op1.Pedir(con, 1, 1, 1, 3);
            
            System.out.println(op1.verConta(con, "Rauan"));
            
            ResultSet rsCliente = con.createStatement().executeQuery("select * from cliente");
            while (rsCliente.next()){System.out.println("Nome: " + rsCliente.getString("nome"));}
            

        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao acessar o banco: " + ex.getMessage());
        } catch (ClassNotFoundException ex){
            System.out.println("Classe do banco de dados não encontrada");
        } finally{
            if(con!=null)
               con.close();
        }        
    }
}
