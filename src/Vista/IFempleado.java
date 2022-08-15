/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista;

import Clases.Empleado;
import Controlador.ControladorEmpleado;
import Controlador.mensajesConfirmacion;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JOptionPane;

/**
 *
 * @author teenc
 */
public class IFempleado extends javax.swing.JInternalFrame {
    
    
    ControladorEmpleado controlEmpleado = new ControladorEmpleado();
    
    /**
     * Creates new form IFempleado
     */
    public IFempleado() {
        initComponents();
    }

    public Empleado crearNuevoEmpleado(){
        try{
            if (ValidarVacios()==true){
                JOptionPane.showMessageDialog(null,"Datos incompletos");
                return null;
            }if(!camposTexto()==true){
                JOptionPane.showMessageDialog(null,"Datos incorrectos T");
                return null;
            }if(!camposNumericos()==true){
                JOptionPane.showMessageDialog(null,"Datosincorrectos N");
                return null;
            }if(!campoFecha()==true){
                JOptionPane.showMessageDialog(null,"Formato incorrectos");
                return null;
                } else {
                String nombre1 = tFNombre1.getText();
                String nombre2 = tfNombre2.getText();
                String apellido1 = tFApellido1.getText();
                String apellido2 = tFApellido2.getText();
                String identificacion = cBDocumento.getSelectedItem().toString();
                String numeroidentificacion = tFNumeroIdentificacion.getText();
                String fechaNacimiento = tFFechaNacimiento.getText();
                String direccion = tFDireccion.getText();
                String ciudad = cBCiudadPersona.getSelectedItem().toString();
                String regional = cBRegional.getSelectedItem().toString();
                String telefonoPersona = tFTelefonoPersonal.getText();
                String eMailPersona = tFEMailPersona.getText();
                String fechaIngreso = tFFechaIngreso.getText();
                String cargo = cBCargo.getSelectedItem().toString();
                String salario = cBSalario.getSelectedItem().toString();
                String empleadoId = tFEmpleadoId.getText();
                String usuario = tFUsuario.getText();
                String contraseña = lBContraseña.getText();
                String eMailEmpresa = tFEMailEmpresa.getText();
                Empleado nuevo = new Empleado(empleadoId, fechaIngreso,"N/A", cargo, regional, salario, usuario, contraseña, eMailEmpresa, identificacion, numeroidentificacion, nombre1, nombre2, apellido1, apellido2, fechaNacimiento, direccion, ciudad, telefonoPersona, eMailPersona);
                return nuevo;
            }
            }catch(Exception e){                 
                System.out.println("vista &&"+e.getMessage());
            }            
        return null;
    }
    
    private boolean ValidarVacios(){
        return tFApellido2.getText().trim().isEmpty()&&tFApellido1.getText().trim().isEmpty()&&tFApellido1.getText().trim().isEmpty()&&lBContraseña.getText().trim().isEmpty()&&tFDireccion.getText().trim().isEmpty()&&
               tFEMailEmpresa.getText().trim().isEmpty()&&tFEMailPersona.getText().trim().isEmpty()&&tFEmpleadoId.getText().trim().isEmpty()&&tFFechaIngreso.getText().trim().isEmpty()&&tFFechaNacimiento.getText().trim().isEmpty()&&
               tFFechaRetiro.getText().trim().isEmpty()&&tFNombre1.getText().trim().isEmpty()&&tFNumeroIdentificacion.getText().trim().isEmpty()&&tFTelefonoPersonal.getText().trim().isEmpty()&&tFUsuario.getText().trim().isEmpty()&&
               tfNombre2.getText().trim().isEmpty()&&cBCargo.getSelectedItem().toString().trim().isEmpty()&&cBCiudadPersona.getSelectedItem().toString().trim().isEmpty()&&cBDocumento.getSelectedItem().toString().trim().isEmpty()&&
               cBRegional.getSelectedItem().toString().trim().isEmpty()&&cBSalario.getSelectedItem().toString().trim().isEmpty();
    }
    private boolean camposNumericos(){
        return tFNumeroIdentificacion.getText().matches("[1-9]*")&&tFTelefonoPersonal.getText().matches("[1-9]*")&&
                cBSalario.getSelectedItem().toString().matches("[1-9]*");
    }
    
    private boolean camposTexto(){
        return tFApellido1.getText().matches("[a-zA-Z]*")&&tFApellido2.getText().matches("[a-zA-Z]*")&&tFNombre1.getText().matches("[a-zA-Z]*")&&tfNombre2.getText().matches("[a-zA-Z]*");
    }
    
    private boolean campoFecha(){
        return tFFechaIngreso.getText().matches("\\d{4}-\\d{2}-\\d{2}$")&&tFFechaNacimiento.getText().matches("\\d{4}-\\d{2}-\\d{2}$")&&tFFechaRetiro.getText().matches("\\d{4}-\\d{2}-\\d{2}$");
    }
    
    private String crearEmpeadoId(){
        try{    
            int a = 111111;
            int b = 999999;
            ThreadLocalRandom ale = ThreadLocalRandom.current();
            String ramdom = String.valueOf(ale.nextInt(a , b+1));
            return ramdom;
        }catch(Exception e){
            System.out.println("empleadoId "+e);
        return null;
        }
    }
    
    private String crearUsuario (){
        try{
            String nombre = tFNombre1.getText().trim().substring(0, 3);
            String may = tFApellido1.getText().trim().substring(0, 1).toUpperCase();
            String apellido = tFApellido1.getText().trim().substring(1);
            String id = tFNumeroIdentificacion.getText().trim().substring(0, 2);
            String empleadoId = nombre+may+apellido+id;
            return empleadoId;
        }catch(Exception e){
            System.out.println("error idEmpleado" +e.getMessage());
            return null ;
        }        
    }
    
    private String crearCorreoEmpresa(){
        try{
            String nombre = crearUsuario();
            String eMailEmpresa = nombre+"@empresa.com";
            return eMailEmpresa;
        }catch(Exception e){
            System.out.println("crearCorreoEmpresa "+ e);
            return null;
        }
    }
    
    private String crearClaveUsuario(){
        try{    
            String clave = tFNumeroIdentificacion.getText().trim();
            StringBuilder idInv = new StringBuilder(clave);
            clave = idInv.reverse().toString();
            String password = clave.substring(0, 6);
            return password;
        }catch(Exception e){
            System.out.println("crear Clave "+e);
            return null;
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tfNombre2 = new javax.swing.JTextField();
        tFApellido1 = new javax.swing.JTextField();
        tFApellido2 = new javax.swing.JTextField();
        tFNombre1 = new javax.swing.JTextField();
        cBDocumento = new javax.swing.JComboBox<>();
        tFNumeroIdentificacion = new javax.swing.JTextField();
        cBCiudadPersona = new javax.swing.JComboBox<>();
        tFFechaNacimiento = new javax.swing.JTextField();
        tFDireccion = new javax.swing.JTextField();
        tFTelefonoPersonal = new javax.swing.JTextField();
        tFEMailPersona = new javax.swing.JTextField();
        cBRegional = new javax.swing.JComboBox<>();
        tFFechaIngreso = new javax.swing.JTextField();
        tFFechaRetiro = new javax.swing.JTextField();
        cBCargo = new javax.swing.JComboBox<>();
        cBSalario = new javax.swing.JComboBox<>();
        tFEmpleadoId = new javax.swing.JTextField();
        tFUsuario = new javax.swing.JTextField();
        lBContraseña = new javax.swing.JTextField();
        tFEMailEmpresa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        JBGrabar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lBEmpleadoId = new javax.swing.JLabel();
        lBusuarioEmpleado = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lbEMailEmpresa = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setAutoscrolls(true);
        setPreferredSize(new java.awt.Dimension(1000, 590));

        tfNombre2.setForeground(new java.awt.Color(204, 204, 204));
        tfNombre2.setText("Nombre 2");

        tFApellido1.setForeground(new java.awt.Color(204, 204, 204));
        tFApellido1.setText("Apellido1");

        tFApellido2.setForeground(new java.awt.Color(204, 204, 204));
        tFApellido2.setText("Apellido2");

        tFNombre1.setForeground(new java.awt.Color(204, 204, 204));
        tFNombre1.setText("Nombre 1");

        cBDocumento.setForeground(new java.awt.Color(204, 204, 204));
        cBDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Documento", "Cedula", "C.Extangeria", "T.Identidad", "Pasaporte" }));

        tFNumeroIdentificacion.setForeground(new java.awt.Color(204, 204, 204));
        tFNumeroIdentificacion.setText("Numero Documento");

        cBCiudadPersona.setForeground(new java.awt.Color(204, 204, 204));
        cBCiudadPersona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tFFechaNacimiento.setForeground(new java.awt.Color(204, 204, 204));
        tFFechaNacimiento.setText("Fecha Nacimiento");

        tFDireccion.setForeground(new java.awt.Color(204, 204, 204));
        tFDireccion.setText("Direccion");

        tFTelefonoPersonal.setForeground(new java.awt.Color(204, 204, 204));
        tFTelefonoPersonal.setText("Tel.Personal");

        tFEMailPersona.setForeground(new java.awt.Color(204, 204, 204));
        tFEMailPersona.setText("E-mail.Personal");

        cBRegional.setForeground(new java.awt.Color(204, 204, 204));
        cBRegional.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Regional", "Norte", "Sur", "Oriente", "Occidente" }));

        tFFechaIngreso.setForeground(new java.awt.Color(204, 204, 204));
        tFFechaIngreso.setText("Fecha Ingreso");

        tFFechaRetiro.setEditable(false);
        tFFechaRetiro.setForeground(new java.awt.Color(204, 204, 204));
        tFFechaRetiro.setText("Fecha Retiro");

        cBCargo.setForeground(new java.awt.Color(204, 204, 204));
        cBCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cargo", "Tecnico", "Analista", "Mensajero" }));

        cBSalario.setForeground(new java.awt.Color(204, 204, 204));
        cBSalario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Salario", "1 SMLV", "1.5 SMLV", "2 SMLV" }));

        tFEmpleadoId.setEditable(false);
        tFEmpleadoId.setForeground(new java.awt.Color(204, 204, 204));
        tFEmpleadoId.setText("EmpleadoId");

        tFUsuario.setEditable(false);
        tFUsuario.setForeground(new java.awt.Color(204, 204, 204));
        tFUsuario.setText("Usuario");

        lBContraseña.setEditable(false);
        lBContraseña.setForeground(new java.awt.Color(204, 204, 204));
        lBContraseña.setText("Contraseña");

        tFEMailEmpresa.setEditable(false);
        tFEMailEmpresa.setForeground(new java.awt.Color(204, 204, 204));
        tFEMailEmpresa.setText("E-Mail Empresa");

        jLabel2.setText("jLabel2");

        jLabel3.setText("jLabel3");

        jLabel4.setText("jLabel4");

        jLabel5.setText("jLabel5");

        jLabel6.setText("jLabel6");

        jLabel7.setText("jLabel7");

        jLabel8.setText("jLabel8");

        jLabel9.setText("jLabel9");

        jLabel10.setText("jLabel10");

        jLabel11.setText("jLabel11");

        jLabel12.setText("jLabel12");

        jLabel13.setText("jLabel13");

        JBGrabar.setText("REGISTRAR");
        JBGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBGrabarActionPerformed(evt);
            }
        });

        jLabel14.setText("jLabel14");

        jLabel15.setText("jLabel15");

        jLabel16.setText("jLabel16");

        jLabel17.setText("jLabel17");

        lBEmpleadoId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lBEmpleadoId.setText("Numero de empleado");

        lBusuarioEmpleado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lBusuarioEmpleado.setText("Usuario Empleado");

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Contraseña");

        lbEMailEmpresa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbEMailEmpresa.setText("E-mail Empresa");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cBDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tFNumeroIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tFFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tFDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cBCiudadPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cBRegional, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tFTelefonoPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tFEMailPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lBEmpleadoId, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lBusuarioEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(tFEmpleadoId, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(JBGrabar)
                                            .addComponent(tFUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbEMailEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lBContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(tFEMailEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tFNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(tfNombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(tFApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tFApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tFFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tFFechaRetiro, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cBCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cBSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(31, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tFNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNombre2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tFApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tFApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cBDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tFNumeroIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tFFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tFDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cBCiudadPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cBRegional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tFTelefonoPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tFEMailPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tFFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tFFechaRetiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cBCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cBSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lBEmpleadoId)
                    .addComponent(lBusuarioEmpleado)
                    .addComponent(jLabel20)
                    .addComponent(lbEMailEmpresa))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tFEmpleadoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tFUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lBContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tFEMailEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(JBGrabar)
                .addGap(28, 28, 28))
        );

        lBEmpleadoId.getAccessibleContext().setAccessibleParent(tFEmpleadoId);
        lBusuarioEmpleado.getAccessibleContext().setAccessibleParent(tFUsuario);
        jLabel20.getAccessibleContext().setAccessibleParent(lBContraseña);
        lbEMailEmpresa.getAccessibleContext().setAccessibleParent(lBContraseña);

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel1.setText("GESTION EMPLEADOS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBGrabarActionPerformed
        try{
            tFEmpleadoId.setText(crearEmpeadoId());
            tFUsuario.setText(crearUsuario());
            tFEMailEmpresa.setText(crearCorreoEmpresa());
            lBContraseña.setText(crearClaveUsuario());
            controlEmpleado.crearEmpleado(crearNuevoEmpleado());
            mensajesConfirmacion mensaje = new mensajesConfirmacion();
            boolean opcion = mensaje.mensajeConfirmacionEmpleado(crearNuevoEmpleado());
            if(opcion ==true){              
              controlEmpleado.crearEmpleado(crearNuevoEmpleado());
            }
            }catch(Exception e){
                System.out.println("btGrbar "+e.getMessage());    
                }
    }//GEN-LAST:event_JBGrabarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBGrabar;
    private javax.swing.JComboBox<String> cBCargo;
    private javax.swing.JComboBox<String> cBCiudadPersona;
    private javax.swing.JComboBox<String> cBDocumento;
    private javax.swing.JComboBox<String> cBRegional;
    private javax.swing.JComboBox<String> cBSalario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lBContraseña;
    private javax.swing.JLabel lBEmpleadoId;
    private javax.swing.JLabel lBusuarioEmpleado;
    private javax.swing.JLabel lbEMailEmpresa;
    private javax.swing.JTextField tFApellido1;
    private javax.swing.JTextField tFApellido2;
    private javax.swing.JTextField tFDireccion;
    private javax.swing.JTextField tFEMailEmpresa;
    private javax.swing.JTextField tFEMailPersona;
    private javax.swing.JTextField tFEmpleadoId;
    private javax.swing.JTextField tFFechaIngreso;
    private javax.swing.JTextField tFFechaNacimiento;
    private javax.swing.JTextField tFFechaRetiro;
    private javax.swing.JTextField tFNombre1;
    private javax.swing.JTextField tFNumeroIdentificacion;
    private javax.swing.JTextField tFTelefonoPersonal;
    private javax.swing.JTextField tFUsuario;
    private javax.swing.JTextField tfNombre2;
    // End of variables declaration//GEN-END:variables
}
