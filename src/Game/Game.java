package Game;

import Characters.Ability;
import Characters.MainCharacter;
import Config.Reloj;
import Facilities.Huerto;
import Facilities.Sickness;
import Facilities.Storage;
import Input.InputManager;
import Strategy.ActionProvider;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.kotcrab.vis.ui.VisUI;
import java.util.Timer;
import java.util.TimerTask;

public class Game extends ApplicationAdapter {
	private SpriteBatch batch;
        
	private Texture img;
        private Texture charImg;
        
        private Texture concinaImg;
        private Texture cuartoImg;
        private Texture banioImg;
        private Texture comedorImg;
        private Texture huertoImg;
        private Texture zonaEjImg;
        private Texture zonaPImg;
        private Texture jardinImg;
        
        private int clockX=1060;
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
        private TextButton eatButton;
        private TextButton collectButton;
        private TextButton cureButton;
        private TextButton excButton;
        private TextButton meditateButton;
        private TextButton showAbisButton;
        
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
            VisUI.load();
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
            eatButton = new TextButton("Comer",textButtonStyle);
            eatButton.setPosition(160,0);
            collectButton = new TextButton("Huerto",textButtonStyle);
            collectButton.setPosition(210,0);
            cureButton = new TextButton("Curar",textButtonStyle);
            cureButton.setPosition(260, 0);
            excButton = new TextButton("Ejercicio",textButtonStyle);
            excButton.setPosition(310,0);
            showAbisButton = new TextButton("Ver Habilidades",textButtonStyle);
            showAbisButton.setPosition(380, 0);
            meditateButton = new TextButton("Meditar",textButtonStyle);
            meditateButton.setPosition(500, 0);
            
            
            stage.addActor(button);
            stage.addActor(defButton);
            stage.addActor(sleepButton);
            stage.addActor(eatButton);
            stage.addActor(collectButton);
            stage.addActor(cureButton);
            stage.addActor(excButton);
            stage.addActor(showAbisButton);
            stage.addActor(meditateButton);
            
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
            
            eatButton.addListener(new ChangeListener() {
                @Override
                public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                    comer();
                }
            });
            
            collectButton.addListener(new ChangeListener() {
                @Override
                public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                    collect();
                }
            });
            
            cureButton.addListener(new ChangeListener() {
                @Override
                public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                    cure();
                }
            });
            
            excButton.addListener(new ChangeListener() {
                @Override
                public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                    excercise();
                }
            });
            
            showAbisButton.addListener(new ChangeListener() {
                @Override
                public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                    showAbilities();
                }
            });
            
            meditateButton.addListener(new ChangeListener() {
                @Override
                public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                    meditate();
                }
            });

            
            Gdx.input.setInputProcessor(stage);
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    reloj.actualizar();
                    relojMsg = reloj.getHoraActual();
                    if(reloj.getHora() == 4 && reloj.getMinutos()==0){
                        Huerto h = Huerto.getInstance();
                        h.generateFood();
                        h.generateFood();
                    }
                    boolean sickBool = action.executeAction("Sick", main);
                    if(sickBool){
                        Dialog dialog = new Dialog("Sick",VisUI.getSkin(),"dialog"){
                            public void result(Object obj){
                                boolean result = (boolean) obj;
                                if(!result){
                                    main.getCurrentSickness().remove(0);
                                    main.setFood(0);
                                    main.setMentalHealth(100);
                                    main.setPhysycalHealth(100);
                                    main.setLiquid(0);
                                }
                                
                            }
                        };
                        dialog.text("Se contrajo la enfermedad: "+main.getCurrentSickness().get(0).getName());
                        dialog.button("Aceptar",true);
                        dialog.button("Negar",false);
                        dialog.key(Keys.ENTER,true);
                        dialog.show(stage);
                        
                    }
                    
                    if(reloj.getHora()==2){
                        for(Sickness s:main.getCurrentSickness()){
                            s.action(main);
                        }
                        if(reloj.getMinutos()==30){
                           for(Sickness s:main.getCurrentSickness()){
                            s.setDuration(s.getDuration()-1);
                            if(s.getDuration()==0){
                                Dialog dialog = new Dialog("Ejercicio",VisUI.getSkin(),"dialog"){
                                 public void result(Object obj){
                                     System.exit(0);
                                 }
                             };
                             dialog.text("Ha muerto por:" +s.getName());
                             dialog.button("Ok","Correr");
                             dialog.key(Keys.ENTER,true);
                             dialog.show(stage);
                            }
                        } 
                        }
                    }
                    if(reloj.getMinutos() == 0||reloj.getMinutos()==30){
                        
                        main.setEnergy(main.getEnergy()-1);
                        if(main.getEnergy()<50){
                            main.setMentalHealth(main.getMentalHealth()-1);
                        }
                    }
                    
                    if(!moving && currentAction.compareTo("")!=0){
                        if(currentAction.compareTo("Excercise")==0&&main.getEnergy()>0){
                             Dialog dialog = new Dialog("Ejercicio",VisUI.getSkin(),"dialog"){
                                 public void result(Object obj){
                                     String result = (String) obj;
                                     if("Correr".equals(result)){
                                         main.setCurrentAction("Correr");
                                         action.action(main);
                                     }
                                     else{
                                         main.setCurrentAction("Nadar");
                                         action.action(main);
                                     }
                                 }
                             };
                             dialog.text("Cual ejercicio desea realizar");
                             dialog.button("Correr","Correr");
                             dialog.button("Nadar","Nadar");
                             dialog.key(Keys.ENTER,true);
                             dialog.show(stage);
                        }
                        boolean cont = action.action(main);
                        if(!cont){
                            currentAction = "";
                        }
                    }   
                    //render();
                }
            },reloj.getAvance(),reloj.getAvance());
	    batch = new SpriteBatch();
            
	    img = new Texture("goku.png");
            charImg = new Texture(this.main.getCurrentImage());
            concinaImg = new Texture("gokuKitchen.png");
            cuartoImg = new Texture("gokuBedroom.png");
            banioImg = new Texture("gokuBathroom.png");
            comedorImg = new Texture("gokuComedor.png");
            huertoImg = new Texture("gokuGarden.png");
            zonaEjImg = new Texture("gokuTrainingArea.png");
            zonaPImg = new Texture("gokuPelea.png");
            jardinImg = new Texture("gokuRelaxGarden.png");
            
	}

	@Override
	public void render () {
            charImg = new Texture(this.main.getCurrentImage());
            if(moving){
                main.setCurrentImage(this.main.getImages().get(0));
                charImg = new Texture(this.main.getCurrentImage());
                this.main.setxPos((int) (this.main.getxPos() + direccion.x*(20)));
                this.main.setyPos((int) (this.main.getyPos() + direccion.x*(20)));
                if(Vector2.dst(posInicial.x, posInicial.y, this.main.getxPos(),this.main.getyPos())>= distance){
                    moving = false;
                    
                    
                }
            }      
            BitmapFont font = new BitmapFont();
            Gdx.gl.glClearColor(0,0, 0, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	    batch.begin();
            batch.draw(img, 0, 0);
            
            batch.draw(concinaImg, home.getSeccion("Cocina").x, home.getSeccion("Cocina").y,100,100);
            batch.draw(cuartoImg, home.getSeccion("Cuarto").x, home.getSeccion("Cuarto").y,100,100);
            batch.draw(banioImg, home.getSeccion("Banio").x, home.getSeccion("Banio").y,100,100);
            batch.draw(comedorImg, home.getSeccion("Comedor").x, home.getSeccion("Comedor").y,100,100);
            batch.draw(huertoImg, home.getSeccion("Huerto").x, home.getSeccion("Huerto").y,100,100);
            batch.draw(zonaEjImg, home.getSeccion("ZonaEjercicios").x, home.getSeccion("ZonaEjercicios").y,100,100);
            batch.draw(zonaPImg, home.getSeccion("ZonaPelea").x, home.getSeccion("ZonaPelea").y,100,100);
            batch.draw(jardinImg, home.getSeccion("Jardin").x, home.getSeccion("Jardin").y,100,100);
            
            batch.draw(charImg, this.main.getxPos(),this.main.getyPos(),75,75);
            
            
            Storage s = Storage.getInstance();
            Huerto h = Huerto.getInstance();
            font.draw(batch,relojMsg, clockX,clockY);
            font.draw(batch, "Liquido: "+Integer.toString(main.getLiquid()), clockX,clockY-20);
            font.draw(batch, "Comida: "+Integer.toString(main.getFood()), clockX,clockY-40);
            font.draw(batch, "Energia: "+Integer.toString(main.getEnergy()), clockX,clockY-60);
            font.draw(batch, "Mental: "+Integer.toString(main.getMentalHealth()), clockX,clockY-80);
            font.draw(batch, "Fisica : "+Integer.toString(main.getPhysycalHealth()), clockX,clockY-100);
            font.draw(batch, "Gordura : "+Integer.toString(main.getGordura()), clockX,clockY-120);
            font.draw(batch, "Cansancio : "+Integer.toString(main.getTiredness()), clockX,clockY-140);
            font.draw(batch, "Edad : "+Integer.toString(main.getAge()), clockX,clockY-160);
            font.draw(batch, "Dia : "+Integer.toString(reloj.getDiasPasados()), clockX,clockY-180);
            font.draw(batch, "Comida : "+Integer.toString(s.getFoods().size()), clockX,clockY-200);
            font.draw(batch, "Medicina : "+Integer.toString(s.getMedicine().size()), clockX,clockY-220);
            font.draw(batch, "Huerto(Comida) : "+Integer.toString(h.getCurrentFoods().size()), clockX,clockY-240);
            font.draw(batch, "Huerto(Medicina) : "+Integer.toString(h.getCurrentCure().size()), clockX,clockY-260);
            if(reloj.getDiasPasados()==0){
                main.setAge(main.getAge()+1);
                
                reloj.setDiasPasados(1);
                if(main.getAge()<5){
                    main.setCurrentImage("GokuChar"+Integer.toString(main.getAge())+".png");
                }
                
            }
            
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
            Vector2 posBano = home.getSeccion("Banio").cpy();
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
        
        public void comer(){
            Vector2 posBano = home.getSeccion("Comedor").cpy();
            posInicial = new Vector2(this.main.getxPos(),this.main.getyPos());
            distance = posInicial.dst(posBano);
            direccion =posBano.sub(posInicial).nor();
            moving = true;
            this.currentAction = "Eat";
            this.action.setAccion("Eat");
        }
        
        public void collect(){
            Vector2 posBano = home.getSeccion("Jardin").cpy();
            posInicial = new Vector2(this.main.getxPos(),this.main.getyPos());
            distance = posInicial.dst(posBano);
            direccion =posBano.sub(posInicial).nor();
            moving = true;
            this.currentAction = "Collect";
            this.action.setAccion("Collect");
        }
        
        public void cure(){
            Vector2 posBano = home.getSeccion("Cuarto").cpy();
            posInicial = new Vector2(this.main.getxPos(),this.main.getyPos());
            distance = posInicial.dst(posBano);
            direccion =posBano.sub(posInicial).nor();
            moving = true;
            this.currentAction = "Cure";
            this.action.setAccion("Cure");
            
        }
        
        public void excercise(){
            Vector2 posBano = home.getSeccion("ZonaEjercicios").cpy();
            posInicial = new Vector2(this.main.getxPos(),this.main.getyPos());
            distance = posInicial.dst(posBano);
            direccion =posBano.sub(posInicial).nor();
            moving = true;
            this.currentAction = "Excercise";
            this.action.setAccion("Excercise");
        }
        
        public void meditate(){
            Vector2 posBano = home.getSeccion("Jardin").cpy();
            posInicial = new Vector2(this.main.getxPos(),this.main.getyPos());
            distance = posInicial.dst(posBano);
            direccion =posBano.sub(posInicial).nor();
            moving = true;
            this.currentAction = "Meditate";
            this.action.setAccion("Meditate");
        }
        
        public void showAbilities(){
            Dialog dialog = new Dialog("Abilities",VisUI.getSkin(),"dialog"){
                public void result(Object obj){                           
                 }
             };
            String habilidades = "";
            for(Ability ab:main.getCurrentAbilities()){
                String concat = habilidades.concat(ab.getName()).concat(" ") +"\n";
                habilidades = concat;
            }
            
            dialog.text("Sus abilidades son: "+habilidades);
            dialog.button("Ok",true);
            dialog.key(Keys.ENTER,true);
            dialog.show(stage);
        }
}
