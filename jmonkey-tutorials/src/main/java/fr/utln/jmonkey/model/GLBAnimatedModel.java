package fr.utln.jmonkey.model;

import com.jme3.anim.AnimClip;
import com.jme3.anim.AnimComposer;
import com.jme3.anim.SkinningControl;
import com.jme3.anim.tween.Tweens;
import com.jme3.anim.tween.action.Action;
import com.jme3.anim.tween.action.BaseAction;
import com.jme3.anim.tween.action.LinearBlendSpace;
import com.jme3.app.SimpleApplication;
import com.jme3.asset.plugins.FileLocator;
import com.jme3.environment.EnvironmentCamera;
import com.jme3.environment.LightProbeFactory;
import com.jme3.input.ChaseCamera;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.light.LightProbe;
import com.jme3.light.SpotLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Spatial;

public class GLBAnimatedModel extends SimpleApplication {

	private int frame = 0;
	
	private SkinningControl sc;
    private static Action currentAction;
	
	@Override
	public void simpleInitApp() {
		DirectionalLight sun = new DirectionalLight();
        sun.setDirection(new Vector3f(0,0,0).normalizeLocal());
        sun.setColor(ColorRGBA.White);
        rootNode.addLight(sun);

        AmbientLight al = new AmbientLight();
        al.setColor(ColorRGBA.White.mult(1.3f));
        rootNode.addLight(al);
		
        SpotLight sl = new SpotLight(new Vector3f(0.0f, 0.0f, 0.0f), Vector3f.UNIT_Y);
        sl.setColor(ColorRGBA.White.mult(1.3f));
        rootNode.addLight(sl);
        
        // Load the GLB model
        assetManager.registerLocator("data", FileLocator.class);
        Spatial animatedModel = assetManager.loadModel("HoverRocket.glb");

        rootNode.attachChild(animatedModel);

        // PBR - Environment camera initialization
        final EnvironmentCamera envCam = new EnvironmentCamera(256, new Vector3f(0.0f, 0.0f, 0.0f));
        stateManager.attach(envCam);
        
        sc = animatedModel.getControl(SkinningControl.class);


/*
        animComposer.actionBlended("Attack", new LinearBlendSpace(0f, 0.5f), "Dodge");
        for (AnimClip animClip : animComposer.getAnimClips()) {
            Action action = animComposer.action(animClip.getName());
            if(!"stand".equals(animClip.getName())) {
                action = new BaseAction(Tweens.sequence(action, Tweens.callMethod(this, "backToStand", animComposer)));
            }
            animComposer.addAction(animClip.getName(), action);
        }
        currentAction = animComposer.setCurrentAction("stand"); // Walk, pull, Dodge, stand, push
*/      
        
        
        
        
        flyCam.setEnabled(false);
        ChaseCamera chaseCam = new ChaseCamera(cam, animatedModel, inputManager);
        
        this.getViewPort().setBackgroundColor(ColorRGBA.LightGray);
	}
	
	@Override
	public void simpleUpdate(float tpf) {
		
		frame++;
		
		// PBR - LightProbe initialization
		// Rendering need to be effective before adding LightProbe
		if (frame == 2) {
			final LightProbe probe = LightProbeFactory.makeProbe(stateManager.getState(EnvironmentCamera.class), rootNode);
	        
	        probe.getArea().setRadius(100);
	        rootNode.addLight(probe);
		}


	}
	
	/**
	 * The main method.
	 * @param args the main method arguments
	 */
	public static void main(String[] args) {
		GLBAnimatedModel app = new GLBAnimatedModel();
		app.start();
	}
}
