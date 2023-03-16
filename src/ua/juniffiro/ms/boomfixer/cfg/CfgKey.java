package ua.juniffiro.ms.boomfixer.cfg;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 13/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public enum CfgKey {

    PLUGIN_ENABLED("settings.enabledPlugin"),
    EXPLODE("settings.disable.explode"),
    EXPLODE_DAMAGE("settings.disable.explodeDamage");

    private final String path;

    CfgKey(String path) {
        this.path = path;
    }

    public String path() {
        return path;
    }
}
