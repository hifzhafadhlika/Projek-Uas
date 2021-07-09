/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.modelbarang;

/**
 *
 * @author titis ikhwani
 */
public interface implementbarang {
    public void insert(modelbarang mb);
    public void delete(int no);
    public void update(modelbarang mb);
    public List<modelbarang> getAll();
    public List<modelbarang> getCariNama(String nama);
}
