package com.demonwav.mcdev.platform.sponge;

import com.demonwav.mcdev.platform.AbstractTemplate;
import com.demonwav.mcdev.util.MinecraftFileTemplateGroupFactory;

import com.intellij.ide.fileTemplates.FileTemplate;
import com.intellij.ide.fileTemplates.FileTemplateManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.Properties;

public class SpongeTemplate extends AbstractTemplate {

    @Nullable
    public static String applyPomTemplate(@NotNull Project project,
                                          @NotNull String version) {

        Properties properties = new Properties();
        properties.setProperty("BUILD_VERSION", version);

        FileTemplateManager manager = FileTemplateManager.getInstance(project);
        FileTemplate fileTemplate = manager.getJ2eeTemplate(MinecraftFileTemplateGroupFactory.SPONGE_POM_TEMPLATE);
        try {
            return fileTemplate.getText(properties);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void applyMainClassTemplate(@NotNull Project project,
                                              @NotNull VirtualFile mainClassFile,
                                              @NotNull String packageName,
                                              @NotNull String className,
                                              boolean hasDependencies,
                                              boolean generateDocumentation) {

        Properties properties = new Properties();

        properties.setProperty("PACKAGE", packageName);
        properties.setProperty("CLASS_NAME", className);
        if (hasDependencies) {
            properties.setProperty("HAS_DEPENDENCIES", "true");
        }

        if (generateDocumentation) {
            properties.setProperty("GENERATE_DOCUMENTATION", "true");
        }

        try {
            applyTemplate(project, mainClassFile, MinecraftFileTemplateGroupFactory.SPONGE_MAIN_CLASS_TEMPLATE, properties);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Nullable
    public static String applyBuildGradleTemplate(@NotNull Project project,
                                                  @NotNull String groupId,
                                                  @NotNull String pluginVersion,
                                                  @NotNull String buildVersion) {

        Properties properties = new Properties();
        properties.setProperty("GROUP_ID", groupId);
        properties.setProperty("PLUGIN_VERSION", pluginVersion);
        properties.setProperty("BUILD_VERSION", buildVersion);

        FileTemplateManager manager = FileTemplateManager.getInstance(project);
        FileTemplate template = manager.getJ2eeTemplate(MinecraftFileTemplateGroupFactory.SPONGE_BUILD_GRADLE_TEMPLATE);

        try {
            return template.getText(properties);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Nullable
    public static String applySubmoduleBuildGradleTemplate(@NotNull Project project,
                                                           @NotNull String commonProjectName) {

        Properties properties = new Properties();
        properties.setProperty("COMMON_PROJECT_NAME", commonProjectName);

        FileTemplateManager manager = FileTemplateManager.getInstance(project);
        FileTemplate template = manager.getJ2eeTemplate(MinecraftFileTemplateGroupFactory.SPONGE_SUBMODULE_BUILD_GRADLE_TEMPLATE);

        try {
            return template.getText(properties);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
