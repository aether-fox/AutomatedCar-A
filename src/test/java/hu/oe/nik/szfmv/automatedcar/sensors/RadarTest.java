package hu.oe.nik.szfmv.automatedcar.sensors;

import hu.oe.nik.szfmv.automatedcar.AutomatedCar;
import hu.oe.nik.szfmv.automatedcar.model.World;
import hu.oe.nik.szfmv.automatedcar.model.WorldObject;
import hu.oe.nik.szfmv.automatedcar.virtualfunctionbus.VirtualFunctionBus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class RadarTest {
    Radar radar;
    AutomatedCar automatedCar;
    VirtualFunctionBus virtualFunctionBus;
    MockWorld world;

    /**
     * Mock class for controling the passed on data
     */
    class MockWorld extends World {
        int calledNumber = 0;

        MockWorld(int width, int height) {
            super(width, height, new ArrayList<WorldObject>());
        }

        @Override
        public List<WorldObject> getObjectsInsideTriangle(Point a, Point b, Point c) {
            calledNumber++;
            List<WorldObject> returnlist = new ArrayList<>();

            // the collideable object
            WorldObject object1 = new WorldObject(-100, -100, "roadsign_speed_40.png");
            object1.setType("roadsign_speed_40");
            object1.setId("roadsign_speed_40_1");
            object1.setZ(1);
            returnlist.add(object1);

            // the not collideable object
            WorldObject object2 = new WorldObject(200, 400, "parking_space_parallel.png");
            object2.setType("parking_space_parallel");
            object2.setId("parking_space_parallel_2");
            object2.setZ(0);
            returnlist.add(object2);

            addRemoved(returnlist);

            return returnlist;
        }

        private void addRemoved(List<WorldObject> returnlist) {
            if (calledNumber == 1) {
                // a collideable object
                WorldObject object1 = new WorldObject(600, 200, "tree.png");
                object1.setType("tree");
                object1.setId("tree_3");
                object1.setZ(1);
                returnlist.add(object1);
            }
        }
    }

    @BeforeEach
    public void init() {
        virtualFunctionBus = new VirtualFunctionBus();
        automatedCar = new AutomatedCar(10, 10, "car_1_white.png");
        automatedCar.setRotation((float) Math.toRadians(-30));
        world = new MockWorld(1000, 1000);
        radar = new Radar(virtualFunctionBus, automatedCar, world);
    }

    /**
     * Check whether the class gets instantiatied when new Radar() called.
     */
    @Test
    public void classInstantiated() {
        assertNotNull(radar);
    }

    /**
     * Check whether collidable objects are sent to the selectedDebugListPacket
     */
    @Test
    public void collidableObjects() {
        radar.loop();
        assertTrue(radar.getObjectsSeenByRadar().stream()
            .filter(t -> t.getId().equals("roadsign_speed_40_1")).findFirst().isPresent());
        assertFalse(radar.getObjectsSeenByRadar().stream()
            .filter(t -> t.getId().equals("parking_2")).findFirst().isPresent());
    }

    /**
     * Checks whether object is removed from the selectedDebugListPacket if no longer seen by radar
     */
    @Test
    public void collidableRemoved() {
        radar.loop();
        assertTrue(radar.getObjectsSeenByRadar().stream()
            .filter(t -> t.getId().equals("tree_3")).findFirst().isPresent());
        radar.loop();
        assertFalse(radar.getObjectsSeenByRadar().stream()
            .filter(t -> t.getId().equals("tree_3")).findFirst().isPresent());
    }

    /**
     * Checks whether the radar triangle position is right
     * and it is set to the right
     */
    @Test
    public void radarTriangleSet() {
        radar.loop();
        assertEquals(-42, virtualFunctionBus.radarVisualizationPacket.getSensorSource().getX());
        assertEquals(-80, virtualFunctionBus.radarVisualizationPacket.getSensorSource().getY());
        assertEquals(61, virtualFunctionBus.radarVisualizationPacket.getSensorCorner1().getX());
        assertEquals(-11446, virtualFunctionBus.radarVisualizationPacket.getSensorCorner1().getY());
        assertEquals(-9937, virtualFunctionBus.radarVisualizationPacket.getSensorCorner2().getX());
        assertEquals(-5673, virtualFunctionBus.radarVisualizationPacket.getSensorCorner2().getY());
    }
}
