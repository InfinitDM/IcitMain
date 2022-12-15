package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.units.PlayerTank;
import com.mygdx.game.units.Tank;

public class MyGdxGame extends ApplicationAdapter {
	private Map map;
	private SpriteBatch batch;
	private PlayerTank player;
	private BulletEmitter bulletEmitter;
	private BotEmitter botEmitter;
	private float gameTimer;

	public BulletEmitter getBulletEmitter() {
		return bulletEmitter;
	}

	@Override
	public void create () {
		batch = new SpriteBatch();
		map = new Map();
		player = new PlayerTank(this);
		bulletEmitter = new BulletEmitter();
		botEmitter = new BotEmitter(this);
		botEmitter.activate(MathUtils.random(0, Gdx.graphics.getWidth()),MathUtils.random(0, Gdx.graphics.getHeight()) );
	}

	@Override
	public void render () {
		float dt = Gdx.graphics.getDeltaTime();
		update(dt);
		ScreenUtils.clear(0, 1,0,0);
		batch.begin();
		map.render(batch);

		player.render(batch);
		botEmitter.render(batch);
		bulletEmitter.render(batch);
		batch.end();
	}

	public void update(float dt){
		gameTimer += dt;
		if (gameTimer > 5.0f){
			gameTimer = 0.0f;
			botEmitter.activate(MathUtils.random(0, Gdx.graphics.getWidth()),MathUtils.random(0, Gdx.graphics.getHeight()) );
		}
		player.update(dt);
		botEmitter.update(dt);
		bulletEmitter.update(dt);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
