package com.example.demo;

public class mapRequest {
    landDetails land;

    public mapRequest(landDetails land) {
        this.land = land;
    }

    public landDetails getLand() {
        return land;
    }

    public void setLand(landDetails land) {
        this.land = land;
    }

    public String generateMap()
    {
        String map="";
        if(land!=null)
        {
            map="MAP";
        }
        return map;
    }
}
