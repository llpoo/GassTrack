/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.view.principal;

import br.com.gt.view.lookandfeel.JFrameLAF;
import com.toedter.calendar.JDateChooser;
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

    public JCheckBox getApenasAtivosCheckBox() {
        return apenasAtivosCheckBox;
    }

    public void setApenasDesativadosCheckBox(JCheckBox apenasDesativadosCheckBox) {
        this.apenasAtivosCheckBox = apenasDesativadosCheckBox;
    }

    
    
    public JTextField getVendas_funcionarioTxt() {
        return vendas_funcionarioTxt;
    }

    public void setVendas_funcionarioTxt(JTextField vendas_funcionarioTxt) {
        this.vendas_funcionarioTxt = vendas_funcionarioTxt;
    }

    public JDateChooser getVendas_DataTxt() {
        return vendas_DataTxt;
    }

    public void setVendas_DataTxt(JDateChooser vendas_DataTxt) {
        this.vendas_DataTxt = vendas_DataTxt;
    }
    
    
    
    
    public JButton getAlterarAcessoBtn() {
        return alterarAcessoBtn;
    }

    public void setAlterarAcessoBtn(JButton alterarAcessoBtn) {
        this.alterarAcessoBtn = alterarAcessoBtn;
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

    public JTextField getItemTxt() {
        return itemTxt;
    }

    public void setItemTxt(JTextField itemTxt) {
        this.itemTxt = itemTxt;
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

    public JTextField getClientes_clienteTxt() {
        return clientes_clienteTxt;
    }

    public JButton getExcluirClienteBtn() {
        return excluirClienteBtn;
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


    public JTextField getVendas_clienteTxt() {
        return vendas_clienteTxt;
    }

    

    public JTable getFuncionarioTable() {
        return funcionarioTable;
    }

    public void setFuncionarioTable(JTable funcionarioTable) {
        this.funcionarioTable = funcionarioTable;
    }

    public JButton getVendas_FiltrarPorDataBtn() {
        return vendas_FiltrarPorDataBtn;
    }

    public JButton getVendas_LimparBtn() {
        return vendas_LimparBtn;
    }

    public void setVendas_LimparBtn(JButton vendas_LimparBtn) {
        this.vendas_LimparBtn = vendas_LimparBtn;
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
        vendasPanel = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        vendas_funcionarioTxt = new javax.swing.JTextField();
        vendas_clienteTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        vendasTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        vendas_FiltrarPorDataBtn = new javax.swing.JButton();
        vendas_DataTxt = new com.toedter.calendar.JDateChooser();
        vendas_LimparBtn = new javax.swing.JButton();
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
        funcionarios_novoBtn = new javax.swing.JButton();
        alterarFuncionarioBtn = new javax.swing.JButton();
        excluirFuncionarioBtn = new javax.swing.JButton();
        apenasAtivosCheckBox = new javax.swing.JCheckBox();
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
        excluirClienteBtn = new javax.swing.JButton();
        alterarClienteBtn = new javax.swing.JButton();
        clientes_novoBtn = new javax.swing.JButton();
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
        excluirFornecedorBtn = new javax.swing.JButton();
        alterarFornecedorBtn = new javax.swing.JButton();
        novoFornecedorBtn = new javax.swing.JButton();
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
        novoItemBtn = new javax.swing.JButton();
        excluirMaterialBtn = new javax.swing.JButton();
        alterarMaterialBtn = new javax.swing.JButton();
        addMatEstoqueBtn = new javax.swing.JButton();
        excluirAcessorioBtn = new javax.swing.JButton();
        alterarAcessorioBtn = new javax.swing.JButton();
        addAceEstoqueBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("GlassTrack");
        setResizable(false);

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
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, -1, -1));

        alterarAcessoBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gt/view/imagens/alterarAcesso.png"))); // NOI18N
        alterarAcessoBtn.setText("Altera acesso");
        alterarAcessoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarAcessoBtnActionPerformed(evt);
            }
        });
        jPanel5.add(alterarAcessoBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 10, -1, -1));

        jTabbedPane1.setBackground(new java.awt.Color(51, 51, 51));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

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

        vendasTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(vendasTable);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Funcionário");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cliente");

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Data");

        vendas_FiltrarPorDataBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gt/view/imagens/lupa.png"))); // NOI18N
        vendas_FiltrarPorDataBtn.setText("Buscar por Data");

        vendas_DataTxt.setBackground(new java.awt.Color(51, 51, 51));

        vendas_LimparBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gt/view/imagens/Cancelar.png"))); // NOI18N
        vendas_LimparBtn.setText("LimparCampos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(vendas_funcionarioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(vendas_clienteTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(vendas_DataTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(vendas_LimparBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(vendas_FiltrarPorDataBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(vendas_funcionarioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(vendas_clienteTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jLabel10))
                    .addComponent(vendas_DataTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vendas_FiltrarPorDataBtn))
                .addGap(11, 11, 11)
                .addComponent(vendas_LimparBtn)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE))
        );

        vendasPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1120, 470));

        jTabbedPane1.addTab("Vendas", new javax.swing.ImageIcon(getClass().getResource("/br/com/gt/view/imagens/vendas.png")), vendasPanel); // NOI18N

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

        funcionarios_novoBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gt/view/imagens/novoCliente.png"))); // NOI18N
        funcionarios_novoBtn.setText("Novo");
        funcionarios_novoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                funcionarios_novoBtnActionPerformed(evt);
            }
        });

        alterarFuncionarioBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gt/view/imagens/teste.png"))); // NOI18N
        alterarFuncionarioBtn.setText("Alterar");

        excluirFuncionarioBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gt/view/imagens/Cancelar.png"))); // NOI18N
        excluirFuncionarioBtn.setText("Desativar");
        excluirFuncionarioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirFuncionarioBtnActionPerformed(evt);
            }
        });

        apenasAtivosCheckBox.setBackground(new java.awt.Color(51, 51, 51));
        apenasAtivosCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        apenasAtivosCheckBox.setText("Apenas funcionários ativos");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(funcionarios_funcionarioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(apenasAtivosCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 212, Short.MAX_VALUE)
                .addComponent(funcionarios_novoBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(alterarFuncionarioBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(excluirFuncionarioBtn))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(excluirFuncionarioBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(funcionarios_funcionarioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(alterarFuncionarioBtn)
                        .addComponent(funcionarios_novoBtn)
                        .addComponent(apenasAtivosCheckBox)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE))
        );

        vendedoresPanel.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 1110, 470));

        jTabbedPane1.addTab("Funcionários", new javax.swing.ImageIcon(getClass().getResource("/br/com/gt/view/imagens/funcionarios.png")), vendedoresPanel); // NOI18N

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

        excluirClienteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gt/view/imagens/Cancelar.png"))); // NOI18N
        excluirClienteBtn.setText("Excluir");

        alterarClienteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gt/view/imagens/teste.png"))); // NOI18N
        alterarClienteBtn.setText("Alterar");

        clientes_novoBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gt/view/imagens/novoCliente.png"))); // NOI18N
        clientes_novoBtn.setText("Novo");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(clientes_clienteTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clientes_novoBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(alterarClienteBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(excluirClienteBtn))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1110, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(excluirClienteBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(clientes_clienteTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(alterarClienteBtn)
                        .addComponent(clientes_novoBtn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE))
        );

        clientesPanel.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 1110, 470));

        jTabbedPane1.addTab("Clientes", new javax.swing.ImageIcon(getClass().getResource("/br/com/gt/view/imagens/clientes.png")), clientesPanel); // NOI18N

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

        excluirFornecedorBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gt/view/imagens/Cancelar.png"))); // NOI18N
        excluirFornecedorBtn.setText("Excluir");

        alterarFornecedorBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gt/view/imagens/teste.png"))); // NOI18N
        alterarFornecedorBtn.setText("Alterar");

        novoFornecedorBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gt/view/imagens/novoCliente.png"))); // NOI18N
        novoFornecedorBtn.setText("Novo");
        novoFornecedorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoFornecedorBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fornecedorTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 372, Short.MAX_VALUE)
                .addComponent(novoFornecedorBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(alterarFornecedorBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(excluirFornecedorBtn))
            .addComponent(jScrollPane4)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(fornecedorTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(excluirFornecedorBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alterarFornecedorBtn)
                    .addComponent(novoFornecedorBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                .addContainerGap())
        );

        fornecedoresPanel.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 1110, 470));

        jTabbedPane1.addTab("Fornecedores", new javax.swing.ImageIcon(getClass().getResource("/br/com/gt/view/imagens/fornecedores.png")), fornecedoresPanel); // NOI18N

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

        novoItemBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gt/view/imagens/add.png"))); // NOI18N
        novoItemBtn.setText("Novo Item");

        excluirMaterialBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gt/view/imagens/Cancelar.png"))); // NOI18N
        excluirMaterialBtn.setText("Excluir");

        alterarMaterialBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gt/view/imagens/alterar_item.png"))); // NOI18N
        alterarMaterialBtn.setText("Alterar");
        alterarMaterialBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarMaterialBtnActionPerformed(evt);
            }
        });

        addMatEstoqueBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gt/view/imagens/add.png"))); // NOI18N
        addMatEstoqueBtn.setText("Adicionar Estoque");

        excluirAcessorioBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gt/view/imagens/Cancelar.png"))); // NOI18N
        excluirAcessorioBtn.setText("Excluir");

        alterarAcessorioBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gt/view/imagens/alterar_item.png"))); // NOI18N
        alterarAcessorioBtn.setText("Alterar");

        addAceEstoqueBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gt/view/imagens/add.png"))); // NOI18N
        addAceEstoqueBtn.setText("Adicionar Estoque");
        addAceEstoqueBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAceEstoqueBtnActionPerformed(evt);
            }
        });

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
                        .addComponent(itemTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(novoItemBtn))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(material_baixaSelectBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(itemTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(excluirAcessorioBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(alterarAcessorioBtn)
                        .addComponent(addAceEstoqueBtn))
                    .addComponent(material_baixaSelectBox, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(excluirMaterialBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(alterarMaterialBtn)
                        .addComponent(addMatEstoqueBtn)
                        .addComponent(acessorio_baixaSelectBox)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        estoquePanel.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 1110, 470));

        jTabbedPane1.addTab("Estoque", new javax.swing.ImageIcon(getClass().getResource("/br/com/gt/view/imagens/VerEstoque.png")), estoquePanel); // NOI18N

        jPanel5.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 660));

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

    private void addAceEstoqueBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAceEstoqueBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addAceEstoqueBtnActionPerformed

    private void alterarMaterialBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarMaterialBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alterarMaterialBtnActionPerformed

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

    private void alterarAcessoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarAcessoBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alterarAcessoBtnActionPerformed

    private void excluirFuncionarioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirFuncionarioBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_excluirFuncionarioBtnActionPerformed

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
    private javax.swing.JCheckBox apenasAtivosCheckBox;
    private javax.swing.JTable clienteTable;
    private javax.swing.JPanel clientesPanel;
    private javax.swing.JTextField clientes_clienteTxt;
    private javax.swing.JButton clientes_novoBtn;
    private javax.swing.JPanel estoquePanel;
    private javax.swing.JButton excluirAcessorioBtn;
    private javax.swing.JButton excluirClienteBtn;
    private javax.swing.JButton excluirFornecedorBtn;
    private javax.swing.JButton excluirFuncionarioBtn;
    private javax.swing.JButton excluirMaterialBtn;
    private javax.swing.ButtonGroup filtroVendaGroup;
    private javax.swing.JTable fornecedorTable;
    private javax.swing.JTextField fornecedorTxt;
    private javax.swing.JPanel fornecedoresPanel;
    private javax.swing.JTable funcionarioTable;
    private javax.swing.JTextField funcionarios_funcionarioTxt;
    private javax.swing.JButton funcionarios_novoBtn;
    private javax.swing.JTextField itemTxt;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
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
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable materialTable;
    private javax.swing.JCheckBox material_baixaSelectBox;
    private javax.swing.JButton novoFornecedorBtn;
    private javax.swing.JButton novoItemBtn;
    private javax.swing.JButton sairBtn;
    private javax.swing.JPanel vendasPanel;
    private javax.swing.JTable vendasTable;
    private com.toedter.calendar.JDateChooser vendas_DataTxt;
    private javax.swing.JButton vendas_FiltrarPorDataBtn;
    private javax.swing.JButton vendas_LimparBtn;
    private javax.swing.JTextField vendas_clienteTxt;
    private javax.swing.JTextField vendas_funcionarioTxt;
    private javax.swing.JPanel vendedoresPanel;
    // End of variables declaration//GEN-END:variables
}
