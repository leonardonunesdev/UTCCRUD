/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utc.crudutc.controller;

import com.utc.crudutc.dao.VehicleDao;
import com.utc.crudutc.model.Vehicle;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author leona
 */
@WebServlet(name = "Veiculos", urlPatterns = {"/VehicleController"})
public class VehicleController extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/vehicle.jsp";
    private static String LIST_VEHICLE = "/listVehicle.jsp";
    private VehicleDao dao;
    
    public VehicleController(){
        super();
        dao = new VehicleDao();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int idVeiculo = Integer.parseInt(request.getParameter("id_veiculo"));
            dao.deleteVehicle(idVeiculo);
            forward = LIST_VEHICLE;
            request.setAttribute("vehicles", dao.getAllVehicles());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int idVeiculo = Integer.parseInt(request.getParameter("id_veiculo"));
            Vehicle vehicle = dao.getVehicleById(idVeiculo);
            request.setAttribute("vehicle", vehicle);
        } else if (action.equalsIgnoreCase("listVehicle")){
            forward = LIST_VEHICLE;
            request.setAttribute("vehicles", dao.getAllVehicles());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Vehicle vehicle = new Vehicle();
        
        vehicle.setDescPlaca(request.getParameter("desc_placa"));
        vehicle.setDescRenavam(request.getParameter("desc_renavam"));
        vehicle.setDescProprietario(request.getParameter("desc_proprietario"));
        vehicle.setDescCondutor(request.getParameter("desc_condutor"));
        vehicle.setDescVeiculo(request.getParameter("desc_veiculo"));
        vehicle.setAnoFabricacao(Integer.parseInt(request.getParameter("ano_fabricacao")));
        vehicle.setQtdKmAtual(Integer.parseInt(request.getParameter("qtd_kmatual")));
        vehicle.setDescChassi(request.getParameter("desc_chassi"));
        vehicle.setFlagSituacao(request.getParameter("flag_situacao"));
        vehicle.setQtdLugares(Integer.parseInt(request.getParameter("qtd_lugares")));
        
        String idVeiculo = request.getParameter("id_veiculo");
        if(idVeiculo == null || idVeiculo.isEmpty())
        {
            dao.addVehicle(vehicle);
        }
        else
        {
            vehicle.setIdVeiculo(Integer.parseInt(idVeiculo));
            dao.updateVehicle(vehicle);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_VEHICLE);
        request.setAttribute("vehicles", dao.getAllVehicles());
        view.forward(request, response);
    }
}
