/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author titis ikhwani
 */
public class modtblbarang extends AbstractTableModel {
    
    List<modelbarang> lmb;

    public modtblbarang(List<modelbarang> lmb) {
        this.lmb = lmb;
    }
    

    @Override
    public int getRowCount() {
        return lmb.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int row, int column) {
    
        switch(column){
            case 0:
                return lmb.get(row).getNo();
            case 1:
                return lmb.get(row).getNama();
            case 2:
                return lmb.get(row).getHarga();
            case 3:
                return lmb.get(row).getStok();
            default:
                return null;
        }
    
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return "no";
            case 1:
                return "nama";
            case 2:
                return "harga";
            case 3:
                return "stok";
            default:
                return null;
        }
  }
}
