/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Familia-PC
 */
public class Modelo_V {

    private Vista vistaMCD;
    private VentanaInicio vistaInicio;
    private Ecuacion ecuacion;
    ArrayList<Integer> numeros = new ArrayList();

    Scanner s = new Scanner(System.in);
    int n = 0;
    int o = 1;
    int numEcu = 0;
    ArrayList<Ecuacion> Ecuaciones = new ArrayList<>();
    String respuesta = "";
    String residuos = "";
    String combLineal = "";
    String salida = "";
    String reemplazar = "";

    int n1, n2, nCociente, nResiduo;

    public Vista getVistaMCD() {
        if (vistaMCD == null) {
            this.vistaMCD = new Vista(this);
        }
        return vistaMCD;
    }

    public VentanaInicio getVistaInicio() {
        if (vistaInicio == null) {
            this.vistaInicio = new VentanaInicio(this);
        }
        return vistaInicio;
    }

    public void iniciar() {
        getVistaInicio().setVisible(true);
        vistaInicio.setResizable(false);
    }

    public void calcularMCD() {
        int num, c = 0;
        if (!vistaInicio.getTxtN1().getText().isEmpty()) {
            numeros.add(Integer.parseInt(vistaInicio.getTxtN1().getText()));
            num = numeros.get(c);
            c++;
        }
        if (!vistaInicio.getTxtN2().getText().isEmpty()) {
            numeros.add(Integer.parseInt(vistaInicio.getTxtN2().getText()));
            num = numeros.get(c);
            c++;
        }
        if (!vistaInicio.getTxtN3().getText().isEmpty()) {
            numeros.add(Integer.parseInt(vistaInicio.getTxtN3().getText()));
            num = numeros.get(c);
            c++;
        }
        if (!vistaInicio.getTxtN4().getText().isEmpty()) {
            numeros.add(Integer.parseInt(vistaInicio.getTxtN4().getText()));
            num = numeros.get(c);
            c++;
        }

        System.out.println(numeros);

        if (numeros.size() < 2) {
            System.out.println("........");
            numeros.clear();
            JOptionPane.showMessageDialog(null, "Verifique los numeros ingresados",
                    null, JOptionPane.WARNING_MESSAGE);
        } else {
            Comparator<Integer> comparador = Collections.reverseOrder();
            Collections.sort(numeros, comparador);

            vistaInicio.setVisible(false);
            getVistaMCD().setVisible(true);
            vistaMCD.setResizable(false);

            n1 = numeros.get(0);
            n2 = numeros.get(1);
            nCociente = n1 / n2;
            nResiduo = n1 % n2;

            if (nResiduo != 0) {
                ecuacion = new Ecuacion();
                ecuacion.setN1(n1);
                ecuacion.setN2(n2);
                ecuacion.setnResiduo(nResiduo);
                ecuacion.setnCociente((-1) * nCociente);
                Ecuaciones.add(ecuacion);
            }

            respuesta += "\n" + n1 + " = "
                    + nCociente + " * " + n2 + " + " + nResiduo + "\n";

            residuos += "\n" + nResiduo + " = " + n1 + " - " + nCociente
                    + " * " + n2 + "\n";

            while (nResiduo != 0) {
                n1 = n2;
                n2 = nResiduo;
                nCociente = n1 / n2;

                nResiduo = n1 % n2;

                if (nResiduo != 0) {
                    ecuacion = new Ecuacion();
                    ecuacion.setN1(n1);
                    ecuacion.setN2(n2);
                    ecuacion.setnResiduo(nResiduo);
                    ecuacion.setnCociente((-1) * nCociente);
                    Ecuaciones.add(ecuacion);
                }

                respuesta += "\n" + n1 + " = "
                        + nCociente + " * " + n2 + " + " + nResiduo + "\n";

                residuos += "\n" + nResiduo + " = " + n1 + " - " + nCociente
                        + " * " + n2 + "\n";

            }

            if (numeros.size() > 2) {

                for (int i = 2; i < numeros.size(); i++) {
                    if (nResiduo > 0) {
                        if (numeros.get(i) < n2) {
                            n1 = n2;
                            n2 = numeros.get(i);
                        } else {
                            n1 = numeros.get(i);
                        }
                        respuesta += "\n-----Con el siguiente valor-----\n";

                        nCociente = n1 / n2;
                        nResiduo = n1 % n2;

                        if (nResiduo != 0) {
                            ecuacion = new Ecuacion();
                            ecuacion.setN1(n1);
                            ecuacion.setN2(n2);
                            ecuacion.setnResiduo(nResiduo);
                            ecuacion.setnCociente((-1) * nCociente);
                            Ecuaciones.add(ecuacion);
                        }

                        respuesta += "\n" + n1 + " = "
                                + nCociente + " * " + n2 + " + " + nResiduo + "\n";

                        residuos += "\n" + nResiduo + " = " + n1 + " - " + nCociente
                                + " * " + n2 + "\n";
                        while (nResiduo != 0) {
                            n1 = n2;
                            n2 = nResiduo;
                            nCociente = n1 / n2;
                            nResiduo = n1 % n2;

                            if (nResiduo != 0) {
                                ecuacion = new Ecuacion();
                                ecuacion.setN1(n1);
                                ecuacion.setN2(n2);
                                ecuacion.setnResiduo(nResiduo);
                                ecuacion.setnCociente((-1) * nCociente);
                                Ecuaciones.add(ecuacion);
                            }

                            respuesta += "\n" + n1 + " = "
                                    + nCociente + " * " + n2 + " + " + nResiduo + "\n";

                            residuos += "\n" + nResiduo + " = " + n1 + " - " + nCociente
                                    + " * " + n2 + "\n";

                        }

                    } else {
                        n1 = numeros.get(i);
                        respuesta += "\n---**--Con el siguiente valor-----\n";

                        nCociente = n1 / n2;
                        nResiduo = n1 % n2;

                        respuesta += "\n" + n1 + " = "
                                + nCociente + " * " + n2 + " + " + nResiduo + "\n";
                        residuos += "\n" + nResiduo + " = " + n1 + " - " + nCociente
                                + " * " + n2 + "\n";

                        if (nResiduo != 0) {
                            ecuacion = new Ecuacion();
                            ecuacion.setN1(n1);
                            ecuacion.setN2(n2);
                            ecuacion.setnResiduo(nResiduo);
                            ecuacion.setnCociente((-1) * nCociente);
                            Ecuaciones.add(ecuacion);
                        }

                        while (nResiduo != 0) {
                            n1 = n2;
                            n2 = nResiduo;
                            nCociente = n1 / n2;
                            nResiduo = n1 % n2;

                            if (nResiduo != 0) {
                                ecuacion = new Ecuacion();
                                ecuacion.setN1(n1);
                                ecuacion.setN2(n2);
                                ecuacion.setnResiduo(nResiduo);
                                ecuacion.setnCociente((-1) * nCociente);
                                Ecuaciones.add(ecuacion);
                            }

                            respuesta += "\n" + n1 + " = "
                                    + nCociente + " * " + n2 + " + " + nResiduo + "\n";
                            residuos += "\n" + nResiduo + " = " + n1 + " - " + nCociente
                                    + " * " + n2 + "\n";
                        }
                    }
                }
            }
            combLineal();
            salida = "" + numeros.get(0);

            for (int i = 1; i < numeros.size(); i++) {
                salida += "," + numeros.get(i);
            }
            vistaMCD.getLblSalida().setText("MCD(" + salida + ") = " + n2);

        }

    }

    public void combLineal() {
        Ecuacion ecu = new Ecuacion();
        int cant1 = 1;
        int cant2 = 1;
        int cant3 = 1;
        int cant4 = 1;
        int aux = 1;
        int aux2 = 1;
        boolean tres = false;
        boolean cuatro = false;

        n = Ecuaciones.size() - 1;
        ecu = Ecuaciones.get(n - 1);

        int res = Ecuaciones.get(n).getnResiduo();
        int cos = Ecuaciones.get(n).getnCociente();

        reemplazar = "(" + ecu.getN1() + " "
                + ecu.getnCociente() + " * " + ecu.getN2() + ")";

        combLineal += "\n" + res + " = " + Ecuaciones.get(n).getN1() + " "
                + cos + " * " + reemplazar + "\n";

        if (ecu.getN2() == Ecuaciones.get(n).getN1()) {
            cant2 = cos * ecu.getnCociente() + cant1;
            cant1 = cos;
        } else {
            cant3 = cos * ecu.getnCociente();
            cant1 = cos;
            tres = true;
            combLineal += "\n" + res + " = " + cant1 + " * " + ecu.getN1() + " + ("
                    + cant2 + ") * " + Ecuaciones.get(n).getN1() + " + (" + cant3 + ")*(" + ecu.getN2() + ")" + "\n";
            aux = ecu.getN1();

        }

        for (int i = n - 1; i >= 0; i--) {

            int num1 = Ecuaciones.get(i).getN1();
            int num2 = Ecuaciones.get(i).getN2();

            if (i != 0) {

                if (tres == true) {
                    ecu = Ecuaciones.get(i - 1);
                    reemplazar = "(" + ecu.getN1() + " "
                            + ecu.getnCociente() + " * " + ecu.getN2() + ")";
                    combLineal += "\n" + res + " = " + cant1 + " * " + aux + " + ("
                            + cant2 + ") * " + Ecuaciones.get(n).getN1() + " + (" + cant3 + ")*" + reemplazar + "\n";

                    if (aux == ecu.getN2()) {
                        aux2 = cant1;
                        cant1 = cant3;
                        aux = ecu.getN1();
                        cant3 = cant3 * ecu.getnCociente() + aux2;

                    } else {

                        cant4 = cant3;
                        cant3 = cant3 * ecu.getnCociente();

                        cuatro = true;

                        ecu = Ecuaciones.get(i - 1);
                        reemplazar = "(" + ecu.getN1() + " "
                                + ecu.getnCociente() + " * " + ecu.getN2() + ")";
                        combLineal += "\n" + res + " = " + cant1 + " * " + aux + " + ("
                                + cant2 + ") * " + Ecuaciones.get(n).getN1() + " + (" + cant3 + ")*(" + ecu.getN2()
                                + ") + (" + cant4 + ")*(" + ecu.getN1() + ")" + "\n";

                    }

                } else {

                    combLineal += "\n" + res + " = " + cant1 + " * " + num1 + " + ("
                            + cant2 + ") * " + num2 + "\n";
                    ecu = Ecuaciones.get(i - 1);
                    reemplazar = "(" + ecu.getN1() + " "
                            + ecu.getnCociente() + " * " + ecu.getN2() + ")";

                    if (ecu.getN2() == num1) {
                        combLineal += "\n" + res + " = " + cant1 + " * " + num1 + " + ("
                                + cant2 + ") * " + reemplazar + "\n";

                        aux = cant2;
                        cant2 = cant2 * ecu.getnCociente() + cant1;
                        cant1 = aux;
                    } else {
                        cant3 = cant2 * ecu.getnCociente();
                        cant1 = cant2;
                        tres = true;
                        combLineal += "\n" + res + " = " + cant1 + " * " + ecu.getN1() + " + ("
                                + cant2 + ") * " + Ecuaciones.get(n).getN1() + " + (" + cant3 + ")*(" + ecu.getN2() + ")" + "\n";
                        aux = ecu.getN1();
                    }

                }

            } else if (i == 0 && tres == false) {
                combLineal += "\n" + res + " = " + cant1 + " * " + num1 + " + ("
                        + cant2 + ") * " + num2 + "\n";
            }

        }

    }

    public void escribirEcuacion(String opcion) {
        if (opcion == "MCD") {
            getVistaMCD().getTxtMCD().setText(respuesta);
        }
        if (opcion == "Residuos") {
            getVistaMCD().getTxtMCD().setText("\n.....Residuos.....\n" + residuos);
        }
        if (opcion == "Combinacion lineal") {
            getVistaMCD().getTxtMCD().setText("\n.....Combianción Lineal.....\n" + combLineal);
        }
        vistaMCD.getTxtMCD().setEditable(false);
    }

    public void volver() {
        respuesta = "";
        residuos = "";
        combLineal = "";
        Ecuaciones.clear();
        numeros.clear();
        vistaInicio.setVisible(true);
        vistaInicio.setResizable(false);
        vistaMCD.setVisible(false);
    }
}
