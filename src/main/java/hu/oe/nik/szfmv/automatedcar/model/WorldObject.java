package hu.oe.nik.szfmv.automatedcar.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WorldObject {

    private static int uid = 1;

    private static final Logger LOGGER = LogManager.getLogger(WorldObject.class);

    protected String id;
    protected String type;
    protected int x;
    protected int y;
    protected int z;
    protected int width;
    protected int height;
    protected float rotation = 0f;
    protected float[][] rotationMatrix;
    protected String imageFileName;
    protected BufferedImage image;
    protected Polygon polygon;
    protected boolean isStatic;

    public WorldObject(int x, int y, String imageFileName) {
        this.x = x;
        this.y = y;
        this.imageFileName = imageFileName;
        initImage();
    }

    public WorldObject(String id) {
        setId(id);
        this.rotationMatrix = new float[2][2];
    }

    public WorldObject() {

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float[][] getRotationMatrix() {
        return rotationMatrix;
    }

    public void setRotationMatrix(float[][] matrix) {
        this.rotationMatrix = matrix;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Polygon getPolygon() {
        return polygon;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getRotation() {
        return rotation;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public boolean getIsStatic() {
        return isStatic;
    }

    public void setIsStatic(boolean isStatic) {
        this.isStatic = isStatic;
    }

    public BufferedImage getImage() {
        return this.image;
    }

    public void initImage() {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            image = ImageIO.read(classLoader.getResourceAsStream(imageFileName));
            this.width = image.getWidth();
            this.height = image.getHeight();
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }

    public void initObject() {
        if (id == null)
            setId(type + "_" + (uid++));
        setImageFileName(this.type + ".png");
        initImage();
        addPolygons();
    }

    private Polygon createCrossRoadPolygon() {
        Point crossRoadP1 = new Point(0, 520);
        Point crossRoadP2 = new Point(345, 525);
        Point crossRoadP3 = new Point(530, 345);
        Point crossRoadP4 = new Point(525, 0);
        Point crossRoadP5 = new Point(870, 0);
        Point crossRoadP6 = new Point(865, 360);
        Point crossRoadP7 = new Point(1050, 535);
        Point crossRoadP8 = new Point(1400, 535);
        Point crossRoadP9 = new Point(1400, 870);
        Point crossRoadP10 = new Point(1055, 860);
        Point crossRoadP11 = new Point(870, 1055);
        Point crossRoadP12 = new Point(870, 1390);
        Point crossRoadP13 = new Point(525, 1390);
        Point crossRoadP14 = new Point(525, 1035);
        Point crossRoadP15 = new Point(350, 870);
        Point crossRoadP16 = new Point(0, 875);


        var crossroad = new Polygon();

        crossroad.addPoint(crossRoadP1.x, crossRoadP1.y);
        crossroad.addPoint(crossRoadP2.x, crossRoadP2.y);
        crossroad.addPoint(crossRoadP3.x, crossRoadP3.y);
        crossroad.addPoint(crossRoadP4.x, crossRoadP4.y);
        crossroad.addPoint(crossRoadP5.x, crossRoadP5.y);
        crossroad.addPoint(crossRoadP6.x, crossRoadP6.y);
        crossroad.addPoint(crossRoadP7.x, crossRoadP7.y);
        crossroad.addPoint(crossRoadP8.x, crossRoadP8.y);
        crossroad.addPoint(crossRoadP9.x, crossRoadP9.y);
        crossroad.addPoint(crossRoadP10.x, crossRoadP10.y);
        crossroad.addPoint(crossRoadP11.x, crossRoadP11.y);
        crossroad.addPoint(crossRoadP12.x, crossRoadP12.y);
        crossroad.addPoint(crossRoadP13.x, crossRoadP13.y);
        crossroad.addPoint(crossRoadP14.x, crossRoadP14.y);
        crossroad.addPoint(crossRoadP15.x, crossRoadP15.y);
        crossroad.addPoint(crossRoadP16.x, crossRoadP16.y);

        return crossroad;
    }

    private Polygon create2LaneTJunctionPolygon(boolean isLeft) {
        var road2LaneTJunction = new Polygon();
        Point road2LaneTJunctionP1 = new Point(0, 530);
        Point road2LaneTJunctionP2 = new Point(350, 530);
        Point road2LaneTJunctionP3 = new Point(530, 350);
        Point road2LaneTJunctionP4 = new Point(530, 0);
        Point road2LaneTJunctionP5 = new Point(865, 0);
        Point road2LaneTJunctionP6 = new Point(875, 1400);
        Point road2LaneTJunctionP7 = new Point(525, 1400);
        Point road2LaneTJunctionP8 = new Point(520, 1050);
        Point road2LaneTJunctionP9 = new Point(350, 875);
        Point road2LaneTJunctionP10 = new Point(0, 875);

        Point road2LaneTJunctionP11 = new Point(0, 0);
        Point road2LaneTJunctionP12 = new Point(350, 0);
        Point road2LaneTJunctionP13 = new Point(350, 355);
        Point road2LaneTJunctionP14 = new Point(525, 525);
        Point road2LaneTJunctionP15 = new Point(875, 530);
        Point road2LaneTJunctionP16 = new Point(870, 870);
        Point road2LaneTJunctionP17 = new Point(520, 875);
        Point road2LaneTJunctionP18 = new Point(345, 1055);
        Point road2LaneTJunctionP19 = new Point(350, 1095);
        Point road2LaneTJunctionP20 = new Point(0, 1095);

        if (isLeft) {
            road2LaneTJunction.addPoint(road2LaneTJunctionP1.x, road2LaneTJunctionP1.y);
            road2LaneTJunction.addPoint(road2LaneTJunctionP2.x, road2LaneTJunctionP2.y);
            road2LaneTJunction.addPoint(road2LaneTJunctionP3.x, road2LaneTJunctionP3.y);
            road2LaneTJunction.addPoint(road2LaneTJunctionP4.x, road2LaneTJunctionP4.y);
            road2LaneTJunction.addPoint(road2LaneTJunctionP5.x, road2LaneTJunctionP5.y);
            road2LaneTJunction.addPoint(road2LaneTJunctionP6.x, road2LaneTJunctionP6.y);
            road2LaneTJunction.addPoint(road2LaneTJunctionP7.x, road2LaneTJunctionP7.y);
            road2LaneTJunction.addPoint(road2LaneTJunctionP8.x, road2LaneTJunctionP8.y);
            road2LaneTJunction.addPoint(road2LaneTJunctionP9.x, road2LaneTJunctionP9.y);
            road2LaneTJunction.addPoint(road2LaneTJunctionP10.x, road2LaneTJunctionP10.y);
        } else {
            road2LaneTJunction.addPoint(road2LaneTJunctionP11.x, road2LaneTJunctionP11.y);
            road2LaneTJunction.addPoint(road2LaneTJunctionP12.x, road2LaneTJunctionP12.y);
            road2LaneTJunction.addPoint(road2LaneTJunctionP13.x, road2LaneTJunctionP13.y);
            road2LaneTJunction.addPoint(road2LaneTJunctionP14.x, road2LaneTJunctionP14.y);
            road2LaneTJunction.addPoint(road2LaneTJunctionP15.x, road2LaneTJunctionP15.y);
            road2LaneTJunction.addPoint(road2LaneTJunctionP16.x, road2LaneTJunctionP16.y);
            road2LaneTJunction.addPoint(road2LaneTJunctionP17.x, road2LaneTJunctionP17.y);
            road2LaneTJunction.addPoint(road2LaneTJunctionP18.x, road2LaneTJunctionP18.y);
            road2LaneTJunction.addPoint(road2LaneTJunctionP19.x, road2LaneTJunctionP19.y);
            road2LaneTJunction.addPoint(road2LaneTJunctionP20.x, road2LaneTJunctionP20.y);
        }

        return road2LaneTJunction;
    }

    private Polygon createBicyclePolygon() {
        Point bicycleP1 = new Point(9, 9);
        Point bicycleP2 = new Point(71, 9);
        Point bicycleP3 = new Point(71, 137);
        Point bicycleP4 = new Point(9, 137);
        var bicycle = new Polygon();
        bicycle.addPoint(bicycleP1.x, bicycleP1.y);
        bicycle.addPoint(bicycleP2.x, bicycleP2.y);
        bicycle.addPoint(bicycleP3.x, bicycleP3.y);
        bicycle.addPoint(bicycleP4.x, bicycleP4.y);

        return bicycle;
    }

    private Polygon createBollardPolygon() {
        Point bollardP1 = new Point(0, 0);
        Point bollardP2 = new Point(20, 0);
        Point bollardP3 = new Point(20, 60);
        Point bollardP4 = new Point(0, 60);
        var bollard = new Polygon();

        bollard.addPoint(bollardP1.x, bollardP1.y);
        bollard.addPoint(bollardP2.x, bollardP2.y);
        bollard.addPoint(bollardP3.x, bollardP3.y);
        bollard.addPoint(bollardP4.x, bollardP4.y);

        return bollard;
    }

    private Polygon createBoundaryPolygon() {
        Point boundaryP1 = new Point(0, 0);
        Point boundaryP2 = new Point(50, 0);
        Point boundaryP3 = new Point(50, 85);
        Point boundaryP4 = new Point(0, 85);
        var boundary = new Polygon();
        boundary.addPoint(boundaryP1.x, boundaryP1.y);
        boundary.addPoint(boundaryP2.x, boundaryP2.y);
        boundary.addPoint(boundaryP3.x, boundaryP3.y);
        boundary.addPoint(boundaryP4.x, boundaryP4.y);

        return boundary;
    }

    private Polygon createCarPolygon(boolean isLongCar) {
        Point carP1 = new Point(0, 0);
        Point carP2 = new Point(119, 0);
        Point carP3 = new Point(119, 286);
        Point carP4 = new Point(0, 286);

        Point carP5 = new Point(0, 0);
        Point carP6 = new Point(105, 0);
        Point carP7 = new Point(105, 238);
        Point carP8 = new Point(0, 238);
        var car = new Polygon();

        if (isLongCar) {
            car.addPoint(carP1.x, carP1.y);
            car.addPoint(carP2.x, carP2.y);
            car.addPoint(carP3.x, carP3.y);
            car.addPoint(carP4.x, carP4.y);
        } else {
            car.addPoint(carP5.x, carP5.y);
            car.addPoint(carP6.x, carP6.y);
            car.addPoint(carP7.x, carP7.y);
            car.addPoint(carP8.x, carP8.y);
        }

        return car;
    }

    private Polygon createCrossWalkPolygon() {
        Point crossWalkP1 = new Point(0, 0);
        Point crossWalkP2 = new Point(335, 0);
        Point crossWalkP3 = new Point(335, 195);
        Point crossWalkP4 = new Point(0, 195);
        var crossWalk = new Polygon();
        crossWalk.addPoint(crossWalkP1.x, crossWalkP1.y);
        crossWalk.addPoint(crossWalkP2.x, crossWalkP2.y);
        crossWalk.addPoint(crossWalkP3.x, crossWalkP3.y);
        crossWalk.addPoint(crossWalkP4.x, crossWalkP4.y);

        return crossWalk;
    }

    private Polygon createGaragePolygon() {
        Point GarageP1 = new Point(0, 0);
        Point GarageP2 = new Point(336, 0);
        Point GarageP3 = new Point(336, 294);
        Point GarageP4 = new Point(0, 294);
        var garage = new Polygon();
        garage.addPoint(GarageP1.x, GarageP1.y);
        garage.addPoint(GarageP2.x, GarageP2.y);
        garage.addPoint(GarageP3.x, GarageP3.y);
        garage.addPoint(GarageP4.x, GarageP4.y);

        return garage;
    }

    private Polygon createParkingPolygon(boolean isParallel) {
        Point parkingP1 = new Point(0, 0);
        Point parkingP2 = new Point(141, 0);
        Point parkingP3 = new Point(141, 624);
        Point parkingP4 = new Point(0, 624);

        Point parkingP5 = new Point(0, 0);
        Point parkingP6 = new Point(295, 0);
        Point parkingP7 = new Point(295, 465);
        Point parkingP8 = new Point(0, 465);
        var parking = new Polygon();

        if (isParallel) {
            parking.addPoint(parkingP1.x, parkingP1.y);
            parking.addPoint(parkingP2.x, parkingP2.y);
            parking.addPoint(parkingP3.x, parkingP3.y);
            parking.addPoint(parkingP4.x, parkingP4.y);
        } else {
            parking.addPoint(parkingP5.x, parkingP5.y);
            parking.addPoint(parkingP6.x, parkingP6.y);
            parking.addPoint(parkingP7.x, parkingP7.y);
            parking.addPoint(parkingP8.x, parkingP8.y);
        }

        return parking;
    }

    private Polygon create2Lane6Polygon(boolean isLeft) {
        Point road2lane6P1 = new Point(0, 35);
        Point road2lane6P2 = new Point(345, 0);
        Point road2lane6P3 = new Point(363, 363);
        Point road2lane6P4 = new Point(19, 363);

        Point road2lane6P5 = new Point(19, 0);
        Point road2lane6P6 = new Point(365, 39);
        Point road2lane6P7 = new Point(347, 364);
        Point road2lane6P8 = new Point(0, 360);
        var road2lane6 = new Polygon();

        if (isLeft) {
            road2lane6.addPoint(road2lane6P1.x, road2lane6P1.y);
            road2lane6.addPoint(road2lane6P2.x, road2lane6P2.y);
            road2lane6.addPoint(road2lane6P3.x, road2lane6P3.y);
            road2lane6.addPoint(road2lane6P4.x, road2lane6P4.y);
        } else {
            road2lane6.addPoint(road2lane6P5.x, road2lane6P5.y);
            road2lane6.addPoint(road2lane6P6.x, road2lane6P6.y);
            road2lane6.addPoint(road2lane6P7.x, road2lane6P7.y);
            road2lane6.addPoint(road2lane6P8.x, road2lane6P8.y);
        }

        return road2lane6;
    }

    private Polygon create2Lane45Polygon(boolean isLeft) {
        Point road2lane45P1 = new Point(0, 247);
        Point road2lane45P2 = new Point(247, 0);
        Point road2lane45P3 = new Point(302, 60);
        Point road2lane45P4 = new Point(348, 141);
        Point road2lane45P5 = new Point(380, 226);
        Point road2lane45P6 = new Point(401, 371);
        Point road2lane45P7 = new Point(51, 371);
        Point road2lane45P8 = new Point(43, 321);
        Point road2lane45P9 = new Point(31, 291);
        Point road2lane45P10 = new Point(23, 272);

        Point road2lane45P11 = new Point(0, 368);
        Point road2lane45P12 = new Point(9, 264);
        Point road2lane45P13 = new Point(52, 141);
        Point road2lane45P14 = new Point(91, 74);
        Point road2lane45P15 = new Point(154, 0);
        Point road2lane45P16 = new Point(399, 244);
        Point road2lane45P17 = new Point(372, 284);
        Point road2lane45P18 = new Point(359, 316);
        Point road2lane45P19 = new Point(349, 369);
        var road2lane45 = new Polygon();

        if (isLeft) {
            road2lane45.addPoint(road2lane45P1.x, road2lane45P1.y);
            road2lane45.addPoint(road2lane45P2.x, road2lane45P2.y);
            road2lane45.addPoint(road2lane45P3.x, road2lane45P3.y);
            road2lane45.addPoint(road2lane45P4.x, road2lane45P4.y);
            road2lane45.addPoint(road2lane45P5.x, road2lane45P5.y);
            road2lane45.addPoint(road2lane45P6.x, road2lane45P6.y);
            road2lane45.addPoint(road2lane45P7.x, road2lane45P7.y);
            road2lane45.addPoint(road2lane45P8.x, road2lane45P8.y);
            road2lane45.addPoint(road2lane45P9.x, road2lane45P9.y);
            road2lane45.addPoint(road2lane45P10.x, road2lane45P10.y);
        } else {
            road2lane45.addPoint(road2lane45P11.x, road2lane45P11.y);
            road2lane45.addPoint(road2lane45P12.x, road2lane45P12.y);
            road2lane45.addPoint(road2lane45P13.x, road2lane45P13.y);
            road2lane45.addPoint(road2lane45P14.x, road2lane45P14.y);
            road2lane45.addPoint(road2lane45P15.x, road2lane45P15.y);
            road2lane45.addPoint(road2lane45P16.x, road2lane45P16.y);
            road2lane45.addPoint(road2lane45P17.x, road2lane45P17.y);
            road2lane45.addPoint(road2lane45P18.x, road2lane45P18.y);
            road2lane45.addPoint(road2lane45P19.x, road2lane45P19.y);
        }

        return road2lane45;
    }

    private Polygon create2Lane90Polygon(boolean isLeft) {
        Point road2lane90P1 = new Point(0, 0);
        Point road2lane90P2 = new Point(127, 17);
        Point road2lane90P3 = new Point(206, 43);
        Point road2lane90P4 = new Point(276, 79);
        Point road2lane90P5 = new Point(343, 127);
        Point road2lane90P6 = new Point(428, 221);
        Point road2lane90P7 = new Point(456, 265);
        Point road2lane90P8 = new Point(470, 293);
        Point road2lane90P9 = new Point(506, 394);
        Point road2lane90P10 = new Point(523, 521);
        Point road2lane90P11 = new Point(175, 521);
        Point road2lane90P12 = new Point(164, 462);
        Point road2lane90P13 = new Point(121, 401);
        Point road2lane90P14 = new Point(75, 369);
        Point road2lane90P15 = new Point(0, 350);

        Point road2lane90P16 = new Point(0, 520);
        Point road2lane90P17 = new Point(20, 375);
        Point road2lane90P18 = new Point(62, 278);
        Point road2lane90P19 = new Point(133, 175);
        Point road2lane90P20 = new Point(244, 82);
        Point road2lane90P21 = new Point(345, 28);
        Point road2lane90P22 = new Point(522, 0);
        Point road2lane90P23 = new Point(522, 350);
        Point road2lane90P24 = new Point(468, 360);
        Point road2lane90P25 = new Point(427, 388);
        Point road2lane90P26 = new Point(386, 419);
        Point road2lane90P27 = new Point(363, 456);
        Point road2lane90P28 = new Point(348, 524);
        var road2lane90 = new Polygon();

        if (isLeft) {
            road2lane90.addPoint(road2lane90P1.x, road2lane90P1.y);
            road2lane90.addPoint(road2lane90P2.x, road2lane90P2.y);
            road2lane90.addPoint(road2lane90P3.x, road2lane90P3.y);
            road2lane90.addPoint(road2lane90P4.x, road2lane90P4.y);
            road2lane90.addPoint(road2lane90P5.x, road2lane90P5.y);
            road2lane90.addPoint(road2lane90P6.x, road2lane90P6.y);
            road2lane90.addPoint(road2lane90P7.x, road2lane90P7.y);
            road2lane90.addPoint(road2lane90P8.x, road2lane90P8.y);
            road2lane90.addPoint(road2lane90P9.x, road2lane90P9.y);
            road2lane90.addPoint(road2lane90P10.x, road2lane90P10.y);
            road2lane90.addPoint(road2lane90P11.x, road2lane90P11.y);
            road2lane90.addPoint(road2lane90P12.x, road2lane90P12.y);
            road2lane90.addPoint(road2lane90P13.x, road2lane90P13.y);
            road2lane90.addPoint(road2lane90P14.x, road2lane90P14.y);
            road2lane90.addPoint(road2lane90P15.x, road2lane90P15.y);
        } else {
            road2lane90.addPoint(road2lane90P16.x, road2lane90P16.y);
            road2lane90.addPoint(road2lane90P17.x, road2lane90P17.y);
            road2lane90.addPoint(road2lane90P18.x, road2lane90P18.y);
            road2lane90.addPoint(road2lane90P19.x, road2lane90P19.y);
            road2lane90.addPoint(road2lane90P20.x, road2lane90P20.y);
            road2lane90.addPoint(road2lane90P21.x, road2lane90P21.y);
            road2lane90.addPoint(road2lane90P22.x, road2lane90P22.y);
            road2lane90.addPoint(road2lane90P23.x, road2lane90P23.y);
            road2lane90.addPoint(road2lane90P24.x, road2lane90P24.y);
            road2lane90.addPoint(road2lane90P25.x, road2lane90P25.y);
            road2lane90.addPoint(road2lane90P26.x, road2lane90P26.y);
            road2lane90.addPoint(road2lane90P27.x, road2lane90P27.y);
            road2lane90.addPoint(road2lane90P28.x, road2lane90P28.y);
        }

        return road2lane90;
    }

    private Polygon create2LaneRotaryPolygon() {
        Point road2laneRotaryP1 = new Point(0, 533);
        Point road2laneRotaryP2 = new Point(341, 517);
        Point road2laneRotaryP3 = new Point(525, 341);
        Point road2laneRotaryP4 = new Point(525, 0);
        Point road2laneRotaryP5 = new Point(870, 0);
        Point road2laneRotaryP6 = new Point(860, 349);
        Point road2laneRotaryP7 = new Point(1050, 530);
        Point road2laneRotaryP8 = new Point(1397, 537);
        Point road2laneRotaryP9 = new Point(1397, 862);
        Point road2laneRotaryP10 = new Point(1040, 869);
        Point road2laneRotaryP11 = new Point(860, 1045);
        Point road2laneRotaryP12 = new Point(865, 1389);
        Point road2laneRotaryP13 = new Point(530, 1389);
        Point road2laneRotaryP14 = new Point(525, 1037);
        Point road2laneRotaryP15 = new Point(345, 865);
        Point road2laneRotaryP16 = new Point(0, 865);

        var road2laneRotary = new Polygon();
        road2laneRotary.addPoint(road2laneRotaryP1.x, road2laneRotaryP1.y);
        road2laneRotary.addPoint(road2laneRotaryP2.x, road2laneRotaryP2.y);
        road2laneRotary.addPoint(road2laneRotaryP3.x, road2laneRotaryP3.y);
        road2laneRotary.addPoint(road2laneRotaryP4.x, road2laneRotaryP4.y);
        road2laneRotary.addPoint(road2laneRotaryP5.x, road2laneRotaryP5.y);
        road2laneRotary.addPoint(road2laneRotaryP6.x, road2laneRotaryP6.y);
        road2laneRotary.addPoint(road2laneRotaryP7.x, road2laneRotaryP7.y);
        road2laneRotary.addPoint(road2laneRotaryP8.x, road2laneRotaryP8.y);
        road2laneRotary.addPoint(road2laneRotaryP9.x, road2laneRotaryP9.y);
        road2laneRotary.addPoint(road2laneRotaryP10.x, road2laneRotaryP10.y);
        road2laneRotary.addPoint(road2laneRotaryP11.x, road2laneRotaryP11.y);
        road2laneRotary.addPoint(road2laneRotaryP12.x, road2laneRotaryP12.y);
        road2laneRotary.addPoint(road2laneRotaryP13.x, road2laneRotaryP13.y);
        road2laneRotary.addPoint(road2laneRotaryP14.x, road2laneRotaryP14.y);
        road2laneRotary.addPoint(road2laneRotaryP15.x, road2laneRotaryP15.y);
        road2laneRotary.addPoint(road2laneRotaryP16.x, road2laneRotaryP16.y);

        return road2laneRotary;
    }

    private Polygon create2LaneStraightPolygon() {
        Point roadStraightP1 = new Point(0, 0);
        Point roadStraightP2 = new Point(350, 0);
        Point roadStraightP3 = new Point(350, 350);
        Point roadStraightP4 = new Point(0, 350);
        var roadStraight = new Polygon();
        roadStraight.addPoint(roadStraightP1.x, roadStraightP1.y);
        roadStraight.addPoint(roadStraightP2.x, roadStraightP2.y);
        roadStraight.addPoint(roadStraightP3.x, roadStraightP3.y);
        roadStraight.addPoint(roadStraightP4.x, roadStraightP4.y);

        return roadStraight;
    }

    private Polygon createParkingSignPolygon() {
        Point parkingSignP1 = new Point(0, 0);
        Point parkingSignP2 = new Point(80, 0);
        Point parkingSignP3 = new Point(80, 80);
        Point parkingSignP4 = new Point(0, 80);
        var parkingSign = new Polygon();
        parkingSign.addPoint(parkingSignP1.x, parkingSignP1.y);
        parkingSign.addPoint(parkingSignP2.x, parkingSignP2.y);
        parkingSign.addPoint(parkingSignP3.x, parkingSignP3.y);
        parkingSign.addPoint(parkingSignP4.x, parkingSignP4.y);

        return parkingSign;
    }

    private Polygon createStopSignPolygon() {
        Point stopSignP1 = new Point(0, 23);
        Point stopSignP2 = new Point(23, 0);
        Point stopSignP3 = new Point(56, 0);
        Point stopSignP4 = new Point(80, 23);
        Point stopSignP5 = new Point(80, 55);
        Point stopSignP6 = new Point(55, 80);
        Point stopSignP7 = new Point(23, 80);
        var stopSign = new Polygon();
        stopSign.addPoint(stopSignP1.x, stopSignP1.y);
        stopSign.addPoint(stopSignP2.x, stopSignP2.y);
        stopSign.addPoint(stopSignP3.x, stopSignP3.y);
        stopSign.addPoint(stopSignP4.x, stopSignP4.y);
        stopSign.addPoint(stopSignP5.x, stopSignP5.y);
        stopSign.addPoint(stopSignP6.x, stopSignP6.y);
        stopSign.addPoint(stopSignP7.x, stopSignP7.y);

        return stopSign;
    }

    private Polygon createSpeedSignPolygon() {
        Point speedSignP1 = new Point(0, 38);
        Point speedSignP2 = new Point(10, 12);
        Point speedSignP3 = new Point(40, 0);
        Point speedSignP4 = new Point(66, 10);
        Point speedSignP5 = new Point(79, 40);
        Point speedSignP6 = new Point(70, 65);
        Point speedSignP7 = new Point(40, 80);
        Point speedSignP8 = new Point(10, 67);
        var speedSign = new Polygon();
        speedSign.addPoint(speedSignP1.x, speedSignP1.y);
        speedSign.addPoint(speedSignP2.x, speedSignP2.y);
        speedSign.addPoint(speedSignP3.x, speedSignP3.y);
        speedSign.addPoint(speedSignP4.x, speedSignP4.y);
        speedSign.addPoint(speedSignP5.x, speedSignP5.y);
        speedSign.addPoint(speedSignP6.x, speedSignP6.y);
        speedSign.addPoint(speedSignP7.x, speedSignP7.y);
        speedSign.addPoint(speedSignP8.x, speedSignP8.y);

        return speedSign;
    }

    private Polygon createTreePolygon() {
        Point treeP1 = new Point(73, 55);
        Point treeP2 = new Point(88, 63);
        Point treeP3 = new Point(94, 74);
        Point treeP4 = new Point(87, 94);
        Point treeP5 = new Point(71, 100);
        Point treeP6 = new Point(54, 93);
        Point treeP7 = new Point(45, 78);
        Point treeP8 = new Point(53, 63);

        var tree = new Polygon();
        tree.addPoint(treeP1.x, treeP1.y);
        tree.addPoint(treeP2.x, treeP2.y);
        tree.addPoint(treeP3.x, treeP3.y);
        tree.addPoint(treeP4.x, treeP4.y);
        tree.addPoint(treeP5.x, treeP5.y);
        tree.addPoint(treeP6.x, treeP6.y);
        tree.addPoint(treeP7.x, treeP7.y);
        tree.addPoint(treeP8.x, treeP8.y);

        return tree;
    }

    private Polygon createPersonPolygon() {
        Point personP1 = new Point(0, 0);
        Point personP2 = new Point(47, 0);
        Point personP3 = new Point(47, 74);
        Point personP4 = new Point(0, 74);


        var person = new Polygon();
        person.addPoint(personP1.x, personP1.y);
        person.addPoint(personP2.x, personP2.y);
        person.addPoint(personP3.x, personP3.y);
        person.addPoint(personP4.x, personP4.y);

        return person;
    }

    private void addPolygons() {
        Map<String, Polygon> addActions = new HashMap<String, Polygon>();
        addActions.put("2_crossroad_1", createCrossRoadPolygon());
        addActions.put("2_crossroad_2", createCrossRoadPolygon());
        addActions.put("bollard", createBollardPolygon());
        addActions.put("bicycle", createBicyclePolygon());
        addActions.put("boundary", createBoundaryPolygon());
        addActions.put("car_1_blue", createCarPolygon(false));
        addActions.put("car_1_red", createCarPolygon(false));
        addActions.put("car_1_white", createCarPolygon(false));
        addActions.put("car_2_blue", createCarPolygon(false));
        addActions.put("car_2_red", createCarPolygon(false));
        addActions.put("car_2_white", createCarPolygon(false));
        addActions.put("car_3_black", createCarPolygon(true));
        addActions.put("crosswalk", createCrossWalkPolygon());
        addActions.put("garage", createGaragePolygon());
        addActions.put("man", createPersonPolygon());
        addActions.put("woman", createPersonPolygon());
        addActions.put("parking_90", createParkingPolygon(false));
        addActions.put("parking_space_parallel", createParkingPolygon(true));
        addActions.put("road_2lane_6left", create2Lane6Polygon(true));
        addActions.put("road_2lane_6right", create2Lane6Polygon(false));
        addActions.put("road_2lane_45left", create2Lane45Polygon(true));
        addActions.put("road_2lane_45right", create2Lane45Polygon(false));
        addActions.put("road_2lane_90left", create2Lane90Polygon(true));
        addActions.put("road_2lane_90right", create2Lane90Polygon(false));
        addActions.put("road_2lane_rotary", create2LaneRotaryPolygon());
        addActions.put("road_2lane_straight", create2LaneStraightPolygon());
        addActions.put("road_2lane_tjunctionleft", create2LaneTJunctionPolygon(true));
        addActions.put("road_2lane_tjunctionright", create2LaneTJunctionPolygon(false));
        addActions.put("roadsign_parking_right", createParkingSignPolygon());
        addActions.put("roadsign_priority_stop", createStopSignPolygon());
        addActions.put("roadsign_speed_40", createSpeedSignPolygon());
        addActions.put("roadsign_speed_50", createSpeedSignPolygon());
        addActions.put("roadsign_speed_60", createSpeedSignPolygon());
        addActions.put("tree", createTreePolygon());

        this.polygon = addActions.get(this.type);


    }
}
