/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.SQLException;

/**
 *
 * @author titis ikhwani
 */
public class koneksiDB {
    static Connection con;
    
    public static Connection connection(){
        if(con == null){
            MysqlDataSource data = new MysqlDataSource();
            data.setPort(3306);
            data.setDatabaseName("barang");
            data.setUser("root");
            data.setPassword("");
            
            try{
                con = (Connection) data.getConnection();
            } catch (SQLException ex){
//                Logger.getLogger(koneksiDB.class.getName()).log(level.SERVERE, null, ex);
                ex.printStackTrace();
            }
        }  
        return con;
    }
}
