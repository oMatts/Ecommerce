/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ecommerce;

import model.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Matt
 */
public class Operacoes implements OperacoesInterface{
    @Override
    public void Criar(Connection con, Cliente c){
   
    String sql = "insert into Cliente(nome, email, salario, id) values(?,?,?,?);";
   
    try {
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, c.getNome());
        stm.setString(2, c.getEmail());
        stm.setInt(3, c.getSalario());
        stm.setInt(4, c.getId());
        stm.executeUpdate();
    } catch (Exception e) {}
    }
    
    @Override
    public void Pedir(Connection con, int numId, int numPedido,int numProduto, int qtd) {
        String sql = "insert into Pedido(dataPedido, idCliente)" +
        "values(now(), ?);";
        try {
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setInt(1, numId);
        stm.executeUpdate();
        //System.out.print(stm.getResultSet().getString("preco"));
        
        }catch (Exception e) {}
        
        String sql1 = "insert into pedido_produto(idPedido, idProduto, quantidade) values(?, ?, ?);";
        try {
        PreparedStatement stm1 = con.prepareStatement(sql1);
        stm1.setInt(1, numPedido);
        stm1.setInt(2, numProduto);
        stm1.setInt(3, qtd);
        stm1.executeUpdate();
        //System.out.print(stm.getResultSet().getString("preco"));
        
        }catch (Exception e) {}
        
        
    }

    @Override
    public int verConta(Connection con, String Nome) {
        String sql = "SELECT c.nome, sum(p.preco * pp.quantidade) as Total from cliente c" +
        "join pedido pd on c.id = pd.idCliente" +
        "join pedido_produto pp on pd.id = pp.idPedido" +
        "join produto p on pp.idProduto = p.id" +
        "where c.nome = ?";
        
        int total = 0;
        
        try{
        PreparedStatement stm = createdPreparedStatement(con, sql, Nome);
        ResultSet rs = stm.executeQuery();
            while (rs.next()){
                System.out.println("Total Gasto: " + rs.getInt("Total"));
                total = rs.getInt("Total");
                return total;
            }
        
        }catch (SQLException e){}
        return 0;
        
    } 
    
    private static PreparedStatement createdPreparedStatement(Connection con, String sql, String Nome) throws SQLException{
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, Nome);
        
        return stm;
    }

    @Override
    public void Pagar() {
        
    }
}
