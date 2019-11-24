package Game;

import Characters.MainCharacter;
import Config.Reloj;
import Input.InputManager;
import Strategy.ActionProvider;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import java.util.Timer;
import java.util.TimerTask;

public class Game extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture img;
        private Texture charImg;
        private int clockX=1120;
        private int clockY=1000;
        private String relojMsg = "";
        private Timer timer = new java.util.Timer();     
        private Reloj reloj;
        private Home home;
        private MainCharacter main;
        private Stage  stage; 
        private TextButton button;
        private TextButton defButton;
        private TextButton sleepButton;
        private BitmapFont font;
        private TextButtonStyle  textButtonStyle;
        private String currentAction = "";
        private ActionProvider action = new ActionProvider();
        boolean moving = false;
        float distance;
        Vector2 direccion;
        Vector2 posInicial;
        
        public Game(Reloj reloj,Home h,MainCharacter main){
            super();
            this.reloj  = reloj;
            this.relojMsg = this.reloj.getHoraActual();
            this.home = h;
            this.main = main;
            
        }
        
	@Override
	public void create () {    
            
            stage = new Stage();
            font = new BitmapFont();
            textButtonStyle = new TextButtonStyle(); 
            textButtonStyle.font = font;
            
            //Declaracion de botones
            button = new TextButton("Orinar",textButtonStyle);
            button.setPosition(0,0);
            defButton = new TextButton("Defecar",textButtonStyle);
            defButton.setPosition(50,0);
            sleepButton = new TextButton("Dormir",textButtonStyle);
            sleepButton.setPosition(110,0);
            
            
            stage.addActor(button);
            stage.addActor(defButton);
            stage.addActor(sleepButton);
            
            //Declaracion de actionListener de botones
            button.addListener(new ChangeListener() {
                @Override
                public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                    orinar();
                }
            });
            defButton.addListener(new ChangeListener() {
                @Override
                public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                    defecar();
                }
            });
            sleepButton.addListener(new ChangeListener() {
                @Override
                public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                    dormir();
                }
            });
            
            
            
            Gdx.input.setInputProcessor(stage);
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    reloj.actualizar();
                    relojMsg = reloj.getHoraActual();
                    if(!moving && currentAction.compareTo("")!=0){
                        boolean cont = action.action(main);
                        System.out.println(main.getTiredness());
                        if(!cont){
                            currentAction = "";
                        }
                    }   
                    //render();
                }
            },reloj.getAvance(),reloj.getAvance());
	    batch = new SpriteBatch();
            
	    img = new Texture("goku.png");
            charImg = new Texture(this.main.getImages().get(0));
	}

	@Override
	public void render () {
            if(moving){
                this.main.setxPos((int) (this.main.getxPos() + direccion.x*(5)));
                this.main.setyPos((int) (this.main.getyPos() + direccion.x*(5)));
                if(Vector2.dst(posInicial.x, posInicial.y, this.main.getxPos(),this.main.getyPos())>= distance){
                    moving = false;
                    
                    
                }
            }      
            BitmapFont font = new BitmapFont();
            Gdx.gl.glClearColor(0,0, 0, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	    batch.begin();
            batch.draw(img, 0, 0);
            batch.draw(charImg, this.main.getxPos(),this.main.getyPos(),75,75);
            
            font.draw(batch,relojMsg, clockX,clockY);
            batch.end();
            //Gdx.input.setInputProcessor(new InputManager(this.home));
            stage.draw();
            stage.act();

                
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
        
        public void orinar(){
            Vector2 posBano = home.getSeccion("Banio").cpy();
            
            posInicial = new Vector2(this.main.getxPos(),this.main.getyPos());
            distance = posInicial.dst(posBano);
            direccion =posBano.sub(posInicial).nor();

            moving = true;
            this.currentAction = "Pee";
            this.action.setAccion("Pee");
            
        }
        public void defecar(){
            Vector2 posBano = home.getSeccion("Cocina").cpy();
            posInicial = new Vector2(this.main.getxPos(),this.main.getyPos());
            distance = posInicial.dst(posBano);
            direccion =posBano.sub(posInicial).nor();
            moving = true;
            this.currentAction = "Poo";
            this.action.setAccion("Poo");
        }
        
        public void dormir(){
            Vector2 posBano = home.getSeccion("Cuarto").cpy();
            posInicial = new Vector2(this.main.getxPos(),this.main.getyPos());
            distance = posInicial.dst(posBano);
            direccion =posBano.sub(posInicial).nor();
            moving = true;
            this.currentAction = "Sleep";
            this.action.setAccion("Sleep");
        }
}
