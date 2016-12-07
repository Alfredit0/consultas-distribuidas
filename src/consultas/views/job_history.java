/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultas.views;

import consultas.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Meltsan
 */
public class job_history extends javax.swing.JFrame {
    DefaultTableModel modelo;
    Database d;
    ResultSet rs;
    /**
     * Creates new form departments
     */
    public job_history() throws SQLException {
        initComponents();
        cargarDatos();
    }
public void cargarDatos() throws SQLException{
            modelo= new DefaultTableModel();        
            //modelo.addColumn("Número Adquisición");
            modelo.addColumn("EMPLOYEE_ID");
            modelo.addColumn("START_DATE");
            modelo.addColumn("END_DATE"); 
            modelo.addColumn("JOB_ID"); 
            modelo.addColumn("DEPARTMENT_ID"); 
            jTable1.setModel(modelo);  
            
            String []Datos= new String[5];
            
		Database d=new Database();
		ResultSet rs;
                String devolver ="";
		System.out.println("Conectando con la base de datos:");
		if(d.conectar()){
			rs=d.ejecutarConsulta("select * from job_history @LINK_A");
                        while(rs.next()) {
				for(int i=1; i<=5; i++) {
					Datos[i-1]=rs.getString(i);
				}
                                modelo.addRow(Datos);
                        }
                }
		else
			System.out.println("No se pudo conectar. Revisa los datos introducidos.");
		if(d.desconectar())
			System.out.println("Desconectado tras jecutar la consulta.");
		else
			System.out.println("Por alguna razón no se ha podido desconectar.");            
}
public void cargarDatos(String categoria, String parametro) throws SQLException{
            modelo= new DefaultTableModel();        
            //modelo.addColumn("Número Adquisición");
            modelo.addColumn("EMPLOYEE_ID");
            modelo.addColumn("START_DATE");
            modelo.addColumn("END_DATE"); 
            modelo.addColumn("JOB_ID"); 
            modelo.addColumn("DEPARTMENT_ID"); 
            jTable1.setModel(modelo);  
            
            String []Datos= new String[5];
            
		Database d=new Database();
                
		System.out.println("Conectando con la base de datos:");
                String consulta = "select * from job_history@LINK_A where "+categoria+" LIKE '%"+parametro+"%'";
                System.out.println(consulta);
		if(d.conectar()){
			this.rs=d.ejecutarConsulta(consulta);
                        while(rs.next()) {
				for(int i=1; i<=5; i++) {
					Datos[i-1]=rs.getString(i);
				}
                                modelo.addRow(Datos);
                        }
                }
		else
			System.out.println("No se pudo conectar. Revisa los datos introducidos.");
		if(d.desconectar())
			System.out.println("Desconectado tras jecutar la consulta.");
		else
			System.out.println("Por alguna razón no se ha podido desconectar.");            
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnVerTodo = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jTextFieldParam = new javax.swing.JTextField();
        jComboBoxCat = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        lbl_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Historial Empleados");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Book", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("HISTORIAL DE EMPLEOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 900, 440));

        btnVerTodo.setFont(new java.awt.Font("Franklin Gothic Book", 1, 18)); // NOI18N
        btnVerTodo.setForeground(new java.awt.Color(204, 0, 0));
        btnVerTodo.setText("VER TODOS");
        btnVerTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerTodoActionPerformed(evt);
            }
        });
        getContentPane().add(btnVerTodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 110, -1, 30));

        btnBuscar.setFont(new java.awt.Font("Franklin Gothic Book", 1, 18)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(204, 0, 0));
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 110, -1, 30));

        jTextFieldParam.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        jTextFieldParam.setForeground(new java.awt.Color(204, 0, 0));
        getContentPane().add(jTextFieldParam, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, 150, 30));

        jComboBoxCat.setFont(new java.awt.Font("Franklin Gothic Book", 1, 18)); // NOI18N
        jComboBoxCat.setForeground(new java.awt.Color(204, 0, 0));
        jComboBoxCat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE", "EMPLOYEE_ID", "START_DATE", "END_DATE", "JOB_ID", "DEPARTMENT_ID" }));
        getContentPane().add(jComboBoxCat, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 180, -1));

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Book", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setText("BUSCAR POR");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, -1, 30));

        lbl_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/consultas/views/fondo1.jpg"))); // NOI18N
        getContentPane().add(lbl_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerTodoActionPerformed
        try {
            cargarDatos();
        } catch (SQLException ex) {
            Logger.getLogger(countries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnVerTodoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String categoria = (String) jComboBoxCat.getSelectedItem();
        String parametro = jTextFieldParam.getText();
        System.out.println(categoria);
        if(!categoria.equals("SELECCIONE")){
            if(!"".equals(jTextFieldParam.getText())){
                try {
                    cargarDatos(categoria, parametro);
                } catch (SQLException ex) {
                    Logger.getLogger(countries.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                JOptionPane.showMessageDialog(rootPane, "Par favar escribe un parametro de busqueda");
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Par favar seleccione una categoria");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(job_history.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(job_history.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(job_history.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(job_history.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new job_history().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(job_history.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnVerTodo;
    private javax.swing.JComboBox<String> jComboBoxCat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldParam;
    private javax.swing.JLabel lbl_fondo;
    // End of variables declaration//GEN-END:variables
}
