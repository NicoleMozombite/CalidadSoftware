/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelo.Productos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 *
 * @author HP
 */
public class ControladorHistorial extends ColeccionHistorial{
    protected String nombre;
    public ControladorHistorial(String Nombre){
        this.nombre = Nombre;
        Lee();
    }
    public void grabar(){
        try{
            FileWriter fw = new FileWriter(nombre);
            PrintWriter pw = new PrintWriter(fw);
            for(Productos p:historial){
                pw.print("*"+p.getTipoMovimento()+"*"+p.getCodigoProd()+"*"+p.getTipoProducto()+"*"+p.getNomProducto()+"*"+p.getAnioMov()+"*"+p.getMesMov()+"*"+p.getDiaMov()+"*"+p.getFechaVencimiento()+"*"+p.getProveedor()+"*"+p.getUnidad()+"*"+p.getNroLote()+"*"+p.getPrecio()+"*"+p.getCant()+"*"+p.getStock());
            }pw.close();
            
        }catch(Exception e){}
    }
    
    public void Lee(){
        try{
            FileReader fr = new FileReader(nombre);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            while(linea !=null){
                StringTokenizer st = new StringTokenizer(linea,"*");
                String TipoMovimiento = st.nextToken();
                String CodigoProducto = st.nextToken();
                int TipoProducto = Integer.parseInt(st.nextToken());
                String NombreProducto = st.nextToken();
                int anioMov = Integer.parseInt(st.nextToken());
                int mesMov = Integer.parseInt(st.nextToken());
                int diaMov = Integer.parseInt(st.nextToken());
                String fechaVencimiento = st.nextToken();
                String unidad = st.nextToken();
                int nroLote = Integer.parseInt(st.nextToken());
                double precio = Double.parseDouble(st.nextToken());
                double cant = Double.parseDouble(st.nextToken());
                double Stock = Double.parseDouble(st.nextToken());
                Productos p = new Productos(TipoMovimiento, CodigoProducto, TipoProducto, NombreProducto, anioMov, mesMov, diaMov, fechaVencimiento, unidad, unidad, nroLote, precio, cant, Stock);
                agrega(p);
            }linea = br.readLine();
            br.close();
        }catch(Exception e){
            
        }
    }
    
}
