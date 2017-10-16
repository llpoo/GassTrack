/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.view.principal;

import br.com.gt.view.lookandfeel.JFrameLAF;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author lucas
 */
public class PrincipalGerenteView extends JFrameLAF{

    public JButton getAlterarAcessoBtn() {
        return alterarAcessoBtn;
    }

    public void setAlterarAcessoBtn(JButton alterarAcessoBtn) {
        this.alterarAcessoBtn = alterarAcessoBtn;
    }

    public void setMostrarAcessorioBtn(JButton mostrarAcessorioBtn) {
        this.mostrarAcessorioBtn = mostrarAcessorioBtn;
    }

    public JButton getMostrarMaterialBtn() {
        return mostrarMaterialBtn;
    }

    public void setMostrarMaterialBtn(JButton mostrarMaterialBtn) {
        this.mostrarMaterialBtn = mostrarMaterialBtn;
    }

    public JButton getMostrarAcessorioBtn() {
        return mostrarAcessorioBtn;
    }
    
    public JButton getAlterarAcessorioBtn() {
        return alterarAcessorioBtn;
    }

    public void setAlterarAcessorioBtn(JButton alterarAcessorioBtn) {
        this.alterarAcessorioBtn = alterarAcessorioBtn;
    }

    public JButton getAlterarMaterialBtn() {
        return alterarMaterialBtn;
    }

    public void setAlterarMaterialBtn(JButton alterarMaterialBtn) {
        this.alterarMaterialBtn = alterarMaterialBtn;
    }

    public JButton getExcluirAcessorioBtn() {
        return excluirAcessorioBtn;
    }

    public void setExcluirAcessorioBtn(JButton excluirAcessorioBtn) {
        this.excluirAcessorioBtn = excluirAcessorioBtn;
    }

    public JButton getExcluirMaterialBtn() {
        return excluirMaterialBtn;
    }

    public void setExcluirMaterialBtn(JButton excluirMaterialBtn) {
        this.excluirMaterialBtn = excluirMaterialBtn;
    }

    public JTable getMaterialTable() {
        return materialTable;
    }

    public void setMaterialTable(JTable materialTable) {
        this.materialTable = materialTable;
    }

    public JCheckBox getMaterial_baixaSelectBox() {
        return material_baixaSelectBox;
    }

    public void setMaterial_baixaSelectBox(JCheckBox material_baixaSelectBox) {
        this.material_baixaSelectBox = material_baixaSelectBox;
    }

    public JButton getNovoItemBtn() {
        return novoItemBtn;
    }

    public void setNovoItemBtn(JButton novoItemBtn) {
        this.novoItemBtn = novoItemBtn;
    }

    public JButton getPesquisarItemBtn() {
        return pesquisarItemBtn;
    }

    public void setPesquisarItemBtn(JButton pesquisarItemBtn) {
        this.pesquisarItemBtn = pesquisarItemBtn;
    }

    public JTextField getItemTxt() {
        return itemTxt;
    }

    public void setItemTxt(JTextField itemTxt) {
        this.itemTxt = itemTxt;
    }
        
    public JButton getMostrarClienteBtn() {
        return mostrarClienteBtn;
    }

    public void setMostrarClienteBtn(JButton mostrarClienteBtn) {
        this.mostrarClienteBtn = mostrarClienteBtn;
    }

    public JButton getAddAceEstoqueBtn() {
        return addAceEstoqueBtn;
    }

    public void setAddAceEstoqueBtn(JButton addAceEstoqueBtn) {
        this.addAceEstoqueBtn = addAceEstoqueBtn;
    }

    public JButton getAddMatEstoqueBtn() {
        return addMatEstoqueBtn;
    }

    public void setAddMatEstoqueBtn(JButton addMatEstoqueBtn) {
        this.addMatEstoqueBtn = addMatEstoqueBtn;
    }
    
    public JButton getMostrarFuncionarioBtn() {
        return mostrarFuncionarioBtn;
    }

    public void setMostrarFuncionarioBtn(JButton mostrarFuncionarioBtn) {
        this.mostrarFuncionarioBtn = mostrarFuncionarioBtn;
    }
    
    public JButton getClientes_novoBtn() {
        return clientes_novoBtn;
    }

    public void setClientes_novoBtn(JButton clientes_novoBtn) {
        this.clientes_novoBtn = clientes_novoBtn;
    }
    
    
    public JButton getExcluirFornecedorBtn() {
        return excluirFornecedorBtn;
    }

    public void setExcluirFornecedorBtn(JButton excluirFornecedorBtn) {
        this.excluirFornecedorBtn = excluirFornecedorBtn;
    }
   
    public JTable getAcessorioTable() {
        return acessorioTable;
    }

    public JCheckBox getAcessorio_baixaSelectBox() {
        return acessorio_baixaSelectBox;
    }

    public JButton getAlterarClienteBtn() {
        return alterarClienteBtn;
    }

    public JTable getClienteTable() {
        return clienteTable;
    }

    public JButton getClientes_clienteBuscaBtn() {
        return clientes_clienteBuscaBtn;
    }

    public JTextField getClientes_clienteTxt() {
        return clientes_clienteTxt;
    }

    public JButton getExcluirClienteBtn() {
        return excluirClienteBtn;
    }

    public JButton getFornecedorBuscaBtn() {
        return fornecedorBuscaBtn;
    }

    public JTable getFornecedorTable() {
        return fornecedorTable;
    }

    public JTextField getFornecedorTxt() {
        return fornecedorTxt;
    }

    public JButton getNovoFornecedorBtn() {
        return novoFornecedorBtn;
    }

    public JButton getSairBtn() {
        return sairBtn;
    }

    public JTable getVendasTable() {
        return vendasTable;
    }

    public JButton getVendas_clienteBuscaBtn() {
        return vendas_filtrarPorVendedorBtn;
    }

    public JTextField getVendas_clienteTxt() {
        return vendas_clienteTxt;
    }

    public JButton getFiltrarVendasBtn() {
        return vendas_filtrarPorVendedorBtn;
    }
    
    public JTextField getVendas_vendedorTxt() {
        return vendas_vendedorTxt;
    }

    public JTable getFuncionarioTable() {
        return funcionarioTable;
    }

    public void setFuncionarioTable(JTable funcionarioTable) {
        this.funcionarioTable = funcionarioTable;
    }

    public JTextField getDataChooser() {
        return dataChooser;
    }

    public JButton getVendas_FiltrarPorDataBtn() {
        return vendas_FiltrarPorDataBtn;
    }

    public JButton getVendas_filtrarPorClienteBtn() {
        return vendas_FiltrarPorClienteBtn;
    }

    public JButton getVendas_filtrarPorVendedorBtn() {
        return vendas_filtrarPorVendedorBtn;
    }

    public JButton getAlterarFornecedorBtn() {
        return alterarFornecedorBtn;
    }

    public void setAlterarFornecedorBtn(JButton alterarFornecedorBtn) {
        this.alterarFornecedorBtn = alterarFornecedorBtn;
    }

    public JButton getAlterarFuncionarioBtn() {
        return alterarFuncionarioBtn;
    }

    public void setAlterarFuncionarioBtn(JButton alterarFuncionarioBtn) {
        this.alterarFuncionarioBtn = alterarFuncionarioBtn;
    }

    public JButton getExcluirFuncionarioBtn() {
        return excluirFuncionarioBtn;
    }

    public void setExcluirFuncionarioBtn(JButton excluirFuncionarioBtn) {
        this.excluirFuncionarioBtn = excluirFuncionarioBtn;
    }

    public JButton getFuncionarios_BuscaBtn() {
        return funcionarios_BuscaBtn;
    }

    public void setFuncionarios_BuscaBtn(JButton funcionarios_BuscaBtn) {
        this.funcionarios_BuscaBtn = funcionarios_BuscaBtn;
    }

    public JTextField getFuncionarios_funcionarioTxt() {
        return funcionarios_funcionarioTxt;
    }

    public void setFuncionarios_funcionarioTxt(JTextField funcionarios_funcionarioTxt) {
        this.funcionarios_funcionarioTxt = funcionarios_funcionarioTxt;
    }

    public JButton getFuncionarios_novoBtn() {
        return funcionarios_novoBtn;
    }

    public void setFuncionarios_novoBtn(JButton funcionarios_novoBtn) {
        this.funcionarios_novoBtn = funcionarios_novoBtn;
    }

    public JButton getMostrarFornecedorBtn() {
        return mostrarFornecedorBtn;
    }

    public void setMostrarFornecedorBtn(JButton mostrarFornecedorBtn) {
        this.mostrarFornecedorBtn = mostrarFornecedorBtn;
    }
    
    
    
    
    public PrincipalGerenteView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filtroVendaGroup = new javax.swing.ButtonGroup();
        jPanel5 = new javax.swing.JPanel();
        sairBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        alterarAcessoBtn = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        dashboardPanel = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        vendasPanel = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        vendas_vendedorTxt = new javax.swing.JTextField();
        vendas_clienteTxt = new javax.swing.JTextField();
        vendas_filtrarPorVendedorBtn = new javax.swing.JButton();
        dataChooser = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        vendasTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        vendas_FiltrarPorClienteBtn = new javax.swing.JButton();
        vendas_FiltrarPorDataBtn = new javax.swing.JButton();
        vendedoresPanel = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        funcionarioTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        funcionarios_funcionarioTxt = new javax.swing.JTextField();
        funcionarios_BuscaBtn = new javax.swing.JButton();
        funcionarios_novoBtn = new javax.swing.JButton();
        alterarFuncionarioBtn = new javax.swing.JButton();
        excluirFuncionarioBtn = new javax.swing.JButton();
        mostrarFuncionarioBtn = new javax.swing.JButton();
        clientesPanel = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        clienteTable = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        clientes_clienteTxt = new javax.swing.JTextField();
        clientes_clienteBuscaBtn = new javax.swing.JButton();
        excluirClienteBtn = new javax.swing.JButton();
        alterarClienteBtn = new javax.swing.JButton();
        clientes_novoBtn = new javax.swing.JButton();
        mostrarClienteBtn = new javax.swing.JButton();
        fornecedoresPanel = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        fornecedorTable = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        fornecedorTxt = new javax.swing.JTextField();
        fornecedorBuscaBtn = new javax.swing.JButton();
        excluirFornecedorBtn = new javax.swing.JButton();
        alterarFornecedorBtn = new javax.swing.JButton();
        novoFornecedorBtn = new javax.swing.JButton();
        mostrarFornecedorBtn = new javax.swing.JButton();
        estoquePanel = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        acessorioTable = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        materialTable = new javax.swing.JTable();
        material_baixaSelectBox = new javax.swing.JCheckBox();
        acessorio_baixaSelectBox = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        itemTxt = new javax.swing.JTextField();
        pesquisarItemBtn = new javax.swing.JButton();
        novoItemBtn = new javax.swing.JButton();
        excluirMaterialBtn = new javax.swing.JButton();
        alterarMaterialBtn = new javax.swing.JButton();
        addMatEstoqueBtn = new javax.swing.JButton();
        excluirAcessorioBtn = new javax.swing.JButton();
        alterarAcessorioBtn = new javax.swing.JButton();
        addAceEstoqueBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        mostrarMaterialBtn = new javax.swing.JButton();
        mostrarAcessorioBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("GlassTrack");

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sairBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gt/view/imagens/logout.png"))); // NOI18N
        sairBtn.setText("Sair");
        jPanel5.add(sairBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gt/view/imagens/Gerente.png"))); // NOI18N
        jLabel2.setText("Módulo do Gerente");
        jLabel2.setToolTipText("");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, -1, -1));

        alterarAcessoBtn.setText("Altera acesso");
        jPanel5.add(alterarAcessoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 40, -1, -1));

        jTabbedPane1.setBackground(new java.awt.Color(51, 51, 51));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        dashboardPanel.setBackground(new java.awt.Color(51, 51, 51));
        dashboardPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gt/view/imagens/LogoVidro.png"))); // NOI18N
        dashboardPanel.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 90));

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("BankGothic Md BT", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 153));
        jLabel16.setText("Glass Track");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 153));
        jLabel17.setText("Dashboard");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 20, -1, 20));

        dashboardPanel.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1130, 50));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("GRÁFICOS E RELATÓRIOS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(980, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(445, Short.MAX_VALUE))
        );

        dashboardPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1130, 470));

        jTabbedPane1.addTab("Dashboard", dashboardPanel);

        vendasPanel.setBackground(new java.awt.Color(51, 51, 51));
        vendasPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gt/view/imagens/LogoVidro.png"))); // NOI18N
        vendasPanel.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 90));

        jPanel14.setBackground(new java.awt.Color(0, 153, 153));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("BankGothic Md BT", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 153));
        jLabel18.setText("Glass Track");
        jPanel14.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 153));
        jLabel19.setText("Gerenciamento de Vendas");
        jPanel14.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 20, -1, 20));

        vendasPanel.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1130, 50));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        vendas_filtrarPorVendedorBtn.setText("Buscar");

        vendasTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(vendasTable);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Vendedor");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cliente");

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Data");

        vendas_FiltrarPorClienteBtn.setText("Buscar");

        vendas_FiltrarPorDataBtn.setText("Buscar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(vendas_filtrarPorVendedorBtn)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(vendas_vendedorTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(vendas_clienteTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(vendas_FiltrarPorClienteBtn))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dataChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(vendas_FiltrarPorDataBtn))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vendas_vendedorTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vendas_clienteTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vendas_filtrarPorVendedorBtn)
                    .addComponent(vendas_FiltrarPorClienteBtn)
                    .addComponent(vendas_FiltrarPorDataBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE))
        );

        vendasPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1120, 470));

        jTabbedPane1.addTab("Vendas", vendasPanel);

        vendedoresPanel.setBackground(new java.awt.Color(51, 51, 51));
        vendedoresPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gt/view/imagens/LogoVidro.png"))); // NOI18N
        vendedoresPanel.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 90));

        jPanel15.setBackground(new java.awt.Color(0, 153, 153));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("BankGothic Md BT", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 153));
        jLabel20.setText("Glass Track");
        jPanel15.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        jLabel21.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 153));
        jLabel21.setText("Gerenciamento de Vendedores");
        jPanel15.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 20, -1, 20));

        vendedoresPanel.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1130, 50));

        jPanel11.setBackground(new java.awt.Color(51, 51, 51));

        funcionarioTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        funcionarioTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                funcionarioTableMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                funcionarioTableMouseEntered(evt);
            }
        });
        jScrollPane7.setViewportView(funcionarioTable);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Funcionário");

        funcionarios_BuscaBtn.setText("Pesquisar");

        funcionarios_novoBtn.setText("Novo");
        funcionarios_novoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                funcionarios_novoBtnActionPerformed(evt);
            }
        });

        alterarFuncionarioBtn.setText("Alterar");

        excluirFuncionarioBtn.setText("Excluir");

        mostrarFuncionarioBtn.setText("Ver Detalhes");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 1110, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(funcionarios_funcionarioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(funcionarios_BuscaBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mostrarFuncionarioBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(funcionarios_novoBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(alterarFuncionarioBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(excluirFuncionarioBtn))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(funcionarios_funcionarioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(funcionarios_BuscaBtn)
                    .addComponent(excluirFuncionarioBtn)
                    .addComponent(alterarFuncionarioBtn)
                    .addComponent(funcionarios_novoBtn)
                    .addComponent(mostrarFuncionarioBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE))
        );

        vendedoresPanel.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 1110, 470));

        jTabbedPane1.addTab("Funcionários", vendedoresPanel);

        clientesPanel.setBackground(new java.awt.Color(51, 51, 51));
        clientesPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gt/view/imagens/LogoVidro.png"))); // NOI18N
        clientesPanel.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 90));

        jPanel16.setBackground(new java.awt.Color(0, 153, 153));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("BankGothic Md BT", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 153));
        jLabel22.setText("Glass Track");
        jPanel16.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        jLabel23.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 153));
        jLabel23.setText("Gerenciamento de Clientes");
        jPanel16.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 20, -1, 20));

        clientesPanel.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1130, 50));

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));

        clienteTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(clienteTable);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cliente");

        clientes_clienteBuscaBtn.setText("Pesquisar");

        excluirClienteBtn.setText("Excluir");

        alterarClienteBtn.setText("Alterar");

        clientes_novoBtn.setText("Novo");

        mostrarClienteBtn.setText("Ver Detalhes");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(clientes_clienteTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(clientes_clienteBuscaBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mostrarClienteBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 326, Short.MAX_VALUE)
                .addComponent(clientes_novoBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(alterarClienteBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(excluirClienteBtn)
                .addContainerGap())
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(clientes_clienteTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clientes_clienteBuscaBtn)
                    .addComponent(excluirClienteBtn)
                    .addComponent(alterarClienteBtn)
                    .addComponent(clientes_novoBtn)
                    .addComponent(mostrarClienteBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE))
        );

        clientesPanel.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 1110, 470));

        jTabbedPane1.addTab("Clientes", clientesPanel);

        fornecedoresPanel.setBackground(new java.awt.Color(51, 51, 51));
        fornecedoresPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gt/view/imagens/LogoVidro.png"))); // NOI18N
        fornecedoresPanel.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 90));

        jPanel19.setBackground(new java.awt.Color(0, 153, 153));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setBackground(new java.awt.Color(255, 255, 255));
        jLabel27.setFont(new java.awt.Font("BankGothic Md BT", 1, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 153));
        jLabel27.setText("Glass Track");
        jPanel19.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        jLabel34.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 153));
        jLabel34.setText("Gerenciamento de Fornecedores");
        jPanel19.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 20, -1, 20));

        fornecedoresPanel.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1130, 50));

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));

        fornecedorTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(fornecedorTable);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Fornecedor");

        fornecedorBuscaBtn.setText("Pesquisar");

        excluirFornecedorBtn.setText("Excluir");

        alterarFornecedorBtn.setText("Alterar");

        novoFornecedorBtn.setText("Novo");
        novoFornecedorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoFornecedorBtnActionPerformed(evt);
            }
        });

        mostrarFornecedorBtn.setText("Detalhar");
        mostrarFornecedorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarFornecedorBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane4))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fornecedorTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fornecedorBuscaBtn)
                        .addGap(18, 18, 18)
                        .addComponent(mostrarFornecedorBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 316, Short.MAX_VALUE)
                        .addComponent(novoFornecedorBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(alterarFornecedorBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(excluirFornecedorBtn)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(fornecedorTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fornecedorBuscaBtn)
                    .addComponent(excluirFornecedorBtn)
                    .addComponent(alterarFornecedorBtn)
                    .addComponent(novoFornecedorBtn)
                    .addComponent(mostrarFornecedorBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                .addContainerGap())
        );

        fornecedoresPanel.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 1110, 470));

        jTabbedPane1.addTab("Fornecedores", fornecedoresPanel);

        estoquePanel.setBackground(new java.awt.Color(51, 51, 51));
        estoquePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gt/view/imagens/LogoVidro.png"))); // NOI18N
        estoquePanel.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 90));

        jPanel17.setBackground(new java.awt.Color(0, 153, 153));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("BankGothic Md BT", 1, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 153));
        jLabel25.setText("Glass Track");
        jPanel17.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        jLabel26.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 153));
        jLabel26.setText("Gerenciamento de Estoque");
        jPanel17.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 20, -1, 20));

        estoquePanel.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1130, 50));

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));

        acessorioTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(acessorioTable);

        materialTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(materialTable);

        material_baixaSelectBox.setBackground(new java.awt.Color(51, 51, 51));
        material_baixaSelectBox.setForeground(new java.awt.Color(255, 255, 255));
        material_baixaSelectBox.setText("Estoque em baixa");

        acessorio_baixaSelectBox.setBackground(new java.awt.Color(51, 51, 51));
        acessorio_baixaSelectBox.setForeground(new java.awt.Color(255, 255, 255));
        acessorio_baixaSelectBox.setText("Estoque em baixa");

        jLabel9.setBackground(new java.awt.Color(51, 51, 51));
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Item");

        pesquisarItemBtn.setText("Pesquisar");

        novoItemBtn.setText("Novo Item");

        excluirMaterialBtn.setText("Excluir");

        alterarMaterialBtn.setText("Alterar");
        alterarMaterialBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarMaterialBtnActionPerformed(evt);
            }
        });

        addMatEstoqueBtn.setText("Adicionar Estoque");

        excluirAcessorioBtn.setText("Excluir");

        alterarAcessorioBtn.setText("Alterar");

        addAceEstoqueBtn.setText("Adicionar Estoque");
        addAceEstoqueBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAceEstoqueBtnActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        mostrarMaterialBtn.setText("Mostrar Detalhes");
        mostrarMaterialBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarMaterialBtnActionPerformed(evt);
            }
        });

        mostrarAcessorioBtn.setText("Mostrar Detalhes");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(itemTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pesquisarItemBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(novoItemBtn))
                    .addComponent(jSeparator1)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(material_baixaSelectBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mostrarMaterialBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addMatEstoqueBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(alterarMaterialBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(excluirMaterialBtn))
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addComponent(acessorio_baixaSelectBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(mostrarAcessorioBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addAceEstoqueBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(alterarAcessorioBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(excluirAcessorioBtn))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(novoItemBtn)
                    .addComponent(jLabel9)
                    .addComponent(itemTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pesquisarItemBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(excluirAcessorioBtn)
                        .addComponent(alterarAcessorioBtn)
                        .addComponent(addAceEstoqueBtn)
                        .addComponent(mostrarAcessorioBtn))
                    .addComponent(material_baixaSelectBox, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(excluirMaterialBtn)
                        .addComponent(alterarMaterialBtn)
                        .addComponent(addMatEstoqueBtn)
                        .addComponent(acessorio_baixaSelectBox)
                        .addComponent(mostrarMaterialBtn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        estoquePanel.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 1110, 470));

        jTabbedPane1.addTab("Estoque", estoquePanel);

        jPanel5.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1130, 620));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void novoFornecedorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoFornecedorBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_novoFornecedorBtnActionPerformed

    private void funcionarios_novoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_funcionarios_novoBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_funcionarios_novoBtnActionPerformed

    private void funcionarioTableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_funcionarioTableMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_funcionarioTableMouseEntered

    private void funcionarioTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_funcionarioTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_funcionarioTableMouseClicked

    private void alterarMaterialBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarMaterialBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alterarMaterialBtnActionPerformed

    private void mostrarFornecedorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarFornecedorBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mostrarFornecedorBtnActionPerformed

    private void mostrarMaterialBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarMaterialBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mostrarMaterialBtnActionPerformed

    private void addAceEstoqueBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAceEstoqueBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addAceEstoqueBtnActionPerformed

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
            java.util.logging.Logger.getLogger(PrincipalGerenteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalGerenteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalGerenteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalGerenteView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalGerenteView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable acessorioTable;
    private javax.swing.JCheckBox acessorio_baixaSelectBox;
    private javax.swing.JButton addAceEstoqueBtn;
    private javax.swing.JButton addMatEstoqueBtn;
    private javax.swing.JButton alterarAcessoBtn;
    private javax.swing.JButton alterarAcessorioBtn;
    private javax.swing.JButton alterarClienteBtn;
    private javax.swing.JButton alterarFornecedorBtn;
    private javax.swing.JButton alterarFuncionarioBtn;
    private javax.swing.JButton alterarMaterialBtn;
    private javax.swing.JTable clienteTable;
    private javax.swing.JPanel clientesPanel;
    private javax.swing.JButton clientes_clienteBuscaBtn;
    private javax.swing.JTextField clientes_clienteTxt;
    private javax.swing.JButton clientes_novoBtn;
    private javax.swing.JPanel dashboardPanel;
    private javax.swing.JTextField dataChooser;
    private javax.swing.JPanel estoquePanel;
    private javax.swing.JButton excluirAcessorioBtn;
    private javax.swing.JButton excluirClienteBtn;
    private javax.swing.JButton excluirFornecedorBtn;
    private javax.swing.JButton excluirFuncionarioBtn;
    private javax.swing.JButton excluirMaterialBtn;
    private javax.swing.ButtonGroup filtroVendaGroup;
    private javax.swing.JButton fornecedorBuscaBtn;
    private javax.swing.JTable fornecedorTable;
    private javax.swing.JTextField fornecedorTxt;
    private javax.swing.JPanel fornecedoresPanel;
    private javax.swing.JTable funcionarioTable;
    private javax.swing.JButton funcionarios_BuscaBtn;
    private javax.swing.JTextField funcionarios_funcionarioTxt;
    private javax.swing.JButton funcionarios_novoBtn;
    private javax.swing.JTextField itemTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable materialTable;
    private javax.swing.JCheckBox material_baixaSelectBox;
    private javax.swing.JButton mostrarAcessorioBtn;
    private javax.swing.JButton mostrarClienteBtn;
    private javax.swing.JButton mostrarFornecedorBtn;
    private javax.swing.JButton mostrarFuncionarioBtn;
    private javax.swing.JButton mostrarMaterialBtn;
    private javax.swing.JButton novoFornecedorBtn;
    private javax.swing.JButton novoItemBtn;
    private javax.swing.JButton pesquisarItemBtn;
    private javax.swing.JButton sairBtn;
    private javax.swing.JPanel vendasPanel;
    private javax.swing.JTable vendasTable;
    private javax.swing.JButton vendas_FiltrarPorClienteBtn;
    private javax.swing.JButton vendas_FiltrarPorDataBtn;
    private javax.swing.JTextField vendas_clienteTxt;
    private javax.swing.JButton vendas_filtrarPorVendedorBtn;
    private javax.swing.JTextField vendas_vendedorTxt;
    private javax.swing.JPanel vendedoresPanel;
    // End of variables declaration//GEN-END:variables
}
