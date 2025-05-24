package ac.kritex.check;

import ac.kritex.player.KritexPlayer;

public abstract class Abstract {

    protected final KritexPlayer player;
    protected final CheckInfo checkInfo;

    public Abstract(KritexPlayer player, String checkName, String type) {
        this.player = player;
        this.checkInfo = new CheckInfo(player, checkName, type);
    }

    public void fail() {
        checkInfo.fail();
    }

    public int getViolation() {
        return checkInfo.getViolation();
    }

    public void resetViolations() {
        checkInfo.resetViolations();
    }

    public abstract String getName();

    public abstract String getType();
}