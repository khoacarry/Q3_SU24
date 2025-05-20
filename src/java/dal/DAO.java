/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ExecutionItems;
import model.Executions;

/**
 *
 * @author thais
 */
public class DAO extends DBContext {
    
    public List<ExecutionItems> getExecutionItemById(int exeId) {
        List<ExecutionItems> l = new ArrayList<>();
        String sql = "select * from ExecutionItems where ExecutionID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, exeId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ExecutionItems item = new ExecutionItems(
                        rs.getInt("ExecutionItemID"),
                        rs.getInt("ArrayItem"),
                        rs.getInt("ExecutionID"));
                l.add(item);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return l;
    }

    public List<Executions> getExecution() {
        List<Executions> l = new ArrayList<>();
        String sql = "select * from Executions";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                 List<ExecutionItems> ex = getExecutionItemById(rs.getInt("ExecutionID"));
                Executions e = new Executions(
                        rs.getInt("ExecutionID"),
                        rs.getInt("Result"),
                        ex);
                l.add(e);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return l;
    }
    
    public Executions getExecutionById(int id) {
        String sql = "select * from Executions where ExecutionID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                List<ExecutionItems> ex = getExecutionItemById(rs.getInt("ExecutionID"));
                return new Executions(
                        rs.getInt("ExecutionID"),
                        rs.getInt("Result"),
                        ex);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    public boolean delete(int exeId){
        String deleteChild = "delete from ExecutionItems where ExecutionID = ?";
        String deleteParent = "delete from Executions where ExecutionID = ?";
        
        try {
            connection.setAutoCommit(false);
            
            PreparedStatement psChild = connection.prepareStatement(deleteChild);
            psChild.setInt(1, exeId);
            psChild.executeUpdate();
            
            PreparedStatement psParent = connection.prepareStatement(deleteParent);
            psParent.setInt(1, exeId);
            psParent.executeUpdate();
            
            connection.commit();
            return true;
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            return false;
        }finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }
    
    public static void main(String[] args) {
        DAO d = new DAO();
        d.delete(3);
    }
}
