/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ecommerce;

import model.Cliente;
import java.sql.Connection;

/**
 *
 * @author Matt
 */
public interface OperacoesInterface {
    public void Criar(Connection con, Cliente c1);
    public void Pedir(Connection con, int numId, int numPedido,int numProduto, int qtd);
    public int verConta(Connection con, String Nome);
    public void Pagar();
}
