package Game;

import Config.Reloj;
import Input.InputManager;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.Timer;
import java.util.TimerTask;

public class Game extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture img;
        private int clockX=1120;
        private int clockY=1000;
        private String relojMsg = "";
        private Timer timer = new java.util.Timer();     
        private Reloj reloj;
        private Home home;
        
        public Game(Reloj reloj,Home h){
            super();
            this.reloj  = reloj;
            this.relojMsg = this.reloj.getHoraActual();
            this.home = h;
            
        }
        
	@Override
	public void create () {    
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    reloj.actualizar();
                    relojMsg = reloj.getHoraActual();
                    //render();
                }
            },reloj.getAvance(),reloj.getAvance());
	    batch = new SpriteBatch();
            
	    img = new Texture("goku.png");
	}

	@Override
	public void render () {
            
            BitmapFont font = new BitmapFont();
            Gdx.gl.glClearColor(0,0, 0, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	    batch.begin();
            batch.draw(img, 0, 0);
            font.draw(batch,relojMsg, clockX,clockY);
 
            batch.end();
            
            
            Gdx.input.setInputProcessor(new InputManager(this.home));

                
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
