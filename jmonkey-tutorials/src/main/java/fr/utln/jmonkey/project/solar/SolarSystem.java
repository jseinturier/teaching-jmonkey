package fr.utln.jmonkey.project.solar;

import com.jme3.app.SimpleApplication;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.Trigger;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Sphere;


public class SolarSystem extends SimpleApplication {
    
    private final static Trigger lanzarTrigger = new KeyTrigger(MouseInput.BUTTON_LEFT);
    private final static String lanzarNombre = "Lanzar";
    
   
    public double angulo, angulo2, angulo3, angulo4, angulo5, angulo6, angulo7, angulo8, angulo9= 0; //Variables for the angles 
        Sphere sol = new Sphere(32, 32, 5f);
        Geometry solGeometry = new Geometry("Sun", sol);
        
        Sphere mercury = new Sphere(32, 32, 1f);
        Geometry mercuryGeometry = new Geometry("Mercury", mercury);
        
        Sphere venus = new Sphere(32, 32, 2.2f);
        Geometry venusGeometry = new Geometry("Venus", venus);
        
        Sphere earth = new Sphere(32, 32, 2.2f);
        Geometry earthGeometry = new Geometry("Earth", earth);
        
        Sphere mars = new Sphere(32, 32, 1.5f);
        Geometry marsGeometry = new Geometry("Mars", mars);
        
        Sphere jupiter = new Sphere(32, 32, 4f);
        Geometry jupiterGeometry = new Geometry("Jupiter", jupiter);
        
        Sphere saturn = new Sphere(32, 32, 3f);
        Geometry saturnGeometry = new Geometry("Saturn", saturn);
        
        Sphere uranus = new Sphere(32, 32, 2f);
        Geometry uranusGeometry = new Geometry("Uranus", uranus);
        
        Sphere neptune = new Sphere(32, 32, 2f);
        Geometry neptuneGeometry = new Geometry("Neptune", neptune);
        
        Sphere pluto = new Sphere(32, 32, 1.0f);
        Geometry plutoGeometry = new Geometry("Pluto", pluto);
       
        Vector3f sol1= new Vector3f(0.0f, 1.0f, 1.0f);
        Vector3f mercurio1 = new Vector3f(1.0f, 10.0f, 10.0f);
        Vector3f venus1= new Vector3f(20.0f, 1.0f, 1.0f);
        Vector3f tierra1 = new Vector3f(11.0f, 1.0f, 1.0f);
        Vector3f marte1 = new Vector3f(14.0f, 1.0f, 1.0f);
        Vector3f jupiter1 = new Vector3f(17.0f, 1.0f, 1.0f);
        Vector3f saturno1 = new Vector3f(20.0f, 1.0f, 1.0f);
        Vector3f urano1 = new Vector3f(23f, 1.0f, 1.0f);
        Vector3f neptuno1 = new Vector3f(26f, 1.0f, 1.0f);
        Vector3f pluton1 = new Vector3f(29f, 1.0f, 1.0f);
        
        Vector3f camera = new Vector3f(0f, 0f, 125f);
    @Override
    public void simpleInitApp() {
        
        
        
        flyCam.setEnabled(true);
        flyCam.setDragToRotate(true);
        inputManager.setCursorVisible(true);
        inputManager.addMapping(lanzarNombre, lanzarTrigger);
        inputManager.addListener(actionListener, new String[]{lanzarNombre});
      
        cam.setLocation(camera);
        
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        Material mat2 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        Material mat3 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        Material mat4 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        Material mat5 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        Material mat6 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        Material mat7 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        Material mat8 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        Material mat9 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        Material mat10 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        
        mat.setColor("Color", ColorRGBA.Yellow);
        mat2.setColor("Color", ColorRGBA.Blue);
        mat3.setColor("Color", ColorRGBA.Red);
        mat4.setColor("Color", ColorRGBA.Green);
        mat5.setColor("Color", ColorRGBA.White);
        mat6.setColor("Color", ColorRGBA.Brown);
        mat7.setColor("Color", ColorRGBA.Cyan);
        mat8.setColor("Color", ColorRGBA.Gray);
        mat9.setColor("Color", ColorRGBA.LightGray);
        mat10.setColor("Color", ColorRGBA.Pink);
                
        
        solGeometry.setMaterial(mat);
        mercuryGeometry.setMaterial(mat2);
        venusGeometry.setMaterial(mat3);
        earthGeometry.setMaterial(mat4);
        marsGeometry.setMaterial(mat5);
        jupiterGeometry.setMaterial(mat6);
        saturnGeometry.setMaterial(mat7);
        uranusGeometry.setMaterial(mat8);
        neptuneGeometry.setMaterial(mat9);
        plutoGeometry.setMaterial(mat10);
        
        
        
        rootNode.attachChild(solGeometry);
        rootNode.attachChild(mercuryGeometry);
        rootNode.attachChild(venusGeometry);
        rootNode.attachChild(earthGeometry);
        rootNode.attachChild(marsGeometry);
        rootNode.attachChild(jupiterGeometry);
        rootNode.attachChild(saturnGeometry);
        rootNode.attachChild(uranusGeometry);
        rootNode.attachChild(neptuneGeometry);
        rootNode.attachChild(plutoGeometry);
        
    }
    
    private ActionListener actionListener = new ActionListener() {
        public void onAction(String name, boolean isPressed, float tpf) {
            System.out.println("Mapping detected (discrete): " + name);
            if (name.equals(lanzarNombre) && !isPressed) {
                solGeometry.setLocalTranslation(1f, 0, 0);
                
                           } 
        }
    };

    @Override
    public void simpleUpdate(float tpf) {
        
        angulo = angulo + 0.04;
        angulo2 = angulo2 + 0.02;
        angulo3 = angulo3 + 0.015;
        angulo4 = angulo4 + 0.0097;
        angulo5 = angulo5 + 0.0085;
        angulo6 = angulo6 + 0.0080;
        angulo7 = angulo7 + 0.007;
        angulo8 = angulo8 + 0.0065;
        angulo9 = angulo9 + 0.0050;
        
        
        float r = FastMath.DEG_TO_RAD;
        double Merc = FastMath.DEG_TO_RAD*angulo;
        double Ven = FastMath.DEG_TO_RAD*angulo2;
        double Tier = FastMath.DEG_TO_RAD*angulo3;
        double Marte = FastMath.DEG_TO_RAD*angulo4;
        double Jupi = FastMath.DEG_TO_RAD*angulo5;
        double Satur = FastMath.DEG_TO_RAD*angulo6;
        double Uran = FastMath.DEG_TO_RAD*angulo7;
        double Neptu = FastMath.DEG_TO_RAD*angulo8;
        double Pluton = FastMath.DEG_TO_RAD*angulo9;
        
        //Position of the planets in the space
        
        int rMer = 7;
        int rVenus = 12;
        int rTierra = 17;
        int rMarte = 22;
        int rJupiter = 32;
        int rSaturno = 40;
        int rUrano = 44;
        int rNeptuno = 48;
        int rPluton = 52;
        
        
        //Coordinates to make the planets go around the sun
        
        float xMer = (float) Math.sin(Merc)*rMer;
        float yMer = (float) Math.cos(Merc)*rMer;
        
        float xVenus = (float) Math.sin(Ven)*rVenus;
        float yVenus = (float) Math.cos(Ven)*rVenus;
        
        float xTierra = (float) Math.sin(Tier)*rTierra;
        float yTierra = (float) Math.cos(Tier)*rTierra;
        
        float xMarte = (float) Math.sin(Marte)*rMarte;
        float yMarte = (float) Math.cos(Marte)*rMarte;
        
        float xJupiter = (float) Math.sin(Jupi)*rJupiter;
        float yJupiter = (float) Math.cos(Jupi)*rJupiter;
        
        float xSaturno = (float) Math.sin(Satur)*rSaturno;
        float ySaturno = (float) Math.cos(Satur)*rSaturno;
        
        float xUrano = (float) Math.sin(Uran)*rUrano;
        float yUrano = (float) Math.cos(Uran)*rUrano;
        
        float xNeptuno = (float) Math.sin(Neptu)*rNeptuno;
        float yNeptuno = (float) Math.cos(Neptu)*rNeptuno;
        
        float xPluton = (float) Math.sin(Pluton)*rPluton;
        float yPluton = (float) Math.cos(Pluton)*rPluton;
        
         
        
        solGeometry.rotate(r,0f,0f);
        mercuryGeometry.rotate(r,0f,0f);
        venusGeometry.rotate(r,0f,0f);
        earthGeometry.rotate(r,0f,0f);
        marsGeometry.rotate(r,0f,0f);
        jupiterGeometry.rotate(r,0f,0f);
        saturnGeometry.rotate(r,0f,0f);
        uranusGeometry.rotate(r,0f,0f);
        neptuneGeometry.rotate(r,0f,0f);
        plutoGeometry.rotate(r,0f,0f);
        
        //Rotation against the sun
        
        Vector3f orbMercurio = new Vector3f (xMer , yMer, 0);
        Vector3f orbVenus = new Vector3f (xVenus , yVenus, 0);
        Vector3f orbTierra = new Vector3f (xTierra , yTierra, 0);
        Vector3f orbMarte = new Vector3f (xMarte , yMarte, 0);
        Vector3f orbJupiter = new Vector3f (xJupiter , yJupiter, 0);
        Vector3f orbSaturno = new Vector3f (xSaturno , ySaturno, 0);
        Vector3f orbUrano = new Vector3f (xUrano , yUrano, 0);
        Vector3f orbNeptuno = new Vector3f (xNeptuno , yNeptuno, 0);
        Vector3f orbPluton = new Vector3f (xPluton , yPluton, 0);
        
        mercuryGeometry.setLocalTranslation(orbMercurio);
        venusGeometry.setLocalTranslation(orbVenus);
        earthGeometry.setLocalTranslation(orbTierra);
        marsGeometry.setLocalTranslation(orbMarte);
        jupiterGeometry.setLocalTranslation(orbJupiter);
        saturnGeometry.setLocalTranslation(orbSaturno);
        uranusGeometry.setLocalTranslation(orbUrano);
        neptuneGeometry.setLocalTranslation(orbNeptuno);
        plutoGeometry.setLocalTranslation(orbPluton);
        
        }
    
   

       
   

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
    
    public static void main(String[] args) {
        SolarSystem app = new SolarSystem();
        
        app.start();
    }
}