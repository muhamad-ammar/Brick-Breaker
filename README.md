# Brick-Breaker Game

Algorithem:
                                                                                                                                                                         
    1). Integration= p1=p0+ v⋅Δt
    2). Collision: The static collision detection and response ideas 
        used in this game are described at Static Void Games.
    3). Actions: 
    on a key press
      - mark the key as down
    on clock tick
      -  ball position += velocity * time   on collision with a brick
       - play a sound
    reflect the ball
       - increase score
    remove the brick
       - speed up the ball
    on last brick removed
      -  mode = game over
    on ball collision with top, left, or right wall:
      -  play a sound
    reflect ball velocity
       - on ball collision with bottom wall:
    decrement numBalls
       - play a sound
    if numBalls == 0: mode = game over
