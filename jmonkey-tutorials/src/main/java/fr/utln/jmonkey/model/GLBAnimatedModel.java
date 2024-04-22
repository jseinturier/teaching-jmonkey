package fr.utln.jmonkey.model;

import com.jme3.anim.SkinningControl;
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
import com.jme3.math.FastMath;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.scene.Spatial;

public class GLBAnimatedModel extends SimpleApplication {

	private int frame = 0;
	
	private SkinningControl sc;
	
	@Override
	public void simpleInitApp() {
      
        // Load the GLB model from the data folder
        assetManager.registerLocator("data", FileLocator.class);
        Spatial animatedModel = assetManager.loadModel("model/HoverRocket.glb");

        // Place the model correctly according the JMonkey referential
        Quaternion rotation = new Quaternion();
        rotation.fromAngles(-FastMath.HALF_PI, 0.0f, 0.0f);
        animatedModel.setLocalRotation(rotation);
  
        rootNode.attachChild(animatedModel);

        // PBR - Environment camera initialization
        // This initialization is necessary if the model contain PBR material
        // see: https://wiki.jmonkeyengine.org/docs/3.4/tutorials/how-to/articles/pbr/pbr_part1.html
        //
        // PBR handling need also the definition of a light probe within update method.
        final EnvironmentCamera envCam = new EnvironmentCamera(256, new Vector3f(0.0f, 0.0f, 0.0f));
        stateManager.attach(envCam);
        
        // Animation - Initializing animation
        sc = animatedModel.getControl(SkinningControl.class);

        // Configure a chase camera for a better experience
        flyCam.setEnabled(false);
        ChaseCamera chaseCam = new ChaseCamera(cam, animatedModel, inputManager);
        
        
        this.getViewPort().setBackgroundColor(ColorRGBA.LightGray);
	}
	
	@Override
	public void simpleUpdate(float tpf) {
		
		frame++;
		
		// PBR - LightProbe initialization
		// Rendering need to be effective before adding LightProbe, 
		// this is the reason the rendering of the frame 2 is required 
		// before initializing the light probe. 
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
