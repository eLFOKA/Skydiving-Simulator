

xmax = 6
ymax = xmax / 2.0
make_grid()


def force(name):
    grav = 9.8
    name.weight = v(0, -name.mass * grav)
    drag_coeff = 1
    name.drag = v(-drag_coeff * name.vx, -drag_coeff * name.vy)
    # You can add a new force here!

    force = name.weight + name.drag  # + any new forces!
    return force


position_graph = graph(xtitle="time", ytitle="position")
velocity_graph = graph(xtitle="time", ytitle="velocity")
force_graph = graph(xtitle="time", ytitle="force")
# Use the marker function to create a dot.
# name = marker(x,y,mass,color)
skydiver = marker(0, ymax, 1, color.red)
# Give your dot an initial velocity vector.
skydiver.vx = 0
skydiver.vy = 0
# Give your dot a position plot.
skydiver.xcurve = gcurve(label="skydiver's x", color=color.red, graph=position_graph)
skydiver.ycurve = gcurve(label="skydiver's y", color=color.blue, graph=position_graph)
# Give your dot a velocity plot.
skydiver.vxcurve = gcurve(label="skydiver's vx",
                          color=color.red,
                          graph=velocity_graph)
skydiver.vycurve = gcurve(label="skydiver's vy",
                          color=color.blue,
                          graph=velocity_graph)
# Give your dot a force plot.
skydiver.fxcurve = gcurve(label="skydiver's net x-force",
                          color=color.red,
                          graph=force_graph)
skydiver.fycurve = gcurve(label="skydiver's net y-force",
                          color=color.blue,
                          graph=force_graph)
# Let's get moving!
# We need a starting time.
time = 0
time_step = 0.02
# This next part will repeat until we reach the ground.
while (skydiver.pos.y >= ground.pos.y):
    # Accelerate your dot.
    accelerate(skydiver)
    # Move your dot.
    dx = skydiver.vx * time_step
    dy = skydiver.vy * time_step
    move(skydiver, dx, dy)
    # Update your dot's graphs.
    skydiver.xcurve.plot(pos=(time, skydiver.pos.x))
    skydiver.ycurve.plot(pos=(time, skydiver.pos.y))
    skydiver.vxcurve.plot(pos=(time, skydiver.vx))
    skydiver.vycurve.plot(pos=(time, skydiver.vy))
    skydiver.fxcurve.plot(pos=(time, force(skydiver).x))
    skydiver.fycurve.plot(pos=(time, force(skydiver).y))
    # If you need to move more dots, add a move function here!
    # Move to the next time value and repeat.
    time += time_step


# You can move again here! Just copy and paste.


### Don't change anything below here! ###

def v(x, y):
    return vector(x, y, 0)


def make_grid():
    scene.background = color.white
    thickness = 0.02
    dx = 1
    global xmax, ymax
    x = -xmax
    while (x <= xmax):
        y = -ymax
        gridline = curve(pos=[vector(x, y, -thickness)], color=color.black, radius=thickness)
        while (y <= ymax):
            gridline.append(vector(x, y, -thickness))
            y = y + dx
        x = x + dx
    y = -xmax / 2.0
    while (y <= xmax / 2.0):
        x = -xmax
        gridline = curve(pos=[vector(x, y, -thickness)], color=color.black, radius=thickness)
        while (x <= xmax):
            gridline.append(vector(x, y, -thickness))
            x = x + dx
        y = y + dx
    global ground
    ground = box(pos=vector(0, -ymax, -thickness), size=vector(2 * xmax + 2 * thickness, 2 * thickness, 2 * thickness),
                 color=color.green)
    return


def marker(x, y, mass, col):
    sleep(0.1)
    scale_factor = 0.1
    a = sphere(pos=vector(x, y, 0), radius=0.3,
               color=col, make_trail=True,
               trail_type="points",
               interval=4,
               initial_pos=vector(x, y, 0),
               distance=0, mass=mass,
               weight=vector(0, 0, 0), drag=vector(0, 0, 0))
    attach_arrow(a, "weight", scale=scale_factor, shaftwidth=0.1, color=color.green)
    attach_arrow(a, "drag", scale=scale_factor, shaftwidth=0.1, color=color.green)

    return a


def accelerate(name, dvx, dvy):
    global time_step
    f = force(name)
    dvx = f.x / name.mass * time_step
    dvy = f.y / name.mass * time_step
    name.vx = name.vx + dvx
    name.vy = name.vy + dvy
    return


def move(name, dx, dy):
    sleep(0.005)
    name.pos = name.pos + vector(dx, dy, 0)
    name.distance = name.distance + sqrt(dx ** 2 + dy ** 2)
    return


def distance(name):
    return name.distance


def displacement(name):
    dx = name.pos.x - name.initial_pos.x
    dy = name.pos.y - name.initial_pos.y
    return sqrt(dx ** 2 + dy ** 2)