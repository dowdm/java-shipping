package models;

import java.util.ArrayList;

public class Parcel {
    public int length;
    public int width;
    public int height;
    public int weight;
    public int volume;
    public double cost;


    public Parcel(int length, int width, int height, int weight){
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
        this.volume = length * width * height;
        this.cost = 0.00;
    }

    public double costToShip(String speed){
        if (speed.equals("standard")){
            if (this.volume <= 2000 && this.weight <= 100){
                return this.cost = this.volume * .01;
            } else if (this.volume <= 2000 && this.weight > 100){
                return this.cost = this.volume * .02;
            } else if (this.volume > 2000 && this.weight <= 100){
                return this.cost = this.volume * .03;
            } else {
                return this.cost = this.volume * .04;
            }
        } else {
            if (this.volume <= 2000 && this.weight <= 100) {
                return this.cost = this.volume * .03;
            } else if (this.volume <= 2000 && this.weight > 100) {
                return this.cost = this.volume * .06;
            } else if (this.volume > 2000 && this.weight <= 100) {
                return this.cost = this.volume * .09;
            } else {
                return this.cost = this.volume * .12;
            }
        }
    }

    public double giftWrap(String option){
        if (option.equals("yes")) {
            return this.cost += ((this.length * 2) + (this.height * 2) + (this.width * 2)) * 0.02;
        } else {
            return this.cost;
        }
    }

}
