/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.view.principal;

import br.com.gt.view.lookandfeel.JFrameLAF;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author lucas
 */
public class PrincipalFuncionarioView extends JFrameLAF {

    public JButton getLimparBtn() {
        return limparBtn;
    }

    public void setLimparBtn(JButton limparBtn) {
        this.limparBtn = limparBtn;
    }

    public JTextField getClienteVendaTxt() {
        return clienteVendaTxt;
    }

    public void setClienteVendaTxt(JTextField clienteVendaTxt) {
        this.clienteVendaTxt = clienteVendaTxt;
    }
    
    

    public JButton getAlterarVendaBtn() {
        return alterarVendaBtn;
    }

    public JTabbedPane getPainelDeGuias() {
        return PainelDeGuias;
    }

    public void setPainelDeGuias(JTabbedPane PainelDeGuias) {
        this.PainelDeGuias = PainelDeGuias;
    }
    
    

    public JPanel getFinalizarPanel() {
        return FinalizarPanel;
    }

    public void setFinalizarPanel(JPanel FinalizarPanel) {
        this.FinalizarPanel = FinalizarPanel;
    }
    
    

    public void setAlterarVendaBtn(JButton alterarVendaBtn) {
        this.alterarVendaBtn = alterarVendaBtn;
    }

    public JButton getBuscarVendaBtn() {
        return buscarVendaBtn;
    }

    public void setBuscarVendaBtn(JButton buscarVendaBtn) {
        this.buscarVendaBtn = buscarVendaBtn;
    }

    public JButton getCancelarVendaBtn() {
        return cancelarVendaBtn;
    }

    public void setCancelarVendaBtn(JButton cancelarVendaBtn) {
        this.cancelarVendaBtn = cancelarVendaBtn;
    }

    public JButton getFinalizarVendaBtn() {
        return finalizarVendaBtn;
    }

    public void setFinalizarVendaBtn(JButton finalizarVendaBtn) {
        this.finalizarVendaBtn = finalizarVendaBtn;
    }

    public JTable getVendasTable() {
        return vendasTable;
    }

    public void setVendasTable(JTable vendasTable) {
        this.vendasTable = vendasTable;
    }
    
    

    public JLabel getTituloTxt() {
        return tituloTxt;
    }

    public JButton getEncaminharVendaBtn() {
        return encaminharVendaBtn;
    }

    public void setEncaminharVendaBtn(JButton encaminharVendaBtn) {
        this.encaminharVendaBtn = encaminharVendaBtn;
    }

    
    
    public JTextField getCpfClienteTxt() {
        return cpfClienteTxt;
    }

    public void setCpfClienteTxt(JTextField cpfClienteTxt) {
        this.cpfClienteTxt = cpfClienteTxt;
    }

    public JButton getNovoClienteBtn() {
        return novoClienteBtn;
    }

    public void setNovoClienteBtn(JButton novoClienteBtn) {
        this.novoClienteBtn = novoClienteBtn;
    }

    
    
    public JComboBox<String> getAcessorioComboBox() {
        return acessorioComboBox;
    }

    public void setAcessorioComboBox(JComboBox<String> acessorioComboBox) {
        this.acessorioComboBox = acessorioComboBox;
    }

    public JComboBox<String> getClienteComboBox() {
        return clienteComboBox;
    }

    public void setClienteComboBox(JComboBox<String> clienteComboBox) {
        this.clienteComboBox = clienteComboBox;
    }

    public JComboBox<String> getMaterialComboBox() {
        return materialComboBox;
    }

    public JButton getAddAcessorioBtn() {
        return addAcessorioBtn;
    }

    public void setAddAcessorioBtn(JButton addAcessorioBtn) {
        this.addAcessorioBtn = addAcessorioBtn;
    }

    public JTextArea getDescricaoTxt() {
        return descricaoTxt;
    }

    public void setDescricaoTxt(JTextArea descricaoTxt) {
        this.descricaoTxt = descricaoTxt;
    }

    public JButton getExcluirItemBtn() {
        return excluirItemBtn;
    }

    public void setExcluirItemBtn(JButton excluirItemBtn) {
        this.excluirItemBtn = excluirItemBtn;
    }

    
    
    public JTextField getValorTotalTxt() {
        return valorTotalTxt;
    }

    public void setValorTotalTxt(JTextField valorTotalTxt) {
        this.valorTotalTxt = valorTotalTxt;
    }

    public JTextField getDescontoTxt() {
        return descontoTxt;
    }

    public void setDescontoTxt(JTextField descontoTxt) {
        this.descontoTxt = descontoTxt;
    }

    public JTextField getMaoDeObraTxt() {
        return maoDeObraTxt;
    }

    public void setMaoDeObraTxt(JTextField maoDeObraTxt) {
        this.maoDeObraTxt = maoDeObraTxt;
    }
    
    

    public JTextField getQuantidadeAcessorioTxt() {
        return quantidadeAcessorioTxt;
    }

    public void setQuantidadeAcessorioTxt(JTextField quantidadeAcessorioTxt) {
        this.quantidadeAcessorioTxt = quantidadeAcessorioTxt;
    }
    

    public JTable getItensTable() {
        return itensTable;
    }

    public void setItensTable(JTable itensTable) {
        this.itensTable = itensTable;
    }

    public JTextField getAlturaMaterialTxt() {
        return alturaMaterialTxt;
    }

    public void setAlturaMaterialTxt(JTextField alturaMaterialTxt) {
        this.alturaMaterialTxt = alturaMaterialTxt;
    }

    public JTextField getLarguraMaterialTxt() {
        return larguraMaterialTxt;
    }

    public void setLarguraMaterialTxt(JTextField larguraMaterialTxt) {
        this.larguraMaterialTxt = larguraMaterialTxt;
    }
    
    

    public void setMaterialComboBox(JComboBox<String> materialComboBox) {
        this.materialComboBox = materialComboBox;
    }

    
    public JTextField getItemTxt() {
        return itemTxt;
    }

    public void setItemTxt(JTextField itemTxt) {
        this.itemTxt = itemTxt;
    }

    public JButton getPesquisarItemBtn() {
        return pesquisarItemBtn;
    }

    public void setPesquisarItemBtn(JButton pesquisarItemBtn) {
        this.pesquisarItemBtn = pesquisarItemBtn;
    }
    
    public JCheckBox getAcessorio_baixaSelectBox() {
        return acessorio_baixaSelectBox;
    }

    public void setAcessorio_baixaSelectBox(JCheckBox acessorio_baixaSelectBox) {
        this.acessorio_baixaSelectBox = acessorio_baixaSelectBox;
    }

    public JCheckBox getMaterial_baixaSelectBox() {
        return material_baixaSelectBox;
    }

    public void setMaterial_baixaSelectBox(JCheckBox material_baixaSelectBox) {
        this.material_baixaSelectBox = material_baixaSelectBox;
    }

    public JButton getAddMaterialBtn() {
        return addMaterialBtn;
    }

    public void setAddMaterialBtn(JButton addMaterialBtn) {
        this.addMaterialBtn = addMaterialBtn;
    }   
    
    public JTable getAcessorioTable() {
        return acessorioTable;
    }

    public void setAcessorioTable(JTable acessorioTable) {
        this.acessorioTable = acessorioTable;
    }

    public JTable getMaterialTable() {
        return materialTable;
    }

    public void setMaterialTable(JTable materialTable) {
        this.materialTable = materialTable;
    }

    public JButton getSairBtn() {
        return sairBtn;
    }
    
    public PrincipalFuncionarioView() {
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

        jPanel1 = new javax.swing.JPanel();
        tituloTxt = new javax.swing.JLabel();
        sairBtn = new javax.swing.JButton();
        PainelDeGuias = new javax.swing.JTabbedPane();
        AbrirVendaPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        materialComboBox = new javax.swing.JComboBox<>();
        excluirItemBtn = new javax.swing.JButton();
        acessorioComboBox = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        itensTable = new javax.swing.JTable();
        quantidadeAcessorioTxt = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        addAcessorioBtn = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        larguraMaterialTxt = new javax.swing.JTextField();
        addMaterialBtn = new javax.swing.JButton();
        valorTotalTxt = new javax.swing.JTextField();
        descontoTxt = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        maoDeObraTxt = new javax.swing.JTextField();
        limparBtn = new javax.swing.JButton();
        encaminharVendaBtn = new javax.swing.JButton();
        clienteComboBox = new javax.swing.JComboBox<>();
        cpfClienteTxt = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        novoClienteBtn = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        descricaoTxt = new javax.swing.JTextArea();
        jLabel31 = new javax.swing.JLabel();
        alturaMaterialTxt = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        alterarVendaBtn = new javax.swing.JButton();
        FinalizarPanel = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        vendasTable = new javax.swing.JTable();
        finalizarVendaBtn = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        clienteVendaTxt = new javax.swing.JTextField();
        buscarVendaBtn = new javax.swing.JButton();
        cancelarVendaBtn = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        PanelEstoque = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        PanelEstoque1 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        acessorioTable = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        materialTable = new javax.swing.JTable();
        acessorio_baixaSelectBox = new javax.swing.JCheckBox();
        material_baixaSelectBox = new javax.swing.JCheckBox();
        pesquisarItemBtn = new javax.swing.JButton();
        itemTxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Glass Track");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tituloTxt.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tituloTxt.setForeground(new java.awt.Color(255, 255, 255));
        tituloTxt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gt/view/imagens/IconeVendedor.png"))); // NOI18N
        tituloTxt.setText("Módulo do Vendedor");
        tituloTxt.setToolTipText("");
        tituloTxt.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        tituloTxt.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(tituloTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, 290, -1));

        sairBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gt/view/imagens/logout.png"))); // NOI18N
        sairBtn.setText("Sair");
        sairBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sairBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairBtnActionPerformed(evt);
            }
        });
        jPanel1.add(sairBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 10, -1, -1));

        PainelDeGuias.setBackground(new java.awt.Color(51, 51, 51));
        PainelDeGuias.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        AbrirVendaPanel1.setBackground(new java.awt.Color(51, 51, 51));
        AbrirVendaPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        AbrirVendaPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1102, 11, -1, -1));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gt/view/imagens/LogoVidro.png"))); // NOI18N
        AbrirVendaPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 90));

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("BankGothic Md BT", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 153));
        jLabel16.setText("Glass Track");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 153));
        jLabel17.setText("Abertura de Venda");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 20, -1, 20));

        AbrirVendaPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1130, 50));

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));

        excluirItemBtn.setText("Excluir Item");

        acessorioComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acessórios", "Trinco", "Alumínio", "Roldana" }));

        itensTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(itensTable);

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Quantidade");

        addAcessorioBtn.setText("Adicionar acessório");
        addAcessorioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAcessorioBtnActionPerformed(evt);
            }
        });

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Descrição");

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Tamanho");

        addMaterialBtn.setText("Adicionar material");
        addMaterialBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMaterialBtnActionPerformed(evt);
            }
        });

        valorTotalTxt.setEditable(false);
        valorTotalTxt.setBackground(new java.awt.Color(255, 255, 255));

        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Desconto (%)");

        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("VALOR TOTAL (R$)");

        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Mão de obra (R$)");

        maoDeObraTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maoDeObraTxtActionPerformed(evt);
            }
        });

        limparBtn.setText("Cancelar");
        limparBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparBtnActionPerformed(evt);
            }
        });

        encaminharVendaBtn.setText("Encaminhar Venda");
        encaminharVendaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encaminharVendaBtnActionPerformed(evt);
            }
        });

        clienteComboBox.setToolTipText("Selecione o Cliente");

        cpfClienteTxt.setEditable(false);
        cpfClienteTxt.setBackground(new java.awt.Color(255, 255, 255));

        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("CPF do Cliente");

        novoClienteBtn.setText("Novo Cliente");

        descricaoTxt.setColumns(20);
        descricaoTxt.setRows(5);
        jScrollPane6.setViewportView(descricaoTxt);

        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("x");

        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("[Cm]");

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Acessório");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Material");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cliente");

        alterarVendaBtn.setText("Salvar alterações");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(clienteComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(larguraMaterialTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jLabel31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(alturaMaterialTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel32)
                                .addGap(104, 104, 104)
                                .addComponent(addMaterialBtn))
                            .addComponent(materialComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel18))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(cpfClienteTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(novoClienteBtn)
                                        .addContainerGap(270, Short.MAX_VALUE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(acessorioComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(quantidadeAcessorioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(addAcessorioBtn)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(excluirItemBtn))))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(encaminharVendaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(alterarVendaBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(limparBtn)
                                .addContainerGap())))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addContainerGap(1034, Short.MAX_VALUE))
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel26)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(descontoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel25)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(valorTotalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maoDeObraTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clienteComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cpfClienteTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29)
                    .addComponent(novoClienteBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(materialComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(acessorioComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addMaterialBtn)
                    .addComponent(jLabel32)
                    .addComponent(alturaMaterialTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(larguraMaterialTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(jLabel20)
                    .addComponent(jLabel18)
                    .addComponent(quantidadeAcessorioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addAcessorioBtn)
                    .addComponent(excluirItemBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(maoDeObraTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(valorTotalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25)
                            .addComponent(descontoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(limparBtn)
                            .addComponent(alterarVendaBtn)
                            .addComponent(encaminharVendaBtn)))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                .addContainerGap())
        );

        AbrirVendaPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 1090, 490));

        PainelDeGuias.addTab("Abrir Venda", new javax.swing.ImageIcon(getClass().getResource("/br/com/gt/view/imagens/AbriVenda.png")), AbrirVendaPanel1, "<html>\n<b>Criar uma nova venda ou simular orçamento"); // NOI18N

        FinalizarPanel.setBackground(new java.awt.Color(51, 51, 51));
        FinalizarPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gt/view/imagens/LogoVidro.png"))); // NOI18N
        FinalizarPanel.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 90));

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));

        vendasTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Cliente", "CPF", "Valor", "Abertura da Venda", "Situação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(vendasTable);

        finalizarVendaBtn.setText("Pagamento Realizado");

        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Cliente");

        buscarVendaBtn.setText("Pesquisar");

        cancelarVendaBtn.setText("Cancelar Venda");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(clienteVendaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buscarVendaBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(finalizarVendaBtn)
                .addGap(119, 119, 119)
                .addComponent(cancelarVendaBtn))
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 1100, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(finalizarVendaBtn)
                    .addComponent(jLabel35)
                    .addComponent(clienteVendaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarVendaBtn)
                    .addComponent(cancelarVendaBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        FinalizarPanel.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 1100, -1));

        jPanel7.setBackground(new java.awt.Color(0, 153, 153));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 153));
        jLabel37.setText("Vendas em Aberto");
        jPanel7.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 20, -1, 20));

        jLabel38.setFont(new java.awt.Font("BankGothic Md BT", 1, 24)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 153));
        jLabel38.setText("Glass Track");
        jPanel7.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        FinalizarPanel.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1130, 50));

        PainelDeGuias.addTab("Finalizar Venda", new javax.swing.ImageIcon(getClass().getResource("/br/com/gt/view/imagens/VendaAberta.png")), FinalizarPanel, "<html>\n<b>Vendas com pagamento não realizado"); // NOI18N

        PanelEstoque.setBackground(new java.awt.Color(51, 51, 51));
        PanelEstoque.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/gt/view/imagens/LogoVidro.png"))); // NOI18N
        PanelEstoque.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 90));

        PanelEstoque1.setBackground(new java.awt.Color(51, 51, 51));

        acessorioTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Acessório", "Quantidade", "Quantidade Mínima"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        acessorioTable.setName(""); // NOI18N
        jScrollPane8.setViewportView(acessorioTable);

        materialTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Material", "Quantidade", "Quantidade mínima"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane9.setViewportView(materialTable);

        acessorio_baixaSelectBox.setBackground(new java.awt.Color(51, 51, 51));
        acessorio_baixaSelectBox.setForeground(new java.awt.Color(255, 255, 255));
        acessorio_baixaSelectBox.setText("Apenas acessórios em baixa");

        material_baixaSelectBox.setBackground(new java.awt.Color(51, 51, 51));
        material_baixaSelectBox.setForeground(new java.awt.Color(255, 255, 255));
        material_baixaSelectBox.setText("Apenas materiais em baixa");

        pesquisarItemBtn.setText("Pesquisar");

        jLabel9.setBackground(new java.awt.Color(51, 51, 51));
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Item");

        javax.swing.GroupLayout PanelEstoque1Layout = new javax.swing.GroupLayout(PanelEstoque1);
        PanelEstoque1.setLayout(PanelEstoque1Layout);
        PanelEstoque1Layout.setHorizontalGroup(
            PanelEstoque1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEstoque1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelEstoque1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE)
                    .addComponent(jScrollPane8)
                    .addGroup(PanelEstoque1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(itemTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pesquisarItemBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(material_baixaSelectBox))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelEstoque1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(acessorio_baixaSelectBox))))
        );
        PanelEstoque1Layout.setVerticalGroup(
            PanelEstoque1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEstoque1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelEstoque1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(itemTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pesquisarItemBtn)
                    .addComponent(material_baixaSelectBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(acessorio_baixaSelectBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        PanelEstoque.add(PanelEstoque1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 1090, -1));

        jPanel8.setBackground(new java.awt.Color(0, 153, 153));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel44.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 153));
        jLabel44.setText("Visualização de Estoque");
        jPanel8.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 20, -1, 20));

        jLabel45.setFont(new java.awt.Font("BankGothic Md BT", 1, 24)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 153));
        jLabel45.setText("Glass Track");
        jPanel8.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        PanelEstoque.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1130, 50));

        PainelDeGuias.addTab("Estoque", new javax.swing.ImageIcon(getClass().getResource("/br/com/gt/view/imagens/VerEstoque.png")), PanelEstoque, "<html>\n<b>Visualizar situação do estoque"); // NOI18N

        jPanel1.add(PainelDeGuias, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -1, -1, 660));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addAcessorioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAcessorioBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addAcessorioBtnActionPerformed

    private void addMaterialBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMaterialBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addMaterialBtnActionPerformed

    private void maoDeObraTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maoDeObraTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maoDeObraTxtActionPerformed

    private void limparBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_limparBtnActionPerformed

    private void encaminharVendaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encaminharVendaBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_encaminharVendaBtnActionPerformed

    private void sairBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sairBtnActionPerformed

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
            java.util.logging.Logger.getLogger(PrincipalFuncionarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalFuncionarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalFuncionarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalFuncionarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalFuncionarioView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AbrirVendaPanel1;
    private javax.swing.JPanel FinalizarPanel;
    private javax.swing.JTabbedPane PainelDeGuias;
    private javax.swing.JPanel PanelEstoque;
    private javax.swing.JPanel PanelEstoque1;
    private javax.swing.JComboBox<String> acessorioComboBox;
    private javax.swing.JTable acessorioTable;
    private javax.swing.JCheckBox acessorio_baixaSelectBox;
    private javax.swing.JButton addAcessorioBtn;
    private javax.swing.JButton addMaterialBtn;
    private javax.swing.JButton alterarVendaBtn;
    private javax.swing.JTextField alturaMaterialTxt;
    private javax.swing.JButton buscarVendaBtn;
    private javax.swing.JButton cancelarVendaBtn;
    private javax.swing.JComboBox<String> clienteComboBox;
    private javax.swing.JTextField clienteVendaTxt;
    private javax.swing.JTextField cpfClienteTxt;
    private javax.swing.JTextField descontoTxt;
    private javax.swing.JTextArea descricaoTxt;
    private javax.swing.JButton encaminharVendaBtn;
    private javax.swing.JButton excluirItemBtn;
    private javax.swing.JButton finalizarVendaBtn;
    private javax.swing.JTextField itemTxt;
    private javax.swing.JTable itensTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextField larguraMaterialTxt;
    private javax.swing.JButton limparBtn;
    private javax.swing.JTextField maoDeObraTxt;
    private javax.swing.JComboBox<String> materialComboBox;
    private javax.swing.JTable materialTable;
    private javax.swing.JCheckBox material_baixaSelectBox;
    private javax.swing.JButton novoClienteBtn;
    private javax.swing.JButton pesquisarItemBtn;
    private javax.swing.JTextField quantidadeAcessorioTxt;
    private javax.swing.JButton sairBtn;
    private javax.swing.JLabel tituloTxt;
    private javax.swing.JTextField valorTotalTxt;
    private javax.swing.JTable vendasTable;
    // End of variables declaration//GEN-END:variables
}
