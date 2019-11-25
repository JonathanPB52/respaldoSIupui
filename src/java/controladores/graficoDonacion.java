/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Donacion;
import facades.DonacionFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author Jonathan
 */
@Named(value = "graficoDonacion")
@ViewScoped
public class graficoDonacion implements Serializable {

    /**
     * Creates a new instance of graficoDonacion
     */
    @EJB
    private DonacionFacade donacionFacade;

    private List<Donacion> listado;

    private BarChartModel barra;

    public graficoDonacion() {
    }

    public void listar() {
        listado = donacionFacade.listar();
        graficar();
    }

    public void graficar() {
        barra = new BarChartModel();
        List<Donacion> lista = donacionFacade.listar();
        int especie = 0;
        int monetaria = 0;
        for (Donacion donacion : lista) {
            if (donacion.getTipoDonacion().getId() == 1) {
                especie++;
            }
            if (donacion.getTipoDonacion().getId() == 2) {
                monetaria++;
            }
        }

        ChartSeries serie = new BarChartSeries();
        serie.setLabel("Monetaria");
        serie.set("Monetaria", monetaria);
        
        ChartSeries serie1 = new BarChartSeries();
        serie1.setLabel("Especie");
        serie1.set("Especie", especie);
        
        
        barra.addSeries(serie);
        barra.addSeries(serie1);
        
        barra.setTitle("Donaciones registradas");
        barra.setLegendPosition("ne");
        barra.setAnimate(true);

        Axis xAxis = barra.getAxis(AxisType.X);
        xAxis.setLabel("Tipo de donacion");
        Axis yAxis = barra.getAxis(AxisType.Y);
        yAxis.setLabel("Cantidad donada");
        yAxis.setMin(0);
        yAxis.setMax(30);

    }

    public List<Donacion> getListado() {
        return listado;
    }

    public void setListado(List<Donacion> listado) {
        this.listado = listado;
    }

    public BarChartModel getBarra() {
        return barra;
    }

    public void setBarra(BarChartModel barra) {
        this.barra = barra;
    }

}
