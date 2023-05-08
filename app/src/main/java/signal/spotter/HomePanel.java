package signal.spotter;

import javax.swing.*;

public class HomePanel extends JPanel {

        private javax.swing.JPanel fastBar;
        private javax.swing.JButton fastButton;
        private javax.swing.JPanel helpBar;
        private javax.swing.JButton helpButton;
        private javax.swing.JButton jButton2;
        private javax.swing.JMenuItem jMenuItem1;
        private javax.swing.JPopupMenu jPopupMenu1;
        private javax.swing.JPanel listBar;
        private javax.swing.JButton listButton;
        public javax.swing.JPanel mapPanel;
        public javax.swing.JPanel menuBar;
        private javax.swing.JButton menuButton;
        public javax.swing.JPanel menuIcon;
        private javax.swing.JPanel menuPanel;
        public javax.swing.JPanel refreshBar;
        private javax.swing.JButton refreshButton;
        private javax.swing.JPanel reportBar;
        private javax.swing.JButton reportButton;
        private javax.swing.JPanel trendsBar;
        private javax.swing.JButton trendsButton;

        public HomePanel() {
                java.awt.GridBagConstraints gridBagConstraints;

                jPopupMenu1 = new javax.swing.JPopupMenu();
                jMenuItem1 = new javax.swing.JMenuItem();
                jButton2 = new javax.swing.JButton();
                menuBar = new javax.swing.JPanel();
                menuIcon = new javax.swing.JPanel();
                menuButton = new javax.swing.JButton();
                mapPanel = new javax.swing.JPanel();
                menuPanel = new javax.swing.JPanel();
                reportBar = new javax.swing.JPanel();
                reportButton = new javax.swing.JButton();
                trendsBar = new javax.swing.JPanel();
                trendsButton = new javax.swing.JButton();
                fastBar = new javax.swing.JPanel();
                fastButton = new javax.swing.JButton();
                listBar = new javax.swing.JPanel();
                listButton = new javax.swing.JButton();
                helpBar = new javax.swing.JPanel();
                helpButton = new javax.swing.JButton();
                refreshBar = new javax.swing.JPanel();
                refreshButton = new javax.swing.JButton();

                jPopupMenu1.setBackground(new java.awt.Color(255, 255, 255));
                jPopupMenu1.setInheritsPopupMenu(true);
                jPopupMenu1.setMaximumSize(new java.awt.Dimension(400, 250));
                jPopupMenu1.setMinimumSize(new java.awt.Dimension(400, 250));
                jPopupMenu1.setPopupSize(new java.awt.Dimension(400, 250));
                jPopupMenu1.setRequestFocusEnabled(false);
                jPopupMenu1.getAccessibleContext().setAccessibleDescription("");
                jPopupMenu1.getAccessibleContext().setAccessibleParent(menuButton);

                jMenuItem1.setBackground(new java.awt.Color(255, 255, 255));
                jMenuItem1.setText("jMenuItem1");
                jMenuItem1.setMinimumSize(new java.awt.Dimension(400, 50));
                jMenuItem1.setPreferredSize(new java.awt.Dimension(400, 50));
                jMenuItem1.getAccessibleContext().setAccessibleParent(jPopupMenu1);

                jButton2.setBackground(new java.awt.Color(255, 255, 255));
                jButton2.setText("jButton2");
                jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                jButton2.setMaximumSize(new java.awt.Dimension(400, 50));
                jButton2.setMinimumSize(new java.awt.Dimension(400, 50));
                jButton2.setPreferredSize(new java.awt.Dimension(400, 50));
                jButton2.getAccessibleContext().setAccessibleParent(jPopupMenu1);

                setBackground(new java.awt.Color(255, 255, 255));
                setName("mainFrame"); // NOI18N
                setSize(new java.awt.Dimension(400, 800));
                java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
                layout.columnWidths = new int[] { 80 };
                layout.rowHeights = new int[] { 50 };
                layout.columnWeights = new double[] { 0.2, 0.2 };
                layout.rowWeights = new double[] { 0.5, 0.5 };
                setLayout(layout);

                menuBar.setBackground(new java.awt.Color(0, 0, 255));
                menuBar.setForeground(new java.awt.Color(0, 0, 255));
                menuBar.setAlignmentX(0.0F);
                menuBar.setAlignmentY(1.0F);
                menuBar.setMaximumSize(new java.awt.Dimension(1100, 50));
                menuBar.setMinimumSize(new java.awt.Dimension(400, 50));
                menuBar.setName(""); // NOI18N
                menuBar.setPreferredSize(new java.awt.Dimension(400, 50));
                menuBar.setLayout(new java.awt.GridBagLayout());

                menuIcon.setBackground(new java.awt.Color(0, 0, 204));
                menuIcon.setAlignmentX(3.0F);
                menuIcon.setMaximumSize(new java.awt.Dimension(50, 50));
                menuIcon.setMinimumSize(new java.awt.Dimension(50, 50));
                menuIcon.setNextFocusableComponent(menuButton);

                menuButton.setBackground(new java.awt.Color(0, 0, 255));
                menuButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                menuButton.setForeground(new java.awt.Color(255, 255, 255));
                menuButton.setText("Menu");
                menuButton.setBorder(null);
                menuButton.setBorderPainted(false);
                menuButton.setIconTextGap(1);
                menuButton.setMargin(new java.awt.Insets(1, 1, 1, 1));
                menuButton.setMaximumSize(new java.awt.Dimension(50, 50));
                menuButton.setMinimumSize(new java.awt.Dimension(50, 50));
                menuButton.setPreferredSize(new java.awt.Dimension(50, 50));
                menuButton.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                // menuButtonMouseClicked(evt);
                        }

                        public void mouseEntered(java.awt.event.MouseEvent evt) {
                                // menuButtonMouseEntered(evt);
                        }

                        public void mouseExited(java.awt.event.MouseEvent evt) {
                                // menuButtonMouseExited(evt);
                        }
                });
                menuButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                // menuButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout menuIconLayout = new javax.swing.GroupLayout(menuIcon);
                menuIcon.setLayout(menuIconLayout);
                menuIconLayout.setHorizontalGroup(
                                menuIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(menuButton, javax.swing.GroupLayout.Alignment.TRAILING,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE));
                menuIconLayout.setVerticalGroup(
                                menuIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(menuIconLayout.createSequentialGroup()
                                                                .addComponent(menuButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE)));

                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
                gridBagConstraints.insets = new java.awt.Insets(0, 300, 0, 0);
                menuBar.add(menuIcon, gridBagConstraints);

                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 1;
                gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
                add(menuBar, gridBagConstraints);

                mapPanel.setBackground(new java.awt.Color(153, 204, 255));
                mapPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 2));
                mapPanel.setForeground(new java.awt.Color(255, 255, 0));
                mapPanel.setAlignmentX(0.0F);
                mapPanel.setAlignmentY(2.0F);
                mapPanel.setMaximumSize(new java.awt.Dimension(400, 650));
                mapPanel.setMinimumSize(new java.awt.Dimension(400, 650));
                mapPanel.setPreferredSize(new java.awt.Dimension(400, 650));

                menuPanel.setBackground(new java.awt.Color(255, 153, 255));
                menuPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 2));
                menuPanel.setAlignmentX(0.0F);
                menuPanel.setAlignmentY(0.0F);
                menuPanel.setMaximumSize(new java.awt.Dimension(396, 250));
                menuPanel.setMinimumSize(new java.awt.Dimension(396, 250));
                menuPanel.setPreferredSize(new java.awt.Dimension(396, 250));
                java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
                jPanel1Layout.rowHeights = new int[] { 50 };
                menuPanel.setLayout(jPanel1Layout);

                reportBar.setBackground(new java.awt.Color(255, 255, 255));
                reportBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
                reportBar.setAlignmentX(0.0F);
                reportBar.setAlignmentY(0.0F);
                reportBar.setMaximumSize(new java.awt.Dimension(1600, 50));
                reportBar.setMinimumSize(new java.awt.Dimension(400, 50));
                reportBar.setPreferredSize(new java.awt.Dimension(400, 50));

                reportButton.setBackground(new java.awt.Color(255, 255, 255));
                reportButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                reportButton.setForeground(new java.awt.Color(0, 0, 255));
                reportButton.setText("Report Current Wifi");
                reportButton.setBorder(null);
                reportButton.setMaximumSize(new java.awt.Dimension(390, 48));
                reportButton.setMinimumSize(new java.awt.Dimension(390, 48));
                reportButton.setPreferredSize(new java.awt.Dimension(390, 48));
                reportButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                GUI.cardLayout.show(GUI.cardPanel, "dashboardPanel");
                        }
                });

                javax.swing.GroupLayout reportBarLayout = new javax.swing.GroupLayout(reportBar);
                reportBar.setLayout(reportBarLayout);
                reportBarLayout.setHorizontalGroup(
                                reportBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(reportBarLayout.createSequentialGroup()
                                                                .addComponent(reportButton,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGap(0, 8, Short.MAX_VALUE)));
                reportBarLayout.setVerticalGroup(
                                reportBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reportBarLayout
                                                                .createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addComponent(reportButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)));

                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
                menuPanel.add(reportBar, gridBagConstraints);

                trendsBar.setBackground(new java.awt.Color(255, 255, 255));
                trendsBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
                trendsBar.setAlignmentX(1.0F);
                trendsBar.setAlignmentY(0.0F);
                trendsBar.setMaximumSize(new java.awt.Dimension(1600, 50));
                trendsBar.setMinimumSize(new java.awt.Dimension(400, 50));
                trendsBar.setPreferredSize(new java.awt.Dimension(400, 50));

                trendsButton.setBackground(new java.awt.Color(255, 255, 255));
                trendsButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                trendsButton.setForeground(new java.awt.Color(0, 0, 255));
                trendsButton.setText("Signal Trends");
                trendsButton.setBorder(null);
                trendsButton.setMaximumSize(new java.awt.Dimension(390, 48));
                trendsButton.setMinimumSize(new java.awt.Dimension(390, 48));
                trendsButton.setPreferredSize(new java.awt.Dimension(396, 48));
                trendsButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                // trendsButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout trendsBarLayout = new javax.swing.GroupLayout(trendsBar);
                trendsBar.setLayout(trendsBarLayout);
                trendsBarLayout.setHorizontalGroup(
                                trendsBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trendsBarLayout
                                                                .createSequentialGroup()
                                                                .addComponent(trendsButton,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                390, Short.MAX_VALUE)
                                                                .addContainerGap()));
                trendsBarLayout.setVerticalGroup(
                                trendsBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trendsBarLayout
                                                                .createSequentialGroup()
                                                                .addComponent(trendsButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE)));

                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
                gridBagConstraints.weightx = 1.0;
                menuPanel.add(trendsBar, gridBagConstraints);

                fastBar.setBackground(new java.awt.Color(255, 255, 255));
                fastBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
                fastBar.setAlignmentX(2.0F);
                fastBar.setAlignmentY(0.0F);
                fastBar.setMaximumSize(new java.awt.Dimension(1600, 50));
                fastBar.setMinimumSize(new java.awt.Dimension(400, 50));
                fastBar.setPreferredSize(new java.awt.Dimension(400, 50));

                fastButton.setBackground(new java.awt.Color(255, 255, 255));
                fastButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                fastButton.setForeground(new java.awt.Color(0, 0, 255));
                fastButton.setText("Fast Wifi Now");
                fastButton.setBorder(null);
                fastButton.setMaximumSize(new java.awt.Dimension(390, 48));
                fastButton.setMinimumSize(new java.awt.Dimension(390, 48));
                fastButton.setPreferredSize(new java.awt.Dimension(390, 48));
                fastButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                // fastButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout fastBarLayout = new javax.swing.GroupLayout(fastBar);
                fastBar.setLayout(fastBarLayout);
                fastBarLayout.setHorizontalGroup(
                                fastBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(fastBarLayout.createSequentialGroup()
                                                                .addComponent(fastButton,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGap(0, 8, Short.MAX_VALUE)));
                fastBarLayout.setVerticalGroup(
                                fastBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(fastBarLayout.createSequentialGroup()
                                                                .addComponent(fastButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE)));

                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
                menuPanel.add(fastBar, gridBagConstraints);

                listBar.setBackground(new java.awt.Color(255, 255, 255));
                listBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
                listBar.setMaximumSize(new java.awt.Dimension(1600, 50));
                listBar.setMinimumSize(new java.awt.Dimension(400, 50));
                listBar.setPreferredSize(new java.awt.Dimension(400, 50));

                listButton.setBackground(new java.awt.Color(255, 255, 255));
                listButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                listButton.setForeground(new java.awt.Color(0, 0, 255));
                listButton.setText("List View");
                listButton.setBorder(null);
                listButton.setMaximumSize(new java.awt.Dimension(390, 48));
                listButton.setMinimumSize(new java.awt.Dimension(390, 48));
                listButton.setPreferredSize(new java.awt.Dimension(390, 48));
                listButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                // listButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout listBarLayout = new javax.swing.GroupLayout(listBar);
                listBar.setLayout(listBarLayout);
                listBarLayout.setHorizontalGroup(
                                listBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(listBarLayout.createSequentialGroup()
                                                                .addComponent(listButton,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGap(0, 8, Short.MAX_VALUE)));
                listBarLayout.setVerticalGroup(
                                listBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(listBarLayout.createSequentialGroup()
                                                                .addComponent(listButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE)));

                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                menuPanel.add(listBar, gridBagConstraints);

                helpBar.setBackground(new java.awt.Color(255, 255, 255));
                helpBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
                helpBar.setMaximumSize(new java.awt.Dimension(1600, 50));
                helpBar.setMinimumSize(new java.awt.Dimension(400, 50));
                helpBar.setPreferredSize(new java.awt.Dimension(400, 50));

                helpButton.setBackground(new java.awt.Color(255, 255, 255));
                helpButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                helpButton.setForeground(new java.awt.Color(0, 0, 255));
                helpButton.setText("Help");
                helpButton.setBorder(null);
                helpButton.setMaximumSize(new java.awt.Dimension(390, 48));
                helpButton.setMinimumSize(new java.awt.Dimension(390, 48));
                helpButton.setPreferredSize(new java.awt.Dimension(390, 48));
                helpButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                // helpButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout helpBarLayout = new javax.swing.GroupLayout(helpBar);
                helpBar.setLayout(helpBarLayout);
                helpBarLayout.setHorizontalGroup(
                                helpBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(helpBarLayout.createSequentialGroup()
                                                                .addComponent(helpButton,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGap(0, 8, Short.MAX_VALUE)));
                helpBarLayout.setVerticalGroup(
                                helpBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(helpBarLayout.createSequentialGroup()
                                                                .addComponent(helpButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE)));

                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
                menuPanel.add(helpBar, gridBagConstraints);

                javax.swing.GroupLayout mapPanelLayout = new javax.swing.GroupLayout(mapPanel);
                mapPanel.setLayout(mapPanelLayout);
                mapPanelLayout.setHorizontalGroup(
                                mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(mapPanelLayout.createSequentialGroup()
                                                                .addComponent(menuPanel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGap(0, 0, Short.MAX_VALUE)));
                mapPanelLayout.setVerticalGroup(
                                mapPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(mapPanelLayout.createSequentialGroup()
                                                                .addComponent(menuPanel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGap(0, 396, Short.MAX_VALUE)));

                menuPanel.getAccessibleContext().setAccessibleParent(menuButton);

                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
                add(mapPanel, gridBagConstraints);

                refreshBar.setBackground(new java.awt.Color(0, 0, 255));
                refreshBar.setAlignmentX(0.0F);
                refreshBar.setAlignmentY(15.0F);
                refreshBar.setMinimumSize(new java.awt.Dimension(400, 50));
                refreshBar.setPreferredSize(new java.awt.Dimension(400, 50));
                refreshBar.setLayout(new java.awt.GridBagLayout());

                refreshButton.setBackground(new java.awt.Color(0, 0, 255));
                refreshButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
                refreshButton.setForeground(new java.awt.Color(255, 255, 255));
                refreshButton.setText("Refresh");
                refreshButton.setBorder(null);
                refreshButton.setMaximumSize(new java.awt.Dimension(1500, 46));
                refreshButton.setMinimumSize(new java.awt.Dimension(396, 46));
                refreshButton.setPreferredSize(new java.awt.Dimension(400, 48));
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.insets = new java.awt.Insets(13, 162, 14, 163);
                refreshBar.add(refreshButton, gridBagConstraints);

                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
                gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
                gridBagConstraints.weightx = 1.0;
                gridBagConstraints.weighty = 0.5;
                add(refreshBar, gridBagConstraints);
        }
}