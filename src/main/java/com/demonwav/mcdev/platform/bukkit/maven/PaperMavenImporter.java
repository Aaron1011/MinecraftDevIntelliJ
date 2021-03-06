package com.demonwav.mcdev.platform.bukkit.maven;

import com.demonwav.mcdev.platform.bukkit.PaperModuleType;

import com.intellij.openapi.module.JavaModuleType;
import com.intellij.openapi.module.ModuleType;
import org.jetbrains.annotations.NotNull;

public class PaperMavenImporter extends SpigotMavenImporter {

    public PaperMavenImporter() {
        super(PaperModuleType.getInstance());
    }

    @NotNull
    @Override
    public ModuleType getModuleType() {
        return JavaModuleType.getModuleType();
    }
}
