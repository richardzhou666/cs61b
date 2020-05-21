import java.util.Arrays;

public class NBody {
    public static double readRadius(String name) {
        In in = new In(name);
        in.readInt();
        return in.readDouble();
    }

    public static Body[] readBodies(String name) {
        In in = new In(name);
        int n = in.readInt(); /* Total number of bodies */
        int j = 0; /* Initialize*/
        in.readDouble(); /* Skip radius */
        Body[] result = new Body[n];
        while (j < n ) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            result[j] = new Body(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
            j = j+1;
        }
        return result;
    }

    public static void main(String[] args) {
        In in = new In();
        double T = Double.parseDouble(in.readString());
        double dt = Double.parseDouble(in.readString());
        String filename = in.readString();
        Body[] bodies = readBodies(filename);
        double radius = readRadius(filename);
        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-radius, radius);
        /**StdDraw.setScale(-radius, radius);
        StdDraw.picture(0,0,"images/starfield.jpg");
        for (Body body:bodies) {
            body.draw();
        } */
        double time = 0;
        while (time <= T) {
            double[] xForces = new double[bodies.length];
            double[] yForces = new double[bodies.length];
            for (int i=0;i < bodies.length; i++) {
                xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
                yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
                bodies[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.picture(0,0,"images/starfield.jpg");
            for (Body body:bodies) {
                body.draw();
            }
            StdDraw.show();
            StdDraw.pause(20);
            time = time + dt;
        }
        StdOut.printf("%d\n", bodies.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < bodies.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
                    bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);
        }
    }
}


