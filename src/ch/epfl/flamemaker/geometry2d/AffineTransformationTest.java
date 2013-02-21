package ch.epfl.flamemaker.geometry2d;
 
import static org.junit.Assert.*;
 
import org.junit.Test;
 
 
 
public class AffineTransformationTest {
       
        private static double DELTA = 0.000000001;
       
        @Test
        public void testAffineTransformation() {
                new AffineTransformation(1, 0, 0, 0, 1, 0);
        }
       
        @Test
        public void testNewTranslation() {
                AffineTransformation t = AffineTransformation.newTranslation(1, 1);
                Point p = new Point(0, 0);
                assertEquals(t.transformPoint(p).x(), 1, DELTA);
                assertEquals(t.transformPoint(p).y(), 1, DELTA);
               
        }
       
        @Test
        public void testNewRotation() {
                AffineTransformation t = AffineTransformation.newRotation(Math.PI);
                Point p = new Point(1,1);
                assertEquals(t.transformPoint(p).x(), -1, DELTA);
                assertEquals(t.transformPoint(p).y(), -1, DELTA);
        }
       
        @Test
        public void testNewScaling() {
                AffineTransformation t = AffineTransformation.newScaling(1, 1);
                Point p = new Point (1, 1);
                assertEquals(t.transformPoint(p).x(), 1, DELTA);
                assertEquals(t.transformPoint(p).y(), 1, DELTA);
        }
       
        @Test
        public void testNewShearX() {
                AffineTransformation t = AffineTransformation.newShearX(1);
                Point p = new Point(1, 1);
                assertEquals(t.transformPoint(p).x(), 2, DELTA);
                assertEquals(t.transformPoint(p).y(), 1, DELTA);
        }
        
        @Test
        public void testNewShearY() {
                AffineTransformation t = AffineTransformation.newShearY(1);
                Point p = new Point(1, 1);
                assertEquals(t.transformPoint(p).x(), 1, DELTA);
                assertEquals(t.transformPoint(p).y(), 2, DELTA);
        }
        
        @Test
        public void testComposeWith() {
        	AffineTransformation f = new AffineTransformation(1,0,1,0,1,0);
        	AffineTransformation g = new AffineTransformation(1,0,1,1,0,1);
        	AffineTransformation h = f.composeWith(g);
        	assertEquals(h.translationX(),2,DELTA);
        	assertEquals(h.translationY(),1,DELTA);
        }
        
        
       
}