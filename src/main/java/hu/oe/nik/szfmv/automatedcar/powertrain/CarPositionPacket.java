package hu.oe.nik.szfmv.automatedcar.powertrain;

import hu.oe.nik.szfmv.automatedcar.math.IVector;

class CarPositionPacket implements hu.oe.nik.szfmv.automatedcar.virtualfunctionbus.packets.powertrain.CarPositionPacket {

    private final double x;

    private final double y;

    private final IVector moveVector;

    private CarPositionPacket(double x, double y, IVector moveVector) {
        this.x = x;
        this.y = y;
        this.moveVector = moveVector;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public IVector getMoveVector() {
        return moveVector;
    }
}
