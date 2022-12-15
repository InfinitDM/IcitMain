package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Weapon {
    private Texture texture;
    private float firePeriod;
    private int damage;

    public float getFirePeriod() {
        return firePeriod;
    }

    public int getDamage() {
        return damage;
    }

    public Texture getTexture() {
        return texture;
    }

    public Weapon(){
        this.texture = new Texture("simple_weapon.png");
        this.damage = 1;
        this.firePeriod = 0.2f;
    }
}
