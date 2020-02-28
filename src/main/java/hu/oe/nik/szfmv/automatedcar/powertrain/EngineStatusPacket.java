package hu.oe.nik.szfmv.automatedcar.powertrain;

class EngineStatusPacket implements hu.oe.nik.szfmv.automatedcar.virtualfunctionbus.packets.powertrain.EngineStatusPacket {

    private final double rpm;

    private final int forwardLevel;

    private final CarTransmissionMode mode;

    public EngineStatusPacket(double rpm, int forwardLevel, CarTransmissionMode mode) {
        this.rpm = rpm;
        this.forwardLevel = forwardLevel;
        this.mode = mode;
    }

    @Override
    public CarTransmissionMode getTransmissionMode() {
        return mode;
    }

    @Override
    public Integer getForwardLevel() {
        return forwardLevel > 0 ? forwardLevel : null;
    }

    @Override
    public double getRPM() {
        return rpm;
    }

}
