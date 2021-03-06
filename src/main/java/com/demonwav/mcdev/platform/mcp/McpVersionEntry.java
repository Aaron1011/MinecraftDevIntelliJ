package com.demonwav.mcdev.platform.mcp;

public class McpVersionEntry {

    private static final String RED_START = "<html><font color='red'>";
    private static final String RED_END = "</font></html>";

    private final boolean isRed;
    private final String s;

    public McpVersionEntry(final String s) {
        this(s, false);
    }

    public McpVersionEntry(final String s, final boolean isRed) {
        this.isRed = isRed;
        this.s = s;
    }

    @Override
    public String toString() {
        if (isRed) {
            return RED_START + s + RED_END;
        } else {
            return s;
        }
    }

    public boolean isRed() {
        return isRed;
    }

    public String getText() {
        return s;
    }
}
