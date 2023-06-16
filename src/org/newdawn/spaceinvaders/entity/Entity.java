package org.newdawn.spaceinvaders.entity;

import java.awt.Graphics;
import java.awt.Rectangle;

import org.newdawn.spaceinvaders.Sprite;
import org.newdawn.spaceinvaders.SpriteStore;

/**
<<<<<<< HEAD
 * !!!!!!!!move,doLogic,collidesWith,abstract collidedWith 함수 재정의!!!!!!!!!!!
 */

/**
=======
>>>>>>> eaa63a266232f67b6f64d4d3e089eb4db0420952
 * An entity represents any element that appears in the game. The
 * entity is responsible for resolving collisions and movement
 * based on a set of properties defined either by subclass or externally.
 * 
 * Note that doubles are used for positions. This may seem strange
 * given that pixels locations are integers. However, using double means
 * that an entity can move a partial pixel. It doesn't of course mean that
 * they will be display half way through a pixel but allows us not lose
 * accuracy as we move.
 * 
 * @author Kevin Glass
 */
public abstract class Entity {
<<<<<<< HEAD
	/**
	 * The current x location of this entity
	 */
	protected double x;

	/**
	 * The current y location of this entity
	 */

	protected double y;

	/**
	 * The sprite that represents this entity
	 */
	protected Sprite sprite;
	/**
	 * The current speed of this entity horizontally (pixels/sec)
	 */
	protected double dx;

	/**
	 * The current speed of this entity vertically (pixels/sec)
	 */
	protected double dy;

	/**
	 * The rectangle used for this entity during collisions  resolution
	 */
	private Rectangle me = new Rectangle();
	/**
	 * The rectangle used for other entities during collision resolution
	 */
	private Rectangle him = new Rectangle();

	/**
	 * Construct a entity based on a sprite image and a location.
	 *
	 * @param ref The reference to the image to be displayed for this entity
	 * @param x   The initial x location of this entity
	 * @param y   The initial y location of this entity
	 */
	public Entity(String ref, int x, int y) {
=======
	/** The current x location of this entity */ 
	protected double x;

	/** The current y location of this entity */

	protected double y;

	/** The sprite that represents this entity */
	protected Sprite sprite;
	/** The current speed of this entity horizontally (pixels/sec) */
	protected double dx;

	/** The current speed of this entity vertically (pixels/sec) */
	protected double dy;

	/** The rectangle used for this entity during collisions  resolution */
	private Rectangle me = new Rectangle();
	/** The rectangle used for other entities during collision resolution */
	private Rectangle him = new Rectangle();
	
	/**
	 * Construct a entity based on a sprite image and a location.
	 * 
	 * @param ref The reference to the image to be displayed for this entity
 	 * @param x The initial x location of this entity
	 * @param y The initial y location of this entity
	 */
	public Entity(String ref,int x,int y) {
>>>>>>> eaa63a266232f67b6f64d4d3e089eb4db0420952
		this.sprite = SpriteStore.get().getSprite(ref);
		this.x = x;
		this.y = y;
	}
<<<<<<< HEAD

	/**
	 * Request that this entity move itself based on a certain ammount
	 * of time passing.
	 *
=======
	
	/**
	 * Request that this entity move itself based on a certain ammount
	 * of time passing.
	 * 
>>>>>>> eaa63a266232f67b6f64d4d3e089eb4db0420952
	 * @param delta The ammount of time that has passed in milliseconds
	 */
	public void move(long delta) {
		// update the location of the entity based on move speeds
		x += (delta * dx) / 1000;
		y += (delta * dy) / 1000;
	}
<<<<<<< HEAD

	public void move(long delta, int player) {
=======
	public void move1(long delta) {
>>>>>>> eaa63a266232f67b6f64d4d3e089eb4db0420952
		// update the location of the entity based on move speeds
		x += (delta * dx) / 1000;
		y += (delta * dy) / 1000;
	}

<<<<<<< HEAD

	/**
	 * Set the horizontal speed of this entity
	 *
=======
	public void move2(long delta) {
		// update the location of the entity based on move speeds
		x += (delta * dx) / 1000;
		y += (delta * dy) / 1000;
	}
	
	/**
	 * Set the horizontal speed of this entity
	 * 
>>>>>>> eaa63a266232f67b6f64d4d3e089eb4db0420952
	 * @param dx The horizontal speed of this entity (pixels/sec)
	 */
	public void setHorizontalMovement(double dx) {
		this.dx = dx;
	}

	/**
	 * Set the vertical speed of this entity
<<<<<<< HEAD
	 *
=======
	 * 
>>>>>>> eaa63a266232f67b6f64d4d3e089eb4db0420952
	 * @param/ The vertical speed of this entity (pixels/sec)
	 */

	public double getHorizontalMovement() {
		return dx;
	}

	/**
	 * Get the vertical speed of this entity
<<<<<<< HEAD
	 *
	 * @return The vertical speed of this entity (pixels/sec)
	 */

	/**
	 * Draw this entity to the graphics context provided
	 *
	 * @param g The graphics context on which to draw
	 */
	public void draw(Graphics g) {
		sprite.draw(g, (int) x, (int) y);
	}

=======
	 * 
	 * @return The vertical speed of this entity (pixels/sec)
	 */
	
	/**
	 * Draw this entity to the graphics context provided
	 * 
	 * @param g The graphics context on which to draw
	 */
	public void draw(Graphics g) {
		sprite.draw(g,(int) x,(int) y);
	}
>>>>>>> eaa63a266232f67b6f64d4d3e089eb4db0420952
	/**
	 * Do the logic associated with this entity. This method
	 * will be called periodically based on game events
	 */
	public void doLogic(int currentLevel) {
	}

<<<<<<< HEAD
	public void doLogic() {
	}

	/**
	 * Get the x location of this entity
	 *
=======
	public void doLogic1() {
	}

	public void doLogic2() {
	}
	/**
	 * Get the x location of this entity
	 * 
>>>>>>> eaa63a266232f67b6f64d4d3e089eb4db0420952
	 * @return The x location of this entity
	 */
	public int getX() {
		return (int) x;
	}

	/**
	 * Get the y location of this entity
<<<<<<< HEAD
	 *
=======
	 * 
>>>>>>> eaa63a266232f67b6f64d4d3e089eb4db0420952
	 * @return The y location of this entity
	 */
	public int getY() {
		return (int) y;
	}
<<<<<<< HEAD

	/**
	 * Check if this entity collised with another.
	 *
=======
	
	/**
	 * Check if this entity collised with another.
	 * 
>>>>>>> eaa63a266232f67b6f64d4d3e089eb4db0420952
	 * @param other The other entity to check collision against
	 * @return True if the entities collide with each other
	 */
	public boolean collidesWith(Entity other) {
<<<<<<< HEAD
		me.setBounds((int) x, (int) y, sprite.getWidth(), sprite.getHeight());
		him.setBounds((int) other.x, (int) other.y, other.sprite.getWidth(), other.sprite.getHeight());

		return me.intersects(him);
	}

	public boolean collidesWith(Entity other, int player) {
		me.setBounds((int) x, (int) y, sprite.getWidth(), sprite.getHeight());
		him.setBounds((int) other.x, (int) other.y, other.sprite.getWidth(), other.sprite.getHeight());

		return me.intersects(him);
	}

	/**
	 * Notification that this entity collided with another.
	 *
	 * @param other The entity with which this entity collided.
	 */
	public abstract void collidedWith(Entity other);

	public abstract void collidedWith(Entity other, int player);
}
=======
		me.setBounds((int) x,(int) y,sprite.getWidth(),sprite.getHeight());
		him.setBounds((int) other.x,(int) other.y,other.sprite.getWidth(),other.sprite.getHeight());

		return me.intersects(him);
	}
	public boolean collidesWith1(Entity other) {
		me.setBounds((int) x,(int) y,sprite.getWidth(),sprite.getHeight());
		him.setBounds((int) other.x,(int) other.y,other.sprite.getWidth(),other.sprite.getHeight());

		return me.intersects(him);
	}
	public boolean collidesWith2(Entity other) {
		me.setBounds((int) x,(int) y,sprite.getWidth(),sprite.getHeight());
		him.setBounds((int) other.x,(int) other.y,other.sprite.getWidth(),other.sprite.getHeight());

		return me.intersects(him);
	}
	/**
	 * Notification that this entity collided with another.
	 * 
	 * @param other The entity with which this entity collided.
	 */
	public abstract void collidedWith(Entity other);
	public abstract void collidedWith1(Entity other);
	public abstract void collidedWith2(Entity other);
}
>>>>>>> eaa63a266232f67b6f64d4d3e089eb4db0420952
