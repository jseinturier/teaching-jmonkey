package fr.utln.jmonkey.sample;

import com.jme3.app.SimpleApplication;
import com.jme3.asset.plugins.FileLocator;
import com.jme3.light.DirectionalLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Spatial;

public class FBXModelImport extends SimpleApplication {

    public static void main(String[] args) {
        FBXModelImport app = new FBXModelImport();
        app.start();
    }

    public void simpleInitApp() {

        // GLTF can be exported from various formats (FBX, 3DS, ...) using Blender
        assetManager.registerLocator("data/model", FileLocator.class);
        Spatial model = assetManager.loadModel("hollow.gltf");
        
        DirectionalLight dl = new DirectionalLight();
        dl.setColor(ColorRGBA.White);
        dl.setDirection(Vector3f.UNIT_XYZ.negate());

        rootNode.addLight(dl);
        rootNode.attachChild(model);

    }
}
