package com.demonwav.mcdev.insight.generation.ui;

import com.intellij.ide.highlighter.JavaHighlightingColors;
import com.intellij.openapi.editor.ex.util.EditorUtil;
import com.intellij.openapi.wm.ex.IdeFocusTraversalPolicy;
import com.intellij.util.ui.UIUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EventListenerWizard {
    private JPanel panel;
    private JTextField classNameTextField;
    // TODO: This field isn't always focusable when this wziard is created. I have no idea why or how to fix it, but it needs to be fixed before release
    private JTextField listenerNameTextField;
    private JLabel publicVoidLabel;
    private JPanel contentPanel;

    private JPanel innerContentPanel;
    private String chosenClassName;

    public EventListenerWizard(@Nullable JPanel panel, @NotNull String chosenClassName) {
        this.innerContentPanel = panel;
        this.chosenClassName = chosenClassName;
    }

    public JPanel getPanel() {
        classNameTextField.setFont(EditorUtil.getEditorFont());
        listenerNameTextField.setFont(EditorUtil.getEditorFont());
        publicVoidLabel.setFont(EditorUtil.getEditorFont());
        if (UIUtil.isUnderDarcula()) {
            publicVoidLabel.setForeground(JavaHighlightingColors.KEYWORD.getDefaultAttributes().getForegroundColor());
        } else {
            publicVoidLabel.setForeground(JavaHighlightingColors.KEYWORD.getFallbackAttributeKey().getDefaultAttributes().getForegroundColor());
        }

        if (innerContentPanel != null) {
            contentPanel.add(innerContentPanel);
        }

        classNameTextField.setText(chosenClassName);
        listenerNameTextField.setText("on" + chosenClassName.replace("Event", ""));

        IdeFocusTraversalPolicy.getPreferredFocusedComponent(listenerNameTextField).requestFocus();
        listenerNameTextField.requestFocus();

        return panel;
    }

    public String getChosenClassName() {
        return listenerNameTextField.getText();
    }
}