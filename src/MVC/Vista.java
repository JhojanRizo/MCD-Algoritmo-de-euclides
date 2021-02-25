/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

/**
 *
 * @author Familia-PC
 */
public class Vista extends javax.swing.JFrame {

    private Modelo_V modelo;
    private ControladorMCD control;
    

    public Vista(Modelo_V modelo) {
        initComponents();
        this.modelo = modelo;
        eventos();
        setLocationRelativeTo(null);
    }

    public Modelo_V getModelo() {
        return modelo;
    }

    public ControladorMCD getControl() {
        if (control == null) {
            control = new ControladorMCD(this);
        }
        return control;
    }

    public JButton getBtnVolver() {
        return btnVolver;
    }
    
    public JScrollPane getPanelMCD() {
        return panelMCD;
    }

    public void setPanelMCD(JScrollPane panelMCD) {
        this.panelMCD = panelMCD;
    }

    public JTextPane getTxtMCD() {
        return txtMCD;
    }

    public void setTxtMCD(JTextPane txtMCD) {
        this.txtMCD = txtMCD;
    }

    public JRadioButton getrBtnMCD() {
        return rBtnMCD;
    }

    public JRadioButton getrBtnResiduos() {
        return rBtnResiduos;
    }

    public JRadioButton getrBtnCombLineal() {
        return rBtnCombLineal;
    }
    
    public JLabel getLblSalida() {
        return lblSalida;
    }

    public void setLblSalida(JLabel lblSalida) {
        this.lblSalida = lblSalida;
    }

    
    
    public void eventos() {
        rBtnMCD.addActionListener(getControl());
        rBtnResiduos.addActionListener(getControl());
        rBtnCombLineal.addActionListener(getControl());
        btnVolver.addActionListener(getControl());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMCD = new javax.swing.JScrollPane();
        txtMCD = new javax.swing.JTextPane();
        btnVolver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        rBtnMCD = new javax.swing.JRadioButton();
        rBtnResiduos = new javax.swing.JRadioButton();
        lblSalida = new javax.swing.JLabel();
        rBtnCombLineal = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        panelMCD.setViewportView(txtMCD);

        btnVolver.setText("Volver a calcular");

        jLabel1.setFont(new java.awt.Font("Galderglynn Titling Bl", 1, 14)); // NOI18N
        jLabel1.setText("Algoritmo de Euclides MCD");

        rBtnMCD.setText("MCD");

        rBtnResiduos.setText("Residuos desde la penultima hasta la pimera ecuación ");

        lblSalida.setFont(new java.awt.Font("Galderglynn Titling Rg", 0, 18)); // NOI18N
        lblSalida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        rBtnCombLineal.setText("Paso a paso combinacion lineal");
        rBtnCombLineal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtnCombLinealActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(lblSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(178, 178, 178))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelMCD, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVolver)
                        .addGap(115, 115, 115))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rBtnResiduos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rBtnCombLineal)
                                    .addComponent(rBtnMCD))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelMCD, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rBtnMCD)
                        .addGap(35, 35, 35)
                        .addComponent(rBtnResiduos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rBtnCombLineal)
                        .addGap(27, 27, 27)
                        .addComponent(btnVolver)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rBtnCombLinealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtnCombLinealActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rBtnCombLinealActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblSalida;
    private javax.swing.JScrollPane panelMCD;
    private javax.swing.JRadioButton rBtnCombLineal;
    private javax.swing.JRadioButton rBtnMCD;
    private javax.swing.JRadioButton rBtnResiduos;
    private javax.swing.JTextPane txtMCD;
    // End of variables declaration//GEN-END:variables
}
