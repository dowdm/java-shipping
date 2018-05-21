package models;

public class Parcel {
    int length;
    int width;
    int height;
    int weight;
    int volume;


    public Parcel(int length, int width, int height, int weight){
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
        this.volume = length * width * height;
    }

    public double costToShip(String speed){
        if (speed.equals("standard")){
            if (this.volume <= 2000 && this.weight <= 100){
                return this.volume * .01;
            } else if (this.volume <= 2000 && this.weight > 100){
                return this.volume * .02;
            } else if (this.volume > 2000 && this.weight <= 100){
                return this.volume * .03;
            } else {
                return this.volume * .04;
            }
        } else {
            if (this.volume <= 2000 && this.weight <= 100) {
                return this.volume * .03;
            } else if (this.volume <= 2000 && this.weight > 100) {
                return this.volume * .06;
            } else if (this.volume > 2000 && this.weight <= 100) {
                return this.volume * .09;
            } else {
                return this.volume * .12;
            }
        }
    }
}
