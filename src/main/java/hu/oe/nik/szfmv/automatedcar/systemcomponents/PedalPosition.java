package hu.oe.nik.szfmv.automatedcar.systemcomponents;

public class PedalPosition {

    private double gasPedalValue;
    private boolean gasPedalSwitch;//true -> down, false -> up
    private double breakPedalValue;
    private boolean breakPedalSwitch;
    private double steeringWheelValue;//-180 - 180
    private boolean steeringWheelRight;
    private boolean steeringWheelLeft;

    public void startSteeringRight(){
        if(!steeringWheelRight) {
            steeringWheelRight = true;
            steeringRight();
        }
    }

    private void steeringRight(){
        Thread valueChangeThread = new Thread(()->{
            int counter = 0;
            while(steeringWheelRight && steeringWheelValue<180.0)
            {

                if(steeringWheelValueValidRange(steeringWheelValue+increaseNumber(counter))) {
                    steeringWheelValue += increaseNumber(counter);
                }
                else{
                    steeringWheelValue=180;
                }
                counter++;
                Sleep();
            }
        });
        valueChangeThread.start();
    }

    public void startSteeringLeft(){
        if(!steeringWheelLeft){
            steeringWheelLeft=true;
            steeringLeft();
        }
    }

    private void steeringLeft(){
        Thread valueChangeThread = new Thread(()->{
            int counter = 0;
            while(steeringWheelRight && steeringWheelValue> -180.0)
            {

                if(steeringWheelValueValidRange(steeringWheelValue+increaseNumber(counter))) {
                    steeringWheelValue -= increaseNumber(counter);
                }
                else{
                    steeringWheelValue= -180;
                }
                counter++;
                Sleep();
            }
        });
        valueChangeThread.start();
    }

    public void steeringWheelReleased(){
        Thread valueChangeThread = new Thread(()->{
            int counter = 0;
            while(!steeringWheelRight && !steeringWheelLeft && !(steeringWheelValue==0.0)) {
                counter++;
                steeringWheelValue+=steeringWheelToZero(steeringWheelValue,counter);
            }
        });
        valueChangeThread.start();
    }

    public void gasPedalDown(){
        if(!gasPedalSwitch) {
        gasPedalSwitch=true;
        gasPedalValueIncrease();
        }
    }

    private void gasPedalValueIncrease(){
        Thread valueChangeThread = new Thread(()->{
            int counter = 0;
            while(gasPedalSwitch && gasPedalValue<100.0)
            {

                if(PedalValueValidRange(gasPedalValue+increaseNumber(counter))) {
                    gasPedalValue += increaseNumber(counter);
                }
                else{
                    gasPedalValue=100;
                }
                counter++;
                Sleep();
            }
        });
        valueChangeThread.start();
    }

    public void gasPedalUp(){
        gasPedalSwitch = false;
        gasPedalValueDecrease();;
    }

    private void gasPedalValueDecrease(){
        Thread valueChangeThread = new Thread(()->{
            int counter = 0;
            while(gasPedalSwitch && gasPedalValue>=0.0)
            {

                if(PedalValueValidRange(gasPedalValue-increaseNumber(counter))) {
                    gasPedalValue -= increaseNumber(counter);
                }
                else{
                    gasPedalValue=0;
                }
                counter++;
                Sleep();
            }
        });
        valueChangeThread.start();
    }

    public void breakPedalDown() {
        if (!breakPedalSwitch) {
            breakPedalSwitch = true;
            breakPedalValueIncrease();
        }
    }

    private void breakPedalValueIncrease(){
        Thread valueChangeThread = new Thread(()->{
            int counter = 0;
            while(breakPedalSwitch && breakPedalValue<100.0)
            {

                if(PedalValueValidRange(breakPedalValue+increaseNumber(counter))) {
                    breakPedalValue += increaseNumber(counter);
                }
                else{
                    breakPedalValue=100;
                }
                counter++;
                Sleep();
            }
        });
        valueChangeThread.start();
    }

    public void breakPedalUp(){
        breakPedalSwitch = false;
        breakPedalValueDecrease();
    }

    private void breakPedalValueDecrease(){
        Thread valueChangeThread = new Thread(()->{
            int counter = 0;
            while(!breakPedalSwitch && breakPedalValue>0.0)
            {

                if(PedalValueValidRange(breakPedalValue+increaseNumber(counter))) {
                    breakPedalValue += increaseNumber(counter);
                }
                else{
                    breakPedalValue=100;
                }
                counter++;
                Sleep();
            }
        });
        valueChangeThread.start();
    }

    private int increaseNumber(int counter){
        if(counter <5){
            return 5;
        }
        else if(counter < 10){
            return 10;
        }
        else{
            return 15;
        }
    }

    private void Sleep(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean PedalValueValidRange(double value){
        if(value>=0.0 && value <=100.0){
            return true;
        }
        else{
            return false;
        }
    }

    private boolean steeringWheelValueValidRange(double value){
        if(value>=-180.0 && value<=180.0){
            return true;
        }
        else{
            return false;
        }
    }

    private int steeringWheelToZero(double value,int counter){

        int outputValue;

        if(counter <5){
            outputValue= 5;
        }
        else if(counter < 10){
            outputValue= 10;
        }
        else{
            outputValue= 15;
        }

        if(value<0){
            if(value+outputValue>0){
            return (int)-value;
            }
            else{
                return outputValue;
            }
        }
        else{
            if(value-outputValue<0){
                return (int)-value;
            }
            else {
                return -outputValue;
            }
        }
    }
};