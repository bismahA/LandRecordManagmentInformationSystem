package com.example.demo;

public class addLandRequest {

    landDetails land;

    public addLandRequest(landDetails land) {
        this.land = land;
    }

    public landDetails getLand() {
        return land;
    }

    public void setLand(landDetails land) {
        this.land = land;
    }
}
