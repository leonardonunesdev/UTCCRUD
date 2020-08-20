/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utc.crudutc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.utc.crudutc.model.Vehicle;
import com.utc.crudutc.db.DbUtil;

/**
 *
 * @author leona
 */
public class VehicleDao {
    private Connection connection;
    
    public VehicleDao(){
        connection = DbUtil.getConnection();
    }
    
    public void addVehicle(Vehicle vehicle){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO public.frota_veiculo(\n" +
                    "desc_placa, desc_renavam, desc_proprietario, desc_condutor, desc_veiculo, ano_fabricacao, qtd_kmatual, desc_chassi, flag_situacao, qtd_lugares)\n" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            
            preparedStatement.setString(1, vehicle.getDescPlaca());
            preparedStatement.setString(2, vehicle.getDescRenavam());
            preparedStatement.setString(3, vehicle.getDescProprietario());
            preparedStatement.setString(4, vehicle.getDescCondutor());
            preparedStatement.setString(5, vehicle.getDescVeiculo());
            preparedStatement.setInt(6, vehicle.getAnoFabricacao());
            preparedStatement.setInt(7, vehicle.getQtdKmAtual());
            preparedStatement.setString(8, vehicle.getDescChassi());
            preparedStatement.setString(9, vehicle.getFlagSituacao());
            preparedStatement.setInt(10, vehicle.getQtdLugares());
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteVehicle(int vehicleId){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM public.frota_veiculo\n" +
                "WHERE id_veiculo = ?;");
            
            preparedStatement.setInt(1, vehicleId);
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateVehicle(Vehicle vehicle){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE public.frota_veiculo\n" +
                "SET desc_placa=?, desc_renavam=?, desc_proprietario=?, desc_condutor=?, desc_veiculo=?, ano_fabricacao=?, qtd_kmatual=?, desc_chassi=?, flag_situacao=?, qtd_lugares=?\n" +
                "WHERE id_veiculo=?;");
            
            preparedStatement.setString(1, vehicle.getDescPlaca());
            preparedStatement.setString(2, vehicle.getDescRenavam());
            preparedStatement.setString(3, vehicle.getDescProprietario());
            preparedStatement.setString(4, vehicle.getDescCondutor());
            preparedStatement.setString(5, vehicle.getDescVeiculo());
            preparedStatement.setInt(6, vehicle.getAnoFabricacao());
            preparedStatement.setInt(7, vehicle.getQtdKmAtual());
            preparedStatement.setString(8, vehicle.getDescChassi());
            preparedStatement.setString(9, vehicle.getFlagSituacao());
            preparedStatement.setInt(10, vehicle.getQtdLugares());
            preparedStatement.setInt(11, vehicle.getIdVeiculo());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Vehicle> getAllVehicles(){
        List<Vehicle> vehicles = new ArrayList<Vehicle>();
        
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM public.frota_veiculo;");
            System.out.println("Tamanho: " + rs.toString());
            while(rs.next()){
                Vehicle vehicle = new Vehicle();
                vehicle.setIdVeiculo(rs.getInt("id_veiculo"));
                vehicle.setDescPlaca(rs.getString("desc_placa"));
                vehicle.setDescRenavam(rs.getString("desc_renavam"));
                vehicle.setDescProprietario(rs.getString("desc_proprietario"));
                vehicle.setDescCondutor(rs.getString("desc_condutor"));
                vehicle.setDescVeiculo(rs.getString("desc_veiculo"));
                vehicle.setAnoFabricacao(rs.getInt("ano_fabricacao"));
                vehicle.setQtdKmAtual(rs.getInt("qtd_kmatual"));
                vehicle.setDescChassi(rs.getString("desc_chassi"));
                vehicle.setFlagSituacao(rs.getString("flag_situacao"));
                vehicle.setQtdLugares(rs.getInt("qtd_lugares"));
                
                vehicles.add(vehicle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return vehicles;
    }
    
    public Vehicle getVehicleById(int vehicleId){
        Vehicle vehicle = new Vehicle();
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM public.frota_veiculo WHERE id_veiculo=?;");
            preparedStatement.setInt(1, vehicleId);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            if(rs.next()){
                vehicle.setIdVeiculo(rs.getInt("id_veiculo"));
                vehicle.setDescPlaca(rs.getString("desc_placa"));
                vehicle.setDescRenavam(rs.getString("desc_renavam"));
                vehicle.setDescProprietario(rs.getString("desc_proprietario"));
                vehicle.setDescCondutor(rs.getString("desc_condutor"));
                vehicle.setDescVeiculo(rs.getString("desc_veiculo"));
                vehicle.setAnoFabricacao(rs.getInt("ano_fabricacao"));
                vehicle.setQtdKmAtual(rs.getInt("qtd_kmatual"));
                vehicle.setDescChassi(rs.getString("desc_chassi"));
                vehicle.setFlagSituacao(rs.getString("flag_situacao"));
                vehicle.setQtdLugares(rs.getInt("qtd_lugares"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return vehicle;
    }
}
