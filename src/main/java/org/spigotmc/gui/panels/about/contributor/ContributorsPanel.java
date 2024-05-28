package org.spigotmc.gui.panels.about.contributor;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ContributorsPanel extends JPanel {

    public ContributorsPanel() {
        initComponents();
    }

    private void initComponents() {
        final JLabel[] md5 = createContributorLabels("md_5", "CLI工具的原始创建者。");
        final JLabel[] small = createContributorLabels("SmallXY x KimiAi", "中文简体翻译");
        final JLabel[] coll1234567 = createContributorLabels("Coll1234567", "初始GUI框架设置。");
        final JLabel[] nothixal = createContributorLabels("Nothixal", "UI/UX 设计师");
        final JLabel[] y2k = createContributorLabels("Y2K_", "主题切换器和代码清理。");
//        final JLabel[] choco = createContributorLabels("Choco",  "特性澄清.");
        final JLabel[] winnpixie = createContributorLabels("winnpixie", "原始GUI灵感.");
        final JLabel[] mfnalex = createContributorLabels("mfnalex", "Java路径爬虫工具.");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(coll1234567[0])
                        .addComponent(nothixal[0])
                        .addComponent(y2k[0])
//                        .addComponent(choco[0])
                            .addComponent(small[0])
                        .addComponent(md5[0])
                        .addComponent(winnpixie[0])
                        .addComponent(mfnalex[0]))
                    .addGap(16, 16, 16)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(mfnalex[1])
                        .addComponent(winnpixie[1])
                        .addComponent(md5[1])
//                        .addComponent(choco[1])
                            .addComponent(small[1])
                        .addComponent(y2k[1])
                        .addComponent(nothixal[1])
                        .addComponent(coll1234567[1]))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(md5[0])
                        .addComponent(md5[1]))
                    .addGap(8, 8, 8)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(coll1234567[0])
                        .addComponent(coll1234567[1]))
                    .addGap(8, 8, 8)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(small[0])
                            .addComponent(small[1]))
                    .addGap(8, 8, 8)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(nothixal[0])
                        .addComponent(nothixal[1]))
                    .addGap(8, 8, 8)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(y2k[0])
                        .addComponent(y2k[1]))
//                    .addGap(8, 8, 8)
//                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//                        .addComponent(choco[0])
//                        .addComponent(choco[1]))
                    .addGap(8, 8, 8)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(winnpixie[0])
                        .addComponent(winnpixie[1]))
                    .addGap(8, 8, 8)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(mfnalex[0])
                        .addComponent(mfnalex[1])))
        );

    }

    private static JLabel[] createContributorLabels(final String name, final String contribution) {
        return new JLabel[]{new JLabel(name), new JLabel(contribution)};
    }
}
