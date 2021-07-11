/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.daobarang;
import DAO.implementbarang;
import java.util.List;
import javax.swing.JOptionPane;
import model.modelbarang;
import model.modtblbarang;
import view.formbarang;

/**
 *
 * @author titis ikhwani
 */
public class controllerbarang {
    formbarang frame;
    implementbarang implbarang;
    List<modelbarang> lmb;

    public controllerbarang(formbarang frame) {
        this.frame = frame;
        implbarang = new daobarang();
        lmb = implbarang.getAll();
    }


    public void reset(){
        frame.getTf_no().setText("");
        frame.getTf_nama().setText("");
        frame.getTf_harga().setText("");
        frame.getTf_stok().setText("");
    }
    public void isitabel(){
        lmb = implbarang.getAll();
        modtblbarang mtb = new modtblbarang(lmb);
        frame.getTbl_barang().setModel(mtb);
    }
    
    public void isifield(int row){
        frame.getTf_no().setText(String.valueOf(lmb.get(row).getNo()));
        frame.getTf_nama().setText(lmb.get(row).getNama()) ;
        frame.getTf_harga().setText(String.valueOf(lmb.get(row).getHarga()));
        frame.getTf_stok().setText(String.valueOf(lmb.get(row).getStok()));
    }
    
    public void insert(){
        if(!frame.getTf_nama().getText().trim().isEmpty() & !frame.getTf_nama().getText().trim().isEmpty()){
            modelbarang mb = new modelbarang();
            
            mb.setNo(Integer.valueOf(frame.getTf_no().getText()));
            mb.setNama(frame.getTf_nama().getText());
            mb.setHarga(Double.valueOf(frame.getTf_harga().getText()));
            mb.setStok(Integer.valueOf(frame.getTf_stok().getText()));
            
            implbarang.insert(mb);
            JOptionPane.showMessageDialog(null, "data disimpan");
        }else{
            JOptionPane.showMessageDialog(null, "Data gagal disimpan");
        }
    }
    
    public void delete(){
        if(!frame.getTf_no().getText().trim().isEmpty()){
            int no = Integer.parseInt(frame.getTf_no().getText());
            implbarang.delete(no);
            JOptionPane.showMessageDialog(null, "data dihapus");
        }else{
            JOptionPane.showMessageDialog(null, "Data gagal dihapus");
        }
    }
    
    public void update(){
        if(!frame.getTf_no().getText().trim().isEmpty()){
            
            modelbarang mb = new modelbarang();
            
            mb.setNama(frame.getTf_nama().getText());
            mb.setHarga(Double.valueOf(frame.getTf_harga().getText()));
            mb.setStok(Integer.valueOf(frame.getTf_stok().getText()));
            mb.setNo(Integer.valueOf(frame.getTf_no().getText()));
            
            implbarang.update(mb);
            JOptionPane.showMessageDialog(null, "Data diperbarui");
        }
        else{
            JOptionPane.showMessageDialog(null, "Data gagal diperbarui");
        }
    }
    
    public void isiTableCariNama(){
        lmb = implbarang.getCariNama(frame.getTf_cari().getText());
        
        modtblbarang mtb = new modtblbarang(lmb);
        frame.getTbl_barang().setModel(mtb);
    }
    
    public void cariNama(){
        if(!frame.getTf_cari().getText().trim().isEmpty()){
            implbarang.getCariNama(frame.getTf_cari().getText());
            isiTableCariNama();
        }
        else{
            JOptionPane.showMessageDialog(null, "Silahkan masukan nama");
        }
    }
}
