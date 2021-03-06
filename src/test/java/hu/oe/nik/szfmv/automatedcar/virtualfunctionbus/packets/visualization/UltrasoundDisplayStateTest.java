package hu.oe.nik.szfmv.automatedcar.virtualfunctionbus.packets.visualization;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UltrasoundDisplayStateTest {

    UltrasoundDisplayStatePacket ultrasoundDisplayStatePacket;

    @BeforeEach
    public void init() {
        ultrasoundDisplayStatePacket = new UltrasoundDisplayStatePacket();
        ultrasoundDisplayStatePacket.setUltrasoundDisplayState(true);
    }

    /**
     * Check whether the class gets instantiated when new CameraDisplayStatePacket() is called.
     */
    @Test
    public void classInstantiated() {
        assertNotNull(ultrasoundDisplayStatePacket);
    }

    /**
     * Checks whether the setting is passed right
     */
    @Test
    public void settingPassed() {
        assertEquals(true, ultrasoundDisplayStatePacket.getUltrasoundDisplayState());
    }
}
