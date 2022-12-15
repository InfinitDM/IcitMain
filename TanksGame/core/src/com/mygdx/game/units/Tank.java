package com.mygdx.game.units;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.utilit.Added_Utils;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Weapon;

public abstract class  Tank {
    MyGdxGame game;
    Weapon weapon;
    float fierTimer;

    int hp;
    int hpMax;

    Texture texture;
    Texture textureTurret;
    Vector2 position;
    float speed;
    float angle;
    float Turretangle;
    int wight;
    int height;


    public Tank(MyGdxGame game){
        this.game = game;

    }

    public void render(SpriteBatch batch){
        batch.draw(texture,position.x-wight / 2,position.y-height / 2,wight / 2,height/2
                ,wight,height,1,1,angle,0,0,wight,height,false,false);
        batch.draw(weapon.getTexture(),position.x-wight / 2,position.y-height / 2,wight / 2,height / 2
                ,wight,height,1,1,Turretangle,0,0,wight,height,false,false);

    }

    public void rotateTurretToPoint(float pointX, float pointY, float dt){
        float angleTo = Added_Utils.getAngle( position.x, position.y, pointY,pointX);
        Turretangle = Added_Utils.makeRotation(Turretangle, angleTo, 270.0f, dt);
        Turretangle = Added_Utils.angleToFromNegPiToPosPi(Turretangle);
    }

    public abstract  void update(float dt);

    public void fire(float dt){
        fierTimer += dt;
        if (fierTimer >= weapon.getFirePeriod()){
            fierTimer = 0.0f;
            float angelRad = (float) Math.toRadians(Turretangle);
            game.getBulletEmitter().activate(position.x, position.y, 320.0f* (float)Math.cos(angelRad),320* (float)Math.sin(angelRad), weapon.getDamage());
        }
    }
}
