/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import koneksi.koneksiDB;
import model.modelbarang;

/**
 *
 * @author titis ikhwani
 */
public class daobarang implements implementbarang  {

    Connection connection;
    final String insert = "INSERT INTO barang (no,nama,harga,stok) VALUES (?, ?, ?, ?)";
    final String delete = "DELETE FROM barang WHERE no=?";
    final String update = "UPDATE barang set no=?, nama=?, harga=?, stok=?,";
    final String select = "SELECT * FROM barang";
    final String cariNama = "SELECT * FROM barang WHERE nama like ?";

    public daobarang() {
        connection = koneksiDB.connection();
    }
    
    
    
    @Override
    public void insert(modelbarang mb) {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, mb.getNama());
            statement.setDouble(2, mb.getHarga());
            statement.setInt(3, mb.getStok());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()){
                mb.setNo(rs.getInt(1));
            }
            
        } catch (SQLException ex) {
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
            }
        }
    }

    @Override
    public void delete(int no) {
        
         PreparedStatement statement = null;
         
        try {
            statement = connection.prepareStatement(delete);
            
            statement.setInt(1, no);
            statement.executeUpdate();
           
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        
    }
    
    @Override
    public void update(modelbarang mb) {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, mb.getNama());
            statement.setDouble(2, mb.getHarga());
            statement.setInt(3, mb.getStok());
            statement.setInt(4, mb.getNo());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<modelbarang> getAll() {
        List<modelbarang> lmb = null;
        
        try {
            lmb = new ArrayList<modelbarang>();
            Statement st = connection.createStatement();
            
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                modelbarang mb = new modelbarang();
                mb.setNo(rs.getInt("no"));
                mb.setNama(rs.getString("nama"));
                mb.setHarga(rs.getDouble("harga"));
                mb.setStok(rs.getInt("stok"));
                lmb.add(mb);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lmb;
    }

    @Override
    public List<modelbarang> getCariNama(String nama) {
        List<modelbarang> lmb = null;
        try{
            lmb = new ArrayList<modelbarang>();
            
            PreparedStatement st = connection.prepareStatement(cariNama);
            st.setString(1, nama );
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                modelbarang mb = new modelbarang();
                mb.setNo(rs.getInt("no"));
                mb.setNama(rs.getString("nama"));
                mb.setHarga(rs.getDouble("harga"));
                mb.setStok(rs.getInt("stok"));
                lmb.add(mb);
            }
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return lmb;
    }
    
}
