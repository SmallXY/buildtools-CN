package org.spigotmc.gui.panels.about;

import java.awt.Insets;
import javax.swing.border.Border;
import org.spigotmc.gui.Theme;
import org.spigotmc.gui.attributes.Themeable;
import org.spigotmc.gui.panels.about.contributor.ContributorsPanel;
import org.spigotmc.gui.panels.about.tester.TestersPanel;
import org.spigotmc.gui.panels.about.thirdparty.ThirdPartyPanel;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.Dimension;
import java.awt.Image;

public class AboutPanel extends JPanel implements Themeable {

    private AboutPanelHeader aboutPanelHeader;

    private JScrollPane descriptionScrollPane;
    private JScrollPane issuesScrollPane;
    private JScrollPane updatedScrollPane;
    private JScrollPane contributeScrollPane;
    private JScrollPane donateScrollPane;

    public AboutPanel() {
        setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));
        setPreferredSize(new Dimension(1200, 700));

        initComponents();
    }

    private void initComponents() {
        this.aboutPanelHeader = new AboutPanelHeader();
        final AboutPanelFooter aboutPanelFooter = new AboutPanelFooter();
        final AboutInternalPanelHeader contributorsPanelHeader = new AboutInternalPanelHeader("<HTML><b>项目贡献者</b></HTML>");
        final ContributorsPanel contributorsPanel = new ContributorsPanel();
        final AboutInternalPanelHeader testersPanelHeader = new AboutInternalPanelHeader("<HTML><b>软件测试者</b></HTML>");
        final TestersPanel testersPanel = new TestersPanel();
        final AboutInternalPanelHeader thirdpartyPanelHeader = new AboutInternalPanelHeader("<HTML><b>第三方使用</b></HTML>");
        final ThirdPartyPanel thirdpartyPanel = new ThirdPartyPanel();

        final JLabel descriptionLabel = new JLabel("<html><b>简介</b></html>");
        descriptionScrollPane = makeScrolledTextPane("BuildTools 是一个独立的程序，主要用于编译 Spigot 服务器的 JAR 文件.");
        descriptionScrollPane.setFocusable(false);

        final JLabel issuesLabel = new JLabel("<html><b>遇到问题了吗？</b></html>");
        issuesScrollPane = makeScrolledTextPane("如果您遇到问题，请访问我们的维基页面，获取更多关于常见问题和故障排除指南的信息\n" +
                "如果维基页面没有包含解决您问题的方法，请尝试在我们的Discord服务器上提问，或者查看开放的错误报告，看看您的问题是否已经存在。");

        final JLabel stayUpdatedLabel = new JLabel("<html><b>保持更新</b></html>");
        updatedScrollPane = makeScrolledTextPane("确保访问我们的网站以获取更新和公告.");

        final JLabel contributeLabel = new JLabel("<html><b>贡献</b></html>");
        contributeScrollPane = makeScrolledTextPane("如果你想为这个项目或直接为SpigotMC做出贡献，两者的源代码都可以在stash上找到.");

        final JLabel donateLabel = new JLabel("<html><b>捐赠</b></html>");
        donateScrollPane = makeScrolledTextPane("这个图形用户界面是由社区成员开发的。如果您希望看到像这样的未来项目，或者只是想支持SpigotMC的开发，请考虑捐赠.");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(updatedScrollPane)
                        .addComponent(aboutPanelHeader, GroupLayout.DEFAULT_SIZE,
                            GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(aboutPanelFooter, GroupLayout.DEFAULT_SIZE,
                            GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(descriptionScrollPane)
                        .addComponent(issuesScrollPane, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(contributeScrollPane)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                // .addComponent(copyrightLicenseLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(descriptionLabel, GroupLayout.PREFERRED_SIZE,
                                    GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(issuesLabel, GroupLayout.PREFERRED_SIZE,
                                    GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(stayUpdatedLabel, GroupLayout.PREFERRED_SIZE,
                                    GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(contributeLabel, GroupLayout.PREFERRED_SIZE,
                                    GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(donateLabel, GroupLayout.PREFERRED_SIZE,
                                    GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(donateScrollPane, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGap(32, 32, 32)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(testersPanelHeader, GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                        .addComponent(contributorsPanelHeader, GroupLayout.DEFAULT_SIZE, 337,
                            Short.MAX_VALUE)
                        .addComponent(contributorsPanel, GroupLayout.DEFAULT_SIZE,
                            GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(testersPanel, GroupLayout.DEFAULT_SIZE,
                            GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(thirdpartyPanelHeader, GroupLayout.Alignment.TRAILING,
                            GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                        .addComponent(thirdpartyPanel, GroupLayout.PREFERRED_SIZE,
                            GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(aboutPanelHeader, GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(24, 24, 24)
                            .addComponent(descriptionLabel, GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(8, 8, 8)
                            .addComponent(descriptionScrollPane, GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(24, 24, 24)
                            .addComponent(issuesLabel, GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(8, 8, 8)
                            .addComponent(issuesScrollPane, GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(24, 24, 24)
                            .addComponent(stayUpdatedLabel, GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(8, 8, 8)
                            .addComponent(updatedScrollPane, GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(24, 24, 24)
                            .addComponent(contributeLabel, GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(contributeScrollPane, GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(24, 24, 24)
                            .addComponent(donateLabel, GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(donateScrollPane, GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(contributorsPanelHeader, GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(8, 8, 8)
                            .addComponent(contributorsPanel, GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(24, 24, 24)
                            .addComponent(testersPanelHeader, GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(8, 8, 8)
                            .addComponent(testersPanel, GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(24, 24, 24)
                            .addComponent(thirdpartyPanelHeader, GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(8, 8, 8)
                            .addComponent(thirdpartyPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            // .addComponent(copyrightLicenseLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            // .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(aboutPanelFooter, GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
        );
    }

    public void setAboutHeaderImage(final Image image) {
        this.aboutPanelHeader.setLogoImage(image);
    }

    private static JScrollPane makeScrolledTextPane(final String text) {
        final JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBorder(null);

        final JTextPane textPane = new JTextPane();
        textPane.setEditable(false);
        textPane.setBorder(null);
        textPane.setMargin(new Insets(0, 0, 0, 0));

        textPane.setText(text);

        scrollPane.setViewportView(textPane);
        return scrollPane;
    }

    @Override
    public void onThemeChange(Theme theme) {
        Border border = BorderFactory.createEmptyBorder(0, 0, 0, 0);

        descriptionScrollPane.setBorder(border);
        issuesScrollPane.setBorder(border);
        updatedScrollPane.setBorder(border);
        contributeScrollPane.setBorder(border);
        donateScrollPane.setBorder(border);
    }
}
