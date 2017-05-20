package ch.heigvd.tool;

import ch.heigvd.tool.settings.SizeConfigurableTool;
import ch.heigvd.workspace.Workspace;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * The Brush tool class. Brush objects are tools that draw lines on a JavafX
 * Canvas object. It is possible to set the color and the width of the brush.
 *
 * @author mathieu
 */
public class Brush extends LineTool implements SizeConfigurableTool {

   // Color of the brush
   Color color;

   /**
    * Constructor. Sets the default usage values which are a the color black and
    * a size of 1px.
    *
    * @param workspace the Workspace to work on
    */
   public Brush(Workspace workspace) {
      this(workspace, ColorSet.getInstance().getColor(), -1);
   }

   /**
    * Constructor. Specifies the color and size.
    *
    * @param workspace the Workspace to work on
    * @param color the color of the brush
    * @param size the size [px]
    */
   public Brush(Workspace workspace, Color color, int size) {
      super(workspace, size);
      this.color = color;
   }

   /**
    * Draws a circle around the given pixel. The diameter of the circle is 
    * the size of the tool. 
    * @param x the x coordinate of the pixel
    * @param y the y coordinate of the pixel
    * @param gc the GraphicsContext of the canvas
    */
   @Override
   protected void drawPixel(int x, int y, GraphicsContext gc) {
      gc.setFill(color);
      gc.fillOval(x - size/2.0, y - size/2.0, size, size);
   }



   /**
    * Set the color of the brush.
    *
    * @param color the new Color
    */
   public void setColor(Color color) {
      this.color = color;
   }

   /**
    * Get the current brush color.
    *
    * @return the color of the brush
    */
   public Color getColor() {
      return color;
   }

   /**
    * Set the new size of the brush
    *
    * @param size the new size
    */
   @Override
   public void setSize(int size) {
      this.size = size;
   }

   /**
    * Get the size of the brush in pixels
    *
    * @return the size of the brush
    */
   public int getSize() {
      return size;
   }
   
   @Override
   public void mousePressed(double x, double y) {
      setColor(ColorSet.getInstance().getColor());
      super.mousePressed(x, y);
   }

   /**
    * Method to call during the dragging motion.
    *
    * @param x the event x coordinate
    * @param y the event y coordinate
    */
   @Override
   public void mouseDragged(double x, double y) {
      if (!started)
         setColor(ColorSet.getInstance().getColor());
      super.mouseDragged(x, y);
   }

   /**
    * Method to call at the end of the drag movement.
    *
    * @param x the x coordinate of the event
    * @param y the y coordinate of the event
    */
   @Override
   public void mouseReleased(double x, double y) {
      super.mouseReleased(x, y);

   }

}
