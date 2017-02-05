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
public class departments extends javax.swing.JFrame {
    static final boolean EXL = true; //Execute queries on Local Database
    DefaultTableModel modelo;
    Database d;
    ResultSet rs;
    String idEdit;//Id que se selecciona para editar
    int bandEdit;//bandera que se activa cuando se presiona el boton de editar    
    /**
     * Creates new form departments
     */
    public departments() throws SQLException {
        initComponents();
        cargarDatos();
    }
   
public void cargarDatos() throws SQLException{
            modelo= new DefaultTableModel();        
            //modelo.addColumn("Número Adquisición");
            modelo.addColumn("DEPARTMENT_ID");
            modelo.addColumn("DEPARTMENT_NAME");
            modelo.addColumn("MANAGER_ID"); 
            modelo.addColumn("LOCATION_ID"); 
            jTable1.setModel(modelo);  
            
            String []Datos= new String[4];            
		this.d=new Database();		
                String consulta;
                if (EXL)
                    consulta="select * from departments";
                else
                    consulta="select * from departments @LINK_B";
		System.out.println("Conectando con la base de datos:");
		if(d.conectar()){
			rs=d.ejecutarConsulta(consulta);
                        while(rs.next()) {
				for(int i=1; i<=4; i++) {
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
            modelo.addColumn("DEPARTMENT_ID");
            modelo.addColumn("DEPARTMENT_NAME");
            modelo.addColumn("MANAGER_ID"); 
            modelo.addColumn("LOCATION_ID"); 
            jTable1.setModel(modelo);  
            
            String []Datos= new String[4];            
		this.d=new Database();	
                String devolver ="";
		System.out.println("Conectando con la base de datos:");
                String consulta;
                if(EXL)
                    consulta= "select * from departments where "+categoria+" LIKE '%"+parametro+"%'";
                else 
                    consulta= "select * from departments@LINK_B where "+categoria+" LIKE '%"+parametro+"%'";
                System.out.println(consulta);
		if(d.conectar()){
			this.rs=d.ejecutarConsulta(consulta);
                        while(rs.next()) {
				for(int i=1; i<=4; i++) {
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

        textId = new javax.swing.JTextField();
        textNombre = new javax.swing.JTextField();
        textRegionId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        lbl_fondo1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnVerTodo = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jTextFieldParam = new javax.swing.JTextField();
        jComboBoxCat = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jButtonMenu = new javax.swing.JButton();
        textId1 = new javax.swing.JTextField();
        textManagerId = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnAgregar1 = new javax.swing.JButton();
        btnEliminar1 = new javax.swing.JButton();
        btnEditar1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        textLocationId = new javax.swing.JTextField();
        textNomD = new javax.swing.JTextField();
        lbl_fondo = new javax.swing.JLabel();

        jLabel3.setText("ID PAÍS");

        jLabel4.setText("NOMBRE");

        jLabel5.setText("ID REGIÓN");

        btnAgregar.setText("Guardar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        lbl_fondo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/consultas/views/fondo1.jpg"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Departamentos");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Book", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("DEPARTAMENTOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 900, 400));

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
        jComboBoxCat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DEPARTMENT_ID", "DEPARTMENT_NAME", "MANAGER_ID ", "LOCATION_ID" }));
        getContentPane().add(jComboBoxCat, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 180, -1));

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Book", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setText("BUSCAR POR");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, -1, 30));

        jButtonMenu.setFont(new java.awt.Font("Franklin Gothic Book", 1, 18)); // NOI18N
        jButtonMenu.setForeground(new java.awt.Color(204, 0, 0));
        jButtonMenu.setText("Menu");
        jButtonMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenuActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 650, 180, -1));
        getContentPane().add(textId1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 70, 30));
        getContentPane().add(textManagerId, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, 70, 30));

        jLabel6.setText("ID DEPARTAMENTO");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        jLabel7.setText("NOMBRE");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, -1, -1));

        jLabel8.setText("ID MANAGER");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, -1, -1));

        btnAgregar1.setText("Guardar");
        btnAgregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 180, -1, -1));

        btnEliminar1.setText("Eliminar");
        btnEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 180, -1, -1));

        btnEditar1.setText("Editar");
        btnEditar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 180, -1, -1));

        jLabel9.setText("ID UBICACIÓN");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 180, -1, -1));
        getContentPane().add(textLocationId, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 180, 70, 30));
        getContentPane().add(textNomD, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, 100, 30));

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
                JOptionPane.showMessageDialog(rootPane, "Por favor escribe un parametro de busqueda");
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Por favor seleccione una categoria");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jButtonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenuActionPerformed
        main f = null;
        f = new main();
        f.setVisible (true);
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonMenuActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnAgregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar1ActionPerformed
        if("".equals(textId1.getText())&&"".equals(textNomD.getText()))
        JOptionPane.showMessageDialog(null, "Por favor rellene todos los campos obligatorios");
        else{
            if(bandEdit!=1){
                if(d.conectar()){
                    String id = textId1.getText();
                    String nom= textNomD.getText();
                    int managerId = Integer.parseInt(textManagerId.getText());
                    int locationId = Integer.parseInt(textLocationId.getText());
                    if (d.insertarDeparment(id, nom, managerId,locationId)){
                        try {
                            cargarDatos();
                        } catch (SQLException ex) {
                            Logger.getLogger(departments.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                else
                System.out.println("No se pudo conectar. Revisa los datos introducidos.");
                if(d.desconectar())
                System.out.println("Desconectado tras jecutar la consulta.");
                else
                System.out.println("Por alguna razón no se ha podido desconectar.");
            }else{
                if(idEdit.equals(textId1.getText())){
                }else{
                    JOptionPane.showMessageDialog(null, "El campo Id no se puede modificar porque es clave primaria, se guardaran los demas valores excepto este");
                }
                if(d.conectar()){
                    String id = idEdit;
                    String nom= textNomD.getText();                    
                    int managerId = Integer.parseInt(textManagerId.getText());
                    int locationId = Integer.parseInt(textLocationId.getText());                    
                    if (d.actualizarDeparment(id, nom, managerId, locationId)){
                        try {
                            cargarDatos();
                        } catch (SQLException ex) {
                            Logger.getLogger(countries.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                else
                System.out.println("No se pudo conectar. Revisa los datos introducidos.");
                if(d.desconectar())
                System.out.println("Desconectado tras jecutar la consulta.");
                else
                System.out.println("Por alguna razón no se ha podido desconectar.");
                bandEdit=0;
                textId1.setEditable(true);
                textManagerId.setEditable(true);
                textLocationId.setEditable(true);                
                limpiarCajas();                
            }
            limpiarCajas();
        }
    }//GEN-LAST:event_btnAgregar1ActionPerformed

    private void btnEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar1ActionPerformed
        if(jTable1.getSelectedRow()!=-1){
            String idSelected=String.valueOf(modelo.getValueAt(jTable1.getSelectedRow(),0));
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "¿Eliminar el Registro con ID: "+idSelected,
                "Eliminar Regustro", dialogButton);
            if(dialogResult == 0) {
                if(d.conectar()){

                    if (!d.eliminarDeparment(idSelected)){
                        JOptionPane.showMessageDialog(null, "Por motivos de integridad referencial, no puede eliminarse\n" +
                            "esa tupla");
                    }else{
                        try {
                            cargarDatos();
                        } catch (SQLException ex) {
                            Logger.getLogger(countries.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                else
                System.out.println("No se pudo conectar. Revisa los datos introducidos.");
                if(d.desconectar())
                System.out.println("Desconectado tras jecutar la consulta.");
                else
                System.out.println("Por alguna razón no se ha podido desconectar.");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar el registro que desea eliminar");
        }
    }//GEN-LAST:event_btnEliminar1ActionPerformed

    private void btnEditar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditar1ActionPerformed
        if(jTable1.getSelectedRow()!=-1){
            String idSelected=String.valueOf(modelo.getValueAt(jTable1.getSelectedRow(),0));
            String nombre=String.valueOf(modelo.getValueAt(jTable1.getSelectedRow(),1));
            String managerIdr=String.valueOf(modelo.getValueAt(jTable1.getSelectedRow(),2));
            String locationIdr=String.valueOf(modelo.getValueAt(jTable1.getSelectedRow(),3));
            bandEdit=1;
            idEdit=idSelected;
            textId1.setText(idEdit);
            textNomD.setText(nombre);
            textManagerId.setText(managerIdr);
            textLocationId.setText(locationIdr);
            textId1.setEditable(false);
            textManagerId.setEditable(false);
            textLocationId.setEditable(false);
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar el registro que desea Editar");
        }
    }//GEN-LAST:event_btnEditar1ActionPerformed
public void limpiarCajas(){
    textId1.setText("");
    textNomD.setText("");
    textManagerId.setText("");
    textLocationId.setText("");
}
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
            java.util.logging.Logger.getLogger(departments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(departments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(departments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(departments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new departments().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(departments.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregar1;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEditar1;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminar1;
    private javax.swing.JButton btnVerTodo;
    private javax.swing.JButton jButtonMenu;
    private javax.swing.JComboBox<String> jComboBoxCat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldParam;
    private javax.swing.JLabel lbl_fondo;
    private javax.swing.JLabel lbl_fondo1;
    private javax.swing.JTextField textId;
    private javax.swing.JTextField textId1;
    private javax.swing.JTextField textLocationId;
    private javax.swing.JTextField textManagerId;
    private javax.swing.JTextField textNomD;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textRegionId;
    // End of variables declaration//GEN-END:variables
}
