/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista;

import Clases.Empleado;
import Clases.Ciudad;
import Controlador.ControladorCiudad;
import Controlador.ControladorEmpleado;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JOptionPane;

/**
 *
 * @author teenc
 */
public class IFempleado extends javax.swing.JInternalFrame {
    
    ControladorEmpleado controlEmpleado = new ControladorEmpleado();
    ControladorCiudad controlCiudad = new ControladorCiudad();
    
    /**
     * Creates new form IFempleado
     */
    public IFempleado() {
        initComponents();
        jBActualizar.setEnabled(false);
        jBEditar.setEnabled(false);
    }
    
    
    public void cargarEmpleado(Empleado empleado){
        try{
            tFApellido1.setText(empleado.getApellido1());
            tFApellido2.setText(empleado.getApellido2());
            tFBuscarCiudad.setText(empleado.ciudad.getCiudad());
            tFDireccion.setText(empleado.getDireccion());
            tFEMailEmpresa.setText(empleado.getCorreoEmpresarial());
            tFEMailPersona.setText(empleado.geteMail());
            tFEmpleadoId.setText(empleado.getEmpleadoId());
            tFFechaIngreso.setText(empleado.getFechaIngreso());
            tFFechaNacimiento.setText(empleado.getFechaNacimiento());
            tFFechaRetiro.setText(empleado.getFechaRetiro());
            tFNombre1.setText(empleado.getNombre1());
            tFNumeroIdentificacion.setText(empleado.getNumeroIdPersona());
            tFTelefonoPersonal.setText(empleado.getTelefono());
            tFUsuario.setText(empleado.getUsuario());
            tfNombre2.setText(empleado.getNombre2());
            tbContraseña.setText(empleado.getContraseña());
            cBCargo.setSelectedItem(empleado.getCargo());
            cBDocumento.setSelectedItem(empleado.getTipoIdPersona());
            cBRegional.setSelectedItem(empleado.getRegional());
            cBSalario.setSelectedItem(empleado.getSalario());
        }catch(Exception e){
            System.out.println("vista "+e.getMessage());
        }  
    }

    public Empleado crearNuevoEmpleado(){
        try{
            String nombre1 = tFNombre1.getText();
            String nombre2 = tfNombre2.getText();
            String apellido1 = tFApellido1.getText();
            String apellido2 = tFApellido2.getText();
            String identificacion = cBDocumento.getSelectedItem().toString();
            String numeroidentificacion = tFNumeroIdentificacion.getText();
            String fechaNacimiento = tFFechaNacimiento.getText();
            String direccion = tFDireccion.getText();
            String string = (String) cBCiudadPersona.getSelectedItem();
            String[] dividir = string.split("-");
            String numCiudad = dividir[2];
            Ciudad ciudad = controlCiudad.buscarCiudad(numCiudad);
            String regional = cBRegional.getSelectedItem().toString();
            String telefonoPersona = tFTelefonoPersonal.getText();
            String eMailPersona = tFEMailPersona.getText();
            String fechaIngreso = tFFechaIngreso.getText();
            String cargo = cBCargo.getSelectedItem().toString();
            String salario = cBSalario.getSelectedItem().toString();
            String empleadoId = tFEmpleadoId.getText();
            String usuario = tFUsuario.getText();
            String contraseña = tbContraseña.getText();
            String eMailEmpresa = tFEMailEmpresa.getText();
            Empleado nuevo = new Empleado(empleadoId, fechaIngreso,"N/A", cargo, regional, salario, usuario, contraseña, eMailEmpresa, identificacion, numeroidentificacion, nombre1, nombre2, apellido1, apellido2, fechaNacimiento, direccion, ciudad, telefonoPersona, eMailPersona);
            return nuevo;
        }catch(Exception e){                 
            System.out.println("vista &&"+e.getMessage());
        }            
        return null;
    }
    
    private boolean ValidarVacios(){
        try{
            return tFApellido2.getText().trim().isEmpty()&&tFApellido1.getText().trim().isEmpty()&&tFApellido1.getText().trim().isEmpty()&&tbContraseña.getText().trim().isEmpty()&&tFDireccion.getText().trim().isEmpty()&&
                   tFEMailEmpresa.getText().trim().isEmpty()&&tFEMailPersona.getText().trim().isEmpty()&&tFEmpleadoId.getText().trim().isEmpty()&&tFFechaIngreso.getText().trim().isEmpty()&&tFFechaNacimiento.getText().trim().isEmpty()&&
                   tFFechaRetiro.getText().trim().isEmpty()&&tFNombre1.getText().trim().isEmpty()&&tFNumeroIdentificacion.getText().trim().isEmpty()&&tFTelefonoPersonal.getText().trim().isEmpty()&&tFUsuario.getText().trim().isEmpty()&&
                   tfNombre2.getText().trim().isEmpty()&&cBCargo.getSelectedItem().toString().trim().isEmpty()&&cBCiudadPersona.getSelectedItem().toString().trim().isEmpty()&&cBDocumento.getSelectedItem().toString().trim().isEmpty()&&
                   cBRegional.getSelectedItem().toString().trim().isEmpty()&&cBSalario.getSelectedItem().toString().trim().isEmpty()&&cBDocumento.getSelectedItem().equals("-")&&cBCargo.getSelectedItem().equals("-")&&cBCiudadPersona.getSelectedItem().equals("-")
                   &&cBRegional.getSelectedItem().equals("-");
        }catch(Exception e){
            System.out.println("Vista validar vacios "+ e);
        }
        return false;
    }
      
    private void buscarCiudadComboBoxCiudad(){
        try{
            String str1 = tFBuscarCiudad.getText().trim();
            String str2 = str1.substring(0, 1).toUpperCase();
            String str3 = str1.substring(1).toLowerCase();
            String str = str2+str3;
            cBCiudadPersona.removeAllItems();
            LinkedList<Ciudad> ciudades  = controlCiudad.listadoCiudadesRegistradas("%"+str+"%");
            for(Ciudad ciudad :ciudades){
                cBCiudadPersona.addItem(ciudad.getCiudad()+"-"+ciudad.getDepartamento()+"-"+ciudad.getNumCiudad());
            }    
        }catch(Exception e){
         System.out.println("formulario ciudad "+e.getMessage());   
        }
    }
    
    private boolean campoFecha(){
        return true;
//                tFFechaIngreso.getText().matches("\\d{4}-\\d{2}-\\d{2}$")&&tFFechaNacimiento.getText().matches("\\d{4}-\\d{2}-\\d{2}$");
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
            String eMailEmpresa = crearUsuario()+"@empresa.com";
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
        tbContraseña = new javax.swing.JTextField();
        tFEMailEmpresa = new javax.swing.JTextField();
        lBNombre1 = new javax.swing.JLabel();
        lbNombre2 = new javax.swing.JLabel();
        lBApellido1 = new javax.swing.JLabel();
        lBApellido2 = new javax.swing.JLabel();
        lBTipoDocumento = new javax.swing.JLabel();
        lBNumeroDocumento = new javax.swing.JLabel();
        LBFechaNacimiento = new javax.swing.JLabel();
        lBDireccion = new javax.swing.JLabel();
        lBCiudad = new javax.swing.JLabel();
        lBRegional = new javax.swing.JLabel();
        lBTelefonoPersonal = new javax.swing.JLabel();
        lBEMailPersona = new javax.swing.JLabel();
        JBGrabar = new javax.swing.JButton();
        lBFechaIngreso = new javax.swing.JLabel();
        lBFechaRetiro = new javax.swing.JLabel();
        lBCargo = new javax.swing.JLabel();
        lBSalario = new javax.swing.JLabel();
        lBIdEmpleado = new javax.swing.JLabel();
        lBusuarioEmpleado = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lbEMailEmpresa = new javax.swing.JLabel();
        tFBuscarCiudad = new javax.swing.JTextField();
        jBtBuscar = new javax.swing.JButton();
        jBEditar = new javax.swing.JButton();
        jBActualizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setEnabled(false);
        setFocusCycleRoot(false);
        setFocusable(false);
        setMaximumSize(new java.awt.Dimension(545, 900));
        setMinimumSize(new java.awt.Dimension(545, 900));
        setPreferredSize(new java.awt.Dimension(1000, 590));
        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);

        tfNombre2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfNombre2KeyTyped(evt);
            }
        });

        tFApellido1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tFApellido1KeyTyped(evt);
            }
        });

        tFApellido2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tFApellido2KeyTyped(evt);
            }
        });

        tFNombre1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tFNombre1KeyTyped(evt);
            }
        });

        cBDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Cedula", "C.Extangeria", "T.Identidad", "Pasaporte" }));

        tFNumeroIdentificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tFNumeroIdentificacionKeyTyped(evt);
            }
        });

        tFFechaNacimiento.setText("DD-MM-AAAA");
        tFFechaNacimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tFFechaNacimientoKeyTyped(evt);
            }
        });

        tFDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tFDireccionKeyTyped(evt);
            }
        });

        tFTelefonoPersonal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tFTelefonoPersonalKeyTyped(evt);
            }
        });

        tFEMailPersona.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tFEMailPersonaKeyTyped(evt);
            }
        });

        cBRegional.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Norte", "Sur", "Oriente", "Occidente" }));

        tFFechaIngreso.setText("DD-MM-AAAA");
        tFFechaIngreso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tFFechaIngresoKeyTyped(evt);
            }
        });

        tFFechaRetiro.setEditable(false);
        tFFechaRetiro.setText("AA-MM-AAAA");
        tFFechaRetiro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tFFechaRetiroKeyTyped(evt);
            }
        });

        cBCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Tecnico", "Analista", "Mensajero" }));

        cBSalario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "1 SMLV", "1.5 SMLV", "2 SMLV" }));

        tFEmpleadoId.setEditable(false);

        tFUsuario.setEditable(false);

        tbContraseña.setEditable(false);

        tFEMailEmpresa.setEditable(false);

        lBNombre1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lBNombre1.setText("NOMBRE");

        lbNombre2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNombre2.setText("NOMBRE ");

        lBApellido1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lBApellido1.setText("APELLIDO ");

        lBApellido2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lBApellido2.setText("APELLIDO");

        lBTipoDocumento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lBTipoDocumento.setText("TIPO DOCUMENTO");

        lBNumeroDocumento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lBNumeroDocumento.setText("NUMERO DOCUMENTO");

        LBFechaNacimiento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LBFechaNacimiento.setText("FECHA NACIMIENTO");

        lBDireccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lBDireccion.setText("DIRECCION");

        lBCiudad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lBCiudad.setText("CIUDAD");

        lBRegional.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lBRegional.setText("REGIONAL");

        lBTelefonoPersonal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lBTelefonoPersonal.setText("TELEFONO PER.");

        lBEMailPersona.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lBEMailPersona.setText("E-MAIL PERS.");

        JBGrabar.setText("REGISTRAR");
        JBGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBGrabarActionPerformed(evt);
            }
        });

        lBFechaIngreso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lBFechaIngreso.setText("FECHA INGRESO");

        lBFechaRetiro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lBFechaRetiro.setText("FECHA RETIRO");

        lBCargo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lBCargo.setText("CARGO");

        lBSalario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lBSalario.setText("SALARIO");

        lBIdEmpleado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lBIdEmpleado.setText("ID EMPLEADO");

        lBusuarioEmpleado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lBusuarioEmpleado.setText("USUARIO EMPLEADO");

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("CONTRASEÑA");

        lbEMailEmpresa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbEMailEmpresa.setText("E-MAIL EMPRESA");

        tFBuscarCiudad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tFBuscarCiudadKeyTyped(evt);
            }
        });

        jBtBuscar.setText("BUSCAR");
        jBtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtBuscarActionPerformed(evt);
            }
        });

        jBEditar.setText("EDITAR");
        jBEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditarActionPerformed(evt);
            }
        });

        jBActualizar.setText("ACTUALIZAR");
        jBActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lBCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lBEMailPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(tFBuscarCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lBRegional, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lBTelefonoPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cBCiudadPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cBRegional, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(tFTelefonoPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(tFEMailPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lBIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lBusuarioEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(tFEmpleadoId, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tFUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(JBGrabar)
                                                .addGap(18, 18, 18)
                                                .addComponent(jBtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbEMailEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jBEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(14, 14, 14)
                                                .addComponent(jBActualizar))
                                            .addComponent(tbContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(tFEMailEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lBTipoDocumento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tFNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lBNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lBNumeroDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(LBFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(tfNombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(tFApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbNombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lBApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tFApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lBDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lBApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lBFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lBFechaRetiro, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lBCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lBSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tFFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tFFechaRetiro, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cBCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cBSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lBNombre1)
                    .addComponent(lbNombre2)
                    .addComponent(lBApellido1)
                    .addComponent(lBApellido2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tFNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNombre2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tFApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tFApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lBTipoDocumento)
                    .addComponent(lBNumeroDocumento)
                    .addComponent(LBFechaNacimiento)
                    .addComponent(lBDireccion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cBDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tFNumeroIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tFFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tFDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lBRegional, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lBCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lBTelefonoPersonal)
                        .addComponent(lBEMailPersona)
                        .addComponent(tFBuscarCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cBCiudadPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cBRegional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tFTelefonoPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tFEMailPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lBFechaIngreso)
                    .addComponent(lBFechaRetiro)
                    .addComponent(lBCargo)
                    .addComponent(lBSalario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tFFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tFFechaRetiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cBCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cBSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lBIdEmpleado)
                    .addComponent(lBusuarioEmpleado)
                    .addComponent(jLabel20)
                    .addComponent(lbEMailEmpresa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tFEmpleadoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tFUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tFEMailEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBGrabar)
                    .addComponent(jBtBuscar)
                    .addComponent(jBEditar)
                    .addComponent(jBActualizar))
                .addGap(40, 40, 40))
        );

        lBIdEmpleado.getAccessibleContext().setAccessibleParent(tFEmpleadoId);
        lBusuarioEmpleado.getAccessibleContext().setAccessibleParent(tFUsuario);
        jLabel20.getAccessibleContext().setAccessibleParent(tbContraseña);
        lbEMailEmpresa.getAccessibleContext().setAccessibleParent(tbContraseña);

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel1.setText("GESTION EMPLEADOS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(273, 273, 273)
                .addComponent(jLabel1))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBGrabarActionPerformed
        try{    
            if (ValidarVacios()==true){
                JOptionPane.showMessageDialog(null,"Datos incompletos");            
            }if(!campoFecha()==true){
                JOptionPane.showMessageDialog(null,"Formato incorrectos");
                } else {
                tFEmpleadoId.setText(crearEmpeadoId());
                tFUsuario.setText(crearUsuario());
                tbContraseña.setText(crearClaveUsuario());
                tFEMailEmpresa.setText(crearCorreoEmpresa());
                controlEmpleado.crearEmpleado(this.crearNuevoEmpleado());
                int opcion = this.mensajeConfirmacionEmpleado("Creado",crearNuevoEmpleado());
                    if(opcion == 0){              
                    controlEmpleado.crearEmpleado(crearNuevoEmpleado());
                    limpiarFormulario();
                    }
                }    
            }catch(Exception e){
                System.out.println("btGrbar "+e.getMessage());  
            }
    }//GEN-LAST:event_JBGrabarActionPerformed

    private void limpiarFormulario(){
        try{
            tFApellido1.setText("");
            tFApellido2.setText("");
            tFBuscarCiudad.setText("");
            tFDireccion.setText("");
            tFEMailEmpresa.setText("");
            tFEMailPersona.setText("");
            tFEmpleadoId.setText("");
            tFFechaIngreso.setText("DD-MM-AAA");
            tFFechaNacimiento.setText("DD-MM-AAA");
            tFFechaRetiro.setText("DD-MM-AAA");
            tFFechaRetiro.setEnabled(false);
            tFNombre1.setText("");
            tFNumeroIdentificacion.setText("");
            tFTelefonoPersonal.setText("");
            tFUsuario.setText("");
            tfNombre2.setText("");
            tbContraseña.setText("");
            cBCargo.setSelectedItem("-");
            cBCiudadPersona.setSelectedItem("-");
            cBDocumento.setSelectedItem("-");
            cBRegional.setSelectedItem("-");
            cBSalario.setSelectedItem("-");
        }catch(Exception e){
                System.out.println("Vista limpiar "+e.getMessage());
                }    
    }
    
    private void bloquearFormulario(boolean str){
        try{
            tFApellido1.setEnabled(str);
            tFApellido2.setEnabled(str);
            tFBuscarCiudad.setEnabled(str);
            tFDireccion.setEnabled(str);
            tFEMailEmpresa.setEnabled(str);
            tFEMailPersona.setEnabled(str);
            tFEmpleadoId.setEnabled(str);
            tFFechaIngreso.setEnabled(str);
            tFFechaNacimiento.setEnabled(str);
            tFFechaRetiro.setEnabled(str);
            tFNombre1.setEnabled(str);
            tFNumeroIdentificacion.setEnabled(str);
            tFTelefonoPersonal.setEnabled(str);
            tFUsuario.setEnabled(str);
            tfNombre2.setEnabled(str);
            tbContraseña.setEnabled(str);
            cBCargo.setEnabled(str);
            cBCiudadPersona.setEnabled(str);
            cBDocumento.setEnabled(str);
            cBRegional.setEnabled(str);
            cBSalario.setEnabled(str);
        }catch(Exception e){
            System.out.println("Vista bloquear "+e.getMessage());
        }    
    }
    
    public int mensajeConfirmacionEmpleado(String str,Empleado em) {
        int mensaje = JOptionPane.showConfirmDialog(null,"Se a" +str+" un empleado:"+
                em.getNombre1()+" - "+em.getNombre2()+"\n"+em.getApellido1()+" - "+em.getApellido2()+
                "\n"+em.geteMail()+" - "+em.getTipoIdPersona()+"\n"+em.getNumeroIdPersona()+" - "+
                em.getTelefono()+"\n"+ em.getFechaNacimiento()+" - "+em.getDireccion()+"\n"+em.getCiudad().getCiudad()+" - "+
                em.getRegional()+"\n"+em.getCargo()+" - "+em.getSalario()+"\n"+em.getFechaIngreso()+" - "+
                em.getEmpleadoId()+"\n"+em.getUsuario()+" - "+em.getCorreoEmpresarial());
        return mensaje;
    }
    
    private void tFNombre1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tFNombre1KeyTyped
        if(tFNombre1.getText().length() >= 20)
        {
        evt.consume();
        }
        int key = evt.getKeyChar();

        boolean mayusculas = key >= 65 && key <= 90;
        boolean minusculas = key >= 97 && key <= 122;
        boolean espacio = key == 32;

        if (!(minusculas || mayusculas || espacio))
       {
           evt.consume();
       }
    }//GEN-LAST:event_tFNombre1KeyTyped

    private void tfNombre2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNombre2KeyTyped
        if(tfNombre2.getText().length() >= 20)
    {
        evt.consume();
    }
        int key = evt.getKeyChar();

        boolean mayusculas = key >= 65 && key <= 90;
        boolean minusculas = key >= 97 && key <= 122;
        boolean espacio = key == 32;

        if (!(minusculas || mayusculas || espacio))
       {
           evt.consume();
       }
    }//GEN-LAST:event_tfNombre2KeyTyped

    private void tFApellido1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tFApellido1KeyTyped
        if(tFApellido1.getText().length() >= 20)
    {
        evt.consume();
    }
        int key = evt.getKeyChar();

        boolean mayusculas = key >= 65 && key <= 90;
        boolean minusculas = key >= 97 && key <= 122;
        boolean espacio = key == 32;

        if (!(minusculas || mayusculas || espacio))
       {
           evt.consume();
       }
    }//GEN-LAST:event_tFApellido1KeyTyped

    private void tFApellido2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tFApellido2KeyTyped
         if(tFApellido2.getText().length() >= 20)
    {
        evt.consume();
    }
         int key = evt.getKeyChar();

        boolean mayusculas = key >= 65 && key <= 90;
        boolean minusculas = key >= 97 && key <= 122;
        boolean espacio = key == 32;

        if (!(minusculas || mayusculas || espacio))
       {
           evt.consume();
       }
    }//GEN-LAST:event_tFApellido2KeyTyped

    private void tFNumeroIdentificacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tFNumeroIdentificacionKeyTyped
         if(tFNumeroIdentificacion.getText().length() >= 20)
    {
        evt.consume();
    }  
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;
        
        if (!numeros)
        {
            evt.consume();
        }
        if (tFNombre1.getText().trim().length() == 10) {
            evt.consume();
        }
    }//GEN-LAST:event_tFNumeroIdentificacionKeyTyped

    private void tFDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tFDireccionKeyTyped
         if(tFDireccion.getText().length() >= 20)
    {
        evt.consume();
    }
    }//GEN-LAST:event_tFDireccionKeyTyped

    private void tFTelefonoPersonalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tFTelefonoPersonalKeyTyped
        if(tFTelefonoPersonal.getText().length() >= 10)
    {
        evt.consume();
    }
        
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;
        
        if (!numeros)
        {
            evt.consume();
        }
        if (tFNombre1.getText().trim().length() == 10) {
            evt.consume();
        }
    }//GEN-LAST:event_tFTelefonoPersonalKeyTyped

    private void tFEMailPersonaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tFEMailPersonaKeyTyped
         if(tFEMailPersona.getText().length() >= 20)
    {
        evt.consume();
    }
    }//GEN-LAST:event_tFEMailPersonaKeyTyped

    private void tFFechaNacimientoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tFFechaNacimientoKeyTyped
        if(tFApellido2.getText().length() >= 10)
            {
        evt.consume();
        }
    }//GEN-LAST:event_tFFechaNacimientoKeyTyped

    private void tFFechaIngresoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tFFechaIngresoKeyTyped
        if(tFApellido2.getText().length() >= 10)
            {
        evt.consume();
        }
    }//GEN-LAST:event_tFFechaIngresoKeyTyped

    private void tFFechaRetiroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tFFechaRetiroKeyTyped
        if(tFApellido2.getText().length() >= 10){
        evt.consume();
        }
    }//GEN-LAST:event_tFFechaRetiroKeyTyped

    private void tFBuscarCiudadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tFBuscarCiudadKeyTyped
        buscarCiudadComboBoxCiudad();
    }//GEN-LAST:event_tFBuscarCiudadKeyTyped

    private void jBtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtBuscarActionPerformed
        try{
            String str = tFNumeroIdentificacion.getText();
            Empleado empleado = controlEmpleado.buscarEmpleado(str);
            int mensaje = this.mensajeConfirmacionEmpleado("encontrado", empleado);
            if(mensaje==0){
                cargarEmpleado(empleado);
                buscarCiudadComboBoxCiudad();
                bloquearFormulario(false);
                JBGrabar.setEnabled(false);
                jBEditar.setEnabled(true);
            }else{
            this.limpiarFormulario();
            }
        }catch(Exception e){
            System.out.println("Vista "+e.getMessage());
        }
    }//GEN-LAST:event_jBtBuscarActionPerformed

    private void jBEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditarActionPerformed
        try{
            Empleado em = crearNuevoEmpleado();
            int mensaje = JOptionPane.showInternalConfirmDialog(null, " ¿Desea actualizar la informacion ?");
            if(mensaje == 0){
                bloquearFormulario(true);
                cBDocumento.setEnabled(false);
                tFNumeroIdentificacion.setEnabled(false);
                tFFechaNacimiento.setEnabled(false);
                tFFechaIngreso.setEnabled(false);
                tFFechaRetiro.setEnabled(false);
                tFEmpleadoId.setEnabled(false);
                tFUsuario.setEnabled(false);
                tbContraseña.setEnabled(false);
                tFEMailEmpresa.setEnabled(false);
                jBActualizar.setEnabled(true);
                jBtBuscar.setEnabled(false);
            }else{
                bloquearFormulario(true);
                limpiarFormulario();    
                jBEditar.setEnabled(false);
                JBGrabar.setEnabled(true);
            }
            controlEmpleado.actualizarEmpleado(em);
        }catch(Exception e){
            System.out.println("Vista "+e.getMessage());
        }
    }//GEN-LAST:event_jBEditarActionPerformed

    private void jBActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActualizarActionPerformed
        try{
            Empleado empleado = crearNuevoEmpleado();
            int mensaje = mensajeConfirmacionEmpleado("Actualizara", empleado);
            if(mensaje==0){
                boolean actualizar = controlEmpleado.actualizarEmpleado(empleado);
                if(actualizar){
                    JOptionPane.showInternalConfirmDialog(null,"El empleado se actualizo correctamente");
                }
            }  
        }catch(Exception e){
            System.out.println("Vista "+e.getMessage());
            JOptionPane.showInternalConfirmDialog(null,"No se logro actualizar el Empleado");
        }
    }//GEN-LAST:event_jBActualizarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBGrabar;
    private javax.swing.JLabel LBFechaNacimiento;
    private javax.swing.JComboBox<String> cBCargo;
    private javax.swing.JComboBox<String> cBCiudadPersona;
    private javax.swing.JComboBox<String> cBDocumento;
    private javax.swing.JComboBox<String> cBRegional;
    private javax.swing.JComboBox<String> cBSalario;
    private javax.swing.JButton jBActualizar;
    private javax.swing.JButton jBEditar;
    private javax.swing.JButton jBtBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lBApellido1;
    private javax.swing.JLabel lBApellido2;
    private javax.swing.JLabel lBCargo;
    private javax.swing.JLabel lBCiudad;
    private javax.swing.JLabel lBDireccion;
    private javax.swing.JLabel lBEMailPersona;
    private javax.swing.JLabel lBFechaIngreso;
    private javax.swing.JLabel lBFechaRetiro;
    private javax.swing.JLabel lBIdEmpleado;
    private javax.swing.JLabel lBNombre1;
    private javax.swing.JLabel lBNumeroDocumento;
    private javax.swing.JLabel lBRegional;
    private javax.swing.JLabel lBSalario;
    private javax.swing.JLabel lBTelefonoPersonal;
    private javax.swing.JLabel lBTipoDocumento;
    private javax.swing.JLabel lBusuarioEmpleado;
    private javax.swing.JLabel lbEMailEmpresa;
    private javax.swing.JLabel lbNombre2;
    private javax.swing.JTextField tFApellido1;
    private javax.swing.JTextField tFApellido2;
    private javax.swing.JTextField tFBuscarCiudad;
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
    private javax.swing.JTextField tbContraseña;
    private javax.swing.JTextField tfNombre2;
    // End of variables declaration//GEN-END:variables
}
