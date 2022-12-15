package com.mygdx.game.utilit;

import com.badlogic.gdx.math.Vector2;

public class Added_Utils {
    public static final float pi = 90;
    public static final float pi2 = 180;
    public static final float piD2 = 45;
    public static final float pi3D2 = 270;

    public static float getAngle(float x1, float y1, float x2, float y2){
        float dx = x2 - x1;
        float dy = y2 - y1;
        return (float) Math.toDegrees((float) Math.atan2(dy,dx));
    }
    
    public static float lerp(float value1, float value2, float point){
        return value1 + (value2-value1);
    }

    public static float makeRotation(float angle,  float angleTo, float rotatiomSpeed, float dt){
        if (angle < angleTo){
            if (Math.abs(angle-angleTo) < 180){
                angle += rotatiomSpeed * dt;
            }else {
                angle -= rotatiomSpeed * dt;
            }
        }
        if (angle > angleTo){
            if (Math.abs(angle - angleTo) < 180){
                angle -= rotatiomSpeed * dt;
            }else {
                angle += rotatiomSpeed * dt;
            }
        }
        if (Math.abs(angle - angleTo) < 1.5f * rotatiomSpeed * dt){
            angle = angleTo;
        }
        return angle;
    }

    public static float angleToFromNegPiToPosPi(float ang){
        while (ang < -180 || ang > 180){
            if (ang > 180){
                ang -= 360;
            }
            if (ang < -180){
                ang += 360;
            }
        }
        return ang;
    }

    public static void normalizePosition(Vector2 v){
        v.x = Math.round(v.x / 32.0f) * 32.0f;
        v.y = Math.round(v.y / 32.0f) * 32.0f;
    }
}
